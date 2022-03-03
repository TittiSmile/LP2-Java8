package com.company;

//ATTENZIONE. fa quel che deve. l'unico problema è che il valore di addBonus dovrebbe andare nel getSalary. quello non riesco a farlo.

public class Main {

    public static void main(String[] args) {
	// write your code here
        Progression a = new Progression(1000, 150);
        a.addEmployee("Jesse", 2008);
        a.addEmployee("Gale", 2009);
        a.addBonus("Gale", 2010, 300);

        System.out.println(a.getSalary("Jesse", 2009));
        System.out.println(a.getSalary("Gale", 2010));
        System.out.println(a.getSalary("Gale", 2011));

        System.out.println(a.addBonus("Gale", 2010, 300));
    }
}
