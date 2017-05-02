package com.mxuan.test.volatiletest;

public class ii implements Fon, Inter{
    private final SomeThing someThing = new SomeThing();

    public ii(){
    }

    @Override
    public <T> void p(T a){

        someThing.p(a);
    }
}