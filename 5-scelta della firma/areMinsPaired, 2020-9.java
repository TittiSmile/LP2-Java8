//pre: accetta una mappa e un comparatore che confronta chiavi e valori
//post: ritorna true se la chiave minima (cioè la più  piccola tra le chiavi) è associata al valore minimo



/*chiaramente, il comparatore deve confrontare chiavi e valori. di conseguenza, K e V devono essere come minimo imparentati 
(quindi ? extends) e in più il comparatore deve essere dello stesso tipo di K e V considerando il ? super come migliore intestazione
per il tipo. di conseguenza, questa qui è la migliore intestazione.
la dichiarazione degli oggetti è fatta con ? extends T. totalmente legittimo
può andare bene anche: 	
	boolean areMinsPaired(Map<T,T> m, Comparator<T> comp)
però è limitante e non ci dice nulla sulla completezza*/
 public class MyClass {

    <T> boolean areMinsPaired(Map<? extends T,? extends T> m, Comparator<? super T> comp){
        Collection<? extends T> col = m.values();
        Set<? extends T> set = m.keySet();
        T minV = col.iterator().next();//primo elemento della collezione di valori
        T minK = set.iterator().next(); //primo elemento del set di chiavi.
        //primo ciclo per trovare il minimo K e minimo V
        for(Map.Entry<? extends T,? extends T> entry : m.entrySet()){
            if(comp.compare(entry.getValue(),minV)<=0){
                minV=entry.getValue();
            }
            if(comp.compare(entry.getKey(),minK)<=0){
                minK=entry.getKey();
            }

        }
        //secondo ciclo per il confronto
        for(Map.Entry<? extends T,? extends T> entry : m.entrySet()){
            if(entry.getValue().equals(minV) && entry.getKey().equals(minK)){
                return true;
            }
        }
        return false;
    }

class compareKV<T extends Comparable<T>> implements Comparator<T>{
    @Override
    public int compare(T a , T b){
        return a.compareTo(b);
    }
}







public class Main {

    public static void main(String[] args) {
        MyClass m = new MyClass();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1,11);map.put(2,12);map.put(3,13);
        compareKV<Integer> comp = new compareKV<>();
        boolean b = m.areMinsPaired(map,comp);
        System.out.println(b);
    }
}
