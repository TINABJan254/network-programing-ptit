/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

/**
 *
 * @author ADMIN
 */

import java.util.*;
import java.io.*;
import java.net.*;

//tcp - byte stream
public class TinhTong {
    public static void main(String[] args) throws Exception{
        String iMes = "B22DCCN218" + ";" + "1iPQNCYN";
        
        Socket socket = new Socket("203.162.10.109", 2206);
        socket.setSoTimeout(5000);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        
        out.write(iMes.getBytes());
        out.flush();
        
        byte[] buffer = new byte[1024];
        int len = in.read(buffer);
        if (len != -1) {
            String s = new String(buffer, 0, len);
            System.out.println(s);
            s = s.replace('|', ' ').trim();
            String[] tokens = s.split("\\s+");
            
            int sum = 0;
            for (String x : tokens) {
                sum += Integer.parseInt(x);
            }
            
            out.write(String.valueOf(sum).getBytes());
            out.flush();
        }
        socket.close();
    }
}

/*
[Mã câu hỏi (qCode): 1iPQNCYN].  Một chương trình server hỗ trợ kết nối qua giao thức TCP tại cổng 2206 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). 
Yêu cầu xây dựng chương trình client thực hiện kết nối tới server trên sử dụng luồng byte dữ liệu (InputStream/OutputStream) để trao đổi thông tin theo thứ tự: 
a.	Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B16DCCN999;C64967DD"
b.	Nhận dữ liệu từ server là một chuỗi gồm các giá trị nguyên được phân tách với nhau bằng  "|"
Ex: 2|5|9|11
c.	Thực hiện tìm giá trị tổng của các số nguyên trong chuỗi và gửi lên server
Ex: 27
d.	Đóng kết nối và kết thúc
*/