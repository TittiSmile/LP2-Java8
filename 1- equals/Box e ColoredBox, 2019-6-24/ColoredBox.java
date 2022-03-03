package com.company;

public class ColoredBox extends Box{
    private String color;
    ColoredBox(int x, int y, String c){
        super(x,y);
        this.color=c;
    }

    @Override
    public boolean equals(Object obj){
        if(!super.equals(obj))
            return false;
        if(this.getClass()!=obj.getClass())
            return false;
        ColoredBox c = (ColoredBox)obj;
        return color.equals(c.color);
    }

    public int hashCode(){
        int hash=0;
        hash+=color.hashCode()+super.getX()+super.getY();
        return hash;
    }
}
