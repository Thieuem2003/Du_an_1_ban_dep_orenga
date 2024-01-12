/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import DomainModels.De;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface DeImpl {
    public ArrayList<De> getAllDeService();
    
    public String insert(De cl);
    
    public String update(De cl);
    
    public String delete(String id);
    
    public String getIDByName(String de);
    
    public void updateTrangThai(String idDe);
}
