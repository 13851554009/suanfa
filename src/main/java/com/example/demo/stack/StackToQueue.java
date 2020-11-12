package com.example.demo.stack;

import java.util.Stack;

public class StackToQueue {

    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stackToQueue(stack1, stack2);
    }

    /**
     * 通过两个栈 实现队列
     * @param stack1
     * @param stack2
     */
    private static void stackToQueue(Stack<Integer> stack1, Stack<Integer> stack2) {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        while (!stack2.isEmpty()) {
            System.out.println(stack2.pop());
        }
    }
}
