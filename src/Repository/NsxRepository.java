/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.NhaSanXuat;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.sql.*;

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
}
