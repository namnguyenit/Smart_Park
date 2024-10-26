/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlybaidoxe.timkiembai;

import java.io.File;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author nhannt
 */
public class timbai {
     public static void timbai(String filePath, DefaultTableModel tableModel){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(filePath));
            Element root = doc.getDocumentElement();
            

            NodeList nodeList = root.getElementsByTagName("parkingSpot");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element spotElement = (Element) node;

                    // Lấy dữ liệu từ các phần tử con (spotID, tinhTrang, chuXe, Gia)
                    String spotID = spotElement.getElementsByTagName("spotID").item(0).getTextContent();
                    Boolean tinhTrang = Boolean.parseBoolean(spotElement.getElementsByTagName("tinhTrang").item(0).getTextContent());

                    
                    String gia = spotElement.getElementsByTagName("Gia").item(0).getTextContent();

                    if(tinhTrang.equals(false)){
                        tableModel.addRow(new Object[]{spotID, gia});
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }     
    }

}
