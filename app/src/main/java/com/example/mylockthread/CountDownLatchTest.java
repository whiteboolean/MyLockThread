package com.example.mylockthread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    private static final CountDownLatch countDownLatch  = new CountDownLatch(2);

    public static void main(String[] args) {
            thread1();
            thread2();
        try {
            countDownLatch.await();
            System.out.println("两个线程都跑完了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private static void thread1(){

        new Thread(){
            @Override
            public void run() {
                super.run();
                try {

                    Thread.sleep(3000);
                    System.out.println("线程1跑完了");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }

    private static void thread2(){
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {

                    Thread.sleep(2000);
                    System.out.println("线程2跑完了");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
