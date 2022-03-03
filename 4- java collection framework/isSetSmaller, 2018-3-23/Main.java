package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        myClass m = new myClass();
        Set<Integer>s1 = new HashSet<>();
        Set<Integer>s2 = new HashSet<>();
        setsComparator<Integer> comp = new setsComparator<>();
        s1.add(1);s1.add(4);s1.add(5);
        s2.add(55);s2.add(56);s2.add(255);
        System.out.println(m.isSmaller(s1,s2,comp));
    }
}
