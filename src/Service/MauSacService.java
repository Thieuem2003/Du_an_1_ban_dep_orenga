/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModels.MauSac;
import Interface.MauSacImpl;
import Repository.MauSacRepository;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class MauSacService implements MauSacImpl{
    
    MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    public ArrayList<MauSac> getAllMauSacService() {
        return mauSacRepository.getAllMauSac();
    }

    @Override
    public String insert(MauSac ms) {
        if (mauSacRepository.insertMauSac(ms)) {
            return "Them Thanh Cong";
        } else {
            return "Them That Bai";
        }
    }

    @Override
    public String update(String Ma,MauSac ms) {
        if (mauSacRepository.updateMauSac(Ma, ms)) {
            return "Cap Nhat Thanh Cong";
        } else {
            return "Cap Nhat That Bai";
        }
    }

    @Override
    public MauSac getIDByName(String mauSac) {
        return mauSacRepository.getMauSacTen(mauSac);
    }

    @Override
    public void updateTrangThai(String idMauSac) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
