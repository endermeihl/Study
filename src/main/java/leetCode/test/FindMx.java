package leetCode.test;

public class FindMx {
    int m;
    int n;
    public boolean find(int target, int [][] array) {
        m=array.length;
        if(m==0){
            return false;
        }
        n=array[0].length;
        if(n==0){
            return false;
        }
        int len=m*n;
        return helper(array,0,len-1,target);
    }

    private boolean helper(int[][] array,int l,int r,int target){
        if(l>r) return false;
        int mid=(l+r)/2;
        int temp=array[mid/n][mid%n];
        if(temp==target) return true;
        if(temp>target) return helper(array,l,mid,target);
        return helper(array,mid+1,r,target);
    }

    public static void main(String[] args){
        int[][] nums=new int[][]{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15}};
        FindMx findMx=new FindMx();
        System.out.println(findMx.find(16,nums));
    }
}
