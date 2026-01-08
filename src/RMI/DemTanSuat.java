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
import java.util.*;
import java.io.*;
import java.rmi.registry.*;

//rmi - character
public class DemTanSuat {
    public static void main(String[] args) throws Exception{
        String sCode = "B22DCCN469", qCode = "MvLVhkeD";
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        CharacterService sv = (CharacterService)rg.lookup("RMICharacterService");
        
        String s = sv.requestCharacter(sCode, qCode);
        
        int[] cnt = new int[10000];
        for (char c : s.toCharArray()) {
            cnt[c]++;
        }
        
        String ans = "";
        for (char c : s.toCharArray()) {
            if (cnt[c] != 0) {
                ans += c + "" + cnt[c];
                cnt[c] = 0;
            }
        }
        
        sv.submitCharacter(sCode, qCode, ans);
    }
}
