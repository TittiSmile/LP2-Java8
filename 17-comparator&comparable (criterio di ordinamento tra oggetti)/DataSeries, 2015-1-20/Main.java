package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        DataSeries pop1 = new DataSeries();
        DataSeries pop2 = new DataSeries();

        pop1.set(2000,15000.0);pop1.set(2005,18500.0);pop1.set(2010,19000.0);
        pop2.set(2000,12000.0);pop2.set(2005,16000.0);pop2.set(2010,21000.0);

        System.out.println(DataSeries.comparatorByYear(2000));
        pop2.print();
    }
}
