/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.math.BigDecimal;
import DomainModels.ChatLieu;
import DomainModels.DanhMuc;
import DomainModels.De;
import DomainModels.MauSac;
import DomainModels.NhaSanXuat;
import DomainModels.SanPham;
import DomainModels.Size;

/**
 *
 * @author ADMIN
 */
public class ChiTietDep {

    private Integer Id;

    private SanPham IdSanPham;

    private DanhMuc IdDanhMuc;

    private Size IdSize;

    private MauSac IdMauSac;

    private ChatLieu IdChatLieu;

    private NhaSanXuat IdNSX;

    private De IdDe;

    private Integer SoLuong;

    private Float GiaNhap;

    private Float GiaBan;

    private String MoTa;

    private String HinhAnh;

    private Integer TrangThai;

    public ChiTietDep() {
    }

    public ChiTietDep(Integer Id, SanPham IdSanPham, DanhMuc IdDanhMuc, Size IdSize, MauSac IdMauSac, ChatLieu IdChatLieu, NhaSanXuat IdNSX, De IdDe, Integer SoLuong, Float GiaBan, String MoTa, Integer TrangThai) {
        this.Id = Id;
        this.IdSanPham = IdSanPham;
        this.IdDanhMuc = IdDanhMuc;
        this.IdSize = IdSize;
        this.IdMauSac = IdMauSac;
        this.IdChatLieu = IdChatLieu;
        this.IdNSX = IdNSX;
        this.IdDe = IdDe;
        this.SoLuong = SoLuong;
        this.GiaBan = GiaBan;
        this.MoTa = MoTa;
        this.TrangThai = TrangThai;
    }

    
    
    public ChiTietDep(Integer Id, SanPham IdSanPham, DanhMuc IdDanhMuc, Size IdSize, MauSac IdMauSac, ChatLieu IdChatLieu, NhaSanXuat IdNSX, De IdDe, Integer SoLuong, Float GiaNhap, Float GiaBan, String MoTa, String HinhAnh, Integer TrangThai) {
        this.Id = Id;
        this.IdSanPham = IdSanPham;
        this.IdDanhMuc = IdDanhMuc;
        this.IdSize = IdSize;
        this.IdMauSac = IdMauSac;
        this.IdChatLieu = IdChatLieu;
        this.IdNSX = IdNSX;
        this.IdDe = IdDe;
        this.SoLuong = SoLuong;
        this.GiaNhap = GiaNhap;
        this.GiaBan = GiaBan;
        this.MoTa = MoTa;
        this.HinhAnh = HinhAnh;
        this.TrangThai = TrangThai;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public DanhMuc getIdDanhMuc() {
        return IdDanhMuc;
    }

    public void setIdDanhMuc(DanhMuc IdDanhMuc) {
        this.IdDanhMuc = IdDanhMuc;
    }

    public SanPham getIdSanPham() {
        return IdSanPham;
    }

    public void setIdSanPham(SanPham IdSanPham) {
        this.IdSanPham = IdSanPham;
    }

    public Size getIdSize() {
        return IdSize;
    }

    public void setIdSize(Size IdSize) {
        this.IdSize = IdSize;
    }

    public MauSac getIdMauSac() {
        return IdMauSac;
    }

    public void setIdMauSac(MauSac IdMauSac) {
        this.IdMauSac = IdMauSac;
    }

    public ChatLieu getIdChatLieu() {
        return IdChatLieu;
    }

    public void setIdChatLieu(ChatLieu IdChatLieu) {
        this.IdChatLieu = IdChatLieu;
    }

    public NhaSanXuat getIdNSX() {
        return IdNSX;
    }

    public void setIdNSX(NhaSanXuat IdNSX) {
        this.IdNSX = IdNSX;
    }

    public De getIdDe() {
        return IdDe;
    }

    public void setIdDe(De IdDe) {
        this.IdDe = IdDe;
    }

    public Integer getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(Integer SoLuong) {
        this.SoLuong = SoLuong;
    }

    public Float getGiaNhap() {
        return GiaNhap;
    }

    public void setGiaNhap(Float GiaNhap) {
        this.GiaNhap = GiaNhap;
    }

    public Float getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(Float GiaBan) {
        this.GiaBan = GiaBan;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getHinhAnh() {
        return HinhAnh;
    }

    public void setHinhAnh(String HinhAnh) {
        this.HinhAnh = HinhAnh;
    }

    public Integer getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(Integer TrangThai) {
        this.TrangThai = TrangThai;
    }

}
