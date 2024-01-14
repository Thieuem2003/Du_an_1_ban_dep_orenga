/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.NhaSanXuat;
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
public class NsxRepository {
    
    DBConnection dBConnection;
    
    public ArrayList<NhaSanXuat> getAllNsx(){
        ArrayList<NhaSanXuat> nhaSanXuats = new ArrayList<>();
        String sql = "select * from NSX";
        try (Connection con = dBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                NhaSanXuat nsx = new NhaSanXuat();
                nsx.setId(rs.getInt("Id"));
                nsx.setMa(rs.getString("Ma"));
                nsx.setTen(rs.getString("Ten"));
                nsx.setTrangThai(rs.getInt("TrangThai"));
                nhaSanXuats.add(nsx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhaSanXuats;
    }
    
    public NhaSanXuat getNSXByID(String id) {

        String sql = "SELECT * FROM NSX WHERE Id=?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, id);
        try {
            while (rs.next()) {
                return new NhaSanXuat(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException ex) {
            
           Logger.getLogger(MauSacRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
