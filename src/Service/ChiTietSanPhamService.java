/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModels.ChiTietDep;
import Interface.ChiTietSanPhamImpl;
import Repository.ChatLieuRepository;
import Repository.ChiTietSanPhamRepository;
import Repository.DanhMucRepository;
import Repository.DeRepository;
import Repository.MauSacRepository;
import Repository.NsxRepository;
import Repository.SanPhamRepository;
import Repository.SizeRepository;
import ViewModel.ChiTietSPModel;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 *
 * @author ADMIN
 */
public class ChiTietSanPhamService {

    ChiTietSanPhamRepository chiTietSanPhamRepository = new ChiTietSanPhamRepository();

    public List<ChiTietDep> getAll() {
        try {
            return chiTietSanPhamRepository.getAllChiTiet();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<ChiTietDep> fillChiTiet(String danhMuc) {
        try {
            return chiTietSanPhamRepository.fillChiTiet(danhMuc);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String insertChiTiet(ChiTietSPModel ctd) {
        if (chiTietSanPhamRepository.addChiTiet(ctd)) {
            return "Them Thanh Cong";
        } else {
            return "Them That Bai";
        }
    }

    public String insertChiTietSanPham(ChiTietSPModel ctd) {
        if (chiTietSanPhamRepository.addChiTietSanPham(ctd)) {
            return "Them Thanh Cong";
        } else {
            return "Them That Bai";
        }
    }

    public String updateChiTiet(ChiTietSPModel ctd) {
        if (chiTietSanPhamRepository.updateChiTiet(ctd)) {
            return "Sua Thanh Cong";
        } else {
            return "Sua That Bai";
        }
    }

    public List<ChiTietDep> getAllHdSp() {
        return this.chiTietSanPhamRepository.getAllHoaDonSP();
    }

    public List<ChiTietDep> getAllSanPham() {
        return this.chiTietSanPhamRepository.getAllSanPham();
    }

    public ArrayList<ChiTietDep> getCTSPByDanhMuc(String danhMuc) {
        return chiTietSanPhamRepository.getCTSPbyDanhMuc(danhMuc);
    }

    public ArrayList<ChiTietDep> getCTSPByMauSac(String mauSac) {
        return chiTietSanPhamRepository.getCTSPbyMauSac(mauSac);
    }

    public ArrayList<ChiTietDep> getCTSPBySize(String size) {
        return chiTietSanPhamRepository.getCTSPbySIZE(size);
    }

    public ArrayList<ChiTietDep> getCTSPByNSX(String nsx) {
        return chiTietSanPhamRepository.getCTSPbyNSX(nsx);
    }

    public ArrayList<ChiTietDep> getCTSPbyChatLieu(String chatLieu) {
        return chiTietSanPhamRepository.getCTSPbyChatLieu(chatLieu);
    }

    public String getIDDanhMuc(String tenDanhMuc) {
        return chiTietSanPhamRepository.getIDDanhMuc(tenDanhMuc);
    }
    
    public List<String> getDanhMuc() {
        return chiTietSanPhamRepository.getDanhMuc();
    }

    public List<String> getDe() {
        return chiTietSanPhamRepository.getDe();
    }

    public List<String> getSanPham() {
        return chiTietSanPhamRepository.getSanPham();
    }

    public List<String> getSize() {
        return chiTietSanPhamRepository.getSize();
    }

    public List<String> getNsx() {
        return chiTietSanPhamRepository.getNSX();
    }

    public List<String> getChatLieu() {
        return chiTietSanPhamRepository.getChatLieu();
    }

    public List<String> getMauSac() {
        return chiTietSanPhamRepository.getMauSac();
    }

}
