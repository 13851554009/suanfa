package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Rang {

    private static int mc = 1000;
    private static List<List<Integer>> all = new ArrayList<>();

    static {
        for (int i = 0; i < 10000; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < 1000; j++) {
                list.add(ThreadLocalRandom.current().nextInt(1000000));
            }
            list = list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            all.add(list);
        }
    }

    private static List<Integer> qq_1(){
        List<Integer> theLast = new ArrayList<>();
        for (List<Integer> list: all) {
            theLast.addAll(list);
        }
        theLast = theLast.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).subList(0, mc);
        System.out.println(theLast);
//
//
//        for (int i = 0; i < mc; i++) {
//            if(theLast_1.get(i).intValue() != theLast.get(i).intValue()){
//                System.out.println("第"+i + "个不同, "+theLast.get(i).intValue() +" : "+theLast_1.get(i).intValue());
//                return i;
//            }
//        }
        return theLast;
    }

    private static List<Integer> qq_2() {
        AtomicInteger size = new AtomicInteger();
        List<List<Integer>> then = new ArrayList<>();
        List<Integer> middleList = all.stream().filter(l -> l.size() > 0).map(l -> l.get(l.size() / 2)).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        Integer middle = middleList.get(middleList.size() / 2);
        then = all.stream().map(l -> l.stream().filter(i -> i >= middle).collect(Collectors.toList())).collect(Collectors.toList());
        then.forEach(l -> size.addAndGet(l.size()));

        while (size.get() > mc*2) {
            size.set(0);
            List<Integer> middleList_then = then.stream().filter(l -> l.size() > 0).map(l -> l.get(l.size() / 2)).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            Integer middle_then = middleList_then.get(middleList_then.size() / 2);
            then = then.stream().map(l -> l.stream().filter(i -> i >= middle_then).collect(Collectors.toList())).collect(Collectors.toList());
            then.forEach(l -> size.addAndGet(l.size()));
            System.out.println(size.get());
        }

        List<Integer> theLast_1 = new ArrayList<>();
        for (List<Integer> list: all) {
            theLast_1.addAll(list);
        }
        theLast_1 = theLast_1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).subList(0, mc);
        return theLast_1;
    }

    private static List<Integer> qq_3() {
        AtomicInteger size = new AtomicInteger();
        List<Integer> middleList_then;
        while (true) {
            size.set(0);
            middleList_then = all.stream().filter(l -> l.size() > 0).map(l -> l.get(l.size() / 2)).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            int middle_then = middleList_then.get(middleList_then.size() / 2);
            all = all.stream().map(l -> l.stream().filter(i -> i >= middle_then).collect(Collectors.toList())).collect(Collectors.toList());
            all.forEach(l -> size.addAndGet(l.size()));
            System.out.println(size.get());
//            System.gc();
            if(size.get() <= mc*3){
                break;
            }
        }

        List<Integer> theLast_1 = new ArrayList<>();
        for (List<Integer> list: all) {
            theLast_1.addAll(list);
        }
        theLast_1 = theLast_1.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).subList(0, mc);
        return theLast_1;
    }


    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1; i++) {
            System.out.println(qq_1());
//            System.out.println(qq_2());
//            System.out.println(qq_3());
        }
        System.out.println("耗时="+(System.currentTimeMillis() - start));

    }

}
