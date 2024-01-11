/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ChiTietDep;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class ChiTietSanPhamRepository {
    
    DBConnection dBConnection;
    
    public ArrayList<ChiTietDep> getList(){
        ArrayList<ChiTietDep> chiTietDeps = new ArrayList<>();
        String sql = "select * from CHITIETDEP";
        try (Connection con = dBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                ChiTietDep chiTietDep = new ChiTietDep();
                chiTietDep.setId(rs.getInt("Id"));
                chiTietDep.setIdDanhMuc(rs.getInt("IdDanhMuc"));
                chiTietDep.setIdSanPham(rs.getInt("IdSanPham"));
                chiTietDep.setIdSize(rs.getInt("IdSize"));
                chiTietDep.setIdMauSac(rs.getInt("IdMauSac"));
                chiTietDep.setIdChatLieu(rs.getInt("IdChatLieu"));
                chiTietDep.setIdNgaySX(rs.getInt("IdNSX"));
                chiTietDep.setIdDe(rs.getInt("IdDe"));
                chiTietDep.setSoLuong(rs.getInt("SoLuong"));
                chiTietDep.setGiaNhap(rs.getFloat("GiaNhap"));
                chiTietDep.setGiaBan(rs.getFloat("GiaBan"));
                chiTietDep.setMoTa(rs.getString("MoTa"));
                chiTietDep.setTrangThai(rs.getInt("TrangThai"));
                chiTietDeps.add(chiTietDep);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietDeps;
    }
    
    
    public String getTenDanhMuc(String idDanhMuc){
        String sql = "select Ten from DANHMUC where Id = ?";
        String tenDanhMuc = "";
        try (Connection con = dBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setObject(1, idDanhMuc);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                tenDanhMuc = rs.getString("Ten");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenDanhMuc;
    }
    
    public String getTenSanPham(String idSanPham){
        String sql = "select Ten from SANPHAM where Id =  ?";
        String tenSanPham = "";
        try (Connection con = dBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setObject(1, idSanPham);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                tenSanPham = rs.getString("Ten");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenSanPham;
    }
    
    public String getDoCaoDe(String idDe){
        String sql = "select Ten from DANHMUC where Id = ?";
        String doCaoDe = "";
        try (Connection con = dBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setObject(1, idDe);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                doCaoDe = rs.getString("Ten");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return doCaoDe;
    }
    
    public String getKichCoSize(String idSize){
        String sql = "select KichCo from SIZE where Id = ?";
        String kichCo = "";
        try (Connection con = dBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setObject(1, idSize);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                kichCo = rs.getString("KichCo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return kichCo;
    }
    
    public String getTenNSX(String idNsx){
        String sql = "select Ten from NSX where Id = ?";
        String nsx = "";
        try (Connection con = dBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setObject(1, idNsx);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                nsx = rs.getString("Ten");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nsx;
    }
    
    public String getTenChatLieu(String idChatLieu){
        String sql = "select Ten from CHATLIEU where Id = ?";
        String tenChatLieu = "";
        try (Connection con = dBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setObject(1, idChatLieu);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                tenChatLieu = rs.getString("KichCo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenChatLieu;
    }
    
    public String getTenMauSac(String idMauSac){
        String sql = "select Ten from CHATLIEU where Id = ?";
        String tenMauSac = "";
        try (Connection con = dBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ps.setObject(1, idMauSac);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                tenMauSac = rs.getString("KichCo");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tenMauSac;
    }
}
