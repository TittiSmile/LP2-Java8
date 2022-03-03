package com.company;
import java.util.*;

public class Progression {
    private Integer salarioBase;
    private Integer incrementoAnnuo;
    private Set<Employee> setEmp; //così evitiamo duplicati.


    Progression(Integer s, Integer i){
        this.salarioBase=s;
        this.incrementoAnnuo=i;
        setEmp=new HashSet<>();
    }


    public Integer getIncrementoAnnuo() {
        return incrementoAnnuo;
    }

    public Integer getSalarioBase() {
        return salarioBase;
    }

    public Set<Employee> getSetEmp() {
        return setEmp;
    }

    void addEmployee(String nome, Integer annoAssunzione){
        Employee e = new Employee(nome, annoAssunzione);
        setEmp.add(e);
    }

    Employee findEmployeeByName(String name){ //mi serve per trovare l'impiegato in base al nome.
        for(Employee e : setEmp){
            if(e.nome.equals(name)){
                return e;
            }
        }
        return null;
    }

    Integer getSalary(String nomeImpiegato, Integer anno){
        //controllo se c'è nomeimpiegato nella lista.
        //se c'è faccio la differenza tra anno e annoAssunzione.
        //la differenza la moltiplico per incremento annuo.
        //il salario finale sarà salarioBase+moltiplicazione
        Employee e = findEmployeeByName(nomeImpiegato);
        int differenzaAnni=0;
        int salarioFinale=0;
        if(setEmp.contains(e)){
            differenzaAnni=anno-e.annoAssunzione;
            if(differenzaAnni>0){
                salarioFinale=salarioBase+(incrementoAnnuo*differenzaAnni);

            }
            else{
                salarioFinale=salarioBase;
            }
        }
        return salarioFinale;
    }


    //il caso d'uso di addBonus è diverso da quello specificato nella traccia. nel caso d'uso si limita ad aggiungere il bonus di
    //quell'anno al salarioBase+incremento annuo.
    Integer addBonus(String nome, Integer anno, Integer bonus){
        Employee e = findEmployeeByName(nome);
        e.bonus=bonus;
        int salarioFinale=getSalary(nome,anno);
        int differenzaAnni=0;
        if(setEmp.contains(e)){

            salarioFinale+=bonus;
        }
        return salarioFinale;
    }


    @Override
    public String toString() {
        return this.salarioBase + " " + this.incrementoAnnuo;
    }





    class Employee{
        private String nome;
        private Integer annoAssunzione;
        private Integer bonus;
        Employee(String n, Integer a){
            this.nome=n;
            this.annoAssunzione=a;
        }

        @Override
        public String toString() {
            return this.nome +" " + this.annoAssunzione;
        }
    }



}
