//pre-cond: accetta una mappa ed un comparatore
//post-cond: ritorna vero se ogni chiave è minore o uguale al valore ad essa associato.

/* POSSIBILE IMPLEMENTAZIONE
    <T> boolean isIncreasing(Map<T,T> m, Comparator<T> c){
        for(Map.Entry<T,T> entry: m.entrySet() ){ 		
            if(c.compare(entry.getKey(), entry.getValue()) > 0 ){
                return false;		
            }
        }
        return true; 
    }
*/


a) <K,V> boolean isIncreasing(Map<K,V> m, Comparator<K> c)
/*
funzionalità:	no. si ha problemi con il comparatore. non può avvenire nessun confronto (K e V non coincidono)
completezza:	
correttezza:	
garanzie:	
semplicità: 	
tipo ritorno:	
*/


b) <K,V> boolean isIncreasing(Map<K,V> m, Comparator<? super K> c)
/*
funzionalità:	no. stesso ragionamento di sopra. il comparatore è sulle chiavi (K). K e V sono due tipi diversi (anche se potrebbero
				essere lo stesso tipoo NON conta). non c'è confronto.
completezza:	
correttezza:	
garanzie:	
semplicità: 	
tipo ritorno:	
*/


c) <K,V extends K> boolean isIncreasing(Map<K,V> m, Comparator<? super K> c)
/*
funzionalità:	secondo me no. come faccio il confronto tra superclasse e sottoclass? volendo si può fare ma bisogna cercare i    
                giusti criteri di uguaglianza (carta e penna). e comunque va ridefinito nella sottoclasse quindi comunque non ci
                troviamo :D
completezza:	
correttezza:	
garanzie:	
semplicità: 	
tipo ritorno:	
*/






d) <T> boolean isIncreasing(Map<T,T> m, Comparator<T> c)
/*
funzionalità:	sì
completezza:	no, la pre-cond dice una mappa ed un comparatore qualunque. qua siamo vincolati da T. 
correttezza:	sì
garanzie:	    nessuna
semplicità: 	1 param
tipo ritorno:	banale
*/

e) <T> boolean isIncreasing(Map<T,T> m, Comparator<? extends T> c)
/*
funzionalità:	no. il comparatore è sui sottotipi di T. non va bene. 
completezza:	
correttezza:	
garanzie:	
semplicità: 	
tipo ritorno:	
*/

f) <T> boolean isIncreasing(Map<? extends T, ? extends T> m, Comparator<T> c)
/*
funzionalità:	sì
completezza:	tecnicamente, possiamo scegliere qualsiasi T e sottotipo. quindi, per T=object possiamo prendere 
                tutti i tipi che vogliamo. quindi sì, è completa. 
correttezza:	sì
garanzie:	    non c'è scrittura sulla mappa.
semplicità: 	1 param
tipo ritorno:	banale
*/

g) boolean isIncreasing(Map<?,?> m, Comparator<?> c)
/*
DUBBIO
funzionalità:	no. il problema è il ? che non ci dice nulla sui tipi. tecnicamente viene letto come object. però, appunto, 
                posso usare il comparatore di object con due tipi distinti e separati? immagina K=integer V=string. il comparatore
                è su object. 
completezza:	
correttezza:	
garanzie:	
semplicità: 	
tipo ritorno:	
*/


//firma migliore per me:
<T> boolean isIncreasing(Map<? extends T, ? extends T> m, Comparator<? super T> c)
//ci dà garanzia sul comparatore (ci legge al più object).



















/* IMPLEMENTAZIONE COMPLETA
public class Main
{
    <T> boolean isIncreasing(Map<T,T> m, Comparator<T> c){
        for(Map.Entry<T,T> entry: m.entrySet() ){ 		//uso entry. in questo modo posso scorrere facilmente sulla mappa
            if(c.compare(entry.getKey(), entry.getValue()) > 0 ){ //se anche solo 1 chiave è maggiore di un valore...
                return false;		//...ritorna falso
            }
        }
        return true; //in tutti gli altri casi (cioè quando le chiavi sono più piccole dei valori) ritorna vero.
    }
    
	public static void main(String[] args) {
	    Main mm = new Main();
		Map<Integer,Integer> m = new HashMap<>();
		mapComparator<Integer> comp = new mapComparator();
		m.put(1, 81);m.put(2,29);m.put(3, 80);
		System.out.println(mm.isIncreasing(m,comp));
		
	}
}

class mapComparator<T extends Comparable<T>> implements Comparator<T>{
    @Override
    public int compare(T a, T b){
        return a.compareTo(b);
    }
}
*/