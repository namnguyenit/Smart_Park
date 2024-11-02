
package com.mycompany.quanlybaidoxe.giaodienAdmin;

/**
 *
 * @author trung
 */
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

class BackgroundScrollPane extends JScrollPane {
    private BufferedImage backgroundImage;

    // Constructor nhận đường dẫn ảnh nền
    public BackgroundScrollPane(Component view, String imagePath) {
        super(view);  // Khởi tạo JScrollPane với view component (ví dụ: JTable)
        
        // Tải ảnh nền
        try {
            backgroundImage = ImageIO.read(getClass().getResourceAsStream(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Thiết lập khoảng cách cho JTable để tạo không gian cách viền ngoài của JScrollPane
        if (view instanceof JTable) {
            ((JTable) view).setIntercellSpacing(new Dimension(10, 10));  // Điều chỉnh khoảng cách giữa các ô nếu cần
            ((JTable) view).setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));  // Thêm padding xung quanh JTable
        }

        // Thiết lập JScrollPane trong suốt để hiển thị ảnh nền
        setOpaque(false);
        getViewport().setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Vẽ ảnh nền nếu tải thành công
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
