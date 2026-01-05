/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UDP;

/**
 *
 * @author ADMIN
 */

import java.io.*;
import java.util.*;
import java.net.*;

//udp - data type
public class XuLyChuoiXaoTron {
    public static void main(String[] args) throws Exception{
        DatagramSocket socket = new DatagramSocket();
        InetAddress addr = InetAddress.getByName("203.162.10.109");
        
        String iMes = ";B22DCCN222;pp2RZvy8";
        DatagramPacket pkt1 = new DatagramPacket(iMes.getBytes(), iMes.length(), addr, 2207);
        socket.send(pkt1);
        
        byte[] buffer = new byte[1024];
        DatagramPacket pkt2 = new DatagramPacket(buffer, buffer.length);
        socket.receive(pkt2);
        
        String s = new String(pkt2.getData(), 0, pkt2.getLength());
        s = s.replace(';', ' ');
        
        String[] tokens = s.split("\\s+");
        String reqId = tokens[0];
        String[] a = tokens[1].replaceAll("[,:]", " ").split("\\s+");
               
        HashMap<String, Integer> m = new HashMap<>();
        for (int i = 0; i < a.length; i += 2) {
            m.put(a[i], Integer.parseInt(a[i + 1]));
        }
        
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(m.entrySet());
        Collections.sort(list, new Comparator<>(){
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        
        String ans = reqId + ";";
        for (Map.Entry<String, Integer> x : list) {
            ans += x.getKey() + ",";
        }
        
        ans = ans.substring(0, ans.length() - 1);
        DatagramPacket pkt3 = new DatagramPacket(ans.getBytes(), ans.length(), addr, 2207);
        socket.send(pkt3);
        
    }
}

/*
[Mã câu hỏi (qCode): pp2RZvy8].  Một chương trình server cho phép giao tiếp qua giao thức UDP tại cổng 2207. Yêu cầu là xây dựng một chương trình client trao đổi thông tin với server theo kịch bản:

a. Gửi thông điệp là một chuỗi chứa mã sinh viên và mã câu hỏi theo định dạng ";studentCode;qCode". Ví dụ: ";B15DCCN009;F3E8B2D4".

b. Nhận thông điệp là một chuỗi từ server theo định dạng "requestId;string", với:
--- requestId là chuỗi ngẫu nhiên duy nhất.
--- string là một chuỗi chứa các chuỗi con bị thay đổi vị trí. Ví dụ: "veM3xgA1g:4,IPFfgEanY:5,aWXlSzDwe:2,PHupvPc:3,PR3gH8ahN:6,UEEKHLIt:7,M6dpWTE:1"

c. Xử lý chuỗi xáo trộn và gửi về chuỗi sau khi sắp xếp: "requestId;string". Ví dụ chuỗi đã được xử lý: "M6dpWTE,aWXlSzDwe,PHupvPc,veM3xgA1g,IPFfgEanY,PR3gH8ahN,UEEKHLIt"

d. Đóng socket và kết thúc chương trình.
*/