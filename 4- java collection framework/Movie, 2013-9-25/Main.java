package com.company;
import java.util.*;

//l'unico PROBLEMA è che non riesco ad aggiungere l'ultimo sequel alla lista. non so come fare.
//per il resto funziona tutto alla grande.

public class Main {

    public static void main(String[] args) {
	// write your code here
        Movie r1 = new Movie("Rocky", 1976);
        Movie r2 = new Movie("Rocky II", 1979, r1);
        Movie r3 = new Movie("Rocky III", 1982, r2);
        Movie f = new Movie("Apocalypse Now", 1979);

        List<Movie> rockys = r2.getSeries();
        System.out.println(rockys);


        List<Movie> x = f.getSeries();
        System.out.println(x);


        Set<Movie> movies1979 = Movie.selectByYear(1979);
        System.out.println(movies1979);



        /*
        setMovieClass s1 = new setMovieClass();
        s1.addMovie(r1);s1.addMovie(r2);s1.addMovie(r3);
        s1.printSet(); //mi stampa tutti gli elementi nel set di movie
         */



    }
}
