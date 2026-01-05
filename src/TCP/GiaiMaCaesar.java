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

//tcp - data stream
public class GiaiMaCaesar {
    public static void main(String[] args) throws Exception{
        String iMes = "B22DCCN222;diDlCvVM";
        
        Socket socket = new Socket("203.162.10.109", 2207);
        socket.setSoTimeout(5000);
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        out.writeUTF(iMes);
        out.flush();
        
        String s = in.readUTF();
        int k = in.readInt();
        
        String ans = "";
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)){
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - base - k + 26) % 26 + base);
            }
            ans += c;
        }
        
        out.writeUTF(ans);
        
        in.close();
        out.close();
        socket.close();
    }
}

/*
Encode: Cipher = PlainText + k
Decode: PlainText = Cipher - k
- 'a' -> chuyển về number (chuyển về cho thành dạng a->0; b->1; c->2; ... )
- k -> theo nguyên lý
+ 26 -> tránh số âm
% 26 -> quay vòng về
+ 'a' -> chuyển về char
Mật mã caesar, còn gọi là mật mã dịch chuyển, để giải mã thì mỗi ký tự nhận được
sẽ được thay thế bằng một ký tự cách nó một đoạn s. Ví dụ: với s = 3 thì ký tự “A” sẽ được
thay thế bằng ký tự “D”.
Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 807 (hỗ trợ thời gian
giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng chương trình client tương tác
với server trên, sử dụng các luồng byte (DataInputStream/DataOutputStream) để trao đổi
thông tin theo thứ tự:
a. Gửi một chuỗi gồm mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode".
Ví dụ: "B15DCCN999;D68C93F7"
b. Nhận lần lượt chuỗi đã bị mã hóa caesar và giá trị dịch chuyển s nguyên
c. Thực hiện giải mã ra thông điệp ban đầu và gửi lên Server
d. Đóng kết nối và kết thúc chương trình
*/
