/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.ChatLieu;
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
    
    public ChatLieu getChatLieuByID(String id) {

        String sql = "SELECT * FROM ChatLieu WHERE Id=?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, id);
        try {
            while (rs.next()) {
                return new ChatLieu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (SQLException ex) {
            
           Logger.getLogger(ChatLieuRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Integer insert(ChatLieu chatLieu) throws SQLException{
        Integer ketQua = -1;
        Connection connection = dBConnection.getConnection();
        String sql = "insert into CHATLIEU (Ma , Ten) values (?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, chatLieu.getMa().trim());
        ps.setString(2, chatLieu.getTen());
        ketQua = ps.executeUpdate();
        ps.close();
        connection.close();
        return ketQua;
    }
    
    public boolean update(ChatLieu chatLieu){
        String sql = "{Call update CHATLIEU (?,?,?,?)}";
        try (Connection connection = dBConnection.getConnection();){
            System.out.println(chatLieu.getId());
            CallableStatement cs = connection.prepareCall(sql);
            cs.setObject(1, chatLieu.getId());
            cs.setObject(2, chatLieu.getMa());
            cs.setObject(3, chatLieu.getTen());
            cs.setObject(4, chatLieu.getTrangThai());
            
            int result = cs.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
