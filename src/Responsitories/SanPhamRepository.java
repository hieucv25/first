/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitories;

import DomainModels.SanPham;
import ViewModels.SanPhamViewModel;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Utilities.SQLConnection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class SanPhamRepository {

    public List<SanPhamViewModel> getAll() {
        List<SanPhamViewModel> listSPCustom = new ArrayList<>();
        String query = "select sp.Ma,sp.Ten,ctsp.NamBH,ctsp.MoTa,ctsp.SoLuongTon,ctsp.GiaNhap,ctsp.GiaBan,nsx.Ten,ms.Ten,dsp.Ten\n"
                + "from SanPham sp join ChiTietSP ctsp on sp.id = ctsp.IdSP \n"
                + "join NSX on ctsp.IdNsx = nsx.Id \n"
                + "join MauSac ms on ctsp.IdMauSac = ms.Id \n"
                + "join DongSP dsp on ctsp.IdDongSP = dsp.id";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                SanPhamViewModel sp = new SanPhamViewModel();
                sp.setMaSP(rs.getString(1));
                sp.setTenSp(rs.getString(2));
                sp.setNamBH(rs.getInt(3));
                sp.setMoTa(rs.getString(4));
                sp.setSoLuong(rs.getInt(5));
                sp.setGiaNhap(rs.getBigDecimal(6));
                sp.setGiaBan(rs.getBigDecimal(7));
                sp.setTenNSX(rs.getString(8));
                sp.setTenMS(rs.getString(9));
                sp.setTenDSP(rs.getString(10));
                listSPCustom.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return listSPCustom;
    }

    public static void main(String[] args) {
        List<SanPhamViewModel> list = new SanPhamRepository().getAll();
        for (SanPhamViewModel sanPhamViewModel : list) {
            System.out.println(sanPhamViewModel.toString());
        }
    }

    public boolean addSP(SanPham sp) {
        String query = "insert into SanPham (Ma,Ten) values (?,?)";
        int check = 0;
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean addSPCT(String id, SanPhamViewModel sp) {
        String query = "insert into ChiTietSP (IdSP,IdNsx,IdMauSac,IdDongSP,NamBH,MoTa,SoLuongTon,GiaNhap,GiaBan) values\n"
                + "                 (?,\n"
                + "                 (Select Id from NSX where Ten like ?),\n"
                + "                 (Select Id from MauSac where Ten like ?),\n"
                + "                 (Select Id from DongSP where Ten like ?),\n"
                + "                 ?,?,?,?,?)";
        int check = 0;
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, id);
            ps.setObject(2, sp.getTenNSX());
            ps.setObject(3, sp.getTenMS());
            ps.setObject(4, sp.getTenDSP());
            ps.setObject(5, sp.getNamBH());
            ps.setObject(6, sp.getMoTa());
            ps.setObject(7, sp.getSoLuong());
            ps.setObject(8, sp.getGiaNhap());
            ps.setObject(9, sp.getGiaBan());
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public String getID(String ma) {
        String query = "Select Id from SanPham where ma = ? ";
        String id = null;
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, ma);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return id;
    }

    public boolean deleteSP(String id) {
        String query = "Delete from SanPham where id = ?";
        int check = 0;
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateSP(String id, SanPham sp) {
        String query = "Update SanPham SET Ma = ? , Ten = ? where Id = ?";
        int check = 0;
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, sp.getMa());
            ps.setObject(2, sp.getTen());
            ps.setObject(3, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean updateSPCT(String id, SanPhamViewModel sp) {
        String query = "UPDATE [dbo].[ChiTietSP]\n"
                + "   SET [IdNsx] = (Select Id from NSX where Ten like ?)\n"
                + "      ,[IdMauSac] = (Select Id from MauSac where Ten like ?)\n"
                + "      ,[IdDongSP] = (Select Id from DongSP where Ten like ?)\n"
                + "      ,[NamBH] = ?\n"
                + "      ,[MoTa] = ?\n"
                + "      ,[SoLuongTon] = ?\n"
                + "      ,[GiaNhap] = ?\n"
                + "      ,[GiaBan] = ?\n"
                + " WHERE IdSP = ?";
        int check = 0;
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, sp.getTenNSX());
            ps.setObject(2, sp.getTenMS());
            ps.setObject(3, sp.getTenDSP());
            ps.setObject(4, sp.getNamBH());
            ps.setObject(5, sp.getMoTa());
            ps.setObject(6, sp.getSoLuong());
            ps.setObject(7, sp.getGiaNhap());
            ps.setObject(8, sp.getGiaBan());
            ps.setObject(9, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean deleteSPCT(String id) {
        String query = "Delete from ChiTietSP where idSP = ?";
        int check = 0;
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, id);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

}
