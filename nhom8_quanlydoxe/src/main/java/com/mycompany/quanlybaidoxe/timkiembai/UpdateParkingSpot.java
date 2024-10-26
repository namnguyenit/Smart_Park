/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlybaidoxe.timkiembai;

import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class UpdateParkingSpot {
    private String filePath;

    public UpdateParkingSpot(String filePath) {
        this.filePath = filePath;
    }

    // Cập nhật thông tin của một parkingSpot với spotID cụ thể
    public void updateSpot(String spotIdToUpdate, String newChuXe, boolean newTinhTrang) {
        try {
            File xmlFile = new File(filePath);
            if (!xmlFile.exists()) {
                System.out.println("File không tồn tại: " + filePath);
                return;
            }

            // Tạo đối tượng DocumentBuilder
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Lấy tất cả các phần tử <parkingSpot>
            NodeList spotList = doc.getElementsByTagName("parkingSpot");

            for (int i = 0; i < spotList.getLength(); i++) {
                Node spotNode = spotList.item(i);
                if (spotNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element spotElement = (Element) spotNode;

                    // Tìm phần tử <parkingSpot> có <spotID> bằng với spotIdToUpdate
                    String spotID = spotElement.getElementsByTagName("spotID").item(0).getTextContent();
                    if (spotID.equals(spotIdToUpdate)) {
                        // Cập nhật thông tin các thuộc tính con
                        spotElement.getElementsByTagName("chuXe").item(0).setTextContent(newChuXe);
                        spotElement.getElementsByTagName("tinhTrang").item(0).setTextContent(Boolean.toString(newTinhTrang));

                        // Ghi lại tài liệu XML sau khi cập nhật
                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        Transformer transformer = transformerFactory.newTransformer();
                        DOMSource source = new DOMSource(doc);
                        StreamResult result = new StreamResult(xmlFile);
                        transformer.transform(source, result);

                        System.out.println("Cập nhật thành công vị trí có spotID: " + spotIdToUpdate);
                        return; // Dừng lại sau khi đã cập nhật thành công
                    }
                }
            }

            System.out.println("Không tìm thấy vị trí có spotID: " + spotIdToUpdate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}