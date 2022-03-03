package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Triangle a = new Triangle(3,4,5);
        Triangle b = new Triangle(4,5,3);
        Triangle c = new Triangle(8,6,10);
        Triangle d = new Triangle(8,8,8);


        System.out.println(a.equals(b));

        Comparator<Triangle> pc = Triangle.perimeterComparator();
        System.out.println(pc.compare(b, c));

    }
}
