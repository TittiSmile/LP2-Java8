package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MinMaxStorage<String> s = new MinMaxStorage<String>();
        s.add("uno");s.add("due");s.add("tre");
        System.out.println(s.getSetStorage()); //li stampa già in ordine
        System.out.println(s.getMin());
        System.out.println(s.getMax());

    }
}
