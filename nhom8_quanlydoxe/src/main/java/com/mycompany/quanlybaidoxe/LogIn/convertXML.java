package com.mycompany.quanlybaidoxe.LogIn;

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
import org.w3c.dom.NodeList;

public class convertXML {

    // Phương thức thêm một đối tượng Customer vào file XML
    public static void addCustomerToXML(Customer customer, String filePath) throws ParserConfigurationException, TransformerException {
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
                rootElement = doc.createElement("Customers");
                doc.appendChild(rootElement);
            }

            Element customerElement = doc.createElement("Customer");

            Element customerId = doc.createElement("customerId");
            customerId.appendChild(doc.createTextNode(customer.getCustomerId() != null ? customer.getCustomerId() : "null"));
            customerElement.appendChild(customerId);

            Element name = doc.createElement("name");
            name.appendChild(doc.createTextNode(customer.getName() != null ? customer.getName() : "null"));
            customerElement.appendChild(name);

            Element phoneNumber = doc.createElement("phoneNumber");
            phoneNumber.appendChild(doc.createTextNode(customer.getPhoneNumber() != null ? customer.getPhoneNumber() : "null"));
            customerElement.appendChild(phoneNumber);

            Element email = doc.createElement("email");
            email.appendChild(doc.createTextNode(customer.getEmail() != null ? customer.getEmail() : "null"));
            customerElement.appendChild(email);

            Element bienSo = doc.createElement("bienSo");
            bienSo.appendChild(doc.createTextNode(customer.getBienSo() != null ? customer.getBienSo() : "null"));
            customerElement.appendChild(bienSo);

            Element spotId = doc.createElement("spotId");
            spotId.appendChild(doc.createTextNode(customer.getSpotId() != null ? customer.getSpotId() : "null"));
            customerElement.appendChild(spotId);

            Element trangThaiXe = doc.createElement("trangThaiXe");
            trangThaiXe.appendChild(doc.createTextNode(customer.getTrangThaiXe() != null ? customer.getTrangThaiXe().toString() : "null"));
            customerElement.appendChild(trangThaiXe);

            Element qrCode = doc.createElement("qrCode");
            qrCode.appendChild(doc.createTextNode(customer.getQrCode() != null ? customer.getQrCode().toString() : "null"));
            customerElement.appendChild(qrCode);

            Element username = doc.createElement("username");
            username.appendChild(doc.createTextNode(customer.getUsername() != null ? customer.getUsername() : "null"));
            customerElement.appendChild(username);

            Element password = doc.createElement("password");
            password.appendChild(doc.createTextNode(customer.getPassword() != null ? customer.getPassword() : "null"));
            customerElement.appendChild(password);

            Element gio = doc.createElement("gio");
            gio.appendChild(doc.createTextNode(customer.getGio() != null ? customer.getGio() : "null"));
            customerElement.appendChild(gio);

            Element phut = doc.createElement("phut");
            phut.appendChild(doc.createTextNode(customer.getPhut() != null ? customer.getPhut() : "null"));
            customerElement.appendChild(phut);

            Element dayv = doc.createElement("dayv");
            dayv.appendChild(doc.createTextNode(customer.getDayv() != null ? customer.getDayv() : "null"));
            customerElement.appendChild(dayv);

            Element giov = doc.createElement("giov");
            giov.appendChild(doc.createTextNode(customer.getGiov() != null ? customer.getGiov() : "null"));
            customerElement.appendChild(giov);

            Element phutv = doc.createElement("phutv");
            phutv.appendChild(doc.createTextNode(customer.getPhutv() != null ? customer.getPhutv() : "null"));
            customerElement.appendChild(phutv);

            // Thêm loaiDo vào XML
            Element loaiDo = doc.createElement("loaiDo");
            loaiDo.appendChild(doc.createTextNode(customer.getLoaiDo() != null ? customer.getLoaiDo().toString() : "null"));
            customerElement.appendChild(loaiDo);

            rootElement.appendChild(customerElement);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));

            transformer.transform(source, result);

            System.out.println("Customer data added to " + filePath);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error while adding Customer to XML: " + e.getMessage());
        }
    }      
}
