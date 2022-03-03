//pre-cond: accetta un oggetto x, un comparatore ed un insieme
//post-cond: ritorna true se x, in base al comparatore, è maggiore o uguale di tutti gli oggetti contenuti nell'insieme. sennò false

public class myClass{
    <T> boolean isMax(T x, Comparator<T> c, Set<T> s){
        for(T t : s){
            if(c.compare(t,x)>0){
                return false;
            }
        }

        return true;
    }
}

class compareObjects<T extends Comparable<T>> implements Comparator<T>{
    @Override
    public int compare(T o1, T o2){
        return o1.compareTo(o2);
    }
}




a) boolean isMax(Object x, Comparator<Object> c, Set<Object> s)
/*
funzionalità: sì, il comparatore è dello stesso tipo del set e dell'oggetto.
completezza:  no. siamo limitati da object
correttezza:  sì
garanzie:     nessuna
semplicità:   0 param
tipo di ritorno: banale
*/

b) <T> boolean isMax(T x, Comparator<T> c, Set<T> s)
/*
funzionalità: sì
completezza:  no (sono tutti dello stesso tipo)
correttezza:  sì
garanzie:     nessuna
semplicità:   1 param
tipo di ritorno: banale
*/

c) <T> boolean isMax(T x, Comparator<? super T> c, Set<T> s) //MIGLIORE 
/*
funzionalità:  sì,come la b
completezza:   no (sono tutti vincolati da tutti)
correttezza:   sì
garanzie:	   posso scrivere sul comparatore e leggo al più object
semplicità:    1 param
tipo di ritorno: banale
*/

d) <T> boolean isMax(T x, Comparator<? extends T> c, Set<? super T> s)
/*
funzionalità: no. non va bene il comparatore. è sui sottotipi di t quindi non può esserci confronto
completezza:
correttezza:
garanzie:
semplicità:
tipo di ritorno:
*/

e) <T> boolean isMax(T x, Comparator<? super T> c, Set<? super T> s)
/*
funzionalità: no. ? super T nel set ti impone di scorrere con object. come puoi far funzionare il comparatore? 
              è come se confrontassi un object (dallo scorrimento del set ? super T) e T (tipo di x)
completezza:  
correttezza:
garanzie:
semplicità:
tipo di ritorno:
*/

f) <S,T extends S> boolean isMax(T x, Comparator<? super S> c, Set<S> s)
/*
funzionalità: no. anche se c'è una relazione tra x e s, il comparatore è sempre su s!! quindi non può avvenire nessun confronto
completezza: 
correttezza:
garanzie:
semplicità:
tipo di ritorno:
*/







































public class Main {

    public static void main(String[] args) {
	// write your code here
        myClass m = new myClass();
        Set<Integer> s = new HashSet<>();
        Integer x = 10;
        Comparator<Integer> c = new compareObjects<>();
        s.add(4);s.add(7);s.add(10);//s.add(105);
        System.out.println(m.isMax(x,c,s));

    }
}
