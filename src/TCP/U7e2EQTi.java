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
public class U7e2EQTi {

    public static void main(String[] args) throws Exception {
        String studentCode = "B22DCCN827";
        String qCode = "U7e2EQTi";
        String initialMessage = studentCode + ";" + qCode;

        Socket socket = new Socket("203.162.10.109", 2208);
        socket.setSoTimeout(5000);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        writer.write(initialMessage);
        writer.newLine();
        writer.flush();

        String response = reader.readLine();
        System.out.println(response);
        if (response == null) {
            System.out.println("Khong nhan duoc phan hoi tu server");
            return;
        }

        String[] domains = response.split(",\\s*");
        List<String> eduDomains = new ArrayList<>();
        for (String domain : domains) {
            if (domain.endsWith(".edu")) {
                eduDomains.add(domain);
            }
        }

        String eduList = String.join(", ", eduDomains);
        writer.write(eduList);
        writer.newLine();
        writer.flush();

        System.out.println("Gửi thành công: " + eduList);
    }
}
