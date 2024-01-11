/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author ADMIN
 */
public class ChiTietSPModel {
    
    private Integer id;
    
    private Integer idDanhMuc;
    
    private Integer idSanPham;
    
    private Integer idSize;
    
    private Integer idMauSac;
    
    private Integer idChatLieu;
    
    private Integer idNgaySX;
    
    private Integer idDe;
    
    private Integer soLuong;
    
    private Float giaNhap;
    
    private Float giaBan;
    
    private String moTa;
    
    private Integer trangThai;

    public ChiTietSPModel() {
    }

    

    public ChiTietSPModel(Integer id, Integer idDanhMuc, Integer idSanPham, Integer idSize, Integer idMauSac, Integer idChatLieu, Integer idNgaySX, Integer idDe, Integer soLuong, Float giaNhap, Float giaBan, String moTa, Integer trangThai) {
        this.id = id;
        this.idDanhMuc = idDanhMuc;
        this.idSanPham = idSanPham;
        this.idSize = idSize;
        this.idMauSac = idMauSac;
        this.idChatLieu = idChatLieu;
        this.idNgaySX = idNgaySX;
        this.idDe = idDe;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdDanhMuc() {
        return idDanhMuc;
    }

    public void setIdDanhMuc(Integer idDanhMuc) {
        this.idDanhMuc = idDanhMuc;
    }

    public Integer getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(Integer idSanPham) {
        this.idSanPham = idSanPham;
    }

    public Integer getIdSize() {
        return idSize;
    }

    public void setIdSize(Integer idSize) {
        this.idSize = idSize;
    }

    public Integer getIdMauSac() {
        return idMauSac;
    }

    public void setIdMauSac(Integer idMauSac) {
        this.idMauSac = idMauSac;
    }

    public Integer getIdChatLieu() {
        return idChatLieu;
    }

    public void setIdChatLieu(Integer idChatLieu) {
        this.idChatLieu = idChatLieu;
    }

    public Integer getIdNgaySX() {
        return idNgaySX;
    }

    public void setIdNgaySX(Integer idNgaySX) {
        this.idNgaySX = idNgaySX;
    }

    public Integer getIdDe() {
        return idDe;
    }

    public void setIdDe(Integer idDe) {
        this.idDe = idDe;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Float getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Float giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Float giaBan) {
        this.giaBan = giaBan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

}
