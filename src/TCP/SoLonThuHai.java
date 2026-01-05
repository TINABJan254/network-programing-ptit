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

public class SoLonThuHai {
    public static void main(String[] args) throws Exception{
        String sCode = "B22DCCN827";
        String qCode = "Chkn135k";
        String iMes = sCode + ";" + qCode;
        
        Socket socket = new Socket("localhost", 806);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        
        out.write(iMes.getBytes());
        out.flush();
        
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        
        if (bytesRead != -1) {
            String s = new String(buffer, 0, bytesRead);
            System.out.println(s);
            
            s = s.replace(',', ' ').trim();
            String[] a = s.split("\\s+");
            
            int max1 = 0, max2 = 0, pos1 = 0, pos2 = 0;
            for (int i = 0; i < a.length; i++){
                if (Integer.parseInt(a[i]) > max1) {
                    max2 = max1;
                    pos2 = pos1;
                    max1 = Integer.parseInt(a[i]);
                    pos1 = i;
                } else if (Integer.parseInt(a[i]) > max2) {
                    max2 = Integer.parseInt(a[i]);
                    pos2 = i;
                }
            }
            
            System.out.println(max2 + " " + pos2);
            String res = max2 + "," + pos2;
            out.write(res.getBytes());
            out.flush();
        }
        
    }
}
