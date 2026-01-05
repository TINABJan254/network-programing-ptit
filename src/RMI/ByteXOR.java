/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RMI;

import RMI.ByteService;
import java.rmi.registry.*;
import java.util.*;

/**
 *
 * @author ADMIN
 */
public class ByteXOR {
    public static void main(String[] args) throws Exception{
        String sCode = "B22DCCN827", qCode = "pOjg6mNX";
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        ByteService sv = (ByteService) rg.lookup("RMIByteService");
        //a.
        byte[] a = sv.requestData(sCode, qCode);
        
        // b. Xử lý
        byte[] key = "PTIT".getBytes();
        
        byte[] encode = new byte[a.length];
        for (int i = 0; i < a.length; i++) {
            encode[i] = (byte) (a[i] ^ (key[i % key.length]));
        }
        
        // c. 
        sv.submitData(sCode, qCode, encode);
    }
}
