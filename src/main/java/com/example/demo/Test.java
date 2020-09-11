package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        Stream.iterate(0, i-> i+1).limit(20).forEach(i->list.add(i));
//        List list1 = new ArrayList<>();
//        list.parallelStream().forEach(i -> list1.add(i));
//        System.out.println(list1);
//        List list2 = list.parallelStream().map(i-> i+1).collect(Collectors.toList());
//        System.out.println(list2);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
//            ThreadLocalRandom.current().nextInt(1000);
            Math.random();
        }
        System.out.println("耗时="+(System.currentTimeMillis() - start));

    }
}
