//pre: accetta due mappe
//post: ritorna una nuova mappa che ha le stesse chiavi della prima e:
		// valore della prima mappa se una chiave è SOLO nella prima mappa
		// valore della seconda mappa se una chiave è ANCHE nella seconda mappa

    <K,V> Map<K,V> overridingMap(Map<K,V> map1, Map<K,V> map2){
        Map<K,V> map = new HashMap<>();
        Set<K> setKey2 = map2.keySet();

        for(Map.Entry<K,V> entry : map1.entrySet()){
            if(!setKey2.contains(entry.getKey())){
                map.put(entry.getKey(), entry.getValue());
            }
            else{
                map.put(entry.getKey(), map2.get(entry.getKey()));
            }
        }
        return map;
    }





a) <K,V> Map<?,?> overridingMap(Map<K,V> map1, Map<K,V> map2)
/*
funzionalità:  sì. 
completezza: sì posso scegliere qualunque tipo
correttezza: sì
semplicità:	 2 param
garanzie:    nessuna. 
ritorno:     si perdono informazioni sul chiamante. posso assegnarci SOLO object. 



*/

b) <K> Map<K,?> overridingMap(Map<K,?> map1, Map<K,?> map2)
/*
funzionalità:  sì. discorso simile a sopra.
completezza:   sì
correttezza:   sì
semplicità:    1 param
garanzie:		sola lettura obj sulle mappe passate come parametro
ritorno: 		è poco corretto per il valore gli posso assegnare solo object
*/

c) <K,V> Map<K,V> overridingMap(Map<K,V> map1, Map<? extends K,?> map2)
/*
funzionalità:  no. questo perchè abbiamo dei problemi nella seconda mappa. 
completezza:
correttezza:
semplicità:
garanzie:
ritorno: 
*/ 

d) <K,V> Map<K,V> overridingMap(Map<K,? extends V> map1, Map<?,? extends V> map2) //MIGLIORE
/*
funzionalità:  sì. 
completezza:   sì, posso scegliere qualunque V e K
correttezza:   sì
semplicità:   2 param
garanzie:     no scrittura sui valori, no scrittura su K della seconda mappa
ritorno:      coerente
*/

e) <K,V> Map<? extends K,V> overridingMap(Map<? super K,V> map1, Map<? super K,V> map2)
/*
funzionalità:  no. questo perchè abbiamo problemi con la mappa di ritorno e la chiave della map1.
				
completezza:
correttezza:
semplicità:
garanzie:
ritorno: 
*/

f) <K> Map<K,Object> overridingMap(Map<K,Object> map1, Map<?,Object> map2)
/*
funzionalità:  sì, è simile alla d.
completezza:	no. V è limiato ad object
correttezza:	sì
semplicità:		1 param
garanzie:		no scrittura sulla K di map2
ritorno: 		troppo specifico. V è object quindi posso passare solo quello. 
*/







        countClass cc = new countClass();
        Map<Integer,String> map1 = new HashMap<>();
        Map<Integer,String> map2 = new HashMap<>();
        Map<Integer,String> map3 = new HashMap<>();
        map1.put(1, "a");map1.put(2,"b");
        map2.put(1, "c");map2.put(2, "d");
        map3=cc.overridingMap(map1,map2);

        System.out.println(map3);