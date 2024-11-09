/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlybaidoxe.giaodienAdmin;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author nhannt
 */
public class ParkingSpotAnalyzer {
    private int totalSpots;
    private int nullOwnerSpots;

    public void analyze(String xmlFilePath) {
        try {
            File inputFile = new File(xmlFilePath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList spots = doc.getElementsByTagName("parkingSpot");
            totalSpots = spots.getLength();

            for (int i = 0; i < spots.getLength(); i++) {
                Element spot = (Element) spots.item(i);
                String chuXe = spot.getElementsByTagName("chuXe").item(0).getTextContent();
                if ("null".equals(chuXe)) {
                    nullOwnerSpots++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getTotalSpots() {
        return totalSpots;
    }

    public int getNullOwnerSpots() {
        return nullOwnerSpots;
    }

    public int getOccupiedSpots() {
        return totalSpots - nullOwnerSpots;
    }
}
