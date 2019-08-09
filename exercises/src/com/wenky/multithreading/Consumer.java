package com.wenky.multithreading;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Consumer  extends Thread{
    CyclicBarrier cyclicBarrier;
    List shared;
    Consumer(CyclicBarrier cyclicBarrier, List shared){
        this.cyclicBarrier=cyclicBarrier;
        this.shared=shared;
    }
    @Override
    public void run() {
        int i=0;
        try {
            while (true) {
                if(i>=ProducerConsumerProblem.MAX_SIZE)
                    i=0;
                if (this.shared.isEmpty()) {
                    System.out.println("No Items..");
                    cyclicBarrier.await();
                }
                this.shared.remove(i);
            }
        }catch (InterruptedException|BrokenBarrierException e){
            e.printStackTrace();
        }
    }
}
