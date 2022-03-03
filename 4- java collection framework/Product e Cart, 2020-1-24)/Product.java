package com.company;
import java.util.*;

public class Product {
    private String descrizione;
    private Integer prezzo;
    private static List<String> list = new LinkedList<>(); //statica perchè altrimenti mi avrebbe aggiunto solo la descrizione corrente.
                                                            // a me serve la descrizione di TUTTI i prodotti che vengono inseriti. solo così
                                                            // posso fare il controllo. fai anche la prova togliendo static e vedi che non ti
                                                            // lancia eccezione. questo perchè ti conta le occorrenze solo per la descrizione
                                                            // corrente. non va bene.
    private int cont=0;
    public Product(String descrizione, Integer prezzo){
        this.descrizione=descrizione;
        this.prezzo=prezzo;
        list.add(descrizione); //aggiungo qua perchè è nel costruttore che, eventualmente, va lanciata eccezione.
        if(contOccorrenze(descrizione)>1){ //se c'è più di 1 occorrenza...
            throw new IllegalArgumentException("errore"); //...lancia errore
        }
    }

    int contOccorrenze(String d){ //mi conta le occorrenze della descrizione nella lista.
        for(String s : list){
            if(s.equals(d)){
                cont++;     //sarà almeno 1. ma se ce ne sono 2 , non va bene.
            }
        }
        return cont;
    }


    public List<String> getList() {
        return list;
    }

    public Integer getPrezzo() {
        return prezzo;
    }

    public String getDescrizione() {
        return descrizione;
    }

    @Override
    public String toString(){
        return this.descrizione+ " " + this.prezzo;
    }

}
