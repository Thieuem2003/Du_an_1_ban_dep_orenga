/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import DomainModels.NhaSanXuat;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface NsxImpl {
    
    public ArrayList<NhaSanXuat> getList();
    
    public String insert(NhaSanXuat nsx);
    
    public String update(NhaSanXuat nsx);
    
    public String delete(String id);
    
    public String getIDByName(String nsx);
    
    public void updateTrangThai(String idNSX);
}
