/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.Size;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.sql.*;
/**
 *
 * @author ADMIN
 */
public class SizeRepository {
    
    DBConnection dBConnection;
    
    public ArrayList<Size> getLAllSize(){
        ArrayList<Size> sizes = new ArrayList<>();
        String sql = "select * from SIZE";
        try (Connection con = dBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                Size sz = new Size();
                sz.setIdSize(rs.getInt("Id"));
                sz.setMa(rs.getString("Ma"));
                sz.setKichCo(rs.getFloat("KichCo"));
                sz.setTrangThai(rs.getInt("TrangThai"));
                sizes.add(sz);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sizes;
    }
}
