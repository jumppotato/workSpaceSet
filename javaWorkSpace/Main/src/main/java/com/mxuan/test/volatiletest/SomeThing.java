package com.mxuan.test.volatiletest;

import java.util.Random;

public class SomeThing implements Inter{
    public SomeThing(){
    }

    @Override
    public <T> void p(T a){
        int count = 0;
        int total = 0;

        count = new Random().nextInt();

        total += count;

    }
}