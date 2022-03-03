package com.company;
import java.util.*;

public class Radio implements Iterable<Radio.Channel> {
    private SortedSet<Channel> setChannel;
    Radio(){
        setChannel= new TreeSet<>(comp); //in questo modo il set di channel sarà già ordinato
    }

    public Channel addChannel(String n, Double f){
        Channel c = new Channel(n,f);
        for(Channel i : setChannel){
            if(i.frequenzaStazione.equals(c.frequenzaStazione)){ //nel set NON ci sono duplicati, vero. ma possiamo avere 2 stazioni con nomi
                                                                // diversi e frequenze uguali. quello non va bene. quindi se c'è un uguaglianza tra
                                                                //f passato e una frequenza già presente, si lancia eccezione.

                throw new IllegalArgumentException("errore");
            }
        }

        setChannel.add(c); //se non si è nella condizione di throw blablabla allora aggiungiamo al set
        return c;
    }

    public Channel nearest(Double f){
        Double min = 1000.0; //valore minimo. devo trovare la stazione più vicina.
        Double difference = 0.0; //valore di differenza
        Channel newChannel = null; //dichiaro un new channel dichiarato a null.
        for(Channel c : setChannel){ //scorro il set.
            difference = Math.abs(c.frequenzaStazione-f); //mi calcolo la differenza in valore assoluto perchè altrimenti diventa tutto più complicato
            if(difference<min){ //se la differenza è più piccola del minimo...
                min = difference; //...allora il minimo diventa la differenza
                newChannel=c; //il newChannel diventa il c corrente
            }
        }
        return newChannel;
    }



    public Set<Channel> getSetChannel() {
        return setChannel;
    }

    Comparator<Channel> comp = new Comparator<Channel>() { //comparatore che mi serve a confrontare in modo CRECENTE le stazioni
        @Override
        public int compare(Channel o1, Channel o2) {
            return o1.frequenzaStazione.compareTo(o2.frequenzaStazione);
        }
    };

    public Iterator<Channel> iterator(){
        return setChannel.iterator(); //ritorno l'iteratore del set.
    }





    class Channel{
        private String nomeStazione;
        private Double frequenzaStazione;
        Channel(String n, Double f){
            this.nomeStazione=n;
            this.frequenzaStazione=f;
        }

        @Override
        public String toString(){
            return this.nomeStazione+"  ("+this.frequenzaStazione+")";
        }

    }

    @Override
    public String toString(){
        return this.setChannel.toString();
    }

}
