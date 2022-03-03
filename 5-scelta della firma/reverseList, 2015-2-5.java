//pre-cond: accetta una lista
//post-cond: ritorna una lista che contiene gli stessi elementi della prima(passata per parametro) ma in ordine inverso. 

//implementazione base con tipo parametrico T
public class myClass{
    <T> List<T> reverseList(List<T> l) {
        //al più, si potrebbe creare una nuova lista e uguagliarla al reverse e ritornare la nuova lista.
        Collections.reverse(l);
        return l;
    }
}

public class Main {

    public static void main(String[] args) {
	// write your code here
        myClass m = new myClass();
        List<Integer> l = new LinkedList<>();
        l.add(1);l.add(3);l.add(5);l.add(8);
        List<Integer> l2 = m.reverseList(l);
        System.out.println(l2);


    }
}

a) List<?> reverseList(List<?> l)
/*
funzionalità: sì, il metodo viene svolto
completezza:  sì
correttezza:  sì
garanzie:	  non c'è scrittura su l e leggo solo object
semplicità:   0 parametri
tipo di ritorno:  c'è problema col chiamante. posso assegnargli solo object. 
*/

b) <T> List<? extends T> reverseList(List<? super T> l)
/*
funzionalità: no. oltre ad esserci problemi col chiamante (che tipo gli assegno nel main?) c'è proprio un problema col ritorno.
			  la lista è di ? super mentre il ritorno è con ? extends. quindi ritorna le cose opposte 
completezza:
correttezza:
garanzie:
semplicità:
tipo di ritorno:
*/

c) <T extends List<?>> T reverseList(T l)
/*
funzionalità: sì, è sottotipo di list ?
completezza: sì perchè prende la lista di ? e sottotipo (cioè supertipo di tutti i tipi parametrici)
correttezza: sì
garanzie:    no
semplicità:  1 parametro
tipo di ritorno: ci sono problemi col chiamante perchè la lista di T è solo di tipo object
*/

d) <T> List<T> reverseList(List<T> l) //MIGLIORE 
/*
funzionalità: sì
completezza:  sì (posso prendere qualunque T)
correttezza:  sì (anche perchè non ci sono particolari restrizioni nella pre-cond)
garanzie:     nessuna
semplicità:	  1 param
tipo di ritorno: coerente 
*/

e) List<Object> reverseList(List<Object> l)
/*
funzionalità: sì
completezza: no perchè siamo costretti ad usare una lista di object
correttezza: sì
garanzie:    nessuna
semplicità:  0 param
tipo di ritorno: troppo restrittivo per il chiamante. posso assegnargli solo una lista di object
*/


//eventualmente?
<T> List<T> reverseList(List<? extends T> l)
//NO perchè non posso scrivere su l. quindi non va bene questo tipo. 






