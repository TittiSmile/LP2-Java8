class A {
	public String f(A x, A y, B z) { return "A1"; }
	public String f(A x, Object y, A z) { return "A2"; }
	private String f(B x, Object y, B z) { return "A3"; }
/*è comunque overloading. non fa NIENTE che cambia l'accesso.  NON c'è problema*/
}
class B extends A {
	public String f(A x, A y, B z) { return "B1" + f(x, this, z); }
	private String f(A x, B y, B z) { return "B2"; }
	public String f(B x, Object y, B z) { return "B3"; }
}
public class Test {
	public static void main(String[] args) {
		B beta = new B();
		A alfa = beta;
		System.out.println( alfa . f ( alfa , alfa , null)) ;
		System.out.println(beta. f ( alfa , beta, alfa )) ;
		System.out.println(beta. f (beta, beta, beta));
		System.out.println(beta. f ( alfa , alfa , null)) ;
	}
}


//OUTPUT: B1:B2, A2, B1:B2

1) System.out.println( alfa . f ( alfa , alfa , null)) ;
/*si cerca prima in A. esiste una firma con questo nome che, passati i seguenti parametri non mi dà problemi? sì.
tecnicamente vanno bene tutte e 3. PERò, ricorda che a PARITà di firme, si va a scegliere la firma della sottoclasse B.
in B c'è una firma uguale a quella passata (la 1°) e quindi si va a prendere quella. */

2) System.out.println(beta. f ( alfa , beta, alfa )) ;
/*si cerca dapprima in B. RICORDA che alfa, anche se dichiarata come beta (quindi si comporta come un B) è SEMPRE un A.
esiste un metodo f in B che, passati questi parametri, non dà problemi? no.
riga 10- no. non va bene. non posso passare un alfa al posto di un B (anche se alfa è dichiarato come beta. è SEMPRE A).
riga 11- no. stesso discorso di sopra. alfa non posso ficcarlo al posto di z
riga 12- neanche. 
quindi? si va a ricercare in A.
riga 4- no. alfa al posto di z (che è dichiarato come B)? no. 
riga 5- YES. posso mettere un beta in object perchè object è la superclasse di tutti iuhu.*/


3)System.out.println(beta. f (beta, beta, beta));
/*dice che c'è ambiguità con la firma con object. se la tolgo, però, mi stampa quella a riga 10. se tolgo anche quella mi stampa A1.
non capisco perchè va nella classe A quando la 2 firma della classe B va bene per questo passaggio di parametri. BOOOOH*/

4)System.out.println(beta. f ( alfa , alfa , null)) ;
/*si cerca prima in B (questo perchè beta è dichiarato come new B ed è di tipo B). esiste in B un metodo che può prendere questi
parametri senza problemi?
il primo metodo è valido perchè può prendere alfa (dichiarto di tipo A ma come B) e anche null
il secondo metodo NON è valido perchè il secondo alfa non può essere preso da B. questo perchè alfa è sì dichiarato uguale ad un beta
	       ma il suo tipo effettivo è comunque A. di conseguenza non posso passarlo
il terzo metodo NON è valido per lo stesso motivo. in più c'è anche object che mi crea problemi.*/

