package com.example.demo.sort;

public class Sort {

    /**
     * insert(插入排序) 比 select（选择排序） 快， select 比 bubble（冒泡排序） 快
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = new int[100000000];
//
//        /*冒泡排序*/
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = (int) (Math.random() * 10000);
//        }
//        long bubbleSortStart = System.currentTimeMillis();
//        bubbleSort(nums);
//        System.out.println("bubble is done , time = " + (System.currentTimeMillis() - bubbleSortStart));
//
//        /*选择排序*/
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = (int) (Math.random() * 10000);
//        }
//        long selectSortStart = System.currentTimeMillis();
//        selectSort(nums);
//        System.out.println("select is done , time = " + (System.currentTimeMillis() - selectSortStart));
//
//        /*插入排序*/
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = (int) (Math.random() * 10000);
//        }
//        long insertSortStart = System.currentTimeMillis();
//        insertSort(nums);
//        System.out.println("insert is done , time = " + (System.currentTimeMillis() - insertSortStart));

        /*快速排序*/
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 10000);
        }
        long quickSortStart = System.currentTimeMillis();
        quickSort(nums);
        System.out.println("quick is done , time = " + (System.currentTimeMillis() - quickSortStart));

        /*归并排序*/
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 10000);
        }
        long mergeSortStart = System.currentTimeMillis();
        mergeSort(nums);
        System.out.println("merge is done , time = " + (System.currentTimeMillis() - mergeSortStart));

//        for (int i = 0; i < nums.length; i++) {
//            System.out.println(nums[i]);
//        }
    }

    /**
     * 冒泡排序
     * 两个一组，依次对比
     * 对比nums.length轮
     *
     * @param nums
     */
    private static void bubbleSort(int[] nums) {
        int m;
        for (int i = 0; i < nums.length; i++) {
            /* 前后两个值，依次对比，调换位置 */
            for (int j = 0; j < nums.length - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    m = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = m;
                }
            }
        }
    }

    /**
     * 选择排序
     * 找出最小值，与当前值交换
     *
     * @param nums
     */
    private static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int min = i;
            /* 遍历找出最小值 */
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            /* 当前值与最小值兑换 */
            if (i != min) {
                int temp = nums[min];
                nums[min] = nums[i];
                nums[i] = temp;
            }
        }
    }


    /**
     * 插入排序
     * 依次与前一个数对比，如果小于，则前一个数后移一位，当前数继续向前对比，直到大于前一个数，插入
     *
     * @param nums
     */
    private static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            int current = nums[j];
            /* 当前值（current）依次与前面的值（nums[j - 1]）对比，
            如果小于，则前面的值后移一位（nums[j] = nums[j - 1]） */
            while (j > 0 && current < nums[j - 1]) {
                nums[j] = nums[j - 1];
                j--;
            }
            /* 当前值（current）对比到了第一位 或者 遇到比自己小的值，则在位置j处 插入*/
            nums[j] = current;
        }
    }

    /**
     * 快速排序
     * 第一个数定为比较的数，正向找比对比数大的数，反向找比对比数小的数，调换位置。
     * 正向、反向相遇则分组，各自重复快速排序
     *
     * @param nums
     */
    private static void quickSort(int[] nums) {
        quickSortNext(nums, 0, nums.length - 1);
    }

    private static void quickSortNext(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int p = nums[start]; // 将第一个数（nums[start]）作为对比数
        int left = start;
        int right = end;
        while (left <= right) {
            while (left <= right && nums[left] < p) {   // 从左往右，寻找比 p 大的数（nums[left]）
                left++;
            }
            while (left <= right && nums[right] > p) {  // 从右往左，寻找比 p 小的数（nums[right]）
                right--;
            }
            if (left <= right) {    // 将 nums[left] 、 nums[right] 交换
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                left++;
                right--;
            }
        }
        /* 一次循环之后，
        start 到 right之间是比 p 小的值，
        left 到 end 之间 是比 p 大的值*/
        quickSortNext(nums, start, right);  // 递归处理左半边数据
        quickSortNext(nums, left, end);     // 递归处理右半边数据
    }

    /**
     * 归并排序
     *
     * @param nums
     */
    private static void mergeSort(int[] nums) {
        int[] sort = new int[nums.length];  // 需要一个数组 记录数据
        mergeSortNext(nums, 0, nums.length - 1, sort);
    }

    private static void mergeSortNext(int[] nums, int start, int end, int[] sort) {
        if (start >= end) {
            return;
        }
        /* 通过递归，拆分成最小数组 */
        int mid = (start + end) / 2;
        mergeSortNext(nums, start, mid, sort);  // 左半部分
        mergeSortNext(nums, mid + 1, end, sort);    // 右半部分
        merge(nums, start, mid, end, sort); // 左、右 部分进行排序
    }

    private static void merge(int[] nums, int start, int mid, int end, int[] sort) {
        int left = start;
        int right = mid + 1;
        int index = start;
        /* 设置左右两个指针（left、right）,
        left 负责左半部分， right 负责右半部分
        nums[left]、nums[right] 依次对比 */
        while (left <= mid && right <= end) {
            if (nums[left] < nums[right]) {     // 将小的值 放入sort数组中，指针后移一位
                sort[index++] = nums[left++];
            } else {
                sort[index++] = nums[right++];
            }
        }
        while (left <= mid) {   // 考虑 right 走完，但 left 没有走完的情况
            sort[index++] = nums[left++];
        }
        while (right <= end) {   // 考虑 left 走完，但 right 没有走完的情况
            sort[index++] = nums[right++];
        }
        for (int i = start; i <= end; i++) {    // 将sort的值 写入 原数组
            nums[i] = sort[i];
        }
    }

}
