package com.wenky.multithreading;

import java.util.concurrent.CyclicBarrier;

public class Printer  extends  Thread{
    CyclicBarrier cyclicBarrier;
    int sequence;
    public Printer(String name, CyclicBarrier cyclicBarrier,int sequence) {
        this.setName(name);
        this.cyclicBarrier=cyclicBarrier;
        this.sequence=sequence;
    }

    @Override
    public void run() {
        while (true){
            try {
                if(cyclicBarrier.getNumberWaiting()==sequence) {
                    if(cyclicBarrier.getNumberWaiting()==0)
                        System.out.println();
                    System.out.print(this.getName());
                    cyclicBarrier.await();
                }

            }catch (Exception e){e.printStackTrace();}
        }
    }
}
