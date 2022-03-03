class A {
	public String f(Object a, A b) { return "A1"; }
	public String f(A a, B b) { return "A2"; }
}
class B extends A {
	public String f(B a, B b) { return "B1 + " + f(a, (A)b); }
	public String f(A a, B b) { return "B2"; }
}
public class Test {
	public static void main(String[] args) {
	B beta = new B();
	A alfa = beta;
	System.out.println( alfa . f (beta, null)) ;
	System.out.println(beta.f (beta, beta));
	System.out.println(beta.f ( alfa , null)) ;
	}
}

//OUTPUT: B2, B1 + A1, B2

1)System.out.println( alfa . f (beta, null)) ;
/*si va in A. esiste in A un metodo che prende un B e null? entrambi i metodi in A sono papabili. però, come sempre detto, va scelto
il metodo più SPECIFICO. quindi si sceglie il metodo di riga 3. NOTA che il metodo di riga 3 è in comune con B!! è lo stesso di riga 7.
quindi, trattandosi di binding dinamico, la chiamata stamperà il metodo di riga 7*/

2)System.out.println(beta.f (beta, beta));
/*in B c'è un metodo che prende entrambi B come parametri. il metodo di riga 6 fa una stampa ad un altro metodo che prende come parametro
un oggetto di tipo B ed un oggetto B castato ad A (quindi diventa un A a tutti gli effetti). c'è in B un metodo che prende B A come 
parametri? no. (il metodo di riga 7 non è valido perchè non posso passare un A al posto di un B. poss fare al più il contrario). 
in A c'è un metodo che prende Obj e A. va bene quello. anche perchè non ce ne sono di più specifici*/


3)System.out.println(beta.f ( alfa , null)) ;
/*in B c'è un metodo che prende A e null? chiaramente non è il metodo di riga 6 (perchè non posso passare un A al posto di B. anche se A
 è dichiarato uguale a beta (che è B)). il metodo di riga 7 va benissimo perchè non ce ne sono di più specifici e prende proprio i tipi
 dichiarati nel metodo*/

