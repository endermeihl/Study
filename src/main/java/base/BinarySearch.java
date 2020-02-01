package base;

public class BinarySearch extends BaseDemo {
    public void search(int[] b, int value) {
        logger.debug(String.valueOf(binarySearch(b, 0, b.length-1, value)));
    }

    private boolean binarySearch(int[] b, int left, int right, int value) {
        if(left>right) return false;
        int middle = (left + right) / 2;
        if(b[middle]==value){
            return true;
        }
        if (b[middle] > value) {
            return binarySearch(b, left, middle-1, value);
        }
        return binarySearch(b, middle+1, right, value);
    }

    public static void main(String[] args){
        int[] b=new int[]{1,2,3,4,5,6,7,8};
        BinarySearch binarySearch=new BinarySearch();
        binarySearch.search(b,1);
    }
}
