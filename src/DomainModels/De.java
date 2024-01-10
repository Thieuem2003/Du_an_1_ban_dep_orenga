/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author ADMIN
 */
public class De {
    
    private Integer idDe;
    
    private String ma;
    
    private String ten;
    
    private Integer trangThai;

    public De() {
    }

    public De(Integer idDe, String ma, String ten) {
        this.idDe = idDe;
        this.ma = ma;
        this.ten = ten;
    }

    public De(Integer idDe, String ma, String ten, Integer trangThai) {
        this.idDe = idDe;
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
    }

    public Integer getIdDe() {
        return idDe;
    }

    public void setIdDe(Integer idDe) {
        this.idDe = idDe;
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
    
    
}
