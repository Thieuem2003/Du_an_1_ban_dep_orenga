/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.KhachHang;

import Utilities.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author UyTin
 */
public class KhachHangRepository {

    public ArrayList<KhachHang> getList() {
        ArrayList<KhachHang> lstkh = new ArrayList<>();
        String sql = "Select Ma, Ten, NgaySinh, GioiTinh, Sdt, Email, DiaChi, TrangThai from KHACHHANG";

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();

                kh.setMa(rs.getString("Ma"));
                kh.setTen(rs.getString("Ten"));
                kh.setNgaySinh(rs.getDate("NgaySinh"));
                kh.setGioiTinh(rs.getInt("GioiTinh"));
                kh.setSdt(rs.getString("Sdt"));
                kh.setEmail(rs.getString("Email"));
                kh.setDiaChi(rs.getString("DiaChi"));
                kh.setTrangThai(rs.getInt("TrangThai"));

                lstkh.add(kh);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return lstkh;
    }

    public boolean addNew(KhachHang khachHang) {

        String sql = "INSERT INTO KHACHHANG (Ma, Ten, NgaySinh, GioiTinh, Sdt, Email, DiaChi, TrangThai)\n"
                + "VALUES(?,?,?,?,?,?,?,?)";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {// PreparedStatement là 1 đối tượng biểu diễn 1 lệnh sql đc biên dịch trước
            ps.setObject(1, khachHang.getMa());
            ps.setObject(2, khachHang.getTen());
            ps.setObject(3, khachHang.getNgaySinh());
            ps.setObject(4, khachHang.getGioiTinh());
            ps.setObject(5, khachHang.getSdt());

            ps.setObject(6, khachHang.getEmail());
            ps.setObject(7, khachHang.getDiaChi());

            ps.setObject(8, khachHang.getTrangThai());

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
     public boolean upDateKH(String Ma, KhachHang khachHang) {

        String sql = "update KhachHang set  Ten = ?, NgaySinh = ?, "
                + "GioiTinh = ?, Sdt = ?, Email = ?, DiaChi = ?, TrangThai = ? where Ma = ?";
        try (Connection con = DBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {// PreparedStatement là 1 đối tượng biểu diễn 1 lệnh sql đc biên dịch trước
           
            ps.setObject(1, khachHang.getTen());
            ps.setObject(2, khachHang.getNgaySinh());
            ps.setObject(3, khachHang.getGioiTinh());
            ps.setObject(4, khachHang.getSdt());

            ps.setObject(5, khachHang.getEmail());
            ps.setObject(6, khachHang.getDiaChi());

            ps.setObject(7, khachHang.getTrangThai());
            
             ps.setObject(8, Ma);

            int result = ps.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
