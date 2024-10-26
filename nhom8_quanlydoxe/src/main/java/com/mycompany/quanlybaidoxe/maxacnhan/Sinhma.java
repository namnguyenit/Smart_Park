/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlybaidoxe.maxacnhan;

import java.util.Random;

/**
 *
 * @author nhannt
 */
public class Sinhma {
    public static String generateRandomString(String characters, int length) {
        Random random = new Random();
        StringBuilder result = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length()); // Lấy chỉ số ngẫu nhiên trong phạm vi độ dài của chuỗi ký tự
            result.append(characters.charAt(index)); // Thêm ký tự ngẫu nhiên vào kết quả
        }
        
        return result.toString(); // Chuyển đổi StringBuilder thành chuỗi
    }
}
