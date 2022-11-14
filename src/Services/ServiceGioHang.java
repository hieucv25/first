/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import ViewModels.GioHangViewModel;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author acer
 */
public interface ServiceGioHang {

    List<GioHangViewModel> getAll();

    List<GioHangViewModel> getCustomer(String id);
    
    boolean addGH(String idKH,String ma ,Date ngayTao);
    
    boolean addGHCT(String idGH, String idCTSP, int soLuong, BigDecimal donGia);

}
