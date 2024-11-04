/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlybaidoxe.trabai;
import com.mycompany.quanlybaidoxe.quanlydoxe.User;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 *
 * @author nhannt
 */
public class luutien {
    public static void luufilera(parkingSpot spot, String filePath) throws ParserConfigurationException, TransformerException {
        File xmlFile = new File(filePath);
        Document doc;
        Element rootElement;

        try {
            // Kiểm tra xem file XML có tồn tại không
            if (xmlFile.exists()) {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                doc = docBuilder.parse(xmlFile);

                rootElement = doc.getDocumentElement();  // Lấy phần tử gốc
            } else {
                // Nếu file không tồn tại, tạo file mới
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                doc = docBuilder.newDocument();
                rootElement = doc.createElement("parkingSpots");
                doc.appendChild(rootElement);
            }

            // Tạo phần tử parkingSpot mới
            Element spotElement = doc.createElement("parkingSpot");

            // Thêm thông tin chủ xe
            Element chuXe = doc.createElement("chuXe");
            chuXe.appendChild(doc.createTextNode(spot.getChuXe() != null ? spot.getChuXe() : "null"));
            spotElement.appendChild(chuXe);

            // Thêm thông tin giá tiền
            Element gia = doc.createElement("Gia");
            gia.appendChild(doc.createTextNode(String.valueOf(spot.getGia())));
            spotElement.appendChild(gia);
            
            Element gio = doc.createElement("Gio");
            int currentGio = LocalTime.now().getHour();// Chỉ lấy số ngày hiện tại
            gio.appendChild(doc.createTextNode(String.valueOf(currentGio)));
            spotElement.appendChild(gio);
            
            // Thêm thông tin ngày hiện tại (chỉ lưu số ngày)
            Element ngay = doc.createElement("Ngay");
            int currentDay = LocalDate.now().getDayOfMonth();  // Chỉ lấy số ngày hiện tại
            ngay.appendChild(doc.createTextNode(String.valueOf(currentDay)));
            spotElement.appendChild(ngay);
            
            Element thang = doc.createElement("Thang");
            int currentThang = LocalDate.now().getMonthValue();  // Chỉ lấy số thang hiện tại
            thang.appendChild(doc.createTextNode(String.valueOf(currentThang)));
            spotElement.appendChild(thang);
            
            User user = User.getInstance();
            
            Element dayv = doc.createElement("Dayv");
            
            dayv.appendChild(doc.createTextNode(user.getDayv()));
            spotElement.appendChild(dayv);
            
            Element giov = doc.createElement("Giov");
            
            giov.appendChild(doc.createTextNode(user.getGiov()));
            spotElement.appendChild(giov);
            
            
            // Thêm phần tử parkingSpot vào phần tử gốc
            rootElement.appendChild(spotElement);

            // Ghi tài liệu XML ra file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));

            transformer.transform(source, result);

            System.out.println("Parking spot data added to " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error while adding parking spot to XML: " + e.getMessage());
        }
    }
}
