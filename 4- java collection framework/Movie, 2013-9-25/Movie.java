package com.company;
import java.util.*;
public class Movie {
    private String titolo;
    private Integer annoProduzione;
    private static Set<Movie> setMovies= new HashSet<>();
    private List<Movie> listMovieSeries = new LinkedList<>();
    Movie(String t, Integer a){
        this.titolo=t;
        this.annoProduzione=a;
        setMovies.add(this);
    }
    Movie(String t, Integer a, Movie prequel){
        this.titolo=t;
        this.annoProduzione=a;
        setMovies.add(this);
        listMovieSeries.add(prequel);
    }

    List<Movie> getSeries(){
        listMovieSeries.add(this);
        return listMovieSeries;
    }

    static Set<Movie> selectByYear(Integer anno){
        Set<Movie> setMovieYears = new HashSet<>();
        for(Movie m : setMovies){
            if(m.annoProduzione.equals(anno)){
                setMovieYears.add(m);
            }
        }
        return setMovieYears;
    }



    public List<Movie> getListMovieSeries() {
        return listMovieSeries;
    }

    public Set<Movie> getSetMovies() {
        return setMovies;
    }

    @Override
    public String toString() {
        return this.titolo + " " + this.annoProduzione;
    }

}


class setMovieClass{
    private Set<Movie> s;
    setMovieClass(){
        s = new HashSet();
    }

    Movie addMovie(Movie m){
        s.add(m);
        return m;
    }
    void printSet(){
        System.out.println(s);
    }

    public Set<Movie> getS() {
        return s;
    }
}