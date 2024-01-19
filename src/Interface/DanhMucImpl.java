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
    
    public String insert(DanhMuc dm);
    
    public String update(String Ma,DanhMuc dm);
    
    public DanhMuc getIDByName(String danhMuc);
    
    public void updateTrangThai(String idDanhMuc);
}
