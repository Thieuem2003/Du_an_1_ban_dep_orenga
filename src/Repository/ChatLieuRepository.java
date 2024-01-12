/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ChatLieu;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author ADMIN
 */
public class ChatLieuRepository {
    
    DBConnection dBConnection;
    
    public ArrayList<ChatLieu> getAllChatLieu(){
        ArrayList<ChatLieu> chatLieus = new ArrayList<>();
        String sql = "select * from CHATLIEU";
        try (Connection con = dBConnection.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)){
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                ChatLieu cl = new ChatLieu();
                cl.setId(rs.getInt("Id"));
                cl.setMa(rs.getString("Ma"));
                cl.setTen(rs.getString("Ten"));
                cl.setTrangThai(rs.getInt("TrangThai"));
                chatLieus.add(cl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chatLieus;
    }
    
}
