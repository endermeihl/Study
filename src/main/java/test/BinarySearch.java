package test;

import base.BaseDemo;

public class BinarySearch extends BaseDemo {

    public int binarySearch(int[] nums, int left, int right, int i) {
        int middle = (left + right) / 2;
        if (nums[middle] == i) return middle;
        else if (nums[middle] < i) return binarySearch(nums, middle + 1, right, i);
        else return binarySearch(nums, left, middle - 1, i);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.log(binarySearch.binarySearch(nums, 0, nums.length, 5));
    }
}
