package com.mxuan.example.thread.deadlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangwenxuan on 2017/6/19 17.
 */
public class DeadLockDemo{
    private static String A = "A";
    private static String B = "B";

    public static void main(String[] args){
        new DeadLockDemo().deadLock();
    }

    private void deadLock(){
        Thread t1 = new Thread(() ->{
            synchronized(A){
                try{
                    Thread.sleep(5000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                synchronized(B){
                    System.out.println("1");
                }
            }
        });
        ReentrantLock

        Thread t2 = new Thread(() ->{
            synchronized(B){
                try{
                    Thread.sleep(5000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                synchronized(A){
                    System.out.println("2");
                }
            }
        });

        t1.start();
        t2.start();

    }
}
