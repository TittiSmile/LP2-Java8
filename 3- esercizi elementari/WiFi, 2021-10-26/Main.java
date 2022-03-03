package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        WiFi manager = new WiFi();
        WiFi.Network home = manager.addNetwork("Vodafone", -40.5);
        WiFi.Network hotel = manager.addNetwork("Hotel Vesuvio",-53.05);
        WiFi.Network neighbor = manager.addNetwork("Casa Esposito",-48.95);
        neighbor.updateStrength(-39.6);
        System.out.println(manager.getRete());


        WiFi.Network x = manager.strongest();
        System.out.println(x);
    }
}
