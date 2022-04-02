//pre: accetta 3 insiemi (qualsiasi)
//post: ritorna l'insieme degli elementi che appartengono ad a oppure a b ma non a c
 <T> Set<T> foo(Set<T> a, Set<T> b, Set<T> c){
        Set<T> newSet = new HashSet<>();

        for(T t : a){   //suppongo che siano liste della stessa dimensione o qualcosa del genere.
        	//volevo provare a farlo con l'iteratore ma non funge.
            if(b.contains(t) && !(c.contains(t))){
                newSet.add(t);
            }
        }
        return newSet;
    }



a)<T> Set<T> foo(Set<? extends T> a, Set<? extends T> b, Set<? extends T> c)
/*
funzionalità: 	sì
completezza:	sì, posso scegliere qualunque T e sottotipo
correttezza:	sì (non ci sono particolari pre-condizioni)
garanzie:		nessuna scrittura sui set
semplicità:		1 param
ritorno:		coerente. posso aggiungere in un set<T> un oggetto suo sottotipo
*/

b)<T> Set<T> foo(Set<? extends T> a, Set<? extends T> b, Set<?> c) 
/*
funzionalità:	sì, l'importante è che il tipo di ritorno concorda con a e b
completezza:	sì, più di prima
correttezza:	sì
garanzie:		no scrittura sui set
semplicità:		1 param
ritorno:		coerente.
*/

c)<T> Set<? extends T> foo(Set<? extends T> a, Set<? extends T> b, Set<? extends T> c)
/*
funzionalità:	sì 
completezza:	sì
correttezza:	sì
garanzie:		non posso scrivere sui set
semplicità:		1 param
ritorno:		perdiamo informazioni sul tipo. non posso richiamare il metodo. 






*/

d)<T> Set<T> foo(Set<? extends T> a, Set<?> b, Set<?> c) //probabilmente questa è la migliore 
/*
funzionalità:	sì
completezza:	sì anche meglio
correttezza:	sì
garanzie:		nessuna scrittura
semplicità:		1 param
ritorno:		coerente.
*/

e)<T> Set<?> foo(Set<T> a, Set<T> b, Set<T> c)
/*
funzionalità:	sì (anche se il tipo di ritorno è ? posso dichiarare il set di ritorno come obj)
completezza:	no. sono 3 set dello stesso tipo
correttezza:	sì
garanzie:		non c'è scrittura sul set di ritorno
semplicità:		1 param
ritorno:		perdiamo informazione sul tipo. possiamo assegnare al metodo solo obj









*/

f)<T> Set<T> foo(Set<? extends T> a, Set<? extends T> b, Set<? super T> c)
/*
funzionalità:	sì
completezza:	sì
correttezza:	sì
garanzie:		nessuna scrittura su a e b leggo da c
semplicità:		1 param
ritorno:		giusto
*/
