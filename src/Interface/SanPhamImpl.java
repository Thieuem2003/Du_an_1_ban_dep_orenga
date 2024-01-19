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
    
    public SanPham getSanPhamMa(String ma);
    
    public SanPham getIDByName(String sanPham);
    
    public void updateTrangThai(String idSanPham);
}
