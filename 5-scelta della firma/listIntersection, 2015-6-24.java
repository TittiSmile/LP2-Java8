//pre-cond: accetta una lista ed un insieme
//post-cond: ritorna una nuova lista che contiene gli elementi della lista che appartengono anche all'insieme (stesso ordine lista)

//implementazione con tipo generico T
public class myClass{

    <T> List<T> listIntersection(List<T> l, Set<T> s){
        List<T> l2 = new LinkedList<>();
        for(T t : l){
            if(s.contains(t)){
                l2.add(t);
            }
        }
        return l2;
    }

}



a) List<?> listIntersection (List<?> l, Set<?> s)
/*
funzionalità: no. la lista l2 diventa di tipo jolly e di conseguenza non ci posso scrivere. !!!!ERRORE!!!!
              è funzionale. questo perchè la nuova lista di ritorno (quella ?) può essere specificata come object.
              posso scorrere la lista come object. quindi posso fare anche la add. il problema resta al chiamante.
completezza:  sì
correttezza:  sì
garanzie:     no scrittura su ? e lettura solo di object per ?
semplicità:   0 param
tipo di ritorno: si perde il tipo di informazione. inutile per il chiamante.




*/


b) List<Object> listIntersection(List<Object> l, Set<?> s)
/*
funzionalità: sì, la lista è di object (come quella di ritorno) quindi non ci sono problemi. se non ci sono elementi contenuti
			  al più mi ritorna null
completezza:  no. tecnicamente siamo abbastanza limitati su list di object. 
correttezza:  sì
garanzie:     leggo object da s e non permetto scrittura
semplicità:	  0 parametri
tipo di ritorno: un po' troppo restrittivo per il chiamante (siamo costretti ad acere una lista di object)
*/

c) <T> List<T> listIntersection(List<T> l, Set<? extends T> s)
/*
funzionalità: sì
completezza:  no. il set è sempre vincolato da T. posso prendere un set fatto di tipo T e sottotipi (di T)
correttezza: sì
garanzie:    non c'è scrittura su s
semplicità:  1 param
tipo di ritorno:  coerente (ha lo stesso tipo della lista)
*/


d) <T> List<T> listIntersection(List<T> l, Set<?> s) //MIGLIORE
/*
funzionalità: sì (anche se il set è di ?). se non trova elementi in comune ritorna al più null.
completezza:  sì perchè posso prendere qualunque lista e set
correttezza:  sì
garanzie:     leggo solo object da s e non c'è scrittura su s
semplicità:   1 param
tipo di ritorno: coerente
*/


e) <S,T> List<T> listIntersection(List<T> l, Set<S> s)
/*
funzionalità: sì (come d solo che abbiamo il parametro S)
completezza:  sì posso scegliere qualunque tipo di S e T
correttezza:  sì
garanzie:     nessuna
semplicità:   2 param
tipo di ritorno: banale
*/











public class Main {

    public static void main(String[] args) {
	// write your code here
        myClass m = new myClass();
        List<Integer> l = new LinkedList<>();
        Set<Integer> s = new HashSet<>();
        l.add(1);l.add(3);l.add(5);l.add(8);
        s.add(4);s.add(3);s.add(8);
        List<Integer> l2 = m.listIntersection(l,s);
        System.out.println(l2);


    }
}