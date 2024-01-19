/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DomainModels.MauSac;
import Service.MauSacService;
import Utilities.DBConnection;
import ViewModel.MauSacModel;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author ADMIN
 */
public class Form_MauSac extends javax.swing.JFrame {

    /**
     * Creates new form Form_MauSac
     */
    MauSacService mauSacService = new MauSacService();
    MauSacModel ms;
    long count , soTrang , trang = 1;
    Connection cn;
    Statement st;
    ResultSet rs;
    
    public Form_MauSac() {
        initComponents();
        setLocationRelativeTo(null);
        titleTable();
        countDB();
        if (count % 5 == 0) {
            soTrang = count / 5;
        } else {
            soTrang = count / 5 + 1;
        }
        loadData(1);
        lbSoTrang.setText("1/" + soTrang);
        lbTrang.setText("1");
    }

    public void titleTable(){
        ms = new MauSacModel();
        tblDanhSach.setModel(ms);
        tblDanhSach.setShowHorizontalLines(true);
        tblDanhSach.setShowVerticalLines(true);
    }
    
    public void countDB(){
        try {
            String query = "Select count(*) from MAUSAC";
            cn = DBConnection.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {                
                count = rs.getLong(1);
            }
            rs.close();
            st.close();
            cn.close();
        } catch (Exception ex) {
            Logger.getLogger(Form_MauSac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadData(long trang){
        titleTable();
        ms.getDataVector().removeAllElements();
        try {
            String query = "Select top 5 * from MAUSAC where MauSac not in (Select top " + (trang * 5 - 5) + " MauSac from MAUSAC)";
            cn = DBConnection.getConnection();
            st = cn.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {                
                Vector v = new Vector();
                String Ma = rs.getString(2);
                String mauSac = rs.getString(3);
                v.add(Ma);
                v.add(mauSac);
                ms.addRow(v);
            }
            rs.close();
            st.close();
            cn.close();
        } catch (Exception ex) {
            Logger.getLogger(Form_MauSac.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtTenMauSac = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnCapNhat = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        btLonMax = new javax.swing.JButton();
        btNhoMax = new javax.swing.JButton();
        txtMaMauSac = new javax.swing.JTextField();
        BtNho = new javax.swing.JButton();
        btLon = new javax.swing.JButton();
        lbTrang = new javax.swing.JLabel();
        lbSoTrang = new javax.swing.JLabel();
        lbClose = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));

        jLabel17.setText("Mã Màu Sắc");

        jLabel18.setText("Tên Màu Sắc");

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Them.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Sua.png"))); // NOI18N
        btnCapNhat.setText("Cập Nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Màu Sắc", "Tên Màu Sắc"
            }
        ));
        tblDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDanhSach);

        btLonMax.setText(">>");
        btLonMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLonMaxActionPerformed(evt);
            }
        });

        btNhoMax.setText("<<");
        btNhoMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNhoMaxActionPerformed(evt);
            }
        });

        BtNho.setText("<");
        BtNho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtNhoActionPerformed(evt);
            }
        });

        btLon.setText(">");
        btLon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLonActionPerformed(evt);
            }
        });

        lbTrang.setText("jLabel1");

        lbSoTrang.setText("jLabel2");

        lbClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-back-40.png"))); // NOI18N
        lbClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCloseMouseClicked(evt);
            }
        });

        btnReset.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-clear-16.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(btnCapNhat)
                        .addGap(45, 45, 45)
                        .addComponent(btnReset)
                        .addGap(53, 53, 53))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(lbClose)
                                        .addGap(136, 136, 136))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel18))
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtMaMauSac, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                                    .addComponent(txtTenMauSac))
                                .addGap(122, 122, 122)))))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(btNhoMax)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BtNho, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTrang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btLon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btLonMax)
                .addGap(18, 18, 18)
                .addComponent(lbSoTrang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbClose)))
                .addGap(34, 34, 34)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18))
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNhoMax)
                    .addComponent(btLonMax)
                    .addComponent(btLon)
                    .addComponent(BtNho)
                    .addComponent(lbTrang)
                    .addComponent(lbSoTrang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtNhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtNhoActionPerformed
        if (trang > 1) {
            trang--;
            loadData(trang);
            lbTrang.setText("" + soTrang);
            lbSoTrang.setText(trang + "/" + soTrang);
        }
    }//GEN-LAST:event_BtNhoActionPerformed

    private void btLonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLonActionPerformed
        if (trang < soTrang) {
            trang++;
            loadData(trang);
            lbTrang.setText("" + trang);
            lbSoTrang.setText(trang + "/" + soTrang);
        }
    }//GEN-LAST:event_btLonActionPerformed

    private void btNhoMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNhoMaxActionPerformed
        trang = 1;
        loadData(trang);
        lbTrang.setText("1");
        lbSoTrang.setText(trang + "/" + soTrang);
    }//GEN-LAST:event_btNhoMaxActionPerformed

    private void btLonMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLonMaxActionPerformed
        trang = soTrang;
        loadData(trang);
        lbTrang.setText("1");
        lbSoTrang.setText(soTrang + "/" + soTrang);
    }//GEN-LAST:event_btLonMaxActionPerformed

    private void lbCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseMouseClicked
        this.dispose();
    }//GEN-LAST:event_lbCloseMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (txtMaMauSac.getText().trim().equals("") || txtTenMauSac.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Moi ban nhap day du thong tin.");
            return;
        }
        try {
            String ma = txtMaMauSac.getText();
            String ten = txtTenMauSac.getText();
            MauSac mauSac = new MauSac(0, ma, ten, WIDTH);
            mauSacService.insert(mauSac);
            loadData(trang);
            JOptionPane.showMessageDialog(this, "Add thanh cong.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Add that bai.");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        if (txtMaMauSac.getText().trim().equals("") || txtTenMauSac.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Moi ban chon ban ghi.");
            return;
        }
        try {
            String ma = txtMaMauSac.getText();
            String ten = txtTenMauSac.getText();
            MauSac mauSac = new MauSac(0, ma, ten, WIDTH);
            mauSacService.update(ma, mauSac);
            loadData(trang);
            JOptionPane.showMessageDialog(this, "Cap nhat thanh cong.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Cap nhat that bai.");
        }
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
         txtMaMauSac.setText("");
        txtTenMauSac.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void tblDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachMouseClicked
        int index = tblDanhSach.getSelectedRow();
        
        String ma = (String) tblDanhSach.getValueAt(index, 0);
        String ten = (String) tblDanhSach.getValueAt(index, 1);
        
        txtMaMauSac.setText(ma);
        txtTenMauSac.setText(ten);
    }//GEN-LAST:event_tblDanhSachMouseClicked

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
//            java.util.logging.Logger.getLogger(Form_MauSac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Form_MauSac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Form_MauSac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Form_MauSac.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Form_MauSac().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtNho;
    private javax.swing.JButton btLon;
    private javax.swing.JButton btLonMax;
    private javax.swing.JButton btNhoMax;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThem;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbClose;
    private javax.swing.JLabel lbSoTrang;
    private javax.swing.JLabel lbTrang;
    private javax.swing.JTable tblDanhSach;
    private javax.swing.JTextField txtMaMauSac;
    private javax.swing.JTextField txtTenMauSac;
    // End of variables declaration//GEN-END:variables
}
