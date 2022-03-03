package com.company;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
	// write your code here
       /* BoundedMap<String,String> m = new BoundedMap<String,String>(2);
        m.put("NA", "Napoli");
        m.put("SA", "Salerno");
        m.put("SaA", "Salerssno");
        System.out.println(m.get("NA"));
        System.out.println(m.get("SA"));
        System.out.println(m.getMapCountOccurrences());
        */
        BoundedMap<String,String> m = new BoundedMap<String,String>(2);
        m.put("NA", "Napoli");
        m.put("SA", "Salerno");
        System.out.println(m.get("NA"));
        m.put("AV", "Avellino");
        System.out.println(m.get("SA"));
    }
}
