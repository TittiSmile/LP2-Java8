MakeMap 2018-6-20

//pre-cond: il metodo deve accettare una lista di chiavi ed una lista di valori (stessa lunghezza) (le liste già piene)
//post-cond: ritorna una mappa che accoppia ogni elemento della prima lista alla seconda lista
//ESEMPIO: l1= 1,2,3	l2=5,9,3	Map(K,V)={1=5, 2=9, 3=3}

/* Possibile implementazione

    <K,V> Map<K,V> makeMap(List<K> keys, List<V> vals){
        Map<K,V> m = new HashMap<>();   //creo una nuova mappa. 

        if(keys.size() != vals.size() ){    
            throw new IllegalArgumentException("liste di dimensioni diverse"); 
        }
        
        for(int i=0; i<keys.size(); i++){   //visto che le liste sono della stessa dimensione, ne scorro una 
            m.put(keys.get(i), vals.get(i));    //poi aggiungo entrambi i valori. 
        }
        return m;

        //piccola postilla. per il FOR meglio usare un ITERATORE esplicito. questo perchè se le liste sono di tipo LL
        //il tempo di scorrimento diventa quadratico. dovrò provare a fare un'implementazione del genere...

        //********************ITERATORE ESPLICITO?
                            //int i =0;
                            //Iterator<K> it = keys.iterator();
                            //while(it.hasNext() ){
                               // K listK = it.next();
                               // V listV = vals.get(i);
                               // m.put(listK, listV);
                               // i++;
                            }
                            
    }

    public static void main(String[] args) {
        List<Integer> k = new ArrayList<>();
        List<String> v = new ArrayList<>();
        Map <Integer, String> map = new HashMap<>();
        Main m = new Main();
        k.add(1);k.add(6);k.add(7);
        v.add("a");v.add("y");v.add("p");
        map=m.makeMap(k, v);
        System.out.println(map);
    }
*/



a) <K,V> Map<? extends K,? extends V> makeMap(List<K> keys, List<V> vals)
/*
funzionale:   sì. anche se la mappa è di ritorno è ? extends puoi dichiarare una mappa del tipo K,V 
               (perchè sono sottotipo di ? extends K/V). il problema è per il chiamante (tipo di ritorno) NON per la funzionalità. 
               se puoi ritornare il metodo con quei parametri (K e V) allora è funzionale.
completezza:  sì
correttezza:   sì
garanzie:      no
semplicità:    2 param
tipo ritorno:   inutile per il chiamante.    è generico per il chiamante.  l'inutilità per il chiamante NON intacca la funz.
*/

/*esempio di implementazione 
<K,V> Map<? extends K,? extends V> makeMap(List<K> keys, List<V> vals){
        Map<K,V> m = new HashMap<>();   //per quel tipo di ritorno, non c'è problema a dichiarare così la mappa.
                                        //K e V sono il sottotipo di loro stessi. sono compresi nel ? extends

        if(keys.size() != vals.size() ){
            throw new IllegalArgumentException("liste di dimensioni diverse");
        }
        
        for(int i=0; i<keys.size(); i++){
            m.put(keys.get(i), vals.get(i));
        }
        return m;
    }

    //il problema sarà quando farò nel main: 
    map=m.makeMap(k, v); //si perde l'informazione sul tipo di ritorno
*/



b) <K,V> Map<? extends K,?> makeMap(List<K> keys, List<?> vals)
/*
funzionalità: sì. la lista ? viene vista come object (quindi qualunque tipo). il ? come tipo di ritorno, può ritornare 
              qualunque cosa. quindi non c'è problema. il problema è al più per il chiamante.
completezza:  sì, accetta tutto
correttezza:  sì
garanzie:      solo lettura di object per vals
semplicità:    1 param
tipo ritorno:  si perde informazione sul tipo. non posso richiamare il metodo


la funzionalità risponde alla domanda: è possibile fare questo metodo con quella firma? se è no, vuol dire che non riesci ad immaginarti
una mappa per questa firma. in realtà non è così. puoi farlo. è funzionale 
*/

/* esempio di impleemntazione 
 <K,V> Map<? extends K,?> makeMap(List<K> keys, List<?> vals){
        Map<K,Object> m = new HashMap<>();   //creo una nuova mappa. 

        if(keys.size() != vals.size() ){    
            throw new IllegalArgumentException("liste di dimensioni diverse"); 
        }
        
        for(int i=0; i<keys.size(); i++){  
            m.put(keys.get(i), vals.get(i));    
        }
        return m;

1-posso creare una mappa di k, obj? sì
2- posso scorrere una lista di ? (se sì con quale parametro)? sì con obj
3- posso fare la put con k e obj? sì, non c'è problema
*/




c) <K,V> Map<K,V> makeMap(List<K> keys, List<?> vals)
/*
funzionalità:  no. ? non è V. il loro tipo non concorda. ? viene letto come object. prometto di ritornare un oggetto di tipo V
                ma in input non ho lo stesso valore (ho ?)
completezza:  
correttezza:   
garanzie:      
semplicità:    
tipo ritorno:  
*/


d) <T> Map<T,T> makeMap(List<? extends T> keys, List<? extends T> vals)
/*
funzionalità:  sì
completezza:   sì.ATTENZIONE ai controesempi!!!! chiaramente, se specifichi il T che ti fa comodo, non troverai mai il controesempio giusto
               ma se al posto di T=emp usassi T=object? vedresti che c'è completezza. puoi prendere qualunque lista.     
correttezza:   sì
garanzie:      non posso scrivere sulle due liste.
semplicità:    1 param.
tipo ritorno:  valore per T troppo generico. o meglio. nel caso in cui T=obj posso limitarmi a restituire solo delle liste di obj.
                costringe un T generico. il tipo di ritorno è ok ma T è generico. se chiave e valore non sono imparentate, sono 
                costretta  mettere obj come T 
*/

e) <K> Map<K,?> makeMap(List<K> keys, List<Object> vals)
/*
funzionalità sì.
completezza  no. la lista di obj mi limita a passare una lista di object :D non posso passarci una lista di emp o di string.
             sono limitata ad obj.se vuoi riutilizare vals devi ridefinire una lista con un altro tipo e questa cosa non ha 
             molto senso
correttezza   sì
garanzie      
semplicità    
tipo ritorno  ? è restrittivo per il chiamante quindi ci sono problemi quando si richiama il metodo. 
*/



f) <K, V extends K> Map<K,V> makeMap(List<K> keys, List<V> vals)
/*
funzionalità  sì
completezza   no. immagina questo: la pre-cond dice di poter prendere due liste qualsiasi. quindi, se passassi una lista di emp
              e una lista di string, posso farlo con questa firma?
              NO. questo perchè, da come sono specificati K e V, V deve essere necessariamente sottoclasse di K ma abbiamo trovato
              un esempio dove questo non è possibile.
              completezza vuol dire: non riesco a passare tutto quello che vorrei. ma le cose che riesco a passare hanno un tipo di ritorno
              giusto? conserva le infor che ho passato?
correttezza   sì
garanzie      nessuna
semplicità    2 param
tipo ritorno  coerente
*/


//firma migliore per me:
<K,V> Map<K,V> makeMap(List<? extends K> keys, List<? extends V> vals)  
//scriviamo sulla mappa di ritorno e diamo garanzie di scrittura soltanto sulle liste. 




