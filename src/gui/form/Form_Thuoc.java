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
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Form_Thuoc extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
    	setBackground(new Color(255, 255, 255));
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
            String formatGiaBan = String.format("%.0f", t.getGiaBan());
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

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel2.setBackground(new Color(255, 255, 255));
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
        txtHSD = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jPanel4.setBackground(new Color(255, 255, 255));
        jPanelButtonCURD = new javax.swing.JPanel();
        jPanelButtonCURD.setBackground(new Color(255, 255, 255));
        btnThem = new javax.swing.JButton();
        btnXoaRongField = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnNgungBan = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();

        tableThuoc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableThuoc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã", "Tên thuốc", "Giá bán", "ĐVT", "Thành phần", "QC đóng gói", "DB Chế", "Hàm lượng", "CTY SX", "Nước SX", "Trạng thái", "VAT(%)", "Số ĐK", "Công dụng", "Số lượng", "Hạn SD"
            }
        ) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class<?> getColumnClass(int columnIndex) {
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
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(scrollThuoc, GroupLayout.DEFAULT_SIZE, 1457, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(scrollThuoc, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
        );
        jPanel2.setLayout(jPanel2Layout);

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

        txtHSD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHSDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout.setHorizontalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel6)
        				.addComponent(jLabel5)
        				.addComponent(jLabel4)
        				.addComponent(jLabel13)
        				.addComponent(jLabel2))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(txtQC)
        				.addComponent(txtHSD, Alignment.TRAILING)
        				.addComponent(txtDBC)
        				.addComponent(txtThanhPhan, GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
        				.addComponent(txtMaThuoc, GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
        			.addGap(18)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel10)
        				.addComponent(jLabel9)
        				.addComponent(jLabel7)
        				.addComponent(jLabel3)
        				.addComponent(jLabel14))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(txtCTYSX, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
        				.addComponent(txtTenThuoc, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
        				.addComponent(txtHamLuong, Alignment.TRAILING, 383, 383, 383)
        				.addComponent(txtNuocSX, 383, 383, 383)
        				.addComponent(txtGia, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))
        			.addGap(18)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel8)
        						.addComponent(jLabel11)
        						.addComponent(jLabel1)
        						.addComponent(jLabel12))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(txtĐVT, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        						.addGroup(jPanel3Layout.createSequentialGroup()
        							.addComponent(txtVAT, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(jLabel17)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(jLabel16)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(txtSoDK, GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
        						.addComponent(cbbTrangThai, 0, 404, Short.MAX_VALUE)
        						.addComponent(cbbNhomCD, Alignment.TRAILING, 0, 404, Short.MAX_VALUE)))
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addComponent(jLabel15)
        					.addGap(18)
        					.addComponent(txtSoLuong, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel4)
        				.addComponent(txtMaThuoc, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel7)
        				.addComponent(txtTenThuoc, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel8)
        				.addComponent(cbbTrangThai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel5)
        				.addComponent(txtThanhPhan, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel9)
        				.addComponent(txtHamLuong, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel11)
        				.addComponent(cbbNhomCD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel6)
        				.addComponent(txtDBC, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel10)
        				.addComponent(txtNuocSX, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel15)
        				.addComponent(txtSoLuong, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel13)
        						.addComponent(jLabel1)
        						.addComponent(txtĐVT, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
        					.addGap(21))
        				.addGroup(jPanel3Layout.createSequentialGroup()
        					.addGap(4)
        					.addGroup(jPanel3Layout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(txtHSD, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        							.addComponent(txtGia, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        							.addComponent(jLabel14, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)))
        					.addGap(18)))
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(txtQC, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel3)
        				.addComponent(txtCTYSX, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel12)
        				.addComponent(txtVAT, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel16)
        				.addComponent(txtSoDK, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel17))
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3.setLayout(jPanel3Layout);

        jPanelButtonCURD.setPreferredSize(new java.awt.Dimension(1438, 60));

        btnThem.setBackground(new Color(46, 123, 255));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new ImageIcon(Form_Thuoc.class.getResource("/image/icon/plus_white.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoaRongField.setBackground(new Color(46, 123, 255));
        btnXoaRongField.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoaRongField.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaRongField.setIcon(new ImageIcon(Form_Thuoc.class.getResource("/image/icon/close_white.png"))); // NOI18N
        btnXoaRongField.setText("Xóa Xỗng");
        btnXoaRongField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaRongFieldActionPerformed(evt);
            }
        });

        btnEdit.setBackground(new Color(46, 123, 255));
        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new ImageIcon(Form_Thuoc.class.getResource("/image/icon/edit_white.png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnNgungBan.setBackground(new Color(255, 28, 28));
        btnNgungBan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnNgungBan.setForeground(new java.awt.Color(255, 255, 255));
        btnNgungBan.setIcon(new ImageIcon(Form_Thuoc.class.getResource("/image/icon/multiply_white.png"))); // NOI18N
        btnNgungBan.setText("Ngừng bán");
        btnNgungBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNgungBanActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new Color(46, 123, 255));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new ImageIcon(Form_Thuoc.class.getResource("/image/icon/bin_white.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new Color(46, 123, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setIcon(new ImageIcon(Form_Thuoc.class.getResource("/image/icon/reload.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnTimKiem.setBackground(new Color(46, 123, 255));
        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(255, 255, 255));
        btnTimKiem.setIcon(new ImageIcon(Form_Thuoc.class.getResource("/image/icon/search_white.png"))); // NOI18N
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
        jPanelButtonCURDLayout.setHorizontalGroup(
        	jPanelButtonCURDLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanelButtonCURDLayout.createSequentialGroup()
        			.addContainerGap(154, Short.MAX_VALUE)
        			.addComponent(btnTimKiem, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(btnXoaRongField)
        			.addGap(18)
        			.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(btnXoa, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(btnLamMoi)
        			.addGap(18)
        			.addComponent(btnNgungBan)
        			.addGap(187))
        );
        jPanelButtonCURDLayout.setVerticalGroup(
        	jPanelButtonCURDLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanelButtonCURDLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanelButtonCURDLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanelButtonCURDLayout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(btnTimKiem, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        					.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
        					.addComponent(btnXoaRongField, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
        				.addGroup(jPanelButtonCURDLayout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(btnEdit, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        					.addComponent(btnXoa, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
        					.addComponent(btnLamMoi, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
        					.addComponent(btnNgungBan, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))))
        );
        jPanelButtonCURD.setLayout(jPanelButtonCURDLayout);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4Layout.setHorizontalGroup(
        	jPanel4Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel4Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanelButtonCURD, GroupLayout.PREFERRED_SIZE, 1419, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
        	jPanel4Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel4Layout.createSequentialGroup()
        			.addComponent(jPanelButtonCURD, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(207, Short.MAX_VALUE))
        );
        jPanel4.setLayout(jPanel4Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 1457, Short.MAX_VALUE))
        				.addComponent(jPanel3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1467, Short.MAX_VALUE)
        				.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, 1457, Short.MAX_VALUE)))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel4, GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        this.setLayout(layout);
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
//            dcHSD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
//            dcHSD.setMinimumSize(new java.awt.Dimension(82, 35));
            txtHSD.setText(tableThuoc.getValueAt(row, 15).toString());
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
                java.util.Date sdf = new SimpleDateFormat("yyyy-MM-dd").parse((String)hanSD);
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
                        JOptionPane.showMessageDialog(null, "Ngừng bán thành công");
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
                        String hsdtxt = txtHSD.getText();
//                        String ngay = dtf.format(dcHSD.getDate());
                        Date hsd = Date.valueOf(hsdtxt);
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
               String hsdtxt = txtHSD.getText().trim();
               
               // String ngay = dtf.format(dcHSD.getDate());
                Date hsd = new Date(dtf.parse(hsdtxt).getTime());
                
                Double giaBan = Double.parseDouble(txtGia.getText());
                int soLuong = Integer.parseInt(txtSoLuong.getText());
                String temp = (String) cbbNhomCD.getSelectedItem();
                String[] temp2 = temp.split(":");
                CongDung congDung = new CongDung(temp2[0]);
                String qcDongGoi = txtQC.getText();
                String ctySanXuat = txtCTYSX.getText();
                Float thueVAT = Float.parseFloat(txtVAT.getText()) / 100;
                String soDK = txtSoDK.getText();
                System.out.println(hsd);
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

    private void txtHSDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHSDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHSDActionPerformed

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
            String formatGiaBan = String.format("%.0f", t.getGiaBan());
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
                df.format(t.getThueVAT() * 0.1),
                t.getSoDK(),
                t.getCongDung().getNhomCongDung() + "; " + t.getCongDung().getCongDung(),
                t.getSoLuongBanDau(),
                t.getHanSuDung()
            });
        }

    }

    private boolean validateFiled() {
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
        if (dcHSD.getDate() == null && txtHSD.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Hạn sử dụng không được rỗng");
            return false;
        }
        if (Date.valueOf(txtHSD.getText().trim()).after(today) == false) {
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
        txtHSD.setText("");
        cbbTrangThai.setSelectedIndex(0);
        cbbNhomCD.setSelectedIndex(0);
    }
    private com.toedter.calendar.JDateChooser dcHSD;
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
    private javax.swing.JTextField txtHSD;
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
