package leetCode;

public class UniquePaths {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        if(obstacleGrid[0][0]!=0){
            obstacleGrid[0][0]=-1;
        }else{
            obstacleGrid[0][0]=1;
        }
        for(int i=1;i<n;i++){
            if(obstacleGrid[i][0]==1){
                obstacleGrid[i][0]=-1;
                continue;
            }
            if(obstacleGrid[i][0]==0 && obstacleGrid[i-1][0]!=-1){
                obstacleGrid[i][0]=1;
                continue;
            }
            if(obstacleGrid[i][0]==0 && obstacleGrid[i-1][0]==-1){
                obstacleGrid[i][0]=-1;
            }
        }
        for(int i=1;i<m;i++){
            if(obstacleGrid[0][i]==1){
                obstacleGrid[0][i]=-1;
                continue;
            }
            if(obstacleGrid[0][i]==0 && obstacleGrid[0][i-1]!=-1){
                obstacleGrid[0][i]=1;
                continue;
            }
            if(obstacleGrid[0][i]==0 && obstacleGrid[0][i-1]==-1){
                obstacleGrid[0][i]=-1;
            }
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(obstacleGrid[i][j]==1){
                    obstacleGrid[i][j]=-1;
                    continue;
                }
                if(obstacleGrid[i-1][j]==-1 && obstacleGrid[i][j-1]==-1){
                    obstacleGrid[i][j]=-1;
                    continue;

                }
                if(obstacleGrid[i-1][j]==-1 && obstacleGrid[i][j-1]!=-1){
                    obstacleGrid[i][j]=obstacleGrid[i][j-1];
                    continue;
                }
                if(obstacleGrid[i-1][j]!=-1 && obstacleGrid[i][j-1]==-1){
                    obstacleGrid[i][j]=obstacleGrid[i-1][j];
                    continue;
                }
                if(obstacleGrid[i-1][j]!=-1 && obstacleGrid[i][j-1]!=-1){
                    obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                }
            }
        }
        return obstacleGrid[n-1][m-1]>=0 ? obstacleGrid[n-1][m-1]:0;
    }

    public static void main(String[] args){
        UniquePaths uniquePaths=new UniquePaths();
        int[][] mx=new int[][]{{0,1,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        uniquePaths.uniquePathsWithObstacles(mx);
    }
}
