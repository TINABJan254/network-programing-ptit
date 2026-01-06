/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

/**
 *
 * @author ADMIN
 */


import java.io.*;
import java.net.*;
import java.util.*;

public class PhanLoaiTu {
    public static void main(String[] args) throws Exception{
        String iMes = "B22DCCN053;p7KISu5v";
        Socket socket = new Socket("203.162.10.109", 2208);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        out.write(iMes);
        out.newLine();
        out.flush();
        
        String s = in.readLine();
        
        s = "hello world this is a teste example";
        
        String[] a = s.split("\\s+");
        Arrays.sort(a);
        
        System.out.println(a);
        for (String x : a) {
            
        }
        
        ArrayList<String> t1 = new ArrayList<>();
        ArrayList<String> t2 = new ArrayList<>();
        ArrayList<String> t3 = new ArrayList<>();
        
        for (String x : a) {
            if (x.length() < 4) {
                t1.add(x);
            } else if (x.length() > 7) {
                t3.add(x);
            } else {
                t2.add(x);
            }
        }
        
        String ans = "[";
        for (int i = 0; i < t1.size() - 1; i++) {
            ans += t1.get(i) + ", ";
        }
        if (t1.size() > 1)
            ans += t1.get(t1.size() - 1);
        
        ans += "],[";
        for (int i = 0; i < t2.size() - 1; i++) {
            ans += t2.get(i) + ", ";
        }
        if (t2.size() > 1)
            ans += t2.get(t2.size() - 1);
        
        ans += "],[";
        for (int i = 0; i < t3.size() - 1; i++) {
            ans += t3.get(i) + ", ";
        }
        if (t3.size() > 1)
            ans += t3.get(t3.size() - 1);
        ans += "]";
        
        System.out.println(ans);
        out.write(ans);
        out.newLine();
        out.flush();
    }
}
