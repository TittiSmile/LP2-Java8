Concat, 2013-6-25

//pre-cond:	 accetta due iteratori generici
//post-cond: ritorna un nuovo iteratore che ritorna tutti gli elementi di a e b (prima l'uno poi l'altro)

<T> Iterator<T> concat(Iterator<? extends T> a, Iterator<? extends T> b){
        return new Iterator<T>() { //ritorno un nuovo iteratore. chiaramente devo sovrascrivere i suoi metodi. 
            @Override
            public boolean hasNext() { 
                return a.hasNext() || b.hasNext(); //devo scorrere finchè a OR b contengono elementi
            }

            @Override
            public T next() { 
                if(a.hasNext()) //se a.hasNext contiene elementi
                    return a.next(); //ritorna il suo next. cioè fallo anche scorrere
                if(b.hasNext()) //discorso simile con b.
                    return b.next();
                return null; //in generale, ritorna null. ma non arriverà mai a null ( a meno che non sono già vuoti)
            }
        };
    }
}



a) Iterator<Object> concat(Iterator<Object> a, Iterator<Object> b)
/*
funzionalità:	ok
completezza:	no
correttezza:	ok
garanzie:		no
semplicità:		0 param
tipo ritorno:	coerente
*/

b) Iterator<?> concat(Iterator<?> a, Iterator<?> b)
/*
funzionalità:	sì		//ritorna comunque object
completezza:	sì		//passo qualunque ma scorro solo con object 
correttezza:	sì, la pre-cond accetta tutto. 
garanzie:		//limitato. no garanzie. leggo solo sottoforma di object 
semplicità:		0 param
tipo ritorno:	troppo generico //ci posso assegnare SOLO object

*/

c) <S> Iterator<S> concat(Iterator<S> a, Iterator<S> b)
/*
funzionalità:	ok
completezza:	no, sono vincolata da s (in realtà devono essere generici)
correttezza:	ok
garanzie:		nessuna
semplicità:		1 param
tipo ritorno:	coerente
*/

d) <S> Iterator<S> concat(Iterator<? extends S> a, Iterator<? extends S> b) //MIGLIORE
/*
funzionalità:	funzionale ?
completezza:	sì, posso prendere le sottoclassi di s
correttezza:	ok
garanzie:		l'iteratore di suo non permette di scrivere
semplicità:		1 param
tipo ritorno:	coerente 


*/

e) <S,T> Iterator<S> concat(Iterator<S> a, Iterator<T> b)
/*
funzionalità:	no. deve ritornare una lista di s ma posso passare anche una lista di t (che, tecnicamente, è diversa da s). 
				in questo caso NON posso fare l'unione perchè sono due tipi diversi e NON imparentati
completezza:
correttezza:
garanzie:
semplicità:
tipo ritorno:
//non rispetta regole di tipo (indipendentemente da S e T)
*/

f) <S,T extends S> Iterator<T> concat(Iterator<T> a, Iterator<S> b)
/*
funzionalità:	non funzionale. mi torna un iteratore di integer ma posso passargli un iteratore di number. chiaramente ritornare
				il sottotipo quando passi un supertipo non è l'ideale (specie se devi fare operazioni di unione e cose simili)
completezza:
correttezza:
garanzie:
semplicità:
tipo ritorno:
*/

//miglior firma per me:
<S> Iterator <S> concat(Iterator<? extends S> a, Iterator<? extends S>b)











public class Main {

    public static void main(String[] args) {
        MyClass m = new MyClass();


        LinkedList<Integer> l = new LinkedList<>();
        l.add(1);l.add(13);l.add(14);

        LinkedList<Integer> l2 = new LinkedList<>();
        l2.add(2);l2.add(21);l2.add(24);


        Iterator<Integer> itl = l.iterator();
        Iterator<Integer> itl2 = l2.iterator();


        Iterator<Integer> it = m.concat(itl,itl2); //ATTENZIONE. visto il metodo concat, è buona norma assegnarlo ad un iteratore
        											//e NON ad una classe che implementa l'iteratore. in questo modo si è tranquilli
        											//sul tipo di ritorno. 

        while(it.hasNext()){
            System.out.println(it.next());
        }


