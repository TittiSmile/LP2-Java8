//è un esercizio preso dalle slides del multithreading. pagina 16
package com.company;
import java.util.*;

public class myClass implements Runnable {
    
        @Override
        public void run() {
            System.out.println("ciao");
        }


    static void periodicJob(Runnable r, int mills){
        try {
            r.run();
            Thread.sleep(mills);
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }
}


public class Main {

    public static void main(String[] args) {
    	myClass mc = new myClass();
        for(int i =0;i<5;i++){  //decido che deve stamparlo per 5 volte ogni 1000 millisecondi.
            myClass.periodicJob(mc, 1000);
        }

    }
}