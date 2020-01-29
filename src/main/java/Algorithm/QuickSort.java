package Algorithm;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort {
    private List<Integer> quickSort(List<Integer> a) {
        if (a.size() < 2) {
            return a;
        } else {
            int temp = a.get(0);
            List<Integer> less = new ArrayList<>();
            List<Integer> high = new ArrayList<>();
            for (int i : a.subList(1, a.size())) {
                if (i <= temp) {
                    less.add(i);
                } else {
                    high.add(i);
                }
            }
            List<Integer> result = new ArrayList<>(quickSort(less));
            result.add(temp);
            result.addAll(quickSort(high));
            return result;
        }
    }

    private void quickSort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (array[j] >= base && i < j) {
                j--;
            }

            // 再从左往右边找，直到找到比base值大的数
            while (array[i] <= base && i < j) {
                i++;
            }

            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        quickSort(array, left, i - 1);
        quickSort(array, i + 1, right);

    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        Integer[] a = {3, 6, 1, 2, 4, 5, 7, 9, 8, 0};
        int[] b = {3, 6, 1, 2, 4, 5, 7, 9, 8, 0};
        quickSort.quickSort(b, 0, b.length - 1);
        System.out.println(Arrays.toString(b));
        //List<Integer> list = Arrays.asList(a);
        //System.out.println(Arrays.toString(quickSort.quickSort(list).toArray()));
    }
}
