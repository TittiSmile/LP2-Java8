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

/*
* allora. voglio spiegare cose.
* in questo esercizio banale, se faccio la add nel costruttore e stampo la lista contenuta nella classe movie, mi stampa
* solo l'elemento con la quale accedo alla get del set<movie> (cioè solo Rocky o solo Rocky II). PERCHè MAI?
* perchè il set è di movie e ogni oggetto della classe movie possiede quest'attributo setMovies che contiene solo il suo nome :D
* non stampa TUTTI quelli che aggiungo nel set attraverso il costruttore (cosa che vorrei) ma aggiunge solo 1 elemento per volta.
* come dicevo, questo è dovuto al fatto che è un set di movie e quindi si aggiunge solo l'oggetto creato (corrente) al
* set senza star lì a vedere chi sono i prossimi.
* COME OVVIARE AL PROBLEMA?
* A- creare il set come STATICO. in questo modo è condiviso con TUTTI gli oggetti Movie e verrà aggiunto un nuovo elemento
*    al set per ogni movie che viene creato.
* B- ci si appoggia ad una classe che si prende il set di movie. in questo modo sarà la classe di supporto ad aggiungere
*    gli elementi (movie) nel set. quindi quando vuoi lavorarci, ci lavori con un oggetto setMovieClass che contiene
*    il set dei movie! è più difficile a dirsi che a farsi ahaha c'è un esempio nel main
*
*  MA COME! IN ESERCIZI PASSATI (radio, greenpass, wifi) IO METTEVO LA COLLEZIONE NELLA CLASSE PRINCIPALE ED ANDAVA!
* vero. ma questo perchè contenevano la loro clase interna!
* ad esempio, in radio la collezione era: Set<Channel>. quindi radio era come una classe di supporto per channel. di
* conseguenza, quando stampavo il set della radio, non avevo problemi perchè c'era la add sulla radio.
*
* that's all folks!
*
* */
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