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

public class ChuyenDoiCoSo {
    public static void main(String[] args) {
        String sCode = "B22DCCN469", qCode = "MK8Sbg1M";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        
        List<Integer> a = (List<Integer>)port.getData(sCode, qCode);
        
        System.out.println(a);
        
        List<String> res = new ArrayList<>();
        for (Integer x : a) {
            res.add(Integer.toOctalString(x) + "|" + Integer.toHexString(x).toUpperCase());
        }
        
        port.submitDataStringArray(sCode, qCode, res);
    }
}
