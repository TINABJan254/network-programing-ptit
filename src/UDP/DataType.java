/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

import java.io.*;
import java.util.*;
import java.net.*;

/**
 *
 * @author ADMIN
 */
public class DataType {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("203.162.10.109");
        int port = 2207;
        
        String initMess = ";B22DCCN827;hba6dsMe";
        DatagramPacket pkt1 = new DatagramPacket(initMess.getBytes(), initMess.length(), addr, port);
        socket.send(pkt1);
        
        byte[] buffer = new byte[1024];
        DatagramPacket pkt2 = new DatagramPacket(buffer, buffer.length);
        socket.receive(pkt2);
        
        String s1 = new String(pkt2.getData());
        String[] tmp = s1.trim().split(";");
        String requestId = tmp[0];
        String[] a = tmp[1].split(",");
        Arrays.sort(a, 0, a.length, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o2) - Integer.parseInt(o1);
            }
            
        });
        
        String ans = requestId + ";" + a[0] + "," + a[a.length - 1];
        System.out.println(ans);
        
        DatagramPacket pkt3 = new DatagramPacket(ans.getBytes(), ans.length(), addr, port);
        socket.send(pkt3);
    }
}

/*
[Mã câu hỏi (qCode): hba6dsMe].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:
    a.	Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng “;studentCode;qCode”. Ví dụ: “;B15DCCN001;DC73CA2E”
    b.	Nhận thông điệp là một chuỗi từ server theo định dạng “requestId;a1,a2,...,a50” 
    -	requestId là chuỗi ngẫu nhiên duy nhất
    -	a1 -> a50 là 50 số nguyên ngẫu nhiên
    c.	Thực hiện tìm giá trị lớn nhất và giá trị nhỏ nhất thông điệp trong a1 -> a50 và gửi thông điệp lên lên server theo định dạng “requestId;max,min”
    d.	Đóng socket và kết thúc chương trình
*/