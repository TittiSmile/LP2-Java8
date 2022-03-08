package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MultiSet<Integer> s1 = new MultiSet<Integer>();
        MultiSet<Integer> s2 = new MultiSet<Integer>();
        s1.add(5); s1.add(7); s1.add(5);
        s2.add(5); s2.add(5); s2.add(7);

        for (Integer n: s1)
            System.out.println(n);
        System.out.println(s1.equals(s2));

    }

}
