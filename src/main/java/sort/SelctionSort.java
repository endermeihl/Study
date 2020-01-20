package sort;

public class SelctionSort {
    public void selctionSort(int[] ins){
        for(int i=0;i<ins.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<ins.length;j++){
                if(ins[j]<ins[minIndex]){
                    minIndex=j;
                }
            }
            int temp=ins[i];
            ins[i]=ins[minIndex];
            ins[minIndex]=temp;
        }
        System.out.println("end!");
    }

    public static void main(String[] args){
        SelctionSort selctionSort=new SelctionSort();
        int[] ints=new int[]{4,3,2,1};
        selctionSort.selctionSort(ints);
    }
}
