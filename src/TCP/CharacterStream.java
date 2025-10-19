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
public class CharacterStream {
    public static void main(String[] args) throws IOException{
        String studentCode = "B22DCCN827";
        String qCode = "N8HlQW5L";
        String initMessage = studentCode + ";" + qCode;
        Socket socket = new Socket("203.162.10.109", 2208);
        
        BufferedWriter  writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        
        writer.write(initMessage);
        writer.newLine();
        writer.flush();
        
        String res = reader.readLine();
        System.out.println(res);
        if (res == null) {
            System.out.println("Khong nhan duoc phan hoi tu server");
        }
        
        Map<Character, Integer> hashMap = new HashMap<>();
        for (char c : res.toCharArray()) {
            if (c != ' ') {
                if (hashMap.containsKey(c)) {
                    hashMap.put(c, hashMap.get(c) + 1);
                } else {
                    hashMap.put(c, 1);
                }
            }
        }
        
        String ans = "";
        
        for (char c : res.toCharArray()) {
            if (hashMap.get(c) != null && hashMap.get(c) > 1) {
                ans += c + ":" + hashMap.get(c) + ",";
                hashMap.put(c, 0);
            }
        }
        
        writer.write(ans);
        writer.newLine();
        writer.flush();
    }
}
