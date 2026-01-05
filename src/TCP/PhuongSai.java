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

public class PhuongSai {
    public static void main(String[] args) throws Exception{
        String iMes = "B22DCCN053;vP9AaY0l";
        
        Socket socket = new Socket("203.162.10.109", 2207);
        socket.setSoTimeout(5000);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        out.writeUTF(iMes);
        out.flush();
        
        int n = in.readInt();
        int[] a = new int[n + 5];
        for (int i = 0; i < n; i++) {
            a[i] = in.readInt();
        }
        
        // phuong sai = (Tong cac (a[i] - tbc)^2 )/n
        float tbc = 0;
        for (int i = 0; i < n; i++) {
            tbc += a[i];
        }
        tbc /= n;
        float p = 0;
        for (int i = 0; i < n; i++) {
            p += (a[i] - tbc) * (a[i] - tbc);
        }
        p /= n;
        
        out.writeFloat(p);
        
        in.close();
        out.close();
        socket.close();
    }
}
