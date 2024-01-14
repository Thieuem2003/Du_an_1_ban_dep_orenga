/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModels.ChatLieu;
import Interface.ChatLieuImpl;
import Repository.ChatLieuRepository;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class ChatLieuService implements ChatLieuImpl{
    
    ChatLieuRepository chatLieuRepository = new ChatLieuRepository();

    @Override
    public ArrayList<ChatLieu> getAllChatLieuService() {
        return chatLieuRepository.getAllChatLieu();
    }

    @Override
    public String insert(ChatLieu cl) {
//        try {
//            return chatLieuRepository.insert(cl);
//        } catch (SQLException ex) {
//            Logger.getLogger(ChatLieuService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
//        }
    }

    @Override
    public String update(ChatLieu cl) {
        ChatLieu chatLieu = new ChatLieu();
        chatLieu.setMa(cl.getMa());
        chatLieu.setTen(cl.getTen());
        if (chatLieuRepository.update(chatLieu)) {
            return "Sua Thanh Cong";
        }
        return "Sua That Bai";
    }

    @Override
    public String getIDByName(String chatLieu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void updateTrangThai(String idChatLieu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
