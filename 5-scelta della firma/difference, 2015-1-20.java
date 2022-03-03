//pre-cond: accetta due insiemi a e b
//post- cond: ritorna un nuovo insieme che contiene gli elementi che appartengono ad a ma non a b (differenza simmetrica a e b)

//implementazione base con T parametrico
public class myClass{
    <T> Set<T> difference(Set<T> a, Set<T> b){
        Set<T> returnSet = new HashSet<>();
        for(T t : a){
            if(!b.contains(t)){
                returnSet.add(t);
            }
        }
        return returnSet;
    }
}


a) Set<?> difference(Set<?> a, Set<?> b)
/*
funzionalità: no, c'è un problema col set di ritorno. è di tipo ? e non posso scriverci. 
completezza:
correttezza:
garanzie:
semplicità:
tipo di ritorno:
*/

b) Set<Object> difference(Set<?> a, Set<?> b)
/*
funzionalità: sì. posso scorrere a con object. 
completezza:  sì, prendo dei set qualsiasi
correttezza:  sì
garanzie:     non posso scrivere sui set e leggo solo object
semplicità:   0 parametri
tipo di ritorno: troppo limitato. posso assegnargli solo set di object
*/

c) Set<Object> difference(Set<String> a, Set<String> b)
/*
funzionalità: sì. scorro un set di string ed aggiungo elementi ad un set di object. (i set di object contengono anche string, volendo)
completezza:  no. siamo limitati su string
correttezza:  sì
garanzie:     nessuna
semplicità:   0 param
tipo di ritorno: trppo limitato. 
*/

d) <T> Set<T> difference(Set<T> a, Set<?> b) //MIGLIORE PER ME
/*
funzionalità: sì (posso passare un set di b qualunque)
completezza:  sì, scelgo qualunque tipo di set
correttezza:  sì
garanzie:     non scrivo su b e leggo solo object
semplicità:   1 parametro
tipo di ritorno:  coerente (cioè deve fare capo al tipo di set di a)
*/

e) <T> Set<T> difference(Set<? extends T> a, Set<? extends T> b)
/*
funzionalità: sì
completezza:  sì. tecnicamente posso prendere come T anche object e va bene così (non sono sicura)
correttezza:  sì
garanzie:     non scrivo sui set
semplicità:   1 param
tipo di ritorno:  coerente
*/

f) <T> Set<T> difference(Set<T> a, Set<? extends T> b)
/*
funzionalità: sì
completezza:  no perchè b è sempre vincolato da T (anche se è di tipo object, volendo)
correttezza:  sì
garanzie:     non scrivo su b
semplicità:   1 param
tipo di ritorno:  coerente. 
*/






public class Main {

    public static void main(String[] args) {
	// write your code here
        myClass m = new myClass();
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        a.add(1);a.add(2);a.add(3);
        b.add(5);b.add(3);b.add(4);
        Set<Integer> s = m.difference(a,b);
        System.out.println(s);

    }
}