package com.company;

public class GuessTheNumber implements Runnable {
    private int numero;
    private long durata;
    private Thread t = new Thread(this);

    GuessTheNumber(int num, long dur){
        this.numero=num;
        this.durata=dur;
        try{
            Thread.sleep(dur);
        }catch (Exception e){
            System.out.println("errore");
        }
        System.out.println("Fine gioco.");
    }


    public boolean guessAndWait(){

    }

    @Override
    public void run() {

    }
}
