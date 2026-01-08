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
import java.net.*;
import java.rmi.*;
import java.rmi.registry.*;



public class Test {
    
    public static void nextPermutation(int[] a) {
        int n = a.length;
        int i = n -2;
        while (i >= 0 && a[i] >= a[i + 1]) {
            --i;
        }
        
        if (i >= 0) {
            int j = n - 1;
            while (a[j] <= a[i]) {
                --j;
            }
            
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            
            reverse(a, i + 1, n - 1);
        } else {
            reverse(a, 0,  n - 1);
        }
    }
    
    public static void reverse(int[] a, int l, int r) {
        while (l < r) {
            int tmp = a[l];
            a[l] = a[r];
            a[r] = tmp;
            ++l;
            --r;
        }
    }
    
    public static void main(String[] args) throws Exception{
        String sCode = "B22DCCN469", qCode = "NNrc8pkP";
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService)rg.lookup("RMIDataService");
        
        String s = (String)sv.requestData(sCode, qCode);
        s = s.replace(',', ' ');
        String[] tmp = s.split("\\s+");
        
        int[] a = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) {
            a[i] = Integer.parseInt(tmp[i].trim());
        }
        
        nextPermutation(a);
        
        String ans = "";
        for (int i = 0; i < a.length - 1; i++) {
            ans += a[i] + ",";
        }
        ans += a[a.length - 1];
        
        sv.submitData(sCode, qCode, ans);
    }
}
