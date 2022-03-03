package com.company;
import java.util.*;
public class Accumulator<T extends Number & Comparable<T>> {
    private List<T> listPositive = new LinkedList<>();
    private List<T> listNegative = new LinkedList<>();
    private List<T> sumList = new LinkedList<>();
    private final Double zero = 0.0;

    public Accumulator(){

    }

    public void add(T elem){
        sumList.add(elem); //l'aggiunta viene SEMPRE fatta nella sumList.
        if(zero.compareTo(elem.doubleValue())<0){
            listPositive.add(elem);
        }
        else{
            listNegative.add(elem);
        }
    }



    List<T> positives(){
        return listPositive;
    }
    List<T> negatives(){
        return listNegative;
    }


    Double sum(){
        double sum = 0.0;
        for(T t : sumList){
            sum+=t.doubleValue();
        }
        return sum;
    }

    public List<T> getListNegative() {
        return listNegative;
    }

    public List<T> getListPositive() {
        return listPositive;
    }

    public List<T> getElementsList() {
        return sumList;
    }

    @Override
    public String toString(){ //toString stampa entrambe le liste.
        return listPositive.toString() + listNegative.toString();
    }



}
