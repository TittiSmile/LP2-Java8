package com.company;
import java.util.*;


public class Cart {
    private List<Product> listProduct = new LinkedList<>(); //non era necessario porre la lista statica.
    public Cart(){

    }

    public void add(Product p){
        listProduct.add(p);
    }
    public void remove(Product p){
        Iterator<Product> it = listProduct.iterator(); //RICORDA che fare la remove senza iteratore in una lista,
                                                        // può lasciare la lista in uno stato incompleto. usa sempre l'iteratore.
        while(it.hasNext()){
            if(it.next().equals(p)){
                it.remove();
                break; //in questo modo non elimina TUTTE le sedie. elimina solo quella che trova.
                //se non ci fosse stato, avrebbe eliminato tutte le sedie dalla lista.
            }
        }
    }

    public int totalPrice(){
        int total=0;
        for(Product p : listProduct){
            total+=p.getPrezzo();
        }
        return total;
    }


    @Override
    public String toString(){
        return listProduct.toString();
    }
}
