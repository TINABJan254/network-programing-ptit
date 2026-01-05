/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.*;
import java.util.*;
import java.net.*;

/**
 *
 * @author ADMIN
 */
public class TaoChuoi {
    public static void main(String[] args) throws Exception {
        String sCode = "B22DCCN468", qCode = "dr2sandw";
        String iMes = sCode + ";" + qCode;
        
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        
        out.write(iMes.getBytes());
        out.flush();
        
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        if (bytesRead != -1){
            int n = Integer.parseInt(new String(buffer, 0, bytesRead));
            ArrayList<Integer> arr = new ArrayList<>();
            arr.add(n);
            while (n != 1) {
                if (n % 2 == 0) {
                    n /= 2;
                } else if (n % 2 != 0 && n != 1) {
                    n = 3*n + 1;
                }
                arr.add(n);
            }
            
            String res = "";
            for (int i = 0; i < arr.size() - 1; i++){
                res += arr.get(i) + " ";
            }
            res += arr.get(arr.size()-1) + "; " + arr.size();
            
            out.write(res.getBytes());
            out.flush();
        }
    }
}

/*
[Mã câu hỏi (qCode): dr2sandw].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2206 (thời gian giao tiếp tối đa cho mỗi yêu cầu là 5s).
Yêu cầu là xây dựng một chương trình client tương tác tới server ở trên sử dụng các luồng byte (InputStream/OutputStream) để trao đổi thông tin theo thứ tự: 
a.	Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B16DCCN999;2B3A6510"
b.	Nhận dữ liệu từ server là một số nguyên n nhỏ hơn 400. Ví dụ: 7
c.	Thực hiện các bước sau đây để sinh ra chuỗi từ số nguyên n ban đầu và gửi lên server.
        Bắt đầu với số nguyên nn:
            Nếu n là số chẵn, chia nn cho 2 để tạo ra số tiếp theo trong dãy.
            Nếu n là số lẻ và khác 1, thực hiện phép toán n=3*n+1 để tạo ra số tiếp theo.
        Lặp lại quá trình trên cho đến khi n=1, tại đó dừng thuật toán.
Kết quả là một dãy số liên tiếp, bắt đầu từ n ban đầu, kết thúc tại 1 và độ dài của chuỗi theo format "chuỗi kết quả; độ dài"  Ví dụ: kết quả với n = 7 thì dãy: 7 22 11 34 17 52 26 13 40 20 10 5 16 8 4 2 1; 17;  
d.	Đóng kết nối và kết thúc chương trình.
*/
