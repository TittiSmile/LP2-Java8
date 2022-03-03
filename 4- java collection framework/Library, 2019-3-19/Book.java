package com.company;

//Un oggetto Book è caratterizzato dal suo titolo.

public class Book {
    private String titolo;
    private int contCall=0; //mi serve per contare quante volte è chiamato il metodo di prestito
    Book(String t){
        this.titolo=t;
    }

    //metodi getter e setter per cont che è privato.
    public int getContCall() {
        return contCall;
    }
    public void setContCall(int c){
        this.contCall=c;
    }

    @Override
    public String toString() {
        return this.titolo;
    }
}
