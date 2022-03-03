class A {
	public String f(A x, A[] y) { return "A1"; }
	public String f(A x, Object y) { return "A2:" + x.f(new C(), y); }
}
class B extends A {
	public String f(C x, A[] y) { return "B1:" + x.f((A)x, y); }
	public String f(A x, A[] y) { return "B2"; }
	public String f(A x, Object[] y) { return "B3"; }
}
class C extends B {
	public String f(A x, B[] y) { return "C1"; }
}
public class Test {
	public static void main(String[] args) {
		C gamma = new C();
		B beta = gamma;//in questo caso beta si comporterà come un C. può accedere ai metodi di B e di C
		B[] array = new B[10];
		System.out.println(beta. f (gamma, array));
		System.out.println(gamma.f(beta, null));
		System.out.println(beta. f (array [0], null)) ;
	}
}

//output: B1, B2, C1, B2 



1) System.out.println(beta.f(gamma, array));
/*l'oggetto beta ci dice in quale classe andare a prendere il metodo. in questo caso, bisogna cercare nella classe B ma anche nella 
classe C. questo perchè beta è sì un B ma è dichiarato come un C. RICORDA che è il tipo dell'oggetto che ti dice in che classe andare 
a vedere la firma. in questo caso è B e C (perchè beta è dichiarato come B). abbiamo 4 papabili firme. tutte e 4 sono valide. 
SECONDO ME è uscito quell'output perchè si dà la PREFERENZA al metodo che prende come parametri quelli con lo stesso tipo dell'oggetto
passato. in questo caso, passo un gamma e io do la preferenza al metodo gamma come parametro. IN PIù, se proprio bisogna fare una scelta,
credo che si dia PREFERENZA sempre alla classe dell'oggetto corrente (e non alla sottoclasse. in questo caso C). */

2)System.out.println(gamma.f(beta, null));
/*SECONDO ME il ragionamento è questo:
gamma è un oggetto di che classe? classe C
OK. esiste un metodo f(), in C, che, passati gli argomenti beta e null, non mi dà errori? si.
OK. prendo quello.

infatti, al metodo f di C posso passare come primo parametro un beta (beta è dichiarato come B ma si comporta come un C. entrambe 
sottoclassi di A) e anche null.*/

3)System.out.println(beta. f (array [0], null)) ;
/*beta è un C. se in B esiste una firma con lo stesso nome di C, allora beta andrà a prendere il metodo da C. 

ma se beta è dichiarato come un C, non deve andare a vedere PRIMA nella classe C? 
vero. specie perchè beta è dichiarato come un C.
quindi, non dovrebbe stampare C1?
falso. questo perchè le due firme f sono DIVERSE (cioè hanno parametri diversi). a PARITà di firma (nome, argomenti ecc UGUALI 
tra superclasse e sottoclasse), si sceglierebbe quella della classe C. in questo caso i due metodi sono DIVERSI e quindi si va
a prendere l'f della classe B.  */