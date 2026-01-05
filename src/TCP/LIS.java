/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.util.*;
import java.io.*;
import java.net.*;

/**
 *
 * @author ADMIN
 */
// TCP - Byte stream
public class LIS {
    public static void main(String[] args) throws Exception{
        String sCode = "B22DCCN504";
        String qCode = "zFpLkHZp";
        String iMes = sCode + ";" + qCode;
        
        Socket socket = new Socket("203.162.10.109", 2206);
        socket.setSoTimeout(5000);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        
        out.write(iMes.getBytes());
        out.flush();
        
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        
        if (bytesRead != -1){
            String s = new String(buffer, 0, bytesRead, "UTF-8");
            System.out.println(s);
            
            s = s.replace(',', ' ').trim();
            String[] a = s.split("\\s+");
            ArrayList<Integer> b = new ArrayList<>();
            for (String x : a) {
                b.add(Integer.parseInt(x));
            }
            
            int[] f = new int[b.size() + 5];
            int[] t = new int[b.size() + 5];
            for (int i = 0; i <= b.size(); i++) {
                f[i] = 1;
                t[i] = -1;
            }
            
            //dp
            for (int i = 0; i < b.size(); i++) {
                for (int j = 0; j < i; j++) {
                    if ( b.get(i) > b.get(j) && (f[j] + 1) > f[i]) {
                        f[i] = f[j] + 1;
                        t[i] = j;
                    }
                }
            }
            
            //end pos
            int maxLen = 0;
            int pos = 0;
            for (int i = 0; i < b.size(); i++) {
                if (f[i] > maxLen) {
                    maxLen = f[i];
                    pos = i;
                }
            }
            
            ArrayList<Integer> res = new ArrayList<>();
            while (pos != -1) {
                res.add(b.get(pos));
                pos = t[pos];
            }
            
            String result = "";
            for (int i = res.size() - 1; i >= 1; i--){
                result += res.get(i) + ",";
            }
            result += res.get(0) + ";" + res.size();
            
            out.write(result.getBytes());
            out.flush();
        }
        
    }
}

/*
[Mã câu hỏi (qCode): zFpLkHZp].  Một chương trình server hỗ trợ kết nối qua giao thức TCP tại cổng 2206 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s). 
Yêu cầu xây dựng chương trình client thực hiện kết nối tới server sử dụng luồng byte dữ liệu (InputStream/OutputStream) để trao đổi thông tin theo thứ tự:
    a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B16DCCN999;76B68B3B".
    b. Nhận dữ liệu từ server là một chuỗi các giá trị số nguyên được phân tách bởi ký tự ",". Ví dụ: 5,10,20,25,50,40,30,35.
    c. Tìm chuỗi con tăng dần dài nhất và gửi độ dài của chuỗi đó lên server theo format "chuỗi tăng dài nhất; độ dài". Ví dụ: 5,10,20,25,50;5
    d. Đóng kết nối và kết thúc chương trình.
*/
