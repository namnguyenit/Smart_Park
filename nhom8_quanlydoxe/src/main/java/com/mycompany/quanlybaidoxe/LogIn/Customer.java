package com.mycompany.quanlybaidoxe.LogIn;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


public class Customer {
    private static int customerCounter = 1000;
    private String customerId;
    private String name;
    private String phoneNumber;
    private String email;
    private String bienSo;         
    private String spotId;         
    private Boolean trangThaiXe;   
    private Boolean qrCode;        
    private String username;
    private String password;       
    private String gio;
    private String phut;
    private String dayv;
    private String giov;
    private String phutv;
    private spotType loaiDo;


    public Customer(String customerId, String name, String phoneNumber, String email, String bienSo, String spotId, Boolean trangThaiXe, Boolean qrCode, String username, String password, String gio, String phut, String dayv, String giov, String phutv, spotType loaiDo) throws NoSuchAlgorithmException {
        this.customerId = generateCustomerId();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bienSo = bienSo;
        this.spotId = spotId;
        this.trangThaiXe = trangThaiXe;
        this.qrCode = qrCode;
        this.username = username;
        this.password = hashPassword(password);
        this.gio = gio;
        this.phut = phut;
        this.dayv = dayv;
        this.giov = giov;
        this.phutv = phutv;
        this.loaiDo = loaiDo;
    }

    public Customer(String customerId, String name, String bienSo, String spotId, Boolean trangThaiXe, String username) {
        this.customerId = customerId;
        this.name = name;
        this.bienSo = bienSo;
        this.spotId = spotId;
        this.trangThaiXe = trangThaiXe;
        this.username = username;
    }
    
    public Customer(String customerId, String name, String bienSo, String spotId, Boolean trangThaiXe, String username, spotType loaiDo) {
        this.customerId = customerId;
        this.name = name;
        this.bienSo = bienSo;
        this.spotId = spotId;
        this.trangThaiXe = trangThaiXe;
        this.username = username;
        this.loaiDo = loaiDo;
    }

    public spotType getLoaiDo() {
        return loaiDo;
    }

    public void setLoaiDo(spotType loaiDo) {
        this.loaiDo = loaiDo;
    }
    




    public Customer(String name, String username, String password) throws NoSuchAlgorithmException {
        this.customerId = generateCustomerId(); 
        this.name = name;
        this.username = username;
        this.password = hashPassword(password); 
        
    }

    
    
    public Customer() {
    }
    
    private String generateCustomerId() {
    customerCounter++; 
    return "CUS" + customerCounter; 
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
    
    public String getGio() {
        return gio;
    }


    public String getPhut() {    
        return phut;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
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
    
    public void setGio(String gio) {
        this.gio = gio;
    }

    public void setPhut(String phut) {
        this.phut = phut;
    }
    
    
    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBienSo() {
        return bienSo;
    }

    public void setBienSo(String bienSo) {
        this.bienSo = bienSo;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public Boolean getTrangThaiXe() {
        return trangThaiXe;
    }

    public void setTrangThaiXe(Boolean trangThaiXe) {
        this.trangThaiXe = trangThaiXe;
    }

    public Boolean getQrCode() {
        return qrCode;
    }

    public void setQrCode(Boolean qrCode) {
        this.qrCode = qrCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws NoSuchAlgorithmException {
        this.password = hashPassword(password);
    }

    // Mã hóa mật khẩu
    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes());
        return Base64.getEncoder().encodeToString(hashedBytes);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId='" + customerId + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", bienSo='" + bienSo + '\'' +
                ", spotId='" + spotId + '\'' +
                ", trangThaiXe=" + trangThaiXe +
                ", qrCode='" + qrCode + '\'' +
                ", username='" + username + '\'' +
                ", gio='" + gio + '\''+
                ", phut='" + phut +'\''+
                ", dayv='" + dayv +'\''+
                ", giov='" + giov +'\''+
                ", phutv='"+phutv+'\''+
                ", loaiDo='"+loaiDo+'\''+
                '}';
    }
}
