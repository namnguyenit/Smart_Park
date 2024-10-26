/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quanlybaidoxe.quanlydoxe;




import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuItem extends JPanel {
    private String title;
    private Runnable onClickAction;
    private JLabel label; // Đặt JLabel thành biến thành viên để có thể truy cập từ các phương thức khác
    private JLabel iconLabel; // JLabel để hiển thị icon
    private Color backgroundColor = new Color(44, 62, 80);
    private boolean isSelected = false;
    private static final int RADIUS = 15; // Bán kính của góc bo tròn

    public MenuItem(String title) {
        this.title = title;
        setLayout(new BorderLayout());

        // Khởi tạo JLabel cho tiêu đề
        label = new JLabel(title);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(new Color(235, 243, 255));
        add(label, BorderLayout.CENTER);

        // Khởi tạo JLabel cho biểu tượng
        iconLabel = new JLabel();
        iconLabel.setHorizontalAlignment(SwingConstants.LEFT); // Căn trái cho biểu tượng
        add(iconLabel, BorderLayout.WEST); // Thêm iconLabel vào bên trái

        // Thiết lập kích thước và màu nền mặc định
        setPreferredSize(new Dimension(200, 50));
        setBackground(new Color(44, 62, 80));

        // Sự kiện thay đổi màu khi di chuột vào
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (!isSelected) {
                    setBackground(new Color(52, 73, 94)); // Đổi màu khi di chuột vào
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (!isSelected) {
                    setBackground(new Color(44, 62, 80)); // Đổi lại màu khi chuột ra khỏi
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                if (onClickAction != null) {
                    onClickAction.run(); // Gọi hành động khi thả chuột
                }
            }
        });
    }

    public void setOnClickAction(Runnable action) {
        this.onClickAction = action;
    }

    public void setMenuItemFont(Font font) {
        label.setFont(font);
    }

    public void setIcon(ImageIcon icon) {
        iconLabel.setIcon(icon);
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
        if (isSelected) {
            setBackground(new Color(52, 73, 94));
        } else {
            setBackground(new Color(44, 62, 80));
        }
    }



 
}