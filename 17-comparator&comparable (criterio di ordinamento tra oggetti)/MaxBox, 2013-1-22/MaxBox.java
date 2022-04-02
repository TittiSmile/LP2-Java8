package com.company;
import java.util.*;

public class MaxBox<T> {
    private SortedSet<T> setObject;
    MaxBox(){
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
