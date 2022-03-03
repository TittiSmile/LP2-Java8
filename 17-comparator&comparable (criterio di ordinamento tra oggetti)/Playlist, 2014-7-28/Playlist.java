package com.company;
import java.util.*;

public class Playlist implements Comparable<Playlist> {
    private List<Song> listSongs;
    Playlist(){
        listSongs = new LinkedList<Song>();
    }

    public void add(Song s){
        listSongs.add(s);
    }

    public void remove(Song s){ //rimuove TUTTE le occorrenze di una canzone dalla lista.
        Iterator<Song> it = listSongs.iterator();
        while(it.hasNext()){
            if(s.equals(it.next())){
                it.remove();
            }
        }
    }

    public int sumTime(){ //mi serve per contare la durata di tutte le canzoni in una lista di canzoni :D
        int contTime = 0;
        for(Song s : listSongs){
            contTime += s.getTime();
        }
        return contTime;
    }

    @Override
    public int compareTo(Playlist o) {
       if(this.sumTime() < o.sumTime()){
           return -1;
       }
       else if (this.sumTime() > o.sumTime()){
           return 1;
       }
        return 0;
    }

    @Override
    public String toString() {
        String listString = listSongs.toString();
        return listString;
    }
}