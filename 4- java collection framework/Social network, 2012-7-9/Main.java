package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Person a = new Person("Antonio");
        Person c = new Person("Cleopatra");
        Person o = new Person("Ottaviano");
        a.addEnemy(o);
        a.addFriend(c);
        System.out.println(a.getSetFriends());



        //System.out.println(a.getListOfContacts());

        for (Person p: a.contacts())
            System.out.println(p);
    }
}
