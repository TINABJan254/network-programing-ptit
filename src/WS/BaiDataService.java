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

public class BaiDataService {
    public static void main(String[] args) {
        String sCode = "B22DCCN827", qCode = "fcQtAsT7";
        DataService_Service service = new DataService_Service();
        DataService port = service.getDataServicePort();
        
        //a.
        List<Integer> a = (List<Integer>)port.getData(sCode, qCode);
        
        //b.
        List<String> res = new ArrayList<>();
        for (Integer x : a) {
            res.add(Integer.toOctalString(x) + "|" + Integer.toHexString(x).toUpperCase());
        }
        
        //c.
        port.submitDataStringArray(sCode, qCode, res);
        
    }
}
