/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitories;

import ViewModels.GioHangViewModel;
import java.util.List;
import Utilities.SQLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class GioHangRepository {

    public List<GioHangViewModel> getAll() {
        String query = "select gh.Ma,sp.Ten,ghct.SoLuong,ghct.DonGia from GioHang gh join GioHangChiTiet "
                + "ghct on gh.Id = ghct.IdGioHang join ChiTietSP ctsp on ghct.IdChiTietSP = ctsp.Id\n"
                + "join SanPham sp on ctsp.IdSP = sp.Id";
        List<GioHangViewModel> listGh = new ArrayList<>();
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                GioHangViewModel gh = new GioHangViewModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
                listGh.add(gh);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return listGh;
    }

    public List<GioHangViewModel> getCustomer(String id) {
        String query = "select gh.Ma,sp.Ten,ghct.SoLuong,ghct.DonGia from KhachHang kh join GioHang gh on kh.Id = gh.IdKH\n"
                + "join GioHangChiTiet ghct on gh.Id = ghct.IdGioHang join ChiTietSP ctsp on ghct.IdChiTietSP = ctsp.Id\n"
                + "join SanPham sp on ctsp.IdSP = sp.Id where kh.Id = ?";
        List<GioHangViewModel> listGh = new ArrayList<>();
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GioHangViewModel gh = new GioHangViewModel(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4));
                listGh.add(gh);
            }

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return listGh;
    }

}
