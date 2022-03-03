extractPos, 2014-3-5

//pre-cond:		accetta una lista ed un numero n
//post-cond:	ritorna l'ennesimo numero della lista

/* implementazione base
	<T> T extractPos(List<T> l, int n){
        l = new ArrayList<T>(l);
        for(int i = 0; i<l.size(); i++){
            return l.get(n);
        }
        return null;
    }

*/



a) Object extractPos(Collection<?> l, int n)
/*
funzionalità:	no. al di là del fatto che collection può essere implementato anche da una classe che non è list. io non posso
				scrivere sulla collezione in quanto ho ?.
completezza:
correttezza:
garanzie:	
semplicità:	
tipo ritorno:

*/

b) <T> T extractPos(List<T> l, int n)	//MIGLIORE. 
/*
funzionalità:	ok
completezza:	sì
correttezza:	ok
garanzie:		nessuna
semplicità:		1 param
tipo ritorno:	coerente
*/

c) <T> T extractPos(List<? extends T> l, int n)
/*
funzionalità:	no. mi impedisce di scrivere sulla lista. non posso fare la new. 
completezza:	
correttezza:	
garanzie:		
semplicità:		
tipo ritorno:	 


*/

d) Object extractPos(List<?> l, int n)
/*
funzionalità:	no. è come la A. anche se è list non posso scriverci su.  
completezza:	
correttezza:	
garanzie:		
semplicità:		
tipo ritorno:	

*/

e) <T> T extractPos(LinkedList<T> l, int n)
/*
funzionalità:	ok
completezza:	sì
correttezza:	ok
garanzie:		nessuna. forse LL è limitante come parametro. 
semplicità:		1 param
tipo ritorno:	giusto
*/

f) <S,T> S extractPos(List<T> l, int n)
/*
funzionalità:	no. la lista è di T ma mi deve ritornare un S.  S e T potrebbero NON coincidere
completezza:
correttezza:
garanzie:
semplicità:
tipo ritorno:
*/
