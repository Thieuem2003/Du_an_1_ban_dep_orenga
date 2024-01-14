/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.SanPham;
import Utilities.DBConnection;
import Utilities.JDBCHelper;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author ADMIN
 */
public class SanPhamRepository {
    
    DBConnection dBConnection;
    
    public ArrayList<SanPham> getAllSanPham(){
        ArrayList<SanPham> sanPhams = new ArrayList<>();
        String sql = "select * from SANPHAM";
        try (Connection con = dBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                SanPham sp = new SanPham();
                sp.setIdSanPham(rs.getInt("Id"));
                sp.setMa(rs.getString("Ma"));
                sp.setTen(rs.getString("Ten"));
                sp.setTrangThai(rs.getInt("TrangThai"));
                sanPhams.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sanPhams;
    }
    
    public SanPham getSanPhamByID(String id) {

        String sql = "SELECT * FROM SANPHAM WHERE Id=?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, id);
        try {
            while (rs.next()) {
                return new SanPham(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (SQLException ex) {
            
           Logger.getLogger(ChatLieuRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
