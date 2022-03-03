package com.company;

import java.math.BigInteger;

class Fraction2 {
    public int numeratore;
    public int denominatore;
    Fraction2(int num, int denom){
        this.numeratore=num;
        this.denominatore=denom;
    }

    int MasComDiv(){    //ma se questa funzione la chiamo dalla sottoclasse, this.numeratore è della sottoclasse?
                        //Sì!! questo perchè hai fatto la super che ti va ad associare il num e denum del costruttore della sottoclasse
                        //come this di numeratore e denominatore. chiaramente, nella superclasse sarà this della classe fraction
        int MCD = BigInteger.valueOf(this.numeratore).gcd(BigInteger.valueOf(this.denominatore)).intValue();
        return MCD;
    }

    static int MasComDiv2(int num, int denom ){     //altra funzione perchè così non si hanno problemi col this e chi cazzo è cosa. maledetto java
                                                    //statico perchè così è la prima cosa che viene buttata in memoria, senza non avrei potuto chiamare il super di sotto
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

    public boolean equals(Object obj){      //se gli passo un fraction funziona
        if(obj==null){
            return false;
        }

        Fraction2 f = (Fraction2)obj;
        System.out.println(this.scomponiNum() + " " + f.numeratore + " "+ f.denominatore + " "+ this.scomponiDenom());
        //if(this.numeratore==f.numeratore && this.denominatore == f.denominatore){
        if(this.scomponiNum() == f.numeratore && this.scomponiDenom() == f.denominatore){
            return true;
        }
        //System.out.println(f.numeratore + " " + this.numeratore + " "+ f.denominatore + " "+ this.denominatore);

        return false;
    }


    @Override
    public String toString() {      //RICORDA che viene ereditato dalla sottoclasse!!!
        return numeratore + "/" + denominatore;
    }


    void print(){
        System.out.println(this.numeratore + "  "+ this.denominatore); //qui num e denom sono 12 e 30. perchè in equals della sottoclasse sono 2 e 5?
    }
}




class ReducedFraction2 extends Fraction2{
    public int numeratore;
    public int denominatore;
    ReducedFraction2(int num, int denom){
        super(num/MasComDiv2(num,denom),denom/MasComDiv2(num,denom));   //e che è? semplicemente,visto che l'aggiornamento del numeratore e
                                                                                    // denominatore si fa sotto e non si vanno ad aggiornare i valori per il
                                                                                   // metodo times, buttiamo le cose aggiornate direttamente nella chiamata
                                                                                   //a super così siamo tutti più felici

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
        System.out.println(super.numeratore + "  "+ this.numeratore + " "+ super.denominatore+ "  "+ this.denominatore); //come mai il super di denominatore è 5? non dvorebbe essere 30?
        return false;
    }


    @Override
    public String toString() {
        return this.numeratore + "/" + this.denominatore;
    }
}



