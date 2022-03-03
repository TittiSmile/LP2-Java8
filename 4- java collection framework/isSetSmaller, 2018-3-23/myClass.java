package com.company;

//Implementare il metodo statico isSetSmaller, che accetta due insiemi e un comparatore, e restituisce
//vero se e solo se tutti gli elementi del primo insieme sono più piccoli, in base al comparatore,
//di tutti gli elementi del secondo insieme.

import java.util.*;

public class myClass {

     <T> boolean isSmaller(Set<? extends T> s1, Set<? extends T> s2, Comparator<? super T> comp){
         ArrayList<T> a1 = new ArrayList<>(s1);
         ArrayList<T> a2 = new ArrayList<>(s1);
         Collections.sort(a1,comp);
         Collections.sort(a2,comp);
         int dim = s1.size();
         T maxElemSet = a1.get(dim-1);
         //ora che gli array sono ordinati mi prendo l'ultimo elemento del primo set e controllo se è più piccolo
         //di tutti gli elementi di s2.
         for(T t : s2){
             if(comp.compare(maxElemSet, t) < 0){
                 return true;
             }
         }

        return false;
    }
}

class setsComparator<T extends Comparable<T>> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }
}
