package com.company;
import java.util.*;

public class BoundedSet<T> {
    private Set<T> setObject;
    private List<T> listOlderElementsSet;
    private Integer capacity;
    public BoundedSet(Integer c){
        this.capacity=c;
        setObject = new HashSet<>();
        listOlderElementsSet = new LinkedList<>();
    }

    void add(T element){
        if(checkSetSizeMinorCapacity()){
            setObject.add(element);
            listOlderElementsSet.add(element);
        }
        else{
            T firstElement = listOlderElementsSet.get(0);
            if(!setObject.contains(element)){
                setObject.remove(firstElement);
                setObject.add(element);
            }
        }

    }

    boolean contains(T element){
        if(setObject.contains(element)){
           return true;
        }
        return false;
    }

    int size(){
        return setObject.size();
    }

    boolean checkSetSizeMinorCapacity(){
        if(setObject.size()<this.capacity){
            return true;
        }
        return false;
    }

    public Set<T> getSetObject() {
        return setObject;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public List<T> getListOlderElementsSet() {
        return listOlderElementsSet;
    }

    @Override
    public String toString(){
        return this.setObject.toString();
    }
}


//1-controllare la dimensione del set ad ogni add
//2-non incrementare la dimensione se c'è già  un elemento presente nel set (tipo se c'è già 5 e lo passo, non deve incrementarlo)


//DUBBIO. non mi viene aggiunto l'altro 5 (anche se è già presente)