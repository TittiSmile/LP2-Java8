package com.company;

public class Engine {
    private Integer cilindrata;
    private Integer cavalli;
    Engine(Integer ci, Integer ca){
        this.cilindrata=ci;
        this.cavalli=ca;
    }

    public Engine byVolume(){ //metodo ANONIMO (grazie forum, non ci sarei mai arrivata <3)
        return new Engine(cilindrata, cavalli){
            @Override
            public boolean equals(Object obj){
                if(obj==null){
                    return false;
                }
                if(this.getClass()!=obj.getClass()){
                    return false;
                }
                Engine e = (Engine) obj;
                return cilindrata.equals(e.cilindrata);
            }
        };
    }

    public Engine byPower(){
        return new Engine(cilindrata, cavalli){
            @Override
            public boolean equals(Object obj){
                if(obj==null){
                    return false;
                }
                if(this.getClass()!=obj.getClass()){
                    return false;
                }
                Engine e = (Engine) obj;
                return cavalli.equals(e.cavalli);
            }
        };
    }



    @Override
    public boolean equals(Object obj){
        if(obj==null){
            return false;
        }
        if(this.getClass()!=obj.getClass()){
            return false;
        }
        Engine e = (Engine) obj;
        return this.cilindrata.equals(e.cilindrata) && this.cavalli.equals(e.cavalli);
    }

    @Override
    public String toString() {
        return this.cilindrata + ".0 cm3, " + this.cavalli + ".0 CV";
    }
}
