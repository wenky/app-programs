package com.wenky.ds;

public class Exception1 {

    public void foo() throws RuntimeException{
        System.out.println("111");
        throw  new RuntimeException();
    }

    public static void main(String[] args) {
        System.out.println("2222222");
        new Exception1().foo();
    }
}


class Exception2 extends Exception1{
    @Override
    public void foo(){

    }
}

class CheckedException extends Exception{

}

class Thread1 implements  Runnable{

    @Override
    public void run() throws  RuntimeException {

    }
}