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
public class KhuyenMai {
    
    
    private Integer id;
    
    private String ma;
    
    private String ten;
    
    private Float phanTramGiam;
    
    private Integer soLuong;
    
    private Date ngayBatDau;
    
    private Date ngayKetThuc;
    
    private Integer trangThai;
    
    private String moTa;

    public KhuyenMai() {
    }

    
    public KhuyenMai(Integer id, String ma, String ten, Float phanTramGiam, Integer soLuong, Date ngayBatDau, Date ngayKetThuc, Integer trangThai, String moTa) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.phanTramGiam = phanTramGiam;
        this.soLuong = soLuong;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.trangThai = trangThai;
        this.moTa = moTa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Float getPhanTramGiam() {
        return phanTramGiam;
    }

    public void setPhanTramGiam(Float phanTramGiam) {
        this.phanTramGiam = phanTramGiam;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }
    
    
}
