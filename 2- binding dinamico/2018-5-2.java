class A {
	public String f(Object a, A b) { return "A1"; } //.
	public String f(A a, C b) { return "A2"; }
}
class B extends A {
	public String f (Object a, A b) { return "B1 + " + f(null, new B()); } //.
	private String f(A a, B b) { return "B2"; } //- ..
}
class C extends B {
	public String f(Object a, B b) { return "C1"; }
	public String f(A a, B b) { return "C2"; }//..
}
public class Test {
	public static void main(String[] args) {
	C gamma = new C();
	B beta = gamma;
	A alfa = gamma;
	System.out.println( alfa . f (beta, gamma));
	System.out.println(beta.f (beta, beta));
	System.out.println(gamma.f(alfa, null));
	System.out.println(beta instanceof A);
	}
}

//OUTPUT: A2, B1 + B2, true


1)System.out.println( alfa . f (beta, gamma));
/*si cerca dapprima in A. in A ci sono solo 2 metodi. va scelto il più SPECIFICO. chiaramente il metodo di riga 3 è quello che
fa al caso nostro perchè prende proprio i tipi dichiarati nell'invocazione*/

2)System.out.println(beta.f (beta, beta));
/*si cerca inizialmente in B. qui c'è un METODO privato quindi sappiamo che l'invocazione di riga 19 NON potrà mai dare come risultato B2.
di conseguenza, in B abbiamo solo riga 6 che è papabile ma in A abbiamo anche riga 2. chiaramente, nessuna delle due è più specifica
dell'altra quindi si preferisce riga 6 perchè è nella classe B. 
riga 6 invoca però un'altra chiamata al metodo. stavolta passa un null e B. Esiste in B un metodo che prende questi parametri? (se non c'è
va cercato in A). OVVIAMENTE c'è ed è il METODO PRIVATO. 
ma come, non abbiamo detto che i metodi privati non vanno calcolati nell'invocazione?
GIUSTISSIMO. però qui la seconda invocazione è in riga 6 cioè nella classe di B dove i metodi privati hanno senso di essere invocati.
fare un'invocazione di un metodo privato al di fuori di quella classe è IMPOSSIBILE (cioè da ERRORE). */

3)System.out.println(gamma.f(alfa, null));
/*andiamo a cercare in C. in C abbiamo 2 metodi. chiaramente, è auspicabile usare il più specifico (riga 11). verrebbe da pensare che stampa
C2. E INVECE NO. questo perchè il parametro alfa corrisponde (e anche null) però, in A (che viene estesa da C attraverso B) c'è un metodo
che prende alfa e C. riga 3 è PIù SPECIFICO  di riga 11 e di conseguenza si usa quello. -.-*/

4)System.out.println(beta instanceof A);
/*vero perchè instanceof si occupa di confrontare il tipo dichiarato con quello della classe. */


