//pre-cond: accetta due insiemi A B ed un comparatore
//post-cond: ritorna il più grande elemento di A che è più piccolo di tutti gli elementi di B. se non esiste, torna null.
			 //(nell'esempio prende degli insiemi di ugual dimensione)
//ESEMPIO: a={5,20,30} b={25,26,30}	ritorno=20

	//POSSIBILE IMPLEMENTAZIONE 
    <T> T gLB(Set<T> a, Set<T> b, Comparator<T> c){
        List<T> la = new ArrayList<>(a);
        List<T> lb = new ArrayList<>(b);
        Collections.sort(la, c);
        Collections.sort(lb, c);
        T minListB = lb.get(0);
        T maxA = null;
        for(T t : la){
            if(c.compare(t, minListB) < 0 ){
                    maxA=t;
            }
        }
        return maxA;
    }

																						

a) <T> T gLB(Set<? extends T> a, Set<? extends T> b, Comparator<T> c)
/*
funzionalità:	sì, non devo scrivere sui set. quindi avere ? extends non mi dà problemi
completezza:	sì. questo perchè il set a è dello stesso tipo del comparatore. al più prende i sottotipi.
correttezza:	sì (non ci sono condizioni particolari da rispettare nella pre-condizione)
garanzie:		no scrittura sugli insiemi
semplicità: 	1 param
tipo ritorno:	coerente
*/


b) <S,T> Object gLB(Set<S> a, Set<T> b, Comparator<Object> c)
/*
funzionalità:	sì,  il comparator è su object quindi prende come parametro 2 object (che in questo caso sono a b)
completezza:	no, non accetta altri tipi al di fuori di object per il comparatore.
correttezza:	sì
garanzie:		no
semplicità: 	2 param.
tipo ritorno:	troppo generico (obj prende tutto).
                un tipo di ritorno ideale ptrebbe essere S. questo perchè deve essere dello stesso tipo del set a
*/


c) <T> T gLB(Set<T> a, Set<T> b, Comparator<? super T> c)			
/*
funzionalità:	sì
completezza:	no, c'è solo T come parametro. 
correttezza:	sì
garanzie:		leggo object sul comparatore. 
semplicità: 	1 param
tipo ritorno:	coerente (ritorna lo stesso tipo del set di a quindi ok)
*/



d) <S,T extends S> S gLB(Set<S> a, Set<T> b, Comparator<S> c)
/*
funzionalità:	sì
completezza:	no, comparatore deve essere per forza dello stesso tipo di a. e questa cosa non è del tutto vera. 
                dalla pre-cond io devo poter accettare set e comparator di qualunque tipo. qui sono "costretta" ad 
                usare S. 
                ad esempio: set<emp> set<emp> comp<person>-> NON POSSO
                IN PIù, il vincolo t ext s mi IMPONE di passare dei set imparentati. dalla pre-cond, io capisco che
                posso passare qualunque set (anche diversi) e qualunque comparator. ma, in questa firma, posso passare
                un set di employee ed uno di stringhe? NO. = non completa
correttezza:	sì
garanzie:		nessuna
semplicità: 	2 param
tipo ritorno:	coerente
*/



e) <T> T gLB(Set<? super T> a, Set<? super T> b, Comparator<T> c)
/*
funzionalità:	no. il comparatore è sul tipo della sottoclasse. i set possono prendere, come parametro, dei tipi della superclasse
completezza:	
correttezza:	
garanzie:	
semplicità: 	
tipo ritorno:	
*/




//firma migliore secondo me (simile alla d):
<T>T gLB(Set<? extends T> a, Set<? extends T> b, Comparator<? super T> c)
//ci dà più garanzie sul comparatore (lettura di object) e ci dà più scelta sul tipo dei set.











/*	non mi ritorna null però. andrebbe fatto un controllo esterno 
<T> T gLB(Set<T> a, Set<T> b, Comparator<T> c){
        List<T> la = new ArrayList<>(a);
        List<T> lb = new ArrayList<>(b);
        Collections.sort(la, c);
        Collections.sort(lb, c);
        T minListB = lb.get(0);
        T max = la.get(0);
        for(T t : la){
            if(c.compare(t, minListB) < 0 ){
                if(c.compare(t, max)>0 ){
                    max=t;
                }
            }
        }
        return max;
    }

*/


