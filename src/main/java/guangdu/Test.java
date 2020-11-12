package guangdu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class Test {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int [] nums1 = new int[]{2,4,9};
        int [] nums2 = new int[]{5,6,4,9};
        ListNode listNode1 = null;
        for (int i = 0; i < nums1.length; i++) {
            listNode1 = solution.ss(listNode1, nums1[i]);
        }
        ListNode listNode2 = null;
        for (int i = 0; i < nums2.length; i++) {
            listNode2 = solution.ss(listNode2, nums2[i]);
        }
        ListNode listNode = solution.addTwoNumbers(listNode1, listNode2);
    }
}
