package com.company;
import java.util.*;

public class Bug {
    private String descrizioneErrore;
    private String nomeSviluppatore;
    static Set<Bug> erroriNonAssegnati = new HashSet<>();
    static Set<Bug> erroriAssegnati = new HashSet<>();
    Bug(String d){
        this.descrizioneErrore=d;
        erroriNonAssegnati.add(this);  //sto aggiungendo TUTTI gli errori creati al set di bug (tutti perchè è statico).
        //la traccia dice: "Inizialmente, l'errore non è assegnato ad alcuno sviluppatore"
    }

    void assignTo(String nome){
        this.nomeSviluppatore=nome;
        erroriAssegnati.add(this);
        erroriNonAssegnati.remove(this);
    }

    static Set<Bug> getUnassigned(){
        return erroriNonAssegnati;
    }

    static Set<Bug> getAssignedTo(String nome){
        Set<Bug> errSvil = new HashSet<>(); //nuovo insieme che mi servirà a ritornare gli errori assegnati ad un certo sviluppatore.

        for(Bug b : erroriAssegnati){ //scorro nel set di errori assegnati...
            if(b.nomeSviluppatore == nome){ //...se il nome dello sviluppatore corrente è uguale a quello passato per parametro...
                errSvil.add(b);//...allora vuol dire che abbiamo trovato lo sviluppatore associato a quell'errore e possiamo aggiungerlo al nuovo set.
            }
        }
        return errSvil;
        //NOTA: riga 29 non ha this ma b perchè il metodo è statico. this non è statico. b (variabile creata nel for) serve a questo.
    }

    @Override
    public String toString() {
        return "\n"+this.descrizioneErrore + " assigned to: " + this.nomeSviluppatore;
    }
}
