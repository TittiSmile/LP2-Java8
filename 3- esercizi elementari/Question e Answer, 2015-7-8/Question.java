package com.company;
import java.util.*;

public class Question {
    private String domanda;
    //List<String> risposte = new ArrayList<>();
    Question(String domanda){
        this.domanda=domanda;
    }

    public Answer getBestAnswer(){
        return Answer.foo();
    }



    @Override
    public String toString(){
        return this.domanda;
    }
}
