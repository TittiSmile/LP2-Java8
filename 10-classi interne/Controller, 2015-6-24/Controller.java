package com.company;
import java.util.*;

public class Controller {
    private Set<Function> setFunction = new HashSet<>();
    private Set<Function> setFunctionON = new HashSet<>();
    private Set<Function> setFunctionOFF = new HashSet<>();


    Controller(){}

    Function addFunction(String s){
        Function f = new Function(s);
        setFunction.add(f);
        return f;
    }

    void printOn(){
        System.out.println(setFunctionON);
    }

    public Set<Function> getSetFunction() {
        return setFunction;
    }

    public Set<Function> getSetFunctionOFF() {
        return setFunctionOFF;
    }

    public Set<Function> getSetFunctionON() {
        return setFunctionON;
    }

    class Function{
        private String myFunction;
        private boolean isIncompatible=false;
        private Set<Function> thisFunction = new HashSet<>();
        Function(String f){
            this.myFunction=f;
        }

        void turnOn(){
            setFunctionON.add(this);
            if(setFunctionOFF.contains(this)){
                Iterator<Function> it = setFunctionOFF.iterator();
                while(it.hasNext()){
                    if(it.next().equals(this)){
                        it.remove();
                    }
                }
            }
            //controllo su thisFunction. se l'elemento corrente è uguale ad uno che si trova in setFunctionON ed è diverso da this, elimina.
           if(isIncompatible){
               System.out.println("dentro if: "+isIncompatible);
               for(Function f : thisFunction){
                   System.out.println("f:"+f+" setfunctionON contiene: "+setFunctionON.contains(f) + "  f!=this: "+ (f!=this));
                   if(setFunctionON.contains(f) && f!=this){
                       setFunctionON.remove(f);
                   }
               }
           }


        }

        void turnOff(){
            setFunctionOFF.add(this);
            if(setFunctionON.contains(this)){
                Iterator<Function> it = setFunctionON.iterator();
                while(it.hasNext()){
                    if(it.next().equals(this)){
                        it.remove();
                    }
                }
            }
        }


        Function setIncompatible(Function f){ //probabilmente non è qui dove devo lanciare l'eccezione.
            //sono incompatibili se this ed f sono entrambe accese
            this.isIncompatible=true;
            thisFunction.add(this);
            //System.out.println(isIncompatible + " - " + f + " - " + thisFunction);
            return f;
        }


        @Override
        public String toString() {
            return this.myFunction;
        }
    }







}
