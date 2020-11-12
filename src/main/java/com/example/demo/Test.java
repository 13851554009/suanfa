package com.example.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        Stream.iterate(0, i-> i+1).limit(20).forEach(i->list.add(i));
//        List list1 = new ArrayList<>();
//        list.parallelStream().forEach(i -> list1.add(i));
//        System.out.println(list1);
//        List list2 = list.parallelStream().map(i-> i+1).collect(Collectors.toList());
//        System.out.println(list2);

//        long start = System.currentTimeMillis();
//        for (int i = 0; i < 100000000; i++) {
////            ThreadLocalRandom.current().nextInt(1000);
//            Math.random();
//        }
//        System.out.println("耗时=" + (System.currentTimeMillis() - start));

        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = new String[]{"hot", "dot", "dog", "lot", "log"};
        System.out.println(ladderLength(beginWord, endWord, Arrays.asList(wordList)));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = beginWord.length();
        if (length != endWord.length()) {
            return 0;
        }
        Stack stack = ladderLengthNext(beginWord, endWord, wordList, new Stack<>());
        int count = 0;
        while (!stack.isEmpty()) {
            stack.pop();
            count++;
        }
        return count;
    }

    public static Stack<String> ladderLengthNext(String beginWord, String endWord, List<String> wordList,
            Stack<String> stack) {
        if (beginWord.equals(endWord)) {
            return stack;
        }
        for (int i = 0; i < beginWord.length(); i++) {
            if (beginWord.charAt(i) != endWord.charAt(i)) {
                String newWord = getNewWord(beginWord, i, endWord.charAt(i));
                if (wordList.contains(newWord)) {
                    stack.push(newWord);
                    Stack<String> s = ladderLengthNext(newWord, endWord, wordList, stack);
                    if (s.contains(newWord)) {
                        return s;
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            stack.pop();
        }
        if (!stack.isEmpty()) {
            return ladderLengthNext(stack.peek(), endWord, wordList, stack);
        }
        return stack;
    }

    private static String getNewWord(String beginWord, int i, char charAt) {
        return beginWord.substring(0, i) + charAt + beginWord.substring(i + 1);
    }


}
