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

public class DayKhongLapDaiNhat {
    public static void main(String[] args) throws Exception{
        String iMes = "B22DCCN827;kIkjwL";
        
        Socket socket = new Socket("203.162.10.109", 2206);
        InputStream in = socket.getInputStream();
        OutputStream out = socket.getOutputStream();
        
        out.write(iMes.getBytes());
        out.flush();
        
        byte[] buffer = new byte[1024];
//        int len = in.read(buffer);
        int len = 2;
        if (len != -1) {
//            String s = new String(buffer, 0, len); 
            String s = "abcdabcdefghcda";
            
            int maxLen = 0;
            int start = 0, left = 0;
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                
                while (set.contains(c)) {
                    set.remove(s.charAt(left));
                    ++left;
                }
                
                set.add(c);
                if (i - left + 1 > maxLen) {
                    maxLen = i - left + 1;
                    start = left;
                }
            }
            
            String ans = s.substring(start, start + maxLen) + ";" + maxLen;
//            out.write(ans.getBytes());

            System.out.println(ans);

            out.close();
            in.close();
            
        }
        socket.close();
    }
}

/*
Một chương trình server cho phép kết nối qua giao thức TCP tại cổng 806 (thời
gian giao tiếp tối đa cho mỗi yêu cầu là 5s). Yêu cầu là xây dựng một chương trình client
thực hiện kết nối tới server sử dụng các luồng byte (InputStream/OutputStream) để trao
đổi thông tin theo thứ tự:
a. Gửi mã sinh viên và mã câu hỏi theo định dạng "studentCode;qCode". Ví dụ:
"B16DCCN999;10048F28".
b. Nhận chuỗi ký tự từ server. Ví dụ: "abcabcbb"5
c. Tìm và gửi lên server chuỗi con dài nhất từ chuỗi nhận được mà không có ký tự lặp lại
theo format "longestsubstring;length". Ví dụ: "abc;3".
d. Đóng kết nối và kết thúc chương trình
*/