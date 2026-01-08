/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

/**
 *
 * @author ADMIN
 */

import java.util.*;
import java.io.*;
import java.rmi.*;
import java.rmi.registry.*;

//rmi - object
public class CapNhatThongTinSanPham {
    public static void main(String[] args) throws Exception{
        String sCode = "B22DCCN469", qCode = "sJHdFwZF";
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ObjectService sv = (ObjectService)rg.lookup("RMIObjectService");
        
        ProductX p = (ProductX)sv.requestObject(sCode, qCode);
        
        System.out.println(p.getDiscountCode());
        
        //sum
        int sum = 0;
        for (char c : p.getDiscountCode().toCharArray()) {
            if (Character.isDigit(c)) {
                sum += c - '0';
            }
        }
        p.setDiscount(sum);
        
        sv.submitObject(sCode, qCode, p);
        
    }
}
