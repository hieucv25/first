/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services.Impl;

import DomainModels.MauSac;
import java.util.List;
import Responsitories.MauSacRepository;

/**
 *
 * @author acer
 */
public class ServiceMauSacImpl implements Services.ServiceMauSac {

    private MauSacRepository ms = new MauSacRepository();

    @Override
    public List<MauSac> getAll() {
        return ms.getAll();
    }

}
