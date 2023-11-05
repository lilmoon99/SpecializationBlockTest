package org.example;

import java.util.*;

public class Lottery {
    private ArrayList<Toy> toys;
    private Map<String, Integer> toysFrequency;
    private PriorityQueue<Toy> toysWithTrueRate;

    public Lottery() {
        this.toys =new ArrayList<>();
    }

    public void addToy(Toy toy) {
        for (int i = 0; i < toy.getRate(); i++) {
            this.toys.add(toy);
        }
        initFrequencyMap();
    }
private void updateMapWithFrequency(){
        initFrequencyMap();
        computeFrequency();
}
    private void initFrequencyMap() {
//        PriorityQueue<Toy> tempQueue = new PriorityQueue<>(this.toys);
        this.toysFrequency = new HashMap<>();
        for (Toy toy: this.toys){
            this.toysFrequency.putIfAbsent(toy.getName(),0);
        }
//        while (!tempQueue.isEmpty()) {
////            toysFrequency.put(tempQueue.poll().getName(),0);
//            this.toysFrequency.putIfAbsent(tempQueue.poll().getName(), 1);
//        }
//        System.out.println(this.toysFrequency);
        computeFrequency();
    }

    private void computeFrequency(){
//        PriorityQueue<Toy> tempQueue = new PriorityQueue<>(this.toys);
//        while (!tempQueue.isEmpty()) {
////            toysFrequency.put(tempQueue.poll().getName(),0);
//            Toy temp = tempQueue.poll();
//            if (tempQueue.contains(temp)){
//                int value = this.toysFrequency.get(temp.getName()) + 1;
//                this.toysFrequency.put(temp.getName(), value);
//            }
//        }
        for (Toy toy: this.toys){
            this.toysFrequency.put(toy.getName(),this.toysFrequency.get(toy.getName()) + 1);
        }
//        System.out.println(this.toysFrequency);
        updateRateAndQueue();
    }

    private void updateRateAndQueue(){
        this.toysWithTrueRate = new PriorityQueue<>();
        for (Toy toy:this.toys){
            toy.setRate((float)this.toysFrequency.get(toy.getName())/toys.size());
            toysWithTrueRate.offer(toy);
        }
    }

    public Toy getToy(){
        Set<Toy> tempToys = new HashSet<Toy>();
        PriorityQueue<Toy> tempQueue = new PriorityQueue<>(this.toysWithTrueRate);
        Toy returnToy;
        double rollRate = roll();
        while (!tempQueue.isEmpty()){
            Toy tempToy = tempQueue.poll();
            if (tempToy.getRate() >= rollRate){
                tempToys.add(tempToy);
            }
        }
        if (tempToys.size() > 1){
            returnToy = (Toy) tempToys.toArray()[new Random().nextInt(0,tempToys.size())];
        }else returnToy =  (Toy)tempToys.toArray()[0];
        //TODO нужно проверить исключение outOfBounds
        removeToyFromDatabase(returnToy);
        return returnToy;
    }

    private void removeToyFromDatabase(Toy toyToRemove){
        this.toys.remove(toyToRemove);
        updateMapWithFrequency();
    }

    public double roll(){
        Random random = new Random();
//        double maxBound = (float)this.toysFrequency.values().stream().max(Double::compare).get() / this.toysWithTrueRate.size();
        return random.nextDouble();
    }

    public PriorityQueue<Toy> getToysWithTrueRate() {
        return toysWithTrueRate;
    }
}
