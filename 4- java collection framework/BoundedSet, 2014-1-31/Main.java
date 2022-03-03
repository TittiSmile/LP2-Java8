package com.company;
import java.util.*;

//non è perfetto. cioè a funzionare funziona PERò se provo a rifare questo giochetto non funziona più
//secondo me vanno aggiornate posizioni e cazzi vari. con l'iteratore non va

public class Main {

    public static void main(String[] args) {
        BoundedSet<Integer> s = new BoundedSet<Integer>(3);
        s.add(3); s.add(8); s.add(5); s.add(5);
        System.out.println("insieme: " + s);
        System.out.println("dimensione insieme: " + s.size());
        System.out.println(s.contains(3));
        s.add(14);
        System.out.println("insieme: " + s);
        System.out.println(s.size()) ;
        System.out.println(s.contains(3)) ;

    }
}
