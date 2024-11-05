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

public class DailyRevenueChart {
    private JPanel jPanel;
    private JLabel jLabel;

    public DailyRevenueChart(JPanel jPanel, JLabel jLabel) {
        this.jPanel = jPanel;
        this.jLabel = jLabel; 
    }

    public void createDailyRevenueChart() {
        double[] dailyRevenue = new double[7]; // Doanh thu cho 7 ngày trong tuần

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
                double price = Double.parseDouble(element.getElementsByTagName("Gia").item(0).getTextContent());
                if (entryDay >= 1 && entryDay <= 7) {
                    dailyRevenue[entryDay - 1] += price; // Cộng doanh thu vào ngày tương ứng
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Tạo biểu đồ
        CategoryChart chart = new CategoryChartBuilder().width(900).height(500)
                .title("Doanh thu từng ngày trong tuần")
                .xAxisTitle("Ngày")
                .yAxisTitle("Doanh thu")
                .build();

        // Tùy chỉnh
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        // Định dạng số cho trục Y
        chart.getStyler().setDecimalPattern("#,###.##"); // Định dạng với dấu phẩy cho phần nguyên
        // Dữ liệu cho biểu đồ
        List<String> days = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            days.add("Ngày " + (i + 1));
        }
        chart.addSeries("Doanh thu", days, List.of(dailyRevenue[0], dailyRevenue[1], dailyRevenue[2],
                dailyRevenue[3], dailyRevenue[4], dailyRevenue[5], dailyRevenue[6]));
        
        // Cập nhật jLabel với tổng doanh thu của tuần
        double totalRevenue = 0;
        for (double revenue : dailyRevenue) {
            totalRevenue += revenue;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        jLabel.setText(decimalFormat.format(totalRevenue) + " VNĐ");
        // Cập nhật biểu đồ trong JPanel
        jPanel.removeAll();
        jPanel.add(new XChartPanel<>(chart), BorderLayout.CENTER);
        jPanel.revalidate();
        jPanel.repaint();
    }
}