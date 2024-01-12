/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author ADMIN
 */
public class DanhMuc {
    
    private Integer idDanhMuc;
    
    private String ma;
    
    private String ten;
    
    private Integer trangThai;

    public DanhMuc() {
    }

    public Integer getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(Integer idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
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

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public DanhMuc(Integer idDanhMuc, String ma, String ten, Integer trangThai) {
        this.idDanhMuc = idDanhMuc;
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return ten;
    }
    
    
}
