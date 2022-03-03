package com.company;

//NON COMPLETO. ho difficoltà a rintracciare il nome dalla stringa.


public class Main {

    public static void main(String[] args) {
	// write your code here
        SocialUser adriana = new SocialUser("Adriana");
        SocialUser barbara = new SocialUser("Barbara");
        SocialUser.Post p = adriana.newPost("Ecco una foto con @Barbara e @Carla.");


        System.out.println(adriana.findChiocciolaPosition(p));
        System.out.println(adriana.findEndChiocciolaNomePosition(p));

        System.out.println(p.getAuthor());
    }
}
