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

public class KiTuXuatHienNhieuHonMotLan {
    public static void main(String[] args) throws Exception{
        String iMes = "B22DCCN125;s1oDmqvy";
        
        Socket socket = new Socket("203.162.10.109", 2208);
        
        BufferedWriter  out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        out.write(iMes);
        out.newLine();
        out.flush();
        
        String s = in.readLine();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : s.toCharArray()){
            if (Character.isLetterOrDigit(c)){
                if (hm.containsKey(c)){
                    hm.put(c, hm.get(c) + 1);
                } else {
                    hm.put(c, 1);
                }
            }
        }
        
        String ans = "";
        for (char c : s.toCharArray()){
            if (hm.containsKey(c)){
                if (hm.get(c) >= 2) {
                    ans += c + ":" + hm.get(c) + ",";
                    hm.put(c, 0);
                }
            }
        }
        
        out.write(ans);
        out.newLine();
        out.flush();
        
        out.close();
        in.close();
        socket.close();
        
    }
}
