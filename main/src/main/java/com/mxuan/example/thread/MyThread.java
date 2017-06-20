package com.mxuan.example.thread;

/**
 * Created by wangwenxuan on 2017/6/17 23.
 */
public class MyThread extends Thread{
    public Object lock;
    private String showChar;

    private int showNumPosition;
    private int printCount = 0;
    volatile private static int addNumber = 1;

    public MyThread(Object lock, String showChar, int showNumPosition){
        super();
        this.lock = lock;
        this.showChar = showChar;
        this.showNumPosition = showNumPosition;
    }

    @Override
    public void run(){
        try{
            synchronized(lock){
                while(true){
                    if(addNumber % 3 == showNumPosition){
                        System.out.println("ThreadName = " + Thread.currentThread().getName() + " runCount = " + addNumber + " " + showChar);
                        lock.notifyAll();
                        addNumber++;
                        printCount++;
                        if(printCount == 3){
                            break;
                        }
                    }else{
                        lock.wait();
                    }
                }
            }
        }catch(Exception e){

        }
    }
}

class Run{
    public static void main(String[] args){
        Object lock = new Object();
        MyThread a = new MyThread(lock, "A", 1);
        MyThread b = new MyThread(lock, "B", 2);
        MyThread c = new MyThread(lock, "C", 0);

        a.start();
        b.start();
        c.start();
    }
}
