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

//TCP - Byte Stream
public class Chkn135k {

    public static void main(String[] args) throws Exception {
        String studentCode = "B22DCCN827";
        String qCode = "Chkn135k";
        String initialMessage = studentCode + ";" + qCode;

        Socket socket = new Socket("203.162.10.109", 2206);
        socket.setSoTimeout(5000);

        InputStream in = new DataInputStream(socket.getInputStream());
        OutputStream out = new DataOutputStream(socket.getOutputStream());

        out.write(initialMessage.getBytes());
        out.flush();

        byte[] buffer = new byte[1024];

        int bytesRead = in.read(buffer);
        if (bytesRead != -1) {
            String response = new String(buffer, 0, bytesRead, "UTF-8");
            System.out.println(response);

            // Xy ly thanh so nguyen
            String[] parts = response.split("\\|");
            int sum = 0;
            for (String p : parts) {
                try {
                    int val = Integer.parseInt(p.trim());
                    sum += val;
                } catch (NumberFormatException e) {
                    System.out.println("Parse Ex: " + p);
                }
            }
            System.out.println("sum = " + sum);

            // Gui lai ket qua cho server
            String result = String.valueOf(sum);
            out.write(result.getBytes("UTF-8"));
            out.flush();
            System.out.println("Gui lai thanh cong cho server: " + result);
        }
    }
}

/*
[Mã câu hỏi (qCode): Chkn135k].  Một chương trình server hỗ trợ kết nối qua giao thức TCP tại cổng 2206 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). 
Yêu cầu xây dựng chương trình client thực hiện kết nối tới server trên sử dụng luồng byte dữ liệu (InputStream/OutputStream) để trao đổi thông tin theo thứ tự: 
    a.	Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B16DCCN999;C64967DD"
    b.	Nhận dữ liệu từ server là một chuỗi gồm các giá trị nguyên được phân tách với nhau bằng  "|"
    Ex: 2|5|9|11
    c.	Thực hiện tìm giá trị tổng của các số nguyên trong chuỗi và gửi lên server
    Ex: 27
    d.	Đóng kết nối và kết thúc
*/