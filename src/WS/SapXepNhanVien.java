/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS;

/**
 *
 * @author ADMIN
 */

import java.util.*;
import vn.medianews.*;

public class SapXepNhanVien {
    public static void main(String[] args) {
        String sCode = "B22DCCN469", qCode = "CbF7qPMj";
        ObjectService_Service sv = new ObjectService_Service();
        ObjectService port = (ObjectService)sv.getObjectServicePort();
        
        List<EmployeeY> e = (List<EmployeeY>)port.requestListEmployeeY(sCode, qCode);
        
        Collections.sort(e, new Comparator<>(){
            @Override
            public int compare(EmployeeY o1, EmployeeY o2) {
                return o1.getStartDate().toGregorianCalendar().getTime().compareTo(o2.getStartDate().toGregorianCalendar().getTime());
            }
        });
        
        System.out.println(e);
        
        port.submitListEmployeeY(sCode, qCode, e);
    }
}

/*

Date d = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
System.out.println(sdf.format(d)); //date -> string

Date d = sdf.parse("2023-10-15"); //string -> date

*/