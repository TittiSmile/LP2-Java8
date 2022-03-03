package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Curriculum cv = new Curriculum("Walter White");
        Curriculum.Job j1 = cv.addJob("Chimico", 1995);
        Curriculum.Job j2 = cv.addJob("Insegnante", 2005);
        Curriculum.Job j3 = cv.addJob("Cuoco", 2009);
        System.out.println(j2 .next());
        System.out.println(j3 .next());
    }
}
