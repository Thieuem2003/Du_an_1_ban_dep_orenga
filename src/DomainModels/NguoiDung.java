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
public class NguoiDung {
    
    private Integer idNguoiDung;
    
    private Integer idChucVu;
    
    private String maNguoiDung;
    
    private String tenNguoiDung;
    
    private Date ngaySinhNguoiDung;
    
    private String emailNguoiDung;
    
    private String sdtNguoiDung;
    
    private Integer gioiTinhNguoiDung;
    
    private String diaChiNguoiDung;
    
    private String matKhauNguoiDung;
    
    private Integer trangThaiNguoiDung;

    
    public NguoiDung() {
    }

    public NguoiDung(Integer idNguoiDung, Integer idChucVu, String maNguoiDung, String tenNguoiDung, Date ngaySinhNguoiDung, String emailNguoiDung, String sdtNguoiDung, Integer gioiTinhNguoiDung, String diaChiNguoiDung, String matKhauNguoiDung, Integer trangThaiNguoiDung) {
        this.idNguoiDung = idNguoiDung;
        this.idChucVu = idChucVu;
        this.maNguoiDung = maNguoiDung;
        this.tenNguoiDung = tenNguoiDung;
        this.ngaySinhNguoiDung = ngaySinhNguoiDung;
        this.emailNguoiDung = emailNguoiDung;
        this.sdtNguoiDung = sdtNguoiDung;
        this.gioiTinhNguoiDung = gioiTinhNguoiDung;
        this.diaChiNguoiDung = diaChiNguoiDung;
        this.matKhauNguoiDung = matKhauNguoiDung;
        this.trangThaiNguoiDung = trangThaiNguoiDung;
    }

    public Integer getIdNguoiDung() {
        return idNguoiDung;
    }

    public void setIdNguoiDung(Integer idNguoiDung) {
        this.idNguoiDung = idNguoiDung;
    }

    public Integer getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(Integer idChucVu) {
        this.idChucVu = idChucVu;
    }

    public String getMaNguoiDung() {
        return maNguoiDung;
    }

    public void setMaNguoiDung(String maNguoiDung) {
        this.maNguoiDung = maNguoiDung;
    }

    public String getTenNguoiDung() {
        return tenNguoiDung;
    }

    public void setTenNguoiDung(String tenNguoiDung) {
        this.tenNguoiDung = tenNguoiDung;
    }

    public Date getNgaySinhNguoiDung() {
        return ngaySinhNguoiDung;
    }

    public void setNgaySinhNguoiDung(Date ngaySinhNguoiDung) {
        this.ngaySinhNguoiDung = ngaySinhNguoiDung;
    }

    public String getEmailNguoiDung() {
        return emailNguoiDung;
    }

    public void setEmailNguoiDung(String emailNguoiDung) {
        this.emailNguoiDung = emailNguoiDung;
    }

    public String getSdtNguoiDung() {
        return sdtNguoiDung;
    }

    public void setSdtNguoiDung(String sdtNguoiDung) {
        this.sdtNguoiDung = sdtNguoiDung;
    }

    public Integer getGioiTinhNguoiDung() {
        return gioiTinhNguoiDung;
    }

    public void setGioiTinhNguoiDung(Integer gioiTinhNguoiDung) {
        this.gioiTinhNguoiDung = gioiTinhNguoiDung;
    }

    public String getDiaChiNguoiDung() {
        return diaChiNguoiDung;
    }

    public void setDiaChiNguoiDung(String diaChiNguoiDung) {
        this.diaChiNguoiDung = diaChiNguoiDung;
    }

    public String getMatKhauNguoiDung() {
        return matKhauNguoiDung;
    }

    public void setMatKhauNguoiDung(String matKhauNguoiDung) {
        this.matKhauNguoiDung = matKhauNguoiDung;
    }

    public Integer getTrangThaiNguoiDung() {
        return trangThaiNguoiDung;
    }

    public void setTrangThaiNguoiDung(Integer trangThaiNguoiDung) {
        this.trangThaiNguoiDung = trangThaiNguoiDung;
    }

    @Override
    public String toString() {
        return "NguoiDung{" + "idNguoiDung=" + idNguoiDung + ", idChucVu=" + idChucVu + ", maNguoiDung=" + maNguoiDung + ", tenNguoiDung=" + tenNguoiDung + ", ngaySinhNguoiDung=" + ngaySinhNguoiDung + ", emailNguoiDung=" + emailNguoiDung + ", sdtNguoiDung=" + sdtNguoiDung + ", gioiTinhNguoiDung=" + gioiTinhNguoiDung + ", diaChiNguoiDung=" + diaChiNguoiDung + ", matKhauNguoiDung=" + matKhauNguoiDung + ", trangThaiNguoiDung=" + trangThaiNguoiDung + '}';
    }

    public NguoiDung(String maNguoiDung, String tenNguoiDung, Date ngaySinhNguoiDung, String emailNguoiDung, String sdtNguoiDung, Integer gioiTinhNguoiDung, String diaChiNguoiDung, String matKhauNguoiDung, Integer trangThaiNguoiDung) {
        this.maNguoiDung = maNguoiDung;
        this.tenNguoiDung = tenNguoiDung;
        this.ngaySinhNguoiDung = ngaySinhNguoiDung;
        this.emailNguoiDung = emailNguoiDung;
        this.sdtNguoiDung = sdtNguoiDung;
        this.gioiTinhNguoiDung = gioiTinhNguoiDung;
        this.diaChiNguoiDung = diaChiNguoiDung;
        this.matKhauNguoiDung = matKhauNguoiDung;
        this.trangThaiNguoiDung = trangThaiNguoiDung;
    }

    
    
    
    
}
