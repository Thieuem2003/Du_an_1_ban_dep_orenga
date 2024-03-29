/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModels.SanPham;
import Interface.SanPhamImpl;
import Repository.SanPhamRepository;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class SanPhamService implements SanPhamImpl{
    
    SanPhamRepository sanPhamRepository = new SanPhamRepository();

    @Override
    public ArrayList<SanPham> getAllSanPhamService() {
        return sanPhamRepository.getAllSanPham();
    }

    @Override
    public String insert(SanPham sp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String update(SanPham sp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SanPham getSanPhamMa(String ma) {
        return sanPhamRepository.getSanPhamMa(ma);
    }

    @Override
    public SanPham getIDByName(String sanPham) {
        return sanPhamRepository.getSanPhamTen(sanPham);
    }

    @Override
    public void updateTrangThai(String idSanPham) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
