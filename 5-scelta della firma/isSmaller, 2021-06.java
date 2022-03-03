//pre: accetta 2 liste ed un comparatore
//post: ritorna vero se tutti gli oggetti della 1 lista sono più piccoli di tutti gli oggetti della 2 lista (in base al comparatore)

<S> boolean isSmaller(List<S> a, List<S> b, Comparator<S> c){
         Iterator<S> it = a.iterator();
         Iterator<S> it2 = b.iterator();
         while(it.hasNext() && it2.hasNext()){
             if(c.compare(it.next(),it2.next())>0){ 
                return false;
             }
         }
         return true;
     }


a) <S,T> boolean isSmaller(List<S> a, List<T> b, Comparator<S> c)
/*
funzionalità:	no. le liste sono di due tipi diversi e il comparatore è su S. non posso confrontare un S con un T. al massimo,
				posso farlo SOLO se imparentati (uno superclasse/sottoclasse dell'altro)
completezza:
correttezza:
garanzie:
semplicità:
ritorno:		banale
*/

b) <S,T> boolean isSmaller(List<S> a, List<S> b, Comparator<S> c)
/*
funzionalità:	sì
completezza:	no, siamo fermi su S
correttezza:	sì
garanzie:		nessuna
semplicità:		1 param
ritorno:		banale
*/

c) <S,T> boolean isSmaller(List<S> a, List<T> b, Comparator<Object> c)
/*
funzionalità:	sì. object è visto come tipo grezzo del comparatore. quindi funziona. 
completezza:	no. il comparatore è fisso su object
correttezza:	sì
garanzie:		nessuna
semplicità:		2 param
ritorno:		banale



N.B. se vuoi il comparator di object NON puoi ritornare a.compareTo(b)



*/

d) boolean isSmaller(List<?> a, List<?> b, Comparator<Object> c)
/*
funzionalità:	sì. anche se le due liste possono essere di qualunque tipo, il comparatore di object ci permette di poter fare il 
				confronto con qualunque tipo associato alle liste (anche confronto con Student ed Employee).
completezza:	no. il comparatore è sempre fisso su object
correttezza:	sì
garanzie:		non scrivo sulle liste e leggo solo object
semplicità:		0 param
ritorno:		banale
*/

e) boolean isSmaller(List<?> a, List<?> b, Comparator<S> c)
/*
funzionalità:	no. il comparatore è di S. le 2 liste possono essere di qualunque tipo quindi NON va bene.
completezza:
correttezza:
garanzie:
semplicità:
ritorno:		
*/

f) <S> boolean isSmaller(List<? extends S> a, List<? extends S> b, Comparator<S> c) //MIGLIORE. l'ideale sarebbe comp<? superS>
/*
funzionalità:	sì. le liste sono sottoclassi di S quindi va bene
completezza:	sì. se scelgo S=object posso prendere qualunque cosa.
correttezza:	sì
garanzie:		non scrivo sulle liste
semplicità:		1 param.
ritorno:		banale
*/
















public class MyClass {

     <S> boolean isSmaller(List<S> a, List<S> b, Comparator<S> c){
         Iterator<S> it = a.iterator();
         Iterator<S> it2 = b.iterator();
         while(it.hasNext() && it2.hasNext()){
             if(c.compare(it.next(),it2.next())>0){ //mi basta che nella 1 lista ci sia un elemento che sia più grande di un altro della 
             										//seconda che NON vale più la condizione di "essere più piccolo"
                 return false;
             }
         }
         return true;
     }

}

class myComp <T extends Comparable<T>> implements Comparator<T>{
    @Override
    public int compare(T a, T b){
        return a.compareTo(b);
    }
}




public class Main {

    public static void main(String[] args) {
        MyClass m = new MyClass();
        List<Integer> l = new LinkedList<>();
        l.add(1);l.add(2);l.add(3);
        List<Integer> l2 = new LinkedList<>();
        l2.add(4);l2.add(5);l2.add(1);
        myComp<Integer> mc = new myComp<>();
        System.out.println(m.isSmaller(l,l2,mc));
    }
}