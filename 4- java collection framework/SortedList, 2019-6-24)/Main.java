package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SortedList<Integer> list = new SortedList<>();
        list .add(100); list .add(50); list .add(25); list .add(50);
        for (Integer n: list )
            System.out.println(n);
    }
}
