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
import ViewModel.ChiTietSPModel;
import java.awt.Image;
import java.io.File;
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
    List<ChiTietDep> listChiTietDep = chiTietSanPhamService.getAll();
    DefaultTableModel model;
    String imageUrl;
    int index = 0;
//    List<String>;

    public Form_ChiTiet() {
        initComponents();
        setLocationRelativeTo(null);
        fillTableSanPham();
//        fillCboChiTiet();

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
//            Object dataRow[] = new Object[11];
//            dataRow[] = ctd.getIdDanhMuc();
                model.addRow(new Object[]{
                    ctd.getIdDanhMuc(), ctd.getIdSanPham(),
                    ctd.getIdSize(), ctd.getIdMauSac(),
                    ctd.getIdChatLieu(), ctd.getIdNSX(),
                    ctd.getIdDe(), ctd.getSoLuong(),
                    ctd.getGiaBan(), ctd.getMoTa(),
                    conVertTinhTrangToString(ctd.getTrangThai())});
            }
        }
    }

//    public void fillCboChiTiet() {
//        listDanhMuc = chiTietSanPhamService.getDanhMuc();
//        listDe = chiTietSanPhamService.getDe();
//        listSanPham = chiTietSanPhamService.getSanPham();
//        listSize = chiTietSanPhamService.getSize();
//        listNsx = chiTietSanPhamService.getNsx();
//        listChatLieu = chiTietSanPhamService.getChatLieu();
//        listMauSac = chiTietSanPhamService.getMauSac();
//        if (listDanhMuc.isEmpty() || listDe.isEmpty()
//                || listSanPham.isEmpty() || listSize.isEmpty()
//                || listNsx.isEmpty() || listChatLieu.isEmpty()
//                || listMauSac.isEmpty()) {
//            System.out.println("Mot Trong Cac List Cbo Rong");
//        } else {
//            cboDanhMuc.removeAllItems();
//            for (String string : listDanhMuc) {
//                cboDanhMuc.addItem(string);
//            }
//
//            cboDe.removeAllItems();
//            for (String string : listDe) {
//                cboDe.addItem(string);
//            }
//
//            cboSanPham.removeAllItems();
//            for (String string : listSanPham) {
//                cboSanPham.addItem(string);
//            }
//
//            cboSize.removeAllItems();
//            for (String string : listSize) {
//                cboSize.addItem(string);
//            }
//
//            cboNsx.removeAllItems();
//            for (String string : listNsx) {
//                cboNsx.addItem(string);
//            }
//
//            cboChatLieu.removeAllItems();
//            for (String string : listChatLieu) {
//                cboChatLieu.addItem(string);
//            }
//
//            cboMauSac.removeAllItems();
//            for (String string : listMauSac) {
//                cboMauSac.addItem(string);
//            }
//            listDanhMuc.add("All");
//            cboDanhMuc.removeAllItems();
//            for (String string : listDanhMuc) {
//                cboDanhMuc.addItem(string);
//            }
//            listDe.add("All");
//            cboDe.removeAllItems();
//            for (String string : listDe) {
//                cboDe.addItem(string);
//            }
//            listSanPham.add("All");
//            cboSanPham.removeAllItems();
//            for (String string : listSanPham) {
//                cboSanPham.addItem(string);
//            }
//            listSize.add("All");
//            cboSize.removeAllItems();
//            for (String string : listSize) {
//                cboSize.addItem(string);
//            }
//            listNsx.add("All");
//            cboNsx.removeAllItems();
//            for (String string : listNsx) {
//                cboNsx.addItem(string);
//            }
//            listChatLieu.add("All");
//            cboChatLieu.removeAllItems();
//            for (String string : listChatLieu) {
//                cboChatLieu.addItem(string);
//            }
//            listMauSac.add("All");
//            cboMauSac.removeAllItems();
//            for (String string : listMauSac) {
//                cboMauSac.addItem(string);
//            }
//        }
//    }

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
        jLabel13 = new javax.swing.JLabel();
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
        anhChiTiet = new javax.swing.JLabel();
        btnAnh = new javax.swing.JButton();

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
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Sản Phẩm", "Danh Mục", "Size", "Màu Sắc", "Chất Liệu", "Nhà Sản Xuất", "Đế", "Số Lượng", "Giá", "Mô Tả", "Trạng Thái"
            }
        ));
        tblDanhSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDanhSachMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDanhSach);

        btNhoMax.setText("<<");

        btNho.setText("<");

        lbTrang.setText("jLabel4");

        btLon.setText(">");

        btLonMax.setText(">>");

        lbSoTrang.setText("jLabel14");

        jLabel13.setText("jLabel13");

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
        btnReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Sua.png"))); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        anhChiTiet.setText("jLabel14");

        btnAnh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAnh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/UpLoad_Image.png"))); // NOI18N
        btnAnh.setText("Chọn Ảnh");
        btnAnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThem)
                .addGap(94, 94, 94)
                .addComponent(btnCapNhat)
                .addGap(74, 74, 74)
                .addComponent(btnReset)
                .addGap(117, 117, 117))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(anhChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btnAnh)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboMauSac, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18)
                                    .addComponent(cboNsx, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(36, 36, 36)
                                        .addComponent(cboSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(34, 34, 34)
                                        .addComponent(cboDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(39, 39, 39)
                                        .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbChatLieu)
                            .addComponent(lbMauSac)
                            .addComponent(lbSize)
                            .addComponent(lbNSX)
                            .addComponent(lbDanhMuc))
                        .addGap(52, 52, 52)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(15, 15, 15)
                                .addComponent(rdoDangBan)
                                .addGap(18, 18, 18)
                                .addComponent(rdoTamNgung))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cboDe, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbDe))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtGia, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(299, 299, 299)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(227, 227, 227)
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
                        .addContainerGap()
                        .addComponent(lbClose)))
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
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cboDe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8))
                            .addComponent(lbDe, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cboDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel9))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(cboChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10))
                            .addComponent(lbChatLieu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                    .addComponent(cboSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbSize, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(cboNsx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbNSX, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdoTamNgung)
                                    .addComponent(rdoDangBan)
                                    .addComponent(jLabel12)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(anhChiTiet, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAnh)))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCapNhat)
                    .addComponent(btnThem)
                    .addComponent(btnReset))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btNhoMax)
                    .addComponent(btNho)
                    .addComponent(lbTrang)
                    .addComponent(btLon)
                    .addComponent(btLonMax)
                    .addComponent(lbSoTrang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        int selected = -1;
        if (rdoDangBan.isSelected()) {
                selected = 1;
            }else if (rdoTamNgung.isSelected()) {
                selected = 0;
            }
        index = tblDanhSach.getSelectedRow();
        fillOnClickChiTiet();
        imageUrl = listChiTietDep.get(index).getHinhAnh();
        showImage(imageUrl);

    }//GEN-LAST:event_tblDanhSachMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        int selected = -1;
        if (checkRongTxtArea(txtMoTa) == false || checkRongTxt(txtGia) == false || checkRongTxt(txtSoLuong) == false) {
            JOptionPane.showMessageDialog(this, "Vui long nhap day du thong tin");
        } else if (checkPhaiLaSo(txtGia) == false || checkPhaiLaSo(txtSoLuong) == false) {
            JOptionPane.showMessageDialog(this, "Mot so thong tin phai la so");
        } else if (checkPhaiDuong(txtGia) == false || checkPhaiDuong(txtSoLuong) == false) {
            JOptionPane.showMessageDialog(this, "So luong và gia khong duoc am");
        } else {
//            ChiTietSPModel chiTietSPModel = new ChiTietSPModel();
//            chiTietSPModel.setTenDanhMuc(String.valueOf(cboDanhMuc.getSelectedItem()));
//            chiTietSPModel.setTenSanPham(String.valueOf(cboSanPham.getSelectedItem()));
//            chiTietSPModel.setTenSize(String.valueOf(cboSize.getSelectedItem()));
//            chiTietSPModel.setTenMauSac(String.valueOf(cboMauSac.getSelectedItem()));
//            chiTietSPModel.setTenChatLieu(String.valueOf(cboChatLieu.getSelectedItem()));
//            chiTietSPModel.setTenNhaSX(String.valueOf(cboNsx.getSelectedItem()));
//            chiTietSPModel.setTenDe(String.valueOf(cboDe.getSelectedItem()));
//            chiTietSPModel.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
//            chiTietSPModel.setGiaBan(Float.parseFloat(txtGia.getText()));
//            chiTietSPModel.setMoTa(String.valueOf(txtMoTa.getText()));
//            chiTietSPModel.setImageUrl(imageUrl);
//
//            if (rdoDangBan.isSelected()) {
//                selected = 1;
//            }else if (rdoTamNgung.isSelected()) {
//                selected = 0;
//            }
//            JOptionPane.showMessageDialog(this, chiTietSanPhamService.addChiTiet(chiTietSPModel));
//            listChiTietDep = chiTietSanPhamService.getAll();
//            
//            showImage(imageUrl);
//            fillTableSanPham();
        }


    }//GEN-LAST:event_btnThemActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        cboDanhMuc.setSelectedIndex(0);
        cboSanPham.setSelectedIndex(0);
        cboSize.setSelectedIndex(0);
        cboMauSac.setSelectedIndex(0);
        cboChatLieu.setSelectedIndex(0);
        cboNsx.setSelectedIndex(0);
        cboDe.setSelectedIndex(0);
        txtGia.setText("");
        txtSoLuong.setText("");
        txtMoTa.setText("");
        ImageIcon icon = new ImageIcon();
        anhChiTiet.setIcon(icon);
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
//            ChiTietSPModel chiTietSPModel = new ChiTietSPModel();
//            chiTietSPModel.setTenDanhMuc(String.valueOf(cboDanhMuc.getSelectedItem()));
//            chiTietSPModel.setTenSanPham(String.valueOf(cboSanPham.getSelectedItem()));
//            chiTietSPModel.setTenSize(String.valueOf(cboSize.getSelectedItem()));
//            chiTietSPModel.setTenMauSac(String.valueOf(cboMauSac.getSelectedItem()));
//            chiTietSPModel.setTenChatLieu(String.valueOf(cboChatLieu.getSelectedItem()));
//            chiTietSPModel.setTenNhaSX(String.valueOf(cboNsx.getSelectedItem()));
//            chiTietSPModel.setTenDe(String.valueOf(cboDe.getSelectedItem()));
//            chiTietSPModel.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
//            chiTietSPModel.setGiaBan(Float.parseFloat(txtGia.getText()));
//            chiTietSPModel.setMoTa(String.valueOf(txtMoTa.getText()));
//            chiTietSPModel.setImageUrl(imageUrl);
//            
//            JOptionPane.showMessageDialog(this, chiTietSanPhamService.updateChiTiet(chiTietSPModel));
//            listChiTietDep = chiTietSanPhamService.getAll();
//            fillTableSanPham();
//            showImage(imageUrl);
        
    }//GEN-LAST:event_btnCapNhatActionPerformed

    private void btnAnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnhActionPerformed
        imageUrl = getImageUrl();
        showImage(imageUrl);
    }//GEN-LAST:event_btnAnhActionPerformed

    public void fillOnClickChiTiet() {
    if (listChiTietDep.isEmpty()) {
        System.out.println("List San Pham Rong");
    } else {
        int index = tblDanhSach.getSelectedRow();

        if (index >= 0 && index < listChiTietDep.size()) {
            cboDanhMuc.setSelectedItem(listChiTietDep.get(index).getIdDanhMuc());
            cboSanPham.setSelectedItem(listChiTietDep.get(index).getIdSanPham());
            cboSize.setSelectedItem(listChiTietDep.get(index).getIdSize());
            cboMauSac.setSelectedItem(listChiTietDep.get(index).getIdMauSac());
            cboChatLieu.setSelectedItem(listChiTietDep.get(index).getIdChatLieu());
            cboNsx.setSelectedItem(listChiTietDep.get(index).getIdNSX());
            cboDe.setSelectedItem(listChiTietDep.get(index).getIdDe());
            txtGia.setText(String.valueOf(listChiTietDep.get(index).getGiaBan()));
            txtSoLuong.setText(String.valueOf(listChiTietDep.get(index).getSoLuong()));
            txtMoTa.setText(listChiTietDep.get(index).getMoTa());
        } else {
            System.out.println("Chỉ số không hợp lệ: " + index);
        }
    }
}


    public String getImageUrl() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(null);
        fileChooser.setDialogTitle("Chon Anh");
        File img = fileChooser.getSelectedFile();
        System.out.println(img.getAbsolutePath());
        return img.getAbsolutePath();
    }

    public void showImage(String imageUrl) {
        if (imageUrl != null) {
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            Image image = imageIcon.getImage();
            Image newImg = image.getScaledInstance(anhChiTiet.getWidth(), anhChiTiet.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon imgAfter = new ImageIcon(newImg);
            anhChiTiet.setIcon(imgAfter);
        } else {
            System.out.println("Khong Co Anh");
            anhChiTiet.setIcon(null);
        }
    }

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
            java.util.logging.Logger.getLogger(Form_ChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form_ChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form_ChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form_ChiTiet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form_ChiTiet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anhChiTiet;
    private javax.swing.JButton btLon;
    private javax.swing.JButton btLonMax;
    private javax.swing.JButton btNho;
    private javax.swing.JButton btNhoMax;
    private javax.swing.JButton btnAnh;
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
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JRadioButton rdoDangBan;
    private javax.swing.JRadioButton rdoTamNgung;
    private javax.swing.JTable tblDanhSach;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
