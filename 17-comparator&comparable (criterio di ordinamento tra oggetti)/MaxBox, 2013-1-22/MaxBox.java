package com.company;
import java.util.*;

public class MaxBox<T> {
    private SortedSet<T> setObject;
    MaxBox(){
        //non so come fare a vedere se una classe implementa un'interfaccia. penso c'entri qualcosa la riflessione.
        setObject=new TreeSet<>();
    }
    MaxBox(Comparator<T> comp){
        setObject=new TreeSet<>(comp);
    }

    void insert(T element){
        setObject.add(element);
    }

    T getMax(){
        return setObject.last(); //last, implementazione di treeset
    }



    @Override
    public String toString(){
        return setObject.toString();
    }
}
