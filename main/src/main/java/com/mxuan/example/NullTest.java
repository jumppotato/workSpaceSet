package com.mxuan.example;

/**
 * Created by wangwenxuan on 2017/5/9.
 */
public class NullTest{
    public static void main(String[] args){
        AThread aThread = new AThread();
        aThread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println("A异常了");
        });
        BThread bThread = new BThread();
        bThread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println("B异常了");
        });

        aThread.start();
        bThread.start();
    }

}

class BThread extends Thread{

    @Override
    public void run(){
        Double b = null;
        b.toString();
    }

}

class AThread extends Thread{
    @Override
    public void run(){
        Double b = null;
        b.toString();
    }

}
