public class A {
	Comparator<Double> b = new B(null);
	Comparator<String> c = (x, y) -> B.g(x, y);
	<T> A f(T x, T y) {
		return new B(x==y);
	}
}

class B extends A implements Comparator { 	//1
    B(Object o){}							//2
    B(Boolean b){}							//3
    @Override
    public int compare(Object o, Object o2){ //sovrascrivo compare perchè B implementa il comparatore
        return 0;
    }
    static Comparator<Object> g(Object o, Object o2){  //4
        return new Comparator<Object>(){
            @Override
            public int compare(Object x, Object y){
                return 0;
            }
        };
    }
    
    
}

/*
1- 	la classe B estende A perchè a riga 5 ritorna un new B quando il tipo di ritorno è A. è possibile SOLO se B +sottotipo di A.
	inoltre, estende anche comparator (GREZZO) perchè riga 2 assegna ad un comparatore di Double un new B di null. quindi B è
	un comparatore. se è un comparatore allora implementa per forza COMPARATOR.
	N.B. NON potevo mettere Comparator<T> perchè B NON è classe parametrica. Da dove avrei preso T?
2-	il primo costruttore prende object. andava bene qualunque oggetto perchè a riga 2 viene passato null. ho preferito object per
	completezza.
3-	il secondo costruttore è booleano perchè a riga 5 ritorna un new B che prende come parametro un confronto tra x e y
4- 	questo mi serviva per la riga 3. NON è corretto!!!! non so come fare. cioè la lambda espressione mi dice che prendo x e y e li passo 
	al metodo statico g di B (statico perchè ci accedo con B grande).

*/