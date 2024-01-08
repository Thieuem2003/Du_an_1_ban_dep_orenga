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
public class HoaDonChiTiet {
    
    private Integer id;
    
    private Integer idHoaDon;
    
    private Integer idChiTietDep;
    
    private Float donGia;
    
    private Integer soLuong;
    
    private Date ngayTao;
    
    private Date ngaySua;
    
    private Integer trangThai;

    public HoaDonChiTiet() {
    }

    
    public HoaDonChiTiet(Integer id, Integer idHoaDon, Integer idChiTietDep, Float donGia, Integer soLuong, Date ngayTao, Date ngaySua, Integer trangThai) {
        this.id = id;
        this.idHoaDon = idHoaDon;
        this.idChiTietDep = idChiTietDep;
        this.donGia = donGia;
        this.soLuong = soLuong;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(Integer idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public Integer getIdChiTietDep() {
        return idChiTietDep;
    }

    public void setIdChiTietDep(Integer idChiTietDep) {
        this.idChiTietDep = idChiTietDep;
    }

    public Float getDonGia() {
        return donGia;
    }

    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
