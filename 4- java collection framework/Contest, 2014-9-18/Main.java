package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Contest<String> c = new Contest<String>();
        String r = "Red", b = "Blue", g = "Green", y="Yellow";
        c.add(r);c.add(b);c.add(g);
        c.vote(r);c.vote(r);
        System.out.println(c.winner());
    }
}
