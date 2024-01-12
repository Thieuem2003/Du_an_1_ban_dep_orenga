/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModels.ChiTietDep;
import Interface.ChiTietSanPhamImpl;
import Repository.ChiTietSanPhamRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ChiTietSanPhamService {
    
    ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();

    public List<ChiTietDep> getAll(){
        try {
            return chiTietSanPhamRepository.getAllChiTiet();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
//    @Override
//    public ArrayList<ChiTietDep> getList() {
//        return chiTietSanPhamRepository.getList();
//    }
//
//    @Override
//    public String insert(ChiTietDep cl) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public String update(ChiTietDep cl) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public String delete(String id) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public String getIDByName(String chiTietDep) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public void updateTrangThai(String idChiTietDep) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public List<ChiTietDep> getChiTietDeps() {
//        List<ChiTietDep> ctds = new ArrayList<>();
//        List<ChiTietDep> chiTietDeps = chiTietSanPhamRepository.getList();
//        for (int i = 0; i < chiTietDeps.size(); i++) {
//            ChiTietDep chiTietDep = new ChiTietDep();
//            chiTietDep.setIdDanhMuc(chiTietSanPhamRepository.getTenDanhMuc));
//        }
//        return ctds;
//    }
//
//    @Override
//    public List<String> getDanhMuc() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public List<String> getSanPham() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public List<String> getChatLieu() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public List<String> getMauSac() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public List<String> getNSX() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public List<String> getDe() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
//
//    @Override
//    public List<String> getSize() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
