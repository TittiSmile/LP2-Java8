package com.company;

import java.util.*;

public class myClass extends Thread {

    @Override
    public void run(){
        System.out.println("metodo run");
    }

    static <T> Iterator<T> delayIterator(Iterator<T> i, int n){ //il metodo ritorna un iteratore
        return new Iterator<T>() {  //lo creo come se fosse anonimo.
            @Override
            public boolean hasNext() {
                return i.hasNext(); //è l'iteratore passato come argomento.
            }
            @Override
            public T next() {   //il delay avviene chiaramente nel next
                try{
                    myClass.sleep(n); //il thread dorme per n secondi
                    //return i.next(); //si può mettere anche qua ma non mi convince.
                }catch(InterruptedException e){
                    System.out.println(e);
                }
                return i.next(); //ritorna il next.
            }
        };
    }



}


package com.company;


public class Main {

    public static void main(String[] args) {

        List<Integer> l = new LinkedList<Integer>();
        l.add(3);
        l.add(4);
        l.add(177);
        Iterator<Integer> i = myClass.delayIterator(l.iterator(), 2000);
        while (i.hasNext()) {
            System.out.println(i.next());
        }

    }
}
