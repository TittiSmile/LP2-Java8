package com.company;

public class Studente { //secondo me gli attributi sono inutili... ma tant'è.
    private String nome;
    private String matricola;
    Studente(String n, String m){
        this.nome=n;
        this.matricola=m;
    }


    static class Triennale{ //in questa versione NON ho messo extends perchè nessuno mi dice che c'è relazione di ereditarietà.
        private String nome;
        private String  matricola;
        private static String prefisso;
        Triennale(String n, String m){
            this.nome=n;
            this.matricola=m;
        }
        static void setPrefisso(String pref){
            prefisso=pref;
        }

        @Override
        public boolean equals(Object o){ //faccio equals nelle singole classi. 
            if(o==null)
                return false;
            if(this.getClass()!=o.getClass())
                return false;
            Studente.Triennale t = (Studente.Triennale)o;
            return (this.matricola.equals(t.matricola)) && (this.nome.equals(t.nome));
        }

        @Override
        public String toString(){ //ma non dovrebbe ereditare il toString? NO. NON CI SONO relazioni di ereditarietà.
            return this.nome + " "+prefisso+ "/" + this.matricola;
        }
    }

    static class Magistrale{
        private String nome;
        private String  matricola;
        private static String prefisso;
        Magistrale(String n, String m){
            this.nome=n;
            this.matricola=m;
        }
        static void setPrefisso(String pref){
            prefisso=pref;
        }
        @Override
        public String toString(){
            return this.nome + " "+prefisso+ "/" + this.matricola;
        }

        @Override
        public boolean equals(Object o){
            if(o==null)
                return false;
            if(this.getClass()!=o.getClass())
                return false;
            Studente.Triennale t = (Studente.Triennale)o;
            return (this.matricola.equals(t.matricola)) && (this.nome.equals(t.nome));
        }


    }

    @Override
    public String toString() {
        return this.nome+ " " + this.matricola;
    }
}
