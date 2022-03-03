package com.company;
//non faccio la clonazione.

import java.util.*;

public class MyString {
    private String str;
    MyString(String s){
        str=new String(s);

    }

    @Override
    public boolean equals(Object obj){//Due oggetti MyString sono uguali se utilizzano le stesse lettere(anche in numero diverso)
        if(obj==null)
            return false;
        if(this.getClass()!=obj.getClass())
            return false;
        MyString m = (MyString) obj;
        return this.sameLetters(m);
    }

    //NON SO COME FARE L'HASHCODE

    boolean sameLetters(MyString m){ //serve a controllare se le liste hanno le stesse lettere al loro interno.
        List<Character> lm = new ArrayList<>(); //creo una lista di caratteri per il parametro
        lm=m.asChar();      //associo alla lista di caratteri i caratteri della parola passata m.
        List<Character> ls = new ArrayList<>();//creo una lista di caratteri per l'oggetto myString corrente (che contiene str).
        ls=this.asChar();   //associo alla lista di caratteri i caratteri della parola contenuta nell'oggetto corrente myString.

        //ciclo sulla lista. nel momento in cui trovo almeno un(1) elemento che non è presente nell'altra, allora sono diversi.

        for(Character c : ls){ //scorro la lista dell'oggetto myString corrente.
            if(!lm.contains(c)){    //questo vuol dire "lm non contiene c". c è l'elemento che sta scorrendo in ls.
                                    //se non c'è in lm vuol dire che sono parole diverse.
                return false;
            }
        }
        return true;
    }

    List<Character> asChar(){ //mi ritorna una lista di caratteri di str.
        int i=0;
        List<Character> l = new ArrayList<>(); //creo la lista di caratteri
        while(i < str.length()){ //ciclo fino ad arrivare alla lunghezza della stringa
            //System.out.println(str.charAt(i));
            i++; //incremento
            l.add(str.charAt(i-1));  //aggiungo alla lista l'elemento i-esimo della stringa.
                    //charAt va da i a len-1 (lo dice la traccia)
        }
        return l;
    }



    @Override
    public String toString() {
        return this.str;
    }
}
