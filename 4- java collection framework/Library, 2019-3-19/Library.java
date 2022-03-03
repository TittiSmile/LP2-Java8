package com.company;
import java.util.*;

public class Library {
    private List<Book> library; //libreria: lista di libri.
    private List<Book> loanedList = new LinkedList<>(); //lista dei libri in prestito

    //1) Un costruttore senza argomenti che crea una biblioteca vuota.
    Library(){
        library=new LinkedList<>(); //l'ho inteso come LL perchè nessuno mi vieta di aggiungere libri uguali in una libreria
    }

    //2) Il metodo addBook aggiunge un libro alla biblioteca. Se il libro era già stato aggiunto,
    //  restituisce false.
    boolean addBook(Book b){
        if(library.contains(b)){
            return false;
        }
        library.add(b);
        return true;
    }

    //3)  Il metodo loanBook prende un libro come argomento e lo dà in prestito, a patto che sia
    //  disponibile. Se quel libro è già in prestito, restituisce false. Se quel libro non è mai stato
    //  inserito nella biblioteca, lancia un'eccezione.
    boolean loanBook(Book b){

        if(!library.contains(b)){
            throw new IllegalArgumentException("libro non presente in libreria");
        }
        else if(library.contains(b) ){ //controllo se l'oggetto b è presente nella lista di libri
            if(b.getContCall()==0){  //controllo che l'attributo cont dell'oggetto passato b sia effettivamente 0 (no prestiti).
                b.setContCall(1);   //imposto cont di b ad 1 (così la prossima chiamata sullo stesso b ritorna false).
                loanedList.add(b); //aggiungo in coda l'elemento "più recente".
                return true;
            }
        }
        return false;
    }

    //4) Il metodo returnBook prende un libro come argomento e restituisce quel libro alla biblioteca.
    //  Se quel libro non era stato prestato col metodo loanBook, il metodo returnBook lancia
    //  un'eccezione.
    Book returnBook(Book b){
        if(b.getContCall()==1){
            b.setContCall(0);   //la restituzione la intendo come il reimpostare il contatore.
            return b;
        }
        throw new IllegalArgumentException("libro mai prestato");
    }

    //5) Il metodo printLoans stampa la lista dei libri attualmente in prestito, in ordine temporale
    //(a partire dal libro in prestito da più tempo).
    void printLoans(){
        System.out.println(loanedList);
    }

    @Override
    public String toString() {
        return library.toString();
    }
}
