/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import DomainModels.NguoiDung;
import Service.NhanVienService;
import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
//import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Form_NV extends javax.swing.JPanel {

    int viTri;
    int TienLui = 0;
    int so = 1;
    int tt = -1;
    //view gọi service
    NhanVienService nvs = new NhanVienService();
    ArrayList<NguoiDung> listNVS = nvs.getAll();

    public Form_NV() {
        initComponents();
        initComponents();
        String ma = txtTimKiemNV.getText().trim();
        ArrayList<NguoiDung> nd = nvs.timKiemPhanTrang(ma, TienLui, tt);
        loadTable(nd);
    }
    
    public void loadTable(ArrayList<NguoiDung> nguoiDung) {
        DefaultTableModel model = (DefaultTableModel) tblNhanVien.getModel();
        model.setRowCount(0);
        for (NguoiDung nd : nguoiDung) {
            Object[] data = new Object[]{
                nd.getMaNguoiDung(),
                nd.getTenNguoiDung(),
                nd.getNgaySinhNguoiDung(),
                nd.getEmailNguoiDung(),
                nd.getSdtNguoiDung(),
                nd.getGioiTinhNguoiDung() == 1 ? "Nam" : "Nữ",
                nd.getDiaChiNguoiDung(),
                nd.getMatKhauNguoiDung(),
                nd.getTrangThaiNguoiDung() == 0 ? "Nghỉ làm" : "Đi làm",};
            model.addRow(data);
        }
        listNVS = nguoiDung;
    }

    // Validate:
    // Check trống:
    public boolean checkTrong() {
        if (txtMaNV.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống mã nhân viên !");
            txtMaNV.requestFocus();
            return false;

        } else if (txtTenNV.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống tên nhân viên !");
            txtTenNV.requestFocus();
            return false;

        } else if (txtNgaySinh.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống ngày sinh !");
            txtNgaySinh.requestFocus();
            return false;

        } else if (txtEmailNV.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống email !");
            txtEmailNV.requestFocus();
            return false;

        } else if (txtSDTNV.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống SĐT !");
            txtSDTNV.requestFocus();
            return false;

        } else if (txtDiaChiNV.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống địa chỉ !");
            txtDiaChiNV.requestFocus();
            return false;

        } else if (txtMatKhauNV.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng không để trống mật khẩu !");
            txtMatKhauNV.requestFocus();
            return false;
        }

        return true;
    }

    // Check email:
    private boolean isValidEmail(String email) {
        // Kiểm tra email không được viết hoa
        if (email.matches(".*[A-Z].*")) {
            return false;
        }

        String lowercaseEmail = email.toLowerCase();
        String regex = "^[a-z0-9._%+-]+(\\.[a-z0-9._%+-]+)*@[a-z0-9.-]+\\.[a-z]{2,}$";
        boolean hasConsecutiveDots = lowercaseEmail.contains("..");
        return lowercaseEmail.matches(regex) && !hasConsecutiveDots;
    }

    public boolean checkEmail() {
        if (!isValidEmail(txtEmailNV.getText().trim())) {
            JOptionPane.showMessageDialog(this, "Email không đúng định dạng!");
            return false;
        }
        return true;
    }

    //Check tên
    public boolean checkTen() {
        String paramater = "^[AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+ [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]+(?: [AÀẢÃÁẠĂẰẲẴẮẶÂẦẨẪẤẬBCDĐEÈẺẼÉẸÊỀỂỄẾỆFGHIÌỈĨÍỊJKLMNOÒỎÕÓỌÔỒỔỖỐỘƠỜỞỠỚỢPQRSTUÙỦŨÚỤƯỪỬỮỨỰVWXYỲỶỸÝỴZ][aàảãáạăằẳẵắặâầẩẫấậbcdđeèẻẽéẹêềểễếệfghiìỉĩíịjklmnoòỏõóọôồổỗốộơờởỡớợpqrstuùủũúụưừửữứựvwxyỳỷỹýỵz]*)*";
        if (txtTenNV.getText().trim().matches(paramater)) {
            return true;
        }
        if (txtTenNV.getText().trim().length() > 2) {
            return true;
        }
        JOptionPane.showMessageDialog(this, "Tên sai định dạng (phải là chữ và lớn hơn hai kí tự) !");

        return false;
    }

    // Check SĐT:
    public boolean checkSDT() {
        if (txtSDTNV.getText().matches("[0,+84][\\d]{8,11}")) {
            return true;
        }
        JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng số điện thoại!");
        return false;
    }

    public NguoiDung getFromData() {
        NguoiDung nd = new NguoiDung();
        nd.setMaNguoiDung(txtMaNV.getText().trim());
        nd.setTenNguoiDung(txtTenNV.getText().trim());
        nd.setNgaySinhNguoiDung(Date.valueOf(txtNgaySinh.getText().trim()));
        nd.setEmailNguoiDung(txtEmailNV.getText().trim());
        nd.setSdtNguoiDung(txtSDTNV.getText().trim());
        if (rdoNam.isSelected()) {
            nd.setGioiTinhNguoiDung(1);
        } else {
            nd.setGioiTinhNguoiDung(0);
        }
        nd.setDiaChiNguoiDung(txtDiaChiNV.getText().trim());
        nd.setMatKhauNguoiDung(txtMatKhauNV.getText().trim());
        int trangThai = 0;
        if (cboTrangThaiNV.getSelectedItem().equals("Đi làm")) {
            trangThai = 1;
        } else if (cboTrangThaiNV.getSelectedItem().equals("Nghỉ làm")) {
            trangThai = 0;
        }
        nd.setTrangThaiNguoiDung(trangThai);
        return nd;
    }

    public void clearFrom() {
        txtMaNV.setText("");
        txtTenNV.setText("");
        txtNgaySinh.setText("");
        txtEmailNV.setText("");
        rdoNam.setSelected(true);
        txtSDTNV.setText("");
        txtDiaChiNV.setText("");
        txtMatKhauNV.setText("");
        cboTrangThaiNV.setSelectedIndex(0);
    }

    public void timkiem() {
        String ma = txtTimKiemNV.getText();
        ArrayList<NguoiDung> nd = nvs.timKiemPhanTrang(ma, TienLui, tt);
        loadTable(nd);
    }
    public void tk(int status) {
        String ma = txtTimKiemNV.getText();
        ArrayList<NguoiDung> output = nvs.timKiemPhanTrang(ma, TienLui, status);
        loadTable(output);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtSDTNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtEmailNV = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtMatKhauNV = new javax.swing.JTextField();
        txtDiaChiNV = new javax.swing.JTextField();
        rdoNam = new javax.swing.JRadioButton();
        rdoNu = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        txtTimKiemNV = new javax.swing.JTextField();
        btnTimKiemNV = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        cboLoc = new javax.swing.JComboBox<>();
        cboTrangThaiNV = new javax.swing.JComboBox<>();
        btnClearFrom = new javax.swing.JButton();
        lui = new javax.swing.JButton();
        tien = new javax.swing.JButton();
        lbSoTrang = new javax.swing.JLabel();
        phantrang = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 204));

        jLabel2.setBackground(new java.awt.Color(51, 102, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 51, 255));
        jLabel2.setText("Quản Lý Nhân Viên");
        jPanel2.add(jLabel2);

        jLabel1.setText("Mã nhân viên : ");

        jLabel4.setText("Tên nhân viên : ");

        jLabel5.setText("Ngày sinh : ");

        jLabel6.setText("Email : ");

        jLabel7.setText("Số điện thoại : ");

        jLabel8.setText("Giới tính : ");

        jLabel9.setText("Địa chỉ : ");

        jLabel10.setText("Mật khẩu : ");

        jLabel11.setText("Trạng thái : ");

        rdoNam.setBackground(new java.awt.Color(255, 255, 204));
        buttonGroup1.add(rdoNam);
        rdoNam.setSelected(true);
        rdoNam.setText("Nam");

        rdoNu.setBackground(new java.awt.Color(255, 255, 204));
        buttonGroup1.add(rdoNu);
        rdoNu.setText("Nữ");

        jPanel4.setBackground(new java.awt.Color(255, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm nhân viên ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        btnTimKiemNV.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTimKiemNV.setText("Tìm");
        btnTimKiemNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemNVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addComponent(txtTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiemNV)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiemNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTimKiemNV))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Họ tên", "Ngày sinh", "Email", "SĐT", "Giới tính", "Địa chỉ", "Mật khẩu", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc theo trạng thái", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N

        cboLoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đi làm", "Nghỉ làm" }));
        cboLoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLocItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cboLoc, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(cboLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        cboTrangThaiNV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đi làm", "Nghỉ làm" }));

        btnClearFrom.setText("Clear From");
        btnClearFrom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearFromActionPerformed(evt);
            }
        });

        lui.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lui.setText("<");
        lui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luiActionPerformed(evt);
            }
        });

        tien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tien.setText(">");
        tien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tienActionPerformed(evt);
            }
        });

        lbSoTrang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSoTrang.setText("Trang : ");

        phantrang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        phantrang.setText("1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(lui, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(phantrang, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(tien, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(358, 358, 358))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(175, 175, 175)
                                        .addComponent(txtMatKhauNV, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(56, 56, 56)
                                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(txtEmailNV, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                            .addComponent(rdoNam, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(111, 111, 111)
                                                                .addComponent(rdoNu, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                                                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGap(18, 18, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnSua)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnClearFrom))
                                            .addComponent(txtSDTNV, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                            .addComponent(txtDiaChiNV)
                                            .addComponent(cboTrangThaiNV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSDTNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtDiaChiNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel10)
                            .addComponent(txtMatKhauNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtEmailNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(cboTrangThaiNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(rdoNam)
                                .addComponent(rdoNu))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnThem)
                                .addComponent(btnSua)
                                .addComponent(btnClearFrom))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lui)
                    .addComponent(tien)
                    .addComponent(lbSoTrang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phantrang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(51, 51, 51))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemNVActionPerformed
        try {
            if (txtTimKiemNV.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "Vui lòng không để trống ô tìm kiếm!");
                return;
            } else {
                timkiem();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnTimKiemNVActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int row = tblNhanVien.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Mời chọn dòng cần sửa!");
            return;
        }
        String ma = tblNhanVien.getValueAt(row, 0).toString();
        if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa ?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            if (checkTrong() == true && checkEmail() == true && checkTen() == true && checkSDT() == true) {
                nvs.update(ma, getFromData());
                tk(-1);
                JOptionPane.showMessageDialog(this, "Sửa thành công !");
                clearFrom();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Sửa thất bại!");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm ?") == JOptionPane.NO_OPTION) {
            return;
        }
        try {
            if (checkTrong() == true && checkEmail() == true && checkTen() == true && checkSDT() == true) {
                nvs.add(getFromData());
                tk(-1);
                JOptionPane.showMessageDialog(this, "Thêm thành công !");
                clearFrom();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Thêm thất bại!");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        int row = tblNhanVien.getSelectedRow();
        if (row < 0) {
            return;
        }
        txtMaNV.setText(tblNhanVien.getValueAt(row, 0).toString());
        txtTenNV.setText(tblNhanVien.getValueAt(row, 1).toString());
        txtNgaySinh.setText(tblNhanVien.getValueAt(row, 2).toString());
        txtEmailNV.setText(tblNhanVien.getValueAt(row, 3).toString());
        txtSDTNV.setText(tblNhanVien.getValueAt(row, 4).toString());
        if (tblNhanVien.getValueAt(row, 5).toString() == "Nam") {
            rdoNam.setSelected(true);
        } else {
            rdoNu.setSelected(true);
        }
        txtDiaChiNV.setText(tblNhanVien.getValueAt(row, 6).toString());
        txtMatKhauNV.setText(tblNhanVien.getValueAt(row, 7).toString());
        cboTrangThaiNV.setSelectedItem(tblNhanVien.getValueAt(row, 8).toString());
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void cboLocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLocItemStateChanged
        try {
            String a = cboLoc.getSelectedItem().toString();

            switch (a) {
                case "Đi làm":
                    tt = 1;
                    break;

                case "Nghỉ làm":
                    tt = 0;
                    break;

                default:
                    tt = -1;
                    break;
            }
            String ma = txtTimKiemNV.getText();
            ArrayList<NguoiDung> output = nvs.timKiemPhanTrang(ma, TienLui, tt);
            loadTable(output);

        } catch (Exception e) {
        }
    }//GEN-LAST:event_cboLocItemStateChanged

    private void btnClearFromActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearFromActionPerformed
        clearFrom();
    }//GEN-LAST:event_btnClearFromActionPerformed

    private void luiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luiActionPerformed
        try {
            String ma = txtTimKiemNV.getText().trim();
            if (TienLui > 0) {
                so -= 1;
                phantrang.setText(String.valueOf(so));
                TienLui -= 5;
                int b = TienLui;
                ArrayList<NguoiDung> nd = nvs.timKiemPhanTrang(ma, b, tt);
                loadTable(nd);
            } else {
                int b = 0;
                ArrayList<NguoiDung> nd = nvs.timKiemPhanTrang(ma, b, tt);
                loadTable(nd);
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_luiActionPerformed

    private void tienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tienActionPerformed
        try {
            String ma = txtTimKiemNV.getText().trim();
            so += 1;
            TienLui += 5;
            if (TienLui > 0) {
                phantrang.setText(String.valueOf(so));
                int b = TienLui;
                ArrayList<NguoiDung> nd = nvs.timKiemPhanTrang(ma, b, tt);
                loadTable(nd);
            }

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tienActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearFrom;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiemNV;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboLoc;
    private javax.swing.JComboBox<String> cboTrangThaiNV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbSoTrang;
    private javax.swing.JButton lui;
    private javax.swing.JLabel phantrang;
    private javax.swing.JRadioButton rdoNam;
    private javax.swing.JRadioButton rdoNu;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JButton tien;
    private javax.swing.JTextField txtDiaChiNV;
    private javax.swing.JTextField txtEmailNV;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMatKhauNV;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDTNV;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTimKiemNV;
    // End of variables declaration//GEN-END:variables
}
