 public static void main(String[] args) {
	// write your code here
        Short s = 10;
        Integer a = 10;
        Float f = new Float(10f);
        Number aa = a;
        Object o = f;
        System.out.println((Object)s == (Object)a); //1
        System.out.println( (s+1) == (a+1) );       //2
        System.out.println( aa == a );              //3
        System.out.println( a.getClass().equals(aa.getClass())); //4
        System.out.println( o.getClass().equals(f.getClass())); //5
        System.out.println( o.getClass().equals(Object.class)); //6
    }
//OUTPUT: false true true true true false 
/*spiego output
1- il cast NON cambia le uguaglianze. s ed a sono di due tipi diversi. immagina come se fossero employee e manager. 
2- a quanto pare qua si sta confrontando il numero. è una somma quindi 11 è uguale ad 11. la somma mi ha indotto in errore
3- questo perchè number è dichiarato uguale ad integer. anche se il tipo dichiarato (number) è diverso da integer non cambia.
   vale a chi lo hai reso uguale.
4- getClass ritorna il tipo effettivo. quindi. aa è dichiarato come integer. ed integer è uguale ad integer
5- getClass ritorna il tipo effettivo dell'oggetto (quindi quello dopo =). in questo caso si tratta di o dichiarato come float.
   quindi sono uguali per questo motivo. 
6- l'operatore class ritorna il tipo DICHIARATO dell'oggetto. quindi object. di conseguenza, il getClass di o è float e il .class
   di object è object. quindi falso. 
*/