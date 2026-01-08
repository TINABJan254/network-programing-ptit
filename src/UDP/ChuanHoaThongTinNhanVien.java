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

public class ChuanHoaThongTinNhanVien {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("203.162.10.109");
        int port = 2209;
        
        String iMes = ";B22DCCN413;qWUPaQyx";
        DatagramPacket p1 = new DatagramPacket(iMes.getBytes(), iMes.length(), addr, port);
        socket.send(p1);
        
        byte[] buffer = new byte[1024];
        DatagramPacket p2 = new DatagramPacket(buffer, buffer.length);
        socket.receive(p2);
        
        String reqId = new String(p2.getData(), 0, 8);
        
        ByteArrayInputStream input = new ByteArrayInputStream(p2.getData(), 8, p2.getLength() - 8);
        ObjectInputStream in = new ObjectInputStream(input);
        Employee e = (Employee)in.readObject();
        
        //chuan hoa ten
        String[] a = e.getName().split("\\s+");
        String newName = "";
        for (String x : a) {
            System.out.println(x);
            newName += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase() +  " ";
        }
        e.setName(newName.trim());
        System.out.println(newName);
        
        //tang luong
        double sum = 0;
        for (char c : e.getHireDate().substring(0, 4).toCharArray()){
            sum += c - '0';
        }
        sum /= 100;
        double newSal = sum * e.getSalary() + e.getSalary();
        e.setSalary(Math.round(newSal * 100.0)/100.0);
        
        //chuan hoa hire date
        String tmp = e.getHireDate();
        e.setHireDate( tmp.substring(8)+ "/" + tmp.substring(5, 7) + "/" + tmp.substring(0, 4));
        
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(output);
        out.writeObject(e);
        out.flush();
        
        byte[] res = new byte[8 + output.size()];
        System.arraycopy(reqId.getBytes(), 0, res, 0, 8);
        System.arraycopy(output.toByteArray(), 0, res, 8, output.size());
        
        DatagramPacket p3 = new DatagramPacket(res, res.length, addr, port);
        socket.send(p3);
        
        socket.close();
    }
}
