package com.company;
import java.util.*;

public class Relation<T,S> {
    //ho inteso la mappa come 2 liste. potrebbe essere anche una mappa di arraylist, non so
    private List<T> tList = new LinkedList<>();
    private List<S> sList = new LinkedList<>();
    Relation(){}

    void put(T t, S s){
        tList.add(t);
        sList.add(s);
    }

    void remove(T t, S s){
        Iterator<T> itT = tList.iterator();
        Iterator<S> itS = sList.iterator();
        while(itT.hasNext()){
            if(itT.next().equals(t)){
                itT.remove();
            }
        }
        while(itS.hasNext()){
            if(itS.next().equals(s)){
                itS.remove();
            }
        }
    }

    Set<S> image(T t){
        Set<S> newSet = new HashSet<>();
        int pos=0;
        for(T temp : tList){
            if(t.equals(temp)){
                //l'idea è poi di andare a vedere quella stessa posizione nell'altra lista... ma non so.
            }
        }
        return newSet;
    }



    @Override
    public String toString(){
        return sList.toString() + " " + tList.toString();
    }
}
