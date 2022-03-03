package com.company;
import java.util.*;

public class Circle implements Comparable<Circle>{
    private Integer raggio;
    private Integer x,y;
    Circle(Integer x, Integer y, Integer r){
        this.x=x;
        this.y=y;
        this.raggio=r;
    }


    public boolean overlaps(Circle c){ //torna vero SE le due circonferenze hanno ALMENO un punto in comune.
        //ATTENZIONE. per punto "in comune" non intende semplicemente x o y. ma, graficamente parlando, se si toccano da qualche parte

        return true;
    }

    @Override
    public int compareTo(Circle o) {
        return 0;
    }

    @Override
    public String toString() {
        return this.x + " " + this.y + " " + this.raggio;
    }
}



/*
una circonferenza è "minore" di un'altra se è interamente contenuta in essa (-1), mentre se nessuna delle
due circonferenze è contenuta nell'altra, esse sono considerate "uguali" (0). Dire se tale criterio di
ordinamento è valido, giusticando la risposta

RIF ANTISIM
sgn(x.compareTo(y)) == -sgn(y.compareTo(x))
*/
