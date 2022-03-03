package com.company;

public class Main {

    public static void main(String[] args) {
        Studente.Triennale.setPrefisso("N86");
        Studente.Magistrale.setPrefisso("N97");     //mi prende solo questo.
        Object luca1 = new Studente.Triennale("Luca", 1234);
        Object luca2 = new Studente.Triennale("Luca", 1234);
        Object anna1 = new Studente.Triennale("Anna", 1234);
        Object anna2 = new Studente.Magistrale("Anna", 1234);
        System.out.println(luca1);
        System.out.println(luca2);
        System.out.println(anna1);
        System.out.println(anna2);

        System.out.println(luca1.equals(luca2)) ;
        System.out.println(anna1.equals(anna2));

        /*Object o = new Studente("paolo", 12);
        Object p = new Studente("paolllo", 12);
        System.out.println(p.equals(o));*/


        //System.out.println(anna2 instanceof Studente);                true
        //System.out.println(anna2 instanceof Studente.Triennale);      false
        //System.out.println(anna2 instanceof Studente.Magistrale);     true






        /*Studente2.Triennale2.setPrefisso("N86");        //per usare setPrefisso devo farla per forza statica perchè triennale e magistrale sono statiche.
        Studente2.Magistrale2.setPrefisso("N97");
        Object luca1 = new Studente2.Triennale2("Luca", 1234);
        Object luca2 = new Studente2.Magistrale2("Luca", 1234);
        System.out.println(luca1);
        System.out.println(luca2);*/





    }
}


/*
*       DOMANDE:
* 1- perchè triennale è statica? cosa mi fa capire che è tale?
* 2- se è realmente statica, non può ereditare gli attributi di studente. quindi come faccio funzionare la super nel costruttore? bohboh
*    R: in realtà non c'entra nulla con quello che eredita... semplicemente gli passa al costruttore gli argomenti della triennale (nome e matricola)
* */