/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Service;

import DomainModels.KhuyenMai;
import Interface.KhuyenMaiServiceImpl;
import Repository.KhuyenMaiRepository;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class KhuyenMaiService implements KhuyenMaiServiceImpl{
    
    KhuyenMaiRepository km = new KhuyenMaiRepository();
    
    @Override
    public ArrayList<KhuyenMai> getAll() {
        return km.getAllKM();
    }
    
}
