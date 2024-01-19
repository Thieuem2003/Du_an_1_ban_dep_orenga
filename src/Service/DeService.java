/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModels.De;
import Interface.DeImpl;
import Repository.DeRepository;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class DeService implements DeImpl{
    
    DeRepository deRepository = new DeRepository();

        @Override
    public ArrayList<De> getAllDeService() {
        return deRepository.getAllDe();
    }

    @Override
    public String insert(De cl) {
        if (deRepository.insertDe(cl)) {
            return "Them Thanh Cong";
        } else {
            return "Them That Bai";
        }
    }

    @Override
    public String update(String Ma,De cl) {
        if (deRepository.updateDe(Ma, cl)) {
            return "Cap Nhat Thanh Cong";
        } else {
            return "Cap Nhat That Bai";
        }
    }
    
    @Override
    public De getIDByName(String de) {
        return deRepository.getDeTen(de);
    }

    @Override
    public void updateTrangThai(String idDe) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
