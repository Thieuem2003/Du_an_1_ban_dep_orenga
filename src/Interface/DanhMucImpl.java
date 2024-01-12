/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import DomainModels.DanhMuc;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public interface DanhMucImpl {
    public ArrayList<DanhMuc> getAllDanhMucRepository();
    
    public String insert(DanhMuc cl);
    
    public String update(DanhMuc cl);
    
    public String delete(String id);
    
    public String getIDByName(String danhMuc);
    
    public void updateTrangThai(String idDanhMuc);
}
