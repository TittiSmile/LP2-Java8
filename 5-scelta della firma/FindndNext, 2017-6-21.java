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


 


