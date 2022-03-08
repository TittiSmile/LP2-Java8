package com.company;



abstract class Shape{
    public abstract Double width();
    public abstract Double height();
    public abstract Double posX();
    public abstract Double posY();

}

public class Circle extends Shape {
    private Double x,y;
    private Double raggio;
    Circle(Double x, Double y, Double r){
        this.x=x;
        this.y=y;
        this.raggio=r;
    }

    @Override
    public Double width() {
        return null;
    }

    @Override
    public Double height() {
        return null;
    }

    @Override
    public Double posX() {
        return null;
    }

    @Override
    public Double posY() {
        return null;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")\t" + this.raggio;
    }
}
