//pre-cond: accetta 2 liste
//post-cond: controlla che contengono gli stessi elementi (secondo equals) anche in ondrine diverso (true). false altrimenti

/*POSSIBILE IMPLEMENTAZIONE
    <T> boolean arePermutations(List<T> a, List<T> b){
        Set<T> s = new HashSet<>(a);
        Set<T> s2 = new HashSet<>(b);
        if(s.equals(s2)){
            return true;
        }
        return false;
    }
*/


a) boolean arePermutations(List<?> a, List<?> b)
/*
funzionalità:	 sì
completezza:	sì
correttezza:	sì
garanzie:		non scrivo sulle liste (leggo al più object)
semplicità: 	0 param
tipo ritorno:	banale

     boolean arePermutations(List<?> a, List<?> b){
        Set<?> s = new HashSet<>(a);		//è legittimo? di che tipo è il set? in realtà puoi sostituirlo con object. 
        Set<?> s2 = new HashSet<>(b);
        if(s.equals(s2)){
            return true;
        }
        return false;
    }

*/

b) <S,T> boolean arePermutations(List<S> a, List<T> b)
/*
funzionalità:	 sì
completezza:	sì
correttezza:	sì
garanzie:		nessuna
semplicità: 	2 param
tipo ritorno:	banale
*/

c) <S> boolean arePermutations(List<S> a, List<S> b)
/*
funzionalità:	 sì
completezza:	no. le liste sono dello stesso tipo
correttezza:	sì
garanzie:		no
semplicità: 	1 param
tipo ritorno:	banale
*/

d) <S> boolean arePermutations(List<? extends S> a, List<? extends S> b)
/*
funzionalità:	 sì
completezza:	sì. se scelgo S=obj posso prendere qualunque lista. 
correttezza:	sì
garanzie:		no scrittura sulla lista
semplicità: 	1 param
tipo ritorno:	banale

     <S> boolean arePermutations(List<? extends S> a, List<? extends S> b){
        Set<S> s = new HashSet<>(a); //posso inserire dei manager in un set di employee
        Set<S> s2 = new HashSet<>(b);
        if(s.equals(s2)){
            return true;
        }
        return false;
    }
*/

e) boolean arePermutations(List<Object> a, List<Object> b)
/*
funzionalità:	 sì
completezza:	no. abbiamo solo object. non posso accettare liste diverse. 
correttezza:	sì
garanzie:		no
semplicità: 	0 param
tipo ritorno:	banale
*/

f) <S, T extends S> boolean arePermutations(List<? extends S> a, List<? extends T> b)
/*
funzionalità:	 sì
completezza:	no. la condizione T extends S impone che T ed S siano imparentati. quindi mi limiterò per forza a sottoclasse-superclasse
correttezza:	sì
garanzie:		no scrittura sulle liste
semplicità: 	2 param
tipo ritorno:	banale
*/











/*
import java.util.*;

public class Main
{
    <T> boolean arePermutations(List<T> a, List<T> b){
        Set<T> s = new HashSet<>(a);
        Set<T> s2 = new HashSet<>(b);
        if(s.equals(s2)){
            return true;
        }
        return false;
    }

    
	public static void main(String[] args) {
		System.out.println("Hello World");
		List<Integer> l = new ArrayList<>();
		List<Integer> l2 = new ArrayList<>();
		Main m = new Main();
		l.add(1);l.add(13);l.add(14);
		l2.add(13);l2.add(1);l2.add(14);
        
        System.out.println(m.arePermutations(l,l2));
	}
}




*/