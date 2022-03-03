package com.company;
import java.util.*;

//forse è un po' troppo dispendioso ma funziona...
public class Contest<T> {
    private Set<T> setObject; //insieme dei "partecipanti"
    private List<T> listVote; //lista dei voti ai partecipanti.
    private Map<T, Integer> mapVoteContOccurrences; //mappa che mi serve per contare le occorrenze :D
    Contest(){
        setObject=new HashSet<>();
        listVote=new ArrayList<>();
        mapVoteContOccurrences = new HashMap<>();
    }

    void add(T elemento){
        setObject.add(elemento);
    }

    void vote(T elemento){
        if(!setObject.contains(elemento)){
            throw new IllegalArgumentException("voto non valido");
        }
        else{
            listVote.add(elemento);
        }
    }

    T winner(){
        Integer cont = 0;
        //così facendo riesco a risalire alle occorrenze di ogni voto. lo inserisco nella mappa.
        for(T t : listVote){
            cont = mapVoteContOccurrences.get(t);
            if(cont == null){
                mapVoteContOccurrences.put(t, 1);
            }
            else{
                mapVoteContOccurrences.put(t, cont+1);
            }
        }
        int maxOccurence = this.maxValue(mapVoteContOccurrences.values()); //mi trovo il valore massimo di occorrenze nella mappa.

        for(Map.Entry<T, Integer> entry : mapVoteContOccurrences.entrySet()){
            if(entry.getValue().equals(maxOccurence)){ //se il valore massimo equivale al corrente valore della mappa...
                return entry.getKey();  //...allora abbiamo trovato la sua chiave.
            }
        }

        return null;
    }


    Integer maxValue(Collection<Integer> l ){
        Integer max = -1000;
        for(Integer i : l){
            if(i > max){
                max = i;
            }
        }
        return max;
    }


    public List<T> getListVote() {
        return listVote;
    }

    public Set<T> getSetObject() {
        return setObject;
    }

    @Override
    public String toString(){
        return setObject.toString();
    }

}
