package gui.form;

import dao.DAO_CT_HoaDonBan;
import dao.DAO_HoaDonBan;
import dao.DAO_NhanVien;
import dao.DAO_Thuoc;
import entity.CT_HoaDonBan;
import entity.HoaDonBan;
import entity.NhanVien;
import entity.Thuoc;
import java.awt.Color;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class Form_ThongKe extends javax.swing.JPanel {

    private DAO_NhanVien nhanVien_dao = new DAO_NhanVien();
    private DAO_HoaDonBan hoaDonBan_dao = new DAO_HoaDonBan();
    private DAO_CT_HoaDonBan chiTietHD_dao = new DAO_CT_HoaDonBan();
    private DAO_Thuoc thuoc_dao = new DAO_Thuoc();
    private DefaultTableModel modelNhanVien;
    private DefaultTableModel modelThongKeThuocTheoNgay;
    private DefaultTableModel modelThongKeThuocHetHan;
    private DefaultTableModel modelThongKeThuocDaHetHan;
    private ArrayList<NhanVien> listNhanVien;
    private ArrayList<HoaDonBan> listHoaDonBanTheoNgay;
    private ArrayList<Thuoc> listThuoc;
    private ArrayList<Thuoc> listThuocDaHetHan;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    private Date date = new Date();
    private String maNV;
   

    public Form_ThongKe() {
        initComponents();

        listNhanVien = nhanVien_dao.getMaVaTenNV();
        listThuoc = thuoc_dao.getThuocHetHan();
        listThuocDaHetHan = thuoc_dao.getThuocDaHetHan();
        themDuLieuNhanVienVaoBang(listNhanVien);
        themDuLieuThuocSapHetHanVaoBang(listThuoc);
        themDuLieuThuocDaHetHanVaoBang(listThuocDaHetHan);
        dcNgay.setDate(date);
        maNV = "";
        txtMaNV.setEnabled(false);
        txtTenNV.setEnabled(false);
        tableNhanVien.setEnabled(false);
        tableNhanVien.setForeground(new Color(242, 242, 242));
        modelThongKeThuocTheoNgay = (DefaultTableModel) tableThongkeThuocNgay.getModel();
        getTatCaHoaDonTheoNgayCuaQuanLi(dateFormat.format(dcNgay.getDate()));
        ChartPanel chartPanelNull = new ChartPanel(showChartNull());
        panelTKThang.add(chartPanelNull);
        ChartPanel chartPanelNullNam = new ChartPanel(showChartNullNam());
        pnelTKNam.add(chartPanelNullNam);

    }

    private void themDuLieuNhanVienVaoBang(ArrayList<NhanVien> listNhanVien) {
        modelNhanVien = (DefaultTableModel) tableNhanVien.getModel();
        for (NhanVien nv : listNhanVien) {
            modelNhanVien.addRow(new Object[]{
                nv.getMaNV(),
                nv.getTenNV()
            });
        }
    }

    private void themDuLieuThuocSapHetHanVaoBang(ArrayList<Thuoc> listThuoc) {
        modelThongKeThuocHetHan = (DefaultTableModel) tableThuocHetHan.getModel();
        for (Thuoc t : listThuoc) {
            modelThongKeThuocHetHan.addRow(new Object[]{
                t.getMaThuoc(),
                t.getTenThuoc(),
                t.getSoDK(),
                t.getSoLuongBanDau(),
                t.getHanSuDung()
            });
        }
    }

    private void themDuLieuThuocDaHetHanVaoBang(ArrayList<Thuoc> listThuoc) {
        modelThongKeThuocDaHetHan = (DefaultTableModel) tableThuocDaHetHan.getModel();
        for (Thuoc t : listThuocDaHetHan) {
            modelThongKeThuocDaHetHan.addRow(new Object[]{
                t.getMaThuoc(),
                t.getTenThuoc(),
                t.getSoLuongBanDau(),
                t.getGiaBan(),
                t.getHanSuDung()
            });
        }
    }

    private void exportExcel(JTable table, DefaultTableModel model, String tenFile) {
        try {
            String filename = "src\\xuatfile\\" + tenFile + ".xlsx";
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("XuatFileTest");
            double tongtien = 0;
            HSSFRow rowhead = sheet.createRow((short) 0);
            for (int j = 0; j < table.getColumnCount(); j++) {
                rowhead.createCell(j).setCellValue(model.getColumnName(j));
            }

            for (int j = 0; j < table.getRowCount(); j++) {
                HSSFRow row = sheet.createRow((short) j + 1);
                for (int k = 0; k < table.getColumnCount(); k++) {
                    row.createCell(k).setCellValue(model.getValueAt(j, k).toString());
                }

            }
            if (table.getColumnName(table.getColumnCount() - 1) == "Thành tiền") {
                HSSFRow rowheadTong = sheet.createRow((short) table.getRowCount() + 1);
                rowheadTong.createCell(table.getColumnCount() - 2).setCellValue("Tổng tiền");
                rowheadTong.createCell(table.getColumnCount() - 1).setCellValue(lblTongDoanhThu.getText());
            }

//            rowheadTong.createCell(table.getColumnCount()-1).setCellValue();
            FileOutputStream fileout = new FileOutputStream(filename);
            workbook.write(fileout);
            fileout.close();
            workbook.close();
            JOptionPane.showMessageDialog(null, "Xuất file thành công!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi khi xuất file!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        cbbLoaiThongKe = new javax.swing.JComboBox<>();
        btnThongKe = new javax.swing.JButton();
        btnXuatFile = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tableNhanVien = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        tabbedPane = new javax.swing.JTabbedPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        dcNgay = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        lblTongHoaDon = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblTongDoanhThu = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableThongkeThuocNgay = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lblTongHoaDonTheoThang = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblTongDoanhThuTheoThang = new javax.swing.JLabel();
        cbbThang = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        panelTKThang = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        panelTKNam = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jYCYear = new com.toedter.calendar.JYearChooser();
        jLabel13 = new javax.swing.JLabel();
        lblTongHoaDonNam = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblTongDoanhThuNam = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        pnelTKNam = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableThuocHetHan = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableThuocDaHetHan = new javax.swing.JTable();

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Thống kê: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Tìm kiếm nhân viên");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Mã NV:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Tên: ");

        txtMaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaNVKeyReleased(evt);
            }
        });

        txtTenNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTenNV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTenNVKeyReleased(evt);
            }
        });

        cbbLoaiThongKe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Cá nhân" }));
        cbbLoaiThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiThongKeActionPerformed(evt);
            }
        });

        btnThongKe.setBackground(new java.awt.Color(0, 102, 102));
        btnThongKe.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThongKe.setForeground(new java.awt.Color(255, 255, 255));
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/iconBTNThongKe.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.setPreferredSize(new java.awt.Dimension(134, 40));
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        btnXuatFile.setBackground(new java.awt.Color(0, 102, 102));
        btnXuatFile.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXuatFile.setForeground(new java.awt.Color(255, 255, 255));
        btnXuatFile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/iconBTNThongKe.png"))); // NOI18N
        btnXuatFile.setText("Xuất File");
        btnXuatFile.setPreferredSize(new java.awt.Dimension(134, 40));
        btnXuatFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaNV)
                            .addComponent(txtTenNV)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbLoaiThongKe, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbLoaiThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tableNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Tên nhân viên"
            }
        ));
        jScrollPane3.setViewportView(tableNhanVien);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tabbedPane.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabbedPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabbedPaneMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Chọn ngày: ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Tổng hóa đơn: ");

        lblTongHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTongHoaDon.setText("****");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Tổng doanh thu: ");

        lblTongDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTongDoanhThu.setText("******");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTongHoaDon)
                        .addGap(122, 122, 122)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTongDoanhThu))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dcNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(569, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dcNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblTongHoaDon)
                    .addComponent(jLabel9)
                    .addComponent(lblTongDoanhThu))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        tableThongkeThuocNgay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thuốc", "Tên thuốc", "Số lượng bán ", "Giá", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableThongkeThuocNgay);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 443, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Theo ngày", jPanel5);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("Thống kê doanh thu theo tháng trong năm");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Chọn tháng: ");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("Tổng hóa đơn: ");

        lblTongHoaDonTheoThang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTongHoaDonTheoThang.setText("****");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Tổng doanh thu: ");

        lblTongDoanhThuTheoThang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTongDoanhThuTheoThang.setText("**********");

        cbbThang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTongHoaDonTheoThang)
                .addGap(40, 40, 40)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTongDoanhThuTheoThang)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(308, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(294, 294, 294))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 44, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel12)
                        .addComponent(lblTongHoaDonTheoThang)
                        .addComponent(jLabel14)
                        .addComponent(lblTongDoanhThuTheoThang)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelTKThang.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(panelTKThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(panelTKThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 447, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Theo tháng", jPanel7);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Thống kê doanh thu theo năm");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Chọn năm: ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Tổng hóa đơn:");

        lblTongHoaDonNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTongHoaDonNam.setText("***");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Tổng doanh thu trong năm:");

        lblTongDoanhThuNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTongDoanhThuNam.setText("***********");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(311, 311, 311)
                        .addComponent(jLabel8))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jYCYear, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTongHoaDonNam)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTongDoanhThuNam)))
                .addContainerGap(276, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(17, 17, 17)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jYCYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(lblTongHoaDonNam)
                        .addComponent(jLabel16)
                        .addComponent(lblTongDoanhThuNam)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnelTKNam.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(pnelTKNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(pnelTKNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 452, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelTKNamLayout = new javax.swing.GroupLayout(panelTKNam);
        panelTKNam.setLayout(panelTKNamLayout);
        panelTKNamLayout.setHorizontalGroup(
            panelTKNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelTKNamLayout.setVerticalGroup(
            panelTKNamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTKNamLayout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(panelTKNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelTKNam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Theo năm", jPanel8);

        tableThuocHetHan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thuốc", "Tên thuốc", "Số đăng ký", "Số lượng", "Hạn sử dụng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableThuocHetHan);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Thuốc sắp hết hạn", jPanel9);

        tableThuocDaHetHan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã thuốc", "Tên thuốc", "Số lượng", "Giá", "Hạn sử dụng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Long.class, java.lang.Double.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tableThuocDaHetHan);

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 968, Short.MAX_VALUE)
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 528, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        tabbedPane.addTab("Thuốc hết hạn", jPanel10);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPane)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(tabbedPane)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaNVKeyReleased
        listNhanVien = nhanVien_dao.timNVTheoTenVaSdt(txtMaNV.getText(), txtTenNV.getText());
        modelNhanVien.getDataVector().removeAllElements();
        modelNhanVien.fireTableDataChanged();
        if (listNhanVien.size() == 0) {
            return;
        }
        new Thread(() -> {
            for (NhanVien t : listNhanVien) {
                modelNhanVien.addRow(new Object[]{t.getMaNV(), t.getTenNV()});
            }
        }).start();
    }//GEN-LAST:event_txtMaNVKeyReleased

    private void txtTenNVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenNVKeyReleased
        listNhanVien = nhanVien_dao.timNVTheoTenVaSdt(txtMaNV.getText(), txtTenNV.getText());
        modelNhanVien.getDataVector().removeAllElements();
        modelNhanVien.fireTableDataChanged();
        if (listNhanVien.size() == 0) {
            return;
        }
        new Thread(() -> {
            for (NhanVien t : listNhanVien) {
                modelNhanVien.addRow(new Object[]{t.getMaNV(), t.getTenNV()});
            }
        }).start();
    }//GEN-LAST:event_txtTenNVKeyReleased

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        if (tabbedPane.getSelectedIndex() == 0) {
            String ngayStr = dateFormat.format(dcNgay.getDate());
            if (cbbLoaiThongKe.getSelectedIndex() != 0) {
                getHoaDonCuaNhanVienTheoNgay(ngayStr);
            } else {
                getTatCaHoaDonTheoNgayCuaQuanLi(ngayStr);
            }
        } else if (tabbedPane.getSelectedIndex() == 1) {
            thongKeThang();
        } else if (tabbedPane.getSelectedIndex() == 2) {
            thongKeNam();
        }
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void cbbLoaiThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiThongKeActionPerformed
        if (cbbLoaiThongKe.getSelectedIndex() == 0) {
            maNV = "";
            txtMaNV.setEnabled(false);
            txtTenNV.setEnabled(false);
            tableNhanVien.setEnabled(false);
            tableNhanVien.setForeground(new Color(242, 242, 242));
        } else {
            maNV = "";
            txtMaNV.setEnabled(true);
            txtTenNV.setEnabled(true);
            tableNhanVien.setEnabled(true);
            tableNhanVien.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_cbbLoaiThongKeActionPerformed

    private void btnXuatFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatFileActionPerformed
        if (tabbedPane.getSelectedIndex() == 0) {
            String ngayStr = dateFormat.format(dcNgay.getDate());
            if (cbbLoaiThongKe.getSelectedIndex() != 0) {
                getHoaDonCuaNhanVienTheoNgay(ngayStr);
                exportExcel(tableThongkeThuocNgay, modelThongKeThuocTheoNgay, "ThuocBanTrongNgayCuaNhanVien");
            } else {
                getTatCaHoaDonTheoNgayCuaQuanLi(ngayStr);
                exportExcel(tableThongkeThuocNgay, modelThongKeThuocTheoNgay, "ThuocBanTrongNgayCuaQuanLy");
            }
        } else if (tabbedPane.getSelectedIndex() == 1) {
            System.out.println("1");
        } else if (tabbedPane.getSelectedIndex() == 2) {
            System.out.println("2");
        } else if (tabbedPane.getSelectedIndex() == 3) {
            exportExcel(tableThuocHetHan, modelThongKeThuocHetHan, "ThuocSapHetHang");
        } else if (tabbedPane.getSelectedIndex() == 4) {
            exportExcel(tableThuocDaHetHan, modelThongKeThuocDaHetHan, "ThuocDaHetHang");
        }
    }//GEN-LAST:event_btnXuatFileActionPerformed

    private void tabbedPaneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabbedPaneMouseClicked
        if (tabbedPane.getSelectedIndex() == 0) {
            btnXuatFile.setEnabled(true);
        } else if (tabbedPane.getSelectedIndex() == 1) {
            btnXuatFile.setEnabled(false);
        } else if (tabbedPane.getSelectedIndex() == 2) {
            btnXuatFile.setEnabled(false);
        } else if (tabbedPane.getSelectedIndex() == 3) {
            btnXuatFile.setEnabled(true);
        } else if (tabbedPane.getSelectedIndex() == 4) {
            btnXuatFile.setEnabled(true);
        }    }//GEN-LAST:event_tabbedPaneMouseClicked

    private void getHoaDonCuaNhanVienTheoNgay(String ngay) {
        modelThongKeThuocTheoNgay = (DefaultTableModel) tableThongkeThuocNgay.getModel();
        int row = tableNhanVien.getSelectedRow();
        if (row > -1) {
            maNV = tableNhanVien.getValueAt(row, 0).toString();
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên");
        }
        ArrayList<HoaDonBan> list = hoaDonBan_dao.getHoaDonTheoNgayCuaNhanVien(ngay, maNV);
        modelThongKeThuocTheoNgay.getDataVector().removeAllElements();
        modelThongKeThuocTheoNgay.fireTableDataChanged();
        lblTongDoanhThu.setText("0");
        lblTongHoaDon.setText("0");
        if (list.size() == 0 && !maNV.equals("")) {
            JOptionPane.showMessageDialog(null, "Không có hóa hơn trong ngày của nhân viên");
            return;
        }
        ArrayList<CT_HoaDonBan> listCT = new ArrayList<>();
        double tt = 0;
        for (HoaDonBan hd : list) {
            tt += hd.tongTien();
            listCT.addAll(chiTietHD_dao.getDSCT_HdByMaHD(hd.getMaHoaDonBan()));
        }
        lblTongDoanhThu.setText(String.format("%,.0f" + " VNĐ", tt));
        lblTongHoaDon.setText(String.valueOf(list.size()));

        for (CT_HoaDonBan t : listCT) {
            modelThongKeThuocTheoNgay.addRow(new Object[]{t.getThuoc().getMaThuoc(), t.getThuoc().getTenThuoc(), t.getSoLuong(),
                Math.round(t.getGiaBan()), Math.round(t.getSoLuong() * t.getGiaBan() * (1 + t.getVat()))});
        }
    }

    private void getTatCaHoaDonTheoNgayCuaQuanLi(String ng) {
        ArrayList<HoaDonBan> list = hoaDonBan_dao.getTatCaHoaDonTheoNgay(ng);
        modelThongKeThuocTheoNgay.getDataVector().removeAllElements();
        modelThongKeThuocTheoNgay.fireTableDataChanged();
        lblTongDoanhThu.setText("0");
        lblTongHoaDon.setText("0");
        ArrayList<CT_HoaDonBan> listCT = new ArrayList<>();
        double tt = 0;
        for (HoaDonBan hd : list) {
            tt += hd.tongTien();
            listCT.addAll(chiTietHD_dao.getDSCT_HdByMaHD(hd.getMaHoaDonBan()));
        }
        lblTongDoanhThu.setText(String.format("%,.0f" + " VNĐ", tt));
        lblTongHoaDon.setText(String.valueOf(list.size()));

        for (CT_HoaDonBan t : listCT) {
            modelThongKeThuocTheoNgay.addRow(new Object[]{t.getThuoc().getMaThuoc(), t.getThuoc().getTenThuoc(), t.getSoLuong(),
                Math.round(t.getGiaBan()), Math.round(t.getSoLuong() * t.getGiaBan() * (1 + t.getVat()))});
        }
    }

    private void thongKeThang() {
        String thang = cbbThang.getSelectedItem().toString();

        int row = tableNhanVien.getSelectedRow();
        if (cbbLoaiThongKe.getSelectedIndex() != 0) {
            if (row > -1) {
                maNV = tableNhanVien.getValueAt(row, 0).toString();
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên");
            }
        }
        ArrayList<HoaDonBan> list = hoaDonBan_dao.getHoaDonTheoThang(thang, maNV);
        panelTKThang.repaint();
        panelTKThang.removeAll();
        lblTongDoanhThuTheoThang.setText("0");
        lblTongHoaDonTheoThang.setText("0");
        if (list.size() == 0 && !maNV.equals("")) {
            ChartPanel chartPanelNull = new ChartPanel(showChartNull());
            panelTKThang.add(chartPanelNull);
        }
        long tt = 0;
        for (HoaDonBan hd : list) {
            tt += hd.tongTien();
        }
        double temp = Double.parseDouble(String.valueOf(tt));
        lblTongDoanhThuTheoThang.setText(String.format("%,.0f" + " VNĐ", temp));
        lblTongHoaDonTheoThang.setText(String.valueOf(list.size()));
        ChartPanel chartPanel = new ChartPanel(createChartThang(thang));
        panelTKThang.add(chartPanel);
    }

    private JFreeChart createChartThang(String thang) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        int row = tableNhanVien.getSelectedRow();
        if (cbbLoaiThongKe.getSelectedIndex() != 0) {
            if (row > -1) {
                maNV = tableNhanVien.getValueAt(row, 0).toString();
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên");
            }
        }
        for (int i = 1; i < 32; i++) {
            String ngay = String.valueOf(i);
            long tt = 0;
            ArrayList<HoaDonBan> list = hoaDonBan_dao.thongKeThang(thang, ngay, maNV);
            for (HoaDonBan hd : list) {
                tt += hd.tongTien();
            }
            dataset.addValue(tt, "Tổng tiền", ngay);
        }
        JFreeChart barChart = ChartFactory.createBarChart("", "Ngày",
                "Tổng tiền (VND)", dataset, PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private void thongKeNam() {
        String nam = String.valueOf(jYCYear.getYear());

        int row = tableNhanVien.getSelectedRow();
        if (cbbLoaiThongKe.getSelectedIndex() != 0) {
            if (row > -1) {
                maNV = tableNhanVien.getValueAt(row, 0).toString();
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm");
            }
        }

        pnelTKNam.repaint();
        pnelTKNam.removeAll();
        lblTongDoanhThuNam.setText("0");
        lblTongHoaDonNam.setText("0");
        ArrayList<HoaDonBan> list = hoaDonBan_dao.getHoaDonTheoNam(nam, maNV);
        if (list.size() == 0 && !maNV.equals("")) {
            JOptionPane.showMessageDialog(null, "Không có hóa đơn nào trong năm của nhân viên để thông kê");
            return;
        }
        long tt = 0;
        for (HoaDonBan hd : list) {
            tt += hd.tongTien();
        }
        double temp = Double.parseDouble(String.valueOf(tt));
        lblTongDoanhThuNam.setText(String.format("%,.0f" + " VNĐ", temp));
        lblTongHoaDonNam.setText(String.valueOf(list.size()));
        ChartPanel chartPanel = new ChartPanel(createChartNam(nam));
        pnelTKNam.add(chartPanel);
    }

    private JFreeChart createChartNam(String nam) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        int row = tableNhanVien.getSelectedRow();
        if (cbbLoaiThongKe.getSelectedIndex() != 0) {
            if (row > -1) {
                maNV = tableNhanVien.getValueAt(row, 0).toString();
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên");
            }
        }
        for (int i = 1; i < 13; i++) {
            String thang = String.valueOf(i);
            long tt = 0;
            ArrayList<HoaDonBan> list = hoaDonBan_dao.thongKeNam(nam, thang, maNV);
            for (HoaDonBan hd : list) {
                tt += hd.tongTien();
            }
            dataset.addValue(tt, "Tổng tiền", thang);
        }
        JFreeChart barChart = ChartFactory.createBarChart("", "Tháng",
                "Tổng tiền (VND)", dataset, PlotOrientation.VERTICAL, false, false, false);
        return barChart;
    }

    private JFreeChart showChartNull() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 1; i < 31; i++) {
            String ngay = String.valueOf(i);

            long tt = 0;
            dataset.addValue(tt, "Tổng tiền", ngay);
        }
        JFreeChart barChart = ChartFactory.createBarChart("", "Ngày",
                "Tổng tiền (VND)", dataset, PlotOrientation.VERTICAL, true, true, false);
        return barChart;
    }

    private JFreeChart showChartNullNam() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 1; i < 13; i++) {
            String ngay = String.valueOf(i);

            long tt = 0;
            dataset.addValue(tt, "Tổng tiền", ngay);
        }
        JFreeChart barChart = ChartFactory.createBarChart("", "Tháng",
                "Tổng tiền (VND)", dataset, PlotOrientation.VERTICAL, true, true, false);
        return barChart;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThongKe;
    private javax.swing.JButton btnXuatFile;
    private javax.swing.JComboBox<String> cbbLoaiThongKe;
    private javax.swing.JComboBox<String> cbbThang;
    private com.toedter.calendar.JDateChooser dcNgay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private com.toedter.calendar.JYearChooser jYCYear;
    private javax.swing.JLabel lblTongDoanhThu;
    private javax.swing.JLabel lblTongDoanhThuNam;
    private javax.swing.JLabel lblTongDoanhThuTheoThang;
    private javax.swing.JLabel lblTongHoaDon;
    private javax.swing.JLabel lblTongHoaDonNam;
    private javax.swing.JLabel lblTongHoaDonTheoThang;
    private javax.swing.JPanel panelTKNam;
    private javax.swing.JPanel panelTKThang;
    private javax.swing.JPanel pnelTKNam;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tableNhanVien;
    private javax.swing.JTable tableThongkeThuocNgay;
    private javax.swing.JTable tableThuocDaHetHan;
    private javax.swing.JTable tableThuocHetHan;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables
}
