/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlybaidoxe.quanlydoxe;

/**
 *
 * @author nhannt
 */
public class User {
    private static User instance;
    private String name;
    private String bienSo;        
    private String spotId;         
    private Boolean trangThaiXe;   
    private Boolean qrCode;        
    private String username;
    private String gio;
    private String phut;
    private String dayv;
    private String giov;
    private String phutv;

    
    private User() {}

    // Phương thức để lấy đối tượng singleton
    public static User getInstance() {
        if (instance == null) {
            instance = new User();
        }
        return instance;
    }

    public void initialize(String name, String bienSo, String spotId, Boolean trangThaiXe, Boolean qrCode, String username, String gio, String phut, String dayv, String giov, String phutv) {
        this.name = name;
        this.bienSo = bienSo;
        this.spotId = spotId;
        this.trangThaiXe = trangThaiXe;
        this.qrCode = qrCode;
        this.username = username;
        this.gio = gio;
        this.phut = phut;
        this.dayv = dayv;
        this.giov = giov;
        this.phutv = phutv;
    }

    public String getName() {
        return name;
    }

    public String getBienSo() {
        return bienSo;
    }

    public String getSpotId() {
        return spotId;
    }

    public Boolean getTrangThaiXe() {
        return trangThaiXe;
    }

    public Boolean getQrCode() {
        return qrCode;
    }

    public String getUsername() {
        return username;
    }

    public String getGio() {
        return gio;
    }

    public String getPhut() {
        return phut;
    }

    public String getDayv() {
        return dayv;
    }

    public String getGiov() {
        return giov;
    }

    public String getPhutv() {
        return phutv;
    }

    public static void setInstance(User instance) {
        User.instance = instance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public void setTrangThaiXe(Boolean trangThaiXe) {
        this.trangThaiXe = trangThaiXe;
    }

    public void setQrCode(Boolean qrCode) {
        this.qrCode = qrCode;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setGio(String gio) {
        this.gio = gio;
    }

    public void setPhut(String phut) {
        this.phut = phut;
    }

    public void setDayv(String dayv) {
        this.dayv = dayv;
    }

    public void setGiov(String giov) {
        this.giov = giov;
    }

    public void setPhutv(String phutv) {
        this.phutv = phutv;
    }
    
    
    
   
}
