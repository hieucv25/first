/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import ViewModels.GioHangViewModel;
import java.util.List;
import Responsitories.GioHangRepository;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author acer
 */
public class ServiceGioHangImpl implements Services.ServiceGioHang {

    private GioHangRepository gh = new GioHangRepository();

    @Override
    public List<GioHangViewModel> getAll() {
        return gh.getAll();
    }

    @Override
    public List<GioHangViewModel> getCustomer(String id) {
        return gh.getCustomer(id);
    }

    @Override
    public boolean addGH(String idKH, String ma, Date ngayTao) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean addGHCT(String idGH, String idCTSP, int soLuong, BigDecimal donGia) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
