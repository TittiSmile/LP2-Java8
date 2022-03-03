package com.company;
import java.util.*;

public class Library {
    private Set<Book> s; //viene implementato come set
    Library(){
        s=new HashSet<>();
    }

    @Override
    public String toString() {
        String str = s.toString();
        return str;
    }

    Book addBook(String titolo, String autore){
        Book b = new Book(titolo, autore);
        s.add(b);
        return b;
    }

    Set<Book> getBooksByTag(String t){
       Set<Book> bookTag = new HashSet<>();
       for(Book b : s){
           //devo controllare se il tag del libro corrente contiene il tag t passato come parametro. se sì, aggiungilo
           //a bookTag e ritornalo.
           if(b.getTags().contains(t)){
               bookTag.add(b);
           }
           else{
               return null;
           }
       }
       return bookTag;
    }


    class Book{
        private String autore;
        private String titolo;
        Set<String> setTag = new HashSet<>(); //i generi sono univoci quindi metto un set.
        Book(String t, String a){
            this.titolo=t;
            this.autore=a;
        }

        void addTag(String t){
            setTag.add(t);
        }

        Set<String> getTags(){
            return setTag;
        }

        @Override
        public String toString() {
            return this.titolo + " " + this.autore;
        }
    }

}
