package com.company;

public class Box {
    private int x, y;
    Box(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public boolean equals(Object obj){
        if(obj==null)
            return false;
        if(this.getClass()!=obj.getClass())
            return false;
        Box b = (Box) obj;
        return x==b.x && y==b.y;
    }

    public int hashCode(){
        //return Objects.hash(x,y);
        int hash=0;
        hash+=x+y;
        return hash;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString(){
        return this.x+" "+this.y;
    }

}
