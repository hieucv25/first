/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitories;


import ViewModels.HoaDonViewModel;
import java.util.List;
import Utilities.SQLConnection;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author acer
 */
public class HoaDonRepository {

    public List<HoaDonViewModel> getAll() {
        String query = "select hd.Ma,hd.NgayTao,nv.Ten,hd.TinhTrang,hd.TenNguoiNhan,hd.DiaChi,hd.Sdt,sp.Ten,hdct.SoLuong,hdct.DonGia from \n"
                + "NhanVien nv join HoaDon hd on hd.IdNV = nv.Id join HoaDonChiTiet hdct on hd.Id = hdct.IdHoaDon\n"
                + "join ChiTietSP ctsp on hdct.IdChiTietSP = ctsp.Id join SanPham sp on ctsp.IdSP = sp.Id";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            List<HoaDonViewModel> listHD = new ArrayList<>();
            while (rs.next()) {
                HoaDonViewModel hd = new HoaDonViewModel(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getInt(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getDouble(10)
                );
                listHD.add(hd);
            }
            return listHD;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public List<HoaDonViewModel> getTT(int tt) {
        String query = "select hd.Ma,hd.NgayTao,nv.Ten,hd.TinhTrang,hd.TenNguoiNhan,hd.DiaChi,hd.Sdt,sp.Ten,hdct.SoLuong,hdct.DonGia from \n"
                + "NhanVien nv join HoaDon hd on hd.IdNV = nv.Id join HoaDonChiTiet hdct on hd.Id = hdct.IdHoaDon\n"
                + "join ChiTietSP ctsp on hdct.IdChiTietSP = ctsp.Id join SanPham sp on ctsp.IdSP = sp.Id where hd.TinhTrang = ?";

        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, tt);
            ResultSet rs = ps.executeQuery();
            List<HoaDonViewModel> listHD = new ArrayList<>();
            while (rs.next()) {
                HoaDonViewModel hd = new HoaDonViewModel(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getInt(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getDouble(10)
                );
                listHD.add(hd);
            }
            return listHD;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public boolean addHD(String tenNV, String tenKH, HoaDonViewModel hd) {
        String query = "INSERT INTO [dbo].[HoaDon]\n"
                + "           ([IdKH]\n"
                + "           ,[IdNV]\n"
                + "           ,[Ma]\n"
                + "           ,[NgayTao]\n"
                + "           ,[TinhTrang]\n"
                + "           ,[TenNguoiNhan]\n"
                + "           ,[DiaChi]\n"
                + "           ,[Sdt])\n"
                + "     VALUES\n"
                + "           ((Select Id from KhachHang where Ten like ?)\n"
                + "           ,(select Id from NhanVien where Ten like ?)\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        int check = 0;
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, tenKH);
            ps.setObject(2, tenNV);
            ps.setObject(3, hd.getMaHD());
            ps.setObject(4, hd.getNgayTao());
            ps.setObject(5, hd.getTinhTrang());
            ps.setObject(6, hd.getTenNgNhan());
            ps.setObject(7, hd.getDiaChi());
            ps.setObject(8, hd.getSdt());
            check = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public String getIDSP(String ten) {
        String query = "select Id from SanPham where Ten like ?";
        String id = null;
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, ten);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return id;
    }

    public boolean addHDCT(String maHoaDon, String idSP, int soLuong, Double donGia) {
        String query = "INSERT INTO [dbo].[HoaDonChiTiet]\n"
                + "           ([IdHoaDon]\n"
                + "           ,[IdChiTietSP]\n"
                + "           ,[SoLuong]\n"
                + "           ,[DonGia])\n"
                + "     VALUES\n"
                + "           ((Select Id from HoaDon where Ma like ?)\n"
                + "           ,(Select Id from ChiTietSP where IdSP = ?)\n"
                + "           ,?\n"
                + "           ,?)";
        int check = 0;
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, maHoaDon);
            ps.setObject(2, idSP);
            ps.setObject(3, soLuong);
            ps.setObject(4, donGia);
            check = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public boolean deleteHD(String maHD) {
        String query = "Delete from HoaDon where Ma = ?";
        int check = 0;
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, maHD);
            check = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return check > 0;
    }

    public List<HoaDonViewModel> getFollowIDKH(String id) {
        String query = "select hd.Ma,hd.NgayTao,nv.Ten,hd.TinhTrang,hd.TenNguoiNhan,hd.DiaChi,hd.Sdt,sp.Ten,hdct.SoLuong,hdct.DonGia from \n"
                + "NhanVien nv join HoaDon hd on hd.IdNV = nv.Id join HoaDonChiTiet hdct on hd.Id = hdct.IdHoaDon\n"
                + "join ChiTietSP ctsp on hdct.IdChiTietSP = ctsp.Id join SanPham sp on ctsp.IdSP = sp.Id join KhachHang kh on hd.IdKH = kh.Id where kh.Id = ?";
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setObject(1, id);
            ResultSet rs = ps.executeQuery();
            List<HoaDonViewModel> listHD = new ArrayList<>();
            while (rs.next()) {
                HoaDonViewModel hd = new HoaDonViewModel(rs.getString(1), rs.getDate(2), rs.getString(3), rs.getInt(4), rs.getString(5),
                        rs.getString(6), rs.getString(7), rs.getString(8), rs.getInt(9), rs.getDouble(10)
                );
                listHD.add(hd);
            }
            return listHD;
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

}
