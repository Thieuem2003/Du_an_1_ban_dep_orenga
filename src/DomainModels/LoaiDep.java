/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author ADMIN
 */
public class LoaiDep {
    
    private Integer idLoaiDep;
    
    private String ma;
    
    private String ten;
    
    private Integer trangThai;

    public LoaiDep() {
    }

    public Integer getIdLoaiDep() {
        return idLoaiDep;
    }

    public void setIdLoaiDep(Integer idLoaiDep) {
        this.idLoaiDep = idLoaiDep;
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

    public LoaiDep(Integer idLoaiDep, String ma, String ten, Integer trangThai) {
        this.idLoaiDep = idLoaiDep;
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
    }
}
