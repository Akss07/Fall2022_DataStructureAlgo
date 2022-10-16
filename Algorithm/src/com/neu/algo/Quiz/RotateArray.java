package com.neu.algo.Quiz;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        swap(nums, 0, n-1);
        swap(nums, 0, k-1);
        swap(nums, k, n-1);
    }

    public void swap(int[] nums, int start, int end){
        while(start <= end){
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            --end;
        }
    }

}