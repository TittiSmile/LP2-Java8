package com.company;

public class Chiamata {
    private String gestoreArrivo;
    private String gestorePartenza;
    private Double costo;

    Chiamata(String ga, String gp, Double c){
        this.gestoreArrivo=ga;
        this.gestorePartenza=gp;
        this.costo=c;
    }

    public Double getCosto() {
        return costo;
    }

    public String getGestoreArrivo() {
        return gestoreArrivo;
    }

    public String getGestorePartenza() {
        return gestorePartenza;
    }

    @Override
    public String toString() {
        return this.gestoreArrivo + " " + this.gestorePartenza + " " + this.costo;
    }
}
