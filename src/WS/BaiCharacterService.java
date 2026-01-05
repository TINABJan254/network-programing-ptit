/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS;

/**
 *
 * @author ADMIN
 */

import java.util.ArrayList;
import java.util.List;
import vn.medianews.*;


public class BaiCharacterService {
    public static void main(String[] args) {
        // Cau hinh thong tin
        String sCode = "B22DCCN827", qCode = "Eg61J3RT";
        
        // Tao doi tuong dich vu tu ws
        CharacterService_Service service = new CharacterService_Service();
        CharacterService port = service.getCharacterServicePort();
        
        //a. Trieu hoi phuong thuc...
        String s = port.requestString(sCode, qCode);
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '_') {
                sb.setCharAt(i, ' ');
            }
        }
        s = sb.toString();
        
        //b. Chuyen doi...
        String[] words = s.trim().split("\\s+");
        List<String> data = new ArrayList<>();
        data.add(toPascalCase(words));
        data.add(toCamelCase(words));
        data.add(toSnakeCase(words));
        
        //c. submit
        port.submitCharacterStringArray(sCode, qCode, data);
    }
    
    private static String toPascalCase(String[] words) {
        String res = "";
        for (String x : words) {
            res += Character.toUpperCase(x.charAt(0));
            for (int i = 1; i < x.length(); i++) {
                res += Character.toLowerCase(x.charAt(i));
            }   
        }
        return res;
    }
    
    private static String toCamelCase(String[] words) {
        String res = "";
        for (String x : words) {
            res += Character.toUpperCase(x.charAt(0));
            for (int i = 1; i < x.length(); i++) {
                res += Character.toLowerCase(x.charAt(i));
            }   
        }
        
        StringBuilder sb = new StringBuilder(res);
        sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
        return sb.toString();
    }
    
    private static String toSnakeCase(String[] words) {
        String res = "";
        for (String x : words) {
            for (int i = 0; i < x.length(); i++) {
                res += Character.toLowerCase(x.charAt(i));
            }   
            res += "_";
        }
        StringBuilder sb = new StringBuilder(res);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
}
