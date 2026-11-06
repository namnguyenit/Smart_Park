
package com.mycompany.quanlybaidoxe.giaodienAdmin;

/**
 *
 * @author trung
 */
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.ArrayList;
import com.mycompany.quanlybaidoxe.LogIn.Customer;

public class CustomerFilter {

    public static ArrayList<Customer> FilterCus(String trangThaiXeFilter, String filePath) {
        ArrayList<Customer> customerList = new ArrayList<>();

        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("Customer");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String customerId = element.getElementsByTagName("customerId").item(0).getTextContent();
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String username = element.getElementsByTagName("username").item(0).getTextContent();
                    String bienSo = element.getElementsByTagName("bienSo").item(0).getTextContent();
                    String trangThaiXe = element.getElementsByTagName("trangThaiXe").item(0).getTextContent();
                    Boolean ttx = stringToBoolean(trangThaiXe);
                    String spotId = element.getElementsByTagName("spotId").item(0).getTextContent();
                     if (trangThaiXe.equals(trangThaiXeFilter)) {
                        customerList.add(new Customer(customerId, name, bienSo, spotId, ttx, username));
                    } 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return customerList;
    }
    
    
    public static ArrayList<Customer> timkiem(String tukhoa, String filePath) {
        ArrayList<Customer> resultList = new ArrayList<>();

        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("Customer");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String customerId = element.getElementsByTagName("customerId").item(0).getTextContent();
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String username = element.getElementsByTagName("username").item(0).getTextContent();
                    String bienSo = element.getElementsByTagName("bienSo").item(0).getTextContent();
                    String spotId = element.getElementsByTagName("spotId").item(0).getTextContent();
                    String trangThaiXe = element.getElementsByTagName("trangThaiXe").item(0).getTextContent();
                    Boolean ttx = stringToBoolean(trangThaiXe);

                    // Kiểm tra nếu từ khóa xuất hiện trong bất kỳ thuộc tính nào
                    if (customerId.contains(tukhoa) || name.contains(tukhoa) || 
                        username.contains(tukhoa) || bienSo.contains(tukhoa) || 
                        spotId.contains(tukhoa)) {
                        
                        resultList.add(new Customer(customerId, name, bienSo, spotId, ttx, username));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultList;
    }
    
    
    
    public static boolean stringToBoolean(String str) {
    if (str == null) {
        return false; 
    }
    return str.equalsIgnoreCase("true");
}
}

