package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        /*Accumulator2<Integer> acc1 = new Accumulator2<>(0);
        acc1.add(10);
        acc1.add(42);
        acc1.add(-5);
        acc1.add(10);
        for (Integer n: acc1.positives()) System.out.println(n);
        for (Integer n: acc1.negatives()) System.out.println(n);

        Accumulator2<Double> acc2 = new Accumulator2<Double>(0.0);
        acc2.add(-10.0);
        acc2.add(42.0);
        System.out.println(acc2.sum());*/


        Accumulator<Integer> acc1 = new Accumulator<>();
        acc1.add(10);
        acc1.add(42);
        acc1.add(-5);
        acc1.add(10);
        for (Integer n: acc1. positives ()) System.out.println(n);
        for (Integer n: acc1.negatives()) System.out.println(n);
        Accumulator<Double> acc2 = new Accumulator<>();
        acc2.add(-10.0);
        acc2.add(42.0);
        System.out.println(acc2.sum());


    }
}
