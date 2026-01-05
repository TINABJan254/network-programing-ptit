/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.util.*;
import java.io.*;
import java.net.*;

//tcp - data stream
public class ChuyenDoiThapPhanNhiPhanHex {
    public static void main(String[] args) throws Exception{
        String iMes = "B22DCCN222;diDlCvVM";
        
        Socket socket = new Socket("203.162.10.109", 2207);
        socket.setSoTimeout(5000);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        out.writeUTF(iMes);
        out.flush();
        
        int n = in.readInt();
        String ans = Integer.toBinaryString(n) + ";" + Integer.toHexString(n).toUpperCase();
        
        out.writeUTF(ans);
        in.close();
        out.close();
        socket.close();
    }
}

/*

Chuyển đôi qua lại giữa các hệ số
    10 -> 2 8 16 : dùng Integer.to
    2 8 16 -> dùng Integer.parseInt(s, hệ cơ số vd: 16)
    giữa các hệ số với nhau thì cứ chuyển về 10 sau đó chuyển tiếp: Cơ số A → thập phân → cơ số B

[Mã câu hỏi (qCode): diDlCvVM].  Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 2207 (hỗ trợ thời gian giao tiếp tối đa cho mỗi yêu cầu là 5 giây). Yêu cầu sinh viên xây dựng chương trình client để tương tác với server, sử dụng các luồng data (DataInputStream và DataOutputStream) để trao đổi thông tin theo thứ tự sau:
a. Gửi mã sinh viên và mã câu hỏi: Chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;D68C93F7".
b. Nhận một số nguyên hệ thập phân từ server. Ví dụ:: 15226.
c. Chuyển đổi số nguyên nhận được sang hệ nhị phân và thập lục phân, ghép thành chuỗi và gửi lên server. Ví dụ: 15226 sẽ thành "11101101111010;3B7A"
d. Đóng kết nối: Kết thúc chương trình sau khi gửi kết quả chuyển đổi.
*/