package com.company;
import java.util.*;

public class Cellphone {
    private String gestore;
    private String numeroTelefono;
    static Set <Chiamata> set = new HashSet<>();
    static Chiamata call;

    Cellphone(String g, String nt){
        this.gestore=g;
        this.numeroTelefono=nt;
    }

    //Il metodo setCost consente di impostare il costo al minuto di una telefonata con un dato gestore
    //di partenza e un dato gestore di arrivo.
    static void setCost(String g1, String g2, Double c){
        call = new Chiamata(g1, g2, c);
        set.add(call);
    }


    //Il metodo getCost calcola il costo di una telefonata verso
    //una data utenza e di una data durata (in minuti)
    Double getCost(Cellphone c, int min){
        Double risultato=0.0;
        risultato= call.getCosto()*min;
        //come continuare??? mi serve accedere al costo di quella chiamata.
        return risultato;
    }

    @Override
    public String toString() {
        return this.gestore + " " + this.numeroTelefono;
    }
}
