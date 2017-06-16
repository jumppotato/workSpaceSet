package com.mxuan;

/**
 * Created by wangwenxuan on 2017/5/16.
 */
public class Main{
    public static void main(String[] args) throws InterruptedException{
        MThread mThread = new MThread();
        mThread.start();
        mThread.sleep(1000);
        mThread.suspend();
        System.out.println("main end");
    }
}

class Target{
    public synchronized void a(){
        System.out.println("A is running");
        try{
            Thread.sleep(5000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("A is end!");
    }

    public synchronized void b(){
        System.out.println("B is running");
        System.out.println("B is end");
    }

}

class MRunnalbe implements Runnable{
    private Target target;
    private int x;

    public MRunnalbe(Target target, int x){
        this.target = target;
        this.x = x;
    }

    @Override
    public void run(){
        if((x & 1) == 0){
            this.target.a();
        }else{
            this.target.b();
        }
    }
}

class MThread extends Thread{

    public MThread(){
    }

    public void run(){
        long beginTime = System.currentTimeMillis();
        int count = 0;
        for(int i = 0; i < 50000000; i++){
            count += i + 1;
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime - beginTime);
    }
}
