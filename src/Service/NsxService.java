/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModels.NhaSanXuat;
import Interface.NsxImpl;
import Repository.NsxRepository;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class NsxService implements NsxImpl{
    
    NsxRepository nsxRepository = new NsxRepository();

    @Override
    public ArrayList<NhaSanXuat> getAllNsxService() {
        return nsxRepository.getAllNsx();
    }

    @Override
    public String insert(NhaSanXuat nsx) {
        if (nsxRepository.insertNsx(nsx)) {
            return "Them Thanh Cong";
        } else {
            return "Them That Bai";
        }
    }

    @Override
    public String update(String Ma,NhaSanXuat nsx) {
        if (nsxRepository.updateNsx(Ma, nsx)) {
            return "Cap Nhat Thanh Cong";
        } else {
            return "Cap Nhat That Bai";
        }
    }

    @Override
    public NhaSanXuat getIDByName(String nsx) {
        return nsxRepository.getNSXTen(nsx);
    }

    @Override
    public void updateTrangThai(String idNSX) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
