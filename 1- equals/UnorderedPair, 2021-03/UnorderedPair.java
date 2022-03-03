package com.company;
import java.util.*;

public class UnorderedPair<T> implements Iterable<T> {
    private T elemento1;
    private T elemento2;
    private List<T> listElement=new LinkedList<>();

    UnorderedPair(T elem1, T elem2){
        this.elemento1=elem1;
        this.elemento2=elem2;
        listElement.add(elemento1);
        listElement.add(elemento2);

    }

    @Override
    public boolean equals(Object o){
        if(o==null)
            return false;
        if(this.getClass()!=o.getClass())
            return false;
        UnorderedPair listPassed = (UnorderedPair) o;
        /*implementazione uguale all'ultimo return, a quanto pare.
        for(Object u : listPassed){
            if(!listElement.contains(u)){
                return false;
            }
        }
        return true;*/
        return listElement.contains(listPassed);
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(this.elemento1);
        //return Objects.hashCode(listElement);
    }



    @Override
    public String toString() {
        return this.elemento1 + " " +  this.elemento2;
    }

    @Override
    public Iterator<T> iterator() {
        return listElement.iterator();
    }
}
