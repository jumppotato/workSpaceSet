package com.mxuan.test.wio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

/**
 * Created by wangwenxuan on 2017/4/11.
 */
public class TimeServerHandler implements Runnable{
    private Socket socket;

    public TimeServerHandler(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try(BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
             PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true)){

            while(true){
                String body = in.readLine();
                if(body == null){
                    break;
                }
                System.out.println("The time server receive order : " + body);
                String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ?
                        new Date(System.currentTimeMillis()).toString()
                        : "BAD ORDER";
                out.println(currentTime);
            }

        }catch(Exception e){
             e.printStackTrace();
        }
    }
}
