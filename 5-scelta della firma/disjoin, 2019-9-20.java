//pre: accetta due collezioni
//post: rimuove da entrambe tutti gli oggetti in comune. inoltre, ritorna l'insieme degli oggetti rimossi (senza ripetizioni)
<S> Set<S> disjoin(Collection<S> a, Collection<S> b) {
        Set<S> newSet = new HashSet<>();
        Iterator<S> it = a.iterator();
        Iterator<S> it2 = b.iterator();

        while(it.hasNext() && it2.hasNext()){ //scorro su entrambi gli iteratori
            S sa = it.next();  S sb = it2.next();
            if(a.contains(sb) && b.contains(sa)){ //verifico se l'elemento corrente appartiene ad entrambi
                it.remove();                    //elimino i valori correnti
                it2.remove();       
                newSet.add(sa);                 //li agguingo al set. potevo aggiungere anche sb perchè sono uguali. 
            }
        }
        return newSet;
    }



a) <S> Set<S> disjoin(Collection<S> a, Collection<S> b)
/*
funzionalità:	sì
completezza:	no, le collezioni sono vincolate dallo stesso tipo S (devo poter scegliere qualunque tipo)
correttezza:	sì, non ci sono particolari vincoli nella pre-cond
garanzie:		nessuna
semplicità:		1 param	
ritorno: 		coerente
*/

b) <S> Set<S> disjoin(Collection<? extends S> a, Collection<?> b) 	//MIGLIORE
/*
funzionalità:	sì
completezza:	sì, posso scegliere qualunque collezione. in più non sono necessariamente dello stesso tipo (come con a)
correttezza:	sì
garanzie:		nessuna scrittura sulle collezioni
semplicità:		1 param
ritorno: 		giusto. è concorde con la prima collezione. (chiaramente non posso ritornare un set di ?)



<S> Set<S> disjoin(Collection<? extends S> a, Collection<?> b) {
        Set<S> newSet = new HashSet<>();
        Iterator<? extends S> it = a.iterator();
        Iterator<?> it2 = b.iterator();

        while(it.hasNext() && it2.hasNext()){ 
            S sa = it.next();
            Object sb = it2.next(); //object perchè il supertipo
            if(a.contains(sb) && b.contains(sa)){ 
                it.remove();                    
                it2.remove();
                newSet.add(sa);                 
            }
        }
        return newSet;
    }

*/

c) <S,T> Set<? super S> disjoin(Collection<S> a, Collection<T> b)
/*
funzionalità:	sì, anche se i tipi delle collezioni non sono imparentati, funziona.
completezza:	sì
correttezza:	sì
garanzie:		nessuna
semplicità:		2 parametri
ritorno: 		si perde informazione sul tipo di ritorno. quindi non posso richiamare il metodo.
*/

d) Set<Object> disjoin(List<?> a, List<?> b)
/*
funzionalità:	sì
completezza:	sì
correttezza:	no perchè la pre-cond mi dice di passare delle collezioni e qui sto passando delle liste (più specifico)
garanzie:		non c'è scrittura sui parametri
semplicità:		0 param
ritorno: 		troppo specifico. posso ritornare solo un set di object
*/

e) <S> Set<S> disjoin(Collection<? super S> a, Collection<? super S> b)
/*
funzionalità:	no. questo perchè c'è il rischio che le collezioni siano del tipo ? super S e nella add del set (che è di tipo S) non
				posso metterci un supertipo.
completezza:
correttezza:
garanzie:
semplicità:
ritorno: 

<S> Set<S> disjoin(Collection<? super S> a, Collection<? super S> b){
        Set<S> newSet = new HashSet<>();
        Iterator<? super S> it = a.iterator();
        Iterator<? super S> it2 = b.iterator();

        while(it.hasNext() && it2.hasNext()){ 
            Object sa = it.next(); //di tipo object perchè sono i supertipi.
            Object sb = it2.next(); 
            if(a.contains(sb) && b.contains(sa)){
                it.remove();                    
                it2.remove();
                newSet.add(sa);                 //ERRORE. questo perchè sa potrebbe essere un oggetto della superclasse di S
            }
        }
        return newSet;
    }
*/
















/*public static void main(String[] args) {
        MyClass m = new MyClass();
        Collection<Integer> c = new LinkedList<>();
        c.add(1);c.add(14);c.add(11);

        Collection<Object> c2 = new LinkedList<>();
        c2.add(1);c2.add(6);c2.add(11);

        Set<Integer> s = new HashSet<>();

        s=m.disjoin(c,c2);
        System.out.println(s);
    }*/