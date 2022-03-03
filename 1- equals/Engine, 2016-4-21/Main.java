package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Engine a = new Engine(1200, 69);
        Engine b = new Engine(1200, 75);
        Engine c = new Engine(1400, 75);
        System.out.println(a);
        System.out.println(a.equals(b));

        Engine aVol = a.byVolume();
        Engine bVol = b.byVolume();
        System.out.println(aVol);
        System.out.println(aVol.equals(bVol));
        System.out.println(a==aVol);

        Engine bPow = b.byPower();
        Engine cPow = c.byPower();
        System.out.println(bPow);
        System.out.println(bPow.equals(cPow));
    }
}
