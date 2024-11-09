package com.mycompany.quanlybaidoxe.giaodienAdmin;

import com.mycompany.quanlybaidoxe.trabai.dinhdangso;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.awt.*;
import java.io.File;
import com.mycompany.quanlybaidoxe.trabai.Number;
import com.mycompany.quanlybaidoxe.trabai.dinhdangso;


/**
 *
 * @author trung
 */
public class loadTable {
    public static void loadData(String filePath, DefaultTableModel tableModel){
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
                    String tinhTrang = spotElement.getElementsByTagName("tinhTrang").item(0).getTextContent();
                    String chuXe = spotElement.getElementsByTagName("chuXe").item(0).getTextContent();
                    String gia = spotElement.getElementsByTagName("Gia").item(0).getTextContent();
                    String type = spotElement.getElementsByTagName("type").item(0).getTextContent();
                    
                    int sotien = Integer.parseInt(gia);
                    Number tongst = new dinhdangso();
                    String sotien1 = tongst.chuyenso(sotien);
                    tableModel.addRow(new Object[]{spotID, tinhTrang, chuXe, sotien1,type});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }     
    }
    public static void loadDatabang3(String filePath, DefaultTableModel tableModel){
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(filePath));
            Element root = doc.getDocumentElement();
            

            NodeList nodeList = root.getElementsByTagName("Customer");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element spotElement = (Element) node;

                    // Lấy dữ liệu từ các phần tử con (spotID, tinhTrang, chuXe, Gia)
                    String customerId = spotElement.getElementsByTagName("customerId").item(0).getTextContent();
                    String name = spotElement.getElementsByTagName("name").item(0).getTextContent();
                    String username = spotElement.getElementsByTagName("username").item(0).getTextContent();
                    String bienSo = spotElement.getElementsByTagName("bienSo").item(0).getTextContent();
                    String trangThaiXe = spotElement.getElementsByTagName("trangThaiXe").item(0).getTextContent();
                    String spotId = spotElement.getElementsByTagName("spotId").item(0).getTextContent();
                    String loaiDo = spotElement.getElementsByTagName("loaiDo").item(0).getTextContent();

                    tableModel.addRow(new Object[]{customerId, name, username, bienSo,trangThaiXe,spotId,loaiDo});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }     
    }
    
}
