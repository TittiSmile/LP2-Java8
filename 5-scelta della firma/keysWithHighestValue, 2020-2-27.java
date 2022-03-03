//pre: accetta una mappa ed un comparatore
//post: ritorna l'insieme delle chiavi che hanno il massimo valore associato secondo comp.(quindi il comparatore confronta i VALORI)

//implementazione BASE
     <K,V> Set<K> keysWithHighestValue(Map<K,V> map, Comparator<V> c){
        Set<K> set = new HashSet<>();
        Collection<V> col = map.values();
        V max=col.iterator().next(); //prendo il primo elemento della collezione. lo uso per "default"
        //volendo, potevi anche fare un ciclo con la collezione e, associazio max = v uscivi con break.

        for(Map.Entry<K,V> entry : map.entrySet()){
            //if(c.compare(entry.getValue(),max)>=0) //condizione SPECULARE. RICORDA di mettere = altrimenti non troverà nessuno 
            if(c.compare(max,entry.getValue())<=0){ //se il primo valore è più piccolo (o uguale) al corrente elemento della mappa...
                max=entry.getValue();   //...allora il massimo risulta essere il valore corrente
                set.add(entry.getKey());    //aggiungo la chiave associata al valore corrente al set.
            }
        }
        return set;
     }




a) <K> Set<K> keysWithHighestValue(Map<K,Object> map, Comparator<Object> c)
/*
funzionalità:	sì, i tipi sono concordi (cioè il set deve avere lo stesso tipo delle K e i V devono avere lo stesso tipo del comp)
completezza:	no. questo perchè V e comp sono di tipo obj
correttezza:	sì (non ci sono particolari limitazioni)
semplicità:		1 param
garanzie:		nessuna
ritorno: 		giusto.
*/

b) <T> Set<T> keysWithHighestValue(Map<T,T> map, Comparator<T> c)
/*
funzionalità:	sì, anche qui i tipi concordano tutti
completezza:	in realtà no. questo perchè anche se possiamo scegliere qualunque T il comparatore è vincolato da T della mappa.
correttezza:	sì
semplicità:		1 param	
garanzie:		nessuna
ritorno: 		giusto
*/

c) <K,V> Set<K> keysWithHighestValue(Map<K,V> map, Comparator<?> c)
/*
funzionalità: no. i problemi arrivano con i confronti tra i valori della mappa e il comparatore. V e ? non concordano. 
completezza:
correttezza:
semplicità:
garanzie:
ritorno: 
*/

d) <V> Set<Object> keysWithHighestValue(Map<?,? extends V> map, Comparator<? super V> c) //MIGLIORE 
/*
funzionalità:	sì. anche se sembrava no, questa firma funziona e forse è pure una delle migliori (con le giuste modifiche).
				partiamo dal set che deve concordare con K della mappa. il ? vuol dire che va bene QUALUNQUE tipo. di conseguenza,
				in un set di object posso metterci di tutto: integer, employee, student eccc...
				per quanto riguarda i valori, invece, va comunque bene. questo perchè il comparatore è sempre su ? super V. e anche se
				passo un oggetto della sottoclasse, il comparatore sarà della superclasse quindi non c'è nessun problema.  
completezza:	sì, posso prendere di tutto
correttezza:	sì
semplicità:		1 parametro
garanzie:		non c'è scrittura sulla mappa e posso leggere object dal comparatore
ritorno: 		un po' troppo restrittivo. posso passare solo un set di object. 
*/

e) <K,V> Set<K> keysWithHighestValue(Map<? super K,? extends V> map, Comparator<? super V> c)
/*
funzionalità:	no. è simile a quella sopra ma abbiamo un problema con le chiavi della mappa. questo perchè, se fisso K=emp, posso
				passare un person come chiave ma il set vuole un employee. non posso aggiungere un person ad un set di employee
				(vale il contrario, al più).
completezza:
correttezza:
semplicità:
garanzie:
ritorno: 
*/




//la migliore secondo me: (simile alla d)
    <K,V> Set<K> keysWithHighestValue(Map< ? extends K,? extends V> map, Comparator<? super V> c) {
        Set<K> set = new HashSet<>();
        Collection<? extends V> col = map.values();
        V max=col.iterator().next();

        for(Map.Entry<? extends K,? extends V> entry : map.entrySet()){
            if(c.compare(max,entry.getValue())<=0){
                max=entry.getValue();
                set.add(entry.getKey());
            }
        }
        return set;
    }

//dà ulteriori garanzie e risulta essere completa. 

//ATTENZIONE!!!! nella firma d, se avessi voluto lasciare ? alla K della mappa, dovevo comunque modificare il tipo di ritorno esempio:
 <K,V> Set<K> keysWithHighestValue(Map<?,? extends V> map, Comparator<? super V> c)  //ERRORE!!!!!
 //questo perchè ? e K possono NON concordare. nel caso della firma d, ? può essere visto come object ma, in più,
 // per qualunque sia ? posso comunque metterlo in un set di object (che contiene di tutto)



















public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 5);map.put("b", 3);map.put("c", 0);map.put("d", 5);
        comparatorClass<Integer> comp = new comparatorClass<>();
        countClass cc = new countClass();
        Set<String> s =cc.keysWithHighestValue(map,comp);
        System.out.println(s);

    }