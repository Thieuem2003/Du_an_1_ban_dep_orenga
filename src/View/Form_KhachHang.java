/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DomainModels.KhachHang;
import Interface.KhachHangServiceIplm;
import Service.KhachHangService;
import Utilities.DBConnection;
import ViewModel.KhachHangModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author asus
 */
public class Form_KhachHang extends javax.swing.JPanel {

    KhachHangModel khm;
    long count, soTrang, trang = 1;

    private KhachHangServiceIplm service = new KhachHangService();
    ArrayList<KhachHang> listKh = new ArrayList<>();

    public Form_KhachHang() {
        initComponents();

        titleTable();
        countDB();
        if (count % 5 == 0) {
            soTrang = count / 5;
        } else {
            soTrang = count / 5 + 1;
        }
        loadData(1);
        lbsoTrang.setText("1/" + soTrang);
        lbtrang.setText("1");
//        loadTable();
    }

    public void titleTable() {
        khm = new KhachHangModel();
        tblKhachHang.setModel(khm);
        tblKhachHang.setShowHorizontalLines(true);
        tblKhachHang.setShowVerticalLines(true);
    }

    public void countDB() {
        try {
            String query = "Select COUNT(*) from KHACHHANG";
            Connection cn = DBConnection.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                count = rs.getLong(1);
            }
            rs.close();
            st.close();
            cn.close();
        } catch (Exception ex) {
            Logger.getLogger(Form_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadData(long trang) {
        titleTable();
        khm.getDataVector().removeAllElements();
        try {
            String query = "Select top 5 * from KHACHHANG where Ten not in ("
                    + "Select top " + (trang * 5 - 5) + " Ten from KHACHHANG)";
            Connection cn = DBConnection.getConnection();
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Vector v = new Vector();

                String Ma = rs.getString(2);
                String Ten = rs.getString(3);
                Date ngaySinh = rs.getDate(4);
                Integer gioiTinh = rs.getInt(5);
                
                String gt;
                if (gioiTinh == 1) {
                    gt = "Nam";
                } else {
                    gt = "Nữ";
                }
                String sdt = rs.getString(6);
                String email = rs.getString(7);
                String diaChi = rs.getString(8);
                Integer trangThai = rs.getInt(10);
                String tt;

                if (trangThai == 1) {
                    tt = "HD";
                } else {
                    tt = "Nhd";
                }
                v.add(Ma);
                v.add(Ten);
                v.add(ngaySinh);
                v.add(gt);
                v.add(sdt);
                v.add(email);
                v.add(diaChi);
                v.add(tt);
                khm.addRow(v);
            }
            rs.close();
            st.close();
            cn.close();
        } catch (Exception ex) {
            Logger.getLogger(Form_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

////  private void loadTable() {
////        DefaultTableModel model = (DefaultTableModel) tblKhachHang.getModel();
////        model.setRowCount(0);
////        ArrayList<KhachHang> kh = service.getList();
////        for (KhachHang k :kh ) {
////            Object[] row = {k.getMa(), k.getTen(),  k.getDiaChi(), k.getSdt(),
//    k.getNgaySinh(), k.getEmail(),k.getGioiTinh(k.getGioiTinh()),
//            k.getTrangThai() == 1 ? "HD": "Nhd"};
////            model.addRow(row);
////        }
////        
////    }
    // check sdt
      public boolean checkSDT() {
        if (txtSDT.getText().matches("[0,+84][\\d]{9}")) {
            return true;

        }
        JOptionPane.showMessageDialog(this, "Sai định dạng số điện thoại!");
        return false;
    }
      // check mail
         public boolean checkmail() {
        if (!isValidEmail(txtEmail.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Gmail không đúng định dạng !");
            return false;
        }
        return true;
    }

    public boolean isValidEmail(String email) {
        // Kiểm tra email không được viết hoa
        if (email.matches(".*[A-Z].*")) {
            return false;
        }

        String lowercaseEmail = email.toLowerCase();
        String regex = "^[a-z0-9._%+-]+(\\.[a-z0-9._%+-]+)*@[a-z0-9.-]+\\.[a-z]{2,}$";
        boolean hasConsecutiveDots = lowercaseEmail.contains("..");
        return lowercaseEmail.matches(regex) && !hasConsecutiveDots;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlCapNhat = new javax.swing.JPanel();
        lblMaKH = new javax.swing.JLabel();
        lblTenKH = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        txtMaKH = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNgaysinh = new javax.swing.JTextField();
        lblTenKH1 = new javax.swing.JLabel();
        cboTrangthai = new javax.swing.JComboBox<>();
        lblSDT1 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        btnNhoMax = new javax.swing.JButton();
        btnLonMax = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        rdonam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        lbtrang = new javax.swing.JLabel();
        btnNho = new javax.swing.JButton();
        btnLon = new javax.swing.JButton();
        lbsoTrang = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        pnlCapNhat.setBackground(new java.awt.Color(255, 255, 204));
        pnlCapNhat.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lblMaKH.setText("Mã khách hàng :");

        lblTenKH.setText("Tên khách hàng :");

        lblSDT.setText("Số điện thoại :");

        lblDiaChi.setText("Địa chỉ :");

        lblEmail.setText("Email :");

        txtTenKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKHActionPerformed(evt);
            }
        });

        txtMaKH.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtMaKH.setForeground(new java.awt.Color(255, 0, 0));
        txtMaKH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMaKHFocusGained(evt);
            }
        });
        txtMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKHActionPerformed(evt);
            }
        });

        txtNgaysinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaysinhActionPerformed(evt);
            }
        });

        lblTenKH1.setText("Ngày Sinh:");

        cboTrangthai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1" }));
        cboTrangthai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboTrangthaiActionPerformed(evt);
            }
        });

        lblSDT1.setText("Trạng Thái:");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        btnNhoMax.setText("<<");
        btnNhoMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhoMaxActionPerformed(evt);
            }
        });

        btnLonMax.setText(">>");
        btnLonMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLonMaxActionPerformed(evt);
            }
        });

        jLabel2.setText("Giới Tính:");

        buttonGroup1.add(rdonam);
        rdonam.setText("Nam");
        rdonam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdonamActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");
        rdoNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoNuActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimKiem.setText("OK");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTimKiem))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiem))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lbtrang.setText("jLabel3");

        btnNho.setText("<");
        btnNho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhoActionPerformed(evt);
            }
        });

        btnLon.setText(">");
        btnLon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLonActionPerformed(evt);
            }
        });

        lbsoTrang.setText("jLabel1");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 102, 255));
        jLabel1.setText("QUẢN LÝ KHÁCH HÀNG");

        javax.swing.GroupLayout pnlCapNhatLayout = new javax.swing.GroupLayout(pnlCapNhat);
        pnlCapNhat.setLayout(pnlCapNhatLayout);
        pnlCapNhatLayout.setHorizontalGroup(
            pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCapNhatLayout.createSequentialGroup()
                        .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lblTenKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                                    .addComponent(lblMaKH, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                                    .addComponent(txtMaKH)))
                            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                .addComponent(lblTenKH1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(43, 43, 43)
                                .addComponent(rdonam)
                                .addGap(56, 56, 56)
                                .addComponent(rdoNu)))
                        .addGap(101, 101, 101))
                    .addGroup(pnlCapNhatLayout.createSequentialGroup()
                        .addComponent(btnThem)
                        .addGap(76, 76, 76)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSDT1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCapNhatLayout.createSequentialGroup()
                        .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSDT)
                            .addComponent(lblDiaChi))
                        .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtEmail)
                                    .addComponent(cboTrangthai, 0, 285, Short.MAX_VALUE)
                                    .addComponent(txtDiaChi)))
                            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtSDT))))
                    .addComponent(lblEmail)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(btnNhoMax, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNho, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbtrang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLon, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLonMax, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbsoTrang)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCapNhatLayout.createSequentialGroup()
                        .addGap(380, 380, 380)
                        .addComponent(jLabel1))
                    .addGroup(pnlCapNhatLayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 939, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pnlCapNhatLayout.setVerticalGroup(
            pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCapNhatLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSDT)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaKH)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTenKH))
                .addGap(18, 18, 18)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTenKH1)
                        .addComponent(txtNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDiaChi))
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSDT1)
                    .addComponent(cboTrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(rdonam)
                    .addComponent(rdoNu))
                .addGap(18, 18, 18)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnThem)
                        .addComponent(btnSua)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCapNhatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNhoMax)
                    .addComponent(btnNho)
                    .addComponent(lbtrang)
                    .addComponent(btnLon)
                    .addComponent(btnLonMax)
                    .addComponent(lbsoTrang))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        jPanel4.getAccessibleContext().setAccessibleName("Tìm kiếm \n");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlCapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKHActionPerformed

    private void txtMaKHFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaKHFocusGained

    }//GEN-LAST:event_txtMaKHFocusGained

    private void txtMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKHActionPerformed

    private void txtNgaysinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaysinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaysinhActionPerformed

    private void cboTrangthaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboTrangthaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboTrangthaiActionPerformed

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked
        int index = tblKhachHang.getSelectedRow();
          if (index < 0) {
            return;
        }
        txtMaKH.setText(tblKhachHang.getValueAt(index, 0).toString());
        txtTenKH.setText(tblKhachHang.getValueAt(index, 1).toString());
        txtNgaysinh.setText(tblKhachHang.getValueAt(index, 2).toString());
        if (tblKhachHang.getValueAt(index,3 ).toString() == "Nam") {
            rdonam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        txtSDT.setText(tblKhachHang.getValueAt(index, 4).toString());
        txtEmail.setText(tblKhachHang.getValueAt(index, 5).toString());
      
        txtDiaChi.setText(tblKhachHang.getValueAt(index, 6).toString());

        cboTrangthai.setSelectedItem(tblKhachHang.getValueAt(index, 7).toString());
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (txtTenKH.getText().trim().equals("") || txtDiaChi.getText().trim().equals("")
                || txtSDT.getText().trim().equals("") || txtNgaysinh.getText().trim().equals("") || txtEmail.getText().trim().equals("")) {

            JOptionPane.showMessageDialog(this, "Vui long khong de trong");
            return;
        }

        String ma = txtMaKH.getText();
        String ten = txtTenKH.getText();
        String diaChi = txtDiaChi.getText();
        String sdt = txtSDT.getText();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        Date ngaySinh;
        try {
            ngaySinh = date.parse(txtNgaysinh.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ngày Sinh sai dinh dang");
            return;
        }
        String email = txtEmail.getText();
        Integer gioiTinh;
        if (rdoNu.isSelected()) {
            gioiTinh = 0;
        } else {
            gioiTinh = 1;
        }

        int trangThai = Integer.parseInt(cboTrangthai.getItemAt(0));
        KhachHang khachHang = new KhachHang(0, ma, ten, ngaySinh, gioiTinh, sdt, email, diaChi, gioiTinh, trangThai);

        service.them(khachHang);
        JOptionPane.showMessageDialog(this, "Thêm Thành  Công");
        loadData(1);
//        loadTable();


    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (txtTenKH.getText().trim().equals("") || 
                txtDiaChi.getText().trim().equals("")
                || txtSDT.getText().trim().equals("") || 
                txtNgaysinh.getText().trim().equals("") ||
                txtEmail.getText().trim().equals("")) {

            JOptionPane.showMessageDialog(this, "Vui long khong de trong");
            return;
        }

        String ma = txtMaKH.getText();
        String ten = txtTenKH.getText();
        String diaChi = txtDiaChi.getText();
        String sdt = txtSDT.getText();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        Date ngaySinh;
        try {
            ngaySinh = date.parse(txtNgaysinh.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "nhap sai dinh dang");
            return;
        }
        String email = txtEmail.getText();
        Integer gioiTinh;
        if (rdoNu.isSelected()) {
            gioiTinh = 0;
            
        } else {
            gioiTinh = 1;
        }

        int trangThai = Integer.parseInt(cboTrangthai.getItemAt(0));
        KhachHang khachHang = new KhachHang(0, ma, ten, ngaySinh, gioiTinh, sdt, email, diaChi, gioiTinh, trangThai);

        service.update(ma, khachHang);
        JOptionPane.showMessageDialog(this, "Sửa Thành  Công");
        loadData(1);


    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnNhoMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhoMaxActionPerformed
        trang = 1;
        loadData(trang);
        lbtrang.setText("1");
        lbsoTrang.setText("1/" + soTrang);
    }//GEN-LAST:event_btnNhoMaxActionPerformed

    private void rdoNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoNuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoNuActionPerformed

    private void rdonamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdonamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdonamActionPerformed

    private void btnNhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhoActionPerformed
        if (trang > 1) {
            trang--;
            loadData(trang);
            lbtrang.setText("" + trang);
            lbsoTrang.setText(trang + "/" + soTrang);
        }
    }//GEN-LAST:event_btnNhoActionPerformed

    private void btnLonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLonActionPerformed
        if (trang < soTrang) {
            trang++;
            loadData(trang);
            lbtrang.setText("" + trang);
            lbsoTrang.setText(trang + "/" + soTrang);
        }
    }//GEN-LAST:event_btnLonActionPerformed

    private void btnLonMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLonMaxActionPerformed
        trang = soTrang;
        loadData(trang);
        lbtrang.setText("" + soTrang);
        lbsoTrang.setText(soTrang + "/" + soTrang);
    }//GEN-LAST:event_btnLonMaxActionPerformed

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
       List<KhachHang> listk = new ArrayList<>();
       for(KhachHang k: listKh){
       if(k.getTen().toLowerCase().contains(txtTimKiem.getText().toLowerCase())  ||
              k.getSdt().toLowerCase().contains(txtTimKiem.getText().toLowerCase())  ){
           listk.add(k);
           
       }
       }
        loadData(1);
    }//GEN-LAST:event_txtTimKiemCaretUpdate


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLon;
    private javax.swing.JButton btnLonMax;
    private javax.swing.JButton btnNho;
    private javax.swing.JButton btnNhoMax;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboTrangthai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblMaKH;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblSDT1;
    private javax.swing.JLabel lblTenKH;
    private javax.swing.JLabel lblTenKH1;
    private javax.swing.JLabel lbsoTrang;
    private javax.swing.JLabel lbtrang;
    private javax.swing.JPanel pnlCapNhat;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JRadioButton rdonam;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNgaysinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
