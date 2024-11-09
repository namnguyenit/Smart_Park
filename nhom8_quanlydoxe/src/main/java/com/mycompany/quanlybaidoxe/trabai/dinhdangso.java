/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlybaidoxe.trabai;

/**
 *
 * @author nhannt
 */
public class dinhdangso extends Number{

    @Override
    public String chuyenso(int number) {
        String numStr = Integer.toString(number);
        String result = "";

        int length = numStr.length();

        for (int i = 0; i < length; i++) {
            result += numStr.charAt(i);
            // Them sau mỗi 3 số
            if ((length - i - 1) % 3 == 0 && (length - i - 1) != 0) {
                result += ",";
            }
        }
        return result;
    
    }
    
}
