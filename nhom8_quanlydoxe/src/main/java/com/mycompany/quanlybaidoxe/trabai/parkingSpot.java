/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlybaidoxe.trabai;

/**
 *
 * @author nhannt
 */
public class parkingSpot {
    private String chuXe;  // Tên chủ xe
    private long Gia;      // Giá tiền

    
    public parkingSpot(String chuXe, long Gia) {
        this.chuXe = chuXe;
        this.Gia = Gia;
    }

    
    public String getChuXe() {
        return chuXe;
    }

    public long getGia() {
        return Gia;
    }

    
    public void setChuXe(String chuXe) {
        this.chuXe = chuXe;
    }

    public void setGia(long Gia) {
        this.Gia = Gia;
    }

}
