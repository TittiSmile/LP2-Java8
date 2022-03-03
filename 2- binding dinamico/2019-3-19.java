class A {
   public String f(A x, A[] y) { return "A1"; }
   public String f(A x, Object y) { return "A2:" + x.f(new B(), null); }
}
class B extends A {
   public String f(B x, B[] y) { return "B1"; }
   public String f(A x, A[] y) { return "B2"; }
   public String f(A x, Object[] y) { return "B3"; }
}
public class Test {
   public static void main(String[] args) {
      B[] arrayB = new B[10];
      A[] arrayA = arrayB;
      arrayB[0] = new B();
      System.out.println(arrayB[0]. f (null, arrayB));
      System.out.println(arrayA[0]. f (null, arrayA));
      System.out.println(arrayA[0]. f (arrayA[0], null)) ;
   }
}

//output: B1, B2, B2


1) arrayB[0] è dichiarato come new B. per questo motivo, bisogna ricercare la firma SOLO nella classe B (senza andare in A). tra le
   il null come primo argomento va bene per qualunque oggetto (sia di tipo A che di tipo B). il secondo parametro, invece, è sempre
   arrayB (che è dichiarato come un B). quindi si escludono sia la firma che prende Object sia quella che prende A. 

2) arrayA è uguale ad arrayB che a sua volta è dichiarato com eun new B. per questo motivo, bisogna andare a ricercare la firma SOLO nella 
   classe B (perchè l'array  è un B). andiamo ad escludere la firma che prende 2 B come parametri (questo perchè nonostante arrayA è dichiarato come un B è pur sempre un A) ed escludiamo anche la firma che prende object come parametro perchè arrayA è dichiarato come un B ma è pur sempre un A

3) anche qui, stesso discorso di 2 perchè arrayA è dichiarato come un B quindi andremo a ricercare la firma SOLO nella classe B. escludiamo 
   la firma con i B. arrivati qui, non so quale scegliere tra la firma che prende, come secondo parametro, A oppure Object. anche perchè il secondo parametro è null quindi proprio non saprei. 