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
            /*dà ECCEZIONE.
            int index = 0;
            Iterator<Job> it = listJob.iterator();
            if(index<(listJob.size())-1){
                index++;
                return listJob.get(listJob.indexOf(this)+1);
            }

            return null;*/

            //grazie webbe
            try{

                return listJob.get(listJob.indexOf(this)+1) ;

            }catch(IndexOutOfBoundsException e){
                return null;
            }
            //forse andrebbe un iteratore.. qualcosa del genere:
            /* Iterator<Job> it = jobSet.iterator();
            while(it.hasNext()){
                return it.next();
            }
            return null;
            
            NON FUNZIONA, sob*/
        }

        @Override
        public String toString() {
            return this.impiego + " " + this.data;
        }
    }



}
