/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author ADMIN
 */
public class NgaySanXuat {
    
    private int id;
    
    private String ma;
    
    private String ten;
    
    private Integer trangThai;

    public NgaySanXuat() {
    }
    

    public NgaySanXuat(int id, String ma, String ten, Integer trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
