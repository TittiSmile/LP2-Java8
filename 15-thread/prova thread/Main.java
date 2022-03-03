package com.company;
import  java.util.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
       /*
        myClassThread mt = new myClassThread();
        myClassThread mt2 = new myClassThread();
        myClassThread mt3 = new myClassThread();


        myClassRunnable mr = new myClassRunnable();
        Thread t = new Thread(mr);
        Thread t2 = new Thread(mr);
        //mr.interruptExampleR();   //RICORDA  che per accedere a questi metodi devi usare l'oggetto della classe che implementa runnable

        */


        final Object x = new Object();
        final int [] count = new int[1]; // don't do this : use AtomicInteger

        class MyThread extends Thread {
            int id;
            MyThread(int n) { id = n; }

            public void run() {

                synchronized (x) {

                    synchronized (count) {
                        count[0]++;
                        count.notify () ;
                    }
                    try {
                        x.wait();
                    } catch (Exception e) {
                        System.out.println(currentThread().getName()+" Exception");
                        x.notify () ;
                    } finally {
                        System.out.println(currentThread().getName()+" finally");
                        System.out.println(id);
                    }
                }
            }
        }

        Thread t1 =new MyThread(1), t2=new MyThread(2), t3=new MyThread(3);
        t1. start () ; t2.start () ; t3.start () ;

        synchronized (count) {
            while (count[0]<3)
                count.wait();
        }

        t2.interrupt () ;
        t2.join () ;
        System.out.println("Fatto");
    }

}
