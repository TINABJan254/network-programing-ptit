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

//tcp - object stream
public class SanPhamDaoNguoc {

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
        
        Laptop product = (Laptop) in.readObject();
        System.out.println("San pham ban dau: " + product);
        //c.
        String name = product.getName();
        String[] words = name.trim().split("\\s+");
        if (words.length > 1) {
            String temp = words[0];
            words[0] = words[words.length - 1];
            words[words.length - 1] = temp;
        }
        String tmpx = "";
        for(String x: words) tmpx+=x + " ";
        product.setName(tmpx.trim());
        // Đảo ngược số lượng
        String tmp = product.getQuantity()+"";
        String tmp1 = "";
        for(int i = tmp.length() - 1;i>=0;i--) tmp1+=String.valueOf(tmp.charAt(i));
        product.setQuantity(Integer.parseInt(tmp1));
        //d.
        System.out.println("San pham luc sau: " + product);
        out.writeObject(product);
        out.flush();
        in.close(); out.close(); socket.close();
    }
}

