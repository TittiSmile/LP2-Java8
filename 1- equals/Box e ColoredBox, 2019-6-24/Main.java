package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Box b = new Box(10,4);
        Box b2 = new Box(10,4);
        System.out.println(b.equals(b2));

        ColoredBox c = new ColoredBox(2,3,"rosso");
        ColoredBox c2 = new ColoredBox(2,3,"rosso");
        System.out.println(c2.equals(c));

        System.out.println(b.hashCode() + " & " +b2.hashCode());
        System.out.println(c.hashCode() + " & " +c2.hashCode());

    }
}
