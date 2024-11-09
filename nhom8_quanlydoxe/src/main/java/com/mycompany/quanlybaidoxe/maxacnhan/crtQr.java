/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlybaidoxe.maxacnhan;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author nhannt
 */
public abstract class crtQr {
    protected String randomText; // Biến lưu chuỗi ngẫu nhiên để sử dụng trong lớp con

    // Phương thức trừu tượng để hiển thị mã QR
    public abstract void displayQRCode();

    // Phương thức tạo hình ảnh mã QR
    protected BufferedImage generateQRCodeImage(String text) throws WriterException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, 190, 150);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }

    // Phương thức tạo chuỗi số ngẫu nhiên với độ dài chỉ định
    protected String generateRandomNumber(int length) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            builder.append(random.nextInt(10)); 
        }
        return builder.toString();
    }
}
