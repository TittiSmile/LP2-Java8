package com.company;

import java.math.BigInteger;

class Fraction {
    public int numeratore;
    public int denominatore;
    Fraction(int num, int denom){
        this.numeratore=num;
        this.denominatore=denom;
    }

    int MasComDiv(){    //ma se questa funzione la chiamo dalla sottoclasse, this.numeratore è della sottoclasse?
                        // Sì!! questo perchè hai fatto la super che ti va ad associare il num e denum del costruttore della sottoclasse
                        //come this di numeratore e denominatore. chiaramente, nella superclasse sarà this della classe fraction
        int MCD = BigInteger.valueOf(this.numeratore).gcd(BigInteger.valueOf(this.denominatore)).intValue();
        //System.out.println(MCD);
        return MCD;
    }
    static int MasComDiv(int num, int denom ){     //altra funzione perchè così non si hanno problemi col this e chi cazzo è cosa. maledetto java
        //statico perchè così è la prima cosa che viene buttata in memoria, senza non avrei potuto chiamare il super di sotto
        int MCD2 = BigInteger.valueOf(num).gcd(BigInteger.valueOf(denom)).intValue();
        return MCD2;
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

    Fraction times(Fraction a){
        int prodNum = a.numeratore*this.numeratore;
        int prodDenom = a.denominatore*this.denominatore;
        Fraction c = new Fraction(prodNum, prodDenom);
        return c;
    }


    /*public boolean equals(Object o){
       // if(this.numeratore == b.numeratore && this.denominatore == b.denominatore){
        //System.out.println(b.numeratore + "   " + b.denominatore + "  "+ this.scomponiNum()+ "  "+ this.scomponiDenom());
        //if(b.numeratore == this.scomponiNum() && b.denominatore == this.scomponiDenom()){
         //   return true;
        //}
          //  return false;
    }*/


/*
    public boolean equals(Object obj)
    {
        if (obj == null){
            System.out.println("a");
            return false;
        }
        if (getClass() != obj.getClass()){      //si blocca qua perchè chiaramente passo una reduced fraction. quindi impazzisce?
            System.out.println("aa" + getClass() + "   " + obj.getClass() );
            return false;
        }
        Fraction b = (Fraction)obj;
        if((b.numeratore == this.scomponiNum() && b.denominatore == this.scomponiDenom())
                || (b.numeratore == this.numeratore && b.denominatore == this.denominatore)){
            return true;
        }
        System.out.println("aaa" + b.numeratore + " " + this.scomponiNum() + " "+ b.denominatore + " "+ this.scomponiDenom());
        return false;
        //return b.numeratore == this.scomponiNum() && b.denominatore == this.scomponiDenom();    //non posso usare equals perchè sono tutti valori primitivi
                                                                                                // se fossero stati oggetti ci sarebbe voluto equals (credo)

    }
*/

    public boolean equals(Object obj){      //se gli passo un fraction funziona
        if(obj==null){
            return false;
        }
        /*if (obj.getClass()!=getClass())
            return false;
            //questa parte nelle slides è presente. io l'ho tolta perchè sennò non mi fa passare un oggetto della sottoclasse di fraction
            probabilmente non è corretot ma non so che soluzione attuare. quindi lo terrò così.
            nella specifica delle slides si dice che un E nons arà mai uguale ad un M. nell'esercizio, questa cosa non è vera cioè
            una frazione può essere uguale ad una frazione ridotta. quindi credo sia ok togliere quella istruzione.*/
        Fraction f = (Fraction)obj;
        System.out.println(this.scomponiNum() + " " + f.numeratore + " "+ f.denominatore + " "+ this.scomponiDenom());  //mi serve per vedere che stampa
        if(this.scomponiNum() == f.numeratore && this.scomponiDenom() == f.denominatore){
            return true;
        }
        return false;
    }



    @Override
    public String toString() {      //RICORDA che viene ereditato dalla sottoclasse!!!
        return numeratore + "/" + denominatore;
    }
}




class ReducedFraction extends Fraction{
    public int numeratore;
    public int denominatore;
    ReducedFraction(int num, int denom){
        //super(numeratore, denominatore);  //NON so perchè non gli piace. perchè num e denom non sono ancora state chiamate dal main quindi non sa chi/cosa sono
        //super(num,denom);   //sarebbero i parametri passati dal costruttore quando crei un oggetto reducedFraction. EVITA numeri a cazzo
                            //in questo modo passo quei parametri al costruttore della superclasse.
        //this.numeratore=num;        //SUPERFLUO. la super passa num e denom di riducedfraction alla superclasse. l'assegnamento lo fa la superclasse
        //this.denominatore=denom;    //superfluo.

        super(num/MasComDiv(num,denom),denom/MasComDiv(num,denom));   //e che è? semplicemente,visto che l'aggiornamento del numeratore e
                // denominatore si fa sotto e non si vanno ad aggiornare i valori per il
                // metodo times, buttiamo le cose aggiornate direttamente nella chiamata
                //a super così siamo tutti più felici


        //faccio partire la riduzione della frazione.
        this.numeratore = num/MasComDiv(num, denom);
        this.denominatore = denom/MasComDiv(num, denom);
    }

    @Override
    public boolean equals(Object obj){
        if (! super.equals(obj))
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        ReducedFraction rf = (ReducedFraction) obj;
        return rf.numeratore == this.scomponiNum() && rf.denominatore == this.scomponiDenom();
    }

    /*@Override
    public boolean equals(Fraction b){
        if(numeratore == b.scomponiNum() && denominatore == b.scomponiDenom()) {    //metterci b è abbastanza superfluo.
            return true;
        }
        return false;
    }*/


   /* @Override
    public boolean equals(Fraction b){
        if(!super.equals(b)){
            return false;
        }
        int m = MasComDiv(numeratore, denominatore);
        System.out.println(m);
        int newNum = this.numeratore/m;
        int newDenom = this.denominatore/m;
        int newNumF = super.scomponiNum();
        int newDenomF = super.scomponiDenom();
        if(newNum == newNumF && newDenom == newDenomF){
            return true;
        }
        return false;

    }*/

    /*  MEGLIO FARE LA RIDUZIONE NEL COSTRUTTORE!!!
    @Override
    public String toString() {
        int m = MasComDiv();
        String s=String.valueOf(m);
        int newNum = this.numeratore/m;
        int newDenom = this.denominatore/m;
        String s1=String.valueOf(newNum);
        String s2=String.valueOf(newDenom);
        return  s1 +"/" + s2 ;
    }*/
    @Override   //chiaramente ridefinisco tostring perchè altrimenti non mi stampa la frazione ridotta.
    public String toString() {
        return this.numeratore + "/" + this.denominatore;
    }


}


/*normalmente la sottoclasse eredita il toString dalla superclasse (in questo caso Fraction). se non avessi il toString in reducedFraction e stampassi
* un oggetto di tipo reducedFraction, non mi stamperebbe qualcosa di indecifrabile ma mi stamperebbe comunque la sua frazione perchè prende tutto
* dalla toString della sueprclasse.*/





/*
 * DOMANDE:
 * 1- int m = MasComDiv();
 *      D: ma non dovrei accedervi con un oggetto di classe Fraction? o perchè lo eredito non è necessario? boh
 *      R: reductedFraction eredita tutta la merda di fraction. quindi non è necessario mettere un oggetto di quella classe per accedere al
 *          metodo. nel main, ad esempio, si fa perchè main non eredita un cazzo da nessuno. è l'entry point di tutto quanto quindi
 *          devi per forza accedere al metodo con un oggetto di classe fraction o reducedfraction. quando c'è ereditarietà
 *          non è necessario.
 *
 *

 */
