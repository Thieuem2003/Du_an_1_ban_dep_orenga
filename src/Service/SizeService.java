/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModels.Size;
import Interface.SizeImpl;
import Repository.SizeRepository;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class SizeService implements SizeImpl{
    
    SizeRepository sizeRepository = new SizeRepository();

    
    @Override
    public ArrayList<Size> getAllSizeSevice() {
        return sizeRepository.getLAllSize();
    }

    @Override
    public String insert(Size sz) {
        if (sizeRepository.insertSize(sz)) {
            return "Them Thanh Cong";
        } else {
            return "Them That Bai";
        }
    }

    @Override
    public String update(String Ma,Size sz) {
        if (sizeRepository.updateSize(Ma, sz)) {
            return "Cap Nhat Thanh Cong";
        } else {
            return "Cap Nhat That Bai";
        }
    }

    @Override
    public Size getIDByName(String size) {
        return sizeRepository.getSizeTen(size);
    }

    @Override
    public void updateTrangThai(String idSize) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    
}
