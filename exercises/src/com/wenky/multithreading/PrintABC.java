package com.wenky.multithreading;

import java.util.concurrent.CyclicBarrier;

/**
 * Program to Print ABC ABC ABC ..
 */
public class PrintABC {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
        Printer a=new Printer("A",cyclicBarrier,0);
        Printer b=new Printer("B",cyclicBarrier,1);
        Printer c=new Printer("C",cyclicBarrier,2);
        a.start();b.start();c.start();

    }
}
