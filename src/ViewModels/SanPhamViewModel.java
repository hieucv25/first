/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.math.BigDecimal;

/**
 *
 * @author acer
 */
public class SanPhamViewModel {

    private String maSP;
    private String tenSp;
    private int namBH;
    private String moTa;
    private int soLuong;
    private BigDecimal giaNhap;
    private BigDecimal giaBan;
    private String tenNSX;
    private String tenMS;
    private String tenDSP;

    public String getMaSP() {
        return maSP;
    }

    public void setMaSP(String maSP) {
        this.maSP = maSP;
    }

    public String getTenSp() {
        return tenSp;
    }

    public void setTenSp(String tenSp) {
        this.tenSp = tenSp;
    }

    public int getNamBH() {
        return namBH;
    }

    public void setNamBH(int namBH) {
        this.namBH = namBH;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public BigDecimal getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(BigDecimal giaNhap) {
        this.giaNhap = giaNhap;
    }

    public BigDecimal getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(BigDecimal giaBan) {
        this.giaBan = giaBan;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public String getTenMS() {
        return tenMS;
    }

    public void setTenMS(String tenMS) {
        this.tenMS = tenMS;
    }

    public String getTenDSP() {
        return tenDSP;
    }

    public void setTenDSP(String tenDSP) {
        this.tenDSP = tenDSP;
    }

    public SanPhamViewModel() {
    }

    public SanPhamViewModel(String maSP, String tenSp, int namBH, String moTa, int soLuong, BigDecimal giaNhap, BigDecimal giaBan, String tenNSX, String tenMS, String tenDSP) {
        this.maSP = maSP;
        this.tenSp = tenSp;
        this.namBH = namBH;
        this.moTa = moTa;
        this.soLuong = soLuong;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.tenNSX = tenNSX;
        this.tenMS = tenMS;
        this.tenDSP = tenDSP;
    }

    @Override
    public String toString() {
        return "SanPhamViewModel{" + "maSP=" + maSP + ", tenSp=" + tenSp + ", namBH=" + namBH + ", moTa=" + moTa + ", soLuong=" + soLuong + ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", tenNSX=" + tenNSX + ", tenMS=" + tenMS + ", tenDSP=" + tenDSP + '}';
    }
    
}
