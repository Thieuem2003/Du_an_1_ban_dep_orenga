/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.MauSac;
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
public class MauSacRepository {
    
    DBConnection dBConnection;
    
    public ArrayList<MauSac> getAllMauSac(){
        ArrayList<MauSac> mauSacs = new ArrayList<>();
        String sql = "select * from MAUSAC";
        try (Connection con = dBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                MauSac ms = new MauSac();
                ms.setId(rs.getInt("Id"));
                ms.setMa(rs.getString("Ma"));
                ms.setMauSac(rs.getString("MauSac"));
                ms.setTrangThai(rs.getInt("TrangThai"));
                mauSacs.add(ms);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mauSacs;
    }
    
    public MauSac getMauSacID(String id) {

        String sql = "SELECT * FROM MAUSAC WHERE Id=?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, id);
        try {
            while (rs.next()) {
                return new MauSac(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (SQLException ex) {
            
           Logger.getLogger(MauSacRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
    
}
