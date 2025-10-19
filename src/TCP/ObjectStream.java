/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.*;
import java.net.*;

/**
 *
 * @author ADMIN
 */
public class ObjectStream {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String studentCode = "B22DCCN827";
        String qCode = "68I7h7Lz";
        String initMess = studentCode + ";" + qCode;

        Socket socket = new Socket("203.162.10.109", 2209);
        socket.setSoTimeout(5000);

        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());

        out.writeObject(initMess);
        out.flush();
        
        Laptop laptop = (Laptop) in.readObject();
        System.out.println(laptop);
        laptop.solve();

        if (laptop != null) {
            System.out.println("hello");
        }

        
        out.writeObject(laptop);
        out.flush();
        socket.close();
    }
}

