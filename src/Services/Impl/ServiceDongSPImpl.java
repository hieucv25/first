/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.DongSanPham;
import java.util.List;
import Responsitories.DongSpRepository;

/**
 *
 * @author acer
 */
public class ServiceDongSPImpl implements Services.ServiceDongSP {

    private DongSpRepository dsp = new DongSpRepository();

    @Override
    public List<DongSanPham> getAll() {
        return dsp.getAll();
    }

}
