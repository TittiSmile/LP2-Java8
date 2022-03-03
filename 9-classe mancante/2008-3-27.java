//devo implementare la classe B in modo tale che la classe A venga compilata correttamente.
public class B extends RuntimeException{ //1
    B(){}								//2
    B(int i, double d){}				//3
    B(String s){}					//4
}
public class A extends B {
	public A(int x) {
		super(x-1, x / 2.0);
	}
	public A(double inutile) { }
	private void stampa(String s) {
		if (s == null) throw new B(s);
		else System.out.println(s) ;

	}
}



/*
1- 	estende runtimeException perchè a riga 13 viene lanciata un'eccezione da B. si preferisce un'eccezione NON verificata
2- 	la classe A ha due costruttori. il secondo costruttore di A NON passa nessuna super. quindi fa riferimento 
	ad un costruttore senza argomenti di B
3- 	il 1 costruttore di A ha come riferimento la super con 2 parametri. sono int (perchè c'è x-1. x è int in A)
	e una divisione che è di norma double
4-	a riga 13 viene lanciata un'eccezione di B che prende un argomento s( stringa). quindi è chiaro che B ha un altro costruttore
	che prende una stringa come parametro.
*/

