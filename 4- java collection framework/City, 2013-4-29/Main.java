package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        City n = new City("Napoli");
        City r = new City("Roma");
        City s = new City("Salerno");
        City p = new City("Parigi");
        n.connect(s);
        n.connect(r);

        Collection<City> r_conn = r.getConnections();
        System.out.println(r_conn);

        System.out.println(r.isConnected(s));
        System.out.println(r.isConnected(p));

    }
}
