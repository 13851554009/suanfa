package com.example.demo.stack;

import lombok.val;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ValidCharacter {

    public static void main(String[] args) {
        String str = "(111)}";
        System.out.println(valid(str));
    }

    /**
     * 字符中的 括号 '(' ')' '{' '}' '[' ']' 必须是配对的
     *
     * @param str
     * @return
     */
    private static Boolean valid(String str) {
        if (str == null || str.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            if (c == ')') {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            }
            if (c == '}') {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            }
            if (c == ']') {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }


}
