package com.company;
import java.util.*;

public class Bijection<T,S> {
    private Map<T,S> map;
    Bijection(){
        map=new HashMap<>();
    }
    void addPair(T elem1, S elem2){
        Set<T> setKey = new HashSet<>(map.keySet());
        Collection<S> colValue = new LinkedList<>(map.values());
        if(setKey.contains(elem1) || setKey.contains(elem2)){
            throw new IllegalArgumentException("errore");
        }
        if(colValue.contains(elem1) || colValue.contains(elem2)){
            throw new IllegalArgumentException("errore");
        }
        map.put(elem1, elem2);
    }

    S getValue(T elem){
        for(Map.Entry<T,S> entry : map.entrySet()){
            if(entry.getKey().equals(elem)){
                return entry.getValue();
            }
        }
        return null;
    }

    T getKey(S elem){
        for(Map.Entry<T,S> entry : map.entrySet()){
            if(entry.getValue().equals(elem)){
                return entry.getKey();
            }
        }
        return null;
    }


    public Map<T, S> getMap() {
        return map;
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
