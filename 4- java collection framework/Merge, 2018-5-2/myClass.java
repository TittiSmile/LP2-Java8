package com.company;
import java.util.*;

public class myClass {

    //Restituisce una nuova LinkedList ottenuta alternando gli elementi della prima
    //lista e quelli della seconda.
    public <T> LinkedList<T> merge(LinkedList<T> a, LinkedList<T> b){
        LinkedList<T> l = new LinkedList<>();
        if(a.size()!=b.size()){
            throw new IllegalArgumentException("le liste hanno dimensioni diverse");
        }
        Iterator<T> it = a.iterator();
        Iterator<T> it2 = b.iterator();
        while(it.hasNext() && it2.hasNext()){
            l.add(it.next());
            l.add(it2.next());
        }
        return l;
    }
}
