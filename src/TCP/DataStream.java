/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.*;
import java.net.*;

/**
 *
 * @author ADMIN
 */
public class DataStream {
    public static void main(String[] args) throws IOException {
        String studentCode = "B22DCCN827";
        String qCode = "DG0kqn1c";
        String initMessage = studentCode + ";" + qCode;
        
        Socket socket = new Socket("203.162.10.109", 2207);
        socket.setSoTimeout(5000);
        
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        out.writeUTF(initMessage);
        out.flush();
        
        int a = in.readInt();
        int b = in.readInt();
        
        System.out.println(a + " " + b);
        
        int sum = a + b;
        int mul = a * b;
        out.writeInt(sum);
        out.writeInt(mul);
        out.flush();
        socket.close();
        
        
    }
}

/*
[Mã câu hỏi (qCode): DG0kqn1c].  Một chương trình máy chủ cho phép kết nối qua TCP tại cổng 807 (hỗ trợ thời gian liên lạc tối đa cho mỗi yêu cầu là 5s), yêu cầu xây dựng chương trình (tạm gọi là client) thực hiện kết nối tới server tại cổng 807, sử dụng luồng byte dữ liệu (DataInputStream/DataOutputStream) để trao đổi thông tin theo thứ tự: 
    a.	Gửi chuỗi là mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ: "B15DCCN999;1D25ED92"
    b.	Nhận lần lượt hai số nguyên a và b từ server
    c.	Thực hiện tính toán tổng, tích và gửi lần lượt từng giá trị theo đúng thứ tự trên lên server
    d.	Đóng kết nối và kết thúc
*/