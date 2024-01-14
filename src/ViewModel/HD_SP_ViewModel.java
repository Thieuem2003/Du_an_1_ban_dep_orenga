/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModel;

/**
 *
 * @author asus
 */
public class HD_SP_ViewModel {
    private Integer Id;
    private String tenSp ;
    private Integer soLuong;
    private Float giaBan;
    private String tenDM;
    private String tenCL;
    private String tenS;
    private String tenH;
    private String tenD;

    public HD_SP_ViewModel() {
    }

    public HD_SP_ViewModel(Integer Id, String tenSp, Integer soLuong, Float giaBan, String tenDM, String tenCL, String tenS, String tenH, String tenD) {
        this.Id = Id;
        this.tenSp = tenSp;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.tenDM = tenDM;
        this.tenCL = tenCL;
        this.tenS = tenS;
        this.tenH = tenH;
        this.tenD = tenD;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Float giaBan) {
        this.giaBan = giaBan;
    }

    public String getTenDM() {
        return tenDM;
    }

    public void setTenDM(String tenDM) {
        this.tenDM = tenDM;
    }

    public String getTenCL() {
        return tenCL;
    }

    public void setTenCL(String tenCL) {
        this.tenCL = tenCL;
    }

    public String getTenS() {
        return tenS;
    }

    public void setTenS(String tenS) {
        this.tenS = tenS;
    }

    public String getTenH() {
        return tenH;
    }

    public void setTenH(String tenH) {
        this.tenH = tenH;
    }

    public String getTenD() {
        return tenD;
    }

    public void setTenD(String tenD) {
        this.tenD = tenD;
    }
    
    
}
