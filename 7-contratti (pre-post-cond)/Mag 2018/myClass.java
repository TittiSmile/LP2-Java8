package com.company;
import java.util.*;
//pre-cond: le due liste devono essere dello stesso tipo e della stessa lunghezza.
//post-cond: ritorna una nuova lista con gli elementi alternati delle due liste.

public class myClass {

    <T> LinkedList<T> merge(LinkedList<T> l1, LinkedList<T>l2) throws IllegalArgumentException{
        LinkedList<T> l3 = new LinkedList<T>();
        if(l1.size()!=l2.size()){
            throw new IllegalArgumentException();
        }

        Iterator<T>it = l1.iterator();
        Iterator<T>it2 = l2.iterator();

        int cont=0;
        while(it.hasNext()){
            if(it.next()!=null){
                l3.add(l1.get(cont));
                l3.add(l2.get(cont));
                cont++;
            }
        }



        return l3;
    }

}
