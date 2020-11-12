package com.example.demo.list;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.LinkedBlockingDeque;

public class Reverse {
    public static void main(String[] args) {
//        Node node5 = new Node(null, 5);
//        Node node4 = new Node(node5, 4);
//        Node node3 = new Node(node4, 3);
//        Node node2 = new Node(node3, 2);
//        Node node1 = new Node(node2, 1);
//        Node node0 = new Node(node1, 0);
//        Node head = node0;
//        for (int i = 0; i < 5; i++) {
//            head = head.getNext();
//            System.out.println(head.getValue());
//        }
//        String s ="";
////        Node reverse = reverse(node1);
//
//        Node reverseMiddle = reverseMiddle(node1, 2, 4);
//        System.out.println(reverseMiddle);

//        qq();

//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//        containsDuplicate(new int[]{1, 2, 3, 4});

        rotate(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
    }

    /**
     * input: 1->2->3->4->5
     * output: 5->4->3->2->1
     *
     * @param head
     * @return
     */
    public static Node reverse(Node head) {   // 入参一个节点
        if (head == null) {
            return null;
        }
        Node pre = head;       // 定义为头节点
        Node current = head.getNext();  // 下一个节点定义为当前节点
        pre.setNext(null);
        while (current != null) {
            Node next = current.getNext();  // 记录当前节点的 下一个节点
            current.setNext(pre);   // 当前节点的下一个节点指向 前一个节点
            pre = current;  // 当前节点作为前节点
            current = next; // 下一个节点作为当前节点
        }
        return pre;
    }

    /**
     * input: 1->2->3->4->5->null, m=2,n=4
     * output: 1->4->3->2->5->null
     *
     * @param head
     * @return
     */
    public static Node reverseMiddle_own(Node head, int m, int n) {
        Node nodem = getNode(head, m);
        Node noden = getNode(head, n);

        Node nPre = getNode(head, n - 1);
        Node nNext = noden.getNext();

        Node mPre = getNode(head, m - 1);
        Node mNext = nodem.getNext();

        mPre.setNext(noden);
        noden.setNext(mNext);

        nPre.setNext(nodem);
        nodem.setNext(nNext);

        return head;
    }

    public static Node getNode(Node head, int i) {
        Node current = head;
        if (i == 1) {
            return current;
        } else {
            int count = 0;
            while (true) {
                if (count++ == i) {
                    return current.getNext();
                } else {
                    current = current.getNext();
                }
            }
        }
    }

    /**
     * input: 1->2->3->4->5->null, m=2,n=4
     * output: 1->4->3->2->5->null
     *
     * @param head
     * @return
     */
    public static Node reverseMiddle(Node head, int m, int n) {
        if (head == null) {
            return null;
        }

        Node dummy = new Node(); // 定义一个哨兵节点，放在head前面
        dummy.setNext(head);
        head = dummy;

        for (int i = 0; i < m - 1; i++) { // 遍历到 m 的前一个节点
            head = head.getNext();
        }
        Node mpre = head;   // 记录 m 前一个节点
        Node mNode = head.getNext();    // m节点
        Node mNext = mNode.getNext(); // 记录 m节点 下一个节点

        for (int i = m - 1; i < n - 1; i++) {   // 遍历到 n 的前一个节点
            head = head.getNext();
        }
        Node npre = head;   // 记录 n 的前一个节点
        Node nNode = head.getNext();    // n 节点
        Node nNext = nNode.getNext();   // 记录 n节点 下一个节点


        mpre.setNext(nNode);    // 设置m前节点的 下一个节点为  n节点

        nNode.setNext(mNext);   // 设置 n节点的下一个节点 为 原来m的下一个节点

        npre.setNext(mNode);    // 设置 n前节点的 下一个节点 为m节点

        mNode.setNext(nNext);   // 设置 m 节点的 下一个节点 为 原来n的下一个节点


        return dummy.getNext();
    }


    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (i != j && nums[i] > nums[j]) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) {
            return false;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            int[] one = matrix[i];
            if (one[0] > target) {
                return false;
            }
            for (int j = 0; j < one.length; j++) {
                if (one[j] == target) {
                    return true;
                }
                if (one[j] > target) {
                    break;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix_1(int[][] matrix, int target) {
        int n = matrix.length;
        if (n == 0) {
            return false;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return false;
        }
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            }
        }
        return false;
    }

    public static boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        char[] c = str.toCharArray();
        int length = c.length;
        int start = 0;
        int end = length - 1;
        while (start < end) {
            if (!isChar(c[start])) {
                start++;
                continue;
            }
            if (!isChar(c[end])) {
                end--;
                continue;
            }

            if (!equals(c[start], c[end])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static boolean isChar(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }

    public static boolean equals(char c1, char c2) {
        if (c1 == c2) {
            return true;
        }
        if (c1 >= 'A' && c1 <= 'Z' && c1 + 32 == c2) {
            return true;
        }
        if (c1 >= 'a' && c1 <= 'z' && c1 - 32 == c2) {
            return true;
        }
        return false;
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        char[] sc = s.toCharArray();
        int length = sc.length;
        String current = "";
        for (int i = 0; i <= length - 1; i++) {
            List list = new ArrayList();
            for (int j = 0; j < length - 1; j++) {
                int start = j;
                int end = j + i;
                int index = start;
                while (index <= end) {
                    current += sc[index];
                    index++;
                }
                if (isPalindrome(current)) {
                    list.add(current);
                }
            }
            if (list.size() != 0) {
                result.add(list);
            }
        }
        return result;
    }


    public int maxProduct(int[] nums) {
        int length = nums.length;
        int max = nums[0];
        for (int i = 0; i < length; i++) {
            int current = nums[i];
            if (current > max) {
                max = current;
            }
            for (int j = i + 1; j < length; j++) {
                current = current * nums[j];
                if (current > max) {
                    max = current;
                }
            }
        }
        return max;
    }

    public int islandPerimeter(int[][] grid) {
        int bc = 0;
        int high = grid.length;
        int length = grid[0].length;
        for (int i = 0; i < high; i++) {
            for (int j = 0; j < length; j++) {
                if (grid[i][j] == 1) {
                    bc += 4;
                    if (has(grid, high, length, i - 1, j)) {
                        bc--;
                    }
                    if (has(grid, high, length, i + 1, j)) {
                        bc--;
                    }
                    if (has(grid, high, length, i, j - 1)) {
                        bc--;
                    }
                    if (has(grid, high, length, i, j + 1)) {
                        bc--;
                    }
                }
            }
        }
        return bc;
    }

    public Boolean has(int[][] grid, int high, int length, int i, int j) {
        if (i < 0 || i >= high || j < 0 || j >= length) {
            return false;
        }
        return grid[i][j] == 1;
    }

    public static boolean containsDuplicate(int[] nums) {
        int[] count = new int[100];
        int[] count_1 = new int[100];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                count[nums[i]]++;
            } else {
                count_1[nums[i] * -1]++;
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 1 || count_1[i] > 1) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate_1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            set.add(nums[i]);
        }
        return set.size() != length;
    }

    public static boolean containsDuplicate_2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void rotate(int[] nums, int k) {
        Queue<Integer> queue = new ArrayDeque();
        int length = nums.length;
        for (int i = length - 1; i >= 0; i--) {
            queue.add(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            queue.add(queue.poll());
        }
        for (int i = length - 1; i >= 0; i--) {
            nums[i] = queue.poll();
        }
    }

    public static void rotate_1(int[] nums, int k) {
        Queue<Integer> queue = new LinkedBlockingDeque<>();
        int length = nums.length;
        int start = length - k % length;
        for (int i = start; i < length; i++) {
            queue.add(nums[i]);
        }
        for (int i = 0; i < start; i++) {
            queue.add(nums[i]);
        }
        for (int i = 0; i < length; i++) {
            nums[i] = queue.poll();
        }
    }

    public int[] intersection(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        List<Integer> result = new ArrayList();
        Set set1 = new HashSet();
        for (int i = 0; i < length1; i++) {
            set1.add(nums1[i]);
        }

        Set set2 = new HashSet();
        for (int i = 0; i < length2; i++) {
            set2.add(nums2[i]);
        }

        Iterator<Integer> iterator = set2.iterator();
        while (iterator.hasNext()) {
            int current = iterator.next();
            if (set1.contains(current)) {
                result.add(current);
            }
        }
        int[] r = new int[result.size()];
        for (int i = 0; i < r.length; i++) {
            r[i] = result.get(i);
        }
        return r;
    }

    public int[] intersection_1(int[] nums1, int[] nums2) {

        Set<Integer> result = new HashSet();
        Set<Integer> set1 = new HashSet();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set1.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }
        int[] r = new int[result.size()];

        int count = 0;
        for (Integer i : result) {
            r[count++] = i;
        }
        return r;
    }

    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3 || A.length > 10000) {
            return false;
        }
        int change = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] >= A[i + 1]) {
                change = i;
                break;
            }
        }
        if (change == 0 || change == A.length - 1) {
            return false;
        }
        for (int i = change; i < A.length - 1; i++) {
            if (A[i] <= A[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
