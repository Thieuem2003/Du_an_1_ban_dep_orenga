/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.math.BigDecimal;

/**
 *
 * @author ADMIN
 */
public class ChiTietDep {
    
    private Integer id;
    
    private Integer idDanhMuc;
    
    private Integer idSanPham;
    
    private Integer idSize;
    
    private Integer idMauSac;
    
    private Integer idChatLieu;
    
    private Integer idNSX;
    
    private Integer idDe;
//    private DanhMuc idDanhMuc;
//    
//    private SanPham idSanPham;
//    
//    private Size idSize;
//    
//    private MauSac idMauSac;
//    
//    private ChatLieu idChatLieu;
//    
//    private NhaSanXuat idNSX;
//    
//    private De idDe;
    
    private Integer soLuong;
    
    private Float giaNhap;
    
    private Float giaBan;
    
    private String moTa;
    
    private Integer trangThai;

    public ChiTietDep() {
    }

    public ChiTietDep(Integer id, Integer idDanhMuc, Integer idSanPham, Integer idSize, Integer idMauSac, Integer idChatLieu, Integer idNSX, Integer idDe, Integer soLuong, Float giaNhap, Float giaBan, String moTa, Integer trangThai) {
        this.id = id;
        this.idDanhMuc = idDanhMuc;
        this.idSanPham = idSanPham;
        this.idSize = idSize;
        this.idMauSac = idMauSac;
        this.idChatLieu = idChatLieu;
        this.idNSX = idNSX;
        this.idDe = idDe;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.moTa = moTa;
        this.trangThai = trangThai;
    }

    
//    public ChiTietDep(Integer id, DanhMuc idDanhMuc, SanPham idSanPham, Size idSize, MauSac idMauSac, ChatLieu idChatLieu, NhaSanXuat idNSX, De idDe, Integer soLuong, Float giaNhap, Float giaBan, String moTa, Integer trangThai) {
//        this.id = id;
//        this.idDanhMuc = idDanhMuc;
//        this.idSanPham = idSanPham;
//        this.idSize = idSize;
//        this.idMauSac = idMauSac;
//        this.idChatLieu = idChatLieu;
//        this.idNSX = idNSX;
//        this.idDe = idDe;
//        this.soLuong = soLuong;
//        this.giaNhap = giaNhap;
//        this.giaBan = giaBan;
//        this.moTa = moTa;
//        this.trangThai = trangThai;
//    }

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

    public Integer getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(Integer idNSX) {
        this.idNSX = idNSX;
    }

    public Integer getIdDe() {
        return idDe;
    }

    public void setIdDe(Integer idDe) {
        this.idDe = idDe;
    }

//    public DanhMuc getIdDanhMuc() {
//        return idDanhMuc;
//    }
//
//    public void setIdDanhMuc(DanhMuc idDanhMuc) {
//        this.idDanhMuc = idDanhMuc;
//    }
//
//    public SanPham getIdSanPham() {
//        return idSanPham;
//    }
//
//    public void setIdSanPham(SanPham idSanPham) {
//        this.idSanPham = idSanPham;
//    }
//
//    public Size getIdSize() {
//        return idSize;
//    }
//
//    public void setIdSize(Size idSize) {
//        this.idSize = idSize;
//    }
//
//    public MauSac getIdMauSac() {
//        return idMauSac;
//    }
//
//    public void setIdMauSac(MauSac idMauSac) {
//        this.idMauSac = idMauSac;
//    }
//
//    public ChatLieu getIdChatLieu() {
//        return idChatLieu;
//    }
//
//    public void setIdChatLieu(ChatLieu idChatLieu) {
//        this.idChatLieu = idChatLieu;
//    }
//
//    public NhaSanXuat getIdNSX() {
//        return idNSX;
//    }
//
//    public void setIdNSX(NhaSanXuat idNSX) {
//        this.idNSX = idNSX;
//    }
//
//    public De getIdDe() {
//        return idDe;
//    }
//
//    public void setIdDe(De idDe) {
//        this.idDe = idDe;
//    }
//    
    
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
