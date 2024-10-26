/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlybaidoxe.quanlydoxe;

/**
 *
 * @author nhannt
 */
public class loitaothongtin {
    public int kiem(String n,String k){
        // Kiểm tra nếu biển số xe vẫn còn là placeholder
        if(n.equals("Nhập biển số xe...vd:30V-123.12")) {
            return -4;
        }
        if(n.isEmpty()){
            return -2;
        }
        if(k.isEmpty()){
            return -3;
        }
        
        // Kiểm tra định dạng biển số xe
        if((int)n.charAt(0) < 48 || (int)n.charAt(0) > 57 ){
            return -1;
        }
        if((int)n.charAt(1) < 48 || (int)n.charAt(1) > 57 ){
            return -1;
        }
        if((int)n.charAt(2) < 65 || (int)n.charAt(2) > 90 ){
            return -1;
        }
        if(n.charAt(3) != '-' ){
            return -1;
        }
        if((int)n.charAt(4) < 48 || (int)n.charAt(4) > 57 ){
            return -1;
        }
        if((int)n.charAt(5) < 48 || (int)n.charAt(5) > 57 ){
            return -1;
        }
        if((int)n.charAt(6) < 48 || (int)n.charAt(6) > 57 ){
            return -1;
        }
        if(n.charAt(7) != '.' ){
            return -1;
        }
        if((int)n.charAt(8) < 48 || (int)n.charAt(8) > 57 ){
            return -1;
        }
        if((int)n.charAt(9) < 48 || (int)n.charAt(9) > 57 ){
            return -1;
        }
        
        return 1;   
    
    }
}
