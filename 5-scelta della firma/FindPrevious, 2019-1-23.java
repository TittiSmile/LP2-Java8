FindPrevious, 2019-1-23

//pre-cond: accetta un insieme, un comparatore ed un oggetto x
//post-cond: torna il più grande oggetto dell'insieme che è minore di x (secondo comparatore)




/* 	POSSIBILE IMPLEMENTAZIONE (caso base T)


<T> T findPrevious(Set<T> set, Comparator<T> comp, T x){
        List<T> l = new ArrayList<>(set);
        l.add(x);						//decido di aggiungere x alla lista
        Collections.sort(l, comp);		//ordino secondo comparatore
        int a =  l.indexOf(x)-1;		//trovo l'indice dell'elemento subito prima di x nella lista
        for(T t : l){					//scorro la lista
            if( comp.compare(t, x) < 0 ){/controllo. se il valore corrente di t è minore di x (la condizione dell'if dice proprio questo)...
                 return l.get(a);			//...ritorna l'elemento con indice a.
             }
        }
        return null;   //nel caso in cui l'if non è verificato (quindi non c'è nella lista elemento più piccolo di x) allora torna null
    }



*/



a) <T> T findPrevious(Set<? extends T> set, Comparator<?> comp, T x)
/*
funzionalità:	no. il comparatore è di ? mentre il set ed x sono di tipo T. i tipi possono non coincidere
completezza:
correttezza:
garanzie:	
semplicità:	
tipo ritorno:
*/


b) <S,T extends S> T findPrevious(Set<T> set, Comparator<S> comp, T x)
/*
funzionalità:	sì
completezza:	sì, posso scegliere qualunque S (anche se T dipende da S)
correttezza:	sì, non ci sono vincoli nella pre-cond
garanzie:		nessuna
semplicità:		2 param
tipo ritorno:	coerente. mi ritorna l'oggetto di tipo del set.
*/


c) <S,T extends S> S findPrevious(Set<S> set, Comparator<T> comp, S x)
/*
funzionalità:	no. non posso avere il comparatore della sottoclasse. 
completezza:
correttezza:
garanzie:	
semplicità:	
tipo ritorno:
*/


d) <T> T findPrevious(Set<T> set, Comparator<? super T> comp, T x)	//MIGLIORE TRA LE PROPOSTE 
/*
funzionalità:	sì
completezza:	sì
correttezza:	sì
garanzie:		posso scrivere sul comparatore e leggo object dal comparatore
semplicità:		1 param.
tipo ritorno:	coerente
*/


e) <T> T findPrevious(Set<T> set, Comparator<T> comp, T x)
/*
funzionalità:	sì
completezza:	sì
correttezza:	sì
garanzie:		no
semplicità:		1 param
tipo ritorno:	coerente
*/


f) <T> T findPrevious(Set<? super T> set, Comparator<T> comp, T x)
/*
funzionalità:	no. questo perchè ? super T viene letto come object. quindi, si avranno problemi con il comparatore
				perchè non posso confrontare object con un T. 
completezza:
correttezza:
garanzie:	
semplicità:	
tipo ritorno:


*/



//firma migliore fatta da me:
<T> T findPrevious(Set<? extends T> set, Comparator<? super T> comp, T x)
//dà una maggiore garanzia al set. non permette la scrittura.
/*
<T> T findPrevious(Set<? extends T> set, Comparator<? super T> comp, T x){
        List<T> l = new ArrayList<>(set);
        l.add(x);
        Collections.sort(l, comp);
        int a =  l.indexOf(x)-1;
        for(T t : l){
            if( comp.compare(t, x) < 0 ){
                 return l.get(a);
             }
        }
        return null;
    }
*/