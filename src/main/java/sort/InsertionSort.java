package sort;

public class InsertionSort {
    public void insertionSort(int[] ints){
        for(int i=0;i<ints.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(ints[j]<ints[j-1]){
                    int temp=ints[j];
                    ints[j]=ints[j-1];
                    ints[j-1]=temp;
                }else {
                    break;
                }
            }
        }
        System.out.println("end!");
    }
    public static void main(String[] args){
        InsertionSort insertionSort=new InsertionSort();
        int[] ints=new int[]{6,5,4,3,2,1};
        insertionSort.insertionSort(ints);
    }


}
