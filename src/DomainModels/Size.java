/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

/**
 *
 * @author ADMIN
 */
public class Size {
    
    private Integer idSize;
    
    private String ma;
    
    private Float kichCo;
    
    private Integer trangThai;

    public Size() {
    }

    
    public Size(Integer idSize, String ma, Float kichCo, Integer trangThai) {
        this.idSize = idSize;
        this.ma = ma;
        this.kichCo = kichCo;
        this.trangThai = trangThai;
    }

    public Integer getIdSize() {
        return idSize;
    }

    public void setIdSize(Integer idSize) {
        this.idSize = idSize;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Float getKichCo() {
        return kichCo;
    }

    public void setKichCo(Float kichCo) {
        this.kichCo = kichCo;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
