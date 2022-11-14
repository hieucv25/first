/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Services;

import DomainModels.KhachHang;
import java.util.List;

/**
 *
 * @author acer
 */
public interface ServiceKhachHang {

    List<KhachHang> getAll();

    String getID(String ma);
}
