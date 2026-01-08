/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

/**
 *
 * @author ADMIN
 */

import java.io.*;
import java.util.*;
import java.net.*;

public class TongHaiSoNhiPhan {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        String iMes = ";B22DCCN401;MAIWyE29";
        InetAddress addr = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        
        DatagramPacket p1 = new DatagramPacket(iMes.getBytes(), iMes.length(), addr, port);
        socket.send(p1);
        
        byte[] buffer = new byte[1024];
        DatagramPacket p2 = new DatagramPacket(buffer, buffer.length);
        socket.receive(p2);
        
        String s = new String(p2.getData(), 0, p2.getLength());
        s = s.replaceAll("[;,]", " ").trim();
        
        String[] a = s.split("\\s+");
        
        System.out.println(a.length);
        
        String res = a[0] + ";" + (Integer.parseInt(a[1], 2) + Integer.parseInt(a[2], 2));
        
        DatagramPacket p3 = new DatagramPacket(res.getBytes(), res.length(), addr, port);
        socket.send(p3);
        
        socket.close();
    }
}
