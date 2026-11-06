package com.mycompany.quanlybaidoxe.giaodienAdmin;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class Button extends JButton {

    private Color effectColor = new Color(255, 255, 255);
    private Point pressedPoint;

    public Color getEffectColor() {
        return effectColor;
    }

    public void setEffectColor(Color effectColor) {
        this.effectColor = effectColor;
    }

    public Button() {
        setContentAreaFilled(false);
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setBackground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent me) {
                pressedPoint = me.getPoint();
                repaint();  // Cập nhật lại nút khi nhấn
            }

            @Override
            public void mouseReleased(java.awt.event.MouseEvent me) {
                pressedPoint = null;  // Xóa hiệu ứng sau khi nhả chuột
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        int width = getWidth();
        int height = getHeight();
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());

        // Bo góc ở mức vừa phải
        int cornerRadius = 20; 
        g2.fillRoundRect(0, 0, width, height, cornerRadius, cornerRadius);

        // Kiểm tra hiệu ứng nhấn
        if (pressedPoint != null) {
            g2.setColor(effectColor);
            g2.fillOval(pressedPoint.x - 10, pressedPoint.y - 10, 20, 20); // Vẽ hình tròn nhỏ tại vị trí bấm
        }

        g2.dispose();
        grphcs.drawImage(img, 0, 0, null);
        super.paintComponent(grphcs);
    }
}
