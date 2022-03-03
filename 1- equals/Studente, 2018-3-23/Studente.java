package com.company;
//RICORDA che le classi/attributi/metodi statici vengono caricati per primi in memoria.


public class Studente {
    private String nome;
    private int matricola;
    private static String pref = null;
    Studente(String n, int m){
        this.nome=n;
        this.matricola=m;
    }
    /*static String setPrefisso(String prefisso){   //non ha molto senso metterlo qui perchè viene sovrascritta ogni cosa (verrà preso sempre 97). è un metodo statico quindi verrà caricato subito in memoria.
        pref=prefisso;
        System.out.println("setPrefisso:  " + pref);
        return pref;
    }*/

    public boolean equals(Object obj){
        if(obj==null)
            return false;
        Studente s = (Studente)obj;
        if(obj.getClass()!=this.getClass())
            return false;
        return this.nome.equals(s.nome) && this.matricola==s.matricola;
    }


   static class Triennale extends Studente{   //perchè classe interna? semplicemente, nel caso d'uso c'è la dicitura: "Studente.Triennale(..)"
       static String p = null;
       Triennale(String name, int mat){
           super(name, mat);
           this.p=setPrefisso(p);   //questo posso farlo perchè setPrefisso è STATICO!!! altrimenti non avrei potuto farlo.
       }

       static String setPrefisso(String prefisso){
           p=prefisso;
          // System.out.println("setPrefissoT:  " +p);
           return p;
       }


       @Override
       public boolean equals(Object obj){
           if (! super.equals(obj))
               return false;
           Triennale t = (Triennale)obj;
           if(obj.getClass()!=this.getClass())
               return false;
           return this.p==t.p;
       }

       @Override
       public String toString() {
           return super.nome + " " + this.p + super.matricola;
      }
   }

    static class Magistrale extends Studente{
        static String p = null;
        Magistrale(String name, int mat){
            super(name, mat);
            this.p=setPrefisso(p);
        }

        static String setPrefisso(String prefisso){
            p=prefisso;
            //System.out.println("setPrefissoT:  " +p);
            return p;
        }

        @Override
        public boolean equals(Object obj){
            if (! super.equals(obj))
                return false;
            Triennale t = (Triennale)obj;
            if(obj.getClass()!=this.getClass())
                return false;
            return this.p==t.p;
        }



        @Override
        public String toString() {
            return super.nome + " " + this.p + super.matricola;
        }
    }


}

