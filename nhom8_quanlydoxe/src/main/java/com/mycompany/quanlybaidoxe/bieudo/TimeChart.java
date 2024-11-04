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
import java.util.ArrayList;
import java.util.List;

public class TimeChart {
    private JPanel jPanel;
    private XChartPanel<CategoryChart> chartPanel;

    public TimeChart(JPanel jPanel) {
        this.jPanel = jPanel;
    }

    public void createHourlyChart() {
        int[] entryCounts = new int[12]; // Đếm số lượt vào cho mỗi khoảng 2 giờ
        int[] exitCounts = new int[12];  // Đếm số lượt ra cho mỗi khoảng 2 giờ

        try {
            File inputFile = new File("thongketien.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("parkingSpot");
            for (int i = 0; i < nList.getLength(); i++) {
                Element element = (Element) nList.item(i);

                int entryHour = Integer.parseInt(element.getElementsByTagName("Giov").item(0).getTextContent());
                int exitHour = Integer.parseInt(element.getElementsByTagName("Gio").item(0).getTextContent());

                int entryIndex = entryHour / 2; // Xác định khoảng 2 giờ cho lượt vào
                int exitIndex = exitHour / 2;   // Xác định khoảng 2 giờ cho lượt ra

                if (entryIndex >= 0 && entryIndex < 12) {
                    entryCounts[entryIndex]++;
                }
                if (exitIndex >= 0 && exitIndex < 12) {
                    exitCounts[exitIndex]++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Tạo biểu đồ
        CategoryChart chart = new CategoryChartBuilder().width(800).height(600)
                .title("Số lượt vào và ra trong ngày mỗi 2h")
                .xAxisTitle("Khoảng 2 giờ")
                .yAxisTitle("Số lượt")
                .build();

        // Tùy chỉnh để tạo khoảng cách giữa các cột
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
        chart.getStyler().setHasAnnotations(true);
        chart.getStyler().setAvailableSpaceFill(0.6); // Giảm độ rộng của cột
        // Định dạng số cho trục Y
        chart.getStyler().setDecimalPattern("#,###.##"); // Định dạng với dấu phẩy cho phần nguyên

        // Dữ liệu cho biểu đồ
        List<String> timeRanges = new ArrayList<>();
        List<Integer> entryData = new ArrayList<>();
        List<Integer> exitData = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            timeRanges.add((i * 2) + "h-" + ((i + 1) * 2) + "h");
            entryData.add(entryCounts[i]);
            exitData.add(exitCounts[i]);
        }

        // Thêm dữ liệu vào biểu đồ
        chart.addSeries("Lượt vào", timeRanges, entryData);
        chart.addSeries("Lượt ra", timeRanges, exitData);

        // Cập nhật biểu đồ trong JPanel
        if (chartPanel != null) {
            jPanel.remove(chartPanel);
        }
        jPanel.removeAll();
        chartPanel = new XChartPanel<>(chart);
        jPanel.add(chartPanel, BorderLayout.CENTER);
        jPanel.revalidate();
        jPanel.repaint();
    }
}