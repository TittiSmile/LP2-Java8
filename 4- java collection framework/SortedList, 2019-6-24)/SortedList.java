package com.company;
import java.util.*;
//oggetti dotati di ordinamento naturale sono tutti quelli che implementano comparable... integer, string ecc

public class SortedList<T extends Comparable<T>> implements Iterable<T>{
    private List<T> sortedList = new ArrayList<>();

    public SortedList(){}

    public void add(T elem){
        sortedList.add(elem);
        Collections.sort(sortedList,comp); //mi serve per ordinare gli elementi in maniera crescente.
    }

    Comparator<T> comp = new Comparator<T>() { //classico comparatore
        @Override
        public int compare(T o1, T o2) {
            return o1.compareTo(o2);
            //se vuoi l'ordinamento decrescente: return o1.compareTo(o2);
        }
    };

    @Override
    public Iterator<T> iterator() {
        return sortedList.iterator();
    }
}
