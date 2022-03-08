package com.company;


public class Main {

    public static void main(String[] args) {
        Fraction a = new Fraction(12,30);
        Fraction b = new ReducedFraction(12,30);
        Fraction c = new Fraction(1,4);
        Fraction d = c.times(a);
        System.out.println("Frazione a:   " + a);
        System.out.println("Frazione ridotta b:   " + b);
        System.out.println("Prodotto di frazioni:   " + d);
        System.out.println("Equals:   " + a.equals(b));
        System.out.println("Prodotto di frazioni:   " + c.times(b));

        

    }
}

