/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TCP;

import java.io.Serializable;

/**
 *
 * @author ADMIN
 */
public class Laptop implements Serializable {

    private int id;
    private String code, name;
    private int quantity;

    private static final long serialVersionUID = 20150711L;

    public Laptop(int id, String code, String name, int quantity) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
    }

    public void solve() {
        this.quantity = Integer.parseInt(new StringBuilder(String.valueOf(this.quantity)).reverse().toString());
        String[] parts = this.name.trim().split("\\s+");

        StringBuilder result = new StringBuilder();

        for (String word : parts) {
            result.append(new StringBuilder(word).reverse()).append(" ");
        }
        this.name = result.toString();
    }

}