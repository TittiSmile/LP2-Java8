//pre-cond:	accetta una mappa m
//post-cond: ritorna una nuova mappa ottenuta invertendo chiavi con valori. se m ha valori duplicati, il metodo lancia eccezione
			 // il metodo non modifica la mappa m.

//implementazione BASE
<K,V> Map<V,K> inverseMap(Map<K,V> m){
        Map<V,K> newMap = new HashMap<>(); //nuova mappa di ritorno
        Collection<V> mapValues = new LinkedList<>(m.values()); //collezione che contiene i valori della mappa m
        Map<V, Integer> mapOccurrences = new HashMap<>(); //mappa di "appoggio" che tiene conto delle occorrenze di un valore
        Integer cont = 0; //contatore per le occorrenze
        
        for(V v : mapValues){
            cont = mapOccurrences.get(v); //imposto l'occorrenza come prima chiave della mappa. 
            if(cont==null){ //vuol dire che non c'è quella chiave nella mappa
                mapOccurrences.put(v,1);
            }
            else{ //altrimenti vuol dire che c'è almeno 1 occorrenza. 
                mapOccurrences.put(v,cont+1);
            }
        }

        for(Map.Entry<V,Integer> entry : mapOccurrences.entrySet()){ //scorro la mappa delle occorrenze
            if(entry.getValue() > 1){ //se il valore è maggiore di 1 vuol dire che ci sono più occorrenze
                throw new IllegalArgumentException("ci sono più occorrenze di valori"); //si lancia eccezione
            }
        }

        for(Map.Entry<K,V> entry : m.entrySet()){ //se arrivo qui vuol dire che m non ha valori duplicati
            newMap.put(entry.getValue(),entry.getKey()); //posso finalmente creare la mappa di ritorno. 
        }

        return newMap;
}




a) <K,V> Map<V,K> inverseMap(Map<?,?> m)
/*
funzionalità: no. si hanno problemi con la creazione della nuova mappa. infatti, m è di tipo ? ? mentre newMap è di tipoi V K.
			  se V e K sono diversi da ? ? non c'è possibilità di fare la put.
completezza:
correttezza:
garanzie:
semplicità:
tipo di ritorno
*/


b) Map<?,?> inverseMap(Map<?,?> m)
/*
funzionalità: no. non posso fare la put nella mappa di ritorno.
completezza:
correttezza:
garanzie:
semplicità:
tipo di ritorno:
*/


c) <K,V> Map<K,V> inverseMap(Map<V,K> m)
/*
funzionalità: sì
completezza:  sì
correttezza:  sì
garanzie:	  nessuna
semplicità:   2 param
tipo di ritorno: coerente. 
*/


d) <K,V> Map<K,V> inverseMap(Map<? extends V, ? super K> m)
/*
funzionalità: no. il problema sta nella entry.getValue della mappa di ritorno.
			  questo perchè sto mettendo un ? super K (letto come object) in un K.  
completezza:
correttezza:
garanzie:
semplicità:
tipo di ritorno:
*/


e) <K,V> Map<K,V> inverseMap(Map<K,V> m)
/*
funzionalità: no. non riesco a fare la put sulla nuova mappa perchè K e V non coincidono con
			  la mappa di ritorno (devono essere scambiati)
completezza:
correttezza:
garanzie:
semplicità:
tipo di ritorno:
*/


f) <K,V> Map<K,V> inverseMap(Map<? extends V, ? extends K> m) //MIGLIORE
/*
funzionalità: sì
completezza:  sì
correttezza:  sì, non ci sono particolari vincoli nella pre-cond
garanzie:     non si può scrivere sulla mappa m
semplicità:   2 parametri
tipo di ritorno: coerente
*/





//IMPLEMENTAZIONE
package com.company;
import java.util.*;
public class myClass {

    <K,V> Map<V,K> inverseMap(Map<? extends K, ? extends V> m){
        Map<V,K> newMap = new HashMap<>();
        Collection<V> mapValues = new LinkedList<>(m.values());
        Map<V, Integer> mapOccurrences = new HashMap<>();
        Integer cont = 0;
        for(V v : mapValues){
            cont = mapOccurrences.get(v);
            if(cont==null){ //vuol dire che non c'è quella chiave nella mappa
                mapOccurrences.put(v,1);
            }
            else{
                mapOccurrences.put(v,cont+1);
            }
        }
        for(Map.Entry<V,Integer> entry : mapOccurrences.entrySet()){
            if(entry.getValue() > 1){
                throw new IllegalArgumentException("ci sono più occorrenze di valori");
            }
        }

        for(Map.Entry<? extends K, ? extends V> entry : m.entrySet()){
            newMap.put(entry.getValue(),entry.getKey());
        }

        return newMap;
    }


    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Map<Integer,String> newMap = new HashMap<>();
        myClass mc = new myClass();
        map.put("a",1);map.put("b",2);map.put("c",3);//map.put("d",1); map.put("e",1);
        System.out.println(map);
        newMap= mc.inverseMap(map);
        System.out.println(newMap);

    }

}









