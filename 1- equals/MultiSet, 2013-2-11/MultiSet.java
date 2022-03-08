package com.company;
import java.util.*;

//un multiSet è un oggetto che si comporta similmente alla lista. ha i suoi metodi add e remove.
//per questo vengono dichiarati dei nuovi metodi.

public class MultiSet<T> implements Iterable<T> { //devi poter fare FOR EACH. serve un iterable.
    private List<T> l;  //dichiaro la lista
    MultiSet(){
        l=new LinkedList<>(); //la inizializzo nel costruttore. per ogni oggetto multiset sarà creata una lista
    }

    public void add(T t){
        l.add(t); //add mi permette di aggiungere l'elemento T alla lista.
    }

    public void remove(T t){
        Iterator<T> it = l.iterator(); //per usare la remove mi serve per forza l'iteratore.
        while(it.hasNext()){ //scorro con iteratore
            if(it.next().equals(t)){ //se l'elemento next è uguale a t (argomento passato)
                it.remove();    //lo rimuovo
            }
        }
    }

    @Override
    public boolean equals(Object obj){ //2 multiset sono uguali SE hanno gli stessi elementi ripetuti lo stesso numero di volte
        if(obj == null){
            return false;
        }
        if(this.getClass()!=obj.getClass()){
            return false;
        }
        MultiSet m = (MultiSet)obj;
        return this.contElement(m);
    }

    @Override
    public String toString() {
        String s = l.toString();
        return s;
    }

    public boolean contElement(MultiSet<T> ml){
        if(l==null || ml==null){
            return false;
        }
        Iterator<T> it2 = ml.iterator();
        while(it2.hasNext()){ //scorro la lista passata.
            T t = it2.next(); //facoltativo ma tant'è.
            if(!l.contains(t)){    //se trovo almeno 1 elemento che NON è contenuto allora non sono uguali.
                return false;
            }
        }
        return true;
    }


    @Override
    public Iterator<T> iterator() { 
        return l.iterator();
    }

    //è buona norma mettere hashcode insieme ad equals:
    @Override
    public int hashCode(){
        return Objects.hash(l);
    }
}
