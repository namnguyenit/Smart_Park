package com.mycompany.quanlybaidoxe.LogIn;

/**
 *
 * @author trung
 */

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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.security.MessageDigest;
import java.util.Base64;
import com.mycompany.quanlybaidoxe.quanlydoxe.User;


public class CustomerXMLReader {

    private String filePath;

    // Constructor của class CustomerXMLReader
    public CustomerXMLReader(String filePath) {
        this.filePath = filePath;
        checkAndCreateXML(); // Kiểm tra và tạo file XML nếu không tồn tại
    }

    // Hàm kiểm tra xem file có tồn tại hay không, nếu không thì tạo file mới
    private void checkAndCreateXML() {
        File xmlFile = new File(filePath);
        if (!xmlFile.exists()) {
            try {
                // Nếu file không tồn tại, tạo file mới với phần tử gốc <Customers>
                System.out.println("File không tồn tại. Tạo file mới: " + filePath);

                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
                Document doc = docBuilder.newDocument();

                // Tạo phần gốc <Customers>
                Element rootElement = doc.createElement("Customers");
                doc.appendChild(rootElement);

                // Ghi tài liệu XML ra file
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(xmlFile);
                transformer.transform(source, result);

                System.out.println("Đã tạo file XML mới với phần tử gốc <Customers>.");
            } catch (ParserConfigurationException | TransformerException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File đã tồn tại: " + filePath);
        }
    }

    // Hàm hash password để kiểm tra mật khẩu đã mã hóa
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // Hàm checkUser kiểm tra thông tin đăng nhập
    public int checkUser(String username, String password) {
        try {
            Document doc = getDocument();

            // Lấy danh sách tất cả các phần tử Customer
            NodeList customerList = doc.getElementsByTagName("Customer");

            // Kiểm tra trường hợp admin
            if (username.equals("admin") && password.equals("admin")) {
                return 2;
            }

            for (int i = 0; i < customerList.getLength(); i++) {
                Node customerNode = customerList.item(i);

                if (customerNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element customerElement = (Element) customerNode;

                    // Lấy username và password từ file XML
                    String storedUsername = customerElement.getElementsByTagName("username").item(0).getTextContent();
                    String storedPassword = customerElement.getElementsByTagName("password").item(0).getTextContent();

                    if (storedUsername.equals(username)) {
                        // Kiểm tra password đã mã hóa
                        if (storedPassword.equals(hashPassword(password))) {
                            String name = customerElement.getElementsByTagName("name").item(0).getTextContent();
                            
                            String bienSo = customerElement.getElementsByTagName("bienSo").item(0).getTextContent();
                            String spotId = customerElement.getElementsByTagName("spotId").item(0).getTextContent();
                            Boolean trangThaiXe = Boolean.parseBoolean(customerElement.getElementsByTagName("trangThaiXe").item(0).getTextContent());
                            Boolean qrCode = Boolean.parseBoolean(customerElement.getElementsByTagName("qrCode").item(0).getTextContent());
                            String gio = customerElement.getElementsByTagName("gio").item(0).getTextContent();
                            String phut = customerElement.getElementsByTagName("phut").item(0).getTextContent();
                            String dayv = customerElement.getElementsByTagName("dayv").item(0).getTextContent();
                            String giov = customerElement.getElementsByTagName("giov").item(0).getTextContent();
                            String phutv = customerElement.getElementsByTagName("phutv").item(0).getTextContent();
                            String loaiDo = customerElement.getElementsByTagName("loaiDo").item(0).getTextContent();
                            String solan = customerElement.getElementsByTagName("solan").item(0).getTextContent();
                            // Gán giá trị vào đối tượng User
                            User user = User.getInstance();
                            user.instance(name, bienSo, spotId, trangThaiXe, qrCode, username, gio, phut, dayv, giov, phutv, loaiDo, solan);
                            return 1; 
                        } else {
                            return 0; 
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Hàm checkTrung kiểm tra xem username có trùng không
    public int checkTrung(String username) {
        try {
            Document doc = getDocument();
            NodeList customerList = doc.getElementsByTagName("Customer");

            for (int i = 0; i < customerList.getLength(); i++) {
                Node customerNode = customerList.item(i);

                if (customerNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element customerElement = (Element) customerNode;
                    String luuusername = customerElement.getElementsByTagName("username").item(0).getTextContent();

                    if (luuusername.equals(username)) {
                        return 0; // Username đã tồn tại
                    }
                }
            }
            return 1; // Không trùng
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Phương thức hỗ trợ để lấy Document từ file XML
    private Document getDocument() {
        try {
            File xmlFile = new File(filePath);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(xmlFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
