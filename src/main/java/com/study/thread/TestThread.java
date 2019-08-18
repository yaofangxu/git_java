package com.study.thread;

public class TestThread extends Thread {
/*
继承创建线程
 */
    public void run() {
        System.out.println(currentThread().getName());
        System.out.println(getId());
        System.out.println(currentThread().getId());
    }

    public static void main(String[] args) {
        TestThread t = new TestThread();
        t.start();
    }



}
