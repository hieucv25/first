/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import ViewModels.HoaDonViewModel;
import java.util.List;
import Responsitories.HoaDonRepository;
import java.math.BigDecimal;

/**
 *
 * @author acer
 */
public class ServiceHoaDonImpl implements Services.ServiceHoaDon {

    private HoaDonRepository hd = new HoaDonRepository();

    @Override
    public List<HoaDonViewModel> getAll() {
        return hd.getAll();
    }

    @Override
    public List<HoaDonViewModel> getTT(int tt) {
        return hd.getTT(tt);
    }

    @Override
    public boolean addHD(String tenNV, String tenKH, HoaDonViewModel hdd) {
        boolean a = hd.addHD(tenNV, tenKH, hdd);
        if (a) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getIDSP(String ten) {
        String id = hd.getIDSP(ten);
        return id;
    }

    @Override
    public boolean addHDCT(String maHoaDon, String idSP, int soLuong, Double donGia) {
        boolean a = hd.addHDCT(maHoaDon, idSP, soLuong, donGia);
        if (a) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteHD(String maHD) {
        boolean a = hd.deleteHD(maHD);
        if (a) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<HoaDonViewModel> getFollowIDKH(String id) {
        return hd.getFollowIDKH(id);
    }

}
