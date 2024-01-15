/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Repository;

import DomainModels.KhuyenMai;
import Interface.KhuyenMaiRepositoryImpl;
import Utilities.DBConnection;
import java.util.ArrayList;
import java.sql.*;


public class KhuyenMaiRepository implements KhuyenMaiRepositoryImpl{
    
    DBConnection cdao = new DBConnection();
    
    @Override
    public ArrayList<KhuyenMai> getAllKM() {
        ArrayList<KhuyenMai> dskm= new ArrayList<>();
        String sql ="Select Ma, Ten, PhanTramGiam, SoLuong, NgayBatDau, NgayKetThuc, TrangThai, MoTa from KHUYENMAI";
        try {
            Connection con= cdao.getConnection();
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while (rs.next()) {                
                dskm.add(new KhuyenMai(rs.getString(1),
                        rs.getString(2),
                        rs.getFloat(3),
                        rs.getInt(4),
                        rs.getDate(5),
                        rs.getDate(6),
                        rs.getInt(7),
                        rs.getString(8)));
            }
        } catch (Exception e) {
            System.out.println("Lỗi GetAll KhuyenMai!");
        }
        return dskm;
    }
    
   
}
