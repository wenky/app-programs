package com.wenky.multithreading;

import java.util.concurrent.CyclicBarrier;

public class PrintNumbers {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(2);
        PrintNumber oddThread=new PrintNumber(n->n%2!=0,cyclicBarrier,10);
        PrintNumber evenThread=new PrintNumber(n->n%2==0,cyclicBarrier,10);
        oddThread.setName("Odd Thread");
        evenThread.setName("Even Thread");
        oddThread.start();
        evenThread.start();
    }
}
