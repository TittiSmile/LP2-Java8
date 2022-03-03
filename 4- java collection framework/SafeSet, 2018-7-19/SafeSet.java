package com.company;
import java.util.*;

public class SafeSet<T> {
    private Set<T> s;
    private List<T> trash = new ArrayList<>();
    private int contCallFunz=0; //conto le chiamate del metodo remove. parto da 0
    SafeSet(){
        s=new HashSet<>();
    }

    //1) Il metodo add aggiunge un elemento all'insieme, restituendo true
    //se l'inserimento ha avuto successo
    boolean add(T t){
        if(s.contains(t)){
            return false;
        }
        s.add(t);
        return true;
    }

    //2) Il metodo remove rimuove un elemento dall'insieme, ma la
    //rimozione è definitiva solo dopo una seconda chiamata

    //DUBBIO: in che caso remove ritorna false? torna sempre true? torna false se il tale elemento non esiste.
    boolean remove(T t){
        if(s.contains(t)){
            if(contCallFunz==0){ //se il contatore delle chiamate di remove è 0 (quindi non è mai stato chiamato)...
                contCallFunz=1; //...lo aggiorno ad 1 (informo che c'è stata una prima chiamata).
                trash.add(t);
                return true;
            }
            else if(contCallFunz==1){ //se invece è già 1...
                s.remove(t);          //...posso eliminare l'elemento
                return true;
            }
        }

       return false;
    }

    //3) Il metodo contains verifica se l'insieme
    //contiene un dato elemento (in base a equals).
    boolean contains(T t){
        if(s.contains(t)){
            if(trash.contains(t)){ //se l'array contiene l'elemento "eliminato" la prima volta allora torna false.
                return false;
            }
            return true;
        }
        return false;
    }

    //due Safeset sono uguali se contengono gli stessi elementi
    @Override
    public boolean equals(Object o){
        if(o==null)
            return false;
        if(this.getClass()!=o.getClass())
            return false;
        SafeSet ss = (SafeSet) o;
        return this.s.equals(ss.s); //controllo, appunto, l'uguaglianza tra gli insiemi creati nella classe.
    }



    @Override
    public String toString() {
        return s.toString(); //stampo l'insieme.
    }

}
