package com.example.demo.leecode.offer;

import java.util.LinkedList;
import java.util.List;

public class Str {
    public static void main(String[] args) {
        String s1 = "abcb";
//        System.out.println(isUnique(s1));
        String s2 = "abcb";
        System.out.println(CheckPermutation(s1, s2));
    }

    public static boolean isUnique(String astr) {
        int count = 0;
        char[] astrChar = astr.toCharArray();
        int len = astrChar.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                count++;
                System.out.println(count);
                if (astrChar[i] == astrChar[j]) {
                    return false;
                }
            }
        }

        return true;
    }


    /**
     * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
     * 输入: s1 = "abc", s2 = "bca" 输出: true
     * 输入: s1 = "abc", s2 = "bad" 输出: false
     *
     * @param s1
     * @param s2
     * @return
     */
//    public static boolean CheckPermutation(String s1, String s2) {
//        if (s1.length() != s2.length()) {
//            return false;
//        }
//        List list = new LinkedList<String>();
//
//        for (char c: s2.toCharArray()) {
//            list.add(c);
//        }
//        char[] chars = s1.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            int index = list.indexOf(chars[i]);
//            if (index != -1) {
//                list.remove(index);
//            } else {
//                return false;
//            }
//        }
//        return list.size() == 0;
//    }

    public static boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int[] array = new int[128]; // 根据ASCII码运用桶计法
        for (int i = 0; i < s1.length(); i++) {
            array[s1.charAt(i)]++;  // 统计原串中每种字符的数量
            array[s2.charAt(i)]--;  // 重排串用掉了字符
        }

        for (int x : array) { // 验证数组中所有元素是否为0
            if (x != 0) {
                return false;
            }
        }
        return true;
    }

}
