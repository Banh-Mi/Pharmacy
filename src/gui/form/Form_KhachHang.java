package gui.form;

import dao.DAO_DiaChi;
import dao.DAO_KhachHang;
import entity.DiaChi;
import entity.KhachHang;
import entity.NhanVien;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Form_KhachHang extends javax.swing.JPanel {

    private DAO_KhachHang khachHang_dao = new DAO_KhachHang();
    private DAO_DiaChi diaChi_dao = new DAO_DiaChi();
    private DefaultTableModel modelKhachHang;
    private ArrayList<KhachHang> listKhachHang;
    private Vector<String> vecQuanHuyen;
    private Vector<String> vecPhuongXa;
    private Vector<String> vecTinhTP = new Vector<String>();

    public Form_KhachHang(NhanVien nv){
        initComponents();
        if (!nv.isLoaiNhanVien()) {
            btnXoa.setEnabled(false);
            btnSua.setEnabled(false);
        }
        listKhachHang = khachHang_dao.getAllKhachHang();
        themDuLieuKhachHangVaoBang(listKhachHang);
        loadTinh();
        txtMaKH.setText(khachHang_dao.TaoSoNgauNhien());
    }

    private void themDuLieuKhachHangVaoBang(ArrayList<KhachHang> listThuoc) {
        modelKhachHang = (DefaultTableModel) tableKhachHang.getModel();
        for (KhachHang kh : listKhachHang) {
            modelKhachHang.addRow(new Object[]{
                kh.getMaKH(),
                kh.getTenKh(),
                kh.isGioiTinh() == true ? "Nam" : "Nữ",
                kh.getSdt(),
                kh.isTrangThai() == true ? "Thường xuyên" : "Vãng lai",
                kh.getDiaChi().getTinhTP(),
                kh.getDiaChi().getQuanHuyen(),
                kh.getDiaChi().getPhuongXa()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbbQuan = new javax.swing.JComboBox<>();
        cbbThanhPho = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        cbbPhuong = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnTim = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbbGioiTinh = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        cbbTrangThai = new javax.swing.JComboBox<>();
        btnXoaRong = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKhachHang = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã khách hàng:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên khách hàng: ");

        txtMaKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaKH.setEnabled(false);

        txtTenKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Tỉnh/ Thành phố: ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Quận/Huyện: ");

        cbbQuan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbQuan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quận/Huyện" }));
        cbbQuan.setPreferredSize(new java.awt.Dimension(78, 33));
        cbbQuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbQuanActionPerformed(evt);
            }
        });

        cbbThanhPho.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbThanhPho.setPreferredSize(new java.awt.Dimension(78, 33));
        cbbThanhPho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbThanhPhoActionPerformed(evt);
            }
        });

        jLabel6.setText("Phường/Xã: ");

        cbbPhuong.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbPhuong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Phường/Xã" }));
        cbbPhuong.setPreferredSize(new java.awt.Dimension(78, 33));

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

        btnSua.setBackground(new java.awt.Color(0, 102, 102));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/ion_sua.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
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

        btnTim.setBackground(new java.awt.Color(0, 102, 102));
        btnTim.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTim.setForeground(new java.awt.Color(255, 255, 255));
        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/search.png"))); // NOI18N
        btnTim.setText("Tìm");
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Số điện thoại: ");

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Giới Tính: ");

        cbbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Nam", "Nữ" }));
        cbbGioiTinh.setPreferredSize(new java.awt.Dimension(72, 33));

        jLabel8.setText("Trạng thái:");

        cbbTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cbbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Thường xuyên", "Vãng lai" }));
        cbbTrangThai.setPreferredSize(new java.awt.Dimension(72, 33));

        btnXoaRong.setBackground(new java.awt.Color(0, 102, 102));
        btnXoaRong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoaRong.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaRong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/clear_search_30px.png"))); // NOI18N
        btnXoaRong.setText("Xóa Rỗng");
        btnXoaRong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaRongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(txtTenKH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbThanhPho, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbQuan, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cbbPhuong, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbbTrangThai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbGioiTinh, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(btnXoaRong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThem)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLamMoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTim)
                .addContainerGap(438, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cbbThanhPho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbbPhuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(cbbTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbbQuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbbGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(btnTim, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXoaRong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tableKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Giới tính", "SĐT", "Trạng thái", "Tỉnh/TP", "Quận/Huyện", "Phường/Xã"
            }
        ));
        tableKhachHang.setRowHeight(30);
        tableKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableKhachHang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 431, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int r = tableKhachHang.getSelectedRow();
        if (r == -1)
            JOptionPane.showMessageDialog(this, "Chọn dòng cần xoá");
        else {
            if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xoá?", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (khachHang_dao.xoaKhachHang(txtMaKH.getText())) {
                    modelKhachHang.removeRow(r);
                    JOptionPane.showMessageDialog(null, "Xóa thành công");
                }
            }
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tableKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKhachHangMouseClicked
        int row = tableKhachHang.getSelectedRow();
        if (row != -1) {
            txtMaKH.setText(tableKhachHang.getValueAt(row, 0).toString());
            txtTenKH.setText(tableKhachHang.getValueAt(row, 1).toString());
            cbbGioiTinh.setSelectedItem(tableKhachHang.getValueAt(row, 2).toString());
            txtSDT.setText(tableKhachHang.getValueAt(row, 3).toString());
            cbbTrangThai.setSelectedItem(tableKhachHang.getValueAt(row, 4).toString());
            cbbThanhPho.setSelectedItem(tableKhachHang.getValueAt(row, 5).toString());
            cbbQuan.setSelectedItem(tableKhachHang.getValueAt(row, 6).toString());
            cbbPhuong.setSelectedItem(tableKhachHang.getValueAt(row, 7).toString());
        }
    }//GEN-LAST:event_tableKhachHangMouseClicked

    private void cbbThanhPhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbThanhPhoActionPerformed
        vecQuanHuyen = new Vector<String>();
        DefaultComboBoxModel<String> mdQuan = new DefaultComboBoxModel<>(vecQuanHuyen);
        cbbQuan.setModel(mdQuan);
        vecPhuongXa = new Vector<String>();
        vecPhuongXa.add("Phường/Xã");
        DefaultComboBoxModel<String> mdPhuong = new DefaultComboBoxModel<>(vecPhuongXa);
        cbbPhuong.setModel(mdPhuong);
        getQuanTheoThanhPho();
        return;
    }//GEN-LAST:event_cbbThanhPhoActionPerformed

    private void getQuanTheoThanhPho() {
        vecQuanHuyen = diaChi_dao.getAllHuyenTheoTinh(cbbThanhPho.getSelectedItem().toString());
        DefaultComboBoxModel<String> mdQuanHuyen = new DefaultComboBoxModel<>(vecQuanHuyen);
        cbbQuan.setModel(mdQuanHuyen);
    }

    private void cbbQuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbQuanActionPerformed
        getPhuongXaTheoQuanHuyen();
        return;
    }//GEN-LAST:event_cbbQuanActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (validateField()) {
            String taoMaKhachHang = khachHang_dao.TaoSoNgauNhien();
            String maKH = taoMaKhachHang;
            String tenKH = txtTenKH.getText();
            String sdt = txtSDT.getText();
            String thanhPho = cbbThanhPho.getSelectedItem().toString();
            String quanHuyen = cbbQuan.getSelectedItem().toString();
            String phuongXa = cbbPhuong.getSelectedItem().toString();

            boolean gioiTinh = cbbGioiTinh.getSelectedItem().toString() == "Nam" ? true : false;
            boolean trangThai = cbbTrangThai.getSelectedItem().toString() == "Thường xuyên" ? true : false;

            KhachHang kh = new KhachHang(maKH, tenKH, gioiTinh, sdt, new DiaChi(diaChi_dao.getMaDCTheoTinhHuyenXa(thanhPho, quanHuyen, phuongXa)), trangThai);

            if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm khách hàng ?", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (khachHang_dao.themKhachHang(kh)) {
                    modelKhachHang.addRow(new Object[]{kh.getMaKH(), kh.getTenKh(), kh.isGioiTinh(), kh.getSdt(), kh.isTrangThai(), kh.getDiaChi().getTinhTP(), kh.getDiaChi().getQuanHuyen(), kh.getDiaChi().getPhuongXa()});
                    JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công");
                    lamMoiTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Thêm khách hàng thất bại");
                }
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        lamMoi();
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int r = tableKhachHang.getSelectedRow();
        if (r == -1)
            JOptionPane.showMessageDialog(this, "Chọn dòng cần sửa");
        else {
            if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn sửa không ?", "Cảnh báo",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (validateField()) {
                    String maKH = txtMaKH.getText();
                    String tenKH = txtTenKH.getText();
                    String sdt = txtSDT.getText();
                    String thanhPho = cbbThanhPho.getSelectedItem().toString();
                    String quanHuyen = cbbQuan.getSelectedItem().toString();
                    String phuongXa = cbbPhuong.getSelectedItem().toString();

                    boolean gioiTinh = cbbGioiTinh.getSelectedItem().toString() == "Nam" ? true : false;
                    boolean trangThai = cbbTrangThai.getSelectedItem().toString() == "Thường xuyên" ? true : false;

                    KhachHang kh = new KhachHang(maKH, tenKH, gioiTinh, sdt, new DiaChi(diaChi_dao.getMaDCTheoTinhHuyenXa(thanhPho, quanHuyen, phuongXa)), trangThai);

                    if (khachHang_dao.capNhatKhachHang(kh)) {
                        modelKhachHang.setValueAt(txtTenKH.getText(), r, 1);
                        modelKhachHang.setValueAt(cbbGioiTinh.getSelectedItem().equals("Nam") ? true : false, r, 2);
                        modelKhachHang.setValueAt(txtSDT.getText(), r, 3);
                        modelKhachHang.setValueAt(cbbTrangThai.getSelectedItem().equals("Thường xuyên") ? true : false, r, 4);
                        modelKhachHang.setValueAt(cbbThanhPho.getSelectedItem(), r, 5);
                        modelKhachHang.setValueAt(cbbQuan.getSelectedItem(), r, 6);
                        modelKhachHang.setValueAt(cbbPhuong.getSelectedItem(), r, 7);
                        JOptionPane.showMessageDialog(null, "Sửa thành công");
                        lamMoiTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Sửa thất bại! Vui lòng kiểm tra lại thông tin");
                    }
                }
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed

        modelKhachHang.setNumRows(0);
        String tp = cbbThanhPho.getSelectedItem().toString();
        if (cbbThanhPho.getSelectedIndex() == 0) {
            tp = "";
        }
        String q = cbbQuan.getSelectedItem().toString();
        if (cbbQuan.getSelectedIndex() == 0) {
            q = "";
        }
        String p = cbbPhuong.getSelectedItem().toString();
        if (cbbPhuong.getSelectedIndex() == 0) {
            p = "";
        }
        String trangThai;
        if (cbbTrangThai.getSelectedIndex() == 0) {
            trangThai = "";
        } else if (cbbTrangThai.getSelectedIndex() == 1) {
            trangThai = "1";
        } else {
            trangThai = "0";
        }
        String gioiTinh;
        if (cbbGioiTinh.getSelectedIndex() == 0) {
            gioiTinh = "";
        } else if (cbbGioiTinh.getSelectedIndex() == 1) {
            gioiTinh = "1";
        } else {
            gioiTinh = "0";
        }
        String tenKH = txtTenKH.getText().trim();
        String sdt = txtSDT.getText().trim();
        for (KhachHang kh : khachHang_dao.timKhachHangTheoDK(tenKH, sdt, trangThai, gioiTinh, tp, q, p)) {
            if (kh != null) {
                modelKhachHang.addRow(new Object[]{
                    kh.getMaKH(),
                    kh.getTenKh(),
                    kh.isGioiTinh() == true ? "Nam" : "Nữ",
                    kh.getSdt(),
                    kh.isTrangThai() == true ? "Thường xuyên" : "Vãng lai",
                    kh.getDiaChi().getTinhTP(),
                    kh.getDiaChi().getQuanHuyen(),
                    kh.getDiaChi().getPhuongXa()
                });
            }
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnXoaRongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaRongActionPerformed
        txtMaKH.setText(khachHang_dao.TaoSoNgauNhien());
        txtSDT.setText("");
        txtTenKH.setText("");
        cbbGioiTinh.setSelectedIndex(0);
        cbbPhuong.setSelectedIndex(0);
        cbbQuan.setSelectedIndex(0);
        cbbThanhPho.setSelectedIndex(0);
        cbbGioiTinh.setSelectedIndex(0);
        cbbTrangThai.setSelectedIndex(0);


    }//GEN-LAST:event_btnXoaRongActionPerformed

    private void getPhuongXaTheoQuanHuyen() {
        vecPhuongXa = diaChi_dao.getAllPhuongXaTheoTinhVaHuyen(cbbThanhPho.getSelectedItem().toString(), cbbQuan.getSelectedItem().toString());
        DefaultComboBoxModel<String> mdPhuong = new DefaultComboBoxModel<>(vecPhuongXa);
        cbbPhuong.setModel(mdPhuong);
    }

    private void loadTinh() {
        vecTinhTP = diaChi_dao.getAllTinh();
        if (vecTinhTP.size() == 1) {
            JOptionPane.showMessageDialog(null, "Lỗi khi đọc danh sách tỉnh!");
            return;
        }
        DefaultComboBoxModel<String> md = new DefaultComboBoxModel<String>(vecTinhTP);
        cbbThanhPho.setModel(md);
    }

    private void lamMoi() {
        txtMaKH.setText(khachHang_dao.TaoSoNgauNhien());
        txtTenKH.setText("");
        txtSDT.setText("");
        cbbThanhPho.setSelectedIndex(0);
        cbbQuan.setSelectedIndex(0);
        cbbPhuong.setSelectedIndex(0);
        cbbGioiTinh.setSelectedIndex(0);
        cbbTrangThai.setSelectedIndex(0);
        txtTenKH.requestFocus();
        lamMoiTable();
    }

    private void lamMoiTable() {
        modelKhachHang.getDataVector().removeAllElements();
        listKhachHang = khachHang_dao.getAllKhachHang();
        themDuLieuKhachHangVaoBang(listKhachHang);
    }

    private boolean validateField() {
        String ten = txtTenKH.getText();
        String sdt = txtSDT.getText();

        if (!(ten != null && !ten.trim().equals(""))) {
            JOptionPane.showMessageDialog(this, "Tên khách hàng không được rỗng");
            return false;
        }
        if (!(sdt != null && !sdt.trim().equals(""))) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được rỗng");
            return false;
        }
        if (cbbPhuong.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn địa chỉ");
            return false;
        }
        if (!sdt.matches("(84|0[3|5|7|8|9])+([0-9]{8})")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không có thực!");
            txtSDT.selectAll();
            txtSDT.requestFocus();
            return false;
        }
        if (cbbTrangThai.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn trạng thái");
            return false;
        }
        if (cbbGioiTinh.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn giới tính");
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaRong;
    private javax.swing.JComboBox<String> cbbGioiTinh;
    private javax.swing.JComboBox<String> cbbPhuong;
    private javax.swing.JComboBox<String> cbbQuan;
    private javax.swing.JComboBox<String> cbbThanhPho;
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableKhachHang;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    // End of variables declaration//GEN-END:variables
}
