
public class Interruptor extends Thread { //non sono sicura che vada messo extends... al più poteva essere fatto tutto nel costruttore ma
                                          // non mi sentivo sicura a metterlo lì.
    private Thread myThread;
    private int secondi;

    @Override
    public void run(){
        try {
            Thread.currentThread().sleep(secondi);
        }catch (InterruptedException e){
            System.out.println(e);
        }
        Thread.currentThread().interrupt();
    }

    Interruptor(Thread t, int secondi){
        this.myThread=t;
        this.secondi=secondi;
        t.start();

        /*//questo sarebbe il costruttore con la soluzione.
        public Interruptor(Thread t, int s) {
		new Thread() {
			@Override
			public void run() {
				try {
					Thread.sleep(s * 1000);
				} catch (InterruptedException i) {
					return;
				}
				t.interrupt();


		    	}
		    }.start();
	    } */

    }

}


public class Main {

    public static void main(String[] args) {
        Interruptor i = new Interruptor(new Thread() {
            @Override
            public void run() { //è stato creato un metodo run apposta. serve per far vedere che viene interrotto e poi ripreso ogni 10 secondi.
                for (int i = 0; i < 10; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                }
            }
        }, 10); //sono 2 parametri. il new Thread che ha tutto questo bordello e l'intero. 


    }
}