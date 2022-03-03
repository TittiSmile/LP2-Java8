//pre: accetta un iterable e un comparatore
//post: ritorna l'elemento massimo presente nell'iterable secondo comparatore

<T> T getMax (Iterable<T> i, Comparator<T> c){
        T max = i.iterator().next(); //è il primo elemento dell'iterable
        for( T t : i){
            if(c.compare(t,max)>0){
                max=t;
            }
        }
        return max;
    }



a)<T> T getMax (Iterable<? extends T> i, Comparator<T> c) //MIGLIORE (anche se sarebbe meglio mettere ? super T)
/*
funzionalità:	sì
completezza:	sì. questo perchè i comparatori devono per forza avere a che fare qualcosa con il tipo da confrontare sennò
				non ha senso :D quindi, posso scegliere qualunque T e va bene così 
correttezza:	sì
garanzie:		non scrivo su iterable
semplicità:		1 paramebtro
ritorno			giusto
*/

b)<T> T getMax (Iterable<? extends T> i, Comparator<? extends T> c)
/*
funzionalità:	no. il problema è il confronto col comparatore. ? extends T col comparatore è la cosa peggiore
completezza:
correttezza:
garanzie:
semplicità:
ritorno
*/

c)<T> T getMax (Iterable<T> i, Comparator<?> c)
/*
funzionalità:	no. il confronto è con comparator. questa cosa non va. ? è un tipo diverso da T.
completezza:
correttezza:
garanzie:
semplicità:
ritorno
*/

d)Object getMax (Iterable<?> i, Comparator<?> c)
/*
funzionalità:	no. stesso discorso di sopra. non funziona il confronto. ? può essere qualunque tipo. non è detto che
				iter e comp siano concordi. come faccio a confrontare, ad esempio, un comparatore<emp> con un iter<student>?
				non si può
completezza:	
correttezza:
garanzie:
semplicità:
ritorno
*/

e)<T> T getMax (Iterable<T> i, Comparator<? extends T> c)
/*
funzionalità:	no. identico alla b. il comparatore NON va bene.
completezza:
correttezza:
garanzie:
semplicità:
ritorno
*/

f)<T,S> S getMax (Iterable<S> i, Comparator<T> c)
/*
funzionalità:	no. sono due tipi totalmente diversi e sconnessi tra loro. non va bene
completezza:
correttezza:
garanzie:
semplicità:
ritorno
*/




























































public class MyClass {
    <T> T getMax (Iterable<? extends T> i, Comparator<? super T> c){ //migliore tra quelle proposte
        T max = i.iterator().next();
        for( T t : i){
            if(c.compare(t,max)>0){
                max=t;
            }
        }
        return max;
    }
}

class comparatorClass<T extends Comparable<T>> implements Comparator<T>{
    @Override
    public int compare(T a, T b){
        return a.compareTo(b);
    }
}

class iterableClass<T> implements Iterable<T>{
    private Collection<T> col = new LinkedList<>();
    iterableClass(){}
    void add(T elem){
        col.add(elem);
    }

    @Override
    public Iterator<T> iterator(){
        return col.iterator();
    }
    @Override
    public String toString(){
        return col.toString();
    }
}
