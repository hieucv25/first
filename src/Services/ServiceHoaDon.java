/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;


import ViewModels.HoaDonViewModel;
import java.util.List;

/**
 *
 * @author acer
 */
public interface ServiceHoaDon {

    List<HoaDonViewModel> getAll();

    List<HoaDonViewModel> getTT(int tt);

    boolean addHD(String tenNV, String tenKH, HoaDonViewModel hd);

    String getIDSP(String ten);

    boolean addHDCT(String maHoaDon, String idSP, int soLuong, Double donGia);

    boolean deleteHD(String maHD);

    List<HoaDonViewModel> getFollowIDKH(String id);
}
