package com.mycompany.quanlybaidoxe.giaodienAdmin;

/**
 *
 * @author trung
 */
import com.mycompany.quanlybaidoxe.LogIn.spotType;
import java.io.File;
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

public class convertSpotXML {

    public static void addParkingSpotToXML(parkingSpot spot, spotType type, String filePath) throws ParserConfigurationException, TransformerException {
        File xmlFile = new File(filePath);
        Document doc;
        Element rootElement;

        try {
            if (xmlFile.exists()) {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                doc = docBuilder.parse(xmlFile);
                rootElement = doc.getDocumentElement();
            } else {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                doc = docBuilder.newDocument();
                rootElement = doc.createElement("parkingSpots");
                doc.appendChild(rootElement);
            }

            Element spotElement = doc.createElement("parkingSpot");

            Element spotID = doc.createElement("spotID");
            spotID.appendChild(doc.createTextNode(String.valueOf(spot.getSpotID())));
            spotElement.appendChild(spotID);

            Element tinhTrang = doc.createElement("tinhTrang");
            tinhTrang.appendChild(doc.createTextNode(String.valueOf(spot.isTinhTrang())));
            spotElement.appendChild(tinhTrang);

            Element chuXe = doc.createElement("chuXe");
            chuXe.appendChild(doc.createTextNode(spot.getChuXe() != null ? spot.getChuXe() : "null"));
            spotElement.appendChild(chuXe);

            Element gia = doc.createElement("Gia");
            gia.appendChild(doc.createTextNode(String.valueOf(spot.getGia())));
            spotElement.appendChild(gia);

            // Thêm phần tử type mà không cần kiểm tra null
            Element typeElement = doc.createElement("type");
            typeElement.appendChild(doc.createTextNode(type.toString()));
            spotElement.appendChild(typeElement);

            rootElement.appendChild(spotElement);

            // Lưu tài liệu XML ra file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));

            transformer.transform(source, result);

            System.out.println("Parking spot data with type added to " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error while adding parking spot to XML: " + e.getMessage());
        }
    }
}
