//pre: accetta un iterable e una mappa
//post:  ritorna tutti gli elementi restituiti dall'iterable che sono anche chiavi della mappa. 

//implementazione base:
<K,V> Collection<K> foo (Iterable<K> i, Map<K,V> map){
        Set<K> setK = new HashSet<>(); //è il set di ritorno
        Iterator<K> it = i.iterator(); //richiamo l'iteratore dell'iterable
        Iterator<K> itM = map.keySet().iterator(); //faccio lo stesso per le K della mappa
        while(it.hasNext() && itM.hasNext()){ //scorro in contemporanea l'iterable e le K della mappa
            K itn = it.next();
            K itMn = itM.next();
            if(itn.equals(itMn)){ //se sono uguali vuol dire che abbiamo trovato quel che ci serve
                setK.add(itn); //lo aggiungo nel set di ritorno. in questo caso itn=itMn
            }
        }
        return setK;
    }




a) <K> Collection<K> foo(Iterable<K> i, Map<K,?> map)
/*
funzionalità:	sì
completezza:	no. la mappa e l'iteratore sono sullo stesso tipo.
correttezza:	sì
garanzie:		non scrivo su V
semplicità:		1 param
ritorno:		è molto permissivo. cioè. scegliere una collection invece di set può fare comodo in fase di progettazione.
				come regola, i K della map sono rappresentati nel set ma va bene anche collection.
				non è un errore, semplicemente è più "largo" come permesso per il chiamante. 
*/

b) <K, T extends K> Collection<T> foo(Iterable<T> i, Map<K,?> map)
/*
funzionalità:	sì
completezza:	sì, posso scegliere qualunque K e di conseguenza ogni T suo sottotipo. (ricorda che qua vai a scegliere
				il tipo in  funzione di K. se K=object allora T è qualunque suo sottotipo)
correttezza:	sì
garanzie:		non scrivo su V
semplicità:		2 param
ritorno:		come sopra. posso fare tranquillamente la add perchè sto aggiungendo l'oggetto di tipo comune in 
				iter e map





*/

c) <K,V> Set<K> foo(Iterable<? extends K> i, Map<K,V> map)
/*
funzionalità:	sì
completezza:	sì, se scelgo ad esempio K=obj posso prendere tutti i suoi sottotipi.
correttezza:	sì
garanzie:		non scrivo su iterable
semplicità:		2 parametri
ritorno:		più specifico (come collezione) di quelli sopra. 
*/

d) Set<Object> foo(Iterable<Object> i, Map<?,?> map)
/*
funzionalità:	sì
completezza:	no. questo perchè avere un parametro che è di tipo obj NON dà la completezza. ad esempio, non posso avere
				un iterable<emp>  (ANCHE SE iterable<obj> può contenere degli emp). con iterable<obj> sono OBBLIGATA ad
				avere come tipo parametrico un object
correttezza:	sì
garanzie:		non scrivo sulla mappa
semplicità:		0 param
ritorno:		troppo restrittivo. posso tornare SOLO un set di obj
*/

e) <K> Set<K> foo(Iterable<? extends K> i, Map<?,?> map) //MIGLIORE
/*
funzionalità:	sì
completezza:	sì, posso prendere qualunque tipo 
correttezza:	sì
garanzie:		non scrivo su iterable e su map
semplicità:		1 param
ritorno:		come collezione, un po' più restrittivo di collection.



*/

f) <K> Set<K> foo(Iterable<? super K> i, Map<? extends K,?> map)
/*
funzionalità:	sì
completezza:	no? anche se posso prendere qualunque K sono comunque vincolati tra loro. ad esempio, non potrei prendere
				iterable<student> e map<employee,?>. potrei scegliere K=obj ma per l'iterable NON potrei passarci un sottotipo
				di object. 
correttezza:	sì
garanzie:		non scrivo sulla mappa e leggo obj da iterable
semplicità:		1 param
ritorno:		più restrittivo di collection ma va bene



*/


































public class MyClass {
    <K,V> Collection<K> foo (Iterable<K> i, Map<K,V> map){
        Set<K> setK = new HashSet<>();
        Iterator<K> it = i.iterator();
        Iterator<K> itM = map.keySet().iterator();
        while(it.hasNext() && itM.hasNext()){
            K itn = it.next(); //facoltativo
            K itMn = itM.next();
            if(itn.equals(itMn)){
                setK.add(itn);
            }
        }

        return setK;
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






public class Main {

    public static void main(String[] args) {
        MyClass m = new MyClass();
        iterableClass<Integer> ic = new iterableClass<>();
        ic.add(1);ic.add(12);ic.add(51);
        Map<Integer, String> map = new HashMap<>();
        map.put(1,"a");map.put(2,"b");map.put(3,"c");
        Collection <Integer> col = new HashSet<>();
        col=m.foo(ic,map);
        System.out.println(col);
    }
}