/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.NhaSanXuat;
import java.util.List;
import Responsitories.NhaSanXuatRepository;

/**
 *
 * @author acer
 */
public class ServiceNhaSanXuatImpl implements Services.ServiceNhaSanXuat {

    private NhaSanXuatRepository nsx = new NhaSanXuatRepository();

    @Override
    public List<NhaSanXuat> getAll() {
        return nsx.getAll();
    }

}
