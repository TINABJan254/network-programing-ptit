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

//tcp - character stream
public class LoaiBoKiTu {
    public static void main(String[] args) throws Exception{
        String iMes = "B22DCCN222;05FIEwNq";
        Socket socket = new Socket("203.162.10.109", 2208);
        
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        out.write(iMes);
        out.newLine();
        out.flush();
        
        String s = in.readLine();
        int[] cnt = new int[10005];
        String ans = "";
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) && cnt[c] == 0){
                ans += c;
                cnt[c]++;
            }
        }
        
        out.write(ans);
        out.newLine();
        out.flush();
        in.close();
        out.close();
        socket.close();
        
    }
}
