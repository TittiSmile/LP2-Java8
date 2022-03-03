package com.company;
//ATTENZIONE. hashcode non coerente per qualche motivo che mi sfugge.

public class Main {

    public static void main(String[] args) {
	// write your code here
        UnorderedPair<String> a = new UnorderedPair<>("uno", "due");
        UnorderedPair<String> b = new UnorderedPair<>("due", "uno");
        UnorderedPair<String> c = new UnorderedPair<>("due", "tre");
        System.out.println(b.equals(c));
        for(String s : b){
            System.out.println(s);
        }

        System.out.println("hashcode A " + a.hashCode());
        System.out.println("hashcode B " + b.hashCode());
        System.out.println("hashcode C " + c.hashCode());

    }
}
