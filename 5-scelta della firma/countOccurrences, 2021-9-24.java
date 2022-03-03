//pre: accetta una collezione
//post: ritorna una mappa che, ad ogni oggetto della collezione, associa il numero di ripetizioni presenti

    <K> Map<K,Integer> countOccurrences(Collection<K> c){
        Map<K, Integer> map = new HashMap<>();
        Integer cont = null;
        for(K k : c){
           cont=map.get(k);
            if(cont==null){
                map.put(k,1);
            }
            else{
                map.put(k,cont+1);
            }
        }
        return map;
    }



a) <K> Map<? extends K,Integer> countOccurrences(Collection<Object> c)
/*
funzionalità:  no. la collezione è di object. la mappa è dichiarata di tipo K. non posso inserire un object in una mappa di K.
               K potrebbe essere qualunque tipo (anche Employee. non posso mettere un object in un employee)
completezza:
correttezza:
semplicità:
garanzie:
ritorno: 
*/


b) <K> Map<? extends K,Integer> countOccurrences(Collection<? super K> c)
/*
funzionalità:  no. devo poter scorrere la collezione con un tipo che equivale a quello della mappa di ritorno. 
               se la collezione è di object non posso scorrere con un oggetto di tipo integer (posso fare il contrario). 
completezza:
correttezza:
semplicità:
garanzie:
ritorno: 
*/


c) Map<Object,Integer> countOccurrences(Collection<Object> c)
/*
funzionalità:  sì
completezza:   no perchè abbiamo solo object
correttezza:   sì
semplicità:    0 param
garanzie:      nessuna
ritorno:       un po' limitato (posso avere solo una mappa di object)
*/

d) <S,T extends S> Map<S,Integer> countOccurrences(Collection<T> c)
/*
funzionalità:  sì. posso scorrere, eventualmente, con S la collezione c (questo perchè T è sottotipo di S).
completezza:   sì. ok che T è vincolato da S ma posso scegliere qualunque S (e quindi qualunque T)
correttezza:   sì
semplicità:    2 param
garanzie:       nessuna
ritorno:        coerente
*/

e) <K> Map<? super K,Integer> countOccurrences(Collection<? extends K> c)
/*
funzionalità:  sì. è simile alla d.
completezza:   sì
correttezza:   sì
semplicità:    1 param
garanzie:      no scrittura sulla collezione, scrittura sulla mappa, leggo solo object.
ritorno:       dà problemi al chiamante. si perde informazione sulla mappa.
*/

//MIGLIORE:
<K> Map<K,Integer> countOccurrences(Collection<? extends K> c)


f) Map<Object,Integer> countOccurrences(Collection<?> c)
/*
funzionalità:  sì. la collezione viene fatta scorrere con object (stesso tipo della mappa) quindi non c'è problema.
completezza:   sì, posso scegliere qualunque tipo per la collezione
correttezza:   sì
semplicità:    0 param
garanzie:       nessuna
ritorno:        troppo specifico su object. 
*/






public static void main(String[] args) {
        countClass cc = new countClass();
        Collection<String> c = new LinkedList<>();
        c.add("a");c.add("a");c.add("a");c.add("att");
        Map<String,Integer> map = new HashMap<>();
        map=cc.countOccurrences(c);
        System.out.println(map);


    }