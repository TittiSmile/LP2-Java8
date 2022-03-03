package com.company;

//non riesco a fare la parte di isIncompatible
public class Main {

    public static void main(String[] args) {
	// write your code here
        Controller c = new Controller();
        Controller .Function ac = c.addFunction("Aria condizionata");
        Controller .Function risc = c.addFunction("Riscaldamento");
        Controller .Function sedile = c.addFunction("Sedile riscaldato");

        ac.setIncompatible(risc ) ;
        ac.setIncompatible(sedile ) ;
        ac.turnOn();
        c.printOn();
        System.out.println("----");


        risc .turnOn();
        sedile .turnOn();
        c.printOn();


    }
}
