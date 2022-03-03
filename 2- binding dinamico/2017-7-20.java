class A {
	public String f (Object x, A y, A z) { return "A1"; } //.
	private String f(A x, B y, B z) { return "A2"; }	//- ..
}
class B extends A {
	public String f (Object x, A y, A z) { return "B1 + " + f(null, new B(), new C()); }//.
	private String f(B x, B y, C z) { return "B2"; }	//-
}
class C extends B {
	public String f(A x, B y, B z) { return "C1 + " + f(this, this, z); } //..
	public String f(B x, B y, B z) { return "C2"; }
}
public class Test {
	public static void main(String[] args) {
	C gamma = new C();
	B beta = gamma;
	A alfa = gamma;
	System.out.println(beta.f (beta, beta, gamma));
	System.out.println(gamma.f(beta, null, beta));
	System.out.println(gamma.f(alfa, beta, gamma));
	System.out.println( ( (Object)gamma ).equals( (Object)alfa ) );
	}
}
//OUTPUT: B1+B2, C2, C1+C2, true
/*in questo caso il cast NON ci modifica nulla. gamma è uguale ad alfa indipendentemente da Object. questo perchè alfa ha come tipo
effettico gamma. equals va a confrontare il tipo effettivo se combacia oppure no. infatti: 
	C gamma = new C();
	B beta = gamma;
	A alfa = gamma;
    A a = new A();
    B b = new B();
	System.out.println( ( (Object)gamma ).equals( (Object)alfa ) ); //TRUE
	System.out.println( ( gamma ).equals( alfa ) ); //TRUE
	System.out.println( ( gamma ).equals( a ) ); //FALSE. questo perchè A è dichiarato come new A e non ha nulla a che vedere con C
	System.out.println( ( gamma ).equals( beta ) ); //TRUE. questo perchè beta ha come tipo effettivo un gamma. 
	System.out.println( ( gamma ).equals( b ) );//FALSE. b è dichiarato come new B. non ha nulla a che fare con C

	B b2 = new C();
	System.out.println( ( gamma ).equals( b2 ) );//FALSE. anche se è dichiarato come new C, sono DUE OGGETTI distinti e separati.
												 //la new mi crea un nuovo oggetto. 

*/


1)System.out.println(beta.f (beta, beta, gamma));
/*si va in B. esiste in B un metodo che prende un B B e C? sì. riga 7. ma riga 7 è un metodo PRIVATO quindi non va bene. quindi si ricade
sul metodo di riga 6. c'è uno più specifico nella superclasse (A)? NO. o meglio, c'è riga 3 ma è privato. riga 2 ha la stessa
specificità. quindi si sceglie riga 6 (riga 2 non è più specifica). quindi si stampa riga 6. riga 6 ha al suo interno una chiamata ad un 
altro metodo. si va a vedere prima in B. in B esiste un metodo che prende null B C ed è proprio riga 7. anche se è privato, viene
chiamato nella classe corrente quindi va bene! */

2)System.out.println(gamma.f(beta, null, beta));
/* si va in C. esiste in C un metodo che prende B null B? sì, riga 11. c'è qualcuno di più specifico nelle superclassi? mi sa proprio di
no :D quindi si sceglie banalmente riga 11.*/

3)System.out.println(gamma.f(alfa, beta, gamma));
/*ok qui non mi è chiaro il perchè del C2.
si va prima in C. in C c'è un metodo che prende un A B C? no. ma abbiamo riga 10 che gli va molto vicino. nelle superclassi NON c'è
nulla di più specifico quindi si stampa C1. per C2 non saprei. anche perchè si passa un'istanza di this (che è alfa dichiarato come 
gamma) quindi non saprei. io avrei messo C1 + C1*/

4)System.out.println( ( (Object)gamma ).equals( (Object)alfa ) );


