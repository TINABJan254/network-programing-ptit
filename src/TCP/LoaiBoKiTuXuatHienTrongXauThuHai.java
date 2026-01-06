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

public class LoaiBoKiTuXuatHienTrongXauThuHai {
    public static void main(String[] args) throws Exception{
        String iMes = "B22DCCN053;p7KISu5v";
        Socket socket = new Socket("203.162.10.109", 2208);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        out.write(iMes);
        out.newLine();
        out.flush();
        
        String s1 = in.readLine();
        String s2 = in.readLine();
        
        s1 = "abcddb";
        s2 = "hjack";
        
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : s1.toCharArray()){
            hm.put(c, 1);
        }
        
        for (char c : s2.toCharArray()) {
            if (hm.containsKey(c)) {
                hm.put(c, 2);
            }
        }
        
        String ans = "";
        for (char c : s1.toCharArray()){
            if (hm.containsKey(c)){
                if (hm.get(c) == 1) {
                    ans += c;
                }
            }
        }
        
        System.out.println(ans);
        
        out.write(ans);
        out.newLine();
        out.flush();
    }
}
