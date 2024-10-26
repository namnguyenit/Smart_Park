package com.mycompany.quanlybaidoxe.LogIn;

import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import com.mycompany.quanlybaidoxe.quanlydoxe.Giaodienchinh;
import com.mycompany.quanlybaidoxe.quanlydoxe.User;
import com.mycompany.quanlybaidoxe.giaodienAdmin.admin;

/**
 *
 * @author trung
 */
public class LogIn extends javax.swing.JFrame {
    private String luudangnhap = "";
    private String luumk ="";

    public LogIn() {
        initComponents();
        setFrameIcon();
        jPanel3.add(LogIn,"jPanel4");
        jPanel3.add(SignIn,"jPanel6");
        CardLayout  cl = (CardLayout) jPanel3.getLayout();
        cl.show(jPanel3,"empty");
    }

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
     private void showWarningDialog() {
        JOptionPane.showMessageDialog(this, 
                                      "Cảnh báo! Mật khâu không trùng khớp.", 
                                      "Cảnh báo", 
                                      JOptionPane.WARNING_MESSAGE);
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        SignIn = new javax.swing.JPanel();
        jPanel2 = new BackgroundPanel("/anh/panelsignIn.png");
        jButton4 = new javax.swing.JButton();
        khungdangky = new BackgroundPanel("/anh/dangnhap.png");
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        taodangnhap = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        taodangnhap1 = new javax.swing.JTextField();
        taomk = new javax.swing.JPasswordField();
        nhaplaimk = new javax.swing.JPasswordField();
        showPass1 = new javax.swing.JToggleButton();
        showPass2 = new javax.swing.JToggleButton();
        LogIn = new javax.swing.JPanel();
        Paneldangnhap = new BackgroundPanel("/anh/panellogIn.png");
        jButton1 = new javax.swing.JButton();
        khungdangnhap = new BackgroundPanel("/anh/dangnhap.png");
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tendangnhap = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        mk = new javax.swing.JPasswordField();
        showPass = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Smart Parking : Log In");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);
        setLocation(new java.awt.Point(120, 120));
        setLocationByPlatform(true);

        jPanel3.setLayout(new java.awt.CardLayout());

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton4.setText("Đăng nhập");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jButton4)
                .addContainerGap(118, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(58, 58, 58))
        );

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel4.setText("ĐĂNG KÝ");

        jLabel5.setText("Tên đăng nhâp:");

        taodangnhap.setBackground(new java.awt.Color(255, 255, 255));
        taodangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taodangnhapActionPerformed(evt);
            }
        });

        jLabel6.setText("Mật khẩu:");

        jLabel7.setText("Nhập lại mật khẩu:");

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("Đăng ký");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel8.setText("Tên người dùng:");

        taodangnhap1.setBackground(new java.awt.Color(255, 255, 255));
        taodangnhap1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                taodangnhap1ActionPerformed(evt);
            }
        });

        showPass1.setText("jToggleButton1");
        showPass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPass1ActionPerformed(evt);
            }
        });

        showPass2.setText("jToggleButton1");
        showPass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPass2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout khungdangkyLayout = new javax.swing.GroupLayout(khungdangky);
        khungdangky.setLayout(khungdangkyLayout);
        khungdangkyLayout.setHorizontalGroup(
            khungdangkyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, khungdangkyLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(92, 92, 92))
            .addGroup(khungdangkyLayout.createSequentialGroup()
                .addGroup(khungdangkyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nhaplaimk, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(taomk, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(khungdangkyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(khungdangkyLayout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addGroup(khungdangkyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(taodangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(khungdangkyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(taodangnhap1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(khungdangkyLayout.createSequentialGroup()
                            .addGap(123, 123, 123)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(khungdangkyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showPass1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showPass2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        khungdangkyLayout.setVerticalGroup(
            khungdangkyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(khungdangkyLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(taodangnhap1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(taodangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(2, 2, 2)
                .addGroup(khungdangkyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(taomk, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showPass1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(khungdangkyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nhaplaimk, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showPass2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout SignInLayout = new javax.swing.GroupLayout(SignIn);
        SignIn.setLayout(SignInLayout);
        SignInLayout.setHorizontalGroup(
            SignInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SignInLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(khungdangky, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
        );
        SignInLayout.setVerticalGroup(
            SignInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(SignInLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(khungdangky, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jPanel3.add(SignIn, "card3");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 0));
        jButton1.setText("Đăng ký");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PaneldangnhapLayout = new javax.swing.GroupLayout(Paneldangnhap);
        Paneldangnhap.setLayout(PaneldangnhapLayout);
        PaneldangnhapLayout.setHorizontalGroup(
            PaneldangnhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PaneldangnhapLayout.createSequentialGroup()
                .addContainerGap(127, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
        );
        PaneldangnhapLayout.setVerticalGroup(
            PaneldangnhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PaneldangnhapLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(50, 50, 50))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("ĐĂNG NHẬP");

        jLabel2.setText("Tên đăng nhâp:");

        tendangnhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tendangnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tendangnhapActionPerformed(evt);
            }
        });

        jLabel3.setText("Mật khẩu:");

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Đăng nhập");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        mk.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mkActionPerformed(evt);
            }
        });

        showPass.setText("jToggleButton1");
        showPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPassActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout khungdangnhapLayout = new javax.swing.GroupLayout(khungdangnhap);
        khungdangnhap.setLayout(khungdangnhapLayout);
        khungdangnhapLayout.setHorizontalGroup(
            khungdangnhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(khungdangnhapLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(khungdangnhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tendangnhap)
                    .addComponent(mk))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(showPass, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, khungdangnhapLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(80, 80, 80))
        );
        khungdangnhapLayout.setVerticalGroup(
            khungdangnhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(khungdangnhapLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tendangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(khungdangnhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mk, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(showPass))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout LogInLayout = new javax.swing.GroupLayout(LogIn);
        LogIn.setLayout(LogInLayout);
        LogInLayout.setHorizontalGroup(
            LogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, LogInLayout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(khungdangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addComponent(Paneldangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        LogInLayout.setVerticalGroup(
            LogInLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Paneldangnhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(LogInLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(khungdangnhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );

        jPanel3.add(LogIn, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        CardLayout  cl = (CardLayout) jPanel3.getLayout();
        cl.show(jPanel3,"jPanel6");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        CardLayout  cl = (CardLayout) jPanel3.getLayout();
        cl.show(jPanel3,"jPanel4");
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        if(taodangnhap.getText().isEmpty()||taodangnhap.getText().isEmpty()||taomk.getText().isEmpty()){
            canhbaodangky dialog = new canhbaodangky(LogIn.this,true);
            dialog.setVisible(true);
        }else{
            CustomerXMLReader reader = new CustomerXMLReader("data_Customer.xml");
            if (reader.checkTrung(taodangnhap.getText())==1){
                if(taomk.getText().equals(nhaplaimk.getText())){
                    try{
                        Customer ct = new Customer(taodangnhap1.getText(),taodangnhap.getText(),taomk.getText());
                        convertXML.addCustomerToXML(ct, "data_Customer.xml");
                        thanhcong dialog = new thanhcong(LogIn.this,true);
                        dialog.setVisible(true);
                    }catch (NoSuchAlgorithmException e) {
                        System.err.println("Error: Unable to hash the password. " + e.getMessage());
                    } catch (ParserConfigurationException ex) {
                        Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (TransformerException ex) {
                        Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }else{
                    canhbaomoi dialog = new canhbaomoi(LogIn.this, true);
                    dialog.setVisible(true); // Hiển thị JDialog
                }
            }else{
                canhbaousername dialog = new canhbaousername(LogIn.this,true);
                dialog.setVisible(true);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void taodangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taodangnhapActionPerformed

    }//GEN-LAST:event_taodangnhapActionPerformed

    private void mkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mkActionPerformed

    private void tendangnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tendangnhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tendangnhapActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        luudangnhap = tendangnhap.getText();
        luumk = mk.getText();
        CustomerXMLReader reader = new CustomerXMLReader("data_Customer.xml");
        int user = reader.checkUser(luudangnhap, luumk);
        switch(user){
                case 0:
                    JOptionPane.showMessageDialog(LogIn, "Đăng nhập không thành công");
                    break;
                case 1:
                    new Giaodienchinh().setVisible(true);
                    this.dispose();
                    
                    break;
                case 2:
                    new admin().setVisible(true);
                    this.dispose();
                    break;
                    
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void showPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPassActionPerformed
       if (showPass.isSelected()) {
                    mk.setEchoChar((char) 0);
                    showPass.setText("Ẩn");
                } else {
                    mk.setEchoChar('*');  
                    showPass.setText("Hiện");
                }
    }//GEN-LAST:event_showPassActionPerformed

    private void taodangnhap1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_taodangnhap1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_taodangnhap1ActionPerformed

    private void showPass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPass1ActionPerformed
        if (showPass1.isSelected()) {
                    taomk.setEchoChar((char) 0);
                    showPass1.setText("Ẩn");
                } else {
                    taomk.setEchoChar('*');  
                    showPass1.setText("Hiện");
                }
    }//GEN-LAST:event_showPass1ActionPerformed

    private void showPass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPass2ActionPerformed
        if (showPass2.isSelected()) {
                    nhaplaimk.setEchoChar((char) 0);
                    showPass2.setText("Ẩn");
                } else {
                    nhaplaimk.setEchoChar('*');  
                    showPass2.setText("Hiện");
                }
    }//GEN-LAST:event_showPass2ActionPerformed

    public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    jButton3.doClick(); // Giả lập nhấn nút
                }
            }
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
               
     
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel LogIn;
    private javax.swing.JPanel Paneldangnhap;
    private javax.swing.JPanel SignIn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel khungdangky;
    private javax.swing.JPanel khungdangnhap;
    private javax.swing.JPasswordField mk;
    private javax.swing.JPasswordField nhaplaimk;
    private javax.swing.JToggleButton showPass;
    private javax.swing.JToggleButton showPass1;
    private javax.swing.JToggleButton showPass2;
    private javax.swing.JTextField taodangnhap;
    private javax.swing.JTextField taodangnhap1;
    private javax.swing.JPasswordField taomk;
    private javax.swing.JTextField tendangnhap;
    // End of variables declaration//GEN-END:variables
}
