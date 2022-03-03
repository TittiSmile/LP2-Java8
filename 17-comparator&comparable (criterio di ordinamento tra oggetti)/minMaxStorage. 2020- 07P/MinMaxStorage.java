package com.company;
import java.util.*;

//la classe accetta oggetti confrontabili. memorizza il massimo ed il minimo oggetto inserito.
public class MinMaxStorage<T> { //tolgo il comparable blablabla perchè NON è detto che devo passare argomenti ordinati.
    private SortedSet<T>  setStorage;
    private T elemento;
    //private comparatorStorage<T> comp = new comparatorStorage<T>(); //a questo punto il comparatore non mi serve più.

    //costruttore senza argomenti. gli oggeti inseriti devono avere ordinamento naturale.
    public MinMaxStorage(){
       setStorage = new TreeSet<T>();  //in questo caso, usiamo treeset senza comparatore. quindi senza implementazione
    }

    //costruttore che accetta un comparatore. gli oggetti verranno confrontati tramite comparatore. non necessariamente
    //avranno ordinamento naturale.
    public MinMaxStorage(Comparator<T> c){
        setStorage = new TreeSet<T>(c); //qui invece prendiamo treeset con comparatore. intendiamo che c'è un tipo di ordinamento.
    }

    //inserisce un oggetto
    public void add(T elem){
        this.elemento=elem;
        setStorage.add(elem);
    }

    //trova il minimo.
    public T getMin(){
        //il treeset ha due metodi: last e first. posso usare quelli per avere massimo e minimo.
        T min = setStorage.first(); //anche perchè il sortedSet è già ordinato. quindi il più piccolo è il primo elemento.
        return min;

      /*T min = setStorage.iterator().next(); //sarebbe il primo elemento del set.
        for(T t : setStorage){
            if(t.compareTo(min) < 0){
                min = t;
            }
        }
        return min;*/
    }

    //trova il massimo
    public T getMax(){
        T max = setStorage.last();
        return max;

    }

    public T getElemento() {
        return elemento;
    }

    public Set<T> getSetStorage() {
        return setStorage;
    }

    /*public Comparator<T> comp = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return o1.compareTo(o2);
        }
    };*/

    @Override
    public String toString() {
        return this.elemento + " ";
    }
}

class comparatorStorage<T extends Comparable<T>> implements Comparator<T>{
    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }
}