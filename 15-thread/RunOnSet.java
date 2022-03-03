//soluzione grazie al webbe
package com.company;
import java.util.*;

interface RunnableWithArg<T>{
    void run(T t);
}

//questa classe non implementa l'interfaccia. non deve ridefinire il suo run. 
//si farà capo all'implementazione di run(T t) dal main.
public class RunOnSet<T> extends Thread{

    private Collection<Thread> collectionThread = new HashSet<>(); //creo una collezione di thread

    public RunOnSet(RunnableWithArg <T> r, Collection<T> c) {
        for(T t : c){ //per ogni oggetto nella collezione passata, aggiungo un nuovo thread che richiama il run dell'interfaccia.
            collectionThread.add(new Thread(){
                @Override
                public void run(){
                    r.run(t);
                }
            });
        }

    }

    @Override
    public void run(){ //il run di Thread semplicemente richiama lo start per ogni oggetto della collezione di thread
        for(Thread t : collectionThread){
            t.start();
        }
    }
}



public class Main {

    public static void main(String[] args) {
    	Collection<Integer> s = new HashSet<Integer>();
        s.add(3); s.add(13); s.add(88);
        RunnableWithArg<Integer> r = new RunnableWithArg<Integer>() {
            public void run(Integer i) {
                System.out.println(i/2);
            }
        };
        Thread t = new RunOnSet<Integer>(r, s);
        t.start();


    }
}
