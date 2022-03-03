package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Library casa = new Library();
        Library uffcio = new Library();

        Library.Book b1 = casa.addBook("Esercizi di stile", "Queneau"); //creazione del libro.
        b1.addTag("letteratura");
        b1.addTag("umorismo");
        Library.Book b2 = casa.addBook("Me parlare bene un giorno", "Sedaris");
        b2.addTag("umorismo");
        Library.Book b3 = uffcio.addBook("Literate programming", "Knuth");
        b3.addTag("programmazione");

        Set<Library.Book> humorCasa = casa.getBooksByTag("umorismo");
        System.out.println(humorCasa);
        Set<Library.Book> humorUfficio = uffcio.getBooksByTag("umorismo");
        System.out.println(humorUfficio);

    }
}
