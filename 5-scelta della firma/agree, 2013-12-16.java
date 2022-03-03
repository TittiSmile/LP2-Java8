//pre:	accetta 2 comp e 2 oggetti
//post:	ritorna true se i comparatori concordano con l'ordine di a e b false altrimenti
    <T> boolean agree(Comparator<T> c1, Comparator<T> c2, T a, T b){
        if(c1.compare(a,b)==c2.compare(a,b))
            return true;
        return false;
    }



a) <T> boolean agree(Comparator<T> c1, Comparator<T> c2, T a, T b)
/*
funzionalità:	sì
completezza:	no, siamo focalizzati su T
correttezza:	sì
garanzie:		nessuna
semplicità:		1 param
ritorno			banale
*/

b) boolean agree(Comparator<Object> c1, Comparator<Object> c2, Object a, Object b)
/*
funzionalità:	sì (object va bene perchè è grezzo)
completezza:	no. siamo limitati ad object
correttezza:	sì
garanzie:		nessuna
semplicità:		0 param
ritorno			banale
*/

c) <S, T> boolean agree(Comparator<S> c1, Comparator<T> c2, S a, T b)
/*
funzionalità:	no. sono due tipi completamente diversi e senza nulla a che vedere. come faccio a confrontare a e b se
				sono di due tipi diversi? il confronto avviene solo con tipi uguali
completezza:
correttezza:
garanzie:
semplicità:
ritorno
*/

d) <T> boolean agree(Comparator<? extends T> c1, Comparator<? extends T> c2, T a, T b)
/*
funzionalità:	no. il comparatore è sulla sottoclasse. come faccio a fare il confronto?
completezza:
correttezza:
garanzie:
semplicità:
ritorno
*/

e) <T> boolean agree(Comparator<? super T> c1, Comparator<? super T> c2, T a, T b) //MIGLIORE
/*
funzionalità:	sì
completezza:	sì, possiamo prender T e sottotipi di T (per qualunque T)
correttezza:	sì
garanzie:		leggo object dai comparatori
semplicità:		1 param
ritorno			banale
*/

f) <S, T extends S> boolean agree(Comparator<S> c1, Comparator<S> c2, T a, T b)
/*
funzionalità:	sì. T ed S sono imparentati quindi va bene.
completezza:	sì, posso scegliere qualunque S (e quindi qualunque T sua sottoclasse)
correttezza:	sì
garanzie:		nessuna
semplicità:		2 param
ritorno			banale
*/

























package com.company;
import java.util.*;

public class MyClass {

    <T> boolean agree(Comparator<T> c1, Comparator<T> c2, T a, T b){
        if(c1.compare(a,b)==c2.compare(a,b))
            return true;
        return false;
    }

}

class myComp <T extends Comparable<T>> implements Comparator<T>{
    @Override
    public int compare(T a, T b){
        return a.compareTo(b);
    }
}

class myComp2 <T extends Comparable<T>> implements Comparator<T>{
    @Override
    public int compare(T a, T b){
        return a.compareTo(b);
        //return b.compareTo(a); //metti questo se vuoi che agree esca FALSO.
    }
}





public class Main {

    public static void main(String[] args) {
        MyClass m = new MyClass();
        Integer a = 10;
        Integer b = 3;
        myComp<Integer> mc = new myComp<>();
        myComp2<Integer> mc2 = new myComp2<>();
        System.out.println(m.agree(mc,mc2,a,b));



    }
}