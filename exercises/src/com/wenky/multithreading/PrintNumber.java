package com.wenky.multithreading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PrintNumber extends Thread{
    Predicate<Integer> predicate;
    CyclicBarrier cyclicBarrier;
    int n;
    PrintNumber(Predicate<Integer> predicate, CyclicBarrier cyclicBarrier,int n){
        this.predicate=predicate;
        this.n=n;
        this.cyclicBarrier=cyclicBarrier;
    }

    @Override
    public void run() {
        int i=0;
        try {
            do {
                i=i+1;
                if (this.predicate.test(i))
                    System.out.println(getName()+"-->"+i);
                cyclicBarrier.await();
            }while (i <n);
        }catch (InterruptedException |BrokenBarrierException e){
            e.printStackTrace();
        }
    }
}
