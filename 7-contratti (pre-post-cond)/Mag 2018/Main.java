package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        LinkedList<Integer> l1 = new LinkedList<Integer>(); //se le dichiaro come List NON vengono accettate da merge. devono essere per forza LL
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        LinkedList<Integer> l3 = new LinkedList<Integer>();
        myClass m = new myClass();
        l1.add(1);l1.add(2);l1.add(3);
        l2.add(4);l2.add(5);l2.add(6);
        l3=m.merge(l1,l2);
        System.out.println(l3);



    }
}
