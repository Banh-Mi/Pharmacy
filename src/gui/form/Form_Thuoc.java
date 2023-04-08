package gui.form;

import dao.DAO_CongDung;
import dao.DAO_Thuoc;
import entity.CongDung;
import entity.NhanVien;
import entity.Thuoc;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Form_Thuoc extends javax.swing.JPanel {

    private DAO_CongDung congDung_Dao = new DAO_CongDung();
    private DAO_Thuoc thuoc_Dao = new DAO_Thuoc();
    private DefaultTableModel modelThuoc;
    private ArrayList<Thuoc> listThuoc;
    private ArrayList<Thuoc> listThuocNew;
    private ArrayList<CongDung> listCD;
    private SimpleDateFormat dtf;
    private JPanel_TimKiem timkiemThuoc;
    private final JPanel_ThemThuoc themThuoc;
  

    public Form_Thuoc(NhanVien nv) {
        timkiemThuoc = new JPanel_TimKiem();
        themThuoc = new JPanel_ThemThuoc();
        dtf = new SimpleDateFormat("yyyy-MM-dd");
        initComponents();
        if (nv.isLoaiNhanVien() == false) {
            btnXoa.setEnabled(false);
            btnEdit.setEnabled(false);
            btnNgungBan.setEnabled(false);
        }
        listThuoc = thuoc_Dao.getAllThuoc();
        themDuLieuThuocVaoBang(listThuoc);
        themDuLieuCongDungVaoCBB();
        addJpnTimKiem();
        addJpnThemThuoc();
    }

    private void themDuLieuThuocVaoBang(ArrayList<Thuoc> listThuoc) {
        modelThuoc = (DefaultTableModel) tableThuoc.getModel();
        DecimalFormat df = new DecimalFormat("#");
        for (Thuoc t : listThuoc) {
            String formatGiaBan = String.format("%,.0f", t.getGiaBan());
            modelThuoc.addRow(new Object[]{
                t.getMaThuoc(),
                t.getTenThuoc(),
                formatGiaBan,
                t.getDonViTinh(),
                t.getThanhPhan(),
                t.getQuyCachDongGoi(),
                t.getDangBaoChe(),
                t.getHamLuong(),
                t.getcTySanXuat(),
                t.getNuocSanXuat(),
                t.isTrangThaiKD() == true ? "Đang Kinh Doanh" : "Ngừng Kinh Doanh",
                df.format(t.getThueVAT() * 100),
                t.getSoDK(),
                t.getCongDung().getNhomCongDung() + "; " + t.getCongDung().getCongDung(),
                t.getSoLuongBanDau(),
                t.getHanSuDung()
            });
        }
    }

    private void themDuLieuCongDungVaoCBB() {
        listCD = congDung_Dao.getListCongDung();
        for (CongDung loaiCD : listCD) {
            cbbNhomCD.addItem(loaiCD.getMaCongDung() + ":" + loaiCD.getNhomCongDung() + ";" + loaiCD.getCongDung());
        }
    }

    private boolean checkINTNumber(String s) {
        String regex = "(^-)*\\d+";
        if (s.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean checkFloatNumber(String s) {
        String regex = "(^-)*\\d+(.\\d+)*";

        if (s.matches(regex)) {
            return true;
        } else {
            return false;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        scrollThuoc = new javax.swing.JScrollPane();
        tableThuoc = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtDBC = new javax.swing.JTextField();
        txtThanhPhan = new javax.swing.JTextField();
        txtMaThuoc = new javax.swing.JTextField();
        txtTenThuoc = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtHamLuong = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtNuocSX = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        dcHSD = new com.toedter.calendar.JDateChooser();
        cbbNhomCD = new javax.swing.JComboBox<>();
        cbbTrangThai = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtĐVT = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtQC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtCTYSX = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtVAT = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtSoDK = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanelButtonCURD = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnXoaRongField = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnNgungBan = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tableThuoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableThuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên thuốc", "Giá bán", "ĐVT", "Thành phần", "QC đóng gói", "DB Chế", "Hàm lượng", "CTY SX", "Nước SX", "Trạng thái", "VAT(%)", "Số ĐK", "Công dụng", "Số lượng", "Hạn SD"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableThuoc.setRowHeight(30);
        tableThuoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableThuocMouseClicked(evt);
            }
        });
        scrollThuoc.setViewportView(tableThuoc);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollThuoc)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(scrollThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Mã thuốc:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Thành phần: ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Dạng bào chế: ");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tên thuốc:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Trạng thái: ");

        txtDBC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtThanhPhan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtMaThuoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaThuoc.setEnabled(false);
        txtMaThuoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaThuocActionPerformed(evt);
            }
        });

        txtTenThuoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Hàm lượng: ");

        txtHamLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Nước SX: ");

        txtNuocSX.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Nhóm CD:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Hạn sử dụng: ");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setText("Giá (VNĐ): ");

        txtGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Số lượng: ");

        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        cbbNhomCD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã Công Dụng:Nhóm Công Dụng;Công Dụng" }));
        cbbNhomCD.setToolTipText("");
        cbbNhomCD.setPreferredSize(new java.awt.Dimension(72, 35));
        cbbNhomCD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNhomCDActionPerformed(evt);
            }
        });

        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Đang Kinh Doanh", "Ngừng Kinh Doanh" }));
        cbbTrangThai.setPreferredSize(new java.awt.Dimension(72, 35));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Đơn vị tính: ");

        txtĐVT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtĐVT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtĐVTActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("QC đóng gói: ");

        txtQC.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtQC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQCActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Công ty SX: ");

        txtCTYSX.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel12.setText("VAT: ");

        txtVAT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Số ĐK: ");

        txtSoDK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel17.setText("%");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(jLabel13)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtThanhPhan)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtQC, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaThuoc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 379, Short.MAX_VALUE)
                            .addComponent(txtDBC, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14)
                    .addComponent(jLabel7)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtNuocSX, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtGia, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtHamLuong)
                    .addComponent(txtTenThuoc, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(txtCTYSX))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15)
                    .addComponent(jLabel1)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtĐVT)
                    .addComponent(txtSoLuong)
                    .addComponent(cbbNhomCD, 0, 362, Short.MAX_VALUE)
                    .addComponent(cbbTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtVAT, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSoDK))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtTenThuoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtThanhPhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtHamLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(cbbNhomCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtDBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtNuocSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtĐVT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtQC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtCTYSX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtVAT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtSoDK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelButtonCURD.setPreferredSize(new java.awt.Dimension(1438, 60));

        btnThem.setBackground(new java.awt.Color(0, 102, 102));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/icon_them.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoaRongField.setBackground(new java.awt.Color(0, 102, 102));
        btnXoaRongField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoaRongField.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaRongField.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/clear_search_30px.png"))); // NOI18N
        btnXoaRongField.setText("Xóa Xỗng");
        btnXoaRongField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaRongFieldActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new java.awt.Color(0, 102, 102));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/ion_sua.png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnNgungBan.setBackground(new java.awt.Color(255, 102, 102));
        btnNgungBan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNgungBan.setForeground(new java.awt.Color(255, 255, 255));
        btnNgungBan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/huyPhongCho.png"))); // NOI18N
        btnNgungBan.setText("Ngừng bán");
        btnNgungBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgungBanActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new java.awt.Color(0, 102, 102));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/error.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new java.awt.Color(0, 102, 102));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/ion_chuyenPhong.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnTimKiem.setBackground(new java.awt.Color(0, 102, 102));
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/search_30px.png"))); // NOI18N
        btnTimKiem.setText("Tìm");
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTimKiemMousePressed(evt);
            }
        });
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelButtonCURDLayout = new javax.swing.GroupLayout(jPanelButtonCURD);
        jPanelButtonCURD.setLayout(jPanelButtonCURDLayout);
        jPanelButtonCURDLayout.setHorizontalGroup(
            jPanelButtonCURDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelButtonCURDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(229, 229, 229)
                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoaRongField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLamMoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNgungBan)
                .addContainerGap(197, Short.MAX_VALUE))
        );
        jPanelButtonCURDLayout.setVerticalGroup(
            jPanelButtonCURDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelButtonCURDLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanelButtonCURDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaRongField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEdit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNgungBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelButtonCURD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelButtonCURD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtMaThuocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaThuocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaThuocActionPerformed

    private void tableThuocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableThuocMouseClicked
        int row = tableThuoc.getSelectedRow();
        if (row != -1) {
            txtMaThuoc.setText(tableThuoc.getValueAt(row, 0).toString());
            txtTenThuoc.setText(tableThuoc.getValueAt(row, 1).toString());
            txtGia.setText(tableThuoc.getValueAt(row, 2).toString());
            txtĐVT.setText(tableThuoc.getValueAt(row, 3).toString());
            txtThanhPhan.setText(tableThuoc.getValueAt(row, 4).toString());
            txtQC.setText(tableThuoc.getValueAt(row, 5).toString());
            txtDBC.setText(tableThuoc.getValueAt(row, 6).toString());
            txtHamLuong.setText(tableThuoc.getValueAt(row, 7).toString());
            txtCTYSX.setText(tableThuoc.getValueAt(row, 8).toString());
            txtNuocSX.setText(tableThuoc.getValueAt(row, 9).toString());
            cbbTrangThai.setSelectedItem(tableThuoc.getValueAt(row, 10).toString());
            txtVAT.setText(tableThuoc.getValueAt(row, 11).toString());
            txtSoDK.setText(tableThuoc.getValueAt(row, 12).toString());
            txtSoLuong.setText(tableThuoc.getValueAt(row, 14).toString());
            dcHSD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
            dcHSD.setMinimumSize(new java.awt.Dimension(82, 35));
            String[] congDungThuocChon = tableThuoc.getValueAt(row, 13).toString().split("; ");
            for (int i = 0; i < listCD.size(); i++) {
                if (listCD.get(i).getCongDung().equalsIgnoreCase(congDungThuocChon[1].trim()) && listCD.get(i).getNhomCongDung()
                        .equalsIgnoreCase(congDungThuocChon[0].trim())) {
                    cbbNhomCD.setSelectedIndex(i + 1);
                    break;
                }
            }

            try {
                String hanSD = tableThuoc.getValueAt(row, 15).toString();
                java.util.Date sdf = new SimpleDateFormat("yyyy-MM-dd").parse((String) hanSD);
                dcHSD.setDate(sdf);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }//GEN-LAST:event_tableThuocMouseClicked

    private void txtĐVTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtĐVTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtĐVTActionPerformed

    private void txtQCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQCActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnTimKiemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMousePressed

    }//GEN-LAST:event_btnTimKiemMousePressed

    private void btnTimKiemMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseExited

    }//GEN-LAST:event_btnTimKiemMouseExited

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        // TODO add your handling code here:
        refersh();
    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        modelThuoc.getDataVector().removeAllElements();
        listThuocNew = thuoc_Dao.getAllThuoc();
        themDuLieuThuocVaoBang(listThuocNew);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int r = tableThuoc.getSelectedRow();
        if (r == -1)
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xoá");
        else {
            if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xoá?", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (thuoc_Dao.deleteThuoc(txtMaThuoc.getText())) {
                    modelThuoc.removeRow(r);
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                }
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnNgungBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNgungBanActionPerformed
        int r = tableThuoc.getSelectedRow();
        if (r == -1)
            JOptionPane.showMessageDialog(this, "Chọn thuốc cần ngừng bán");
        else {
            if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn ngừng bán thuốc này?", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    if (thuoc_Dao.ngungBanThuoc(txtMaThuoc.getText())) {
                        modelThuoc.setValueAt("Ngừng Kinh Doanh", r, 10);
                        JOptionPane.showMessageDialog(null, "Ngừng bán thành công thành công");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Form_Thuoc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_btnNgungBanActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        int r = tableThuoc.getSelectedRow();
        if (r == -1)
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
        else {
            if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa không ?", "Cảnh báo",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    if (validateFiled()) {
                        String maThuoc = txtMaThuoc.getText();
                        String tenThuoc = txtTenThuoc.getText();
                        String thanhPhan = txtThanhPhan.getText();
                        String dangBaoChe = txtDBC.getText();
                        String donViTinh = txtĐVT.getText();
                        String hamLuong = txtHamLuong.getText();
                        String nuocSX = txtNuocSX.getText();
                        boolean trangThai = cbbTrangThai.getSelectedItem().toString().equals("Đang Kinh Doanh") ? true : false;
                        String ngay = dtf.format(dcHSD.getDate());
                        Date hsd = Date.valueOf(ngay);
                        Double giaBan = Double.parseDouble(txtGia.getText());
                        int soLuong = Integer.parseInt(txtSoLuong.getText());
                        String temp = (String) cbbNhomCD.getSelectedItem();
                        String[] temp2 = temp.split(":");
                        CongDung congDung = new CongDung(temp2[0]);
                        String qcDongGoi = txtQC.getText();
                        String ctySanXuat = txtCTYSX.getText();
                        Float thueVAT = Float.parseFloat(txtVAT.getText()) / 100;
                        String soDK = txtSoDK.getText();

                        Thuoc t = new Thuoc(maThuoc, tenThuoc, giaBan, donViTinh, thanhPhan, qcDongGoi, dangBaoChe, hamLuong, ctySanXuat, nuocSX, trangThai, thueVAT, soDK, congDung, soLuong, hsd);

                        if (thuoc_Dao.updateThuoc(t, maThuoc)) {
                            modelThuoc.setValueAt(txtTenThuoc.getText(), r, 1);
                            modelThuoc.setValueAt(txtGia.getText(), r, 2);
                            modelThuoc.setValueAt(txtĐVT.getText(), r, 3);
                            modelThuoc.setValueAt(txtThanhPhan.getText(), r, 4);
                            modelThuoc.setValueAt(txtQC.getText(), r, 5);
                            modelThuoc.setValueAt(txtDBC.getText(), r, 6);
                            modelThuoc.setValueAt(txtHamLuong.getText(), r, 7);
                            modelThuoc.setValueAt(txtCTYSX.getText(), r, 8);
                            modelThuoc.setValueAt(txtNuocSX.getText(), r, 9);
//                            System.out.println(1);
                            modelThuoc.setValueAt(cbbTrangThai.getSelectedItem().toString().equals("Đang Kinh Doanh") ? true : false, r, 10);
//                            System.out.println(2);
                            modelThuoc.setValueAt(txtVAT.getText(), r, 11);
                            modelThuoc.setValueAt(txtSoDK.getText(), r, 12);
                            modelThuoc.setValueAt(congDung, r, 13);
                            modelThuoc.setValueAt(txtSoLuong.getText(), r, 14);
                            modelThuoc.setValueAt(dcHSD.getDate().getTime(), r, 14);
                            btnLamMoiActionPerformed(evt);
                            refersh();
                            JOptionPane.showMessageDialog(null, "Sửa thành công");
                        } else {
                            JOptionPane.showMessageDialog(null, "Sửa thất bại! Vui lòng kiểm tra lại thông tin");
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnXoaRongFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaRongFieldActionPerformed
        refersh();
    }//GEN-LAST:event_btnXoaRongFieldActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

    }//GEN-LAST:event_btnThemActionPerformed
    private void themThuocMoi() {
        try {
            if (validateFiled()) {
                //                txtMaThuoc.setText(thuoc_Dao.TaoSoNgauNhien());
                String maThuoc = txtMaThuoc.getText();
                String tenThuoc = txtTenThuoc.getText();
                String thanhPhan = txtThanhPhan.getText();
                String dangBaoChe = txtDBC.getText();
                String donViTinh = txtĐVT.getText();
                String hamLuong = txtHamLuong.getText();
                String nuocSX = txtNuocSX.getText();
                boolean trangThai = cbbTrangThai.getSelectedItem().toString().equals("Đang Kinh Doanh") ? true : false;
                String ngay = dtf.format(dcHSD.getDate());
                Date hsd = Date.valueOf(ngay);
                Double giaBan = Double.parseDouble(txtGia.getText());
                int soLuong = Integer.parseInt(txtSoLuong.getText());
                String temp = (String) cbbNhomCD.getSelectedItem();
                String[] temp2 = temp.split(":");
                CongDung congDung = new CongDung(temp2[0]);
                String qcDongGoi = txtQC.getText();
                String ctySanXuat = txtCTYSX.getText();
                Float thueVAT = Float.parseFloat(txtVAT.getText()) / 100;
                String soDK = txtSoDK.getText();

                Thuoc t = new Thuoc(maThuoc, tenThuoc, giaBan, donViTinh, thanhPhan, qcDongGoi, dangBaoChe, hamLuong, ctySanXuat, nuocSX, trangThai, thueVAT, soDK, congDung, soLuong, hsd);

                if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm thuốc ?", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    if (thuoc_Dao.addThuoc(t)) {
                        modelThuoc.addRow(new Object[]{t.getMaThuoc(), t.getTenThuoc(), t.getGiaBan(), t.getDonViTinh(), t.getThanhPhan(), t.getQuyCachDongGoi(), t.getDangBaoChe(), t.getHamLuong(), t.getcTySanXuat(), t.getNuocSanXuat(), t.isTrangThaiKD(), t.getThueVAT(), t.getSoDK(), t.getCongDung().getMaCongDung(), t.getSoLuongBanDau(), t.getHanSuDung()});
                        JOptionPane.showMessageDialog(null, "Thêm thuốc thành công");
                    } else {
                        JOptionPane.showMessageDialog(null, "Thêm thuốc thất bại");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void cbbNhomCDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNhomCDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbNhomCDActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnXoaRongActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        txtTenThuoc.setText("");
        txtGia.setText("");
        txtĐVT.setText("");
        txtThanhPhan.setText("");
        txtQC.setText("");
        txtDBC.setText("");
        txtHamLuong.setText("");
        txtCTYSX.setText("");
        txtNuocSX.setText("");
        cbbTrangThai.setSelectedIndex(0);
        txtVAT.setText("");
        txtSoDK.setText("");
        txtSoLuong.setText("");
        dcHSD.setDate(null);
    }

    public void addJpnTimKiem() {
        ActionListener lisMoUI = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMaThuoc.setEnabled(false);
                txtMaThuoc.setEditable(false);
                txtGia.setEnabled(true);
                txtSoLuong.setEnabled(true);
                txtVAT.setEnabled(true);
                refersh();
                jPanel4.removeAll();
                jPanel4.setLayout(new BorderLayout());
                jPanel4.add(jPanelButtonCURD);
                jPanel4.validate();
                jPanel4.repaint();
                jPanel4.updateUI();

            }
        };
        timkiemThuoc.buttonThoat(lisMoUI);

        ActionListener lisXoaRong = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refersh();
                btnLamMoiActionPerformed(e);
                txtMaThuoc.setText("");
            }
        };
        timkiemThuoc.bttonXoaRong(lisXoaRong);

        ActionListener lisXacNhanTim = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                timKiemThuocVV();
            }
        };
        timkiemThuoc.bttonXacNhan(lisXacNhanTim);

        btnTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refersh();
                txtMaThuoc.setEnabled(true);
                txtMaThuoc.setEditable(true);
                txtMaThuoc.setText("");
                txtGia.setEnabled(false);
                txtSoLuong.setEnabled(false);
                txtVAT.setEnabled(false);

                jPanel4.removeAll();
                jPanel4.setLayout(new BorderLayout());
                jPanel4.add(timkiemThuoc);
                jPanel4.validate();
                jPanel4.repaint();
                jPanel4.updateUI();

            }
        });
    }

    public void addJpnThemThuoc() {
        ActionListener lisMoUIThuoc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                txtMaThuoc.setEnabled(false);
//                txtMaThuoc.setEditable(false);
                refersh();
                jPanel4.removeAll();
                jPanel4.setLayout(new BorderLayout());
                jPanel4.add(jPanelButtonCURD);
                jPanel4.validate();
                jPanel4.repaint();
                jPanel4.updateUI();

            }
        };
        themThuoc.buttonThoat(lisMoUIThuoc);

        ActionListener lisXoaRongThuoc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refersh();
            }
        };
        themThuoc.bttonXoaRong(lisXoaRongThuoc);

        ActionListener lisXacNhanThuoc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                themThuocMoi();
            }
        };
        themThuoc.bttonXacNhan(lisXacNhanThuoc);

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refersh();
//                txtMaThuoc.setEnabled(true);
//                txtMaThuoc.setEditable(true);
//                txtMaThuoc.setText("");

                jPanel4.removeAll();
                jPanel4.setLayout(new BorderLayout());
                jPanel4.add(themThuoc);
                jPanel4.validate();
                jPanel4.repaint();
                jPanel4.updateUI();

            }
        });
    }

    private void timKiemThuocVV() {

        String maThuoc = txtMaThuoc.getText();
        String tenThuoc = txtTenThuoc.getText();
//                System.out.println(tenThuoc.isEmpty());
        String thanhPhan = txtThanhPhan.getText();
        String dangBaoChe = txtDBC.getText();
        String donViTinh = txtĐVT.getText();
        String hamLuong = txtHamLuong.getText();
        String nuocSX = txtNuocSX.getText();
//        System.out.println(nuocSX);
        String trangThai = cbbTrangThai.getSelectedItem().toString();
        Date cvngay = (dcHSD.getDate() == null ? null : Date.valueOf(dtf.format(dcHSD.getDate())));
        String giaBan = txtGia.getText();

//        System.out.println(giaBan);
        String strSoLuong = txtSoLuong.getText();
//        System.out.println(strSoLuong);

        String temp = (String) cbbNhomCD.getSelectedItem();
        String[] temp2 = temp.split(":");
        String[] nhomCD_CD = temp2[1].split(";");
        CongDung congDung = new CongDung(temp2[0], nhomCD_CD[0], nhomCD_CD[1]);
        String qcDongGoi = txtQC.getText();
        String ctySanXuat = txtCTYSX.getText();
        String strThueVAT = txtVAT.getText();
        String soDK = txtSoDK.getText();

        while (tableThuoc.getRowCount() != 0) {
            modelThuoc.removeRow(0);
        }
        ArrayList<Thuoc> dsThuocTimKiem = thuoc_Dao.timKiemThuoc3(maThuoc, tenThuoc, giaBan, donViTinh, thanhPhan, qcDongGoi, dangBaoChe, hamLuong, ctySanXuat, nuocSX, trangThai, strThueVAT, soDK, congDung, strSoLuong, cvngay);

        modelThuoc = (DefaultTableModel) tableThuoc.getModel();
        DecimalFormat df = new DecimalFormat("#");
        for (Thuoc t : dsThuocTimKiem) {
            String formatGiaBan = String.format("%,.0f", t.getGiaBan());
            modelThuoc.addRow(new Object[]{
                t.getMaThuoc(),
                t.getTenThuoc(),
                formatGiaBan,
                t.getDonViTinh(),
                t.getThanhPhan(),
                t.getQuyCachDongGoi(),
                t.getDangBaoChe(),
                t.getHamLuong(),
                t.getcTySanXuat(),
                t.getNuocSanXuat(),
                t.isTrangThaiKD() == true ? "Đang Kinh Doanh" : "Ngừng Kinh Doanh",
                df.format(t.getThueVAT() * 100),
                t.getSoDK(),
                t.getCongDung().getNhomCongDung() + "; " + t.getCongDung().getCongDung(),
                t.getSoLuongBanDau(),
                t.getHanSuDung()
            });
        }

    }

    private boolean validateFiled() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date(System.currentTimeMillis());
        String tenThuoc = txtTenThuoc.getText();
        String thanhPhan = txtThanhPhan.getText();
        String dangBaoChe = txtDBC.getText();
        String donViTinh = txtĐVT.getText();
        String hamLuong = txtHamLuong.getText();
        String nuocSX = txtNuocSX.getText();
        String qcDongGoi = txtQC.getText();
        String ctySanXuat = txtCTYSX.getText();
        String soDK = txtSoDK.getText();
        String trangThai = cbbTrangThai.getSelectedItem().toString();
        String tempCD = (String) cbbNhomCD.getSelectedItem();
        String[] temp2CD = tempCD.split(":");

        if (!(tenThuoc != null && !tenThuoc.trim().equals(""))) {
            JOptionPane.showMessageDialog(this, "Tên  thuốc không được rỗng");
            return false;
        }
        if (!(thanhPhan != null && !thanhPhan.trim().equals(""))) {
            JOptionPane.showMessageDialog(this, "Thành phần không được rỗng");
            return false;
        }
        if (!(dangBaoChe != null && !dangBaoChe.trim().equals(""))) {
            JOptionPane.showMessageDialog(this, "Dạng bào chế không được rỗng");
            return false;
        }
        if (!(donViTinh != null && !donViTinh.trim().equals(""))) {
            JOptionPane.showMessageDialog(this, "Đơn vị tính không được rỗng");
            return false;
        }
        if (!(hamLuong != null && !hamLuong.trim().equals(""))) {
            JOptionPane.showMessageDialog(this, "Hàm lượng không được rỗng");
            return false;
        }
        if (!(nuocSX != null && !nuocSX.trim().equals(""))) {
            JOptionPane.showMessageDialog(this, "Nước sản xuất không được rỗng");
            return false;
        }
        if (dcHSD.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Hạn sử dụng không được rỗng");
            return false;
        }
        if (Date.valueOf(dtf.format(dcHSD.getDate())).after(today) == false) {
            JOptionPane.showMessageDialog(this, "Hạn sử dụng phải sau ngày hiện tại");
            return false;
        }
        if (!(qcDongGoi != null && !qcDongGoi.trim().equals(""))) {
            JOptionPane.showMessageDialog(this, "Quy cách đóng gói không được rỗng");
            return false;
        }
        if (!(ctySanXuat != null && !ctySanXuat.trim().equals(""))) {
            JOptionPane.showMessageDialog(this, "Công ty sản xuất không được rỗng");
            return false;
        }
        if (trangThai.equalsIgnoreCase("ALL")) {
            JOptionPane.showMessageDialog(this, "Mời lựa chọn trạng thái kinh doanh");
            return false;
        }
        if (!(soDK != null && !soDK.trim().equals(""))) {
            JOptionPane.showMessageDialog(this, "Số đăng ký không được rỗng");
            return false;
        }
        if (temp2CD[0].equalsIgnoreCase("Mã Công Dụng")) {
            JOptionPane.showMessageDialog(this, "Mời lựa chọn công dụng");
            return false;
        }
        try {
            Double temp = Double.valueOf(txtGia.getText().trim());
            if (temp < 0) {
                JOptionPane.showMessageDialog(this, "Lỗi: Giá bán phải > 0");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Lỗi: Giá nhập phải > 0");
            return false;
        }
        try {
            int temp = Integer.parseInt(txtSoLuong.getText().trim());
            if (temp < 0) {
                JOptionPane.showMessageDialog(this, "Lỗi: Số lượng thuốc phải > 0");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Lỗi: Số lượng thuốc phải > 0");
            return false;
        }
        try {
            int temp = Integer.parseInt(txtVAT.getText().trim());
            if (temp < 0) {
                JOptionPane.showMessageDialog(this, "Lỗi: VAT phải > 0");
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Lỗi: VAT phải > 0");
            return false;
        }
        return true;
    }

    private void refersh() {
        txtMaThuoc.setText(thuoc_Dao.TaoSoNgauNhien());
        txtTenThuoc.setText("");
        txtThanhPhan.setText("");
        txtDBC.setText("");
        txtĐVT.setText("");
        txtHamLuong.setText("");
        txtNuocSX.setText("");
        txtGia.setText("");
        txtSoLuong.setText("");
        txtQC.setText("");
        txtCTYSX.setText("");
        txtVAT.setText("");
        txtSoDK.setText("");
        dcHSD.setDate(null);
        cbbTrangThai.setSelectedIndex(0);
        cbbNhomCD.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnNgungBan;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaRongField;
    private javax.swing.JComboBox<String> cbbNhomCD;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private com.toedter.calendar.JDateChooser dcHSD;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelButtonCURD;
    private javax.swing.JScrollPane scrollThuoc;
    private javax.swing.JTable tableThuoc;
    private javax.swing.JTextField txtCTYSX;
    private javax.swing.JTextField txtDBC;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtHamLuong;
    private javax.swing.JTextField txtMaThuoc;
    private javax.swing.JTextField txtNuocSX;
    private javax.swing.JTextField txtQC;
    private javax.swing.JTextField txtSoDK;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTenThuoc;
    private javax.swing.JTextField txtThanhPhan;
    private javax.swing.JTextField txtVAT;
    private javax.swing.JTextField txtĐVT;
    // End of variables declaration//GEN-END:variables
}
