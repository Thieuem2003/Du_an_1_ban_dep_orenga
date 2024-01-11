/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.MauSac;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class MauSacRepository {
    
    DBConnection dBConnection;
    
    public ArrayList<MauSac> getList(){
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
}
