package com.company;
import java.util.*;

public class IncreasingSubsequence<T extends Comparable<T>> implements Iterable<T> {
    private List <T> list;
    IncreasingSubsequence(List<T> l){
       this.list=l;
    }


    @Override
    public String toString() {
        String s = list.toString();
        return s;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Iterator<T> iter = list.iterator();

            private int currentIndex = 0;
            private T max = list.get(0);

            @Override
            public boolean hasNext() {
                return iter.hasNext();
            }
            @Override
            public T next() {   //da github. non riesco a fare di meglio.
                if(currentIndex++ == 0){
                    return max;
                }
                else if( max.compareTo(list.get(currentIndex)) > 0 ){
                    return next();
                }
                max = list.get(currentIndex);
                return max;
            }
            @Override
            public void remove(){
                throw new UnsupportedOperationException("errore");
            }
        };
    }
}
