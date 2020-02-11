package leetCode;


public class BulbSwitch {
    public int bulbSwitch(int n) {
        boolean[][] dp=new boolean[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(j%i==0){
                    dp[i][j]=!dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int res=0;
        for(int j=1;j<=n;j++){
            if(dp[n][j]){
                res++;
            }
        }
        return res;
    }
    public static void main(String[] args){
        BulbSwitch bulbSwitch=new BulbSwitch();
        bulbSwitch.bulbSwitch(2);
    }
}
