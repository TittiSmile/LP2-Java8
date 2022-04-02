package com.company;

public class Student {
    private String nome;
    private long matricola;
    Student(String nome, long matricola){
        this.nome=nome;
        this.matricola=matricola;
    }

   @Override
   public boolean equals(Object obj){
       if(obj==null)
           return false;
       if(this.getClass()!=obj.getClass())
           return false;
       Student s = (Student) obj;
       return this.matricola==s.matricola &&( ((this.nome==null) && (s.nome==null)) || ( (this.nome)==s.nome  )  );
   }

    boolean checkPari(long matricola){
        if(matricola%2==0)
            return true;
        return false;
    }

    boolean checkDispari(long matricola){
        if(matricola%2!=0)
            return true;
        return false;
    }

    @Override
    public String toString(){
        return this.nome + " " + this.matricola;
    }
}













public class Main {

    public static void main(String[] args) {
    // write your code here
        Student s = new Student("pippo", 1000);
        Student s2 = new Student("pippo", 1020);
        Student s3 = new Student("pippo", 1003);
        Student s4 = new Student("pippo", 1001);
        //System.out.println(s4.equals(s3));

        Student s5 = new Student(null, 1000);
        Student s6 = new Student(null, 1000);
        Student s7 = new Student("pippo", 1001);
        Student s8 = new Student("pippo", 1001);
        System.out.println(s8.equals(s7));


    }
}
