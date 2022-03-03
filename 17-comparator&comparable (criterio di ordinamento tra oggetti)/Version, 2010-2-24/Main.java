package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Version v1 = new Version(1, 0);
        Version v2 = new Version(2, 4);
        Version v3 = new Version(2, 6, 33);
        Version v4 = new Version(2, 6, 34);

        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);
        System.out.println(v4);

        System.out.println(v1.compareTo(v2));
        System.out.println(v4.compareTo(v3));


        //EXTRA.
        //mi sono chiesta: ma se confronta uno che ha il val3 e l'altro no?
        //chiaramente, avrebbe lanciato eccezione nel confrontaInteri perchè si confrontava un null con un integer.
        //ora, nel metodo, ho messo un controllo in più che mi lancia eccezione se uno dei due parametri è vuoto.
        /*Version v5 = new Version(2, 4);
        Version v6 = new Version(2, 4, 3);
        System.out.println(v5.compareTo(v6));*/


        Version v7 = new Version(2, 4, Version.alpha);
        System.out.println(v7);

        Version v8 = new Version(2, 6, 34, Version.beta);
        System.out.println(v8);

        System.out.println(v7.getStr());


    }
}
