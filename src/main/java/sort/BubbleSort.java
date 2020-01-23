package sort;

public class BubbleSort {
    public void bubbleSort(int[] args){
        int temp;
        for(int i=0;i<args.length-1;i++){
            for(int j=args.length-1;j>i;j--){
                if(args[i]>args[j]){
                    temp=args[i];
                    args[i]=args[j];
                    args[j]=temp;
                }
            }
        }
        System.out.println("end!");
    }

    public static void main(String[] args){
        BubbleSort bubbleSort=new BubbleSort();
        int[] ints=new int[]{4,3,2,1};
        bubbleSort.bubbleSort(ints);
    }
}
