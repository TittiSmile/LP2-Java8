public class MyClass {
    static void startAndWaitForOne(Runnable r, int n){
        int i = 0;
        int array[]={0}; //array per vedere chi finisce.

        while(i<n){ //ciclo che viene fatto n volte (andava bene anche un for)
            Thread t = new Thread(){
                @Override
                public void run(){
                    r.run(); //faccio partire il runnable
                    synchronized (array){ //mi sincronizzo sull'array
                        array[0]=1; //se arrivo qui vuol dire che almeno 1 thread è arrivato qua
                        array.notifyAll(); //quindi posso notificare tutti gli altri thread e andare via
                    }
                }
            };
            i++; //incremento
            t.start(); //in questo modo faccio partire il thread n volte.
        }

        synchronized (array){ //mi sincronizzo sull'array
            if(array[0]==0){ //in questo modo, se l'array è ancora 0 (cioè non ha cambiato valore) vuol dire che nessun thread ha finito
                try {
                    array.wait(); //quindi mi metto in attesa (anche perchè se durante l'esecuzione arriva array=1 mi notifica tutto 
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }


    }
}




public class Main {

    public static void main(String[] args) {
        MyClass m = new MyClass();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("thread: " + Thread.currentThread().getName()); //in questo modo capisco quale thread è 
            }
        };
        MyClass.startAndWaitForOne(r,3);
    }
}
