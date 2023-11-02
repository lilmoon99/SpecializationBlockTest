package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Lottery {
    private PriorityQueue<Toy> toys;
    private Map<String, Integer> toysFrequency;

    public Lottery() {
        this.toys = new PriorityQueue<>();
    }

    public void addToy(Toy toy) {
        for (int i = 0; i < toy.getRate(); i++) {
            this.toys.offer(toy);
        }
        initFrequencyMap();
    }

    public void initFrequencyMap() {
        PriorityQueue<Toy> tempQueue = new PriorityQueue<>(this.toys);
        this.toysFrequency = new HashMap<>();

        while (!tempQueue.isEmpty()) {
//            toysFrequency.put(tempQueue.poll().getName(),0);
            this.toysFrequency.putIfAbsent(tempQueue.poll().getName(), 1);
        }
        System.out.println(this.toysFrequency);
        computeFrequency();
    }

    public void computeFrequency(){
        PriorityQueue<Toy> tempQueue = new PriorityQueue<>(this.toys);
        while (!tempQueue.isEmpty()) {
//            toysFrequency.put(tempQueue.poll().getName(),0);
            Toy temp = tempQueue.poll();
            if (tempQueue.contains(temp)){
                int value = this.toysFrequency.get(temp.getName()) + 1;
                this.toysFrequency.put(temp.getName(), value);
            }
        }
        System.out.println(this.toysFrequency);
    }
}
