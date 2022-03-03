package com.company;

public class myClassThread extends Thread {

    myClassThread(){}

    public void run(){
        System.out.println("metodo run Thread");
        for(int i = 0; i< 5;i++){
           try{
               myClassThread.sleep(500);
           }catch(Exception e){
               System.out.println(e);
           }
            System.out.println(i);
        }
        System.out.println(Thread.currentThread().getName());

    }


    void interruptExampleT(){
        try{
            this.interrupt();
        }catch(Exception e){
            System.out.println("interruzione");
        }
    }

    boolean checkInterruptionT(){
        return this.isInterrupted();
    }

    void joinExampleT(){
        try {
            this.join();
        }catch(Exception e){
            System.out.println(e);
        }
    }

    Thread checkCurrentThreadT(){
        return currentThread();
    }

    void sleepExampleT(){
        try{
            System.out.println("zzz...");
            for(int i = 0; i< 5;i++){
                myClassThread.sleep(1000);
                System.out.println("...");
            }


        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("O.O");
        //l'effetto occhi aperti viene meglio se non c'è il for nel run.
    }

}
