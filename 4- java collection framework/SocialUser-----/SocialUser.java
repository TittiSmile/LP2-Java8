package com.company;
import java.util.*;

public class SocialUser {
    private String nome;
    private String postText;
    private Set<Post> allPosts = new HashSet<>();
    SocialUser(String n){
        this.nome=n;
    }

    Post newPost(String text){
        this.postText=text;
        Post p = new Post((postText));
        return p;
    }


    ArrayList<Integer> findChiocciolaPosition(Post p){
        ArrayList<Integer> arrayChiocciolaPosition = new ArrayList<>();
        Character chiocciola= '@';
        for(int i =0; i<p.str.length();i++){
            if(p.str.charAt(i) == chiocciola){
                arrayChiocciolaPosition.add(i);
            }
        }
        return arrayChiocciolaPosition;
    }

    //trovo il primo carattere " " (=spazio) dopo le chiocciole trovate. (mi serve per ottenere il nome).
    ArrayList<Integer> findEndChiocciolaNomePosition(Post p) {
        ArrayList<Integer> arraySpazioChiocciolaPosition = new ArrayList<>();
        ArrayList<Integer> arrayChiocciolaPosition = this.findChiocciolaPosition(p);
        Character spazio= ' ';
        Character chiocciola= '@';
        int stringSize = p.str.length();
        int i=0;
        System.out.println(arrayChiocciolaPosition.get(0) + "----" + stringSize);

        while(i> arrayChiocciolaPosition.get(0) && i<stringSize){
            if(p.str.charAt(i) == spazio){
                arraySpazioChiocciolaPosition.add(i);
            }
        }

        return arraySpazioChiocciolaPosition;
    }


    class Post{
        private String str;
        Post(String s){
            this.str=s;
        }


        Set<SocialUser> getTagged(){
            Set<SocialUser> s = new HashSet<>();
            String name;

            return s;
        }

        //metodo che mi prende il nome della persona taggata. va dal valore di @ fino al primo spazio.

        String getNameFromText(String s){ //passo il postText.
            while(s!=null){
                int i=0;
            }
            return "a";
        }


        String getAuthor(){
            return nome;
        }






    }
}
