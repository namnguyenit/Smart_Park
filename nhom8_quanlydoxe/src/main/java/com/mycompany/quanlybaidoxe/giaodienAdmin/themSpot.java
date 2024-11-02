/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package com.mycompany.quanlybaidoxe.giaodienAdmin;

import static com.mycompany.quanlybaidoxe.LogIn.spotType.xeChuyendung;
import static com.mycompany.quanlybaidoxe.LogIn.spotType.xeGanmay;
import static com.mycompany.quanlybaidoxe.LogIn.spotType.xeOto;
import static com.mycompany.quanlybaidoxe.LogIn.spotType.xeThoso;
import static com.mycompany.quanlybaidoxe.timkiembai.Timkiemtudong.isNumeric;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

/**
 *
 * @author trung
 */
public class themSpot extends javax.swing.JDialog {

    /**
     * Creates new form themSpot
     */
    public themSpot(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        slThem = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tienThem = new javax.swing.JTextField();
        luaChon = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thêm bãi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SansSerif", 1, 24))); // NOI18N

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel1.setText("Nhập số lượng bãi cần thêm");

        slThem.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        slThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slThemActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setText("Số tiền");

        tienThem.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        tienThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tienThemActionPerformed(evt);
            }
        });

        luaChon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "xeThoSo", "xeGanMay", "xeOto", "xeChuyenDung" }));

        jButton1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton1.setText("Thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jButton2.setText("Đóng");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(slThem))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(luaChon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tienThem, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(53, 53, 53))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(202, 202, 202))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(slThem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(luaChon, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)))
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tienThem, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void slThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_slThemActionPerformed

    private void tienThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tienThemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tienThemActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String input = slThem.getText();
        String chon = String.valueOf(luaChon.getSelectedItem());
        admin mainFrame = (admin) getParent();
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
                    mainFrame.loadDulieulenBang1();
                    JOptionPane.showMessageDialog(this, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
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
                    mainFrame.loadDulieulenBang1();
                    JOptionPane.showMessageDialog(this, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
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
                    mainFrame.loadDulieulenBang1();
                    JOptionPane.showMessageDialog(this, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
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
                    mainFrame.loadDulieulenBang1();
                    JOptionPane.showMessageDialog(this, "Thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                }
            }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(this, "Thêm không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Thêm không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(themSpot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(themSpot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(themSpot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(themSpot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                themSpot dialog = new themSpot(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> luaChon;
    private javax.swing.JTextField slThem;
    private javax.swing.JTextField tienThem;
    // End of variables declaration//GEN-END:variables
}
