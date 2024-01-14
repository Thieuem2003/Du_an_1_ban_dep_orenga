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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.*;
import java.util.List;

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
                SanPham sp = spr.getSanPhamByID(rs.getString(3));
                DanhMuc dm = dmr.getDanhMucByID(rs.getString(2));
                Size s = sizer.getSizeByID(rs.getString(4));
                MauSac ms = msr.getMauSacID(rs.getString(5));
                ChatLieu cl = clr.getChatLieuByID(rs.getString(6));
                NhaSanXuat nsx = nsxr.getNSXByID(rs.getString(7));
                De d = der.getDeByID(rs.getString(8));
                listctd.add(new ChiTietDep(rs.getInt(1), dm, sp, s, ms, cl, nsx, d, rs.getInt(9), rs.getFloat(10), rs.getFloat(11), rs.getString(12), rs.getString(13), rs.getInt(14)));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listctd;
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
                list.add(new ChiTietDep(rs.getInt(1), dm, sp, s, ms, cl, nsx, d, rs.getInt(9), rs.getFloat(10), rs.getFloat(11), rs.getString(12), rs.getString(13), rs.getInt(14)));

            }
            c.close();
            ps.close();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

    public boolean addChiTiet(ChiTietDep chiTietDep) {
        String sql = "insert into CHITIETDEP (IdDanhMuc,IdSanPham,IdSize,IdMauSac,\n"
                + "IdChatLieu,IdNSX,IdDe,SoLuong,GiaBan,MoTa,HinhAnh,TrangThai) values \n"
                + " (?,?,?,?,?,?,?,?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setObject(1, chiTietDep.getIdDanhMuc());
            ps.setObject(2, chiTietDep.getIdSanPham());
            ps.setObject(3, chiTietDep.getIdSize());
            ps.setObject(4, chiTietDep.getIdMauSac());
            ps.setObject(5, chiTietDep.getIdChatLieu());
            ps.setObject(6, chiTietDep.getIdNSX());
            ps.setObject(7, chiTietDep.getIdDe());
            ps.setObject(8, chiTietDep.getSoLuong());
            ps.setObject(9, chiTietDep.getGiaBan());
            ps.setObject(10, chiTietDep.getMoTa());
            ps.setObject(11, chiTietDep.getHinhAnh());
            ps.setObject(12, chiTietDep.getTrangThai());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateChiTiet(ChiTietDep chiTietDep) {
        String sql = "{CALL updateCHITIETDEP (?,?,?,?,?,?,?,?,?,?,?,?)}";
        try (Connection con = DBConnection.getConnection()) {
            CallableStatement ps = con.prepareCall(sql);

            ps.setObject(1, chiTietDep.getIdDanhMuc());
            ps.setObject(2, chiTietDep.getIdSanPham());
            ps.setObject(3, chiTietDep.getIdSize());
            ps.setObject(4, chiTietDep.getIdMauSac());
            ps.setObject(5, chiTietDep.getIdChatLieu());
            ps.setObject(6, chiTietDep.getIdNSX());
            ps.setObject(7, chiTietDep.getIdDe());
            ps.setObject(8, chiTietDep.getSoLuong());
            ps.setObject(9, chiTietDep.getGiaBan());
            ps.setObject(10, chiTietDep.getMoTa());
            ps.setObject(11, chiTietDep.getHinhAnh());
            ps.setObject(12, chiTietDep.getTrangThai());

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
       ResultSet rs  = JDBCHelper.excuteQuery(sql);
        try {
            while(rs.next()){
                SanPham sp = spr.getSanPhamByID(rs.getString(3));
                DanhMuc dm = dmr.getDanhMucByID(rs.getString(2));
                Size s = sizer.getSizeByID(rs.getString(4));
                MauSac ms = msr.getMauSacID(rs.getString(5));
                ChatLieu cl = clr.getChatLieuByID(rs.getString(6));
                NhaSanXuat nsx = nsxr.getNSXByID(rs.getString(7));
                De d = der.getDeByID(rs.getString(8));
                listctd.add(new ChiTietDep(rs.getInt(1), dm, sp, s, ms, cl, nsx, d, rs.getInt(9), rs.getFloat(10), rs.getFloat(11), rs.getString(12),rs.getString(13), rs.getInt(14)));
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  listctd;
    }

    public ArrayList<ChiTietDep> getCTSPbyMauSac(String mauSac) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<ChiTietDep> getCTSPbySIZE(String size) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ArrayList<ChiTietDep> getCTSPbyNSX(String nsx) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
