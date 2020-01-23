#!/usr/bin/env bash
# acter meihl
# 读取的version文件格式为 version|machineid|image_name
# 第一行是应用名称
# 启动中容器的名称规范是镜像名称-应用名称-容器编号-应用版本

log(){
    Date=$(date +%Y-%m-%d-%T)
    echo ${Date}-$1
}
IFS=\| latest=($(sed -n '3p' version.conf))
version=${latest[0]}
appname=$(sed -n '1p' version.conf) # 读取应用名称
gitulr=$(sed -n '2p' package.conf) 
gitdir=$(sed -n '3p' package.conf) 
project=/usr/local/docker/${appname} # 指定工作目录
log ${project}
info=${project}/logs/info.${appname}.${version}.log
error=${project}/logs/error.${appname}.${version}.log
if [[ ! -f ${project}/logs/info.fifo ]];then
    mkfifo ${project}/logs/info.fifo
else
    log "输入通道已经存在"
fi
if [[ ! -f ${project}/logs/error.fifo ]];then
    mkfifo ${project}/logs/error.fifo
else
    log "输入通道已经存在"
fi
cat $project/logs/info.fifo | tee -a $info &
cat $project/logs/error.fifo | tee -a $error &
echo "开始更新版本操作"
exec 1>> $project/logs/info.fifo
exec 2>> $project/logs/error.fifo
log "开始处理更新"
log "开始处理打包"
#从版本库拉取内容开始
log "拉取版本内容"
git clone -b feature-resetExamError ssh://$gitulr
cd $gitdir
log "编译并打包"
mvn package -Pproduct
cd docker
cp $appname.war $project
cd $project
#处理之前的版本内容开始
log "处理之前版本内容"
IFS=\| previous=($(sed -n '4p' version.conf)) #获取前一个版本所有信息
log "前一个版本所有信息"`declare -p previous|awk '{match($0,/\([^()]*\)/);print substr($0,RSTART+1,RLENGTH-2)}'`
previous_version=${previous[0]} # 读取前一个版本号
log "前一个版本号:"$previous_version
IFS=, previson_machineids=(${previous[1]}) # 读取前一个容器编号
log "前一个版本容器编号"`declare -p previson_machineids|awk '{match($0,/\([^()]*\)/);print substr($0,RSTART+1,RLENGTH-2)}'`
previous_image_name=${previous[2]} # 读取前一个版本所用镜像名称
log "前一个镜像名称:"$previous_image_name
for machineid in ${previson_machineids[@]}
do
    id=`echo $machineid|awk -F '-' '{print $1}'`
    previous_containerid=`docker ps|grep -i $previous_image_name-$appname-$id-$previous_version|awk '{print $1}'`
    if [ ! -n "$previous_containerid" ];then
    log $previous_image_name-$appname-$id-$previous_version" is null"
    log "continue"
    else
    log "停止容器:"$previous_image_name-$appname-$id-$previous_version"容器ID:"$previous_containerid
    docker stop $previous_containerid
    log "删除容器:"$previous_image_name-$appname-$id-$previous_version"容器ID:"$previous_containerid
    docker rm $previous_containerid
    fi
done
#处理要更新的版本内容
log "处理要更新版本内容"
IFS=\| latest=($(sed -n '3p' version.conf))  # 读取最新的版本号
log "要更新的版本所有信息"`declare -p latest|awk '{match($0,/\([^()]*\)/);print substr($0,RSTART+1,RLENGTH-2)}'`
latest_version=${latest[0]} # 读取最新版本号
log "当前版本号:"$latest_version
IFS=, latest_machineids=(${latest[1]}) # 读取当前版本容器编号
log "当前版本容器编号"`declare -p previson_machineids|awk '{match($0,/\([^()]*\)/);print substr($0,RSTART+1,RLENGTH-2)}'`
latest_image_name=${latest[2]} # 读取当前版本所用镜像名称
log "当前镜像名称:"$latest_image_name
docker build $project -t $latest_image_name:$latest_version
log "创建镜像: "$latest_image_name:$latest_version
for machineid in ${latest_machineids[@]}
do
    log $machineid
    id=`echo $machineid|awk -F '-' '{print $1}'`
    port=`echo $machineid|awk -F '-' '{print $2}'`
    if [ ! -d $project/logs/$appname$id ];then
        mkdir -p $project/logs/$appname$id
    else
    log "文件夹已经存在"
    fi
    docker run -d -p $port:8080 --name $latest_image_name-$appname-$id-$latest_version  -v $project/logs/$appname$id:/usr/local/tomcat/logs $latest_image_name:$latest_version
    log "启动容器:"$latest_image_name-$appname-$id-$latest_version
done
log "删除更新文件"
rm -rf $appname.war
rm -rf jrapi/
log "更新操作结束！"
exit 0
