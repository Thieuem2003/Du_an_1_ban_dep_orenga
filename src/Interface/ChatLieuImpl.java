/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import DomainModels.ChatLieu;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface ChatLieuImpl {
    
    public ArrayList<ChatLieu> getAllChatLieuService();
    
    public String insert(ChatLieu cl);
    
    public String update(ChatLieu cl);
    
    public String getIDByName(String chatLieu);
    
    public void updateTrangThai(String idChatLieu);
}
