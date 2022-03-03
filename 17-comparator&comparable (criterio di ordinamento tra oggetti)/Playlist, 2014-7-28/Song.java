package com.company;

public class Song {
    private String name;
    private Integer time; //sarebbe la durata della canzone
    Song(String n, Integer t){
        this.name=n;
        this.time=t;
    }

    public String getName(){ //serve per ritornare gli attributi privati
        return this.name;
    }
    public Integer getTime(){
        return this.time;
    }

    @Override
    public boolean equals(Object obj){ //lo faccio perchè così, nel remove, ho più facilità ad eliminare una song.
        //due song sono UGUALI se hanno stesso nome e stessa durata.
        if(obj==null)
            return false;
        if(this.getClass()!=obj.getClass())
            return false;
        Song s = (Song) obj;
        return this.name.equals(s.name) && this.time.equals(s.time); //due equals perchè name e time sono tipi wrapper

    }

    @Override
    public String toString() {
        return this.name + " " + this.time;
    }
}
