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

    public ArrayList<ChatLieu> getAllChatLieu() {
        ArrayList<ChatLieu> chatLieus = new ArrayList<>();
        String sql = "select * from CHATLIEU";
        try (Connection con = dBConnection.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
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
    
    public ChatLieu getChatLieuTen(String ten) {

        String sql = "SELECT * FROM ChatLieu WHERE Ten =?";
        ResultSet rs = JDBCHelper.excuteQuery(sql, ten);
        try {
            while (rs.next()) {
                return new ChatLieu(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }
        } catch (SQLException ex) {

            Logger.getLogger(ChatLieuRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public boolean insertChatLieu(ChatLieu chatLieu) {
        String sql = "insert into CHATLIEU (Ma , Ten) values (?,?)";
        try (Connection connection = dBConnection.getConnection(); PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setObject(1, chatLieu.getMa());
            ps.setObject(2, chatLieu.getTen());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException ex) {
           Logger.getLogger(ChatLieuRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateChatLieu(String Ma, ChatLieu chatLieu) {
        try {
            Connection connection = dBConnection.getConnection();
            String sql = "update CHATLIEU set Ten = ? where Ma = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setObject(1, chatLieu.getTen());
            ps.setObject(2, chatLieu.getMa());
            
            ps.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ChatLieuRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
