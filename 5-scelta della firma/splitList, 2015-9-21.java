//pre-cond: il metodo accetta 3 liste ed un oggetto x
//post-cond: spezza la lista src in due parti. una parte della lista (quella minore di x) viene inserita in part1
			 //ed un'altra parte (quella maggiore-uguale di x) in part2

//implementazione con un tipo generico T.
public class myClass<T extends Comparable<T>> { //la traccia non dice nulla in merito al comparable MA visto che bisogna fare un confronto
                                                //tra T è necessario che siano confrontabili. 
    void splitList(List<T> src, T x, List<T> part1, List<T> part2){
        Comparator<T> comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        };
        for(T t : src){
            if(comp.compare(t,x)<0){
                part1.add(t);
            }
            else{
                part2.add(t);
            }
        }
    }

}



a) <T> void splitList(List<T> src, T x, List<T> part1, List<T> part2)
/*
funzionalità: sì  
completezza:  no, sono tutti dello stesso tipo.
correttezza:  sì
garanzie: 	  nessuna
semplicità:   1 param
tipo di ritorno: banale
*/

b) void splitList (List<Object> src, Object x, List<?> part1, List<?> part2)
/*
funzionalità: no. senza neanche vedere l'implementazione: non posso inserire un oggetto in una lista, ad esempio, di integer.
			  vedendo l'implementazione, invece, dovrei usare un comparatore di object  e non mi sembra il caso D: 
              cioè, il confronto tra x e il corrente elemento di src è possibile. il problema è l'add sulle due liste che, essendo
              di tipo ?, non si può fare scrittura.
              in questo caso è NO perchè, anche se list ? può essere scritto come object, qui abbiamo già le liste passate come
              parametri del metodo. quindi NON posso riscriverle come object.
completezza:
correttezza:
garanzie:
semplicità:
tipo di ritorno:
*/

c) <S,T> void splitList(List<S> src, S x, List<T> part1, List<T> part2)
/*
funzionalità: no. il problema, come sopra, è la add. S e T sono diversi. quindi non posso inserire un S in un T. 
completezza:
correttezza:
garanzie:
semplicità:
tipo di ritorno:
*/

d) <T> void splitList(List<? extends T> src, T x, List<T> part1, List<T> part2)
/*
funzionalità: sì (simile alla a). 
completezza:  no, siamo sempre fermi su T.
correttezza:  sì
garanzie:     non c'è scrittura su src
semplicità:	  1 parametro
tipo di ritorno:
*/


e) <T> void splitList(List<T> src, Object x, List<? super T> part1, List<? super T> part2)
/*
funzionalità: no. il problema parte già dal confronto. come faccio a confrontare un T (di src) con un object?
			  questa cosa è impossibile. 
completezza:
correttezza:
garanzie:
semplicità:
tipo di ritorno:
*/





















public class myClass<T extends Comparable<T>> { //la traccia non dice nulla in merito al comparable MA visto che bisogna fare un confronto
                                                //tra T è necessario che siano confrontabili. 
    void splitList(List<? extends T> src, T x, List<T> part1, List<T> part2){
        Comparator<T> comp = new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        };
        for(T t : src){
            if(comp.compare(t,x)<0){
                part1.add(t);
            }
            else{
                part2.add(t);
            }
        }
    }

}

public class Main {

    public static void main(String[] args) {
	// write your code here
        myClass m = new myClass();
        List<Integer> l = new LinkedList<>();
        List<Integer> l2 = new LinkedList<>();
        List<Integer> l3 = new LinkedList<>();
        l.add(1);l.add(3);l.add(5);l.add(8);
        m.splitList(l,4,l2,l3);
        System.out.println(l2);
        System.out.println(l3);


    }
}



