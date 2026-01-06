/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author ADMIN
 */
public class test {
    
    public static int gcd(int a, int b){
        while (b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    
    public static String chuanHoaTen(String s) {
        String[] a = s.split("\\s+");
        String ans = a[a.length - 1] + " ";
        for (int i = 1; i < a.length - 1; i++){
            ans += a[i] + " ";
        }
        ans += a[0];
        return ans.trim();
    }
    
    public static int chuanHoaSL(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        
        return Integer.parseInt(sb.toString());
    }
    
    public static void main(String[] args) throws Exception {
//        String iMes = "B22DCCN125;cvOLaTCV";
//        Socket socket = new Socket("203.162.10.109", 2209);
//        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
//        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
//        
//        out.writeObject(iMes);
//        out.flush();
//        
//        Laptop laptop = (Laptop)in.readObject();
//        System.out.println(laptop.getName());
//        
//        laptop.setName(chuanHoaTen(laptop.getName()));
//        laptop.setQuantity(chuanHoaSL("" + laptop.getQuantity()));
//        
//        out.writeObject(laptop);
//        out.flush();
//        
//        socket.close();


         
    }
}
