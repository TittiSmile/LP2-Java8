package com.company;

public class Time implements Comparable<Time>{
    private int ora;
    private int minuti;
    private int secondi;

    Time(int o, int m, int s){
        if((o<0 || o>23) || (m<0 || m>59) || (s<0 || s>59)){
            throw new IllegalArgumentException("orario non corretto");
        }
        this.ora=o;
        this.minuti=m;
        this.secondi=s;
    }


    public static Time MIDDAY(){
        return new Time(12,0,0);
    }

    public static Time MIDNIGHT(){
        return new Time(0,0,0);
    }

    public Time minus(Time x){ //ritorna la differenza dell'orario corrente con quello passato.
        int newOra, newMinuti, newSecondi;

        //vedo se l'orario corrente è maggiore/minore di quello passato
        if(this.ora > x.ora){
            newOra=this.ora-x.ora;
        }
        else{
            newOra=x.ora-this.ora;
        }

        if(this.minuti > x.minuti){
            newMinuti=this.minuti-x.minuti;
        }
        else{
            newMinuti=x.minuti-this.minuti;
        }

        if(this.secondi > x.secondi){
            newSecondi=this.secondi-x.secondi;
        }
        else{
            newSecondi=x.secondi-this.secondi;
        }
        return new Time(newOra, newMinuti, newSecondi);
    }

    @Override
    public String toString() {
        return this.ora + ":" + this.minuti + ":" + this.secondi;
    }

    @Override
    public int compareTo(Time o) {
        int orario=0;
        if(this.ora!=o.ora){
            orario=confronto(this.ora,o.ora);
        }
        else if(this.minuti!=o.minuti){
            orario=confronto(this.minuti,o.minuti);
        }
        else if(this.secondi!=o.secondi){
            orario=confronto(this.secondi, o.secondi);
        }
        return orario;
    }


    public int confronto(int a, int b){
        if(a>b)
            return 1;
        if(a<b)
            return -1;
        return 0;
    }
}
