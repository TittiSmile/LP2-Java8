package com.company;

//perchè equals va nonostante non abbia fatto nessun confronto con i prefissi?
//semplice. equals, quando confronti anna1 e anna2 darà sempre false perchè appartengono a due classi diverse
//quindi, per questo motivo, è anche inutile andare e confrontare il prefisso (senza considerare che, essendo statico, 
//non si può star lì a fare confronti vari.)

public class Main {
    public static void main(String[] args) {
	// write your code here
        Studente.Triennale. setPrefisso ("N86");
        Studente.Magistrale. setPrefisso ("N97");
        Object luca1 = new Studente.Triennale("Luca", "004312");
        Object luca2 = new Studente.Triennale("Luca", "004312");
        Object anna1 = new Studente.Triennale("Anna", "004312");
        Object anna2 = new Studente.Magistrale("Anna", "004312");

        System.out.println(luca1.equals(luca2)) ;
        System.out.println(anna1.equals(anna2));
        System.out.println(anna1);

    }
}

