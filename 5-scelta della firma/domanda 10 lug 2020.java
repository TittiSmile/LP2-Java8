//pre-cond: il metodo accetta 3 insiemi
//post-cond: inserisce tutti gli elementi di a in b e tutti gli elementi di b in c

package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        Set<Integer> c = new HashSet<>();
        a.add(1);a.add(2);a.add(3);
        b.add(4);b.add(5);b.add(6);
        c.add(7);c.add(8);c.add(9);
        myClass.insertIntoOtherSet(a,b,c);
        System.out.println(a + "\n" + b + "\n" + c);
    }
}

class myClass {
    public static <S,T extends S> void insertIntoOtherSet (Set<? extends T> a, Set<T> b, Set<S> c){ 
        Set<T> bTemp = new HashSet<>(b);
        for(T t : a){
            b.add(t);
        }
        for(T t : bTemp){
            c.add(t);
        }
    }
}


/*
funzionalità: sì.
completezza: sì, accetta parametri che soddisfano la pre-cond
correttezza: sì, non ci sono particolari vincoli nella pre-cond
garanzie:   nessuna scrittura su a.
semplicità: 2 parametri
tipo di ritorno: banale
*/


//se vuoi risparmiare parametri:
public static <T> void insertIntoOtherSet (Set<? extends T> a, Set<T> b, Set<? super T> c)
/*in questo modo puoi scorrere con object c. puoi aggiungere elementi a c. e gli puoi passare T e sottotipi.
funziona analogamente a quello su. solo che risparmi un parametro S.*/
















/*ho scelto extends su a perchè l'insieme a mi serve solo durante lo scorrimento. visto che gli elementi di a vanno in b
ho pensato che valesse la regola della gerarchia. quindi a può andare in b (immagina dei manager negli employee).
discorso molto simile anche con b e c. quindi c'è questa gerarchia strana tra loro. */
















