package com.company;
import java.util.*;

public class Answer {
    private Question domanda;
    private String risposta;
    private static Set<Answer> s = new HashSet<>(); //set perchè immagino che le risposte sono uniche. possono essere votate più volte ma sono uniche
    private static Map<Answer,Integer> map = new HashMap<>(); //mappa per contare le occorrenze di una risposta. sarebbero i voti
    private int cont = 0;
    Answer(Question q, String risposta){
        this.domanda=q;
        this.risposta=risposta;
        s.add(this);
    }

    public void voteUp(){
        cont= cont +1;
        map.put(this,cont);
    }

    String f(){
        for(Answer a : s) {
            domanda.risposte.add(a.risposta);
        }
        System.out.println(domanda.risposte);
        return risposta;
    }

    public static Answer foo(){
        int max = -1000;
        Answer a = null;
        for(Map.Entry<Answer, Integer> entry : map.entrySet()){
            if(entry.getValue()> max){
                max = entry.getValue();
                a=entry.getKey();
            }
        }

        return a;

    }


    public static Set<Answer> getS() {
        return s;
    }

    public static Map<Answer, Integer> getMap() {
        return map;
    }

    @Override
    public String toString(){
        return this.domanda+ " " +this.risposta;
    }

}
