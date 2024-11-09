/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlybaidoxe.bieudo;

import org.knowm.xchart.CategoryChart;
import org.knowm.xchart.CategoryChartBuilder;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.style.Styler;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.awt.*;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class WeeklyRevenueChart {
    private JPanel jPanel;
    private JLabel jLabel;
    private JLabel jLabel1;

    public WeeklyRevenueChart(JPanel jPanel,JLabel jLabel,JLabel jLabel1) {
        this.jPanel = jPanel;
        this.jLabel = jLabel;
        this.jLabel1 = jLabel1;
    }

    public void createWeeklyRevenueChart() {
        double[] weeklyRevenue = new double[4]; // Doanh thu cho 4 tuần trong tháng

        // Lấy tháng hiện tại
        Calendar calendar = Calendar.getInstance();
        int currentMonth = calendar.get(Calendar.MONTH) + 1; // Tháng 0-11 nên cộng thêm 1

        try {
            File inputFile = new File("thongketien.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("parkingSpot");
            for (int i = 0; i < nList.getLength(); i++) {
                Element element = (Element) nList.item(i);
                int entryDay = Integer.parseInt(element.getElementsByTagName("Dayv").item(0).getTextContent());
                int entryMonth = Integer.parseInt(element.getElementsByTagName("Thang").item(0).getTextContent());
                double price = Double.parseDouble(element.getElementsByTagName("Gia").item(0).getTextContent());

                // Kiểm tra xem tháng của dữ liệu có trùng với tháng hiện tại không
                if (entryMonth == currentMonth) {
                    // Tính toán tuần tương ứng (4 tuần)
                    int weekIndex = (entryDay - 1) / 7; // Giả sử tháng này có 28 ngày, điều chỉnh nếu cần
                    if (weekIndex >= 0 && weekIndex < 4) {
                        weeklyRevenue[weekIndex] += price; // Cộng doanh thu vào tuần tương ứng
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Tạo biểu đồ
        CategoryChart chart = new CategoryChartBuilder().width(900).height(490)
                .title("Doanh thu từng tuần trong tháng")
                .xAxisTitle("Tuần")
                .yAxisTitle("Doanh thu")
                .build();

        // Tùy chỉnh
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        // Định dạng số cho trục Y
        chart.getStyler().setDecimalPattern("#,###.##"); // Định dạng với dấu phẩy cho phần nguyên

        // Dữ liệu cho biểu đồ
        List<String> weeks = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            weeks.add("Tuần " + (i + 1));
        }
        chart.addSeries("Doanh thu", weeks, List.of(weeklyRevenue[0], weeklyRevenue[1],
                weeklyRevenue[2], weeklyRevenue[3]));
        
        double totalRevenue = 0;
        for (double revenue : weeklyRevenue) {
            totalRevenue += revenue;
        }
        
        double trungbinh = totalRevenue/4.0;
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        jLabel.setText(decimalFormat.format(totalRevenue) + " VNĐ");
        jLabel1.setText(decimalFormat.format(trungbinh)+ " VNĐ");
        // Cập nhật biểu đồ trong JPanel
        jPanel.removeAll();
        jPanel.add(new XChartPanel<>(chart), BorderLayout.CENTER);
        jPanel.revalidate();
        jPanel.repaint();
    }

}

