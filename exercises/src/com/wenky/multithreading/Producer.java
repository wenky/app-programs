package com.wenky.multithreading;

import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Producer extends Thread{

    CyclicBarrier cyclicBarrier;
    List shared;
    Producer(CyclicBarrier cyclicBarrier,List shared){
        this.cyclicBarrier=cyclicBarrier;
        this.shared=shared;
    }
    @Override
    public void run() {
        try {
            while (true) {
                if (shared.size()==ProducerConsumerProblem.MAX_SIZE) {
                    System.out.println("Limit reached..");
                    cyclicBarrier.await();
                }
                shared.add(new Object());
            }
        }catch (InterruptedException|BrokenBarrierException e){
            e.printStackTrace();
        }
    }
}
