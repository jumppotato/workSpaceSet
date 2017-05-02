package com.mxuan.test.nio;

/**
 * Created by wangwenxuan on 2017/4/17.
 */
public class Main{

    public static void main(String[] args){
        p();
    }

    static Main main = new Main();

    static {
        System.out.println(1);
        boolean a = true;
    }


    {
        System.out.println(2);
    }

    Main(){
        System.out.println(3);
        System.out.println("a = " + a + " b = " + b);
    }

    static void p(){
        System.out.println(4);
    }

    int a = 110;
    static int b = 112;

}
