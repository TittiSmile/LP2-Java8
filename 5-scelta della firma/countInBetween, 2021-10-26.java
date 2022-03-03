//pre: accetta un array, un comparatore e due oggetti a b
//post ritorna il numero di oggetti dell'array che, secondo comparatore, sono maggiori di a e minori di b
    static <T> int countInBetween(ArrayList<T> array, Comparator<T> comp, T a, T b){
        int cont=0;
        Collections.sort(array,comp);
        for(T t : array){
            if(comp.compare(t,a)>=0 || comp.compare(t,b)<0){
                cont++;
            }
        }
        return cont;
    }

        public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);array.add(2);array.add(4);array.add(7);
        comparatorClass c = new comparatorClass();
        int cont = countClass.countInBetween(array,c, 5, 3);
        System.out.println(cont);

    }

//firma migliore: 
static <T> int countInBetween(ArrayList<? extends T> array, Comparator<? super T> comp, T a, T b)
/*
funzionalità:  sì, scorro sull'array e prendo al più il comparatore della superclasse.
completezza:	sì posso scegliere qualunque T
correttezza:	sì
semplicità:		1 param.
garanzie:		no scrittura su array e lettura di object da comparatore
ritorno: 	  banale, è  un intero
*/