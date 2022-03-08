package com.company;

import java.math.BigInteger;

class Fraction2 {
    public int numeratore;
    public int denominatore;
    Fraction2(int num, int denom){
        this.numeratore=num;
        this.denominatore=denom;
    }

    int MasComDiv(){    
        int MCD = BigInteger.valueOf(this.numeratore).gcd(BigInteger.valueOf(this.denominatore)).intValue();
        return MCD;
    }

    static int MasComDiv2(int num, int denom ){     
        int MCD = BigInteger.valueOf(num).gcd(BigInteger.valueOf(denom)).intValue();
        return MCD;
    }

    Fraction2 times(Fraction2 a){
        int prodNum = a.numeratore*this.numeratore;
        int prodDenom = a.denominatore*this.denominatore;
        Fraction2 c = new Fraction2(prodNum, prodDenom);
        System.out.println("parametro " +  a.numeratore + "  "+ a.denominatore );
        System.out.println("parametro a:" + a);
        return c;
    }

    int scomponiNum(){
        int m = MasComDiv();
        int newNum = this.numeratore/m;
        return newNum;

    }
    int scomponiDenom(){
        int m = MasComDiv();
        int newDenom = this.denominatore/m;
        return newDenom;
    }

    public boolean equals(Object obj){     
        if(obj==null){
            return false;
        }

        Fraction2 f = (Fraction2)obj;
        System.out.println(this.scomponiNum() + " " + f.numeratore + " "+ f.denominatore + " "+ this.scomponiDenom());
        if(this.scomponiNum() == f.numeratore && this.scomponiDenom() == f.denominatore){
            return true;
        }
        return false;
    }


    @Override
    public String toString() {     
        return numeratore + "/" + denominatore;
    }


    void print(){
        System.out.println(this.numeratore + "  "+ this.denominatore); 
    }
}




class ReducedFraction2 extends Fraction2{
    public int numeratore;
    public int denominatore;
    ReducedFraction2(int num, int denom){
        super(num/MasComDiv2(num,denom),denom/MasComDiv2(num,denom));  

        //riduco la frazione
        numeratore = num/MasComDiv2(num, denom);
        denominatore = denom/MasComDiv2(num, denom);
    }



    @Override
    public boolean equals(Object obj){
        if (!super.equals(obj))
            return false;
        if(super.numeratore == this.numeratore && super.denominatore == this.denominatore){
            return true;
        }
        System.out.println(super.numeratore + "  "+ this.numeratore + " "+ super.denominatore+ "  "+ this.denominatore); 
        return false;
    }


    @Override
    public String toString() {
        return this.numeratore + "/" + this.denominatore;
    }
}



