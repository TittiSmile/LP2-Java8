public class Main
{
	public static void main(String[] args) {
		Short s = 10;
		Integer a = 10;
		Double b = 11.0;
		Number aa = a;
		Number bb = b;
		System.out.println( ((Object) s) == ((Object) a) );//1
		System.out.println(aa == a);//2
		System.out.println(a.getClass() .equals(aa.getClass())) ;//3
		System.out.println(aa.getClass() .equals(bb.getClass())) ;//4
		Object o = s;
		System.out.println(o.getClass() .equals(Short.class)) ;	//5	
		
	}
}
//OUTPUT: false, true, true, false, true
/*
1-	il cast NON cambia l'uguaglianza. in questo caso, il cast serve solo a rendere possibile fare ==. normalmente, non potrei fare 
	un'ugaglianza tra due oggetti NON imparentati. integer e short sono 2 tipi a parte. 
2-	confronto possibile. qui si va a vedere il tipo dichiarato. integer (a) è integer mentre number (aa) è dichiarato come tipo effettivo
	uguale ad un integer. quindi integer è uguale ad integer.
3-	anche qua si va a confrontare il tipo effettivo. sono entrambi 2 integer quindi va bene così.
4-	si va a confrontare il tipo effettivo. aa è uguale ad un integer mentre bb è uguale ad un double. di conseguenza NON sono uguali
	sono due classi a parte. 
5- 	l'operatore class va a valutare il tipo DICHIARATO. quindi. il getClass (tipo effettivo) di o è s cioè uno short mentre
	la classe dichiarata di Short è proprio short. quindi va bene così.
*/





























































///OLD, ho sbagliato a scrivere
import java.util.*;
public class Main
{
	public static void main(String[] args) {
		System.out.println("Hello World");
		Short s = 10;
		Integer a = 10;
		Double b = 11.0;
		Number aa = a;
		Number bb = b;
		
		System.out.println( ((Object)s) == ((Object)a));
		System.out.println(aa==a);
		System.out.println( a.getClass().equals(aa.getClass()) );
		System.out.println( aa.getClass().equals(a.getClass()) );
		Object o = s;
		System.out.println( o.getClass().equals(Short.class));
		
		
	}
}

/*
riga 12- FALSO. il cast non cambia la natura degli oggetti. normalmente il confronto sarebbe IMPOSSIBILE (sono due tipi diversi, short è 
		 sottotipo) di integer. quindi sono diversi. 
riga 13- VERO. questo perchè number aa è dichiarato uguale ad a (integer). quindi è come se "puntassero" allo stesso oggetto. in maniera
		 del tutto equivalente: se Number aa=10 sarebbe stato ancora true. 
riga 14- VERO. aa viene reso uguale ad a. quindi appartengono alla stessa classe. ricorda che number è un'interfaccia che viene 
		 implementata da integer, double ecc. 
		 se number aa = 10 sarebbe stato ancora vero. 
		 se number aa = 10.0 sarebbe stato FALSO perchè sarebbe stato implementato da Double (che è diverso da integer)
riga 15- VERO. banalmente, la relazione di equivalenza (equals) è riflessiva, simmetrica e transitiva. quindi, per la simmetria, se 
		 la riga 14 era vera, allora anche questa lo è. 
riga 17- VERO. non cadere in errore eheh. il metodo getClass ritorna il nome del tipo EFFETTIVO dell'oggetto (quindi short)
		 il metodo .class applicato alla classe, ritorna il nome della classe. quindi sì, short è uguale a short. 



*/