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
    
    public static int gcd(int a, int b){
        while (b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    
    public static void main(String[] args) throws Exception {
        int n = 1293;
        System.out.println(Integer.toOctalString(n));
        System.out.println(Integer.toHexString(n));
        
    }
}
