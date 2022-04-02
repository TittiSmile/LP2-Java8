package com.company;
import java.util.*;

public class Curriculum {
    private String nome;
    private List<Job> listJob; //viene detto che un curriculum è una "sequenza" di job.
    Curriculum(String n){
        this.nome=n;
        listJob=new ArrayList<>();
    }

    Job addJob(String impiego, Integer data){
        Job j = new Job(impiego, data);
        listJob.add(j);
        return j;
    }

    @Override
    public String toString() {
        return listJob.toString();
    }

    class Job{
        private String impiego;
        private Integer data;
        Job(String i, Integer d){ //un job è caratterizzato da impiego e data di inizio.
            this.impiego=i;
            this.data=d;
        }

        Job next(){

            try{

                return listJob.get(listJob.indexOf(this)+1) ;

            }catch(IndexOutOfBoundsException e){
                return null;
            }

        }

        @Override
        public String toString() {
            return this.impiego + " " + this.data;
        }
    }



}
