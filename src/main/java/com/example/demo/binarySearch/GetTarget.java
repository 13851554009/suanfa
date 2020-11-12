package com.example.demo.binarySearch;

public class GetTarget {
    public static void main(String[] args) {
        int[] num = new int[]{4, 5, 6, 7, 8, 1, 2, 3};
        System.out.println(getTargetIndex(num, 8));
    }

    /**
     * 找出target的下标
     *
     * @param num    有序的数组 或者 旋转有序数组
     * @param target
     * @return
     */
    private static int getTargetIndex(int[] num, int target) {
        if (num == null || num.length == 0) {
            return -1;
        }
        int start = 0;
        int end = num.length - 1;
        if (num[start] < num[end]) { // 升序
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (num[mid] < target) {
                    start = mid;
                } else if (num[mid] == target) {
                    return mid;
                } else {
                    end = mid;
                }
            }
            if (num[start] == target) {
                return start;
            }
            if (num[end] == target) {
                return end;
            }
            return -1;
        } else {    // 旋转有序
            while (start + 1 < end) {
                int mid = start + (end - start) / 2;
                if (num[mid] == target) {
                    return mid;
                }
                if (num[mid] > num[start]) {
                    if (target > num[start] && target < num[mid]) {
                        end = mid;
                    } else {
                        start = mid;
                    }
                } else {
                    if (target > num[mid] && target < num[end]) {
                        start = mid;
                    } else {
                        end = mid;
                    }
                }
            }
            if (num[start] == target) {
                return start;
            }
            if (num[end] == target) {
                return end;
            }
            return -1;
        }

    }
}
