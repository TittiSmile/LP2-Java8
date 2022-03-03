public class MyClass {
    int getTheShortest(Runnable r, Runnable r2){
        final int array[] = {0};
        Thread t1 = new Thread(){
            @Override
            public void run(){
                r.run();
                synchronized (array){
                    array[0]=1; //è il primo runnable
                }
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run(){
                r2.run();
                synchronized (array){
                    array[0]=2; // qui è il secondo runnable
                }
            }
        };

        t1.start(); //faccio partire i 2 thread
        t2.start();
        try {
            t1.join(); //chiaramente li aspetto
            t2.join();
        }catch (Exception e){
            e.printStackTrace(); //stampo l'eventuale eccezione
        }

        return array[0]; //ritorno l'array e conterrà un valore che avrà  1 o 2
    }
}




public class Main {

    public static void main(String[] args) {
        MyClass m = new MyClass();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("primo runnable");
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("secondo runnable");
            }
        };
       System.out.println( m.getTheShortest(r,r2)); //mi stamperà 1 o 2 a seconda dei casi.

    }
}