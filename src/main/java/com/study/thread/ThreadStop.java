package com.study.thread;

public class ThreadStop {
    private String name="yao";

    public static class Thread001 extends Thread{

        private static volatile  boolean flag=false;
        @Override
        public void run() {

                while (!flag){
                    try {
                        Thread.sleep(50000);
                    } catch (InterruptedException e) {


                    }
                    System.out.println("1");
                }
            System.out.println("ddddd");

                }

        public void stopThis(){

            this.flag=true;
        }
    }



    public static void main(String[] args) {

        Thread001 t= new Thread001();
        t.start();


        for(int i=1;i<=30;i++){

            if(i==25){
                try {
                    Thread.sleep(1000);
                    t.interrupt();
                    t.stopThis();

                    System.out.println("main");
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }


            }


        }


    }
}
