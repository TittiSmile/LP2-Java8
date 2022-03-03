public class A extends B<Object> {
	private B<?> b;
	private String msg;
	public A() {
		b = new B<Object>(null);
		msg = B.<A>buildMessage(this);
	}
	public Set<? super Number> f(Set<Integer> set1, Set<String> set2) {
		for (Integer n: b)
			if (b.check(set1, n))
				return b.process(set1, set2 , n);
		return b.process(set2, set1 , null);
	}
}


/*
1-	B è parametrico perchè da riga 5 si vede che prende un parametro. in più a riga 9 si itera su B. io posso iterare solo con SUPERTIPI
	quindi va da sè che B è sottotipo di Integer. quindi posso metterci integer e sottotipi. 
2-	primo costruttore SENZA argomenti perchè a riga 4 il costruttore di A NON fa nessuna super. 
3-	costruttore CON argomenti in quanto a riga 5 gli viene passato ull come parametro.
4-	è un metodo statico perchè ci accedo con B. ritorna una stringa perchè msg è una stringa. this è un'istanza della classe A e
	ritorno una stringa qualsiasi.
5-	è booleano perchè si trova nell'if e deve tornarmi true o false. prende il tipo del primo set (quindi un T qualunque) ed un integer.
*/
class B<T> implements Iterable<Integer>{ 	//1
    B(){} 										//2
    B(T t){}								//3

    public static String buildMessage(A a){		//4
        return "a";
    }

    @Override
    public Iterator<Integer> iterator(){
        return null;
    }

    public boolean check(Set<?> set1, Integer n){  return true;  } //5

    public Set<? super Number> process(Set<String > set1, Set<Integer> set2, Integer n){ //NON SO  COME FARE
        return new HashSet<Number>();
    }
   

}


//IL METODO PROCESS è SBAGLIATO IN B. NON SO COME FARLO!!!!
//la cosa strana è che se in B metto il metodo:
/*Set<? super Number> a(){
        return  new HashSet<Object>();
    }
  mi dice che il tipo di ritorno non va bene quando NORMALMENTE object, come tipo di ritorno in un metodo i ? super va BENISSIMO
*/
