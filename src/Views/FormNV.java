/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Views;

import javax.swing.table.DefaultTableModel;
import DomainModels.DongSanPham;
import DomainModels.NhaSanXuat;
import DomainModels.MauSac;
import DomainModels.SanPham;
import DomainModels.KhachHang;
import DomainModels.NhanVien;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import Services.Impl.ServiceDongSPImpl;
import Services.Impl.ServiceMauSacImpl;
import Services.Impl.ServiceNhaSanXuatImpl;
import ViewModels.SanPhamViewModel;
import ViewModels.HoaDonViewModel;
import Services.Impl.ServiceSanPhamImpl;
import Services.Impl.ServiceHoaDonImpl;
import Services.Impl.ServiceKhachHangImpl;
import Services.Impl.ServiceNhanVienImpl;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author acer
 */
public class FormNV extends javax.swing.JDialog {

    private DefaultTableModel tbmodel1 = new DefaultTableModel();
    private DefaultTableModel tbmodel3 = new DefaultTableModel();
    private DefaultComboBoxModel cbbmodel1 = new DefaultComboBoxModel();
    private DefaultComboBoxModel cbbmodel2 = new DefaultComboBoxModel();
    private DefaultComboBoxModel cbbmodel3 = new DefaultComboBoxModel();
    private DefaultComboBoxModel cbbmodel4 = new DefaultComboBoxModel();
    private DefaultComboBoxModel cbbmodel5 = new DefaultComboBoxModel();
    private DefaultComboBoxModel cbbmodel6 = new DefaultComboBoxModel();
    private DefaultComboBoxModel cbbmodel7 = new DefaultComboBoxModel();
    private List<String> listCBB1 = new ArrayList<>();
    private List<String> listCBB2 = new ArrayList<>();
    private List<String> listCBB3 = new ArrayList<>();
    private List<String> listCBB4 = new ArrayList<>();
    private List<String> listCBB5 = new ArrayList<>();
    private List<String> listCBB6 = new ArrayList<>();
    private List<String> listCBB7 = new ArrayList<>();
    private ServiceDongSPImpl svdsp = new ServiceDongSPImpl();
    private ServiceMauSacImpl svms = new ServiceMauSacImpl();
    private ServiceNhaSanXuatImpl svnsx = new ServiceNhaSanXuatImpl();
    private ServiceSanPhamImpl svsp = new ServiceSanPhamImpl();
    private List<MauSac> listMS = new ArrayList<>();
    private List<NhaSanXuat> listNSX = new ArrayList<>();
    private List<DongSanPham> listDSP = new ArrayList<>();
    private List<KhachHang> listKH = new ArrayList<>();
    private List<NhanVien> listNV = new ArrayList<>();
    private List<SanPhamViewModel> listSp = new ArrayList<>();
    private List<HoaDonViewModel> listHD = new ArrayList<>();
    private List<HoaDonViewModel> listHD2 = new ArrayList<>();
    private ServiceHoaDonImpl svhd = new ServiceHoaDonImpl();
    private ServiceKhachHangImpl svkh = new ServiceKhachHangImpl();
    private ServiceNhanVienImpl svnv = new ServiceNhanVienImpl();
    private int row = - 1;
    private String regexMaSP = "^[a-zA-Z]+[0-9]+$";
    private String regexNamBH = "^20[2-9]{2}";
    private String regexDate = "\\d{1,2}[-|/]\\d{1,2}[-|/]\\20[2-9]{2}";

    /**
     * Creates new form FormNV
     */
    public FormNV(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        listSp = svsp.getAll();
        listHD = svhd.getAll();
        jComboBox1.setModel(cbbmodel1);
        jComboBox2.setModel(cbbmodel2);
        jComboBox3.setModel(cbbmodel3);
        jComboBox4.setModel(cbbmodel5);
        jComboBox5.setModel(cbbmodel4);
        jComboBox6.setModel(cbbmodel6);
        jComboBox7.setModel(cbbmodel7);
        loadCBB1();
        loadCBB2();
        loadCBB3();
        loadCBB4();
        loadCBB5();
        loadCBB6();
        loadCBB7();
        loadDataSP(listSp);
        loadDataHD(listHD);
    }

    public String getRecord1() {
        int row = jTable1.getSelectedRow();
        return (row + 1) + "/" + listSp.size();
    }

    public void updateClickMouse(int index) {
        jTable1.setRowSelectionInterval(index, index);
        fillDataSP(row);
        jLabel5.setText(getRecord1());
    }

    public void prev() {
        if (row <= 0) {
            row = listSp.size() - 1;
            updateClickMouse(row);
        } else {
            row--;
            updateClickMouse(row);
        }

    }

    public void next() {
        if (row == listSp.size() - 1) {
            row = 0;
            updateClickMouse(row);
        } else {
            row++;
            updateClickMouse(row);
        }

    }

    public void fillDataSP(int index) {
        SanPhamViewModel sp = listSp.get(index);
        tfMaSP.setText(sp.getMaSP());
        tfTenSP.setText(sp.getTenSp());
        tfSoLuong.setText(String.valueOf(sp.getSoLuong()));
        tfGiaBan.setText(String.valueOf(sp.getGiaBan()));
        tfGiaNhap.setText(String.valueOf(sp.getGiaNhap()));
        tfMoTa.setText(sp.getMoTa());
        tfNamBH.setText(String.valueOf(sp.getNamBH()));
        jComboBox3.setSelectedItem(sp.getTenNSX());
        jComboBox1.setSelectedItem(sp.getTenMS());
        jComboBox2.setSelectedItem(sp.getTenDSP());
    }

    public void fillDataHD(int index) {
        HoaDonViewModel hd = listHD.get(index);
        jTextField4.setText(hd.getMaHD());
        jTextField8.setText(String.valueOf(hd.getNgayTao()));
        jComboBox5.setSelectedItem(hd.getTenSP());
        jComboBox6.setSelectedItem(hd.getTenNgNhan());
        jComboBox4.setSelectedItem(hd.getTenNV());
        jTextField11.setText(String.valueOf(hd.getSoLuong()));
        jTextField12.setText(String.valueOf(hd.getDonGia()));
        jTextField13.setText(hd.getSdt());
        jTextField7.setText(String.valueOf(hd.getThanhTien(hd.getSoLuong(), hd.getDonGia())));
        jTextArea1.setText(hd.getDiaChi());
        if (hd.getTinhTrang() == 0) {
            jComboBox7.setSelectedItem("Cho Thanh Toan");
        } else if (hd.getTinhTrang() == 1) {
            jComboBox7.setSelectedItem("Da Thanh Toan");
        } else {
            jComboBox7.setSelectedItem("Da Huy");
        }
    }

    public void loadCBB1() {
        listMS = svms.getAll();
        for (MauSac ms : listMS) {
            listCBB1.add(ms.getTen());
        }
        cbbmodel1.addAll(listCBB1);
        cbbmodel1.setSelectedItem("Black");
    }

    public void loadCBB2() {
        listDSP = svdsp.getAll();
        for (DongSanPham d : listDSP) {
            listCBB2.add(d.getTen());
        }
        cbbmodel2.addAll(listCBB2);
        cbbmodel2.setSelectedItem("AAA");
    }

    public void loadCBB3() {
        listNSX = svnsx.getAll();
        for (NhaSanXuat ns : listNSX) {
            listCBB3.add(ns.getTen());
        }
        cbbmodel3.addAll(listCBB3);
        cbbmodel3.setSelectedItem("Chanel");
    }

    public void loadCBB4() {
        for (SanPhamViewModel sp : listSp) {
            listCBB4.add(sp.getTenSp());
        }
        cbbmodel4.addAll(listCBB4);
        cbbmodel4.setSelectedItem("jean");
    }

    public void loadCBB5() {
        listNV = svnv.getAll();
        for (NhanVien nv : listNV) {
            listCBB5.add(nv.getTen());
        }
        cbbmodel5.addAll(listCBB5);
        cbbmodel5.setSelectedItem("Inui");
    }

    public void loadCBB6() {
        listKH = svkh.getAll();
        for (KhachHang kh : listKH) {
            listCBB6.add(kh.getTen());
        }
        cbbmodel6.addAll(listCBB6);
        cbbmodel6.setSelectedItem("ABC");
    }

    public void loadCBB7() {
        listCBB7.add("Cho Thanh Toan");
        listCBB7.add("Da Thanh Toan");
        listCBB7.add("Da Huy");
        cbbmodel7.addAll(listCBB7);
        cbbmodel7.setSelectedItem("Cho Thanh Toan");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        tfMaSP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfTenSP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfSoLuong = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        tfGiaNhap = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        tfGiaBan = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        tfNamBH = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        tfMoTa = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jTextField12 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton6 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Ma San Pham");

        jLabel3.setText("Ten San Pham");

        jLabel4.setText("So Luong");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Prev");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Next");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel5.setText("----");

        jLabel11.setText("NSX");

        jLabel12.setText("Mau Sac");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel13.setText("Dong San Pham");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Gia Nhap");

        jLabel21.setText("Gia Ban");

        jLabel22.setText("Nam Bao Hanh");

        jLabel23.setText("Mo Ta");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jButton4)
                .addGap(26, 26, 26)
                .addComponent(jLabel5)
                .addGap(30, 30, 30)
                .addComponent(jButton5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(277, 277, 277))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfTenSP)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(tfMaSP, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                            .addComponent(jLabel1)
                            .addComponent(tfGiaNhap)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfGiaBan)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel13))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfMoTa))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton2)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))))))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tfMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfGiaNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21)
                        .addGap(12, 12, 12)
                        .addComponent(tfGiaBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNamBH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(tfMoTa))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton5)
                                .addComponent(jLabel5))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh Sach San Pham", jPanel1);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        jLabel7.setText("Ma HD");

        jLabel8.setText("Ngay Tao");

        jLabel9.setText("Ten NV");

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Cho Thanh Toan");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setSelected(true);
        jRadioButton2.setText("Tat Ca");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton3);
        jRadioButton3.setText("Da Huy");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(jRadioButton4);
        jRadioButton4.setText("Da Thanh Toan");
        jRadioButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton4ActionPerformed(evt);
            }
        });

        jLabel16.setText("Ten San Pham");

        jLabel17.setText("So Luong");

        jLabel18.setText("Don Gia");

        jLabel6.setText("Tong Tien");

        jLabel10.setText("Ten Nguoi Nhan");

        jLabel14.setText("SDT");

        jLabel15.setText("Dia Chi");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jButton6.setText("Add");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel20.setText("Tinh Trang");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jRadioButton1)
                        .addGap(31, 31, 31)
                        .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jRadioButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jComboBox4, 0, 172, Short.MAX_VALUE)
                                    .addComponent(jComboBox5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(29, 29, 29)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGap(119, 119, 119)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(33, 33, 33))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jComboBox7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGap(52, 52, 52)))))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 959, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2)
                    .addComponent(jRadioButton3)
                    .addComponent(jRadioButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel17)
                    .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18)
                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel14)
                    .addComponent(jTextField13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20)
                                .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton6))
                            .addComponent(jLabel19))
                        .addGap(61, 61, 61))))
        );

        jTabbedPane1.addTab("Danh Sach Hoa Don", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int rowSelected = jTable1.getSelectedRow();
        fillDataSP(rowSelected);

    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String ma = tfMaSP.getText();
        String tenSP = tfTenSP.getText();
        String soLuong = tfSoLuong.getText();
        String giaNhap = tfGiaNhap.getText();
        String giaBan = tfGiaBan.getText();
        String namBH = tfNamBH.getText();
        String moTa = tfMoTa.getText();
        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ma San Pham Chua Duoc Nhap!");
            return;
        } else if (tenSP.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ten San Pham Chua Duoc Nhap!");
            return;
        } else if (!ma.matches(regexMaSP)) {
            JOptionPane.showMessageDialog(this, "Ma San Pham Chua Dung Dinh Dang!");
            return;
        } else if (!tenSP.matches("[a-zA-z ]+")) {
            JOptionPane.showMessageDialog(this, "Ten San Pham Chua Dung Dinh Dang!");
            return;
        } else if (soLuong.isEmpty()) {
            JOptionPane.showMessageDialog(this, "So Luong Chua Duoc Nhap!");
            return;
        } else if (!soLuong.matches("[1-9][0-9]+")) {
            JOptionPane.showMessageDialog(this, "So Luong Phai La So!");
            return;
        } else if (Integer.valueOf(soLuong) <= 0) {
            JOptionPane.showMessageDialog(this, "So Luong Phai Lon Hon 0!");
            return;
        } else if (giaNhap.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Gia Nhap Chua Duoc Nhap!");
            return;
        } else if (!giaNhap.matches("[1-9][0-9]+")) {
            JOptionPane.showMessageDialog(this, "Gia Nhap Phai La So!");
            return;
        } else if (Integer.valueOf(giaNhap) <= 10000) {
            JOptionPane.showMessageDialog(this, "Gia Nhap Phai Lon Hon 10000!");
            return;
        } else if (giaBan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Gia Ban Chua Duoc Nhap!");
            return;
        } else if (!giaBan.matches("[1-9][0-9]+")) {
            JOptionPane.showMessageDialog(this, "Gia Ban Phai La So!");
            return;
        } else if (Integer.valueOf(giaBan) <= 10000) {
            JOptionPane.showMessageDialog(this, "Gia Ban Phai Lon Hon 10000!");
            return;
        } else if (!namBH.matches(regexNamBH)) {
            JOptionPane.showMessageDialog(this, "Nam BH Phai La So Va Nam Trong Khoang Tu 2022 Den 2099");
            return;
        } else if (namBH.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nam BH Chua Duoc Nhap!");
            return;
        }
        for (SanPhamViewModel sp : listSp) {
            if (ma.equalsIgnoreCase(sp.getMaSP())) {
                JOptionPane.showMessageDialog(this, "Trung Ma San Pham!");
            }
        }
        String dongSP = String.valueOf(jComboBox2.getSelectedItem());
        String mauSac = String.valueOf(jComboBox1.getSelectedItem());
        String nsx = String.valueOf(jComboBox3.getSelectedItem());
        SanPham sp1 = new SanPham(ma, tenSP);
        int i1 = Integer.valueOf(giaNhap);
        int i2 = Integer.valueOf(giaBan);
        boolean a = svsp.addSP(sp1);
        if (a == true) {
            String id = svsp.getID(ma);
            SanPhamViewModel sp2 = new SanPhamViewModel(ma, tenSP, Integer.valueOf(namBH),
                    moTa, Integer.valueOf(soLuong), BigDecimal.valueOf(i1),
                    BigDecimal.valueOf(i2), nsx, mauSac, dongSP);
            if (svsp.addSPCT(id, sp2)) {
                JOptionPane.showMessageDialog(this, "Add thanh cong!");
                listSp = svsp.getAll();
                loadDataSP(listSp);
            } else {
                if (svsp.deleteSP(id)) {
                    JOptionPane.showMessageDialog(this, "Add that bai!");
                } else {
                    JOptionPane.showMessageDialog(this, "Error!");
                }
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int rowSelect = jTable1.getSelectedRow();
        String ma = tfMaSP.getText();
        String tenSP = tfTenSP.getText();
        String soLuong = tfSoLuong.getText();
        String giaNhap = tfGiaNhap.getText();
        String giaBan = tfGiaBan.getText();
        String namBH = tfNamBH.getText();
        String moTa = tfMoTa.getText();
        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ma San Pham Chua Duoc Nhap!");
            return;
        } else if (tenSP.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ten San Pham Chua Duoc Nhap!");
            return;
        } else if (!ma.matches(regexMaSP)) {
            JOptionPane.showMessageDialog(this, "Ma San Pham Chua Dung Dinh Dang!");
            return;
        } else if (!tenSP.matches("[a-zA-z ]+")) {
            JOptionPane.showMessageDialog(this, "Ten San Pham Chua Dung Dinh Dang!");
            return;
        } else if (soLuong.isEmpty()) {
            JOptionPane.showMessageDialog(this, "So Luong Chua Duoc Nhap!");
            return;
        } else if (!soLuong.matches("[1-9][0-9]+")) {
            JOptionPane.showMessageDialog(this, "So Luong Phai La So!");
            return;
        } else if (Integer.valueOf(soLuong) <= 0) {
            JOptionPane.showMessageDialog(this, "So Luong Phai Lon Hon 0!");
            return;
        } else if (giaNhap.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Gia Nhap Chua Duoc Nhap!");
            return;
        } else if (!giaNhap.matches("[1-9][0-9]+")) {
            JOptionPane.showMessageDialog(this, "Gia Nhap Phai La So!");
            return;
        } else if (Integer.valueOf(giaNhap) <= 10000) {
            JOptionPane.showMessageDialog(this, "Gia Nhap Phai Lon Hon 10000!");
            return;
        } else if (giaBan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Gia Ban Chua Duoc Nhap!");
            return;
        } else if (!giaBan.matches("[1-9][0-9]+")) {
            JOptionPane.showMessageDialog(this, "Gia Ban Phai La So!");
            return;
        } else if (Integer.valueOf(giaBan) <= 10000) {
            JOptionPane.showMessageDialog(this, "Gia Ban Phai Lon Hon 10000!");
            return;
        } else if (!namBH.matches(regexNamBH)) {
            JOptionPane.showMessageDialog(this, "Nam BH Phai La So Va Nam Trong Khoang Tu 2022 Den 2099");
            return;
        } else if (namBH.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Nam BH Chua Duoc Nhap!");
            return;
        }
//        for (SanPhamViewModel sp : listSp) {
//            if (ma.equalsIgnoreCase(sp.getMaSP())) {
//                JOptionPane.showMessageDialog(this, "Trung Ma San Pham!");
//            }
//        }
        String dongSP = String.valueOf(jComboBox2.getSelectedItem());
        String mauSac = String.valueOf(jComboBox1.getSelectedItem());
        String nsx = String.valueOf(jComboBox3.getSelectedItem());
        SanPham sp1 = new SanPham(ma, tenSP);
        int i1 = Integer.valueOf(giaNhap);
        int i2 = Integer.valueOf(giaBan);
        if (rowSelect >= 0) {
            SanPhamViewModel spvm = listSp.get(rowSelect);
            String id = svsp.getID(spvm.getMaSP());
            SanPhamViewModel sp2 = new SanPhamViewModel(ma, tenSP, Integer.valueOf(namBH),
                    moTa, Integer.valueOf(soLuong), BigDecimal.valueOf(i1),
                    BigDecimal.valueOf(i2), nsx, mauSac, dongSP);
            if (svsp.updateSP(id, sp1) == true) {
                if (svsp.updateSPCT(id, sp2)) {
                    JOptionPane.showMessageDialog(this, "Update thanh cong!");
                    listSp = svsp.getAll();
                    loadDataSP(listSp);
                } else {
                    if (svsp.deleteSP(id)) {
                        JOptionPane.showMessageDialog(this, "Update that bai!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Error!");
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int rowSelect = jTable1.getSelectedRow();
        if (rowSelect >= 0) {
            String ma = tfMaSP.getText();
            String id = svsp.getID(ma);
            if (svsp.deleteSPCT(id)) {
                if (svsp.deleteSP(id)) {
                    JOptionPane.showMessageDialog(this, "Xoa thanh cong!");
                    listSp = svsp.getAll();
                    loadDataSP(listSp);
                }
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        prev();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        next();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
        int rowSelected = jTable3.getSelectedRow();
        fillDataHD(rowSelected);
    }//GEN-LAST:event_jTable3MouseClicked

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        int i = 0;
        listHD2 = svhd.getTT(i);
        loadDataHD(listHD2);
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        loadDataHD(listHD);
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        int i = 2;
        listHD2 = svhd.getTT(i);
        loadDataHD(listHD2);
    }//GEN-LAST:event_jRadioButton3ActionPerformed

    private void jRadioButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton4ActionPerformed
        // TODO add your handling code here:
        int i = 1;
        listHD2 = svhd.getTT(i);
        loadDataHD(listHD2);
    }//GEN-LAST:event_jRadioButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            String maHD = jTextField4.getText();
            String ngayTao = jTextField8.getText();
            String soLuong = jTextField11.getText();
            String donGia = jTextField12.getText();
            String sdt = jTextField13.getText();
            String tenSP = String.valueOf(jComboBox5.getSelectedItem());
            String tenNV = String.valueOf(jComboBox4.getSelectedItem());
            String tenNN = String.valueOf(jComboBox6.getSelectedItem());
            String diaChi = jTextArea1.getText();
            int tt;
            if (jComboBox7.getSelectedIndex() == 0) {
                tt = 0;
            } else if (jComboBox7.getSelectedIndex() == 1) {
                tt = 1;
            } else {
                tt = 2;
            }
            if (maHD.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ma HD Chua Duoc Nhap!");
            }
            for (HoaDonViewModel hdd : listHD) {
                if (maHD.equalsIgnoreCase(hdd.getMaHD())) {
                    JOptionPane.showMessageDialog(this, "Trung Ma HD!");
                }
            }
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(ngayTao);

            String idSP = svhd.getIDSP(tenSP);
            HoaDonViewModel hd = new HoaDonViewModel(maHD, date, tenNV, tt, tenNN, diaChi, sdt, tenSP, Integer.valueOf(soLuong), Double.valueOf(donGia));
            if (svhd.addHD(tenNV, tenNN, hd)) {
                if (svhd.addHDCT(maHD, idSP, Integer.valueOf(soLuong), Double.valueOf(donGia)) == true) {
                    JOptionPane.showMessageDialog(this, "Add thanh cong!");
                    listHD = svhd.getAll();
                    loadDataHD(listHD);
                } else {
                    svhd.deleteHD(maHD);
                    JOptionPane.showMessageDialog(this, "Add that bai!");
                }
            }
        } catch (ParseException ex) {
            Logger.getLogger(FormNV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed
    public void loadDataSP(List<SanPhamViewModel> list) {
        jTable1.setModel(tbmodel1);
        String title1[] = {"STT", "Ma SP", "Ten SP", "Nam Bao Hanh",
            "Mo Ta", "So Luong Ton", "Gia Nhap", "Gia Ban", "NSX", "Mau Sac", "Dong SP"};
        tbmodel1.setColumnIdentifiers(title1);
        tbmodel1.setRowCount(0);
        int i = 0;
        for (SanPhamViewModel sp : list) {
            tbmodel1.addRow(new Object[]{i, sp.getMaSP(), sp.getTenSp(), sp.getNamBH(),
                sp.getMoTa(), sp.getSoLuong(), sp.getGiaNhap(), sp.getGiaBan(),
                sp.getTenNSX(), sp.getTenMS(), sp.getTenDSP()});
            i++;
        }
    }

    public void loadDataHD(List<HoaDonViewModel> list) {
        jTable3.setModel(tbmodel3);
        String title3[] = {"STT", "Ma HD", "Ngay Tao", "Ten NV", "Tinh Trang",
            "Ten Nguoi Nhan", "Dia Chi", "SDT", "Ten San Pham", "So Luong",
            "Don Gia", "Tong Tien"};
        tbmodel3.setColumnIdentifiers(title3);
        tbmodel3.setRowCount(0);
        int i = 0;
        for (HoaDonViewModel hd : list) {
            tbmodel3.addRow(new Object[]{i, hd.getMaHD(), hd.getNgayTao(), hd.getTenNV(),
                hd.getTrangThai(hd.getTinhTrang()), hd.getTenNgNhan(), hd.getDiaChi(),
                hd.getSdt(), hd.getTenSP(), hd.getSoLuong(), hd.getDonGia(), hd.getThanhTien(hd.getSoLuong(), hd.getDonGia())});
            i++;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormNV dialog = new FormNV(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField tfGiaBan;
    private javax.swing.JTextField tfGiaNhap;
    private javax.swing.JTextField tfMaSP;
    private javax.swing.JTextField tfMoTa;
    private javax.swing.JTextField tfNamBH;
    private javax.swing.JTextField tfSoLuong;
    private javax.swing.JTextField tfTenSP;
    // End of variables declaration//GEN-END:variables

}
