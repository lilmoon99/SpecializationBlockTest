package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Lottery lottery = new Lottery();
        Toy toy1 = new Toy(1,2,"Blue tracktor");
        Toy toy2 = new Toy(2,2,"Barbie");
        Toy toy3 = new Toy(3,6,"Doctor's kit");

        lottery.addToy(toy1);
        lottery.addToy(toy2);
        lottery.addToy(toy3);
        for (int i = 0; i < 10; i++) {
            System.out.println(lottery.getToy());
            System.out.println(lottery.getToysWithTrueRate());
        }

    }
}