/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package WS;

import java.util.ArrayList;
import java.util.List;
import vn.medianews.*;

public class BaiObjectServiceStudent {
    public static void main(String[] args) {
        String sCode = "B22DCCN827", qCode = "lH4UnnqD";
        ObjectService_Service service = new ObjectService_Service();
        ObjectService port = service.getObjectServicePort();
        
        //a. 
        List<Student> students = (List<Student>)port.requestListStudent(sCode, qCode);
        
        //b.
        List<Student> res = new ArrayList<>();
        for (Student x : students) {
            if (x.getScore() >= 8.00 || x.getScore() <= 5.00) {
                res.add(x);
            }
        }
        
        //c.
        port.submitListStudent(sCode, qCode, res);
    }
}
