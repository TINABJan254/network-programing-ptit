/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

/**
 *
 * @author ADMIN
 */
import java.util.*;
import java.io.*;
import java.net.*;

//upd - data type
public class TongChuSo {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        
        String iMes = ";B22DCCN401;JXxK8W8l";
        DatagramPacket p1 = new DatagramPacket(iMes.getBytes(), iMes.length(), addr, port);
        socket.send(p1);
        
        byte[] buffer = new byte[1024];
        DatagramPacket p2 = new DatagramPacket(buffer, buffer.length);
        socket.receive(p2);
        
        String s = new String(p2.getData(), 0, p2.getLength());
        s = s.replace(';', ' ').trim();
        String[] a = s.split("\\s+");
        
        int res = 0;
        for (char c : a[1].toCharArray()) {
            res += c - '0';
        }
        
        String ans = a[0] + ";" + String.valueOf(res);
        DatagramPacket p3 = new DatagramPacket(ans.getBytes(), ans.length(), addr, port);
        socket.send(p3);
        
        socket.close();
    }
}
