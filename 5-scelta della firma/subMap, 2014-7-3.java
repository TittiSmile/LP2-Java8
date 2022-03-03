//pre-cond: accetta una mappa ed una collezione.
//post-cond: ritorna una nuova mappa ottenuta restringendo la prima alle sole chiavi che compaiono nella collezione. 
			//il metodo NON modifica i suoi argomenti.

//possibile implementazione: 
public class myClass {
    <K,V> Map<K,V> subMap(Map<K,V> m, Collection<K> c){
        Map<K,V> map = new HashMap<>();
        for(Map.Entry<K,V> entry : m.entrySet()){
            if(c.contains(entry.getKey())){
                map.put(entry.getKey(), entry.getValue());
            }
        }
        return map;
    }
}

a) <K> Map<K,?> subMap(Map<K,?> m, Collection<K> c)
/*
funzionalità: Sì. argomentiamo:
              per come ho svolto l'implementazione, si ha difficoltà ad eseguire il metodo put sulla nuova mappa. ? non dà 
			  la possibilità di scrivere. quindi non è funzionale. E INVECE!!!
              è funzionale perchè ? può essere sostituito come Object tranquillamente. in questo modo si "ovvia" al problema della
              scrittura (quindi funzionalità). però il problema resta sempre col tipo di ritorno. 
completezza: no. la collezione è vincolata da K.
correttezza: sì
garanzie:    no scrittura su value di map
semplicità:  1 param
tipo du ritorno: un po' inutile per il chiamante. si perde info. 

public class myClass {
    <K,V> Map<?,?> subMap(Map<K,?> m, Collection<K> c){
        Map<Object,Object> map = new HashMap<>(); //mettendo 2 object al posto di ? il problema è risolto
        for(Map.Entry<K,?> entry : m.entrySet()){ //qui resta ? perchè è in lettura sulla mappa. 
            if(c.contains(entry.getKey())){
                map.put(entry.getKey(), entry.getValue()); //con 2 obj la scrittura è possibile. MA COME? posso inserire un
                                                           oggetto di tipo K in un object????????
                                                           SI. di base, in una mappa (o collezione) di tipo <Object> puoi ficcarci
                                                           dentro tutto quello che vuoi. object è il supertipo comune a tutti i 
                                                           tipi. (rivedi il paragrafo su assegnabilità vs contenimento)
            }
        }
        return map;
    }
}



*/

b)<K,V> Map<K,V> subMap(Map<K,V> m, Collection<?> c)	//MIGLIORE
/*
funzionalità: sì, riesco a leggere con object la collezione.
completezza:  sì
correttezza:  sì
garanzie:	  non scriviamo sulla collezione e leggiamo al più object.
semplicità:   2 param
tipo di ritorno: giusto. è lo stesso tipo della mappa passata come parametro.
*/

c) <K,V> Map<K,V> subMap(Map<K,V> m, Collection<? super K> c)
/*
funzionalità: sì
completezza:  no. perchè la collection può essere solo di tipo K e supertipi (se K=emp, posso passare col<emp>, col<per> o superiori)
correttezza: sì
garanzie:	 possiamo scrivere sulla collezione c. leggiamo solo object
semplicità:  2 param.
tipo di ritorno: coerente. 
*/

d)<K,V> Map<K,V> subMap(Map<K,V> m, Collection<? extends K> c)
/*
funzionalità: sì
completezza:  no. come per la firma c. qui non posso passare supertipi di K.
correttezza: sì, rispetta la pre-cond.
garanzie:	 non posso scrivere sulla collezione. posso leggerci soltanto.
semplicità:	 2 param
tipo di ritorno coerente.
*/

e)<K,V> Map<K,V> subMap(Map<K,V> m, Set<K> c)
/*
funzionalità: sì. anche se è set. ricorda che l'insieme delle chiavi nella mappa è un set.  
completezza: no, set è comunque vincolato da K
correttezza:  no. la pre-cond parla di collezioni. questo è un set. 
garanzie:	  nessuna.
semplicità:	   2 param.
tipo di ritorno: coerente.
*/

f)<K,V,K2 extends K> Map<K,V> subMap(Map<K,V> m, Collection<K2> c)
/*
funzionalità: sì. è simile alla firma d.
completezza:  no. sulla collezione siamo vincolati da K. 
correttezza:  sì, prende ciò che è richiesto nella pre-condizione.
garanzie:	  nessuna (extends non è nei parametri)
semplicità:	  3 parametri
tipo di ritorno: coerente
*/

















public class Main {

    public static void main(String[] args) {
        myClass mc = new myClass();
        Map<String, Integer> m = new HashMap<>();
        Collection<String> c = new LinkedList<>();
        m.put("a",1);m.put("b",2);m.put("c",3);
        c.add("a");c.add("b");c.add("pp");
        Map<String,Integer> newMap = mc.subMap(m,c);
        System.out.println(newMap);
    }
}
