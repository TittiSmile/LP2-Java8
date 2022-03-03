class A {
    public String f (Object x, A y) { return "A1"; }
    private String f (A x, Object y) { return "A2"; }//--
    protected String f(A x, B y) { return "A3"; }
}
class B extends A {
    public String f(B x, B y) { return "B1 + " + f(x, (Object)y); }
    public String f(A x, Object y) { return "B2"; }
}
class C extends B {
    public String f(A x, Object y) { return "C1 + " + f(x, (B)y); }
    public String f(Object x, A y) { return "C2"; }
}
public class Test {
    public static void main(String[] args) {
    B beta = new C();
    A alfa = beta;
    System.out.println( alfa . f (beta, null)) ;
    System.out.println(beta.f (beta, beta));
    System.out.println(beta.f ( alfa , (B)null));
    }
}
//OUTPUT: A3, B1 + C1  + A3, A3

1)System.out.println( alfa . f (beta, null)) ;
/*innanzitutto, si va in A. RICORDA che il metodo di riga 3 è privato quindi non ci potrà mai accedere da main. il metodo di riga 4 è 
protected quindi va bene. il metodo di riga 18 può chiamare riga 3 ( SE NON FOSSE STATO PRIVATO) e riga 8. chiaramente alfa NON può
accedere al metodo di riga 7. visto che i restanti metodi contengono object, è sempre meglio PREFERIRE (ove possibile) metodi che
prendono come parametri delle classi più specifiche (come A e B di riga 4)*/

2)System.out.println(beta.f (beta, beta));
/*vado a cercare in B un metodo che prende come parametri 2 B. chiaramente è quello di riga 7. va bene anche riga 8 ma riga 7 è più 
specifico. ORA
non capisco come arriva a C1 e A3. 
PROBABILMENTE il metodo della stampa di riga 7 RICHIAMA il metodo di riga 11 che a sua volta RICHIAMA il metodo di riga 4. 
SPIEGAZIONE PER C1:
allora. il metodo di riga 7 nella stampa richiama un altro metodo. il metodo della stampa prende come parametri B ed Object.
esiste, in B, un metodo che prende questi parametri? Sì. è proprio quello di riga 8. PERò il metodo di riga 8 viene CONDIVISO
con C ed è UGUALE al metodo di riga 11. quindi, quando un oggetto B richiama il metodo di riga 8 stamperà il metodo di riga 11.
SPIEGAZIONE PER A3:
il metodo di riga 11 richiama un altro metodo che contiene come parametri A e B. Esiste in C un metodo che prende questi parametri? NO
o meglio, c'è ma c'è object quindi va a cercare se c'è qualcosa di più SPECIFICO. quindi va in B e non lo trova poi va in A e lo trova.
è il metodo di riga 4.
*/

3)System.out.println(beta.f ( alfa , (B)null));
/*a quanto pare fare il cast a null è possibile. ai fini di questa chiamata è ININFLUENTE.
allora. si va in B. in B si prova a cercare un metodo che prende come parametri un A e un null. ce ne sono?
non è riga 7 ma può essere riga 8. quindi verrebbe da pensare che potrebbe essere il metodo di riga 11 E INVECE NO!!!
questo perchè in A c'è un metodo più specifico!!!!! che prende come parametri proprio A e B. 
IN GENERALE scegli SEMPRE il metodo che prende  i parametri più specifici!!!!!*/











