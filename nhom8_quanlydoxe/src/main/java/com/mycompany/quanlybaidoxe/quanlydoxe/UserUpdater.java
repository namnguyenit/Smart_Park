/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlybaidoxe.quanlydoxe;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class UserUpdater {
    private String filePath;

    public UserUpdater(String filePath) {
        this.filePath = filePath;
    }

    // Cập nhật thông tin User và ghi lại vào file XML
    public void updateUser(User user) {
        try {
            // Tạo DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(filePath);

            // Tìm phần tử <Customer> có username tương ứng
            NodeList customerList = doc.getElementsByTagName("Customer");
            for (int i = 0; i < customerList.getLength(); i++) {
                Element customerElement = (Element) customerList.item(i);
                String storedUsername = customerElement.getElementsByTagName("username").item(0).getTextContent();
                // Kiểm tra nếu username khớp
                if (storedUsername.equals(user.getUsername())) {
                    // Cập nhật thông tin trong XML
                    customerElement.getElementsByTagName("name").item(0).setTextContent(user.getName());
                    customerElement.getElementsByTagName("bienSo").item(0).setTextContent(user.getBienSo());
                    customerElement.getElementsByTagName("spotId").item(0).setTextContent(user.getSpotId());
                    customerElement.getElementsByTagName("trangThaiXe").item(0).setTextContent(user.getTrangThaiXe().toString());
                    customerElement.getElementsByTagName("qrCode").item(0).setTextContent(user.getQrCode().toString());
                    customerElement.getElementsByTagName("gio").item(0).setTextContent(user.getGio());
                    customerElement.getElementsByTagName("phut").item(0).setTextContent(user.getPhut());
                    customerElement.getElementsByTagName("dayv").item(0).setTextContent(user.getDayv());
                    customerElement.getElementsByTagName("giov").item(0).setTextContent(user.getGiov());
                    customerElement.getElementsByTagName("phutv").item(0).setTextContent(user.getPhutv());

                    // Ghi lại tài liệu XML vào file
                    TransformerFactory transformerFactory = TransformerFactory.newInstance();
                    Transformer transformer = transformerFactory.newTransformer();
                    DOMSource source = new DOMSource(doc);
                    StreamResult result = new StreamResult(new File(filePath));
                    transformer.transform(source, result);

                    System.out.println("Thông tin user đã được cập nhật vào file XML.");
                    return; // Dừng lại sau khi cập nhật thành công
                }
            }

            System.out.println("Không tìm thấy user với username: " + user.getUsername());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
