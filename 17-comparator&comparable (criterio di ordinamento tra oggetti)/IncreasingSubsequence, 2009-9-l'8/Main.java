package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Integer> l = new LinkedList<Integer>();
        l .add(10); l .add(3);
        l .add(5); l .add(12);
        l .add(11); l .add(35);

        IncreasingSubseq<Integer> is = new IncreasingSubseq<>(l);


        for(Integer i : l){
            is.compareTo(i);
        }
    }
}
