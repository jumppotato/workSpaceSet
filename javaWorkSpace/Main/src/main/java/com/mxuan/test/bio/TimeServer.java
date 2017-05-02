package com.mxuan.test.bio;

import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer{
    public static void main(String[] args) throws Exception{
        int port = 8080;
        ServerSocket server = null;
        try{
            server = new ServerSocket(port);
            System.out.println("The time server is start in port : " + port);
            Socket socket;
            while(true){
                socket = server.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        }finally{
            if(server != null){
                server.close();
            }
        }
    }
}