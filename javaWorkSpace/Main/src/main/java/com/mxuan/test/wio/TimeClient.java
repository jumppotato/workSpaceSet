package com.mxuan.test.wio;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by wangwenxuan on 2017/4/11.
 */
public class TimeClient{

    public static void main(String[] args){
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            String cmd = cin.nextLine();
            int port = 8080;
            try(Socket socket = new Socket("127.0.0.1", port);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)){
                out.println(cmd);
                System.out.println("Send order 2 server succeed.");
                String resp = in.readLine();
                System.out.println("Now is : " + resp);

            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
}
