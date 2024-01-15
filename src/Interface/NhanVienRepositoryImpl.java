
package Interface;

import DomainModels.NguoiDung;
import java.util.ArrayList;


public interface NhanVienRepositoryImpl {
    
    public ArrayList<NguoiDung> getAll();
    public boolean add(NguoiDung nd);
    public boolean update(String ma, NguoiDung nd);
    public ArrayList<NguoiDung> phanTrang(Integer phantu);
    public ArrayList<NguoiDung> timKiemPhanTrang(String ma, int phantu, int tt);

    
}
