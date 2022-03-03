class A {
	public String f(Object x, A y, B z) { return "A1"; }
	public String f(A x, C y, C z) { return "A2"; }	//.
}
class B extends A {
	public String f (Object x, A y, A z) { return "B1 + " + f(null, new B(), y); }
	private String f(A x, B y, B z) { return "B2"; } //-
}
class C extends B {
	public String f(A x, A y, B z) { return "C1"; }
	public String f(A x, C y, C z) { return "C2"; } //.
}
public class Test {
	public static void main(String[] args) {
		C gamma = new C();
		B beta = gamma;
		A alfa = gamma;
		System.out.println( alfa . f (beta, gamma, gamma));
		System.out.println(beta.f (beta, beta, beta));
		System.out.println(gamma.f(alfa, null, beta));
	}
}

//OUTPUT: C2, A1, C1

1)System.out.println( alfa . f (beta, gamma, gamma));
/*si va a cercare prima in A. esiste in A un metodo che prende B C C? tecnicamente sì, il più specifico è quello di riga 3. 
(anche se c'è A al posto di B non fa niente. qui POSSO passare un B, sottoclasse di A, ad A. NON vale il contrario). verrebbe da pensare
che stampa A2 E INVECE NO! questo perchè in C c'è un metodo che prende gli STESSI parametri del metodo di riga 3 ed è riga 11.
anche se C estende A per vie "traverse" (passa per B) COMUNQUE vale la regola del binding dinamico incontrato finora. quindi,
a parità di parametri e nome del metodo, quando si fa un'invocazione con un oggetto supertipo, si va a richiamare il metodo
della sottoclasse (ci sono esempi di binding dinamico nel pdf).*/



2)System.out.println(beta.f (beta, beta, beta));
/*si va a cercare prima in B. in B abbiamo due metodi. uno dei quali è privato ( riga 7) quindi NON può essere utilizzato in questo
contesto. ora, in C non abbiamo metodi UGUALI a quelli dichiarati in B quindi possiamo andare a vedere SOLO in A. un possibile metodo
in A che può andar bene per questa chiamata è quello di riga 2. si preferisce, infatti, quest'ultimo perchè A PARITà DI TIPI DI PARAMETRI
il metodo di riga 2 passa, come terzo argomento, un B che è più specifico di quello di riga 6.*/



3)System.out.println(gamma.f(alfa, null, beta));
/*si va a cercare prima in C. esiste in C un metodo che prende come parametri un A null (quindi qualunque oggetto) e B? sì.
chiaramente c'è il metodo di riga 10. visto che C è dichiarato come C si va a cercare SOLO in C (non ci sono altre sottoclassi).
quindi lo abbiamo trovato in C. anche riga 7 era papabile ma si trova in classe B e di certo non è più specifica. quindi,
se la firma la trovo nella classe corrispondente all'oggetto dichiarato NON c'è bisogno di cercare altrove. */





//COSE DA VEDERE IN PRIMIS IN ESERCIZI DEL GENERE:
//1- accessibilità dei metodi (se private o no)
//2- se ci sono metodi, nelle sottoclassi, UGUALI (stessi parametri, e tipi di ritono)