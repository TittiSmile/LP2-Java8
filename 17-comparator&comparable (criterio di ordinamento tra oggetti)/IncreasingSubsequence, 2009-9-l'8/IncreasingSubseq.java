package com.company;
import java.util.*;

//NON SONO SICURA DELLA CORRETTEZZA

public class IncreasingSubseq<T extends Comparable<T>> implements Comparable<T> {
    private List<T> list = new LinkedList<>();

    IncreasingSubseq(List<T> l){
        this.list=l;
    }


    @Override
    public String toString() {
        String s = list.toString();
        return s;
    }


    @Override
    public int compareTo(T o) {
        for(T t : list){
            return t.compareTo(o);
        }

        return 0;
    }
}
