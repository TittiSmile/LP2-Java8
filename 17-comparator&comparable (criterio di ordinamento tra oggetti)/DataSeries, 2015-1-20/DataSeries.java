package com.company;
import javax.xml.crypto.Data;
import java.util.*;

//NON sono sicura della correttezza. non mi convince. una soluzione sta sul forum.

public class DataSeries implements Comparator<DataSeries>{
    Map<Integer, Double> m = new HashMap<>();


    public static final Comparator<DataSeries> comparatorByYear(int year){ //metodo ANONIMA.
        System.out.println("aaaa");
        return new DataSeries(){ //metodo anonimo in un ritorno di funzione. si può fare.
                public int compare(DataSeries o1, DataSeries o2){
                    for(Double d : m.values()){
                        if(o1.m.get(year)<o2.m.get(year))
                            return -1;
                        else if(o1.m.get(year)>o2.m.get(year))
                            return 1;
                    }
                    return 0;
                }
        };
    }

    public void print(){
        System.out.println(m);
    }

    public void set(Integer a, Double p){
        m.put(a,p);
    }


    @Override
    public int compare(DataSeries o1, DataSeries o2) {


        return 0;
    }
}
