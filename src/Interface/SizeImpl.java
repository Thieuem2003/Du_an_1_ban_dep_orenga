/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import DomainModels.Size;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface SizeImpl {
    
    public ArrayList<Size> getList();
    
    public String insert(Size sz);
    
    public String update(Size sz);
    
    public String delete(String id);
    
    public String getIDByName(String size);
    
    public void updateTrangThai(String idSize);
}
