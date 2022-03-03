package com.company;

public class myClassRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("metodo run Runnable");
        System.out.println(Thread.currentThread().getName());
        for(int i = 0; i< 5;i++){
            try{
                Thread.sleep(500);
            }catch(Exception e){
                System.out.println(e);
            }
            System.out.println(i);
        }
    }

    void interruptExampleR(){
        try{
            Thread.currentThread().interrupt(); //non avendo l'estensione di Thread, bisogna usare i metodi statici
        }catch(Exception e){
            System.out.println("interruzione");
        }
    }

    boolean checkInterruptionR(){
        return Thread.currentThread().isInterrupted();
    }

    void joinExampleR(Thread t){    //perchè gli faccio passare un parametro? perchè...
        try{
            //Thread.currentThread().join(); //...si metterebbe in attesa su se stesso!
            t.join();
        }catch(Exception e){
            System.out.println("errore");
        }
        System.out.println("esco da join");
    }

    Thread checkCurrentThreadR(){
        return Thread.currentThread();
    }

    void sleepExampleR(){

        try{
            System.out.println("zzz...");
            for(int i = 0; i< 5;i++){
                Thread.sleep(500);
                System.out.println("...");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("O.O");
    }


}
