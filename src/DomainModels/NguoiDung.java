/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class NguoiDung {
    
    private Integer idNguoiDung;
    
    private Integer idChucVu;
    
    private String ma;
    
    private String ten;
    
    private Date ngaySinh;
    
    private String email;
    
    private String sdt;
    
    private Integer gioiTinh;
    
    private String matKhau;
    
    private Integer TrangThai;
    
    private String hinhAnh;

    public NguoiDung() {
    }
    

    public NguoiDung(Integer idNguoiDung, Integer idChucVu, String ma, String ten, Date ngaySinh, String email, String sdt, Integer gioiTinh, String matKhau, Integer TrangThai, String hinhAnh) {
        this.idNguoiDung = idNguoiDung;
        this.idChucVu = idChucVu;
        this.ma = ma;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.sdt = sdt;
        this.gioiTinh = gioiTinh;
        this.matKhau = matKhau;
        this.TrangThai = TrangThai;
        this.hinhAnh = hinhAnh;
    }

    public Integer getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(Integer idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public Integer getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(Integer idChucVu) {
        this.idChucVu = idChucVu;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public Integer getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Integer gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Integer getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(Integer TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }


    
}
