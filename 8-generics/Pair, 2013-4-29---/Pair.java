package com.company;

public class Pair<T,S> {
    T tElem;
    S sElem;
    Pair(T t, S s){
        this.tElem=t;
        this.sElem=s;
    }

    @Override
    public boolean equals(Object obj){ //non mi è molto chiaro questo equals descritto dalla traccia
        //immagino che sono uguali se effettivamente hanno lo stesso contenuto?
        if(obj==null)
            return false;
        if(this.getClass()!=obj.getClass())
            return false;
        Pair p = (Pair) obj;
        return (this.sElem==p.sElem) && (this.tElem==p.tElem);
    }



    @Override
    public String toString(){
        return "("+tElem+", "+sElem+")";
    }
}
