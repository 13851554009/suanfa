package com.example.demo.stack;

import java.util.Stack;

/**
 * 求数组的子数组中，最小值*数组sum 的最大值
 */
public class MaxValue {
    public static void main(String[] args) {
        int[] nums = new int[]{5,2,3,4,1};
        int[] sum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i-1];
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                int index = stack.pop();
                if (stack.isEmpty()) {
                    max = Math.max(max, nums[index] * (sum[i] - sum[0]));
                } else {
                    max = Math.max(max, nums[index] * (sum[i] - sum[index]));
                }
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            if (stack.isEmpty()) {
                max = Math.max(max, nums[index] * (sum[nums.length] - sum[0]));
            } else {
                max = Math.max(max, nums[index] * (sum[nums.length] - sum[index]));
            }
        }

        System.out.println(max);
    }
}
