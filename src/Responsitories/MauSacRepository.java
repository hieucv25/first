/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Responsitories;


import DomainModels.MauSac;
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
public class MauSacRepository {

    public List<MauSac> getAll() {
        String query = "Select Ma,Ten from MauSac";
        List<MauSac> listMS = new ArrayList<>();
        try ( Connection conn = SQLConnection.getConnection();  PreparedStatement ps = conn.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                MauSac ms = new MauSac(rs.getString(1), rs.getString(2));
                listMS.add(ms);
            }
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        }
        return listMS;
    }

}
