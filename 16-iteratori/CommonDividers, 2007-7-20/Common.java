package com.company;
import java.util.*;
//Implementare una classe CommonDividers che rappresenta tutti i divisori comuni di due numeri
//interi, forniti al costruttore.

public class Common implements Iterable<Integer>{
    private int div1;
    private int div2;
    private List<Integer> l;
    Common(int d1, int d2){
        this.div1=d1;
        this.div2=d2;
        if (this.div1 > this.div2) {
            throw new IllegalArgumentException("il primo valore deve essere maggiore del secondo");
        }
        l = new ArrayList<>();
    }



    //implementazione senza lista di appoggio?
    //ci ho provato ma nada. non viene preso.
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int temp = div1;
            int cont = 1;
            int i=cont;

            @Override
            public boolean hasNext() {
                while (cont <= div1) {
                    if (div2 % cont == 0 && div1 % cont == 0) {
                        i=cont;
                    }
                    cont++;
                    return true;
                }
                return false;
            }

            @Override
            public Integer next() {
                int i=0;
                while (hasNext()) {
                  return next();
                }
                return null;
            }
        };

    }
}




















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
