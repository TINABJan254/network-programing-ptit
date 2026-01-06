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
public class TimTuDaiNhat {
    public static void main(String[] args) throws Exception{
        
        Socket socket = new Socket("203.162.10.109", 2208);
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        //
        String code = "B22DCCN191;LsjdDk";
        bw.write(code); bw.newLine(); bw.flush();
        //
        String s = br.readLine();
        System.out.println(s);
        String []a = s.trim().split("\\s+");
        //
        String ans = a[0];int res = a[0].length(); int pos = 1;
         for(int i = 1;i<a.length;i++){
            if(a[i].length() > res){
                ans = a[i];
                res = a[i].length();
                pos = s.indexOf(ans);
            }
        }
        
        bw.write(ans); bw.newLine(); bw.flush();
        bw.write(pos + ""); bw.newLine(); bw.flush();
    }
}
