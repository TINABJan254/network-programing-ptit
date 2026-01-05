/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

/**
 *
 * @author ADMIN
 */
import java.util.*;
import java.io.*;
import java.net.*;

public class KhoangCachNhoNhat {
    public static void main(String[] args) throws Exception{
        String iMes = "B22DCCN111;dkjkej";
        Socket socket = new Socket("203.162.10.109", 2206);
        
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        
        out.write(iMes.getBytes());
        out.flush();
        
        byte[]  buffer = new byte[1024];
        int len = in.read(buffer);
        
//        String s = new String(buffer, 0, len);
        String s = "3,5,2,7,1,9,8";
        s = s.replace(',', ' ').trim();
        
        String[] tokens = s.split("\\s+");
        
        ArrayList<Integer> a = new ArrayList<>();
        for (String x : tokens) {
            a.add(Integer.parseInt(x));
        }
        
        Collections.sort(a);
        
        int res = Integer.MAX_VALUE;
        int maxE = -1, minE = 0;
        
        for (int i = a.size() - 1; i >= 1; i--){
            int tmp = a.get(i) - a.get(i - 1);
            if (tmp < res) {
                res = tmp;
                maxE = a.get(i);
                minE = a.get(i - 1);
            }
        }
        
        String ans = res + "," + minE + "," + maxE; 
       System.out.println(ans);
        
        out.write(ans.getBytes());
        out.flush();
        
        in.close();
        out.close();
        socket.close();
        
    }
}
