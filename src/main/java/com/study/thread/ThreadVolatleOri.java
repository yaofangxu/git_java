package com.study.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadVolatleOri extends Thread{

    /*
    AtomicInteger保证原子性

     */
   // public static volatile int count=0;
    private static AtomicInteger a= new AtomicInteger(0);

    public void run() {
        for (int i = 0; i < 10; i++) {
            //System.out.println(currentThread().getId()+"----------------");
            a.incrementAndGet();
            //System.out.println(currentThread().getName()+"-------"+a);
        }


        System.out.println(currentThread().getName()+"---j----"+a);
    }

    public static void main(String[] args) {

        ThreadVolatleOri[] p  =new ThreadVolatleOri[10];

        for (int i = 0; i < p.length; i++) {

            p[i]=new ThreadVolatleOri();


        }


        for (ThreadVolatleOri s:p
             ) {


            s.start();

        }


    }
}
