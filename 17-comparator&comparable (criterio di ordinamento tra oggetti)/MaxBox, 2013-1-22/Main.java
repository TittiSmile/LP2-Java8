package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MaxBox<String> bb1 = new MaxBox<>();
        MaxBox<String> bb2 = new MaxBox<String>(
                new Comparator<String>() {
                    public int compare(String a, String b) {
                        return a.length() - b.length();
                    }
                });
        bb1.insert ("dodici");
        bb1.insert ("sette");
        bb2.insert ("dodici");
        bb2.insert ("sette");
        System.out.println(bb1.getMax());
        System.out.println(bb2.getMax());

    }
}
