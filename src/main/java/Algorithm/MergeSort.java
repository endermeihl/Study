package Algorithm;

import java.util.Arrays;

public class MergeSort {
    public void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public void sort(int[] arr, int L, int R) {
        if (L == R) {
            return;
        }
        int mid = (L + R) / 2;
        sort(arr, L, mid);
        sort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public void merge(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R - L + 1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while (p1 <= mid && p2 < R) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 < R) {
            temp[i++] = arr[p2++];
        }
        System.arraycopy(temp, 0, arr, L, R - L + 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 6, 4, 5, 1, 2, 7, 9, 8};
        int[] num1 = new int[]{1,3,5,7,9};
        int[] num2 = new int[]{2,4,6,8,10};
        int[] temp=new int[10];
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(arr);
        mergeSort.merge(num1,num2,temp);
        System.out.println(Arrays.toString(temp));
    }

    private void merge(int[] nums1,int[] nums2,int[] temp){
        int leftLen=nums1.length;
        int rightLen=nums2.length;
        int l=0;
        int r=0;
        int i=0;
        while(l<leftLen && r<rightLen){
            temp[i++]= nums1[l]<nums2[r] ? nums1[l++]:nums2[r++];
        }
        while(l<leftLen){
            temp[i++]=nums1[l++];
        }
        while(r<rightLen){
            temp[i++]=nums2[r++];
        }
    }
}
