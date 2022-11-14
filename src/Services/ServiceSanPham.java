/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.SanPham;
import ViewModels.SanPhamViewModel;
import java.util.List;

/**
 *
 * @author acer
 */
public interface ServiceSanPham {

    List<SanPhamViewModel> getAll();

    boolean addSP(SanPham sp);

    boolean addSPCT(String id, SanPhamViewModel sp);

    String getID(String ma);

    boolean deleteSP(String id);

    boolean updateSP(String id, SanPham sp);

    boolean updateSPCT(String id, SanPhamViewModel sp);

    boolean deleteSPCT(String id);
}
