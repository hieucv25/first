/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.KhachHang;
import java.util.List;
import Responsitories.KhachHangRepository;

/**
 *
 * @author acer
 */
public class ServiceKhachHangImpl implements Services.ServiceKhachHang {

    private KhachHangRepository kh = new KhachHangRepository();

    @Override
    public List<KhachHang> getAll() {
        return kh.getAll();
    }

    @Override
    public String getID(String ma) {
        return kh.getIDCustomer(ma);
    }

}
