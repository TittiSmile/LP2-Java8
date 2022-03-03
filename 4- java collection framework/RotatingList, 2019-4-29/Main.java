package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        RotatingList<Integer> l = new RotatingList<>();
        l .add(1); l .add(2); l .add(3);
        //System.out.println( l ) ;

        RotatingList<Integer> l2 = new RotatingList<>();
        l2 .add(1); l2 .add(2); l2 .add(1);
        RotatingList<Integer> l3 = new RotatingList<>();
        l3 .add(2); l3 .add(1); l3 .add(2);l3 .add(2);
        System.out.println( l2.equals(l3) ) ;

        //System.out.println(l3.checkContains(l2));
    }
}
