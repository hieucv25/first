/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitories;


import DomainModels.DongSanPham;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Utilities.SQLConnection;

/**
 *
 * @author acer
 */
public class DongSpRepository {

   
    public List<DongSanPham> getAll() {
        String query = "Select Ma,Ten from DongSP";
        List<DongSanPham> listDSP = new ArrayList<>();
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DongSanPham dsp = new DongSanPham(rs.getString(1), rs.getString(2));
                listDSP.add(dsp);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return listDSP;
    }
}
