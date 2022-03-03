package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Bijection<Integer,String> b = new Bijection<Integer,String>();
        b.addPair(12,"dodici");
        b.addPair(7,"sette");
        System.out.println(b.getValue(12));
        System.out.println(b.getKey("tredici")) ;
        b.addPair(8,"sette");
    }
}
