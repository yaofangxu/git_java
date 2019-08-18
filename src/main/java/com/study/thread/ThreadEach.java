package com.study.thread;

public class ThreadEach {

/*

wait 和 notify 通过一把锁可以互相通信，唤醒

 */
    public static class Person{

        public String name;
        public String sex;
        public boolean flag=false;

    }

    public static class Thread1 extends Thread{
        Person p = null;
        public Thread1(Person s){
            this.p=s;
        }
        @Override
        public void run() {
            int count=0;
            while (true){
                synchronized (p){

                    if(p.flag){
                        try {
                            p.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    if(count%2==0){
                        p.name="姚方旭";
                        p.sex="男";
                    }else {
                        p.name="王莹莹";
                        p.sex="女";
                    }
                    count++;
                    p.flag=true;

                }

                }

        }
    }


    public static class Thread2 extends  Thread{
        Person p= null;
        public Thread2(Person s){
            this.p=s;
        }
        @Override
        public void run() {
            while (true){
                synchronized (p){
                    if(p.flag){
                        System.out.println(p.name+":"+p.sex);
                        p.flag=false;
                        p.notify();
                    }

                }

            }

        }
    }

    public static void main(String[] args) {

        Person p = new Person();
        Thread2 t2 = new Thread2(p);

        Thread1 t1 = new Thread1(p);
        t1.start();
        t2.start();

    }

}
