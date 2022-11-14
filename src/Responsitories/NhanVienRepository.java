/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitories;


import DomainModels.NhanVien;
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
public class NhanVienRepository {

    public List<NhanVien> getAll() {
        String query = "select Ma,Ten,GioiTinh,NgaySinh,DiaChi,sdt,MatKhau,TrangThai from NhanVien";
        List<NhanVien> listNV = new ArrayList<>();
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getDate(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getInt(8));
                listNV.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return listNV;
    }

}
