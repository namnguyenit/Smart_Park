/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlybaidoxe.trabai;

import com.mycompany.quanlybaidoxe.quanlydoxe.User;
import java.io.File;
import java.time.LocalDateTime;
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
public class Loaddanhsach {
    public static int loadds(String filePath, DefaultTableModel tableModel) {
    int tongtien = 0;  // Khởi tạo biến tongtien bên ngoài try
    try {
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
                String gia = spotElement.getElementsByTagName("Gia").item(0).getTextContent();
                User user = User.getInstance();
                System.out.println("Dayv: " + user.getDayv());
                System.out.println("Giov: " + user.getGiov());
                System.out.println("Phutv: " + user.getPhutv());
                // In ra để kiểm tra
                System.out.println("spotID from XML: " + spotID);
                System.out.println("spotID from User: " + user.getSpotId());
                System.out.println("Gia from XML: " + gia);

                // Kiểm tra xem user.getSpotId() có hợp lệ không
                if (user.getSpotId() != null && spotID.equals(user.getSpotId())) {
                    LocalDateTime currentDateTime = LocalDateTime.now();
                    int day = currentDateTime.getDayOfMonth();
                    int hour = currentDateTime.getHour();
                    int minute = currentDateTime.getMinute();

                    String dayv = user.getDayv();  // Giờ lưu từ User
                    String giov = user.getGiov();
                    String phutv = user.getPhutv();

                    int Dayv = Integer.parseInt(dayv);
                    int Giov = Integer.parseInt(giov);
                    int Phutv = Integer.parseInt(phutv);

                    System.out.println("Current Time: " + day + " " + hour + ":" + minute);
                    System.out.println("User Time: " + Dayv + " " + Giov + ":" + Phutv);

                    int tongphut = 0;
                    int phut1 = hour * 60 + minute;  // Tính phút hiện tại
                    int phut2 = Giov * 60 + Phutv;   // Tính phút từ thời gian lưu trong User

                    if ((day - Dayv) > 1) {
                        // Nếu qua nhiều ngày, tính tổng số phút của ngày hiện tại và số phút còn lại từ ngày trước
                        tongphut = (day - Dayv - 1) * 24 * 60 + phut1 + (24 * 60 - phut2); 
                    } else if ((day - Dayv) == 1) {
                        // Nếu chỉ khác một ngày, tính tổng số phút
                        tongphut = phut1 + (24 * 60 - phut2);
                    } else {
                        // Nếu cùng một ngày, chỉ cần trừ phút hiện tại với phút từ User
                        tongphut = phut1 - phut2;
                    }

                    System.out.println("Tongphut: " + tongphut);

                    try {
                        int tien = Integer.parseInt(gia);  // Giá từ XML
                        tongtien = tien * tongphut;  // Tính tổng tiền dựa trên phút

                        System.out.println("Gia: " + tien);
                        System.out.println("Tong tien: " + tongtien);
                    } catch (NumberFormatException e) {
                        System.out.println("Lỗi chuyển đổi giá: " + gia);
                        e.printStackTrace();
                    }
                    break; // Thoát khỏi vòng lặp khi tìm thấy thông tin
                } else {
                    System.out.println("Spot ID không hợp lệ: " + user.getSpotId());
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return tongtien;  // Đảm bảo trả về giá trị tongtien
}
}
