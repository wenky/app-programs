package com.wenky.ds;
public interface Ring<T> extends Iterable<T> {

    int size();
    int capacity();
    boolean add(T t);
    void back();
    void remove();
    void set(T t);
    void removeAll(T t);
    void merge(Ring r1, Ring r2);
    void print();
}
