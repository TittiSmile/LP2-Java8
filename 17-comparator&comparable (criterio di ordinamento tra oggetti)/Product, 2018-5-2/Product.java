package com.company;
import java.util.*;
import java.io.*;

public class Product implements  Comparable<Product>{
    private String descrizione;
    private Double prezzo;
    private static Set <Product> setProdotti = new HashSet<Product>(); //statico PERCHé deve caricare tutti i prodotti per primi.

    Product(String d, Double p){
        this.descrizione=d;
        this.prezzo=p;
        Product.setProdotti.add(this);
    }

    public String getDescrizione(){
        return this.descrizione;
    }
    public Double getPrezzo() {
        return this.prezzo;
    }


    public static final Comparator<Product> comparatorByPrice = new Comparator<Product>() { //classe ANONIMA.
        @Override
        public int compare(Product o1, Product o2) {
            if(o1.prezzo>o2.prezzo){
                return 1;
            }
            else if(o1.prezzo<o2.prezzo){
                return -1;
            }
            return 0;
        };
    };

    public static Product getMostExpensive(){ //ritorna il prodotto più costoso,
        List<Product> listProdcut = new LinkedList<>(setProdotti);
        Collections.sort(listProdcut, comparatorByPrice);
        return listProdcut.get(listProdcut.size()-1); //size-1 perchè dobbiamo prendere l'ultimo elemento. ricorda che parte da 0.
    }

    @Override
    public int compareTo(Product o) {
        if(this.descrizione.compareTo(o.descrizione) > 0){
            return 1;
        }
        else if(this.descrizione.compareTo(o.descrizione) < 0){
            return -1;
        }
        return 0;
    }

    @Override
    public String toString(){
        return this.descrizione + ", " + this.prezzo;
    }

    //per essere sicuri del compare, usiamo anche equals ed hashcode (FACOLTATIVO).


    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        if(this.getClass()!=obj.getClass())
            return false;
        Product p = (Product) obj;
        return this.descrizione.equals(p.descrizione);
    }

    @Override
    public int hashCode() {
        return this.descrizione.hashCode();
    }
}
