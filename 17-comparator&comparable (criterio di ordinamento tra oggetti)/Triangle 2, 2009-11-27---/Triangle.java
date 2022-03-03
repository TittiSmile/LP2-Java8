package com.company;

import java.util.*;

//NON riesco ad implementare il metodo similar...

public class Triangle {
    private Integer a, b, c;
    Triangle(Integer a, Integer b, Integer c){
        this.a=a;
        this.b=b;
        this.c=c;
        if((a > b+c) || (b > a+c) || (c > a+b)){
            throw new IllegalArgumentException("non è possibile creare un triangolo");
        }
    }

    public Integer perimetro(){
        return this.a+this.b+this.c;
    }

    public boolean similar(Triangle t){ //hanno gli stessi angoli, ovvero lo stesso rapporto tra i lati.
        //CIOè se la divisione con uno dei loro lati fa resto 0 8 è il doppio di 4. 6 è il doppio di 3. 10 è il doppio di 5
        /*     if(((t.a%this.a==0) || (t.a%this.b==0) || (t.a%this.c==0))
                && ((t.b%this.a==0) || (t.b%this.b==0) || (t.b%this.c==0))
                && (((t.c%this.a==0) || (t.c%this.b==0) || (t.c%this.c==0))) ){
            return true;
        }
        return false;*/

        return true;
    }

    public static  final Comparator<Triangle> perimeterComparator(){ //metodo ANONIMO
        return new Comparator<Triangle>() {
            @Override
            public int compare(Triangle o1, Triangle o2) {
                return o1.perimetro().compareTo(o2.perimetro());
            }
        };
    }


    @Override
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        if(this.getClass()!=o.getClass()){
            return false;
        }
        Triangle t = (Triangle) o;
        return this.perimetro().equals(t.perimetro());
    }

    @Override
    public String toString() {
        return "lato a: " + this.a + "\nlato b: " +this.b+"\nlato c: "+ this.c;
    }
}


class triangleComparator implements Comparator<Triangle>{

    @Override
    public int compare(Triangle o1, Triangle o2) {
        return o1.perimetro().compareTo(o2.perimetro());
    }
}