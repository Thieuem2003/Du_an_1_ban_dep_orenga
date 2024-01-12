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
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class ChiTietSanPhamRepository {
    
    DBConnection dBConnection;
    
//    public ArrayList<ChiTietDep> getAll() throws SQLException{
//        ArrayList<ChiTietDep> chiTietDeps = new ArrayList<>();
//        Connection con = dBConnection.getConnection();
//        String sql = "SELECT\n" +
//"    CHITIETDEP.Id,\n" +
//"    DANHMUC.Ten,\n" +
//"    SANPHAM.Ten,\n" +
//"    SIZE.KichCo,\n" +
//"    MAUSAC.MauSac,\n" +
//"    CHATLIEU.Ten,\n" +
//"    NSX.Ten ,\n" +
//"    DE.Ten,\n" +
//"    CHITIETDEP.SoLuong,\n" +
//"    CHITIETDEP.GiaNhap,\n" +
//"    CHITIETDEP.GiaBan,\n" +
//"    CHITIETDEP.MoTa,\n" +
//"    CHITIETDEP.TrangThai\n" +
//"FROM CHITIETDEP\n" +
//"JOIN DANHMUC ON CHITIETDEP.IdDanhMuc = DANHMUC.Id\n" +
//"JOIN SANPHAM ON CHITIETDEP.IdSanPham = SANPHAM.Id\n" +
//"JOIN SIZE ON CHITIETDEP.IdSize = SIZE.Id\n" +
//"JOIN MAUSAC ON CHITIETDEP.IdMauSac = MAUSAC.Id\n" +
//"JOIN CHATLIEU ON CHITIETDEP.IdChatLieu = CHATLIEU.Id\n" +
//"JOIN NSX ON CHITIETDEP.IdNSX = NSX.Id\n" +
//"JOIN DE ON CHITIETDEP.IdDe = DE.Id;";
//        PreparedStatement ps = con.prepareStatement(sql);
//        ResultSet rs = ps.executeQuery();
//            while (rs.next()) {        
//                Integer danhMuc1 = rs.getInt("IdDanhMuc");
//                Integer sanPham1 = rs.getInt("IdSanPham");
//                Integer size1 = rs.getInt("IdSize");
//                Integer mauSac1 = rs.getInt("IdMauSac");
//                Integer chatLieu1 = rs.getInt("IdChatLieu");
//                Integer NSX1 = rs.getInt("IdNSX");
//                Integer De1 = rs.getInt("IdDe");
//                Integer soLuong = rs.getInt("SoLuong");
//                Float giaNhap = rs.getFloat("GiaNhap");
//                Float giaBan = rs.getFloat("GiaBan");
//                String moTa = rs.getString("MoTa");
//                Integer trangThai = rs.getInt("TrangThai");
//                
//                DanhMuc danhMuc = new DanhMuc();
//                danhMuc.setIdDanhMuc(danhMuc1);
////                danhMuc.setTen(rs.getString("DanhMucTen"));
//
//                SanPham sanPham = new SanPham();
//                sanPham.setIdSanPham(sanPham1);
////                sanPham.setTen(rs.getString("SanPhamTen"));
//
//                Size size = new Size();
//                size.setKichCo(rs.getFloat(size1));
//
//                MauSac mauSac = new MauSac();
//                mauSac.setId(mauSac1);
////                mauSac.setMauSac(rs.getString("MauSac"));
//
//                ChatLieu chatLieu = new ChatLieu();
//                chatLieu.setId(chatLieu1);
////                chatLieu.setTen(rs.getString("ChatLieuTen"));
//
//                NhaSanXuat nhaSanXuat = new NhaSanXuat();
//                nhaSanXuat.setId(NSX1);
////                nhaSanXuat.setTen(rs.getString("NhaSanXuatTen"));
//
//                De de = new De();
//                de.setIdDe(De1);
////                de.setTen(rs.getString("DonViTinh"));
//
//                // Creating ChiTietDep object and adding to the list
//                ChiTietDep chiTietDep = new ChiTietDep();
//                chiTietDep.setId(rs.getInt("Id"));
//                chiTietDep.setIdDanhMuc(danhMuc);
//                chiTietDep.setIdSanPham(sanPham);
//                chiTietDep.setIdSize(size);
//                chiTietDep.setIdMauSac(mauSac);
//                chiTietDep.setIdChatLieu(chatLieu);
//                chiTietDep.setIdNSX(nhaSanXuat);
//                chiTietDep.setIdDe(de);
//                chiTietDep.setSoLuong(soLuong);
//                chiTietDep.setGiaNhap(giaNhap);
//                chiTietDep.setGiaBan(giaBan);
//                chiTietDep.setMoTa(moTa);
//                chiTietDep.setTrangThai(trangThai);
//
//                chiTietDeps.add(chiTietDep);
//            }
//        
//        return chiTietDeps;
//    }
    
    public ArrayList<ChiTietDep> getAll(){
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
                chiTietDep.setIdNSX(rs.getInt("IdNSX"));
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
