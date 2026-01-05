/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

/**
 *
 * @author ADMIN
 */

import java.rmi.*;
import java.rmi.registry.*;

public class ByteCaesar {
    public static void main(String[] args) throws Exception{
        String sCode = "B22DCCN828", qCode = "ewPZXLeo";
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        
        byte[] a = sv.requestData(sCode, qCode);
        int d = a.length;
        byte[] encode = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            encode[i] = (byte) ((a[i] + d) % 256);
        }
        
        sv.submitData(sCode, qCode, encode);
    }
}
