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

//tcp - data stream
public class TinhTongVaTichHaiSo {
    public static void main(String[] args) throws Exception {
        String iMes = "B22DCCN053;vP9AaY0l";
        
        Socket socket = new Socket("203.162.10.109", 2207);
        socket.setSoTimeout(5000);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        out.writeUTF(iMes);
        out.flush();
        
        int a = in.readInt();
        int b = in.readInt();
        
        out.writeInt(a + b);
        out.writeInt(a * b);
        
        in.close();
        out.close();
        socket.close();
    }
}
