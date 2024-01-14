/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModels.ChiTietDep;
import Interface.ChiTietSanPhamImpl;
import Repository.ChiTietSanPhamRepository;
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

    public List<ChiTietDep> getAllHdSp(){
        return  this.chiTietSanPhamRepository.getAllHoaDonSP();
    }
    
    public ArrayList<ChiTietDep> getCTSPByDanhMuc(String danhMuc){
        return  chiTietSanPhamRepository.getCTSPbyDanhMuc(danhMuc);
    }
    
    public ArrayList<ChiTietDep> getCTSPByMauSac(String mauSac){
        return  chiTietSanPhamRepository.getCTSPbyMauSac(mauSac);
    }
    public ArrayList<ChiTietDep> getCTSPBySize(String size){
        return  chiTietSanPhamRepository.getCTSPbySIZE(size);
    }
    public ArrayList<ChiTietDep> getCTSPByNSX(String nsx){
        return  chiTietSanPhamRepository.getCTSPbyNSX(nsx);
    }


}
