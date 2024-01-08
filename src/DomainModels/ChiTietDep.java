/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author ADMIN
 */
public class ChiTietDep {
    
    private Integer id;
    
    private Integer idLoaiDep;
    
    private Integer idSize;
    
    private Integer idMauSac;
    
    private Integer idChatLieu;
    
    private Integer idNgaySX;
    
    private Integer soLuong;
    
    private Float giaNhap;
    
    private Float giaBan;
    
    private String moTa;
    
    private Integer trangThai;

    public ChiTietDep() {
    }

    
    public ChiTietDep(Integer id, Integer idLoaiDep, Integer idSize, Integer idMauSac, Integer idChatLieu, Integer idNgaySX, Integer soLuong, Float giaNhap, Float giaBan, String moTa, Integer trangThai) {
        this.id = id;
        this.idLoaiDep = idLoaiDep;
        this.idSize = idSize;
        this.idMauSac = idMauSac;
        this.idChatLieu = idChatLieu;
        this.idNgaySX = idNgaySX;
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

    public Integer getIdLoaiDep() {
        return idLoaiDep;
    }

    public void setIdLoaiDep(Integer idLoaiDep) {
        this.idLoaiDep = idLoaiDep;
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
