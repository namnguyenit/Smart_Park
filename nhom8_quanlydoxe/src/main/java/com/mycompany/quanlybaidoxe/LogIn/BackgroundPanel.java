package com.mycompany.quanlybaidoxe.LogIn;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

class BackgroundPanel extends JPanel {
    private Image backgroundImage;

    // Constructor nhận đường dẫn đến file ảnh
    public BackgroundPanel(String imagePath) {
        try {
            // Đọc ảnh từ file
            backgroundImage = ImageIO.read(getClass().getResourceAsStream(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Đặt JPanel không đục để nền trở nên trong suốt
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        // Gọi phương thức của JPanel để vẽ nền trong suốt
        super.paintComponent(g);
        
        // Vẽ hình nền nếu ảnh đã tải thành công
        if (backgroundImage != null) {
            // Vẽ ảnh nền phía sau với kích thước toàn bộ JPanel
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}
