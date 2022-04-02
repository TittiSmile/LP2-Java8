package com.company;
import java.util.*;

public class MinMaxStorage<T> { 
    private SortedSet<T>  setStorage;
    private T elemento;

    public MinMaxStorage(){
       setStorage = new TreeSet<T>();  
    }

    public MinMaxStorage(Comparator<T> c){
        setStorage = new TreeSet<T>(c); 
    }

    //inserisce un oggetto
    public void add(T elem){
        this.elemento=elem;
        setStorage.add(elem);
    }

    //trova il minimo.
    public T getMin(){
       
        T min = setStorage.first(); //anche perchè il sortedSet è già ordinato. quindi il più piccolo è il primo elemento.
        return min;

    
    }

    //trova il massimo
    public T getMax(){
        T max = setStorage.last();
        return max;

    }

    public T getElemento() {
        return elemento;
    }

    public Set<T> getSetStorage() {
        return setStorage;
    }



    @Override
    public String toString() {
        return this.elemento + " ";
    }
}

class comparatorStorage<T extends Comparable<T>> implements Comparator<T>{
    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }
}