/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModels.KhachHang;

import Interface.KhachHangServiceIplm;
import Repository.KhachHangRepository;
import ViewModel.KhachHangModel;
import java.util.ArrayList;

/**
 *
 * @author UyTin
 */
public class KhachHangService implements KhachHangServiceIplm{
    
    KhachHangRepository khachHangRepository =  new KhachHangRepository();

    @Override
    public ArrayList<KhachHang> getList() {
        return khachHangRepository.getList();
    }

    @Override
    public String them(KhachHang kh) {
         if(khachHangRepository.addNew(kh)){
            return"Thêm thành công";
        }else{
            return "Thêm thất bại";
        }
        }

    @Override
    public String update(String Ma, KhachHang kh) {
           if(khachHangRepository.upDateKH(Ma, kh)){
            return"Suawr thành công";
        }else{
            return "sua thất bại";
        }
        }
    
    }

  

    

