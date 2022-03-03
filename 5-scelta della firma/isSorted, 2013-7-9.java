//pre-cond: accetta una collezione ed un comparatore
//post-cond: ritorna true se la collezione è già ordinata in senso crescente (secondo COMPARATORE), false altrimenti.

//implementazione BASE (tipo parametrico T generico)
<T> boolean isSorted(Collection<T> x, Comparator<T> c){
        List<T> newCol = new LinkedList<>(x); //creo una lista di appoggio che contiene gli elementi della collezione.
        Collections.sort(newCol,c); //ordino la lista d'appoggio
        int i=0; //creo un contatore
        for(T t : x){ //scorro la collezione passata
            if(c.compare(t,newCol.get(i))!=0){ //confronto l'elemento corrente con l'i-esimo elemento della lista d'appoggio
                return false; //se trovo anche solo 1 elemento che non è uguale a 0*** allora ritororno false.
            }
            i++; //incremento il contatore
        }

        return true; //ritorno true se, effettivamente, i confronti sono sempre uguali a 0
    }
//*** ricordo che con compare, quando si ritorna 0, è perchè i due elementi confrontati sono uguali. 



a) boolean isSorted(Collection<?> x, Comparator<Object> c)
/*
funzionalità: no. anche se col codice che ho fatto funziona (cioè sostituisco ? con object durante la lettura del ciclo) il
			  problema è il comparatore. questo perchè collection può avere qualunque tipo mentre il comparator è fisso su
			  object (quindi sarebbe un confronto impossibile). inoltre, il comparator di object NON è efficace in quanto
			  object non implementa il comparable di se stesso. quindi gli object non sono confrontabili tra loro. 
DUBBIO: ma di cosa passa il chiamante è un nostro problema? ad esempio:
		qui il metodo con la mia implementazione funzionerebbe alla grande. basta sostituire T con Object ed il gioco è fatto. però,
		chiaramente, il comparator di object è fallace (object non è confrontabile perchè non implementa il comparable di se stesso
		come avviene per String Integer ecc) e, in più, il fatto che la collezione sia di ? ci permette di passare QUALUNQUE tipo. 
		quindi, accantonando per un attimo la fallacità di comparator<obj>, potremmo ritrovarci a dover confrontare una collezione
		di integer con un comparatore di object e chiaramente sarebbe problematico :D quindi? che fare? 
RISPOSTA? penso che anche la roba del chiamante è un problema nostro altrimenti rip. a quanto pare il comparatore di object non è fallace
		  può andare comunque bene. il problema è che la collezione è di ? (quindi qualunque tipo) ma il comparatore è di object. 
completezza:
correttezza:
garanzie:
semplicità:
tipo di ritorno:

ERRATA CORRIGE: è FUNZIONALE.
funzionalità: sì. la collezione di ? viene definita come di object. posso scriverci e fare confronti. 
completezza: no. il comparatore è su object. 
correttezza: sì
garanzie: leggo object dalla collezione
semplicità: 0 param
tipo di ritorno: banale.





caso d'uso:

    boolean isSorted(Collection<?> x, Comparator<Object> c){
        List<Object> newCol = new LinkedList<>(x);
        Collections.sort(newCol,c);
        int i=0;
        for(Object t : x){
            if(c.compare(t,newCol.get(i))!=0){
                return false;
            }
            i++;
        }

        return true;
    }

*/


b) <S> boolean isSorted(Collection<? extends S> x, Comparator<? super S> c) //MIGLIORE
/*
funzionalità: sì
completezza:  no. anche se posso prendere un S qualunque, comparatore e collezione sono sempre vincolati tra loro. la pre-cond
			  specificava un comparatore ed una collezione generici.
correttezza: sì 
garanzie:	 non scrivo sulla collezione. leggo solo dal comparotre
semplicità:	 1 param
tipo di ritorno: banale
*/

c) <S> boolean isSorted(Collection<S> x, Comparator<S> c)
/*
funzionalità: sì
completezza: no, come sopra. sono l'uno dipendente dall'altro. (per dire: se ho una collezione di Integer il comparatore sarà per forza
			 di integer)
correttezza: sì
garanzie:    nessuna
semplicità:	 1 param
tipo di ritorno: banale
*/


d) boolean isSorted(Collection<Object> x, Comparator<Object> c)
/*
funzionalità: sì
completezza:  no, sono limitata da object
correttezza:  sì
garanzie:	  nessuna
semplicità:   0 param
tipo di ritorno: banale
*/

e) <S, T> boolean isSorted(Collection<S> x, Comparator<T> c)
/*
funzionalità: no. S e T sono dei tipi generici che potrebbero non coincidere. il compilatore non fa partire la sort.
completezza:
correttezza:
garanzie:
semplicità:
tipo di ritorno:
*/

f) <S, T extends S> boolean isSorted(Collection<T> x, Comparator<S> c)
/*
funzionalità: sì, T è una sottoclasse di S. il comparatore è della superclasse quindi va bene
completezza:  no, sono comunque vincolati l'uno dall'altro
correttezza:  sì
garanzie:     nessuna
semplicità:	  2 param
tipo di ritorno: banale
*/




















public class myClass {
    <T> boolean isSorted(Collection<? extends T> x, Comparator<? super T> c){
        List<T> newCol = new LinkedList<>(x);
        Collections.sort(newCol,c);
        int i=0;
        for(T t : x){
            if(c.compare(t,newCol.get(i))!=0){
                return false;
            }
            i++;
        }

        return true;
    }


     public static void main(String[] args) {
        Collection<Integer> col = new LinkedList<>();
        col.add(3);col.add(1);col.add(2);
        //col.add(1);col.add(2);col.add(3);
        Comparator<Integer> comp = new compareCollection<>();
        myClass m = new myClass();
        System.out.println(m.isSorted(col,comp));
    }
}

class compareCollection<T extends Comparable<T>> implements Comparator<T>{

    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }
}


