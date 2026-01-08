/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS;

/**
 *
 * @author ADMIN
 */

import vn.medianews.*;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        String sCode = "B22DCCN469", qCode = "KlKa4Teh";
        CharacterService_Service sv = new CharacterService_Service();
        CharacterService port = sv.getCharacterServicePort();
        
        String s = port.requestString(sCode, qCode);
        
        s = s.replace('_', ' ').trim();
        String[] a = s.split("\\s+");
        
        List<String> res = new ArrayList<>();
        //s1
        String s1 = "";
        for (String x : a) {
            s1 += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase();
        }
        res.add(s1);
        
        //s2
        String s2 = "";
        for (String x : a) {
            s2 += Character.toUpperCase(x.charAt(0)) + x.substring(1).toLowerCase();
        }
        s2 = Character.toLowerCase(s2.charAt(0)) + s2.substring(1);
        res.add(s2);
        
        //s3
        String s3 = "";
        for (String x : a) {
            s3 += x.toLowerCase() + "_";
        }
        res.add(s3.substring(0, s3.length() - 1));
        
        port.submitCharacterStringArray(sCode, qCode, res);
    }
}
