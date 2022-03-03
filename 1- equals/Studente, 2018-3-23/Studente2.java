package com.company;

public class Studente2 {
    private String nome;
    private int matricola;
    private String pref = null;
    Studente2(String n, int m){
        this.nome=n;
        this.matricola=m;
    }

    static class Triennale2 extends Studente2{   //perchè classe interna? semplicemente, nel caso d'uso c'è la dicitura: "Studente.Triennale(..)"
        static String p = null;
        Triennale2(String name, int mat){
            super(name, mat);
            this.p=setPrefisso(p);
        }

        static String setPrefisso(String prefisso){
            p=prefisso;
            System.out.println("setPrefissoT:  " +p);
            return p;
        }

        @Override
        public String toString() {
            return super.nome + " " + this.p + super.matricola;
        }
    }

    static class Magistrale2 extends Studente2{
        static String p = null;
        Magistrale2(String name, int mat){
            super(name, mat);
            this.p=setPrefisso(p);
        }

        static String setPrefisso(String prefisso){
            p=prefisso;
            System.out.println("setPrefissoT:  " +p);
            return p;
        }

        @Override
        public String toString() {
            return super.nome + " " + this.p + super.matricola;
        }
    }


}

