/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author ADMIN
 */
public class SanPham {
    
    private Integer idSanPham;
    
    private String ma;
    
    private String ten;
    
    private Integer trangThai;

    public SanPham() {
    }

    public SanPham(Integer idSanPham, String ma, String ten) {
        this.idSanPham = idSanPham;
        this.ma = ma;
        this.ten = ten;
    }

    public SanPham(Integer idSanPham, String ma, String ten, Integer trangThai) {
        this.idSanPham = idSanPham;
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
    }

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
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

    @Override
    public String toString() {
        return ten;
    }
    
    
}
