/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.NhanVien;
import java.util.List;
import Responsitories.NhanVienRepository;

/**
 *
 * @author acer
 */
public class ServiceNhanVienImpl implements Services.ServiceNhanVien {

    private NhanVienRepository nv = new NhanVienRepository();

    @Override
    public List<NhanVien> getAll() {
        return nv.getAll();
    }

}
