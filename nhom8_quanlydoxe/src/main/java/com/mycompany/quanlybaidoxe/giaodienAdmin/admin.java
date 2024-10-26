package com.mycompany.quanlybaidoxe.giaodienAdmin;

import com.mycompany.quanlybaidoxe.LogIn.Customer;
import com.mycompany.quanlybaidoxe.LogIn.LogIn;
import static com.mycompany.quanlybaidoxe.LogIn.spotType.*;
import com.mycompany.quanlybaidoxe.giaodienAdmin.CustomerFilter;
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
import java.util.ArrayList;
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
     
     
     
     
    
     
    
    
    
    //nhập loại xe và biển số
    private String nt;//loại xe
    private String nb;//biển số
    
    //dữ liệu tài khoản 
    private String tnd="";
    private String bsx="";
    private String tkdn="";
    private int sl=0;
    
    //
    
    
    /**
     * Creates new form Giaodienchinh
     */
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        
        JPmc.add(JPttb, "JPttb");
        JPmc.add(JPtrb,"JPtrb");
        JPmc.add(JPtkb,"JPtkb");
        
        // Hiển thị panel trống mặc định
        CardLayout cl = (CardLayout) JPmc.getLayout();
        cl.show(JPmc, "empty"); 
        
        jPanel5.add(nhapThem,"nhapThem");
        jPanel5.add(nhapXoa,"nhapXoa");
        CardLayout cl1 = (CardLayout) jPanel5.getLayout();
        cl1.show(jPanel5, "empty");
        
        
        jPanel8.add(loc,"loc");
        jPanel8.add(xoaCus,"xoaCus");
        CardLayout cl2 = (CardLayout) jPanel8.getLayout();
        cl2.show(jPanel8, "empty");
        
        
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.JPanel thanhcongcu = new BackgroundPanel("/quanlydoxe_img/n1.png");
        Bthongtinxe = new javax.swing.JButton();
        Btimkiem = new javax.swing.JButton();
        Btra = new javax.swing.JButton();
        Bthoat = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        JPmc = new BackgroundPanel("/quanlydoxe_img/Wellcom.png");
        javax.swing.JPanel jPanel2 = new BackgroundPanel("/quanlydoxe_img/Wellcom.png");
        JPtrb = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        bang3 = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        loc = new javax.swing.JPanel();
        locThue = new javax.swing.JButton();
        locChuaThue = new javax.swing.JButton();
        locTrong = new javax.swing.JButton();
        xoaCus = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        IDxoa = new javax.swing.JTextField();
        xoacus = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        JPttb = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bang2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        JPtkb = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        bang1 = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        nhapThem = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        slThem = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tienThem = new javax.swing.JTextField();
        luaChon = new javax.swing.JComboBox<>();
        nhapXoa = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        textXoa = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Smart Packing");
        setBackground(new java.awt.Color(255, 255, 255));

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
                .addGroup(thanhcongcuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Bthongtinxe, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Btra, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, thanhcongcuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(thanhcongcuLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(thanhcongcuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(thanhcongcuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Bthoat, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(thanhcongcuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(thanhcongcuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bthoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(7, 7, 7))
        );

        JPmc.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 538, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 542, Short.MAX_VALUE)
        );

        JPmc.add(jPanel2, "card3");

        jLabel7.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel7.setText("Thông tin người dùng");

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

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jPanel8.setLayout(new java.awt.CardLayout());

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 516, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );

        jPanel8.add(jPanel9, "card2");

        loc.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        locThue.setText("Lọc người dùng đã thuê");
        locThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locThueActionPerformed(evt);
            }
        });

        locChuaThue.setText("Lọc người dùng chưa thuê");
        locChuaThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locChuaThueActionPerformed(evt);
            }
        });

        locTrong.setText("Lọc người dùng trống");
        locTrong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                locTrongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout locLayout = new javax.swing.GroupLayout(loc);
        loc.setLayout(locLayout);
        locLayout.setHorizontalGroup(
            locLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(locThue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(locChuaThue)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(locTrong)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        locLayout.setVerticalGroup(
            locLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(locLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(locLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(locThue)
                    .addComponent(locChuaThue)
                    .addComponent(locTrong))
                .addContainerGap(50, Short.MAX_VALUE))
        );

        jPanel8.add(loc, "card3");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Nhập ID người dùng cần xóa:");

        IDxoa.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        xoacus.setText("Xóa");
        xoacus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                xoacusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout xoaCusLayout = new javax.swing.GroupLayout(xoaCus);
        xoaCus.setLayout(xoaCusLayout);
        xoaCusLayout.setHorizontalGroup(
            xoaCusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xoaCusLayout.createSequentialGroup()
                .addGroup(xoaCusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(xoaCusLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(xoaCusLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(IDxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, xoaCusLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(xoacus)
                .addGap(53, 53, 53))
        );
        xoaCusLayout.setVerticalGroup(
            xoaCusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(xoaCusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(IDxoa, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(xoacus)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel8.add(xoaCus, "card4");

        jButton1.setText("Lọc người dùng");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton12.setText("Sửa");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setText("Thêm");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setText("Xóa");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setText("Tất cả ");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setText("Tìm kiếm");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton16)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton12)
                    .addComponent(jButton13)
                    .addComponent(jButton14)
                    .addComponent(jButton15)
                    .addComponent(jButton16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout JPtrbLayout = new javax.swing.GroupLayout(JPtrb);
        JPtrb.setLayout(JPtrbLayout);
        JPtrbLayout.setHorizontalGroup(
            JPtrbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPtrbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(JPtrbLayout.createSequentialGroup()
                .addGroup(JPtrbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        JPtrbLayout.setVerticalGroup(
            JPtrbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPtrbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                .addContainerGap())
        );

        JPmc.add(JPtrb, "card4");

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton3.setText("Tìm kiếm");

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chế độ lọc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton6.setText("Bãi đã thuê");

        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jButton7.setText("Bãi còn trống");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton8.setText("Tất cả bãi");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(9, 9, 9))
        );

        javax.swing.GroupLayout JPttbLayout = new javax.swing.GroupLayout(JPttb);
        JPttb.setLayout(JPttbLayout);
        JPttbLayout.setHorizontalGroup(
            JPttbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPttbLayout.createSequentialGroup()
                .addGroup(JPttbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPttbLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE))
                .addContainerGap())
        );
        JPttbLayout.setVerticalGroup(
            JPttbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPttbLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        JPmc.add(JPttb, "card2");

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

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton4.setText("Khởi tạo bãi");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton5.setText("Thêm bãi");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton9.setText("Xóa");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jPanel5.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel6, "card4");

        nhapThem.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("Nhập số bãi cần thêm:");

        slThem.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jButton10.setText("Thêm");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel6.setText("Số tiền");

        tienThem.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        luaChon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "xeThoSo", "xeGanMay", "xeOto", "xeChuyenDung" }));

        javax.swing.GroupLayout nhapThemLayout = new javax.swing.GroupLayout(nhapThem);
        nhapThem.setLayout(nhapThemLayout);
        nhapThemLayout.setHorizontalGroup(
            nhapThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nhapThemLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton10)
                .addGap(27, 27, 27))
            .addGroup(nhapThemLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(nhapThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slThem, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(nhapThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tienThem, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(nhapThemLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(45, 45, 45)
                        .addComponent(luaChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        nhapThemLayout.setVerticalGroup(
            nhapThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nhapThemLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nhapThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(nhapThemLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(slThem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(nhapThemLayout.createSequentialGroup()
                        .addGroup(nhapThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(luaChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tienThem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton10)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel5.add(nhapThem, "card3");

        nhapXoa.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Nhập ID bãi cần xóa:");

        textXoa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jButton11.setText("Xóa");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout nhapXoaLayout = new javax.swing.GroupLayout(nhapXoa);
        nhapXoa.setLayout(nhapXoaLayout);
        nhapXoaLayout.setHorizontalGroup(
            nhapXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nhapXoaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton11)
                .addGap(54, 54, 54))
            .addGroup(nhapXoaLayout.createSequentialGroup()
                .addGroup(nhapXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nhapXoaLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(textXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(nhapXoaLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel5)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        nhapXoaLayout.setVerticalGroup(
            nhapXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nhapXoaLayout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(textXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton11)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel5.add(nhapXoa, "card2");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jButton4)
                .addGap(72, 72, 72)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout JPtkbLayout = new javax.swing.GroupLayout(JPtkb);
        JPtkb.setLayout(JPtkbLayout);
        JPtkbLayout.setHorizontalGroup(
            JPtkbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPtkbLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(JPtkbLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPtkbLayout.setVerticalGroup(
            JPtkbLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPtkbLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        JPmc.add(JPtkb, "card6");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(thanhcongcu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPmc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(thanhcongcu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(JPmc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        khoitaoform khoitaodialog = new khoitaoform(admin.this, true);
        khoitaodialog.setVisible(true);
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        String input = slThem.getText();
        String chon = String.valueOf(luaChon.getSelectedItem());
        if(isNumeric(input)){
            try{
                if (chon.equals("xeThoSo")){
                    long SL = Long.parseLong(input);
                    for (long i=1;i<=SL;i++){
                        parkingSpot pkS = new parkingSpot();
                        long gia = Long.parseLong(tienThem.getText());
                        pkS.setGia(gia);
                        try {
                            convertSpotXML.addParkingSpotToXML(pkS,xeThoso, "data_parkSpot.xml");
                        } catch (ParserConfigurationException ex) {
                            Logger.getLogger(khoitaoform.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (TransformerException ex) {
                            Logger.getLogger(khoitaoform.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    loadDulieulenBang1();
                    themThanhCong();
                }else if(chon.equals("xeGanMay")){
                    long SL = Long.parseLong(input);
                    for (long i=1;i<=SL;i++){
                        parkingSpot pkS = new parkingSpot();
                        long gia = Long.parseLong(tienThem.getText());
                        pkS.setGia(gia);
                        try {
                            convertSpotXML.addParkingSpotToXML(pkS,xeGanmay, "data_parkSpot.xml");
                        } catch (ParserConfigurationException ex) {
                            Logger.getLogger(khoitaoform.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (TransformerException ex) {
                            Logger.getLogger(khoitaoform.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    loadDulieulenBang1();
                    themThanhCong();
                }else if(chon.equals("xeOto")){
                    long SL = Long.parseLong(input);
                    for (long i=1;i<=SL;i++){
                        parkingSpot pkS = new parkingSpot();
                        long gia = Long.parseLong(tienThem.getText());
                        pkS.setGia(gia);
                        try {
                            convertSpotXML.addParkingSpotToXML(pkS,xeOto, "data_parkSpot.xml");
                        } catch (ParserConfigurationException ex) {
                            Logger.getLogger(khoitaoform.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (TransformerException ex) {
                            Logger.getLogger(khoitaoform.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    loadDulieulenBang1();
                    themThanhCong();
                }else if(chon.equals("xeChuyenDung")){
                    long SL = Long.parseLong(input);
                    for (long i=1;i<=SL;i++){
                        parkingSpot pkS = new parkingSpot();
                        long gia = Long.parseLong(tienThem.getText());
                        pkS.setGia(gia);
                        try {
                            convertSpotXML.addParkingSpotToXML(pkS,xeChuyendung, "data_parkSpot.xml");
                        } catch (ParserConfigurationException ex) {
                            Logger.getLogger(khoitaoform.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (TransformerException ex) {
                            Logger.getLogger(khoitaoform.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    loadDulieulenBang1();
                    themThanhCong();
                }
            }catch(NumberFormatException e){
                
            }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        CardLayout cl = (CardLayout) jPanel5.getLayout();
        cl.show(jPanel5, "nhapThem");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        CardLayout cl = (CardLayout) jPanel5.getLayout();
        cl.show(jPanel5, "nhapXoa");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        String IDstr = textXoa.getText();
        if (isNumeric(IDstr)){
            long ID = Long.parseLong(IDstr);
            if ((ID>=1) && (parkingSpot.loadNextID()> ID)){
                xoaParkingSpot("data_parkSpot.xml", ID);
                loadDulieulenBang1();
            }else{
                JOptionPane.showMessageDialog(this, "Xóa không thành công!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        
            }
        }else{
            JOptionPane.showMessageDialog(this, "Xóa không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CardLayout cl2 = (CardLayout) jPanel8.getLayout();
        cl2.show(jPanel8, "loc");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton13ActionPerformed

    private void locThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locThueActionPerformed
        loadLoclenBang3("true");
    }//GEN-LAST:event_locThueActionPerformed

    private void locChuaThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locChuaThueActionPerformed
        loadLoclenBang3("false");
    }//GEN-LAST:event_locChuaThueActionPerformed

    private void locTrongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_locTrongActionPerformed
       loadLoclenBang3("null");
    }//GEN-LAST:event_locTrongActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        loadDulieulenBang3();
    }//GEN-LAST:event_jButton15ActionPerformed

    private void xoacusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_xoacusActionPerformed
        String IDxoaStr = IDxoa.getText();
        if (checkCusID("data_Customer.xml", IDxoaStr)==1){
            xoaCustomer("data_Customer.xml", IDxoaStr);
            loadDulieulenBang3();
            JOptionPane.showMessageDialog(this, "Xóa thành công!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "Xóa không thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);         
        } 
    }//GEN-LAST:event_xoacusActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        CardLayout cl2 = (CardLayout) jPanel8.getLayout();
        cl2.show(jPanel8, "xoaCus");
    }//GEN-LAST:event_jButton14ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bthoat;
    private javax.swing.JButton Bthongtinxe;
    private javax.swing.JButton Btimkiem;
    private javax.swing.JButton Btra;
    private javax.swing.JTextField IDxoa;
    private javax.swing.JPanel JPmc;
    private javax.swing.JPanel JPtkb;
    private javax.swing.JPanel JPtrb;
    private javax.swing.JPanel JPttb;
    public javax.swing.JTable bang1;
    private javax.swing.JTable bang2;
    private javax.swing.JTable bang3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel loc;
    private javax.swing.JButton locChuaThue;
    private javax.swing.JButton locThue;
    private javax.swing.JButton locTrong;
    private javax.swing.JComboBox<String> luaChon;
    private javax.swing.JPanel nhapThem;
    private javax.swing.JPanel nhapXoa;
    private javax.swing.JTextField slThem;
    private javax.swing.JTextField textXoa;
    private javax.swing.JTextField tienThem;
    private javax.swing.JPanel xoaCus;
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
