package com.company;
import java.util.*;
//Implementare una classe CommonDividers che rappresenta tutti i divisori comuni di due numeri
//interi, forniti al costruttore.
//implementazione con lista d'appoggio. NON è sbagliato


public class CommonDividers implements Iterable<Integer> {
    private int div1;
    private int div2;
    private List<Integer> l;
    CommonDividers(int d1, int d2){
        this.div1=d1;
        this.div2=d2;
        if (this.div1 > this.div2) { //pongo che il secondo parametro deve essere maggiore del primo per comodità.
            throw new IllegalArgumentException("il primo valore deve essere maggiore del secondo");
        }
        l = new ArrayList<>();
        l=listaDivisori();      //lo riassegno perchè la stampa parte già facendo la new dell'oggetto.
    }

    private List<Integer> listaDivisori(){
       int cont=1;  //parto da 1 per evitare divisioni per 0
       while(cont <= div1){     //ho imposto che il primo valore passato è minore del secondo.
           if(div2%cont==0 && div1%cont==0){ //se l'elemento corrente è diviso da entrambi i numeri...
               l.add(cont);                 //...allora è un divisore comune.
           }
           cont++;
       }
       return l;
    }

    @Override
    //l'iteratore così com'è ha poco senso.
    //bastava fare return l.iterator().
    public Iterator<Integer> iterator() {
        //puoi ritornare solo l'iteratore della lista.
        return new Iterator<Integer>() {
            Iterator<Integer> it = l.iterator(); //è ridondante? NO. anzi è sensato
            @Override
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override
            public Integer next() {
                return it.next();
            }

            @Override
            public void remove(){
                throw new UnsupportedOperationException("errore");
            }
        };
    }


}






/*
    //implementazione senza lista di appoggio?
    class myClass implements Iterator<Integer>{
        private Iterator<Integer> it; // no iteratore. metti una variabile che assegna il minimo trovato su.
        //il next cicla sui successivi.
        int temp=div1;
        int cont=1;
        myClass(){
            it=l.listIterator();
        }
        @Override
        public boolean hasNext(){
            while(cont<div1){
                return true;
            }
            return false;
            //bisogna ridefinirlo. devi controllare se c'è un prossimo divisore oppure no.
        }
        @Override
        public Integer next() { //chiamare listDivisori dal next? serve istanza di CommonDividers
            //listaDivisori adattata in next. ha un intero come attributo della classe. (no iteratore).
            //il next trova il prossimo divisore.
            while(it.hasNext()){
                if(div2%cont==0 && div1%cont==0){
                    return it.next();
                }
            }
            return null;
        }

        @Override
        public void remove(){
            throw new UnsupportedOperationException("errore");
        }
*
* */













/*
    boolean isDivided(){    //considero se l'uno è divisibile dall'altro
        if(div2%div1==0)
            return true;
        return false;
    }

    List<Integer> listaDivisori(){

        //ritorno la lista con tutti i divisori comuni.
        int cont=1; //parte da 1 perchè sennò c'è divisione per 0
        if(isDivided()){ //controllo se l'uno divide l'altro
            while(cont<div2 && cont <= div1){ //il contatore deve essere minore di entrambi i divisori
                if(div2%cont==0){   //se il valore cont diviso div2 dà resto 0...
                    l.add(cont);    //...posso aggiungerlo alla lista (vuol dire che è divisore)
                }
                cont++;
            }
        }
        else{
            l.add(cont);
            if(div1%2==0 && div2%2==0){
                l.add(2);
            }
            else if(div1%3==0 && div2%3==0){
                l.add(3);
            }
        }
        return l;
      }

    */