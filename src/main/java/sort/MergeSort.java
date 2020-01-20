package sort;

public class MergeSort {
    public void mergeSort(int[] ins,int left,int right){
        int middle=(left+right)/2;
        mergeSort(ins,middle+1,right);
        mergeSort(ins,left,middle);
        merge(ins,left,middle,right);
    }
    public void merge(int[] ins,int left,int middle,int right){
        int[] tmpArray=new int[ins.length];

    }
}
