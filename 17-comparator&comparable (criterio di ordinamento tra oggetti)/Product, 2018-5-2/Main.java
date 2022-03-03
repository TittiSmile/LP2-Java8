package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Product a = new Product("Sale", 0.60);
        Product b = new Product("Zucchero", 0.95);
        Product c = new Product("Caffè", 2.54);

        System.out.println(Product.getMostExpensive());
        System.out.println(b.compareTo(c));
        System.out.println(Product.comparatorByPrice.compare(b,c));


        System.out.println(a.equals(a));
        System.out.println(a.compareTo(a));
        System.out.println(a.hashCode());
    }
}
