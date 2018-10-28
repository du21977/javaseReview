package com.dobi;

import java.io.IOException;
import java.net.*;

public class day02_3 {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket();

        socket.setSoTimeout(3000);
        //连接本地，端口2000，超时时间3s
        socket.connect(new InetSocketAddress(Inet4Address.getLocalHost(),2000),3000);

        System.out.println("已发起服务器连接，并进入后续流程··");
        System.out.println("客户端信息："+socket.getLocalAddress()+"Port:"+socket.getLocalPort());

        System.out.println("服务器信息："+socket.getInetAddress()+"Port:"+socket.getPort());
        try{
            todo(socket);
        }catch (Exception e){
            System.out.println("异常关闭");
        }

        //释放资源
        socket.close();
        System.out.println("客户端已退出");

    }

    /**
     *
     * @param client
     * @throws IOException
     */
    private static void todo(Socket client) throws IOException{

    }

}
