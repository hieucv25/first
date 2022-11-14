/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitories;


import DomainModels.NhaSanXuat;
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
public class NhaSanXuatRepository {

    public List<NhaSanXuat> getAll() {

        String query = "Select Ma,Ten from NSX";
        List<NhaSanXuat> listNSX = new ArrayList<>();
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NhaSanXuat nsx = new NhaSanXuat(rs.getString(1), rs.getString(2));
                listNSX.add(nsx);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return listNSX;

    }

}
