package com.company;

import java.util.*;
//se non volessi usare sorted set? vedi sotto.
//NON aggiorna il segnale nel set. è come se dovesse rifare l'ordinamento.

public class WiFi implements Iterable<WiFi.Network> {
    private SortedSet<Network> rete; //ho usato un set perchè mi immagino che non posso avere duplicati. posso avere più "vodafone" ma NON con lo stesso segnale
    WiFi(){
        rete=new TreeSet<>(comp);
    }
    public Network addNetwork(String n, Double s){
        Network net = new Network(n, s);
        rete.add(net);
        return net;
    }

    public Network strongest(){
        return rete.first();
    }

    Comparator<Network> comp = new Comparator<Network>() {
        @Override
        public int compare(Network o1, Network o2) {
            return o2.segnale.compareTo(o1.segnale);
        }
    };

    public SortedSet<Network> getRete() {
        return rete;
    }
    public Iterator<Network> iterator(){
        return rete.iterator();
    }


    class Network{
        private String nome;
        private Double segnale;
        Network(String n, Double s){
            this.nome=n;
            this.segnale=s;
            if(s>0){
                throw new IllegalArgumentException("errore");
            }
        }

        public void  updateStrength(Double s){
            if (s>0){
                throw  new IllegalArgumentException("errore");
            }
            this.segnale=s;
            /*Double newSegnale = this.segnale=s;
            for(Network n : rete){
                if(n.segnale.equals(this.segnale)){
                    n.segnale=newSegnale;
                }
            }*/

        }

        @Override
        public String toString(){
            return this.nome+" "+ this.segnale;
        }

    }

}


/*
public class WiFi{
    private List<Network> listNet;
    WiFi(){
        listNet = new ArrayList<>();
    }

    public Network addNetwork(String n, Double s){
        Network net = new Network(n,s);
        listNet.add(net);
        Collections.sort(listNet,comp);
        return net;
    }

    Comparator<Network> comp = new Comparator<Network>() {
        @Override
        public int compare(Network o1, Network o2) {
            return o2.segnale.compareTo(o1.segnale);
        }
    };

    public Network strongest(){
        return  listNet.get(0);
    }

    class Network{
        private String nome;
        private Double segnale;
        Network(String n, Double s){
            if(s>0){
                throw new IllegalArgumentException("errore");
            }
            this.segnale=s;
            this.nome=n;
        }
        public void updateStrength(Double d){
            if(d>0){
                throw new IllegalArgumentException("errore");
            }
            this.segnale=d;
        }


        @Override
        public String toString(){
            return this.nome+" "+this.segnale;
        }
    }

    public List<Network> getListNet() {
        return listNet;
    }

    @Override
    public String toString(){
        return listNet.toString();
    }

}
*/