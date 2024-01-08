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
public class HoaDon {
    
    private Integer id;
    
    private String ma;
    
    private Integer idNguoiDung;
    
    private Integer idKhachHang;
    
    private Integer idKhuyenMai;
    
    private Float tongTien;
    
    private Float thanhTien;
    
    private Date ngayThanhToan;
    
    private Date ngayTao;
    
    private Date ngaySua;
    
    private Integer trangThai;

    public HoaDon() {
    }

    
    public HoaDon(Integer id, String ma, Integer idNguoiDung, Integer idKhachHang, Integer idKhuyenMai, Float tongTien, Float thanhTien, Date ngayThanhToan, Date ngayTao, Date ngaySua, Integer trangThai) {
        this.id = id;
        this.ma = ma;
        this.idNguoiDung = idNguoiDung;
        this.idKhachHang = idKhachHang;
        this.idKhuyenMai = idKhuyenMai;
        this.tongTien = tongTien;
        this.thanhTien = thanhTien;
        this.ngayThanhToan = ngayThanhToan;
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

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Integer getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(Integer idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public Integer getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(Integer idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public Integer getIdKhuyenMai() {
        return idKhuyenMai;
    }

    public void setIdKhuyenMai(Integer idKhuyenMai) {
        this.idKhuyenMai = idKhuyenMai;
    }

    public Float getTongTien() {
        return tongTien;
    }

    public void setTongTien(Float tongTien) {
        this.tongTien = tongTien;
    }

    public Float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(Float thanhTien) {
        this.thanhTien = thanhTien;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
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
