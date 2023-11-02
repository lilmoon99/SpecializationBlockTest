package org.example;

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

    }
}