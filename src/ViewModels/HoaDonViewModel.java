/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ViewModels;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author acer
 */
public class HoaDonViewModel {

    private String maHD;
    private Date ngayTao;
    private String tenNV;
    private String tenKH;
    private int tinhTrang;
    private String tenNgNhan;
    private String diaChi;
    private String sdt;
    private String tenSP;
    private int soLuong;
    private Double donGia;

    public HoaDonViewModel(String maHD, Date ngayTao, String tenNV, String tenKH, int tinhTrang, String tenNgNhan, String diaChi, String sdt, String tenSP, int soLuong, Double donGia) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.tenNV = tenNV;
        this.tenKH = tenKH;
        this.tinhTrang = tinhTrang;
        this.tenNgNhan = tenNgNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public HoaDonViewModel(String maHD, Date ngayTao, String tenNV, int tinhTrang, String tenNgNhan, String diaChi, String sdt, String tenSP, int soLuong, Double donGia) {
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.tenNV = tenNV;
        this.tinhTrang = tinhTrang;
        this.tenNgNhan = tenNgNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.tenSP = tenSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public HoaDonViewModel() {
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getTenNgNhan() {
        return tenNgNhan;
    }

    public void setTenNgNhan(String tenNgNhan) {
        this.tenNgNhan = tenNgNhan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
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

    public String getTrangThai(int tinhTrang) {
        if (tinhTrang == 0) {
            return "Cho Thanh Toan";
        } else if (tinhTrang == 1) {
            return "Da Thanh Toan";
        } else {
            return "Da Huy";
        }
    }

    public Double getThanhTien(int soLuong, Double donGia) {
       return soLuong*donGia;
    }
}
