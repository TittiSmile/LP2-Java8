package com.company;
import java.util.*;

public class City {
    private String cityName;
    private Set<City> citySet;
    City(String cn){
        this.cityName=cn;
        citySet=new HashSet<>();
    }

    void connect(City newCity){
        citySet.add(newCity); //aggiungo la città passata come argomento al set.
        newCity.citySet.add(this); //in più, devo aggiungere la città corrente (this) al set della città passata come argomento
                                   //in questo modo mi ritroverò this anche nel set di newCity
    }

    Collection<City> getConnections(){
        return citySet; //banalmente, mi ritorna il set della città
    }

    boolean isConnected(City newCity){ //torna true se la città è collegata a newCity direttamente o indirettamente.
        //1- controlla, banalmente, che newCity è nel set.
        //2- se non è nel set, controlla se l'elemento corrente nel set di this (scorrendo la sua lista) ha newCity
        for(City c : citySet){  //scorro il set
            if(citySet.contains(newCity)){ //se il set contiene la città passata...
                return true;                //...allora l'abbiamo trovata.
            }
            else{//altrimenti...
                if(c.citySet.contains(newCity)){ //cerco se nel set della città corrente c'è la città passata
                                                //(immagina che c sia napoli. cerco nel set di napoli se c'è newCity).
                    return true;
                }
            }
        }
        return  false;
    }

    public Set<City> getCitySet() {
        return citySet;
    }

    @Override
    public String toString(){
        return this.cityName;
    }
}
