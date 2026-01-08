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

public class TimMinMax {
    public static void main(String[] args) throws Exception{
        String iMes = ";B22DCCN125;w9bJqE8G";
        DatagramSocket socket = new DatagramSocket();
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
        
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = 1; i < a.length; i++) {
            b.add(Integer.parseInt(a[i]));
        }
        Collections.sort(b);
        
        String ans = a[0] + ";" + b.get(b.size() - 1) + "," + b.get(0);
        DatagramPacket p3 = new DatagramPacket(ans.getBytes(), ans.length(), addr, port);
        socket.send(p3);
        
        socket.close();
        
    }
}
