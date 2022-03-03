///ATTENZIONE!!! questa classe non ha l'implementazione simile al caso d'uso. qua passo come parametro un argomento.

package com.company;
import java.util.*;

public class Accumulator2<T extends Number & Comparable<T>> { //perchè? semplice.
    // il nostro T deve essere sottoclasse di number. NON BASTA deve anche implementare il comparable di se stesso per
    // eventuali confronti (ho usato il comparatore. come posso usare compareTo riga 31 se T non implementa il comparable di se stesso?)
    private List<T> listPositive = new LinkedList<>(); //lista che conterrà solo elementi positivi
    private List<T> listNegative = new LinkedList<>();//lista che conterrà solo elementi positivi
    private List<T> sumList = new LinkedList<>();//lista dove aggiungo TUTTI gli elementi per fare la somma. RICORDA. NON può essere statico
    T zero;

    public Accumulator2(T zero){//NON rispecchia il caso d'uso ma ho usato questa strategia. gli passo lo zero come parametro.
        this.zero=zero;

    }

    public void add(T elem){
        sumList.add(elem); //l'aggiunta viene SEMPRE fatta nella sumList.
        if(comp.compare(elem,zero)>0){ //se il confronto tra elem e zero (a cui ho passato 0) è maggiore di 0 allora elem è positivo
            listPositive.add(elem);
        }
        else{ //viceversa è negativo
            listNegative.add(elem);
        }
    }


    Comparator<T> comp = new Comparator<T>() { //ho usato un comparatore. ma poteva anche essere evitato e proverò un altro metodo.
        @Override
        public int compare(T o1, T o2) {
            return o1.compareTo(o2);
        }
    };

   List<T> positives(){ //ritorna la lista degli elementi positivi
       return listPositive;
    }
    List<T> negatives(){ //ritorna la lista degli elementi negativi
        return listNegative;
    }


    Double sum(){ //fa la somma di tutti gli elementi
       double sum = 0.0;
       for(T t : sumList){
           sum+=t.doubleValue(); //metodo che viene suggerito nella traccia. non so bene come funziona ma fa il suo lavoro.
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
