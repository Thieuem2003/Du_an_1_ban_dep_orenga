/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ChatLieu;
import DomainModels.ChiTietDep;
import DomainModels.DanhMuc;
import DomainModels.De;
import DomainModels.MauSac;
import DomainModels.NhaSanXuat;
import DomainModels.SanPham;
import DomainModels.Size;
import Utilities.DBConnection;
import Utilities.JDBCHelper;
import ViewModel.ChiTietSPModel;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ChiTietSanPhamRepository {

    DBConnection dBConnection;
    SanPhamRepository spr = new SanPhamRepository();
    DanhMucRepository dmr = new DanhMucRepository();
    SizeRepository sizer = new SizeRepository();
    MauSacRepository msr = new MauSacRepository();
    ChatLieuRepository clr = new ChatLieuRepository();
    DeRepository der = new DeRepository();
    NsxRepository nsxr = new NsxRepository();

    public ArrayList<ChiTietDep> getAllChiTiet() {
        ArrayList<ChiTietDep> listctd = new ArrayList<>();
        String sql = "SELECT * FROM CHITIETDEP";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                SanPham sp = spr.getSanPhamByID(rs.getString(2));
                DanhMuc dm = dmr.getDanhMucByID(rs.getString(3));
                Size s = sizer.getSizeByID(rs.getString(4));
                MauSac ms = msr.getMauSacID(rs.getString(5));
                ChatLieu cl = clr.getChatLieuByID(rs.getString(6));
                NhaSanXuat nsx = nsxr.getNSXByID(rs.getString(7));
                De d = der.getDeByID(rs.getString(8));
                listctd.add(new ChiTietDep(rs.getInt(1), sp, dm, s, ms, cl, nsx, d, rs.getInt(9), rs.getFloat(10), rs.getFloat(11), rs.getString(12), rs.getString(13), rs.getInt(14)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listctd;
    }
    
    public ArrayList<ChiTietDep> fillChiTiet(String danhMuc) {
    String sql = "SELECT * FROM CHITIETDEP WHERE";
    ArrayList<ChiTietDep> chiTietDeps = new ArrayList<>();

    try {
        StringBuilder queryBuilder = new StringBuilder(sql);

        if (danhMuc != null && !danhMuc.isEmpty()) {
            queryBuilder.append(" IdDanhMuc = ? ");
        }
//        if (sanPham != null && !sanPham.isEmpty()) {
//            queryBuilder.append(" AND IdSanPham = ? ");
//        }
//        if (size != null && !size.isEmpty()) {
//            queryBuilder.append(" AND IdSize = ? ");
//        }
//        if (mauSac != null && !mauSac.isEmpty()) {
//            queryBuilder.append(" AND IdMauSac = ? ");
//        }
//        if (chatLieu != null && !chatLieu.isEmpty()) {
//            queryBuilder.append(" AND IdChatLieu = ? ");
//        }
//        if (nsx != null && !nsx.isEmpty()) {
//            queryBuilder.append(" AND IdNSX = ? ");
//        }
//        if (de != null && !de.isEmpty()) {
//            queryBuilder.append(" AND IdDe = ? ");
//        }

        try (PreparedStatement pstmt = dBConnection.getConnection().prepareStatement(queryBuilder.toString())) {
            int parameterIndex = 1;
            if (danhMuc != null && !danhMuc.isEmpty()) {
                pstmt.setString(parameterIndex++, danhMuc);
            }
//            if (sanPham != null && !sanPham.isEmpty()) {
//                pstmt.setString(parameterIndex++, sanPham);
//            }
//            if (size != null && !size.isEmpty()) {
//                pstmt.setString(parameterIndex++, size);
//            }
//            if (mauSac != null && !mauSac.isEmpty()) {
//                pstmt.setString(parameterIndex++, mauSac);
//            }
//            if (chatLieu != null && !chatLieu.isEmpty()) {
//                pstmt.setString(parameterIndex++, chatLieu);
//            }
//            if (nsx != null && !nsx.isEmpty()) {
//                pstmt.setString(parameterIndex++, nsx);
//            }
//            if (de != null && !de.isEmpty()) {
//                pstmt.setString(parameterIndex++, de);
//            }

            // Execute the query and process the result set
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {                
                SanPham sp = spr.getSanPhamByID(rs.getString(2));
                DanhMuc dm = dmr.getDanhMucByID(rs.getString(3));
                Size s = sizer.getSizeByID(rs.getString(4));
                MauSac ms = msr.getMauSacID(rs.getString(5));
                ChatLieu cl = clr.getChatLieuByID(rs.getString(6));
                NhaSanXuat n = nsxr.getNSXByID(rs.getString(7));
                De d = der.getDeByID(rs.getString(8));
                chiTietDeps.add(new ChiTietDep(rs.getInt(1), sp, dm, s, ms, cl, n, d, rs.getInt(9), rs.getFloat(10), rs.getFloat(11), rs.getString(12), rs.getString(13), rs.getInt(14)));
                
            }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return chiTietDeps;
}



    public ArrayList<ChiTietDep> getCTSPbyDanhMuc(String danhMuc) {
        ArrayList<ChiTietDep> list = new ArrayList<>();
        String sql = "SELECT a.Id, a.IdSanPham, a.SoLuong, a.GiaBan, a.IdDanhMuc, a.IdChatLieu, a.IdSize, a.IdNSX, a.IdDe, DanhMuc.Ten "
                + "FROM CHITIETDEP a "
                + "JOIN DANHMUC ON a.IdDanhMuc = DanhMuc.Id "
                + "WHERE DanhMuc.Ten LIKE ?";
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, "%" + danhMuc + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham sp = spr.getSanPhamByID(rs.getString(3));
                DanhMuc dm = dmr.getDanhMucByID(rs.getString(2));
                Size s = sizer.getSizeByID(rs.getString(4));
                MauSac ms = msr.getMauSacID(rs.getString(5));
                ChatLieu cl = clr.getChatLieuByID(rs.getString(6));
                NhaSanXuat nsx = nsxr.getNSXByID(rs.getString(7));
                De d = der.getDeByID(rs.getString(8));
                list.add(new ChiTietDep(rs.getInt(1), sp, dm, s, ms, cl, nsx, d, rs.getInt(9), rs.getFloat(10), rs.getFloat(11), rs.getString(12), rs.getString(13), rs.getInt(14)));

            }
            c.close();
            ps.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public boolean addChiTiet(ChiTietSPModel chiTietDep) {
        String sql = "insert into CHITIETDEP (IdDanhMuc,IdSanPham,IdSize,IdMauSac,\n"
                + "IdChatLieu,IdNSX,IdDe,SoLuong,GiaBan,MoTa,TrangThai) values \n"
                + " (?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(2, chiTietDep.getTenDanhMuc().getIdDanhMuc());
            ps.setObject(1, chiTietDep.getTenSanPham().getIdSanPham());
            ps.setObject(3, chiTietDep.getTenSize().getIdSize());
            ps.setObject(4, chiTietDep.getTenMauSac().getId());
            ps.setObject(5, chiTietDep.getTenChatLieu().getId());
            ps.setObject(6, chiTietDep.getTenNhaSX().getId());
            ps.setObject(7, chiTietDep.getTenDe().getIdDe());
            ps.setObject(8, chiTietDep.getSoLuong());
            ps.setObject(9, chiTietDep.getGiaBan());
            ps.setObject(10, chiTietDep.getMoTa());
            ps.setObject(11, chiTietDep.getTrangThai());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean addChiTietSanPham(ChiTietSPModel chiTietDep) {
        String sql = "insert into CHITIETDEP (IdSanPham,IdDanhMuc,GiaBan,MoTa,HinhAnh,TrangThai) values \n"
                + " (?,?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, chiTietDep.getTenSanPham().getIdSanPham());
            ps.setObject(2, chiTietDep.getTenDanhMuc().getIdDanhMuc());
            ps.setObject(3, chiTietDep.getGiaBan());
            ps.setObject(4, chiTietDep.getMoTa());
            ps.setObject(5, chiTietDep.getTrangThai());
            ps.setObject(6, chiTietDep.getImageUrl());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateChiTiet(ChiTietSPModel chiTietDep) {
        String sql = "update CHITIETDEP set IdDanhMuc = ? , IdSanPham = ? , IdSize = ? , IdMauSac = ?,\n"
                + "IdChatLieu = ? , IdNSX = ? ,IdDe = ?,SoLuong = ?,GiaBan = ?,MoTa = ?,TrangThai = ? where Id = ?";
        try (Connection con = DBConnection.getConnection()) {
            CallableStatement ps = con.prepareCall(sql);

            ps.setObject(2, chiTietDep.getTenDanhMuc().getIdDanhMuc());
            ps.setObject(1, chiTietDep.getTenSanPham().getIdSanPham());
            ps.setObject(3, chiTietDep.getTenSize().getIdSize());
            ps.setObject(4, chiTietDep.getTenMauSac().getId());
            ps.setObject(5, chiTietDep.getTenChatLieu().getId());
            ps.setObject(6, chiTietDep.getTenNhaSX().getId());
            ps.setObject(7, chiTietDep.getTenDe().getIdDe());
            ps.setObject(8, chiTietDep.getSoLuong());
            ps.setObject(9, chiTietDep.getGiaBan());
            ps.setObject(10, chiTietDep.getMoTa());
            ps.setObject(11, chiTietDep.getTrangThai());
            ps.setObject(12, chiTietDep.getId());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<ChiTietDep> getAllHoaDonSP() {
        ArrayList<ChiTietDep> listctd = new ArrayList<>();
        String sql = "SELECT * FROM CHITIETDEP";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                SanPham sp = spr.getSanPhamByID(rs.getString(3));
                DanhMuc dm = dmr.getDanhMucByID(rs.getString(2));
                Size s = sizer.getSizeByID(rs.getString(4));
                MauSac ms = msr.getMauSacID(rs.getString(5));
                ChatLieu cl = clr.getChatLieuByID(rs.getString(6));
                NhaSanXuat nsx = nsxr.getNSXByID(rs.getString(7));
                De d = der.getDeByID(rs.getString(8));
                listctd.add(new ChiTietDep(rs.getInt(1), sp, dm, s, ms, cl, nsx, d, rs.getInt(9), rs.getFloat(10), rs.getFloat(11), rs.getString(12), rs.getString(13), rs.getInt(14)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listctd;
    }

    public ArrayList<ChiTietDep> getAllSanPham() {
        ArrayList<ChiTietDep> listctd = new ArrayList<>();
        String sql = "SELECT * FROM CHITIETDEP";
        ResultSet rs = JDBCHelper.excuteQuery(sql);
        try {
            while (rs.next()) {
                SanPham sp = spr.getSanPhamByID(rs.getString(3));
                DanhMuc dm = dmr.getDanhMucByID(rs.getString(2));
                Size s = sizer.getSizeByID(rs.getString(4));
                MauSac ms = msr.getMauSacID(rs.getString(5));
                ChatLieu cl = clr.getChatLieuByID(rs.getString(6));
                NhaSanXuat nsx = nsxr.getNSXByID(rs.getString(7));
                De d = der.getDeByID(rs.getString(8));
                listctd.add(new ChiTietDep(rs.getInt(1), sp, dm, s, ms, cl, nsx, d, rs.getInt(9), rs.getFloat(10), rs.getFloat(11), rs.getString(12), rs.getString(13), rs.getInt(14)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listctd;
    }

    public ArrayList<ChiTietDep> getCTSPbyChatLieu(String chatLieu) {
        ArrayList<ChiTietDep> list = new ArrayList<>();
        String sql = "SELECT a.Id, a.IdSanPham, a.SoLuong, a.GiaBan, a.IdDanhMuc, a.IdChatLieu, a.Size,a.IdHang,a.IdDe , CHATLIEU.Ten "
                + "from CHITIETDEP as join CHATLIEU.Id = a.CHATLIEU "
                + "where Ten like ?";
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, "%" + chatLieu + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham sp = spr.getSanPhamByID(rs.getString(3));
                DanhMuc dm = dmr.getDanhMucByID(rs.getString(2));
                Size s = sizer.getSizeByID(rs.getString(4));
                MauSac ms = msr.getMauSacID(rs.getString(5));
                ChatLieu cl = clr.getChatLieuByID(rs.getString(6));
                NhaSanXuat nsx = nsxr.getNSXByID(rs.getString(7));
                De d = der.getDeByID(rs.getString(8));
                list.add(new ChiTietDep(rs.getInt(1), sp, dm, s, ms, cl, nsx, d, rs.getInt(9), rs.getFloat(10), rs.getFloat(11), rs.getString(12), rs.getString(13), rs.getInt(14)));

            }
            c.close();
            ps.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public ArrayList<ChiTietDep> getCTSPbyMauSac(String mauSac) {
        ArrayList<ChiTietDep> list = new ArrayList<>();
        String sql = "SELECT a.Id, a.IdSanPham, a.SoLuong, a.GiaBan, a.IdDanhMuc, a.IdChatLieu, a.Size,a.IdHang,a.IdDe , MAUSAC.Ten "
                + "from CHITIETDEP as join MAUSAC.Id = a.MAUSAC "
                + "where Ten like ?";
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, "%" + mauSac + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham sp = spr.getSanPhamByID(rs.getString(3));
                DanhMuc dm = dmr.getDanhMucByID(rs.getString(2));
                Size s = sizer.getSizeByID(rs.getString(4));
                MauSac ms = msr.getMauSacID(rs.getString(5));
                ChatLieu cl = clr.getChatLieuByID(rs.getString(6));
                NhaSanXuat nsx = nsxr.getNSXByID(rs.getString(7));
                De d = der.getDeByID(rs.getString(8));
                list.add(new ChiTietDep(rs.getInt(1), sp, dm, s, ms, cl, nsx, d, rs.getInt(9), rs.getFloat(10), rs.getFloat(11), rs.getString(12), rs.getString(13), rs.getInt(14)));

            }
            c.close();
            ps.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public ArrayList<ChiTietDep> getCTSPbySIZE(String size) {
        ArrayList<ChiTietDep> list = new ArrayList<>();
        String sql = "SELECT a.Id, a.IdSanPham, a.SoLuong, a.GiaBan, a.IdDanhMuc, a.IdChatLieu, a.Size,a.IdHang,a.IdDe , SIZE.Ten "
                + "from CHITIETDEP as join SIZE.Id = a.SIZE "
                + "where Ten like ?";
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, "%" + size + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham sp = spr.getSanPhamByID(rs.getString(3));
                DanhMuc dm = dmr.getDanhMucByID(rs.getString(2));
                Size s = sizer.getSizeByID(rs.getString(4));
                MauSac ms = msr.getMauSacID(rs.getString(5));
                ChatLieu cl = clr.getChatLieuByID(rs.getString(6));
                NhaSanXuat nsx = nsxr.getNSXByID(rs.getString(7));
                De d = der.getDeByID(rs.getString(8));
                list.add(new ChiTietDep(rs.getInt(1), sp, dm, s, ms, cl, nsx, d, rs.getInt(9), rs.getFloat(10), rs.getFloat(11), rs.getString(12), rs.getString(13), rs.getInt(14)));

            }
            c.close();
            ps.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public ArrayList<ChiTietDep> getCTSPbyNSX(String nsx1) {
        ArrayList<ChiTietDep> list = new ArrayList<>();
        String sql = "SELECT a.Id, a.IdSanPham, a.SoLuong, a.GiaBan, a.IdDanhMuc, a.IdChatLieu, a.Size,a.IdHang,a.IdDe , NSX.Ten "
                + "from CHITIETDEP as join NSX.Id = a.NSX "
                + "where Ten like ?";
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, "%" + nsx1 + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham sp = spr.getSanPhamByID(rs.getString(3));
                DanhMuc dm = dmr.getDanhMucByID(rs.getString(2));
                Size s = sizer.getSizeByID(rs.getString(4));
                MauSac ms = msr.getMauSacID(rs.getString(5));
                ChatLieu cl = clr.getChatLieuByID(rs.getString(6));
                NhaSanXuat nsx = nsxr.getNSXByID(rs.getString(7));
                De d = der.getDeByID(rs.getString(8));
                list.add(new ChiTietDep(rs.getInt(1), sp, dm, s, ms, cl, nsx, d, rs.getInt(9), rs.getFloat(10), rs.getFloat(11), rs.getString(12), rs.getString(13), rs.getInt(14)));

            }
            c.close();
            ps.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public ArrayList<ChiTietDep> getCTSPbyDe(String de) {
        ArrayList<ChiTietDep> list = new ArrayList<>();
        String sql = "SELECT a.Id, a.IdSanPham, a.SoLuong, a.GiaBan, a.IdDanhMuc, a.IdChatLieu, a.Size,a.IdHang,a.IdDe , DE.Ten "
                + "from CHITIETDEP as join DE.Id = a.DE "
                + "where Ten like ?";
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, "%" + de + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham sp = spr.getSanPhamByID(rs.getString(3));
                DanhMuc dm = dmr.getDanhMucByID(rs.getString(2));
                Size s = sizer.getSizeByID(rs.getString(4));
                MauSac ms = msr.getMauSacID(rs.getString(5));
                ChatLieu cl = clr.getChatLieuByID(rs.getString(6));
                NhaSanXuat nsx = nsxr.getNSXByID(rs.getString(7));
                De d = der.getDeByID(rs.getString(8));
                list.add(new ChiTietDep(rs.getInt(1), sp, dm, s, ms, cl, nsx, d, rs.getInt(9), rs.getFloat(10), rs.getFloat(11), rs.getString(12), rs.getString(13), rs.getInt(14)));

            }
            c.close();
            ps.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public ArrayList<ChiTietDep> getCTSPbySanPham(String sp) {
        ArrayList<ChiTietDep> list = new ArrayList<>();
        String sql = "SELECT a.Id, a.IdSanPham, a.SoLuong, a.GiaBan, a.IdDanhMuc, a.IdChatLieu, a.Size,a.IdHang,a.IdDe , SANPHAM.Ten "
                + "from CHITIETDEP as join SANPHAM.Id = a.SANPHAM "
                + "where Ten like ?";
        try {
            Connection c = DBConnection.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);

            ps.setString(1, "%" + sp + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                SanPham sp1 = spr.getSanPhamByID(rs.getString(3));
                DanhMuc dm = dmr.getDanhMucByID(rs.getString(2));
                Size s = sizer.getSizeByID(rs.getString(4));
                MauSac ms = msr.getMauSacID(rs.getString(5));
                ChatLieu cl = clr.getChatLieuByID(rs.getString(6));
                NhaSanXuat nsx = nsxr.getNSXByID(rs.getString(7));
                De d = der.getDeByID(rs.getString(8));
                list.add(new ChiTietDep(rs.getInt(1), sp1, dm, s, ms, cl, nsx, d, rs.getInt(9), rs.getFloat(10), rs.getFloat(11), rs.getString(12), rs.getString(13), rs.getInt(14)));

            }
            c.close();
            ps.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }
    public String getIDDanhMuc(String tenDanhMuc) {
        String sql = "SELECT Id from DANHMUC WHERE Ten = ?";
        String idDanhMuc = "";
        try (Connection conn = DBConnection.getConnection(); 
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, tenDanhMuc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idDanhMuc = rs.getString("Id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idDanhMuc;
    }
    
    public List<String> getDanhMuc() {
        List<String> lstDanhMuc = new ArrayList<>();
        String sql = "select * from DANHMUC where TrangThai = 1";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstDanhMuc.add(rs.getString("Ten"));
            }
            return lstDanhMuc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getSanPham() {
        List<String> lstDanhMuc = new ArrayList<>();
        String sql = "select * from SANPHAM where TrangThai = 1";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstDanhMuc.add(rs.getString("Ten"));
            }
            return lstDanhMuc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getChatLieu() {
        List<String> lstDanhMuc = new ArrayList<>();
        String sql = "select * from CHATLIEU where TrangThai = 1";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstDanhMuc.add(rs.getString("Ten"));
            }
            return lstDanhMuc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getMauSac() {
        List<String> lstDanhMuc = new ArrayList<>();
        String sql = "select * from MAUSAC where TrangThai = 1";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstDanhMuc.add(rs.getString("MauSac"));
            }
            return lstDanhMuc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getSize() {
        List<String> lstDanhMuc = new ArrayList<>();
        String sql = "select * from SIZE where TrangThai = 1";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstDanhMuc.add(rs.getString("KichCo"));
            }
            return lstDanhMuc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getNSX() {
        List<String> lstDanhMuc = new ArrayList<>();
        String sql = "select * from NSX where TrangThai = 1";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstDanhMuc.add(rs.getString("Ten"));
            }
            return lstDanhMuc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> getDe() {
        List<String> lstDanhMuc = new ArrayList<>();
        String sql = "select * from DE where TrangThai = 1";
        try (Connection conn = DBConnection.getConnection()) {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lstDanhMuc.add(rs.getString("Ten"));
            }
            return lstDanhMuc;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String getDanhMucByID(String id) {

        String sql = "SELECT Ten FROM DANHMUC WHERE Id=?";
        String tenDanhMuc = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenDanhMuc = rs.getString("Ten");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenDanhMuc;
    }
    
    public String getSanPhamByID(String id) {

        String sql = "SELECT Ten FROM SANPHAM WHERE Id=?";
        String tenSanPham = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenSanPham = rs.getString("Ten");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenSanPham;
    }
    
    public String getSizeByID(String id) {

        String sql = "SELECT KichCo FROM SIZE WHERE Id=?";
        String kichCo = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                kichCo = rs.getString("KichCo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kichCo;
    }
    
    public String getMauSacID(String id) {

        String sql = "SELECT MauSac FROM MAUSAC WHERE Id=?";
        String mauSac = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                mauSac = rs.getString("MauSac");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mauSac;
    }
    
    public String getChatLieuByID(String id) {

        String sql = "SELECT Ten FROM ChatLieu WHERE Id=?";
        String tenChatLieu = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenChatLieu = rs.getString("Ten");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenChatLieu;
    }
    
    public String getDeByID(String id) {

        String sql = "SELECT Ten FROM DE WHERE Id=?";
        String tenDe = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenDe = rs.getString("Ten");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenDe;
    }
    
    public String getNSXByID(String id) {

        String sql = "SELECT Ten FROM NSX WHERE Id=?";
        String tenNsx = "";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tenNsx = rs.getString("Ten");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenNsx;
    }
}
