package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Bug b1 = new Bug("Application crashes on Windows 8");
        Bug b2 = new Bug("Application freezes after 2 hours");
        Bug b3 = new Bug("Application does not print on laser printer");
        Bug b4 = new Bug("Data missing after partial save");

        Set<Bug> unassigned = Bug.getUnassigned();
        System.out.println(unassigned.size()); //4 perchè sono 4 gli errori NON ancora assegnati (di default non sono assegnati).
        b2.assignTo("Paolo");
        b3.assignTo("Filomena");
        b4.assignTo("Filomena");
        System.out.println(unassigned.size());  //1 perchè, dei 4 errori, ne abbiamo assegnati 3.


        Set<Bug> filo = Bug.getAssignedTo("Filomena");
        System.out.println( filo ) ;

    }
}
