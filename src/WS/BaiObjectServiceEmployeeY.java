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
import java.time.*;

public class BaiObjectServiceEmployeeY {
    public static void main(String[] args) {
        String sCode = "B22DCCN828", qCode = "utOsoQhN";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        
        //a.
        List<EmployeeY> employees = (List<EmployeeY>) port.requestListEmployeeY(sCode, qCode);
        
        //b.
        Collections.sort(employees, new Comparator<EmployeeY>(){
            @Override
            public int compare(EmployeeY o1, EmployeeY o2) {
                return o1.getStartDate().compare(o2.getStartDate());
            }
        });
        
        //c.
        port.submitListEmployeeY(sCode, qCode, employees);
    }
}
