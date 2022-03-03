package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Question q = new Question("Dove si trova Albuquerque?");
        Answer a1 = new Answer(q, "Canada");
        Answer a2 = new Answer(q, "New Mexico");
        a1.voteUp();
        System.out.println(q.getBestAnswer());
        a2.voteUp();
        a2.voteUp();
        System.out.println(q.getBestAnswer());


        //non mi convince molto perchè mi ritorna NON solo la risposta ma anche la sua domanda associata. però yolo, funziona
        //forse andava fatto una lista di riferimento in question

        //System.out.println(a1.f());

    }
}
