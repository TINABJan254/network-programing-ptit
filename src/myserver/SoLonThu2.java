/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package myserver;

/**
 *
 * @author ADMIN
 */

import java.util.*;
import java.io.*;
import java.net.*;
import java.nio.charset.*;

public class SoLonThu2 {
    public static void main(String[] args) {
        int port = 806;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server đang chạy tại cổng " + port + "...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                clientSocket.setSoTimeout(5000); // timeout 5s
                System.out.println("Client kết nối: " + clientSocket.getInetAddress());

                handleClient(clientSocket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket socket) {
        try (
                InputStream in = socket.getInputStream();
                OutputStream out = socket.getOutputStream()
        ) {
            byte[] buffer = new byte[1024];

            // a. Nhận studentCode;qCode
            int len = in.read(buffer);
            String info = new String(buffer, 0, len, StandardCharsets.UTF_8);
            System.out.println("Nhận từ client: " + info);

            // b. Tạo chuỗi số nguyên random
            String numbers = generateRandomNumbers();
            out.write(numbers.getBytes(StandardCharsets.UTF_8));
            out.flush();
            System.out.println("Gửi chuỗi số: " + numbers);

            // c. Nhận kết quả từ client (giá trị lớn thứ hai, vị trí)
            len = in.read(buffer);
            String result = new String(buffer, 0, len, StandardCharsets.UTF_8);
            System.out.println("Client trả kết quả: " + result);

            socket.close();
            System.out.println("Đã đóng kết nối\n");

        } catch (Exception e) {
            System.out.println("Client timeout hoặc lỗi!");
        }
    }

    // Hàm random chuỗi số
    private static String generateRandomNumbers() {
        Random rand = new Random();
        int n = rand.nextInt(5) + 6; // 6–10 số

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = rand.nextInt(100); // 0–99
            sb.append(num);
            if (i < n - 1) sb.append(",");
        }
        return sb.toString();
    }
}
