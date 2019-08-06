package com.wenky.ds;

import java.util.*;
import java.util.function.Consumer;

public class RingImpl<T> implements Ring<T>{

    private static final long serialVersionUID = 8683452581122892189L;

    private int capacity,size;
    private Node current;
    private Node[] nodes;
    protected transient int modCount = 0;

    public RingImpl(int capacity){
        this.capacity =capacity;
        nodes=new Node[capacity];
    }

    /**
     * Gives information about the number of elements in the ring.
     * For a newly created ring this is 0.The maximum number of elements is equal to capacity.
     * @return
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Provides information about the capacity of the ring,as specified in the constructor.
     * @return the capacity of the string
     */
    @Override
    public int capacity() {
        return this.capacity;
    }

    /**
     * Inserts the new element o to the left of the current element.The current elements remains unchanged.
     * @param t
     * @return
     * @throws IllegalArgumentException if the ring is full
     */
    @Override
    public boolean add(T t)  throws  IllegalArgumentException{
        if(size==capacity)
            throw new IllegalArgumentException("Ring is Full");
        Node node=new Node(t,current);
        if(current==null)
            current=node;
        else {
            node.left=size==1?current:current.left;
            current.left = node;
        }
        size++;
        modCount++;//to support fail-fast iterators
        return true;
    }


    /**
     *  Makes the left neighbour of the current element the new current element
     * @throws NoSuchElementException if the ring is empty
     */
    @Override
    public void back() throws NoSuchElementException {
        if(size==0)
            throw new NoSuchElementException("Ring is Empty");
        if(size==1)
            return;//we cannot change the Ring at this point.

        Node neighbour=current.left;
        current=neighbour;
    }


    /**
     * Deletes the current element from the ring and makes the element to the right of the element,just deleted the new current element
     * @throws NoSuchElementException if the ring is empty
     */
    @Override
    public void remove()  throws NoSuchElementException{
        if(size==0)
            throw new NoSuchElementException("Ring is Empty");
        Node newCurrent=current.left;

        Set<Node> traversedNodes=new HashSet<>();
        Node tmp=current;
        do{
        }while(((tmp=tmp.left)!=null) && !traversedNodes.add(tmp.left));


        current=tmp.left;
        size--;
    }


    /**
     * Replaces the current element with T and make sthe right neighboiur the new current element.
     * @param o
     * @throws NoSuchElementException if the ring is empty
     */
    @Override
    public void set(T o) throws  NoSuchElementException {
        if(size==0)
            throw new NoSuchElementException("Ring is Empty");
        Set<Node> traversedNodes=new HashSet<>();
        Node tmp=current;
        do{
        }while(((tmp=tmp.left)!=null) && !traversedNodes.add(tmp.left));
        current.value=o;
        current=tmp.left;
    }

    /**
     * Deletes all elements in a ring that are equal to obj.Use equals for comparison.
     * @param obj
     */
    @Override
    public void removeAll(T obj) {
        Set<Node> traversedNodes=new HashSet<>();
        Node tmp=current;
        while(tmp!=null && tmp.left!=null){
            if(obj.equals(tmp.value)) {
                Node s = tmp.left;
                tmp.left = null;
                tmp = s.left;
            }
        }
        current=null;
        this.size=0;
    }

    /**
     * Separates two rings passed as parameters with the same element type to the left of the current element
     * and provides a new ring in which elements of the two original rings are one after the other.
     * In the new ring,the elements of the first parameter come before the elements of the second paramater(when reading from left to right).
     * The current element of the new ring is the current element of the first parameter.
     * Use wildcard types to keep the methodas flexible as possible.
     *
     */
    @Override
    public void merge(Ring r1, Ring r2) {

    }

    public void print(){
        Node tmp=new Node(current);
        if(current==null)
            return;
        Set<Node> traversedNodes=new HashSet<>();
        do{
            if(!traversedNodes.add(tmp))
                break;
            System.out.print(tmp.value+"->");
        }while(((tmp=tmp.left)!=null) && !tmp.left.equals(tmp));

    }
    @Override
    public String toString() {

        return "RingImpl{" +
                "capacity=" + capacity +
                ", current=" + current +
                '}';
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    class RingIterator implements Iterator{

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public Object next() {
            return null;
        }

        @Override
        public void remove() {

        }

        @Override
        public void forEachRemaining(Consumer action) {

        }
    }

    private class Node<T>{
        T value;
        Node left;

        public Node() {
        }

        public Node(Node<T> current) {
            this.value = current.value;
            this.left = current.left;
        }

        public Node(T value, Node left) {
            this.value = value;
            this.left = left;
        }

        public T getValue() {
            return value;
        }

        public Node getLeft() {
            return left;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Node)) return false;
            Node<?> node = (Node<?>) o;
            return Objects.equals(getValue(), node.getValue()) &&
                    Objects.equals(getLeft(), node.getLeft()) ;
        }

        @Override
        public int hashCode() {
            int hashCode = 1;
                hashCode = 31*hashCode + (this.value==null ? 0 : this.value.hashCode());

            return hashCode;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", left=" + left +
                    '}';
        }
    }
}
