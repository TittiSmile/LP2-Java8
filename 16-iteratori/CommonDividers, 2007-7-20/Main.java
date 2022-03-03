package com.company;
import java.util.*;


public class Main {

    public static void main(String[] args) {
	// write your code here
        for (Integer n: new CommonDividers(12, 60))
            System.out.print(n + " ");

        System.out.print("\n\n");


        for (Integer n: new Common(12, 60))
            System.out.print(n + " ");


    }
}
