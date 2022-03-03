package com.company;
import java.util.*;

/*
    CREDO di aver trovato il modo per scrivere alpha nel tostring.
    - ho iniziato creandomi la stringa str per tenere conto del fatto che venisse passata o meno una stringa.
    - a seconda del valore passato (beta o alpha), con il metodo getStr mi veniva ritornato quel valore.
    - il metodo f sarebbe stato comodo, come implementazione nel toString. solo che, se ci accedo/stampo con un oggetto che NON
      ha alpha/beta mi si frigge tutto. se accedo ad f con un oggetto che non ha alpha/beta, mi si frigge tutto
    - visto che questa è una cosa "marginale" penso che sorvolerò.
 */

public class Version implements Comparable<Version>{
    Integer val1, val2, val3; //dichiarati come integer così posso fare il confronto in toString
    String str; //mi serve per verificare se la stringa passata nel costruttore(alpha) sia stata effettivamente passata oppure no :D
    static String alpha = "alpha";
    static String beta = "beta";
    Version(Integer v1, Integer v2){
       this.val1=v1;
       this.val2=v2;
    }
    Version(Integer v1, Integer v2, Integer v3){
        this.val1=v1;
        this.val2=v2;
        this.val3=v3;
    }

    Version(Integer v1, Integer v2, String s){
        this.val1=v1;
        this.val2=v2;
        this.str=s; //in questo modo sto dicendo che ho usato il costruttore con argomento stringa (alpha o beta)

    }

    Version(Integer v1, Integer v2, Integer v3, String s){
        this.val1=v1;
        this.val2=v2;
        this.val3=v3;
        this.str=s;

    }

    public String getStr(){
        return this.str;
    }

    public String f(){
        if(getStr().equals("alpha")){
            return this.val1 + "." + this.val2 + "" + alpha;
        }
        else if(getStr().equals("beta")){
            return this.val1 + "." + this.val2 + "" + beta;
        }
        return "aaa";
    }


    @Override
    public String toString() { //non posso fare diversi toString in una classe... quindi:
        String values = this.val1 + "." + this.val2;    //dichiaro una variabile che contiene i 2 valori che SICURAMENTE saranno nel costruttore
        if (this.val3 != null) {    //visto che il 3 valore è FACOLTATIVO controllo se è diverso da null.
           return this.val1 + "." + this.val2 + "." + this.val3; //se non è null allora val3 ha un certo valore e posso tornare la stampa dei 3
        }

        return values; //altrimenti ritorno "solo" la stampa dei 2.
    }

    @Override
    public int compareTo(Version o) {
        int risultato=0;
        if(this.val1!=o.val1){ //potrei usare anche equals invece di !=
            risultato = confrontoInteri(this.val1, o.val1);
        }
        else if(this.val2!=o.val2){
            risultato = confrontoInteri(this.val2, o.val2);
        }
        else if(this.val3!=o.val3){
            risultato = confrontoInteri(this.val3, o.val3);
        }
        return risultato;
    }

    public Integer confrontoInteri(Integer a, Integer b){ //mi serve nel compareTo. questo perchè devo andare a verificare i 3 valori.
        if(a==null || b==null){
            throw  new IllegalArgumentException("uno dei due parametri è null"); //così mi dice subito se il confronto è possibile o no.
            //non tutti gli oggetti version possono avere un parametro v3.
        }
        if(a>b){
            return 1;
        }
        else if(a<b){
            return -1;
        }
        return 0;
    }
}


/*    @Override
    public String toString() { //non posso fare diversi toString in una classe... quindi:
        String values = this.val1 + "." + this.val2;    //dichiaro una variabile che contiene i 2 valori che SICURAMENTE saranno nel costruttore
        if (this.val3 != null) {    //visto che il 3 valore è FACOLTATIVO controllo se è diverso da null.
            return this.val1 + "." + this.val2 + "." + this.val3; //se non è null allora val3 ha un certo valore e posso tornare la stampa dei 3
        }
        return values; //altrimenti ritorno "solo" la stampa dei 2.
    }
 */