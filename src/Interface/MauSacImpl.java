/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import DomainModels.MauSac;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface MauSacImpl {
    
    public ArrayList<MauSac> getAllMauSacService();
    
    public String insert(MauSac ms);
    
    public String update(String Ma,MauSac ms);
    
    public MauSac getIDByName(String mauSac);
    
    public void updateTrangThai(String idMauSac);
}
