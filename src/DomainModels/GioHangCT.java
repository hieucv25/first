/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DomainModels;

import java.math.BigDecimal;

/**
 *
 * @author acer
 */
public class GioHangCT {

    private String idGioHang;
    private String idCTSP;
    private int soLuong;
    private Double donGia;
    private Double dongGiaKhiGiam;

    public GioHangCT(String idGioHang, String idCTSP, int soLuong, Double donGia, Double dongGiaKhiGiam) {
        this.idGioHang = idGioHang;
        this.idCTSP = idCTSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.dongGiaKhiGiam = dongGiaKhiGiam;
    }

    public GioHangCT() {
    }

    public String getIdGioHang() {
        return idGioHang;
    }

    public void setIdGioHang(String idGioHang) {
        this.idGioHang = idGioHang;
    }

    public String getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(String idCTSP) {
        this.idCTSP = idCTSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Double getDonGia() {
        return donGia;
    }

    public void setDonGia(Double donGia) {
        this.donGia = donGia;
    }

    public Double getDongGiaKhiGiam() {
        return dongGiaKhiGiam;
    }

    public void setDongGiaKhiGiam(Double dongGiaKhiGiam) {
        this.dongGiaKhiGiam = dongGiaKhiGiam;
    }

}
