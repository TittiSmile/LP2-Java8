package com.company;

public class Box implements Comparable<Box>{
    private Integer altezza;
    private Integer larghezza;
    private Integer profond;
    private Integer volume;

    Box(Integer a, Integer l, Integer p){
        this.altezza=a;
        this.larghezza=l;
        this.profond=p;
        volume = a*l*p;
    }

    public Integer getVolume(){
        return this.volume;
    }

    public boolean fitsIn(Box y){
        if(   (this.altezza <= y.altezza) && (this.larghezza <= y.larghezza) && (this.profond <= y.profond)){
            return true;
        }
        return false;
    }

    @Override
    public int compareTo(Box o) {
        if(this.volume.compareTo(o.volume) > 0){
            return 1;
        }
        else if(this.volume.compareTo(o.volume) < 0){
            return -1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null)
            return false;
        if(this.getClass()!=obj.getClass())
            return false;
        Box b = (Box) obj;
        if((this.altezza.equals(b.altezza)) &&  (this.larghezza.equals(b.larghezza)) && (this.profond.equals(b.profond)))
            return true;
        return false;
    }

    @Override
    public int hashCode() {
        return this.altezza.hashCode() + this.profond.hashCode() + this.larghezza.hashCode();
    }
}
