package com.wenky.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

public class ProducerConsumerProblem {
    public static final int MAX_SIZE = 20;

    public static void main(String[] args) {
        List l=new ArrayList();
        CyclicBarrier cyclicBarrier=new CyclicBarrier(2);
        Producer producer=new Producer(cyclicBarrier,l);
        Consumer consumer=new Consumer(cyclicBarrier,l);
        producer.start();consumer.start();
    }
}
