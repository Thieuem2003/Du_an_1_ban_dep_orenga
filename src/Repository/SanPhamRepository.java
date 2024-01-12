/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.SanPham;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author ADMIN
 */
public class SanPhamRepository {
    
    DBConnection dBConnection;
    
    public ArrayList<SanPham> getList(){
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
}
