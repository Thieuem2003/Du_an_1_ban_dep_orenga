/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import DomainModels.SanPham;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface SanPhamImpl {
    
    public ArrayList<SanPham> getAllSanPhamService();
    
    public String insert(SanPham sp);
    
    public String update(SanPham sp);
    
    public String delete(String id);
    
    public String getIDByName(String sanPham);
    
    public void updateTrangThai(String idSanPham);
}
