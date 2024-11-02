package com.mycompany.quanlybaidoxe.giaodienAdmin;

/**
 *
 * @author trung
 */
import com.mycompany.quanlybaidoxe.LogIn.spotType;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.File;
import java.util.ArrayList;

public class ParkingSpotFilter {

    public static ArrayList<parkingSpot> locTinhTrang(String tinhTrangFilter, String filePath) {
        ArrayList<parkingSpot> parkingSpotList = new ArrayList<>();

        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("parkingSpot");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String spotID = element.getElementsByTagName("spotID").item(0).getTextContent();
                    String tinhTrang = element.getElementsByTagName("tinhTrang").item(0).getTextContent();
                    String chuXe = element.getElementsByTagName("chuXe").item(0).getTextContent();
                    String gia = element.getElementsByTagName("Gia").item(0).getTextContent();
                    String type = element.getElementsByTagName("type").item(0).getTextContent();

                    if (tinhTrang.equalsIgnoreCase(tinhTrangFilter)) {
                        parkingSpotList.add(new parkingSpot(Long.parseLong(spotID), stringToBoolean(tinhTrang),chuXe,Long.parseLong(gia), stringToSpotType(type) ));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return parkingSpotList;
    }
    
    public static ArrayList<parkingSpot> locType(String typeLoc, String filePath) {
        ArrayList<parkingSpot> parkingSpotList = new ArrayList<>();

        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);

            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("parkingSpot");

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    String spotID = element.getElementsByTagName("spotID").item(0).getTextContent();
                    String tinhTrang = element.getElementsByTagName("tinhTrang").item(0).getTextContent();
                    String chuXe = element.getElementsByTagName("chuXe").item(0).getTextContent();
                    String gia = element.getElementsByTagName("Gia").item(0).getTextContent();
                    String type = element.getElementsByTagName("type").item(0).getTextContent();

                    // Kiểm tra nếu type khớp với typeFilter
                    if (type.toString().equalsIgnoreCase(typeLoc)) {
                        parkingSpotList.add(new parkingSpot(Long.parseLong(spotID), stringToBoolean(tinhTrang),chuXe,Long.parseLong(gia), stringToSpotType(type) ));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return parkingSpotList;
    }
    
    
    
    private static spotType stringToSpotType(String str) {
        try {
            return spotType.valueOf(str);
        } catch (IllegalArgumentException | NullPointerException e) {
            e.printStackTrace();
            return null; // Hoặc có thể trả về giá trị mặc định tùy thuộc vào yêu cầu
        }
    }

    private static boolean stringToBoolean(String str) {
        return str != null && str.equalsIgnoreCase("true");
    }
}
