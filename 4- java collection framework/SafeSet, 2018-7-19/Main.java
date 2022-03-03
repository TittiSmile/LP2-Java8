package com.company;

//pare funzioni ma non ne sono 100% sicura dell'ottimizzazione
public class Main {

    public static void main(String[] args) {
	// write your code here
        SafeSet<String> a = new SafeSet<>();
        System.out.println("1- " + a.add("ciao")); //t
        System.out.println("2- " + a.add("mondo")); //t
        System.out.println("3- " + a.remove("ciao")); //t
        System.out.println("4- " + a.contains("ciao")) ; //f
        System.out.println("5- " + a.remove("ciao"));//t
        System.out.println("6- " + a.contains("ciao")) ;//f


    }
}
