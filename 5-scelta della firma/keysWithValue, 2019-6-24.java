//pre: accetta una mappa, un valore ed una lista
//post: inserisce nella lista tutte le chiavi della mappa che hanno quel valore associato
   <K,V> void keysWithValue(Map<K,V> m, V value, List<K> out){
        for(K k : m.keySet()){ //scorro sulle chiavi della mappa
            if(value.equals(m.get(k))){	//se il valore del parametro è uguale a quello associato alla chiave...
                out.add(k);				//aggiungo alla lista.
            }
        }
        //System.out.println(out); //stampo solo per vedere se fa quel che deve.
    }








a) <K,V> void keysWithValue(Map<K,V> m, V value, List<K> out)
/*
funzionalità:	sì
completezza:	no, sono vincolata dagli stessi tipi di valori.
correttezza:	sì
garanzie:		nessuna
semplicità:		2 param
ritorno: 		banale
*/

b) <K> void keysWithValue(Map<K,?> m, Object value, List<Object> out)
/*
funzionalità:	sì. anche se la lista è di object e la mappa è di K questo NON è un problema. in una lista di obj posso metterci 
				QUALSIASI tipo. anche un K qualunque.
completezza:	no, il valore e la lista sono di obj
correttezza:	sì
garanzie:		non posso scrivere sul valore della mappa
semplicità:		1 param
ritorno: 		banale
*/

c) <K,V> void keysWithValue(Map<? extends K,V> m, V value, List<K> out) //MIGLIORE
/*
funzionalità:	sì (simile alla a)
completezza:	sì. per la mappa posso scegliere K e sottotipi. quindi va bene anche per la lista 
				(che potrebbe accettare,al più, un suo sottotipo)
correttezza:	sì
garanzie:		non scrivo sulla K della mappa
semplicità:		2 param
ritorno: 		banale
*/

d) <K,V> void keysWithValue(Map<? extends K,V> m, V value, List<? extends K> out)
/*
funzionalità:	no. non posso fare la scrittura sulla lista.
completezza:
correttezza:
garanzie:
semplicità:
ritorno: 
*/

e) <V> void keysWithValue(Map<?,V> m, V value, List<?> out)
/*
funzionalità:	no. non posso scrivere sulla lista.
completezza:
correttezza:
garanzie:
semplicità:
ritorno: 
*/

f) <K> void keysWithValue(Map<K,?> m, Object value, LinkedList<? super K> out)
/*
funzionalità:	sì. anche se abbiamo ? il valore è dichiarato come object quindi va bene. 
completezza:	sì
correttezza:	no. stiamo prendendo una LL quando la traccia chiede una semplice list
garanzie:		non scrivo sul V della mappa e leggo obj dalla lista
semplicità:		1 param
ritorno: 		banale
*/
































    public static void main(String[] args) {
        MyClass m = new MyClass();
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"a");map.put(3,"v");map.put(14,"a");
        String a = "a";
        List<Integer> l = new LinkedList<>();
        m.keysWithValue(map,a,l);
    }    