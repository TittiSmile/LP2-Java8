//pre-cond: accetta due mappe
//post-cond: ritorna l'insieme degli oggetti che compaiono come chiavi in entrambe le mappe

/* POSSIBILE IMPLEMENTAZIONE
    <T> Set<T> commonKeys(Map<T,?> m1, Map<T,?> m2){
        Set<T> s = m1.keySet();			
        Set<T> s2 = m2.keySet();		
        Set<T> s3 = new HashSet<>();	
        for(T t : s){					
            if(s2.contains(t)){			
                s3.add(t);				
            }
        }
        return s3;  
    }
*/




a) <T> Set<T> commonKeys(Map<T,?> m1, Map<T,?> m2)
/*
funzionalità:	sì
completezza:	no, chiavi delle mappe sono per forza dello stesso tipo 
correttezza:	sì
garanzie:		nessuna
semplicità: 	1 param
tipo ritorno:	coerente
*/

b) <T,V1,V2> Set<T> commonKeys(Map<T,V1> m1, Map<T,V2> m2)
/*
funzionalità:	sì
completezza:	no (stesso discorso di sopra)
correttezza:	sì
garanzie:		nessuna
semplicità: 	3 parametri (i tipi dei valori sono superficiali)
tipo ritorno:	coerente
*/


c) Set<Object> commonKeys(Map<?,?> m1, Map<?,?> m2) //MIGLIORE
/*
funzionalità:	sì. 
completezza:	sì
correttezza:	sì
garanzie:	    non scrivo sulle mappe (e leggo solo object)
semplicità: 	0 param
tipo ritorno:	un po' troppo specifico. siamo obbligati a far ritornare un set di object.



*/

d) <T> Set<? extends T> commonKeys(Map<? extends T,?> m1, Map<? extends T,?> m2)
/*
funzionalità:	no. per come l'ho inteso io non è possibile. immagina che T=employee. non posso assegnare ad un set di employee
                un set di manager. in più, non è possibile scrivere sul set di ritorno quindi niente add. 
completezza:	 
correttezza:	
garanzie:		
semplicità:		 	
tipo ritorno:	
*/

e) <T> Set<?> commonKeys(Map<T,?> m1, Map<?,?> m2)
/*
funzionalità:	non posso scrivere sulla mappa di ritorno.
completezza:	
correttezza:	
garanzie:	    
semplicità: 	
tipo ritorno:	
*/

















/*implementazione completa

import java.util.*;

public class Main
{
    <T> Set<T> commonKeys(Map<T,?> m1, Map<T,?> m2){
        Set<T> s = m1.keySet();         //creo un nuovo set con le key della prima mappa
        Set<T> s2 = m2.keySet();        //creo un nuovo set con le key della seconda mappa
        Set<T> s3 = new HashSet<>();    //creo un set che mi servirà per il ritorno
        for(T t : s){                   //scorro il primo set
            if(s2.contains(t)){         //se il secondo set contiene il presente elemento (quindi sono in comune)...
                s3.add(t);              //...allora viene aggiunto al nuovo set
            }
        }
        return s3; //ritorno il nuovo set. 
    }
    public static void main(String[] args) {
        System.out.println("Hello World");
        Main mm = new Main();
        Map<Integer, Integer> m = new HashMap<>();
        Map<Integer, Integer> m2 = new HashMap<>();
        m.put(1,2);m.put(13,2);m.put(14,2);
        m2.put(1,2);m2.put(4,2);m2.put(5,2);
        Set<Integer> s = mm.commonKeys(m, m2);
        System.out.println(s);
    }
}




*/