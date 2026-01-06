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
import java.util.*;
import java.net.*;

//tcp - object stream
public class ChuanHoaThongTinKhachHang {
    
    public static void main(String[] args) throws Exception{
        String iMes = "B22DCCN650;5LQeKr5N";
        Socket socket = new Socket("203.162.10.109", 2209);
        
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
        
        out.writeObject(iMes);
        out.flush();
        
        Customer cus = (Customer)in.readObject();
        
        //Chuan hoa ten
        String[] a = cus.getName().split("\\s+");
        String ans = a[a.length - 1].toUpperCase() + ", ";
        for (int i = 0; i < a.length - 1; i++) {
            ans += Character.toUpperCase(a[i].charAt(0)) + a[i].substring(1).toLowerCase() + " ";
        }
        cus.setName(ans.trim());
        
        //Chuan hoa ns
        ans = "";
        ans += cus.getDayOfBirth().substring(3, 5) + "/";
        ans += cus.getDayOfBirth().substring(0, 2) + "/";
        ans += cus.getDayOfBirth().substring(6);
        cus.setDayOfBirth(ans);
        
        // Tao username
        ans = "";
        for (int i = 0; i < a.length - 1; i++) {
            ans += a[i].toLowerCase().charAt(0);
        }
        ans += a[a.length-1].toLowerCase();
        cus.setUserName(ans);
        
        out.writeObject(cus);
        out.flush();
        out.close();
    }
}
