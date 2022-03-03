package com.company;
import java.util.*;

//ATTENZIONE!!! non ho fatto  la throws perchè c'è sempre almeno 1 maronno che si trova nell'intervallo. per il resto, funziona


public class Room {
    private Reservation r;
    private Set<Reservation> prenotazioni;

    Room(){
        prenotazioni=new TreeSet<>();
    }

    Reservation reserve(String nome, Integer dataPrenotazioneI, Integer dataPrenotazioneF){
        r=new Reservation(nome, dataPrenotazioneI, dataPrenotazioneF);

        if(!r.isReserved(prenotazioni, r)){
            //throw new IllegalArgumentException("errore data");
            System.out.println(r + "-----");
        }
        prenotazioni.add(r);

        return r;
    }



    Set<Reservation> reservations(){
        //System.out.println(prenotazioni);
        return prenotazioni;
    }

}
