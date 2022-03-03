class A {
	public String f (Object x, A y, B z) { return "A1"; }
	private String f(A x, B y, A z) { return "A2"; }	//-
}
class B extends A {
	public String f(Object x, A y, B z) { return "B1 + " + f(null, z, new B()); }
	private String f(B x, B y, B z) { return "B2"; }	//-
}
public class Test {
	public static void main(String[] args) {
	B beta = new B();
	A alfa = (A) beta;
	System.out.println( alfa . f ( alfa , beta, beta));
	System.out.println( alfa . f (beta, alfa , null)) ;
	System.out.println(beta.f (beta, beta, beta));
	System.out.println( alfa instanceof B);
	}
}

//OUTPUT: B1 + B2, B1 + B2, B1 + B2, true

1)System.out.println( alfa . f ( alfa , beta, beta));
/*alfa è di tipo dichiarato A. quindi si va a cercare in A. esiste un metodo che prende questi 3 parametri e sono dello stesso tipo?
sì. è riga 3. PERò riga 3 è privato. di conseguenza NON può essere stampato nell'invocazione di riga 13. quindi? quindi si prende riga 2.
riga 2 PERò è uguale a riga 6 di B. quindi, a parità di invocazione, si chiama quello della sottoclasse. 
quindi. chiamiamo riga 6. riga 6 contiene un'altra chiamata ad un metodo f. f è in B. esiste in B un metodo che prende quei parametri
con i tipi dichiarati giusti? sì. è riga 7. ANCHE SE è PRIVATO possiamo prenderlo perchè è chiamato nella classe B.*/


2)System.out.println( alfa . f (beta, alfa , null)) ;
/*si va in A. si fa lo stesso discorso della chiamata di prima. pari pari. */


3)System.out.println(beta.f (beta, beta, beta));
/*si va in B. in B c'è un metodo che prende tutti beta MA è privato quindi non va bene. prendiamo, quindi, riga 6. in questo caso NON
si va nella superclasse perchè la superclasse non ha parametri PIù specifici. quindi è inutile. stamperà la stessa cosa delle righe su.
stesso ragionamento. riga 7 è privata ma, chiamata nella classe B va bene. */

4)System.out.println( alfa instanceof B);
/*VERO. anche se A è superclasse di B, qui è stato assegnato alfa a beta (il cast con A è superfluo. è un upcast). quindi si va
a confrontare il tipo effettivo. (che è beta).*/