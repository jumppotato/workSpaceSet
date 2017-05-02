package com.mxuan.test.wio;

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
            TimeServerHandlerExecutePool singExecutor = new TimeServerHandlerExecutePool(50, 10000);
            while(true){
                socket = server.accept();
                singExecutor.execute(new TimeServerHandler(socket));
            }
        }finally{
            if(server != null){
                server.close();
            }
        }
    }
}