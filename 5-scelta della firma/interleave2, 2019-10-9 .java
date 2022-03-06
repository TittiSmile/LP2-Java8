//pre: prende come argomento tre liste A B C (qualsiasi)
//post: senza modificare A e B, aggiunge tutti gli elementi di A e B in C in modo alternato
    <S> void interleave(List<S> a, List<S> b, List<S> c){
        Iterator<S> itA = a.iterator();
        Iterator<S> itB = b.iterator();

        while(itA.hasNext() && itB.hasNext()){ //scorro entrambe le liste
            c.add(itA.next());
            c.add(itB.next());
        }
        //System.out.println(c);

    }






a) <S> void interleave(List<S> a, List<S> b, List<S> c)
/*
funzionalità:	sì
completezza:	no, sono tutte vincolate da S (tutte dello stesso tipo)
correttezza:	sì
garanzie:		nessuna
semplicità:		1 param
ritorno			banale
*/

b) <S, T extends S> void interleave(List<T> a, List<T> b, List<S> c)
/*
funzionalità:	sì
completezza:	no. le 2 liste sono necessariamente dello stesso tipo e chiaramente non va bene. 
correttezza:	sì	
garanzie:		no
semplicità:		2 param
ritorno
*/

c) void interleave(List<?> a, List<?> b, List<Object> c)
/*
funzionalità:	sì, non ci sono problemi (anche perchè una lista di object può contere oggetti di qualunque tipo)
completezza:	no. la 3 lista è di object. questo non ci dà la completezza.
correttezza:	sì
garanzie:		non scrivo sulle due liste
semplicità:		0 param
ritorno			banale
*/

d) <S> void interleave(List<?> a, List<?> b, List<S> c)
/*
funzionalità: 	no. la lista è di tipo S mentre le altre 2 liste sono di tipo ?. non concordano.
completezza:
correttezza:
garanzie:
semplicità:
ritorno
*/

e) <S> void interleave(List<S> a, List<S> b, List<? super S> c)
/*
funzionalità:	sì, posso aggiungere sottotipi di S a ? super S
completezza:	no, anche qui, come la b, le due liste sono necessariamente dello stesso tipo
correttezza:	sì
garanzie:		leggo object da c
semplicità:		1 param
ritorno			banale
*/



//migliore secondo me: 
<S> void interleave(List<? extends S> a, List<? extends S> b, List<S> c){
        Iterator<? extends S> itA = a.iterator();
        Iterator<? extends S> itB = b.iterator();

        while(itA.hasNext() && itB.hasNext()){
            c.add(itA.next());
            c.add(itB.next());
        }
        System.out.println(c);
    }


//abbiamo ulteriori garanzie sulle liste (non ci scriviamo). in più risulta essere completa perchè scegliamo S in funzione della
//terza lista. quindi va bene

















public static void main(String[] args) {
        MyClass m = new MyClass();
        List<Integer> l = new LinkedList<>();
        l.add(1);l.add(2);l.add(3);
        List<Integer> l2 = new LinkedList<>();
        l2.add(4);l2.add(5);l2.add(6);

        m.interleave(l,l2,new LinkedList<Integer>());
    }
