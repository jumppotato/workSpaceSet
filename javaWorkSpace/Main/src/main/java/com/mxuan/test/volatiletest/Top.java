package com.mxuan.test.volatiletest;

import java.util.Random;

public class Top{

    public static void main(String[] args){

    }

    public int getStr(){
        int result = 0;
        int temp = 0;

        temp = new Random().nextInt();

        result += temp;
        return result;
    }
}