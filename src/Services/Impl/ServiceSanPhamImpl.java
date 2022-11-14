/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.SanPham;
import ViewModels.SanPhamViewModel;
import java.util.List;
import Responsitories.SanPhamRepository;

/**
 *
 * @author acer
 */
public class ServiceSanPhamImpl implements Services.ServiceSanPham {
    
    SanPhamRepository spim = new SanPhamRepository();
    
    @Override
    public List<SanPhamViewModel> getAll() {
        return spim.getAll();
    }
    
    @Override
    public boolean addSP(SanPham sp) {
        boolean a = spim.addSP(sp);
        if (a) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean addSPCT(String id, SanPhamViewModel sp) {
        boolean a = spim.addSPCT(id, sp);
        if (a) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public String getID(String ma) {
        return spim.getID(ma);
    }
    
    @Override
    public boolean deleteSP(String id) {
        boolean a = spim.deleteSP(id);
        if (a) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean updateSP(String id, SanPham sp) {
        boolean a = spim.updateSP(id, sp);
        if (a) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean updateSPCT(String id, SanPhamViewModel sp) {
        boolean a = spim.updateSPCT(id, sp);
        if (a) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean deleteSPCT(String id) {
        boolean a = spim.deleteSPCT(id);
        if (a) {
            return true;
        } else {
            return false;
        }
    }
    
}
