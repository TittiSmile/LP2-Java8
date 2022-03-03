abstract class A {
	public abstract String f(A a, B b); //.
	public int f(B b, C c) { return 1; }
}
class B extends A {
	public String f(A a, B b) { return "2"; } //. .. ...
	public String f(C c, B b) { return "3"; }
	public int f(C c, Object x) { return 4; }
}
class C extends B {
	public String f(C c1, C c2) { return "5"; }// ..
	public String f(A a, B b) { return "6"; } //...
}
public class Test {
	public static void main(String[] args) {
	C gamma = new C();
	B beta = gamma;
	A alfa = gamma;
	System.out.println( alfa . f (null, gamma));
	System.out.println(beta.f (gamma, gamma));
	System.out.println(gamma.f(gamma, alfa));
	System.out.println(gamma.f(beta, beta));
	System.out.println(1 + "1");
	}
}
//OUTPUT: 1, errore, 4, 6, 11






1) System.out.println( alfa . f (null, gamma));
/*A è astratta. però non ce ne frega e quando si fa l'invocazione con alfa (riga 19) si va in A. c'è in A un metodo che prende
quei parametri e va bene? sì. riga 3. riga 2 non va bene perchè c'è riga 3 che prende parametri più specifici. */


2)System.out.println(beta.f (gamma, gamma));
/*qui c'è l'errore!!! la spiegazione sarà lunga :D
allora. innanzitutto si va in B. in B abbiamo 3 metodi. qual è quello papabile per quegli oggetti passati? sono tutti e 3 validi ma, 
chiaramente, si va a scegliere quello più specifico cioè il metodo di riga 7. ora. qui ci viene segnato errore. questo perchè nella 
classe A (classe estesa da B) c'è un metodo (riga 3) che prende esattamente gli STESSI tipi che vengono presi in riga 7 SOLO che l'ordine
è invertito. quindi, per questo motivo, nessuna delle due firme è più specifica dell'altra e di conseguenza si andrà in ERRORE.
normalmente si sceglierebbe quella di classe B (se in A NON c'è una più specifica). però in A abbiamo il metodo che prende gli stessi
parametri in ordine inverso. se l'ordine fosse stato UGUALE si sarebbe scelto quello di classe B. ma così NON è. 
in questo caso NON importa che il tipo di ritorno non combacia. è l'ultimo dei problemi. qui si va a vedere il tipo dei parametri e 
l'ordine di seguito, alcune chiamate che vanno bene/non vanno bene: 
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
			C gamma = new C();
        	B beta = gamma;
        	A alfa = gamma;
        	System.out.println(beta.f (gamma, gamma));
	}
}

 class A {
	//public String f(B b, C c) { return "1"; } //KO. stesso tipo di ritorno. stessa specificità dei parametri di B ma ordine "inverso". il compilatore non sa chi scegliere
	//public String f(C b, B c) { return "1"; } //OK. stesso tipo di ritorno. stessi specificità dei parametri di B e stesso ordine. a parità di firma, si sceglie sempre quella di classe B.
	//public String f(C b, C c) { return "1"; } //OK. stesso tipo di ritorno. specificità maggiore dei parametri rispetto a B. con l'invocazione, si sceglie questo metodo perchè più specifico di quello in B.
	//public int f(C b, B c) { return 1; } //KO. tipo di ritorno diverso. in questo caso fa la differenza. stessa specificità dei parametri di B ma in ordine inverso. il compialtore non sa quale scegliere.
	//public int f(C b, C c) { return 1; } //OK. tipo di ritorno diverso. specificità maggiore dei parametri rispetto alla classe B. a parità di firma (quindi di nome e parametri) si sceglie quella più specifica. si sarebbe scelta questa qui per la stampa invece di quella in B.
}
class B extends A {
	public String f(C c, B b) { return "3"; }
}
class C extends B {

}
*/


3)System.out.println(gamma.f(gamma, alfa));
/*si va in classe C. in classe C abbiamo 2 metodi. il metodo di riga 11 NON è possibile perchè prende C e C (mentre nel metodo abbiamo 
un A). il secondo metodo è possibile. ma esiste uno più SPECIFICO nelle superclassi? cerchiamo un metodo che abbia C come primo 
parametro e A come secondo. in B abbiamo il metodo di riga 7 e 8 che potrebbero andare bene. il metodo di riga 7 però ha B come secondo
parametro (mentre nell'invocazione c'è un alfa) quindi NON va bene. di conseguenza, si sceglie il metodo di riga 8 che prende un C
come primo argomento e un object. è quello più specifico.  */

4)System.out.println(gamma.f(beta, beta));
/*si va in classe C. qui abbiamo 2 possibili metodi. il metodo di riga 11 non va bene perchè passa 2 C (è impossibile passare due
oggetti della superclasse quando ne richiede 2 della sottoclasse. posso passare un oggetto della sottoclasse se il parametro è di 
superclasse ma NON il contrario). il metodo possibile è quello a riga 12. ce n'è uno più specifico nelle superclassi? (quindi un metodo
che prende BB). NO. in B abbiamo a riga 6 il metodo che prende A B come in C ma NON è più specifico. quindi, a parità di specificità, 
scelgo quello che si trova nella classe dell'oggetto chiamante (gamma) ossia riga 12 */

5)System.out.println(1 + "1");
/*questa è una concatenazione. quindi sto aggiungendo al numero 1 la stringa contenente il carattere 1. */
