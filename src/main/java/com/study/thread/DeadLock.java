package com.study.thread;

public class DeadLock {


    public static void main(String[] args) {


       final Object ob1 =new Object();
       final  Object ob2 = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (ob1){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (ob2){

                        System.out.println("1");

                    }

                }

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {

                synchronized (ob2){

                    synchronized (ob1){

                        System.out.println("2");

                    }

                }

            }
        }).start();



    }
}
