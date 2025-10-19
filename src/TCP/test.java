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
public class test {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("203.162.10.109", 2207);
        DataInputStream reader = new DataInputStream(socket.getInputStream());
        DataOutputStream writter = new DataOutputStream(socket.getOutputStream());
        writter.writeUTF("B22DCCN827;DG0kqn1c");
        writter.flush();
        int a = reader.readInt();
        int b = reader.readInt();
        int tong = a + b;
        int tich = a*b;
        writter.writeInt(tong);
        writter.writeInt(tich);
        writter.flush();
        writter.close();
        reader.close();
        socket.close();
        
    }
}
