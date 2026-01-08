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


//udp - string
public class ChuanHoaChuoi {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        String iMes = ";B22DCCN222;fgkK6OnX";
        InetAddress addr = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        
        DatagramPacket p1 = new DatagramPacket(iMes.getBytes(), iMes.length(), addr, port);
        socket.send(p1);
        
        byte[] buffer = new byte[1024];
        DatagramPacket p2 = new DatagramPacket(buffer, buffer.length);
        socket.receive(p2);
        
        String s = new String(p2.getData(), 0, p2.getLength());
        s = s.replace(';', ' ');
        String[] a = s.split("\\s+");
        
        String res = a[0] + ";";
        for (int i = 1; i < a.length; i++) {
            res += Character.toUpperCase(a[i].charAt(0)) + a[i].substring(1).toLowerCase() + " ";
        }
        res.trim();
        
        DatagramPacket p3 = new DatagramPacket(res.getBytes(), res.length(), addr, port);
        socket.send(p3);
        
        socket.close();
    }
}
