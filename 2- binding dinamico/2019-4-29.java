class A {
	public String f(Object a, B b) { return "A1"; } //ma non dovrebbe farmi conflitto con riga 11? postilla*
	public String f(A a, A b) { return "A2"; }
	public String f(B a, C b) { return "A3"; }
}
class B extends A {
	public String f (Object a, A b) { return "B1 + " + f(null, new B()); }
	private String f(A a, B b) { return "B2"; }
}
class C extends B {
	public String f(Object a, B b) { return "C1"; }
	public String f(A a, B b) { return "C2"; }
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

//OUTPUT: A3, C2, true 

1)System.out.println( alfa . f (beta, gamma));
/*innanzitutto, si va a vedere nella classe A se esiste un metodo possibile. questo perchè alfa è dichiarato come tipo A 
(anche se il tipo effettivo è C). 

-public String f(Object a, B b) { return "A1"; }
questo è valido (CREDO). infatti ad object posso passare qualsiasi suo sottotipo. e a B posso passare un B ma anche un C
(che è suo sottotipo)

-public String f(A a, A b) { return "A2"; }
anche questo è valido. infatti beta è un oggetto sottotipo di A e anche se ha tipo effettivo un oggetto di tipo C, va comunque bene. 

-public String f(B a, C b) { return "A3"; }
valido. in realtà è il migliore perchè B e C sono proprio i tipi dichiarati di beta e gamma. anche se pure gli altri erano validi, 
si preferisce sempre il metodo che ha come parametri i tipi dichiarati di quelli passati. 

*/


2)System.out.println(beta.f (beta, beta));
/*B2 non verrà MAI stampato. questo perchè il metodo di riga 8 è privato quindi accessibile solo nella classe B.
pare che ci siano conflitti strani con la chiamata di riga 2 in A. quindi, così com'è, dà errore di compilazione.
non ho ben capito perchè...
*/



3)System.out.println(gamma.f(alfa, null));
/*gamma è dichiarato di tipo C. quindi si va a controllare prima in C se esiste un metodo che, passati alfa e null, possa andare bene.
chiaramente c'è ed è quello di riga 12. infatti, in questo caso, alfa è di tipo A (anche se ha tipo effettivo gamma) e quindi va bene
e null può essere passato a qualunque tipo. */



4)System.out.println(beta instanceof A);
/*chiaramente, beta è sottoclasse di A. di conseguenza questa stampa darà sempre true. */










//postilla*
/*no perchè sono entrambi pubblici. INFATTI, ho fatto una prova.
ho cambiato la firma di riga 2 con:  
	public String f(A a, B b) { return "A1"; }
e mi andava in conflitto con la firma di riga 8 della classe B. questo perchè la firma di riga 8 è PRIVATE mentre la firma di riga 2 
è dichairata come PUBLIC e quindi questo creava problemi
*/