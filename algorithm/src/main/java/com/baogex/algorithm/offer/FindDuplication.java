package com.baogex.algorithm.offer;

/**
 * <p>
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * <p>
 * Input:
 * {2, 3, 1, 0, 2, 5}
 * <p>
 * Output:
 * 2
 * </p>
 *
 * @author : zuomin.yu
 * @date : 2020-08-24
 */
public class FindDuplication {

    public static boolean duplicate(int[] nums, int length, int[] duplication) {
        if (nums == null || nums.length < 1) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = i;
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,2,1,3};
        System.out.println(duplicate(nums, 5, new int[]{1}));
    }
}
