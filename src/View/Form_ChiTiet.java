/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import DomainModels.ChatLieu;
import DomainModels.ChiTietDep;
import DomainModels.DanhMuc;
import DomainModels.De;
import DomainModels.MauSac;
import DomainModels.NhaSanXuat;
import DomainModels.SanPham;
import DomainModels.Size;
import Interface.ChiTietSanPhamImpl;
import Service.ChatLieuService;
import Service.ChiTietSanPhamService;
import Service.DanhMucService;
import Service.DeService;
import Service.MauSacService;
import Service.NsxService;
import Service.SanPhamService;
import Service.SizeService;
import Utilities.DBConnection;
import ViewModel.ChiTietSPModel;
import java.awt.Image;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ADMIN
 */
public class Form_ChiTiet extends javax.swing.JFrame {

    /**
     * Creates new form Form_ChiTiet
     */
    ChiTietSanPhamService chiTietSanPhamService = new ChiTietSanPhamService();
    DanhMucService danhMucService = new DanhMucService();
    SanPhamService sanPhamService = new SanPhamService();
    ChatLieuService chatLieuService = new ChatLieuService();
    MauSacService mauSacService = new MauSacService();
    SizeService sizeService = new SizeService();
    DeService deService = new DeService();
    NsxService nsxService = new NsxService();
    
    List<String> listDanhMuc;
    List<String> listSanPham;
    List<String> listChatLieu;
    List<String> listMauSac;
    List<String> listSize;
    List<String> listDe;
    List<String> listNsx;
    List<ChiTietDep> listChiTietDep;
    List<ChiTietSPModel> chiTietSPModels;
    DefaultTableModel model;
    int index = 0;
    
    long count, soTrang, trang = 1;
    
    public Form_ChiTiet() {
        initComponents();
        setLocationRelativeTo(null);
        fillTableSanPham();
        fillCboChiTiet();
        countDB();
        if (count % 5 == 0) {
            soTrang = count / 5;
        } else {
            soTrang = count / 5 + 1;
        }
        lbSoTrang.setText("1/" + soTrang);
        lbTrang.setText("1");
    }
    
    public void countDB() {
        try {
            String query = "Select count(*) from CHITIETDEP";
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
            Logger.getLogger(Form_ChiTiet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String conVertTinhTrangToString(int tinhTrang) {
        if (tinhTrang == 0) {
            return "Tam Ngung Ban";
        }
        return "Dang Ban";
    }
    
    public int conVertTinhTrangToInt(String tinhTrang) {
        int number = 0;
        if (tinhTrang.equalsIgnoreCase("Tam Ngung Ban")) {
            return 0;
        }
        return 1;
    }
    
    public void fillTableSanPham() {
        List<ChiTietDep> chiTietDeps = chiTietSanPhamService.getAll();
        if (chiTietDeps == null) {
            JOptionPane.showMessageDialog(this, "Lỗi");
        } else if (chiTietDeps.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Không có dữ liệu");
        } else {
            DefaultTableModel model = (DefaultTableModel) tblDanhSach.getModel();
            model.setRowCount(0);
            for (ChiTietDep ctd : chiTietDeps) {
                
                model.addRow(new Object[]{
                    ctd.getId(),
                    ctd.getIdSanPham().getTen(), ctd.getIdDanhMuc().getTen(),
                    ctd.getIdSize().getKichCo(), ctd.getIdMauSac().getMauSac(),
                    ctd.getIdChatLieu().getTen(), ctd.getIdNSX().getTen(),
                    ctd.getIdDe().getTen(), ctd.getSoLuong(),
                    ctd.getGiaBan(), ctd.getMoTa(),
                    conVertTinhTrangToString(ctd.getTrangThai())});
            }
        }
    }
    
    public void fillCboChiTiet() {
        listDanhMuc = chiTietSanPhamService.getDanhMuc();
        listDe = chiTietSanPhamService.getDe();
        listSanPham = chiTietSanPhamService.getSanPham();
        listSize = chiTietSanPhamService.getSize();
        listNsx = chiTietSanPhamService.getNsx();
        listChatLieu = chiTietSanPhamService.getChatLieu();
        listMauSac = chiTietSanPhamService.getMauSac();
        if (listDanhMuc.isEmpty() || listDe.isEmpty()
                || listSanPham.isEmpty() || listSize.isEmpty()
                || listNsx.isEmpty() || listChatLieu.isEmpty()
                || listMauSac.isEmpty()) {
            System.out.println("Mot Trong Cac List Cbo Rong");
        } else {
            cboDanhMuc.removeAllItems();
            for (String string : listDanhMuc) {
                cboDanhMuc.addItem(string);
            }
            
            cboDe.removeAllItems();
            for (String string : listDe) {
                cboDe.addItem(string);
            }
            
            cboSanPham.removeAllItems();
            for (String string : listSanPham) {
                cboSanPham.addItem(string);
            }
            
            cboSize.removeAllItems();
            for (String string : listSize) {
                cboSize.addItem(string);
            }
            
            cboNsx.removeAllItems();
            for (String string : listNsx) {
                cboNsx.addItem(string);
            }
            
            cboChatLieu.removeAllItems();
            for (String string : listChatLieu) {
                cboChatLieu.addItem(string);
            }
            
            cboMauSac.removeAllItems();
            for (String string : listMauSac) {
                cboMauSac.addItem(string);
            }
            listDanhMuc.add("All");
            cboDanhMuc.removeAllItems();
            for (String string : listDanhMuc) {
                cboDanhMuc.addItem(string);
            }
            listDe.add("All");
            cboDe.removeAllItems();
            for (String string : listDe) {
                cboDe.addItem(string);
            }
            listSanPham.add("All");
            cboSanPham.removeAllItems();
            for (String string : listSanPham) {
                cboSanPham.addItem(string);
            }
            listSize.add("All");
            cboSize.removeAllItems();
            for (String string : listSize) {
                cboSize.addItem(string);
            }
            listNsx.add("All");
            cboNsx.removeAllItems();
            for (String string : listNsx) {
                cboNsx.addItem(string);
            }
            listChatLieu.add("All");
            cboChatLieu.removeAllItems();
            for (String string : listChatLieu) {
                cboChatLieu.addItem(string);
            }
            listMauSac.add("All");
            cboMauSac.removeAllItems();
            for (String string : listMauSac) {
                cboMauSac.addItem(string);
            }
        }
    }
    
    public boolean checkRongTxt(JTextField txt) {
        if (txt.getText().trim().equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }
    
    public boolean checkRongTxtArea(JTextArea txtA) {
        if (txtA.getText().trim().equalsIgnoreCase("")) {
            return false;
        }
        return true;
    }
    
    public boolean checkPhaiLaSo(JTextField txt) {
        try {
            int a = Integer.parseInt(txt.getText());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean checkPhaiDuong(JTextField txt) {
        if (Integer.parseInt(txt.getText()) < 0) {
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cboNsx = new javax.swing.JComboBox<>();
        cboSize = new javax.swing.JComboBox<>();
        cboMauSac = new javax.swing.JComboBox<>();
        cboChatLieu = new javax.swing.JComboBox<>();
        cboSanPham = new javax.swing.JComboBox<>();
        cboDanhMuc = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cboDe = new javax.swing.JComboBox<>();
        txtSoLuong = new javax.swing.JTextField();
        txtGia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        rdoDangBan = new javax.swing.JRadioButton();
        rdoTamNgung = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDanhSach = new javax.swing.JTable();
        btNhoMax = new javax.swing.JButton();
        btNho = new javax.swing.JButton();
        lbTrang = new javax.swing.JLabel();
        btLon = new javax.swing.JButton();
        btLonMax = new javax.swing.JButton();
        lbSoTrang = new javax.swing.JLabel();
        lblid = new javax.swing.JLabel();
        btnCapNhat = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        lbClose = new javax.swing.JLabel();
        lbDanhMuc = new javax.swing.JLabel();
        lbChatLieu = new javax.swing.JLabel();
        lbMauSac = new javax.swing.JLabel();
        lbSize = new javax.swing.JLabel();
        lbNSX = new javax.swing.JLabel();
        lbDe = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel1.setText("Id Chi Tiết :");

        jLabel2.setText("Sản Phẩm");

        jLabel3.setText("Danh Mục");

        jLabel4.setText("Chất Liệu");

        jLabel5.setText("Màu Sắc");

        jLabel6.setText("Size");

        jLabel7.setText("Nhà Sản Xuất");

        jLabel8.setText("Đế");

        jLabel9.setText("Số Lượng");

        jLabel10.setText("Giá");

        jLabel11.setText("Mô Tả");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane1.setViewportView(txtMoTa);

        jLabel12.setText("Trạng Thái");

        buttonGroup1.add(rdoDangBan);
        rdoDangBan.setText("Dang Ban");

        buttonGroup1.add(rdoTamNgung);
        rdoTamNgung.setText("Tam Ngung Ban");

        tblDanhSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Sản Phẩm", "Danh Mục", "Size", "Màu Sắc", "Chất Liệu", "Nhà Sản Xuất", "Đế", "Số Lượng", "Giá", "Mô Tả", "Trạng Thái"
            }
        ));
        tblDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDanhSach);

        btNhoMax.setText("<<");
        btNhoMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNhoMaxActionPerformed(evt);
            }
        });

        btNho.setText("<");
        btNho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNhoActionPerformed(evt);
            }
        });

        lbTrang.setText("jLabel4");

        btLon.setText(">");
        btLon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLonActionPerformed(evt);
            }
        });

        btLonMax.setText(">>");
        btLonMax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLonMaxActionPerformed(evt);
            }
        });

        lbSoTrang.setText("jLabel14");

        btnCapNhat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Sua.png"))); // NOI18N
        btnCapNhat.setText("Cập Nhật");
        btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhatActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Them.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        lbClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-back-40.png"))); // NOI18N
        lbClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbCloseMouseClicked(evt);
            }
        });

        lbDanhMuc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-add-new-32.png"))); // NOI18N
        lbDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDanhMucMouseClicked(evt);
            }
        });

        lbChatLieu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-add-new-32.png"))); // NOI18N
        lbChatLieu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbChatLieuMouseClicked(evt);
            }
        });

        lbMauSac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-add-new-32.png"))); // NOI18N
        lbMauSac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbMauSacMouseClicked(evt);
            }
        });

        lbSize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-add-new-32.png"))); // NOI18N
        lbSize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSizeMouseClicked(evt);
            }
        });

        lbNSX.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-add-new-32.png"))); // NOI18N
        lbNSX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbNSXMouseClicked(evt);
            }
        });

        lbDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-add-new-32.png"))); // NOI18N
        lbDe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbDeMouseClicked(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(btnThem)
                        .addGap(68, 68, 68)
                        .addComponent(btnCapNhat)
                        .addGap(71, 71, 71)
                        .addComponent(btnReset))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(lblid))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbClose))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(btNhoMax)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btNho, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTrang)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btLon, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btLonMax)
                        .addGap(18, 18, 18)
                        .addComponent(lbSoTrang))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbMauSac))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboNsx, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbNSX))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbChatLieu))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbDanhMuc))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbSize)))
                        .addGap(82, 82, 82)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cboDe, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(rdoDangBan)
                                .addGap(18, 18, 18)
                                .addComponent(rdoTamNgung))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtGia)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                                    .addComponent(txtSoLuong))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbDe))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 903, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbClose)
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblid))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(3, 3, 3)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(cboSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(cboDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(cboDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(lbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addComponent(lbDe, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10)
                                .addComponent(jLabel6))
                            .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(cboNsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel11)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdoTamNgung)
                                    .addComponent(rdoDangBan)
                                    .addComponent(jLabel12))))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCapNhat)
                            .addComponent(btnThem)
                            .addComponent(btnReset)))
                    .addComponent(lbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNhoMax)
                    .addComponent(btNho)
                    .addComponent(lbTrang)
                    .addComponent(btLon)
                    .addComponent(btLonMax)
                    .addComponent(lbSoTrang))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lbCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbCloseMouseClicked
        this.dispose();
    }//GEN-LAST:event_lbCloseMouseClicked

    private void lbDanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDanhMucMouseClicked
        try {
            Form_DanhMuc danhMuc = new Form_DanhMuc();
            danhMuc.setVisible(true);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_lbDanhMucMouseClicked

    private void lbChatLieuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbChatLieuMouseClicked
        try {
            Form_ChatLieu chatLieu = new Form_ChatLieu();
            chatLieu.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lbChatLieuMouseClicked

    private void lbMauSacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbMauSacMouseClicked
        try {
            Form_MauSac mauSac = new Form_MauSac();
            mauSac.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lbMauSacMouseClicked

    private void lbSizeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSizeMouseClicked
        try {
            Form_Size size = new Form_Size();
            size.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lbSizeMouseClicked

    private void lbNSXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbNSXMouseClicked
        try {
            Form_NSX nSX = new Form_NSX();
            nSX.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lbNSXMouseClicked

    private void lbDeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbDeMouseClicked
        try {
            Form_De de = new Form_De();
            de.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_lbDeMouseClicked

    private void tblDanhSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDanhSachMouseClicked
        int index = tblDanhSach.getSelectedRow();
        if (index < 0) {
            return;
        }
        lblid.setText(tblDanhSach.getValueAt(index, 0).toString());
        cboSanPham.setSelectedItem(tblDanhSach.getValueAt(index, 1).toString());
        cboDanhMuc.setSelectedItem(tblDanhSach.getValueAt(index, 2).toString());
        cboSize.setSelectedItem(tblDanhSach.getValueAt(index, 3).toString());
        cboMauSac.setSelectedItem(tblDanhSach.getValueAt(index, 4).toString());
        cboChatLieu.setSelectedItem(tblDanhSach.getValueAt(index, 5).toString());
        cboNsx.setSelectedItem(tblDanhSach.getValueAt(index, 6).toString());
        cboDe.setSelectedItem(tblDanhSach.getValueAt(index, 7).toString());
        txtSoLuong.setText(tblDanhSach.getValueAt(index, 8).toString());
        txtGia.setText(tblDanhSach.getValueAt(index, 9).toString());
        txtMoTa.setText(tblDanhSach.getValueAt(index, 10).toString());
        if (tblDanhSach.getValueAt(index, 11).toString() == "Dang Ban") {
            rdoDangBan.setSelected(true);
        } else {
            rdoTamNgung.setSelected(true);
        }
    }//GEN-LAST:event_tblDanhSachMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        int selected = -1;
        if (checkRongTxtArea(txtMoTa) == false || checkRongTxt(txtGia) == false || checkRongTxt(txtSoLuong) == false) {
            JOptionPane.showMessageDialog(this, "Vui long nhap day du thong tin");
        } else if (checkPhaiLaSo(txtSoLuong) == false) {
            JOptionPane.showMessageDialog(this, "Mot so thong tin phai la so");
        } else if (checkPhaiDuong(txtGia) == false || checkPhaiDuong(txtSoLuong) == false) {
            JOptionPane.showMessageDialog(this, "So luong và gia khong duoc am");
        }
        
        ChiTietSPModel chiTietSPModel = new ChiTietSPModel();
        chiTietSPModel.setTenDanhMuc(FillTenDanhMuc((String) cboDanhMuc.getSelectedItem()));        
        chiTietSPModel.setTenSanPham(FillTenSanPham((String) cboSanPham.getSelectedItem()));
        chiTietSPModel.setTenSize(FillTenSize((String) cboSize.getSelectedItem()));
        chiTietSPModel.setTenMauSac(FillTenMauSac((String) cboMauSac.getSelectedItem()));
        chiTietSPModel.setTenChatLieu(FillTenChatLieu((String) cboChatLieu.getSelectedItem()));
        chiTietSPModel.setTenNhaSX(FillTenNhaSanXuat((String) cboNsx.getSelectedItem()));
        chiTietSPModel.setTenDe(FillTenDe((String) cboDe.getSelectedItem()));
        chiTietSPModel.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        chiTietSPModel.setGiaBan(Float.parseFloat(txtGia.getText()));
        chiTietSPModel.setMoTa(String.valueOf(txtMoTa.getText()));
        if (rdoDangBan.isSelected()) {
            chiTietSPModel.setTrangThai(1);
        }else{
            chiTietSPModel.setTrangThai(0);
        }
        JOptionPane.showMessageDialog(this, chiTietSanPhamService.insertChiTiet(chiTietSPModel));
        listChiTietDep = chiTietSanPhamService.getAll();
        fillTableSanPham();
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        cboSanPham.setSelectedIndex(0);
        cboDanhMuc.setSelectedIndex(0);
        cboSize.setSelectedIndex(0);
        cboMauSac.setSelectedIndex(0);
        cboChatLieu.setSelectedIndex(0);
        cboNsx.setSelectedIndex(0);
        cboDe.setSelectedIndex(0);
        txtGia.setText("");
        txtSoLuong.setText("");
        txtMoTa.setText("");
        rdoDangBan.setSelected(true);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhatActionPerformed
        if (checkRongTxtArea(txtMoTa) == false || checkRongTxt(txtGia) == false || checkRongTxt(txtSoLuong) == false) {
            JOptionPane.showMessageDialog(this, "Vui long chon ban ghi de cap nhat.");
            return;
        }
        if (checkPhaiLaSo(txtGia) == false || checkPhaiLaSo(txtSoLuong) == false) {
            JOptionPane.showMessageDialog(this, "Mot so thong tin phai la so.");
            return;
        }
        if (checkPhaiDuong(txtGia) == false || checkPhaiDuong(txtSoLuong) == false) {
            JOptionPane.showMessageDialog(this, "So luong và gia khong duoc am.");
            return;
        }
        ChiTietSPModel chiTietSPModel = new ChiTietSPModel();
        chiTietSPModel.setTenDanhMuc(FillTenDanhMuc((String) cboDanhMuc.getSelectedItem()));        
        chiTietSPModel.setTenSanPham(FillTenSanPham((String) cboSanPham.getSelectedItem()));
        chiTietSPModel.setTenSize(FillTenSize((String) cboSize.getSelectedItem()));
        chiTietSPModel.setTenMauSac(FillTenMauSac((String) cboMauSac.getSelectedItem()));
        chiTietSPModel.setTenChatLieu(FillTenChatLieu((String) cboChatLieu.getSelectedItem()));
        chiTietSPModel.setTenNhaSX(FillTenNhaSanXuat((String) cboNsx.getSelectedItem()));
        chiTietSPModel.setTenDe(FillTenDe((String) cboDe.getSelectedItem()));
        chiTietSPModel.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
        chiTietSPModel.setGiaBan(Float.parseFloat(txtGia.getText()));
        chiTietSPModel.setMoTa(String.valueOf(txtMoTa.getText()));
        if (rdoDangBan.isSelected()) {
            chiTietSPModel.setTrangThai(1);
        }else{
            chiTietSPModel.setTrangThai(0);
        }
        chiTietSPModel.setId(Integer.parseInt(lblid.getText()));
        JOptionPane.showMessageDialog(this, chiTietSanPhamService.updateChiTiet(chiTietSPModel));
        listChiTietDep = chiTietSanPhamService.getAll();
        fillTableSanPham();

    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btNhoMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNhoMaxActionPerformed
        trang = 1;
        fillTableSanPham();
        lbTrang.setText("1");
        lbSoTrang.setText("1/" + soTrang);
    }//GEN-LAST:event_btNhoMaxActionPerformed

    private void btLonMaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLonMaxActionPerformed
        trang = soTrang;
        fillTableSanPham();
        lbTrang.setText("" + soTrang);
        lbSoTrang.setText(soTrang + "/" + soTrang);
    }//GEN-LAST:event_btLonMaxActionPerformed

    private void btNhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNhoActionPerformed
        if (trang > 1) {
            trang--;
            fillTableSanPham();
            lbTrang.setText("" + trang);
            lbSoTrang.setText(trang + "/" + soTrang);
        }
    }//GEN-LAST:event_btNhoActionPerformed

    private void btLonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLonActionPerformed
        if (trang < soTrang) {
            trang++;
            fillTableSanPham();
            lbTrang.setText("" + trang);
            lbSoTrang.setText(trang + "/" + soTrang);
        }
    }//GEN-LAST:event_btLonActionPerformed
    
    private SanPham FillTenSanPham(String ten) {
        return sanPhamService.getIDByName(ten);
    }
    
    private DanhMuc FillTenDanhMuc(String ten) {
        return danhMucService.getIDByName(ten);
    }
    
    private Size FillTenSize(String ten) {
        return sizeService.getIDByName(ten);
    }
    
    private NhaSanXuat FillTenNhaSanXuat(String ten) {
        return nsxService.getIDByName(ten);
    }
    
    private ChatLieu FillTenChatLieu(String ten) {
        return chatLieuService.getIDByName(ten);
    }
    
    private De FillTenDe(String ten) {
        return deService.getIDByName(ten);
    }
    
    private MauSac FillTenMauSac(String ten) {
        return mauSacService.getIDByName(ten);
    }

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
//            java.util.logging.Logger.getLogger(Form_ChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Form_ChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Form_ChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Form_ChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Form_ChiTiet().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLon;
    private javax.swing.JButton btLonMax;
    private javax.swing.JButton btNho;
    private javax.swing.JButton btNhoMax;
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboChatLieu;
    private javax.swing.JComboBox<String> cboDanhMuc;
    private javax.swing.JComboBox<String> cboDe;
    private javax.swing.JComboBox<String> cboMauSac;
    private javax.swing.JComboBox<String> cboNsx;
    private javax.swing.JComboBox<String> cboSanPham;
    private javax.swing.JComboBox<String> cboSize;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbChatLieu;
    private javax.swing.JLabel lbClose;
    private javax.swing.JLabel lbDanhMuc;
    private javax.swing.JLabel lbDe;
    private javax.swing.JLabel lbMauSac;
    private javax.swing.JLabel lbNSX;
    private javax.swing.JLabel lbSize;
    private javax.swing.JLabel lbSoTrang;
    private javax.swing.JLabel lbTrang;
    private javax.swing.JLabel lblid;
    private javax.swing.JRadioButton rdoDangBan;
    private javax.swing.JRadioButton rdoTamNgung;
    private javax.swing.JTable tblDanhSach;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
