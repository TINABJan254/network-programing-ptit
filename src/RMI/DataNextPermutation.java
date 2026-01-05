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

public class DataNextPermutation {

    public static void main(String[] args) throws Exception {
        String sCode = "B22DCCN827", qCode = "XZQtcXCT";
        Registry rg = LocateRegistry.getRegistry("203.162.10.109", 1099);
        DataService sv = (DataService) rg.lookup("RMIDataService");

        String s = (String) sv.requestData(sCode, qCode);
        String[] parts = s.split(",");

        int[] a = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            a[i] = Integer.parseInt(parts[i].trim());
        }

        nextPermutation(a);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                sb.append(",");
            }
            sb.append(a[i]);
        }
        
        sv.submitData(sCode, qCode, sb.toString());

    }

    private static void nextPermutation(int[] a) {
        int n = a.length;
        int i = n - 2;
        while (i >= 0 && a[i] >= a[i + 1]) {
            --i;
        }

        if (i >= 0) {
            int j = n - 1;
            while (a[j] <= a[i]) {
                j--;
            }
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;

            reverse(a, i + 1, n - 1);
        } else {
            reverse(a, 0, n - 1);
        }
    }

    public static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}
