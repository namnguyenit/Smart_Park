package com.mycompany.quanlybaidoxe.quanlydoxe;

import javax.swing.JFrame;


import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JFrame;
import com.mycompany.quanlybaidoxe.maxacnhan.xacnhanQr;
import com.mycompany.quanlybaidoxe.maxacnhan.xacnhanma;
import com.mycompany.quanlybaidoxe.timkiembai.Luachonbai;
import com.mycompany.quanlybaidoxe.timkiembai.Timkiemtudong;
import com.mycompany.quanlybaidoxe.trabai.Trabai;
import com.mycompany.quanlybaidoxe.quanlydoxe.loitaothongtin;
import com.mycompany.quanlybaidoxe.quanlydoxe.baoloi;
import com.mycompany.quanlybaidoxe.quanlydoxe.User;
import com.mycompany.quanlybaidoxe.LogIn.LogIn;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import com.mycompany.quanlybaidoxe.giaodienAdmin.Button;

/**
 *
 * @author nhannt
 */
public class Giaodienchinh extends javax.swing.JFrame {
    
    
    
    //nhập loại xe và biển số
    private String nt="";//loại xe
    private String nb="";//biển số
    
    //dữ liệu tài khoản 
    private String tnd="";
    private String bsx="";
    private String tkdn="";
    private String sl;
    private MenuItem selectedMenuItem = null;
    
    //
    
    
    /**
     * Creates new form Giaodienchinh
     */
    
    private void setFrameIcon() {
        try {
            // Tải ảnh từ tệp
            Image icon = ImageIO.read(getClass().getResourceAsStream("/anh/icon.png"));
            // Đặt icon cho JFrame
            this.setIconImage(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // hàm làm hiệu ứng cho các nút chức năng
     private void changeButtonColor(JButton clickedButton) {
        // Đặt màu tất cả các nút thành trắng
        Bthongtinxe.setBackground(new Color(40, 62, 80));
        Btimkiem.setBackground(new Color(40, 62, 80));
        Btra.setBackground(new Color(40, 62, 80));
        Bxacnhan.setBackground(new Color(40, 62, 80));
        jButton2.setBackground(new Color(40, 62, 80));

        // Đặt nút được nhấn thành màu xanh
        clickedButton.setBackground(new Color(81, 99, 114));
    }
    
    public Giaodienchinh() {

        initComponents();
        setFrameIcon();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        customizeTextField();
        setLocationRelativeTo(null);
        setResizable(false);
        customInit();
        jPanel7.setBackground(new Color(44, 62, 80));
        jPanel8.setBackground(new Color(44, 62, 80));
        JPmc.add(JPttb, "JPttb");
        JPmc.add(JPtrb,"JPtrb");
        JPmc.add(JPvb,"JPvb");
        JPmc.add(JPtkb,"JPtkb");
        JPmc.add(JPtk,"JPtk");      
        
        CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "empty"); 
        
    }
    private void customizeTextField() {
        // Thêm placeholder cho JTnt (TextField biển số xe)
        
        JTbxwir.setText("Nhập biển số xe...vd:30V-123.12");
        JTbxwir.setForeground(Color.GRAY);


         JTbxwir.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                if (JTbxwir.getText().equals("Nhập biển số xe...vd:30V-123.12")) {
                    JTbxwir.setText("");
                    JTbxwir.setForeground(Color.BLACK); // Đổi màu chữ khi người dùng nhập
                }
            }

            public void focusLost(java.awt.event.FocusEvent evt) {
                if (JTbxwir.getText().isEmpty()) {
                    JTbxwir.setText("Nhập biển số xe...vd:30V-123.12");
                    JTbxwir.setForeground(Color.GRAY); // Trả lại màu placeholder nếu không có nội dung
                }
            }
        });
    }
    
    private void customInit() {
    MenuItem menuItem1 = new MenuItem("Tạo thông tin xe");
    MenuItem menuItem2 = new MenuItem("Tìm kiếm bãi đỗ xe");
    MenuItem menuItem3 = new MenuItem("Trả bãi đỗ xe");
    MenuItem menuItem4 = new MenuItem("Qr xác nhận vào bãi ");
    MenuItem menuItem5 = new MenuItem("Tài khoản");
    MenuItem menuItem6 = new MenuItem("EXIT");
    
    
    
    // Sử dụng phương thức setMenuItemFont để thay đổi font của MenuItem
    menuItem1.setMenuItemFont(new java.awt.Font("Verdana", java.awt.Font.PLAIN, 20));
    menuItem2.setMenuItemFont(new java.awt.Font("Verdana", java.awt.Font.PLAIN, 20));
    menuItem3.setMenuItemFont(new java.awt.Font("Verdana", java.awt.Font.PLAIN, 20));
    menuItem3.setMenuItemFont(new java.awt.Font("Verdana", java.awt.Font.PLAIN, 20));
    menuItem4.setMenuItemFont(new java.awt.Font("Verdana", java.awt.Font.PLAIN, 20));
    
//    menuItem4.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 20)); // JLabel sử dụng setFont như bình thường
    menuItem5.setMenuItemFont(new java.awt.Font("Verdana", java.awt.Font.PLAIN, 20));
    menuItem6.setMenuItemFont(new java.awt.Font("Verdana", java.awt.Font.PLAIN, 20));
    
    menuItem1.setForeground(new Color(44, 62, 80));
    menuItem2.setForeground(new Color(44, 62, 80));
    menuItem3.setForeground(new Color(44, 62, 80)); // Đặt màu cho menuItem3
    menuItem4.setForeground(new Color(44, 62, 80));
    menuItem5.setForeground(new Color(44, 62, 80)); 
    menuItem6.setForeground(new Color(44, 62, 80));
    
    JLabel menuItem7 = new JLabel("SmartPark");
    menuItem7.setFont(new java.awt.Font("Verdana", java.awt.Font.PLAIN, 40));
    menuItem7.setForeground(new Color(255, 255, 255)); // Màu chữ
    menuItem7.setOpaque(true);
    menuItem7.setBackground(new Color(44, 62, 80)); // Màu nền giống như nút
    menuItem7.setPreferredSize(new Dimension(200, 50)); // Kích thước giống như các nút
    menuItem7.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa chữ
    menuItem7.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Khoảng cách
    
    Dimension itemSize = new Dimension(230, 50);
    // Đặt ảnh n.png vào JLabel
//    ImageIcon icon = new ImageIcon(getClass().getResource(""));//ảnh
//    menuItem4.setIcon(icon);
//    menuItem4.setHorizontalTextPosition(SwingConstants.RIGHT); // Chữ bên phải ảnh
//    menuItem4.setIconTextGap(10); // Khoảng cách giữa ảnh và chữ
//    menuItem4.setHorizontalAlignment(SwingConstants.CENTER);
//    menuItem4.setPreferredSize(new Dimension(200, 50)); // Kích thước giống như các nút
//    menuItem4.setOpaque(true);
//    menuItem4.setBackground(new Color(108, 126, 225)); // Màu nền giống như nút
//    menuItem4.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Khoảng cách
    

//    ImageIcon icon = new ImageIcon(getClass().getResource("/images/icon.png"));
//    menuItem3.setIcon(icon); 

    menuItem1.setPreferredSize(itemSize);
//    menuItem1.setMaximumSize(itemSize);
    menuItem1.setMinimumSize(itemSize);

    menuItem2.setPreferredSize(itemSize);
   // menuItem2.setMaximumSize(itemSize);
    menuItem2.setMinimumSize(itemSize);

    menuItem3.setPreferredSize(itemSize);
   // menuItem3.setMaximumSize(itemSize);
    menuItem3.setMinimumSize(itemSize);

//    menuItem4.setPreferredSize(itemSize);
//    menuItem4.setMaximumSize(itemSize);
//    menuItem4.setMinimumSize(itemSize);
    menuItem4.setPreferredSize(itemSize);
   // menuItem4.setMaximumSize(itemSize);
    menuItem4.setMinimumSize(itemSize);
    
    menuItem5.setPreferredSize(itemSize);
    //menuItem5.setMaximumSize(itemSize);
    menuItem5.setMinimumSize(itemSize);
    
    menuItem6.setPreferredSize(itemSize);
    //menuItem5.setMaximumSize(itemSize);
    menuItem6.setMinimumSize(itemSize);
    // Thiết lập hành động cho các nút
    menuItem1.setOnClickAction(() -> {
            User user = User.getInstance();
        System.out.println(user.getBienSo()+" " + user.getGio()+ " " + user.getName()+ " " + user.getPhut()+" " +user.getSpotId()+" " +user.getUsername() +" "+ user.getQrCode() +" "+user.getTrangThaiXe());
        
        CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "JPttb");
            updateSelection(menuItem4);
        
        updateSelection(menuItem1);
    });
    
    menuItem4.setOnClickAction(() -> {
            // Your custom action here
             CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "JPvb");
            updateSelection(menuItem4);
    });
    
    menuItem2.setOnClickAction(() -> {
        
        CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "JPtkb");
       
        updateSelection(menuItem2);
    });

    menuItem3.setOnClickAction(() -> {
        
        CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "JPtrb");
        
        updateSelection(menuItem3);
    });

    menuItem5.setOnClickAction(() -> {
        
        CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "JPtk");
        
        updateSelection(menuItem5);
    });
    
    menuItem6.setOnClickAction(() -> {
            // Your custom action here
            new LogIn().setVisible(true);
        this.dispose();
            updateSelection(menuItem6);
    });
   
    
    // Thiết lập BoxLayout cho jPanel1
    jPanel7.setLayout(new BoxLayout(jPanel7, BoxLayout.Y_AXIS));

    // Thêm các JPanel chứa các menuItem vào jPanel1
     jPanel7.add(createPanelWithMenuItem(menuItem7));
    jPanel7.add(Box.createRigidArea(new Dimension(0, 5)));
    jPanel7.add(createPanelWithMenuItem(menuItem1));
    jPanel7.add(Box.createRigidArea(new Dimension(0, 5)));
    jPanel7.add(createPanelWithMenuItem(menuItem2));
    jPanel7.add(Box.createRigidArea(new Dimension(0, 5)));
    jPanel7.add(createPanelWithMenuItem(menuItem4));
    jPanel7.add(Box.createRigidArea(new Dimension(0, 5)));
    jPanel7.add(createPanelWithMenuItem(menuItem3));
    // Thêm một khoảng cách giữa menuItem3 và menuItem5
    jPanel7.add(Box.createRigidArea(new Dimension(0, 50))); // Thêm khoảng cách 50px
    
    jPanel7.add(createPanelWithMenuItem(menuItem5));
    jPanel7.add(Box.createRigidArea(new Dimension(0, 5)));
    jPanel7.add(createPanelWithMenuItem(menuItem6));

    // Cập nhật layout
    jPanel7.revalidate();
    jPanel7.repaint();    
    }
    
    private void updateSelection(MenuItem menuItem) {
        if (selectedMenuItem != null) {
            selectedMenuItem.setSelected(false);
        }
        selectedMenuItem = menuItem;
        selectedMenuItem.setSelected(true);
    }

    private JPanel createPanelWithMenuItem(JComponent menuItem) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(menuItem);
        return panel;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel8 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        javax.swing.JPanel thanhcongcu = new javax.swing.JPanel();
        Bthongtinxe = new Button();
        Btimkiem = new Button();
        Btra = new Button();
        Bxacnhan = new Button();
        Bthoat = new javax.swing.JButton();
        jButton2 = new Button();
        jPanel7 = new javax.swing.JPanel();
        JPmc = new BackgroundPanel("/quanlydoxe_img/Wellcom.png");
        JPttb = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel10 = new RoundedPanel(30);
        jLabel5 = new javax.swing.JLabel();
        JTbxwir = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        JClx = new javax.swing.JComboBox<>();
        JBxntt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JPvb = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel18 = new RoundedPanel(30);
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        JBqrv = new javax.swing.JButton();
        jPanel19 = new RoundedPanel(30);
        JBmv = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        JPtkb = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel12 = new RoundedPanel(30);
        jButton4 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel13 = new RoundedPanel(30);
        jButton5 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        JPtk = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel21 = new RoundedPanel(30);
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        JLtnd = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        JLbsx = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        JLtkdn = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        JLsltb = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        javax.swing.JPanel jPanel2 = new BackgroundPanel("/quanlydoxe_img/Wellcom.png");
        JPtrb = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel15 = new RoundedPanel(30);
        jButton1 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jPanel16 = new RoundedPanel(30);
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Smart Packing");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setLayout(new java.awt.CardLayout());

        thanhcongcu.setBackground(new java.awt.Color(44, 62, 80));

        Bthongtinxe.setBackground(new java.awt.Color(44, 62, 80));
        Bthongtinxe.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        Bthongtinxe.setForeground(new java.awt.Color(255, 255, 255));
        Bthongtinxe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/car (2).png"))); // NOI18N
        Bthongtinxe.setText("Tạo thông tin xe");
        Bthongtinxe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BthongtinxeActionPerformed(evt);
            }
        });

        Btimkiem.setBackground(new java.awt.Color(44, 62, 80));
        Btimkiem.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        Btimkiem.setForeground(new java.awt.Color(255, 255, 255));
        Btimkiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/search.png"))); // NOI18N
        Btimkiem.setText("Tìm kiếm chỗ đỗ xe");
        Btimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtimkiemActionPerformed(evt);
            }
        });

        Btra.setBackground(new java.awt.Color(44, 62, 80));
        Btra.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        Btra.setForeground(new java.awt.Color(255, 255, 255));
        Btra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/circle-parking.png"))); // NOI18N
        Btra.setText("Trả bãi đỗ xe");
        Btra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtraActionPerformed(evt);
            }
        });

        Bxacnhan.setBackground(new java.awt.Color(44, 62, 80));
        Bxacnhan.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        Bxacnhan.setForeground(new java.awt.Color(255, 255, 255));
        Bxacnhan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/qr-code.png"))); // NOI18N
        Bxacnhan.setText("QR xác nhận vào bãi");
        Bxacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BxacnhanActionPerformed(evt);
            }
        });

        Bthoat.setBackground(new java.awt.Color(255, 51, 51));
        Bthoat.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        Bthoat.setForeground(new java.awt.Color(255, 255, 255));
        Bthoat.setText("Exit");
        Bthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BthoatActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(44, 62, 80));
        jButton2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/user (1).png"))); // NOI18N
        jButton2.setText("Tài khoản");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout thanhcongcuLayout = new javax.swing.GroupLayout(thanhcongcu);
        thanhcongcu.setLayout(thanhcongcuLayout);
        thanhcongcuLayout.setHorizontalGroup(
            thanhcongcuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thanhcongcuLayout.createSequentialGroup()
                .addGroup(thanhcongcuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(thanhcongcuLayout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(thanhcongcuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Bthoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)))
                    .addGroup(thanhcongcuLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(thanhcongcuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Btra, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(thanhcongcuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Btimkiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Bthongtinxe, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Bxacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        thanhcongcuLayout.setVerticalGroup(
            thanhcongcuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thanhcongcuLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(Bthongtinxe, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btra, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bxacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(Bthoat, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jPanel6.add(thanhcongcu, "card2");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 307, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel7, "card3");

        JPmc.setLayout(new java.awt.CardLayout());

        JPttb.setBackground(new java.awt.Color(243, 244, 246));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tạo thông tin xe");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Biển số xe");

        JTbxwir.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        JTbxwir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTbxwirActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Loại xe");

        JClx.setBackground(new java.awt.Color(255, 255, 255));
        JClx.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        JClx.setForeground(new java.awt.Color(255, 255, 255));
        JClx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xe thô sơ", "Xe cơ giới (xe gắn máy)", "Xe cơ giới(xe ô tô)", "Xe chuyên dụng" }));
        JClx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JClxActionPerformed(evt);
            }
        });

        JBxntt.setBackground(new java.awt.Color(0, 0, 0));
        JBxntt.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        JBxntt.setForeground(new java.awt.Color(255, 255, 255));
        JBxntt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/circle-check-big.png"))); // NOI18N
        JBxntt.setText("Xác nhận");
        JBxntt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBxnttActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 32)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Nhập thông tin xe");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Vui lòng nhập đầy đủ thông tin xe của bạn");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JClx, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JBxntt, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(JTbxwir, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(24, 24, 24)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JTbxwir, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(JClx, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(JBxntt, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout JPttbLayout = new javax.swing.GroupLayout(JPttb);
        JPttb.setLayout(JPttbLayout);
        JPttbLayout.setHorizontalGroup(
            JPttbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JPttbLayout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(186, Short.MAX_VALUE))
        );
        JPttbLayout.setVerticalGroup(
            JPttbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPttbLayout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        JPmc.add(JPttb, "card2");

        JPvb.setBackground(new java.awt.Color(243, 244, 246));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setForeground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Xác nhận vào bãi");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel8)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel26.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel26.setText("Quét mã QR");

        jLabel27.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel27.setText("Quét mã QR được cung cấp tại bãi đỗ xe");

        JBqrv.setBackground(new java.awt.Color(51, 65, 85));
        JBqrv.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        JBqrv.setForeground(new java.awt.Color(255, 255, 255));
        JBqrv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/scan-line.png"))); // NOI18N
        JBqrv.setText("QR xác nhận");
        JBqrv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBqrvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27)
                    .addComponent(jLabel26)
                    .addComponent(JBqrv, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel27)
                .addGap(18, 18, 18)
                .addComponent(JBqrv, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        JBmv.setBackground(new java.awt.Color(51, 65, 85));
        JBmv.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        JBmv.setForeground(new java.awt.Color(255, 255, 255));
        JBmv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/key-round.png"))); // NOI18N
        JBmv.setText("Mã xác nhận");
        JBmv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBmvActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel29.setText("Nhập mã xác nhận");

        jLabel28.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel28.setText("Nhập mã xác nhận được cung cấp tại bãi đỗ xe");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBmv, javax.swing.GroupLayout.PREFERRED_SIZE, 439, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28)
                    .addComponent(jLabel29))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel28)
                .addGap(35, 35, 35)
                .addComponent(JBmv, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout JPvbLayout = new javax.swing.GroupLayout(JPvb);
        JPvb.setLayout(JPvbLayout);
        JPvbLayout.setHorizontalGroup(
            JPvbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JPvbLayout.createSequentialGroup()
                .addGap(163, 163, 163)
                .addGroup(JPvbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(152, Short.MAX_VALUE))
        );
        JPvbLayout.setVerticalGroup(
            JPvbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPvbLayout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(115, Short.MAX_VALUE))
        );

        JPmc.add(JPvb, "card5");

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Tìm kiếm bãi đỗ xe");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel9)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jButton4.setBackground(new java.awt.Color(51, 65, 85));
        jButton4.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/compass.png"))); // NOI18N
        jButton4.setText("Tìm kiếm tự động");
        jButton4.setMaximumSize(new java.awt.Dimension(168, 35));
        jButton4.setMinimumSize(new java.awt.Dimension(168, 35));
        jButton4.setPreferredSize(new java.awt.Dimension(168, 35));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel11.setText("Tìm kiếm tự động");

        jLabel12.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel12.setText("Hệ thống sẽ tự động tìm vị trí đỗ xe phù hợp nhất cho bạn");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(115, 115, 115)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(117, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addGap(29, 29, 29)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jButton5.setBackground(new java.awt.Color(51, 65, 85));
        jButton5.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/map-pin.png"))); // NOI18N
        jButton5.setText("Lựa chọn bãi đỗ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel13.setText("Lựa chọn thủ công");

        jLabel14.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        jLabel14.setText("Tự chọn vị trí đỗ xe theo sở thích của bạn");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addGap(27, 27, 27)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JPtkbLayout = new javax.swing.GroupLayout(JPtkb);
        JPtkb.setLayout(JPtkbLayout);
        JPtkbLayout.setHorizontalGroup(
            JPtkbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JPtkbLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(JPtkbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        JPtkbLayout.setVerticalGroup(
            JPtkbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPtkbLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        JPmc.add(JPtkb, "card6");

        JPtk.setBackground(new java.awt.Color(243, 244, 246));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Thông tin người dùng");

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel10)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Tên người dùng");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        JLtnd.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        JLtnd.setForeground(new java.awt.Color(0, 0, 0));
        JLtnd.setText("Chưa có thông tin ...");
        JLtnd.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                JLtndAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLtnd, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLtnd, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        JLbsx.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        JLbsx.setForeground(new java.awt.Color(0, 0, 0));
        JLbsx.setText("Chưa có thông tin ...");
        JLbsx.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                JLbsxAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLbsx, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLbsx, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel16.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Biển số xe");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        JLtkdn.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        JLtkdn.setForeground(new java.awt.Color(0, 0, 0));
        JLtkdn.setText("Chưa có thông tin...");
        JLtkdn.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                JLtkdnAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLtkdn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLtkdn, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel17.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Tài khoản đăng nhập");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        JLsltb.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        JLsltb.setForeground(new java.awt.Color(0, 0, 0));
        JLsltb.setText("Chưa có thông tin...");
        JLsltb.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                JLsltbAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLsltb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLsltb, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel18.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Số lần thuê bãi");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 155, Short.MAX_VALUE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel21Layout.createSequentialGroup()
                                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );

        javax.swing.GroupLayout JPtkLayout = new javax.swing.GroupLayout(JPtk);
        JPtk.setLayout(JPtkLayout);
        JPtkLayout.setHorizontalGroup(
            JPtkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPtkLayout.createSequentialGroup()
                .addContainerGap(154, Short.MAX_VALUE)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
        );
        JPtkLayout.setVerticalGroup(
            JPtkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPtkLayout.createSequentialGroup()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        JPmc.add(JPtk, "card7");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 857, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 696, Short.MAX_VALUE)
        );

        JPmc.add(jPanel2, "card3");

        JPtrb.setBackground(new java.awt.Color(243, 244, 246));
        JPtrb.setForeground(new java.awt.Color(255, 255, 255));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel7.setText("Trả bãi đỗ xe");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel7)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(51, 65, 85));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/circle-check-big.png"))); // NOI18N
        jButton1.setText("Xác nhận trả");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Xác nhận trả bãi");

        jLabel20.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel20.setText("Vui lòng xác nhận để hoàn tất việc trả bãi đỗ xe");

        jPanel16.setBackground(new java.awt.Color(255, 251, 235));
        jPanel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 204, 51)));

        jLabel21.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(133, 77, 14));
        jLabel21.setText("Lưu ý quan trọng");

        jLabel23.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel23.setText("Kiểm tra và mang theo tất cả tài sản cá nhân");

        jLabel24.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel24.setText("Đảm bảo xe đã được khóa an toàn");

        jLabel25.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel25.setText("Giữ biên nhận để đối chiếu khi cần thiết");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel21))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel25))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel22))
                            .addComponent(jLabel23))))
                .addContainerGap(130, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addGap(12, 12, 12)
                .addComponent(jLabel24)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel22))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel25)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel20)
                .addGap(28, 28, 28)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JPtrbLayout = new javax.swing.GroupLayout(JPtrb);
        JPtrb.setLayout(JPtrbLayout);
        JPtrbLayout.setHorizontalGroup(
            JPtrbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPtrbLayout.createSequentialGroup()
                .addContainerGap(141, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(128, 128, 128))
        );
        JPtrbLayout.setVerticalGroup(
            JPtrbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPtrbLayout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        JPmc.add(JPtrb, "card4");

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlydoxe_img/1.png"))); // NOI18N
        jLabel3.setText("CHỨC NĂNG");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(936, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 859, Short.MAX_VALUE)))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                    .addGap(0, 309, Short.MAX_VALUE)
                    .addComponent(JPmc, javax.swing.GroupLayout.PREFERRED_SIZE, 857, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(624, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                    .addGap(0, 86, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JPmc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BthongtinxeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BthongtinxeActionPerformed
        // TODO add your handling code here:
        User user = User.getInstance();
        System.out.println(user.getBienSo()+" " + user.getGio()+ " " + user.getName()+ " " + user.getPhut()+" " +user.getSpotId()+" " +user.getUsername() +" "+ user.getQrCode() +" "+user.getTrangThaiXe());
        
        CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "JPttb");
        changeButtonColor(Bthongtinxe);
        
    }//GEN-LAST:event_BthongtinxeActionPerformed

    private void BtimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtimkiemActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "JPtkb");
        changeButtonColor(Btimkiem);
    }//GEN-LAST:event_BtimkiemActionPerformed

    private void BtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtraActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "JPtrb");
        changeButtonColor(Btra);
        
    }//GEN-LAST:event_BtraActionPerformed

    private void BxacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BxacnhanActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "JPvb");
        changeButtonColor(Bxacnhan);
    }//GEN-LAST:event_BxacnhanActionPerformed

    private void BthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BthoatActionPerformed
        // TODO add your handling code here:
        
        
        new LogIn().setVisible(true);
        this.dispose();
        // trả lại trang đăng nhập
        
    }//GEN-LAST:event_BthoatActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //hiện frame tìm kiếm tự động và xác nhận hoặc tìm kiếm tự động tiếp hoặc quay lại
        new Timkiemtudong().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void JBxnttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBxnttActionPerformed
        // TODO add your handling code here:
        loitaothongtin k = new loitaothongtin();

        nt = String.valueOf(JClx.getSelectedIndex());
        nb = JTbxwir.getText();
        
        int h1 = k.kiem(nb, nt);

        if (h1 == -4) {
            baoloi baoloi = new baoloi(Giaodienchinh.this, true);
            baoloi.showPanel("card2");
            nt = "";
            baoloi.setVisible(true);
        } else if (h1 == -3) {
            baoloi baoloi = new baoloi(Giaodienchinh.this, true);
            baoloi.showPanel("card3");
            nt = "";
            baoloi.setVisible(true);
        } else if (h1 == -2) {
            baoloi baoloi = new baoloi(Giaodienchinh.this, true);
            baoloi.showPanel("card4");
            nt = "";
            baoloi.setVisible(true);
        } else if (h1 == -1) {
            baoloi baoloi = new baoloi(Giaodienchinh.this, true);
            baoloi.showPanel("card5");
            nt = "";
            baoloi.setVisible(true);
        } else if (h1 == 1) {
            bsx = nb; // Lưu lại nb vào bsx trước khi reset
            String filePath = "data_Customer.xml"; 
            UserUpdater userUpdater = new UserUpdater(filePath);
            User user = User.getInstance();
            user.setBienSo(bsx);
            if(nt.equals("0")){
                user.setLoaiDo("xeThoso");
            }else if(nt.equals("1")){
                user.setLoaiDo("xeGanmay");
            }else if(nt.equals("2")){
                user.setLoaiDo("xeOto");
            }else if(nt.equals("3")){
                user.setLoaiDo("xeChuyendung");
            }
            userUpdater.updateUser(user);
            
            
            baoloi baoloi = new baoloi(Giaodienchinh.this, true);
            baoloi.showPanel("card6");
            baoloi.setVisible(true);
            System.out.println(user.getBienSo()+" " + user.getGio()+ " " + user.getName()+ " " + user.getPhut()+" " +user.getSpotId()+" " +user.getUsername() +" "+ user.getQrCode() +" "+user.getTrangThaiXe());
        }
        //lưu vào data để chỉ có một cái biển số xe thôi
        System.out.println(nt +" "+ nb);
    }//GEN-LAST:event_JBxnttActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        //hiện frame lựa chọn các chỗ còn trống
        new Luachonbai().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // chuyển đến frame tính tiền xuất  hoá đơn và kèm mã qr trả tiền.
        new Trabai().setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void JBqrvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBqrvActionPerformed
        // TODO add your handling code here:
        //chuyển đến frame  hiện qr 
        new xacnhanQr().setVisible(true);
        
        
    }//GEN-LAST:event_JBqrvActionPerformed

    private void JBmvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBmvActionPerformed
        // TODO add your handling code here:
        //chuyển đến frame  hiện mã tự tạo và tạo khung nhập.
        //nếu nhập đúng sẽ tạo mã lưu xe đã vào là biển số.
        new xacnhanma().setVisible(true);
        //đã nhập đúng
        
    }//GEN-LAST:event_JBmvActionPerformed

    private void JLtndAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_JLtndAncestorAdded
        // TODO add your handling code here:
        User user = User.getInstance();
        tnd = user.getName();
        if(tnd.length() == 0){
            JLtnd.setText("Chưa có thông tin...");
        }else{
            JLtnd.setText(tnd);
        }
        
    }//GEN-LAST:event_JLtndAncestorAdded

    private void JLbsxAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_JLbsxAncestorAdded
        // TODO add your handling code here:
        
        User user = User.getInstance();
        if(user.getBienSo().length() == 3){
            JLbsx.setText("Chưa có thông tin...");
        }else{
            JLbsx.setText(user.getBienSo());
        }
    }//GEN-LAST:event_JLbsxAncestorAdded

    private void JLtkdnAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_JLtkdnAncestorAdded
        // TODO add your handling code here:
        User user = User.getInstance();
        tkdn = user.getUsername();
        if(tkdn.length() == 0){
            JLtkdn.setText("Chưa có thông tin...");
        }else{
            JLtkdn.setText(tkdn);
        }
    }//GEN-LAST:event_JLtkdnAncestorAdded

    private void JLsltbAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_JLsltbAncestorAdded
        // TODO add your handling code here:
        User user = User.getInstance();
        System.out.print(user.getSolan());
        if(user.getSolan().equals("null")){
            JLsltb.setText("Chưa có thông tin...");
        }else{
            JLsltb.setText(user.getSolan());
        }
    }//GEN-LAST:event_JLsltbAncestorAdded

    private void JClxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JClxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JClxActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "JPtk");
        changeButtonColor(jButton2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void JTbxwirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTbxwirActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_JTbxwirActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Giaodienchinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Giaodienchinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Giaodienchinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Giaodienchinh.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Giaodienchinh().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bthoat;
    private javax.swing.JButton Bthongtinxe;
    private javax.swing.JButton Btimkiem;
    private javax.swing.JButton Btra;
    private javax.swing.JButton Bxacnhan;
    private javax.swing.JButton JBmv;
    private javax.swing.JButton JBqrv;
    private javax.swing.JButton JBxntt;
    private javax.swing.JComboBox<String> JClx;
    private javax.swing.JLabel JLbsx;
    private javax.swing.JLabel JLsltb;
    private javax.swing.JLabel JLtkdn;
    private javax.swing.JLabel JLtnd;
    private javax.swing.JPanel JPmc;
    private javax.swing.JPanel JPtk;
    private javax.swing.JPanel JPtkb;
    private javax.swing.JPanel JPtrb;
    private javax.swing.JPanel JPttb;
    private javax.swing.JPanel JPvb;
    private javax.swing.JTextField JTbxwir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    // End of variables declaration//GEN-END:variables
}
