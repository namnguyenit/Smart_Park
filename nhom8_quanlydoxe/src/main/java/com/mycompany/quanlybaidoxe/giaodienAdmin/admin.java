package com.mycompany.quanlybaidoxe.giaodienAdmin;

import com.mycompany.quanlybaidoxe.LogIn.Customer;
import com.mycompany.quanlybaidoxe.LogIn.LogIn;
import static com.mycompany.quanlybaidoxe.LogIn.spotType.*;
import com.mycompany.quanlybaidoxe.bieudo.DailyRevenueChart;
import com.mycompany.quanlybaidoxe.bieudo.TimeChart;
import com.mycompany.quanlybaidoxe.bieudo.WeeklyRevenueChart;
import com.mycompany.quanlybaidoxe.giaodienAdmin.CustomerFilter;
import com.mycompany.quanlybaidoxe.giaodienAdmin.ParkingSpotFilter;
import com.mycompany.quanlybaidoxe.giaodienAdmin.convertSpotXML;
import com.mycompany.quanlybaidoxe.giaodienAdmin.khoitaoform;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.CardLayout;
import java.awt.Color;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import static com.mycompany.quanlybaidoxe.giaodienAdmin.khoitaoform.deleteFile;
import com.mycompany.quanlybaidoxe.giaodienAdmin.loadTable;
import com.mycompany.quanlybaidoxe.giaodienAdmin.parkingSpot;
import com.mycompany.quanlybaidoxe.quanlydoxe.BackgroundPanel;
import com.mycompany.quanlybaidoxe.quanlydoxe.Giaodienchinh;
import com.mycompany.quanlybaidoxe.quanlydoxe.MenuItem;
import com.mycompany.quanlybaidoxe.quanlydoxe.User;
import java.awt.Dimension;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.SwingConstants;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Element;

/**
 *
 * @author nhannt
 */
public class admin extends javax.swing.JFrame {
     DefaultTableModel tableModel;
     DefaultTableModel tableModel2;
     DefaultTableModel tableModel3;
     DefaultTableModel tableModel4;
     DefaultTableModel tableModel5;
     DefaultTableModel tableModel6;

    
    
    //nhập loại xe và biển số
    private String nt;//loại xe
    private String nb;//biển số
    
    //dữ liệu tài khoản 
    private String tnd="";
    private String bsx="";
    private String tkdn="";
    private int sl=0;
    private MenuItem selectedMenuItem = null;
    
    
    
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
    
    
    public void  loadDulieulenBang1(){
        tableModel = (DefaultTableModel) bang1.getModel();
        tableModel.setRowCount(0);
        loadTable.loadData("data_parkSpot.xml",tableModel);
    }
    public void  loadDulieulenBang2(){
        tableModel2 = (DefaultTableModel) bang2.getModel();
        tableModel2.setRowCount(0);
        loadTable.loadData("data_parkSpot.xml",tableModel2);
    }
    public void  loadDulieulenBang3(){
        tableModel3 = (DefaultTableModel) bang3.getModel();
        tableModel3.setRowCount(0);
        loadTable.loadDatabang3("data_Customer.xml",tableModel3);
    }
    public void loadLoclenBang3(String trangThai){
        tableModel4 = (DefaultTableModel) bang3.getModel();
        tableModel4.setRowCount(0);
        ArrayList<Customer> customerLoc = new ArrayList<>();
        customerLoc = CustomerFilter.FilterCus(trangThai,"data_Customer.xml" );
        for (Customer customer : customerLoc) {
            Object[] rowData = {
                customer.getCustomerId(),   
                customer.getName(),         
                customer.getUsername(),     
                customer.getBienSo(),       
                customer.getTrangThaiXe(),  
                customer.getSpotId()        
            };
            tableModel4.addRow(rowData);
        }
    }
    public void loadLocTinhTrangBang2(String trangThai){
        tableModel5 = (DefaultTableModel) bang2.getModel();
        tableModel5.setRowCount(0);
        ArrayList<parkingSpot> Spottrangthai = new ArrayList<>();
        Spottrangthai = ParkingSpotFilter.locTinhTrang(trangThai, "data_parkSpot.xml");
        for (parkingSpot spot : Spottrangthai){
            Object[] rowData ={
                spot.getSpotID(),
                spot.getTinhTrang(),
                spot.getChuXe(),
                spot.getGia(),
                spot.getType()
            };
            tableModel5.addRow(rowData);
        }
    }
    
    public void loadLocTypeBang2(String type){
        tableModel6 = (DefaultTableModel) bang2.getModel();
        tableModel6.setRowCount(0);
        ArrayList<parkingSpot> SpotType = new ArrayList<>();
        SpotType = ParkingSpotFilter.locType(type, "data_parkSpot.xml");
        for (parkingSpot spot : SpotType){
            Object[] rowData ={
                spot.getSpotID(),
                spot.getTinhTrang(),
                spot.getChuXe(),
                spot.getGia(),
                spot.getType()
            };
            tableModel6.addRow(rowData);
        }
    }
    
    private void customInit() {
    MenuItem menuItem1 = new MenuItem("Thông tin bãi đỗ xe");
    MenuItem menuItem2 = new MenuItem("Thêm và xoá bãi");
    MenuItem menuItem3 = new MenuItem("Thông tin người dùng");
    MenuItem menuItem6 = new MenuItem("EXIT");
    
    
    
    // Sử dụng phương thức setMenuItemFont để thay đổi font của MenuItem
    menuItem1.setMenuItemFont(new java.awt.Font("Verdana", java.awt.Font.PLAIN, 20));
    menuItem2.setMenuItemFont(new java.awt.Font("Verdana", java.awt.Font.PLAIN, 20));
    menuItem3.setMenuItemFont(new java.awt.Font("Verdana", java.awt.Font.PLAIN, 20));
    
    
    
//    menuItem4.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 20)); // JLabel sử dụng setFont như bình thường
    
    menuItem6.setMenuItemFont(new java.awt.Font("Verdana", java.awt.Font.PLAIN, 20));
    
    menuItem1.setForeground(new Color(44, 62, 80));
    menuItem2.setForeground(new Color(44, 62, 80));
    menuItem3.setForeground(new Color(44, 62, 80)); // Đặt màu cho menuItem3
    
    
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
    
   // menuItem4.setMaximumSize(itemSize);
    
    
    
    //menuItem5.setMaximumSize(itemSize);
    
    
    menuItem6.setPreferredSize(itemSize);
    //menuItem5.setMaximumSize(itemSize);
    menuItem6.setMinimumSize(itemSize);
    // Thiết lập hành động cho các nút
    menuItem1.setOnClickAction(() -> {
        loadDulieulenBang2();
        CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "JPttb");
        
        updateSelection(menuItem1);
    });
    
    
    menuItem2.setOnClickAction(() -> {
         loadDulieulenBang1();
        CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "JPtkb");
        
       
        updateSelection(menuItem2);
    });

    menuItem3.setOnClickAction(() -> {
        loadDulieulenBang3();
        CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "JPtrb");
                
        updateSelection(menuItem3);
    });

    
    menuItem6.setOnClickAction(() -> {
            // Your custom action here
            new LogIn().setVisible(true);
            this.dispose();
            updateSelection(menuItem6);
    });
   
    
    // Thiết lập BoxLayout cho jPanel1
    jPanel11.setLayout(new BoxLayout(jPanel11, BoxLayout.Y_AXIS));

    // Thêm các JPanel chứa các menuItem vào jPanel1
     jPanel11.add(createPanelWithMenuItem(menuItem7));
    jPanel11.add(Box.createRigidArea(new Dimension(0, 5)));
    jPanel11.add(createPanelWithMenuItem(menuItem1));
    jPanel11.add(Box.createRigidArea(new Dimension(0, 5)));
    jPanel11.add(createPanelWithMenuItem(menuItem2));
    jPanel11.add(Box.createRigidArea(new Dimension(0, 5)));
    jPanel11.add(createPanelWithMenuItem(menuItem3));
    jPanel11.add(Box.createRigidArea(new Dimension(0, 5)));
    
    // Thêm một khoảng cách giữa menuItem3 và menuItem5
    jPanel11.add(Box.createRigidArea(new Dimension(0, 80))); // Thêm khoảng cách 50px
    
    

    jPanel11.add(createPanelWithMenuItem(menuItem6));

    // Cập nhật layout
    jPanel11.revalidate();
    jPanel11.repaint();    
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
    
    public static void xoaParkingSpot(String filePath, long spotID) {
        try {
       
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(filePath));
            doc.getDocumentElement().normalize();

            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();
            
            String expression = String.format("/parkingSpots/parkingSpot[spotID='%d']", spotID);
            Node parkingSpotNode = (Node) xpath.evaluate(expression, doc, XPathConstants.NODE);
            
            if (parkingSpotNode != null) {
                parkingSpotNode.getParentNode().removeChild(parkingSpotNode);
                
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(filePath));
                transformer.transform(source, result);

                System.out.println("Xóa thành công parkingSpot với ID: " + spotID);
            } else {
                System.out.println("Không tìm thấy parkingSpot với ID: " + spotID);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public static void xoaCustomer(String filePath, String customerId) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(filePath));
            doc.getDocumentElement().normalize();

            XPathFactory xpathFactory = XPathFactory.newInstance();
            XPath xpath = xpathFactory.newXPath();

            String expression = String.format("/Customers/Customer[customerId='%s']", customerId);
            Node customerNode = (Node) xpath.evaluate(expression, doc, XPathConstants.NODE);

            if (customerNode != null) {
                customerNode.getParentNode().removeChild(customerNode);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(filePath));
                transformer.transform(source, result);

                System.out.println("Xóa thành công Customer với ID: " + customerId);
            } else {
                System.out.println("Không tìm thấy Customer với ID: " + customerId);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int checkCusID(String filePath, String cusID) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(filePath));
            doc.getDocumentElement().normalize();
            NodeList customerList = doc.getElementsByTagName("Customer");

            for (int i = 0; i < customerList.getLength(); i++) {
                Node customerNode = customerList.item(i);
                if (customerNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element customerElement = (Element) customerNode;
                    String currentCusID = customerElement.getElementsByTagName("customerId").item(0).getTextContent();
       
                    if (currentCusID.equals(cusID)) {
                        return 1;
                }
            }
        }
        return 0; 
        } catch (Exception e) {
            e.printStackTrace();
            return 0; 
        }
    }

    
    private void themThanhCong() {
        javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
        javax.swing.JButton jButton1 = new javax.swing.JButton();

        JDialog dialog = new JDialog(this, "Thông báo", true); 

        dialog.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); 
        jLabel1.setText("Thêm thành công");

        jButton1.setText("Đóng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dialog.dispose();
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(dialog.getContentPane());
        dialog.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(jLabel1)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(35, 35, 35))
        );


        dialog.pack();
        dialog.setLocationRelativeTo(this); 
        dialog.setVisible(true);
    }
        public admin() {
            initComponents();
            setFrameIcon();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            jPanel11.setBackground(new Color(44, 62, 80));
            setLocationRelativeTo(null);
            setResizable(false);
            customInit();


            JPmc.add(JPttb, "JPttb");
            JPmc.add(JPtrb,"JPtrb");
            JPmc.add(JPtkb,"JPtkb");
            JPmc.add(jPanel14,"JPtk");

            // Hiển thị panel trống mặc định
            CardLayout cl = (CardLayout) JPmc.getLayout();
            cl.show(JPmc, "empty"); 
            
            
            jPanel17.add(jPanel20,"thang");
            jPanel17.add(jPanel19,"tuan");
            jPanel17.add(jPanel15,"trong");
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        javax.swing.JPanel thanhcongcu = new javax.swing.JPanel();
        Bthongtinxe = new javax.swing.JButton();
        Btimkiem = new javax.swing.JButton();
        Btra = new javax.swing.JButton();
        Bthoat = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        JPmc = new BackgroundPanel("/quanlydoxe_img/Wellcom.png");
        javax.swing.JPanel jPanel2 = new BackgroundPanel("/quanlydoxe_img/Wellcom.png");
        JPtrb = new javax.swing.JPanel();
        jScrollPane2 = new RoundedScrollPane(bang3,25);
        bang3 = new CustomJTable(tableModel3);
        jPanel12 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        locnguoidung = new javax.swing.JComboBox<>();
        jButton13 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        xoacus = new javax.swing.JButton();
        JPttb = new javax.swing.JPanel();
        jScrollPane1 = new RoundedScrollPane(bang2,25);
        bang2 = new CustomJTable(tableModel2);
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        loctype = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        JPtkb = new javax.swing.JPanel();
        jScrollPane3 = new RoundedScrollPane(bang3,25);
        bang1 = new CustomJTable(tableModel);
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Bdt = new javax.swing.JButton();
        Bdn = new javax.swing.JButton();
        Brv = new javax.swing.JButton();
        jScrollPane4 = new RoundedScrollPane(jPanel18,25);
        jPanel18 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Smart Packing");
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setLayout(new java.awt.CardLayout());

        thanhcongcu.setBackground(new java.awt.Color(44, 62, 80));

        Bthongtinxe.setBackground(new java.awt.Color(0, 90, 199));
        Bthongtinxe.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        Bthongtinxe.setForeground(new java.awt.Color(0, 0, 0));
        Bthongtinxe.setText("Thông tin bãi đỗ xe");
        Bthongtinxe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BthongtinxeActionPerformed(evt);
            }
        });

        Btimkiem.setBackground(new java.awt.Color(0, 90, 199));
        Btimkiem.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        Btimkiem.setForeground(new java.awt.Color(0, 0, 0));
        Btimkiem.setText("Thêm và xóa bãi");
        Btimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtimkiemActionPerformed(evt);
            }
        });

        Btra.setBackground(new java.awt.Color(0, 90, 199));
        Btra.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        Btra.setForeground(new java.awt.Color(0, 0, 0));
        Btra.setText("Thông tin người dùng");
        Btra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtraActionPerformed(evt);
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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlydoxe_img/3.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/quanlydoxe_img/1.png"))); // NOI18N
        jLabel3.setText("CHỨC NĂNG");

        jButton2.setBackground(new java.awt.Color(0, 90, 199));
        jButton2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 0));
        jButton2.setText("Biểu đồ thống kê");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout thanhcongcuLayout = new javax.swing.GroupLayout(thanhcongcu);
        thanhcongcu.setLayout(thanhcongcuLayout);
        thanhcongcuLayout.setHorizontalGroup(
            thanhcongcuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thanhcongcuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(thanhcongcuLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(Bthoat, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(thanhcongcuLayout.createSequentialGroup()
                .addGroup(thanhcongcuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bthongtinxe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addComponent(Btimkiem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                    .addComponent(Btra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))
                .addGap(0, 9, Short.MAX_VALUE))
        );
        thanhcongcuLayout.setVerticalGroup(
            thanhcongcuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(thanhcongcuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(Bthongtinxe, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Btra, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(202, 202, 202)
                .addGroup(thanhcongcuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bthoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7))
        );

        jPanel10.add(thanhcongcu, "card2");

        jPanel11.setBackground(new java.awt.Color(44, 62, 80));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 299, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 659, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel11, "card3");

        JPmc.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1005, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 657, Short.MAX_VALUE)
        );

        JPmc.add(jPanel2, "card3");

        JPtrb.setBackground(new java.awt.Color(243, 244, 246));

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));

        bang3.setBackground(new java.awt.Color(255, 255, 255));
        bang3.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        bang3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên người dùng", "Username", "Biển số xe", "Tình trạng xe", "Bãi đang thuê", "Loại xe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(bang3);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel7.setFont(new java.awt.Font("SansSerif", 0, 30)); // NOI18N
        jLabel7.setText("Thông tin người dùng");

        jTextField2.setBackground(new java.awt.Color(255, 255, 255));
        jTextField2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N

        jButton16.setBackground(new java.awt.Color(0, 0, 0));
        jButton16.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("Tìm kiếm");

        locnguoidung.setBackground(new java.awt.Color(255, 255, 255));
        locnguoidung.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lọc người dùng", "Lọc người dùng đã thuê", "Lọc người dùng chưa thuê", "Lọc người dùng trống" }));
        locnguoidung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locnguoidungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
                .addComponent(locnguoidung, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton16)
                .addGap(17, 17, 17))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(locnguoidung, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jButton13.setBackground(new java.awt.Color(40, 62, 82));
        jButton13.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Thêm");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(255, 255, 255));
        jButton15.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton15.setForeground(new java.awt.Color(0, 0, 0));
        jButton15.setText("Tất cả ");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        xoacus.setBackground(new java.awt.Color(239, 68, 68));
        xoacus.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        xoacus.setForeground(new java.awt.Color(255, 255, 255));
        xoacus.setText("Xóa");
        xoacus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoacusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPtrbLayout = new javax.swing.GroupLayout(JPtrb);
        JPtrb.setLayout(JPtrbLayout);
        JPtrbLayout.setHorizontalGroup(
            JPtrbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPtrbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(JPtrbLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(xoacus, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton15)
                .addGap(17, 17, 17))
        );
        JPtrbLayout.setVerticalGroup(
            JPtrbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPtrbLayout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JPtrbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(xoacus, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
                .addContainerGap())
        );

        JPmc.add(JPtrb, "card4");

        JPttb.setBackground(new java.awt.Color(243, 244, 246));

        bang2.setBackground(new java.awt.Color(255, 255, 255));
        bang2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bãi số", "Tình trạng", "Chủ xe", "Giá tiền", "Chế độ đỗ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(bang2);
        if (bang2.getColumnModel().getColumnCount() > 0) {
            bang2.getColumnModel().getColumn(2).setResizable(false);
        }

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(243, 244, 246)));

        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel6.setText("Tất cả bãi");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel7MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel8.setText("Bãi đã thuê");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel8MouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel9.setText("Bãi còn trống");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel10.setText("Thông tin bãi đỗ xe");
        jLabel10.setToolTipText("");

        jTextField1.setBackground(new java.awt.Color(255, 255, 255));
        jTextField1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        jButton1.setBackground(new java.awt.Color(0, 0, 0));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Tìm kiếm");

        loctype.setBackground(new java.awt.Color(255, 255, 255));
        loctype.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        loctype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lọc theo loại xe", "xeThoso", "xeGanmay", "xeOto", "xeChuyendung" }));
        loctype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loctypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loctype, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(36, 36, 36))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel10))
                    .addComponent(loctype, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Tổng số bãi:");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel13)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel11.setText("Danh sách bãi đỗ xe");
        jLabel11.setToolTipText("");

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel14.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Đang sử dụng:");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel14)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Còn trống:");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel15)
                .addContainerGap(70, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel15)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JPttbLayout = new javax.swing.GroupLayout(JPttb);
        JPttb.setLayout(JPttbLayout);
        JPttbLayout.setHorizontalGroup(
            JPttbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JPttbLayout.createSequentialGroup()
                .addGroup(JPttbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPttbLayout.createSequentialGroup()
                        .addGroup(JPttbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(JPttbLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(JPttbLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)))
                        .addGroup(JPttbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(JPttbLayout.createSequentialGroup()
                                .addGap(62, 62, 62)
                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(JPttbLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        JPttbLayout.setVerticalGroup(
            JPttbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPttbLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(JPttbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JPttbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        JPmc.add(JPttb, "card2");

        JPtkb.setBackground(new java.awt.Color(243, 244, 246));

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        bang1.setBackground(new java.awt.Color(255, 255, 255));
        bang1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        bang1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bãi số", "Tình trạng", "Chủ xe", "Giá tiền", "Chế độ đỗ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(bang1);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Quản lý bãi đỗ xe");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 30)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Danh sách bãi đỗ xe");

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 0));
        jButton4.setText("Khởi tạo bãi");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(40, 62, 82));
        jButton5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Thêm bãi");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(239, 68, 68));
        jButton9.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("Xóa");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPtkbLayout = new javax.swing.GroupLayout(JPtkb);
        JPtkb.setLayout(JPtkbLayout);
        JPtkbLayout.setHorizontalGroup(
            JPtkbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(JPtkbLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPtkbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(JPtkbLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(297, 297, 297)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addContainerGap())
        );
        JPtkbLayout.setVerticalGroup(
            JPtkbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPtkbLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(JPtkbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPtkbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        JPmc.add(JPtkb, "card6");

        jLabel16.setFont(new java.awt.Font("Helvetica Neue", 0, 36)); // NOI18N
        jLabel16.setText("Biểu đồ thống kê");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 733, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 62, Short.MAX_VALUE)
        );

        jPanel17.add(jPanel15, "card4");

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel17.setText("Tổng doanh thu trong tháng : ");

        jLabel18.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel17.add(jPanel20, "card3");

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel1.setText("Tổng doanh thu trong tuần:");

        jLabel12.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel17.add(jPanel19, "card2");

        Bdt.setText("Tháng");
        Bdt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BdtActionPerformed(evt);
            }
        });

        Bdn.setText("Tuần");
        Bdn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BdnActionPerformed(evt);
            }
        });

        Brv.setText("Ra ,vào");
        Brv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BrvActionPerformed(evt);
            }
        });

        jPanel18.setLayout(new java.awt.BorderLayout());
        jScrollPane4.setViewportView(jPanel18);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 733, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Bdt)
                .addGap(18, 18, 18)
                .addComponent(Bdn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Brv)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 993, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Bdt)
                            .addComponent(Bdn)
                            .addComponent(Brv))
                        .addGap(21, 21, 21)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 527, Short.MAX_VALUE))
        );

        JPmc.add(jPanel14, "card6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(301, Short.MAX_VALUE)
                .addComponent(JPmc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1008, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(JPmc, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BthongtinxeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BthongtinxeActionPerformed
        loadDulieulenBang2();
        CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "JPttb");
    }//GEN-LAST:event_BthongtinxeActionPerformed

    private void BtimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtimkiemActionPerformed
        loadDulieulenBang1();
        CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "JPtkb");
    }//GEN-LAST:event_BtimkiemActionPerformed

    private void BtraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtraActionPerformed
        loadDulieulenBang3();
        CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "JPtrb");
        
    }//GEN-LAST:event_BtraActionPerformed

    private void BthoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BthoatActionPerformed
        // TODO add your handling code here:
        
        new LogIn().setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_BthoatActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "JPtk");
        TimeChart timeChart = new TimeChart(jPanel18);
        CardLayout k = (CardLayout) jPanel17.getLayout();
        k.show(jPanel17, "trong");
        timeChart.createHourlyChart();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        khoitaoform khoitaodialog = new khoitaoform(admin.this, true);
        khoitaodialog.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        themSpot dialog = new themSpot(admin.this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        int chon = bang1.getSelectedRow();
            if (chon != -1) { 
                String IDstr = bang1.getValueAt(chon, 0).toString();
                long ID = Long.parseLong(IDstr);
                xoaParkingSpot("data_parkSpot.xml", ID);
                loadDulieulenBang1();
                JOptionPane.showMessageDialog(this, "Xóa thành công!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Xóa không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        themCus dialog = new themCus(admin.this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        loadDulieulenBang3();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void xoacusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoacusActionPerformed
         int chon = bang3.getSelectedRow(); 
                if (chon != -1) { 
                    String id = bang3.getValueAt(chon, 0).toString(); 
                    xoaCustomer("data_Customer.xml", id);
                    loadDulieulenBang3();
                    JOptionPane.showMessageDialog(this, "Xóa thành công!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Xóa không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
    }//GEN-LAST:event_xoacusActionPerformed

    private void locnguoidungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locnguoidungActionPerformed
        String luachon = (String) locnguoidung.getSelectedItem();
        if (luachon.equals("Lọc người dùng đã thuê")){
            loadLoclenBang3("true");
        }else if (luachon.equals("Lọc người dùng chưa thuê")){
            loadLoclenBang3("false");
        }else if (luachon.equals("Lọc người dùng trống")){
            loadLoclenBang3("null");
        }
    }//GEN-LAST:event_locnguoidungActionPerformed

    private void jPanel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel7MouseClicked
        loadLocTinhTrangBang2("true");
    }//GEN-LAST:event_jPanel7MouseClicked

    private void jPanel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MouseClicked
        loadLocTinhTrangBang2("false");
    }//GEN-LAST:event_jPanel8MouseClicked

    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        loadDulieulenBang2();
    }//GEN-LAST:event_jPanel3MouseClicked

    private void loctypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loctypeActionPerformed
        String luachon = (String) loctype.getSelectedItem();
        if (luachon.equals("xeThoso")){
            loadLocTypeBang2("xeThoso");
        }else if (luachon.equals("xeGanmay")){
            loadLocTypeBang2("xeGanmay");
        }else if (luachon.equals("xeOto")){
            loadLocTypeBang2("xeOto");
        }else if (luachon.equals("xeChuyendung")){
            loadLocTypeBang2("xeChuyendung");
        }
    }//GEN-LAST:event_loctypeActionPerformed

    private void BdtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BdtActionPerformed
        // TODO add your handling code here:
        WeeklyRevenueChart week = new WeeklyRevenueChart(jPanel18,jLabel18);
        CardLayout cl = (CardLayout) jPanel17.getLayout();
        cl.show(jPanel17, "thang");
        week.createWeeklyRevenueChart();
    }//GEN-LAST:event_BdtActionPerformed

    private void BdnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BdnActionPerformed
        // TODO add your handling code here:
        DailyRevenueChart day = new DailyRevenueChart(jPanel18,jLabel12);
        CardLayout cl = (CardLayout) jPanel17.getLayout();
        cl.show(jPanel17, "tuan");
        day.createDailyRevenueChart();
    }//GEN-LAST:event_BdnActionPerformed

    private void BrvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BrvActionPerformed
        // TODO add your handling code here:
        TimeChart timeChart = new TimeChart(jPanel18);
        CardLayout cl = (CardLayout) jPanel17.getLayout();
        cl.show(jPanel17, "trong");
        timeChart.createHourlyChart();
    }//GEN-LAST:event_BrvActionPerformed
//
//    /**
//     * @param args the command line arguments
//     */
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
//            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new admin().setVisible(true);
//               
//     
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bdn;
    private javax.swing.JButton Bdt;
    private javax.swing.JButton Brv;
    private javax.swing.JButton Bthoat;
    private javax.swing.JButton Bthongtinxe;
    private javax.swing.JButton Btimkiem;
    private javax.swing.JButton Btra;
    private javax.swing.JPanel JPmc;
    private javax.swing.JPanel JPtkb;
    private javax.swing.JPanel JPtrb;
    private javax.swing.JPanel JPttb;
    public javax.swing.JTable bang1;
    private javax.swing.JTable bang2;
    private javax.swing.JTable bang3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JComboBox<String> locnguoidung;
    private javax.swing.JComboBox<String> loctype;
    private javax.swing.JButton xoacus;
    // End of variables declaration//GEN-END:variables

    private boolean isNumeric(String input) {
       try {
            Double.parseDouble(input); 
            return true;
        } catch (NumberFormatException e) {
            return false;  
        }
    }

}
