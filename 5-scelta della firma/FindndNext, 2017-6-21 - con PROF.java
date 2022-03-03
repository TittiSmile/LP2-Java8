FindndNext, 2017-6-21
//pre-cond:		accetta un set, un comparator ed x
//post-cond:	ritorna il più piccolo oggetto dell'insieme che è maggiore di x (secondo comparator)  

/*	IMPLEMENTAZIONE BASE
    <T> T FindNext(Set<T> set, Comparator<T> comp, T x){ //è inutile mettere <T extends Comparable<T>> all'inizio. hai il comparatore!
        ArrayList<T> l = new ArrayList<>(set);
        Collections.sort(l, comp);

        for(int i = 0; i< l.size(); i++){
            if(comp.compare(l.get(i), x) > 0) {
                return l.get(i);
            } 
        }
        return null;
    }


//dichiaro anche il comparatore
class CompareObjects <T extends Comparable<T>> implements Comparator<T> {
    
    @Override
    public int compare(T a, T b){
        return a.compareTo(b);
    }
}
*/




a) <T> T FindNext(Set<? extends T> set, Comparator<?> comp, T x)
/*
funzionalità:	no. il comparatore potrebbe non accettare dei set di T. questo perchè il comparatore è di ? quindi prende al più
				object. non posso confrontare oggetti diversi. 
completezza:	
correttezza:	
garanzie:		
semplicità:		
tipo ritorno:	
*/


b) <S,T extends S> T FindNext(Set<T> set, Comparator<S> comp, T x)
/*
funzionalità:	sì, x e set sono correlati e il comparatore è della superclasse
completezza:	sì, anche se T è vincolato da S posso scegliere qualunque S. 
correttezza:	sì, 
garanzie:		nessuna
semplicità:		2 param
tipo ritorno:	coerente
*/



c) <S,T extends S> S FindNext(Set<S> set, Comparator<T> comp, S x)
/*
funzionalità:	no perchè il comparatore è sulla sottoclasse. non posso accedere al comparatore della sottoclasse.
				non posso confrontare due oggetti della superclasse con il comparatore della sottoclasse.
completezza:
correttezza:
garanzie:
semplicità:
tipo ritorno:
*/


d) <T> T FindNext(Set<T> set, Comparator<? super T> comp, T x) //MIGLIORE
/*
funzionalità:	sì
completezza:	sì
correttezza:	sì, prende solo i valori corretti (cioè T)
garanzie:		leggo solo object da comp. nella peggiore delle ipotesi prendo il comp di object. 
semplicità:		1 param
tipo ritorno:	coerente
*/



e) <T> T FindNext(Set<T> set, Comparator<T> comp, Object x)
/*
funzionalità:	no. il comparatore è su T mentre l'oggetto è su object. chiaramente, il compare non funziona perchè non posso
				confrontare un T con un object. potrebbero essere lo stesso tipo ma T potrebbe anche differire.
completezza:
correttezza:
garanzie:
semplicità:
tipo ritorno:
*/


//firma migliore secondo me:
<T> T FindNext(Set<? extends T> set, Comparator<? super T> comp, T x)
//dà una maggiore garanzia. non permette la scrittura su set.

/*
    <T> T FindNext(Set<? extends T> set, Comparator<T> comp, T x){
        ArrayList<T> l = new ArrayList<>(set);
        Collections.sort(l, comp);
        
        for(int i = 0; i< l.size(); i++){	//cambia for
            if(comp.compare(l.get(i), x) > 0) {
                return l.get(i);
            } 
        }
        return null;
    }



*/


    

/*	IMPLEMENTAZIONE SPIEGATA. (usando il tipo T generico)

import java.util.*;
public class Main
{
    <T extends Comparable<T>> T FindNext(Set<T> set, Comparator<T> comp, T x){ //T estende comparable perchè deve trovare massimo/minimo.
        ArrayList<T> l = new ArrayList<>(set); //mi appoggio ad una lista...
        Collections.sort(l, comp);				//... così posso chiamare il comparatore facendo il sort
        
        for(int i = 0; i< l.size(); i++){		//ciclo sulla lista.
            if(comp.compare(l.get(i), x) < 0) {	//se l'oggetto i è più piccolo di x...
                return l.get(i);				//allora abbiamo trovato quello giusto
            } 
        }
        
        //IN ALTERNATIVA AL FOR DI SOPRA: (funziona alla stessa maniera)
        // for(T t : l){
          //  if(comp.compare(t, x) < 0){
            //    return t;
           // }
       // }


        
        return null;						//altrimenti ritorna null a prescindere.
        
    }
	public static void main(String[] args) {
		System.out.println("Hello World");
		CompareObjects<Integer> co = new CompareObjects<>();	//è una classe che implementa un comparator -> è un comparatore
		
		Main m = new Main();
		Set<Integer> s = new HashSet<>(); 		//creo il set ed aggiungo elementi
		s.add(5);s.add(10);s.add(7);s.add(2);
		Integer x = 6;
		System.out.print(m.FindNext(s, co, x));		//chiamo la funzione. 
		

	}
}

class CompareObjects <T extends Comparable<T>> implements Comparator<T> { //è un comparatore custom in ordine crescente. 
																	//anche qui t estende comprable di se stesso per poter usare compareTo
    
    @Override
    public int compare(T a, T b){
        return a.compareTo(b);
    }
}



*/



