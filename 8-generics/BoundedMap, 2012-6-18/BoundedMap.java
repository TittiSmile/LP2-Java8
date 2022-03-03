package com.company;

import java.util.*;

public class BoundedMap<T,S> {
    private Map<T,S> map;
    private int dimensione;
    private Integer countGetCalls=0;
    private Map<T,Integer> mapCountOccurrences = new HashMap<>(); //mappa che mi conta le occorrenze di una chiamata
    public BoundedMap(int dim){
        this.dimensione=dim;
        map = new HashMap<>();
    }

    public void put(T t, S s){
        int dimMappa = map.size();
        //System.out.println(dimMappa+" " + dimensione);
        if(dimMappa<=dimensione){
            //System.out.println("aaaaa");
            map.put(t,s);
        }
        else {
            /*int max=findMaxValueMap(mapCountOccurrences);
            T x=null;
            for(Map.Entry<T,Integer> entry:mapCountOccurrences.entrySet()){
                if(entry.getValue().equals(max)){
                    x=entry.getKey();
                }
            }
            map.remove(x);
            map.put(t,s);*/
            //System.out.println("rrrrrrrrrr");

            int min = findMinValueMap(mapCountOccurrences);
            T x=null;
            for(Map.Entry<T,Integer> entry:mapCountOccurrences.entrySet()){
                if(entry.getValue().equals(min)){
                    System.out.println(x);
                    x=entry.getKey();
                }
            }
            System.out.println("oggetto " +x);
            map.remove(x);
            mapCountOccurrences.remove(x);
            map.put(t,s);

        }

    }

    public S get(T t){
        countGetCalls=mapCountOccurrences.get(t); //la mappa parte che è vuota
        if(countGetCalls==null) //quindi almeno 1 null ci deve stare.
            mapCountOccurrences.put(t,1);
        else
            mapCountOccurrences.put(t,countGetCalls+1);
        return map.get(t);
    }

    public Integer findMinValueMap(Map<T,Integer> map){
        Integer min=1000;
        for(Integer i : map.values()){
            if(i>min){
                min=i;
            }
        }
        return min;
    }


    public Map<T, S> getMap() {
        return map;
    }

    public Map<T, Integer> getMapCountOccurrences() {
        return mapCountOccurrences;
    }

    public Integer getCountGetCalls() {
        return countGetCalls;
    }

    @Override
    public String toString(){
        return map.toString();
    }
}
