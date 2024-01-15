
package Service;

import DomainModels.NguoiDung;
import Interface.NhanVienServiceImpl;
import Repository.NhanVienRepository;
import java.util.ArrayList;

public class NhanVienService implements NhanVienServiceImpl{
    NhanVienRepository nhanVien= new NhanVienRepository();
    @Override
    public ArrayList<NguoiDung> getAll() {
        return nhanVien.getAll();
    }

    @Override
    public boolean add(NguoiDung nd) {
        return nhanVien.add(nd);
    }

    @Override
    public boolean update(String ma, NguoiDung nd) {
        return nhanVien.update(ma, nd);
    }

    @Override
    public ArrayList<NguoiDung> phanTrang(Integer phantu) {
        return nhanVien.phanTrang(phantu);
    }

    @Override
    public ArrayList<NguoiDung> timKiemPhanTrang(String ma, int phantu, int tt) {
        return nhanVien.timKiemPhanTrang(ma, phantu, tt);
    }
   
    
}
