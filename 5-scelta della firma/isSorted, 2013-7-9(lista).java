public class AnotherClass {
    <S> boolean isSorted(List<? extends S> x, Comparator<? super S> c){
        int len = x.size()-1;
        for(int i=0; i<len;i++){
            if(c.compare(x.get(i),x.get(i+1))>0){
                return false;
            }
        }
        return true;
    }
}



//a parte l'implementazione che è diversa, la scelta migliore è quella simile ad isSorted con la collezione








public static void main(){
    AnotherClass a = new AnotherClass();
    LinkedList<Integer> x = new LinkedList<>();
    x.add(1);x.add(13);x.add(14);x.add(16);x.add(19);
    Comparator<Integer> comp = new Comparator<Integer>() {
               @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            };
    System.out.println(a.isSorted(x,comp));
}