package com.company;

/*l'esercizio si basa principalmente su equals... l'ìmplementazione la sto facendo per esercitarmi :D*/


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



        System.out.println("\n\n\n\n");
        /*Fraction a1 = new Fraction(10,5);
        Fraction b1 = new ReducedFraction(18,3);
        Fraction c1 = new Fraction(3,4);
        Fraction d1 = c1.times(a1);
        System.out.println("Frazione a:   " + a1);
        System.out.println("Frazione ridotta b:   " + b1);
        System.out.println("Prodotto di frazioni:   " + d1);
        System.out.println("Equals:   " + a1.equals(b1));
        System.out.println("Prodotto di frazioni:   " + c1.times(b1));*/

        /*
        Fraction2 f = new Fraction2(12, 30);
        Fraction2 f3 = new Fraction2(12, 3);
        Fraction2 f2 = new ReducedFraction2(12,30);
        Fraction2 f4 = new ReducedFraction2(1,3);
        System.out.println(f.equals(f3));
        System.out.println(f2.equals(f4));
        System.out.println(f.equals(f2));
        */



        /*Fraction2 f = new Fraction2(12,30);
        Fraction2 f2 = new Fraction2(1, 4);
        Fraction2 d = f2.times(f);
        Fraction2 rf = new ReducedFraction2(12,30);
        System.out.println(f);
        System.out.println(rf);
        System.out.println(d);
        System.out.println(f2.times(rf));*/

    }
}

/*PROBLEMA:
* è come se b, nonostante sia stampato in maniera ridotta, venga visto sempre come 12/30. infatti, quando vado a fare il prodotto tra c e b
* non mi esce 2/20 ma sempre 12/120 (appunto come se b fosse sempre 12/30
* R: vedi la risoluzione tra costruttore sottoclasse e MasComDiv
*  */