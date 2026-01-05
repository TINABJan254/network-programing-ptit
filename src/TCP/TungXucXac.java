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

public class TungXucXac {
    public static void main(String[] args) throws Exception{
        String iMes = "B22DCCN053;vP9AaY0l";
        
        Socket socket = new Socket("203.162.10.109", 2207);
        socket.setSoTimeout(5000);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        out.writeUTF(iMes);
        out.flush();
        
        int n = in.readInt();
        int[] cnt = new int[10];
        for (int i = 0; i < n; i++){
            int x = in.readInt();
            cnt[x]++;
        }
        
        for (int i = 1; i <= 6; i++) {
            out.writeFloat((float)cnt[i]/n);
            System.out.println(cnt[i]/n);
        }
        
        in.close();
        out.close();
        socket.close();
    }
}
