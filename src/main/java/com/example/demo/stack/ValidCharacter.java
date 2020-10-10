package com.example.demo.stack;

import java.util.Stack;

public class ValidCharacter {

    public static void main(String[] args) {
        String str = "(111)";
        System.out.println(valid(str));
    }

    private static Boolean valid(String str) {
        if(str == null || str.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            if(c == ')'){
                if(stack.isEmpty() || stack.pop() != '('){
                    return false;
                }
            }
            if(c == '}'){
                if(stack.isEmpty() || stack.pop() != '{'){
                    return false;
                }
            }
            if(c == ']'){
                if(stack.isEmpty() || stack.pop() != '['){
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }
}
