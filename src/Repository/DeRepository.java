/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.De;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class DeRepository {
    
    DBConnection dBConnection;
    
    public ArrayList<De> getAllDe(){
        ArrayList<De> des = new ArrayList<>();
        String sql = "select * from DE";
        try (Connection con = dBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                De cl = new De();
                cl.setIdDe(rs.getInt("Id"));
                cl.setMa(rs.getString("Ma"));
                cl.setTen(rs.getString("Ten"));
                cl.setTrangThai(rs.getInt("TrangThai"));
                des.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return des;
    }
}
