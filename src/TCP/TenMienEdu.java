/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

/**
 *
 * @author ADMIN
 */

import java.io.*;
import java.net.*;
import java.util.*;

//tcp - character stream
public class TenMienEdu {
    public static void main(String[] args) throws Exception{
        String iMes = "B22DCCN053;p7KISu5v";
        Socket socket = new Socket("203.162.10.109", 2208);
        
        BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        
        out.write(iMes);
        out.newLine();
        out.flush();
        
        String s = in.readLine().trim();
        
        s = s.replace(',', ' ');
        String[] a = s.split("\\s+");
        
        String ans = "";
        for (String x : a) {
            if (x.endsWith(".edu")) {
                ans += x + ", ";
            }
        }
        if (ans.length() >4) { //co ton tai ten mien edu
            ans = ans.substring(0, ans.length() - 2);
        }
        
        
        out.write(ans);
        out.newLine();
        out.flush();
        
    }
}

/*
[Mã câu hỏi (qCode): p7KISu5v].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2208 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client tương tác với server sử dụng các luồng byte (BufferedWriter/BufferedReader) theo kịch bản sau: 
a.	Gửi một chuỗi gồm mã sinh viên và mã câu hỏi với định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;EC4F899B"
b.	Nhận một chuỗi ngẫu nhiên là danh sách các một số tên miền từ server
Ví dụ: giHgWHwkLf0Rd0.io, I7jpjuRw13D.io, wXf6GP3KP.vn, MdpIzhxDVtTFTF.edu, TUHuMfn25chmw.vn, HHjE9.com, 4hJld2m2yiweto.vn, y2L4SQwH.vn, s2aUrZGdzS.com, 4hXfJe9giAA.edu
c.	Tìm kiếm các tên miền .edu và gửi lên server
Ví dụ: MdpIzhxDVtTFTF.edu, 4hXfJe9giAA.edu
d.	Đóng kết nối và kết thúc chương trình.
*/
