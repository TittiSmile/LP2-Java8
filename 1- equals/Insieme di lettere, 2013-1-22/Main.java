package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
        MyString a = new MyString("freddo");
        MyString b = new MyString("defro");
        MyString c = new MyString("caldo");

        System.out.println(a+ " " + b + " " +c);

        System.out.println(a.equals(b));
        System.out.println(b.equals(c));
        System.out.println(a.hashCode()==b.hashCode());

        /*List<Character> lc = new ArrayList<>();
        lc=a.asChar("freddo");
        System.out.println(lc);
        boolean x = a.sameLetters(c);
        System.out.println(x);*/
    }
}
