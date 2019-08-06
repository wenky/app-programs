package com.wenky.ds;

public class Main {
    public static void main(String[] args) {
        Ring<Integer> ring=new RingImpl(5);
        System.out.println("Ring size::"+ring.size());
        ring.add(2);
        System.out.println("After adding 2");
        ring.print();
        ring.add(3);
        System.out.println("After adding 3");
        ring.print();
        ring.add(4);
        System.out.println("After adding 4");
        ring.print();
        ring.back();
        System.out.println("After calling back");
        ring.print();
        System.out.println("After removing");
        ring.remove();
        ring.print();

        ring.set(5);
        System.out.println("Setting the current to 5");
        ring.print();

        ring.removeAll(5);
        ring.print();
    }
}
