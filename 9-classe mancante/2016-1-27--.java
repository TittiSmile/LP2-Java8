public class A
{
	public static <S,T extends S> void f(Set<S> set1, Set<T> set2)
	{
		B.process(set1 , set2) ;
		B.process(set2 , set1) ;
		B<S> b = new B<S>();
		S choice1 = b.select (set1) ,
			choice2 = b.select (set2) ;
		Collection<? extends S> c = b.filter(set1);
		HashSet<? super S> hs = b.filter(set1);
	}
}

class B<T>{
	public B(){}
	public static <S> void process(Set<S>set1, Set<S>set2){	}

	S select(Set<S> set1){S s = null; return s;}

	Collection<S> filter(Set<s> set1){return new Collection<S>();}



}

//NON é CORRETTOOOOO