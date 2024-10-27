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
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
    jPanel7.add(createPanelWithMenuItem(menuItem3));
    jPanel7.add(Box.createRigidArea(new Dimension(0, 5)));
    jPanel7.add(createPanelWithMenuItem(menuItem4));
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
        jPanel7 = new javax.swing.JPanel();
        javax.swing.JPanel thanhcongcu = new BackgroundPanel("/quanlydoxe_img/n1.png");
        Bthongtinxe = new javax.swing.JButton();
        Btimkiem = new javax.swing.JButton();
        Btra = new javax.swing.JButton();
        Bxacnhan = new javax.swing.JButton();
        Bthoat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        JPmc = new BackgroundPanel("/quanlydoxe_img/Wellcom.png");
        JPtrb = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        JPttb = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JTbxwir = new javax.swing.JTextField();
        JBxntt = new javax.swing.JButton();
        JClx = new javax.swing.JComboBox<>();
        JPvb = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        JBqrv = new javax.swing.JButton();
        JBmv = new javax.swing.JButton();
        JPtkb = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        JPtk = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        JLtnd = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        JLbsx = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        JLtkdn = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        JLsltb = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        javax.swing.JPanel jPanel2 = new BackgroundPanel("/quanlydoxe_img/Wellcom.png");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Smart Packing");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );

        jPanel6.add(jPanel7, "card3");

        Bthongtinxe.setBackground(new java.awt.Color(0, 90, 199));
        Bthongtinxe.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        Bthongtinxe.setForeground(new java.awt.Color(0, 0, 0));
        Bthongtinxe.setText("Tạo thông tin xe");
        Bthongtinxe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BthongtinxeActionPerformed(evt);
            }
        });

        Btimkiem.setBackground(new java.awt.Color(0, 90, 199));
        Btimkiem.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        Btimkiem.setForeground(new java.awt.Color(0, 0, 0));
        Btimkiem.setText("Tìm kiếm chỗ đỗ xe");
        Btimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtimkiemActionPerformed(evt);
            }
        });

        Btra.setBackground(new java.awt.Color(0, 90, 199));
        Btra.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        Btra.setForeground(new java.awt.Color(0, 0, 0));
        Btra.setText("Trả bãi đỗ xe");
        Btra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtraActionPerformed(evt);
            }
        });

        Bxacnhan.setBackground(new java.awt.Color(0, 90, 199));
        Bxacnhan.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        Bxacnhan.setForeground(new java.awt.Color(0, 0, 0));
        Bxacnhan.setText("QR xác nhận vào bãi");
        Bxacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BxacnhanActionPerformed(evt);
            }
        });

        Bthoat.setBackground(new java.awt.Color(0, 90, 199));
        Bthoat.setForeground(new java.awt.Color(0, 0, 0));
        Bthoat.setText("Exit");
        Bthoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BthoatActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlydoxe_img/2.png"))); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlydoxe_img/3.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlydoxe_img/1.png"))); // NOI18N
        jLabel3.setText("CHỨC NĂNG");

        jButton2.setBackground(new java.awt.Color(0, 90, 199));
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
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
                .addGap(37, 37, 37)
                .addGroup(thanhcongcuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(thanhcongcuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Bthoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(thanhcongcuLayout.createSequentialGroup()
                .addGroup(thanhcongcuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Bthongtinxe, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btra, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bxacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thanhcongcuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        thanhcongcuLayout.setVerticalGroup(
            thanhcongcuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thanhcongcuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(Bthongtinxe, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btra, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Bxacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(thanhcongcuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(thanhcongcuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bthoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7))
        );

        jPanel6.add(thanhcongcu, "card2");

        JPmc.setLayout(new java.awt.CardLayout());

        JPtrb.setForeground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jLabel7.setText("Trả bãi đỗ xe");

        jButton1.setBackground(new java.awt.Color(44, 62, 80));
        jButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Xác nhận trả");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPtrbLayout = new javax.swing.GroupLayout(JPtrb);
        JPtrb.setLayout(JPtrbLayout);
        JPtrbLayout.setHorizontalGroup(
            JPtrbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPtrbLayout.createSequentialGroup()
                .addGroup(JPtrbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPtrbLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(JPtrbLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(199, Short.MAX_VALUE))
        );
        JPtrbLayout.setVerticalGroup(
            JPtrbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPtrbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addGap(160, 160, 160)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(233, Short.MAX_VALUE))
        );

        JPmc.add(JPtrb, "card4");

        jLabel4.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jLabel4.setText("Tạo thông tin xe");

        jLabel5.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel5.setText("Nhập biển số xe");

        jLabel6.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel6.setText("Chọn loại xe");

        JTbxwir.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        JTbxwir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTbxwirActionPerformed(evt);
            }
        });

        JBxntt.setBackground(new java.awt.Color(0, 90, 199));
        JBxntt.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        JBxntt.setForeground(new java.awt.Color(0, 0, 0));
        JBxntt.setText("Xác nhận");
        JBxntt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBxnttActionPerformed(evt);
            }
        });

        JClx.setBackground(new java.awt.Color(255, 255, 255));
        JClx.setForeground(new java.awt.Color(255, 255, 255));
        JClx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Xe thô sơ", "Xe cơ giới (xe gắn máy)", "Xe cơ giới(xe ô tô)", "Xe chuyên dụng" }));
        JClx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JClxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPttbLayout = new javax.swing.GroupLayout(JPttb);
        JPttb.setLayout(JPttbLayout);
        JPttbLayout.setHorizontalGroup(
            JPttbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPttbLayout.createSequentialGroup()
                .addGroup(JPttbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPttbLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4))
                    .addGroup(JPttbLayout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addGroup(JPttbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(JTbxwir, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                            .addComponent(JClx, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(JPttbLayout.createSequentialGroup()
                        .addGap(246, 246, 246)
                        .addComponent(JBxntt, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPttbLayout.setVerticalGroup(
            JPttbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPttbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(78, 78, 78)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTbxwir, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JClx, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JBxntt, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        JPmc.add(JPttb, "card2");

        jLabel8.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jLabel8.setText("Xác nhận vào bãi");

        JBqrv.setBackground(new java.awt.Color(0, 90, 199));
        JBqrv.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        JBqrv.setForeground(new java.awt.Color(0, 0, 0));
        JBqrv.setText("QR xác nhận");
        JBqrv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBqrvActionPerformed(evt);
            }
        });

        JBmv.setBackground(new java.awt.Color(0, 90, 199));
        JBmv.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        JBmv.setForeground(new java.awt.Color(0, 0, 0));
        JBmv.setText("Mã xác nhận");
        JBmv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBmvActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPvbLayout = new javax.swing.GroupLayout(JPvb);
        JPvb.setLayout(JPvbLayout);
        JPvbLayout.setHorizontalGroup(
            JPvbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPvbLayout.createSequentialGroup()
                .addGroup(JPvbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPvbLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(JPvbLayout.createSequentialGroup()
                        .addGap(190, 190, 190)
                        .addGroup(JPvbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(JBqrv, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(JBmv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPvbLayout.setVerticalGroup(
            JPvbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPvbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(99, 99, 99)
                .addComponent(JBqrv, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76)
                .addComponent(JBmv, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        JPmc.add(JPvb, "card5");

        jLabel9.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jLabel9.setText("Tìm kiếm bãi đỗ xe");

        jButton4.setBackground(new java.awt.Color(0, 90, 199));
        jButton4.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Tìm kiếm tự động");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(0, 90, 199));
        jButton5.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 0));
        jButton5.setText("Lựa chọn bãi đỗ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPtkbLayout = new javax.swing.GroupLayout(JPtkb);
        JPtkb.setLayout(JPtkbLayout);
        JPtkbLayout.setHorizontalGroup(
            JPtkbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPtkbLayout.createSequentialGroup()
                .addGroup(JPtkbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JPtkbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(JPtkbLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel9))
                        .addGroup(JPtkbLayout.createSequentialGroup()
                            .addGap(174, 174, 174)
                            .addComponent(jButton4))))
                .addContainerGap(188, Short.MAX_VALUE))
        );
        JPtkbLayout.setVerticalGroup(
            JPtkbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPtkbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addGap(78, 78, 78)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(58, 58, 58)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(204, Short.MAX_VALUE))
        );

        JPmc.add(JPtkb, "card6");

        jLabel10.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel10.setText("Thông tin người dùng");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
                .addComponent(JLtnd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLtnd, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

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

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

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

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel15.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel15.setText("Tên người dùng");

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel16.setText("Biển số xe");

        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel17.setText("Tài khoản đăng nhập");

        jLabel18.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel18.setText("Số lần thuê bãi");

        javax.swing.GroupLayout JPtkLayout = new javax.swing.GroupLayout(JPtk);
        JPtk.setLayout(JPtkLayout);
        JPtkLayout.setHorizontalGroup(
            JPtkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPtkLayout.createSequentialGroup()
                .addGroup(JPtkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JPtkLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10))
                    .addGroup(JPtkLayout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(JPtkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(JPtkLayout.createSequentialGroup()
                                .addGroup(JPtkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel18))
                                .addGap(0, 187, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPtkLayout.setVerticalGroup(
            JPtkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPtkLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(29, 29, 29)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
        );

        JPmc.add(JPtk, "card7");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 581, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
        );

        JPmc.add(jPanel2, "card3");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel8Layout.createSequentialGroup()
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 583, Short.MAX_VALUE)))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                    .addGap(0, 269, Short.MAX_VALUE)
                    .addComponent(JPmc, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 515, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(JPmc, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 515, Short.MAX_VALUE))
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
    }//GEN-LAST:event_BthongtinxeActionPerformed

    private void BtimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtimkiemActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "JPtkb");
    }//GEN-LAST:event_BtimkiemActionPerformed

    private void BtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtraActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "JPtrb");
        
    }//GEN-LAST:event_BtraActionPerformed

    private void BxacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BxacnhanActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "JPvb");
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
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    // End of variables declaration//GEN-END:variables
}
