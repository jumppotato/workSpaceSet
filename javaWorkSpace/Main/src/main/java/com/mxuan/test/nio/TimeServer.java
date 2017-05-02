package com.mxuan.test.nio;

import java.io.IOException;

/**
 * Created by wangwenxuan on 2017/4/11.
 */
public class TimeServer{
    public static void main(String[] args) throws IOException{
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(getPort());
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }

    private static int getPort(){
        return 8080;
    }
}
