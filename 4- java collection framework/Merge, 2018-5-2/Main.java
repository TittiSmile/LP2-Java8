package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        myClass m = new myClass();
        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();
        LinkedList<Integer> l3 = new LinkedList<>();
        l1.add(1);l1.add(3);l1.add(5);
        l2.add(2);l2.add(4);l2.add(6);
        l3=m.merge(l1,l2);
        System.out.println(l3);
    }
}
