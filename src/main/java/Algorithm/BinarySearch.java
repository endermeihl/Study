package Algorithm;

public class BinarySearch {
    private int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    private int binarySearch(int[] a, int b) {
        int left = 0;//记录起始位
        int right = a.length - 1;//记录终点位
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;//中间
            if (a[middle] > b) {
                right = middle - 1;//判断到中间位比值大终点前移
            } else if (a[middle] < b) {
                left = middle + 1;//判断到中间位比值小起点后移
            } else {
                return middle;
            }
        }
        return 99999;
    }

    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();

        System.out.println(b.binarySearch(b.a, 6));
        System.out.println(b.binarySearch(b.a, 5));
    }
}
