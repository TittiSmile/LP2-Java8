package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Cellphone a = new Cellphone("TIMMY", "3341234");
        Cellphone b = new Cellphone("Megafon", "3355678");
        Cellphone c = new Cellphone("Odissey", "3384343");

        Cellphone.setCost("TIMMY", "TIMMY", 0.05);
        Cellphone.setCost("TIMMY", "Megafon", 0.15);
        Cellphone.setCost("Megafon", "TIMMY", 0.25);


        //gli output non sono corretti :D
        System.out.println(a.getCost(b, 10));
        System.out.println(b.getCost(a, 8)) ;
        System.out.println(a.getCost(c, 10));
    }
}
