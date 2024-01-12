/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.DanhMuc;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class DanhMucRepository {
    
    DBConnection dBConnection;
    
    public ArrayList<DanhMuc> getList() throws SQLException{
        ArrayList<DanhMuc> danhMucs = new ArrayList<>();
        String sql = "select Ma,Ten  from DANHMUC";
        Connection con = dBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                DanhMuc danhMuc = new DanhMuc();
                danhMuc.setIdDanhMuc(rs.getInt("Id"));
                danhMuc.setMa(rs.getString("Ma"));
                danhMuc.setTen(rs.getString("Ten"));
                danhMuc.setTrangThai(rs.getInt("TrangThai"));
                danhMucs.add(danhMuc);
            }
        rs.close();
        ps.close();
        con.close();
        return danhMucs;
    }
}
