/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitories;


import DomainModels.KhachHang;
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
public class KhachHangRepository  {

    
    public List<KhachHang> getAll() {
        String query = "select Id,Ma,Ten,NgaySinh,MatKhau,sdt,DiaChi,ThanhPho,QuocGia from KhachHang ";
        List<KhachHang> listKH = new ArrayList<>();
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang(rs.getString("Id"), rs.getString("Ma"), rs.getString("Ten"),
                        rs.getDate("NgaySinh"), rs.getString("sdt"),
                        rs.getString("DiaChi"), rs.getString("ThanhPho"), rs.getString("QuocGia"), rs.getString("MatKhau"));
                listKH.add(kh);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return listKH;
    }

   
    public String getIDCustomer(String ma) {
        String id = null;
        String query = "select Id from KhachHang where Ma = ?";
        List<KhachHang> listKH = new ArrayList<>();
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
    public static void main(String[] args) {
        List<KhachHang> list = new KhachHangRepository().getAll();
        for (KhachHang khachHang : list) {
            System.out.println(khachHang.toString());
        }
    }

}
