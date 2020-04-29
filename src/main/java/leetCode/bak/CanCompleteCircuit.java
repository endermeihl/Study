package leetCode.bak;

public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gases;
        int len=gas.length;
        int i=0;
        for(;i<len;i++){
            int j=i;
            gases=0;
            int k;
            int count=0;
            do{
                gases+=gas[j];
                k=(j+1)%len;
                if(gases>=cost[k]){
                    gases-=cost[k];
                    j=k;
                    count++;
                }else{
                    break;
                }
            }while(j!=i);
            if(count==len) return j+1;
        }
        return -1;
    }

    public static void main(String[] args){
        int[] gas=new int[]{1,2,3,4,5};
        int[] cost=new int[]{3,4,5,1,2};
        CanCompleteCircuit c=new CanCompleteCircuit();
        c.canCompleteCircuit(gas,cost);
    }
}
