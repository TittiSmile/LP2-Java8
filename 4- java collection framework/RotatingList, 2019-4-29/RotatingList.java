package com.company;
import java.awt.image.TileObserver;
import java.util.*;

public class RotatingList<T> {
    private List<T> list;
    RotatingList(){
        list = new LinkedList<>();
    }

    public void add(T elem){
        list.add(elem);
    }

    public void rotateLeft(){ //eh non so come si fa
        //il primo elemento viene spostato in coda, il secondo in testa, il terzo in coda al secondo e così via
        Iterator it = list.iterator();
        int dimList = list.size();
        T lastElement = list.get(dimList);

    }


    @Override
    public boolean equals(Object obj){
        if(obj==null)
            return false;
        if(this.getClass()!=obj.getClass())
            return false;
        RotatingList r = (RotatingList) obj;

        return this.checkContains(r);
    }


    public boolean checkContains(RotatingList<T> r){ //mi serve per l'equals. gli passo un oggetto rotating list (che sarebbe r di equals)
        int sizeList = list.size(); //stabilisco le dimensioni
        int sizeListParam = r.list.size();
        //questo perchè se la prima lista fosse più piccola della seconda, non si va a scorrere tutto ciò che contiene l'altra!
        //esempio: 1, 2, 1       2, 1, 2, 2, 25
        //se non ci fosse stata questa casistica ma avessi fatto scorrere solo la prima lista (list), il confronto con
        // r.list avrebbe dato true perchè r.list contiene 1 e 2. chiaramente, sarebbe saltato il controllo con 25.
        //quindi bisogna far scorrere la lista che ha più elementi in modo tale da non perdere nulla per la strada!!!!
        if(sizeList>=sizeListParam){
            for(T t : list){
                if(!r.list.contains(t)) //se avessi cambiato la condizione e il return, ritornava true perchè bastava trovare 1 occorrenza che
                                        //esistesse per uscire. INVECE qua bisogna trovare quella che non c'è. quindi alla prima occorrenza che
                                        //non corrisponde, si ritorna falso e si sce.
                    return false;
            }
        }
        else if(sizeList<sizeListParam){
            for(T t : r.list){
                if(!list.contains(t))
                    return false;
            }
        }

        return true;
    }


    @Override
    public String toString(){
        return list.toString();
    }

}
