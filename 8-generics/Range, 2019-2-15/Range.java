package com.company;
import java.util.*;

public class Range<T extends Comparable<T>> {
    private T min;
    private T max;
    Range(T min, T max){
        this.max=max;
        this.min=min;
    }

    boolean isInside(T x){
        if(x.compareTo(min)>=0 && x.compareTo(max)<=0){
            return true;
        }
        return false;
    }

    boolean isOverlapping(Range<T> r){
        if(r.min.compareTo(min)>0 && r.max.compareTo(max)<0)
            return true;
        return false;
    }

    @Override
    public boolean equals(Object obj){
        if(obj==null)
            return false;
        if(this.getClass()!=obj.getClass())
            return false;
        Range r = (Range) obj;
        return (this.min==r.min) && (this.max==r.max);
    }

    public int hashCode(){
        return Objects.hash(min,max);
    }


    @Override
    public String toString(){
        return this.max + " " + this.min;
    }
}
