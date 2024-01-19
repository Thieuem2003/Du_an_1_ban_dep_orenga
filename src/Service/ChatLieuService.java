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
        if (chatLieuRepository.insertChatLieu(cl)) {
            return "Them Thanh Cong";
        } else {
            return "Them That Bai";
        }
    }

    @Override
    public String update(String Ma,ChatLieu cl) {
        if (chatLieuRepository.updateChatLieu(Ma, cl)) {
            return "Sua Thanh Cong";
        }
        return "Sua That Bai";
    }

    @Override
    public ChatLieu getIDByName(String chatLieu) {
        return chatLieuRepository.getChatLieuTen(chatLieu);
    }

    @Override
    public void updateTrangThai(String idChatLieu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
