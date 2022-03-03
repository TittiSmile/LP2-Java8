package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Relation<Integer,String> r = new Relation<Integer,String>();
        r .put(0, "a"); r .put(0, "b"); r .put(0, "c");
        r .put(1, "b"); r .put(2, "c");
        r .remove(0, "a");
    }
}
