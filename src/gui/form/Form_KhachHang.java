package gui.form;

import dao.DAO_KhachHang;
import entity.KhachHang;
import entity.NhanVien;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class Form_KhachHang extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DAO_KhachHang khachHang_dao = new DAO_KhachHang();
    private DefaultTableModel modelKhachHang;
    private ArrayList<KhachHang> listKhachHang;
    public Form_KhachHang(NhanVien nv){
    	setBackground(new Color(255, 255, 255));
        initComponents();
        if (!nv.isLoaiNhanVien()) {
            btnXoa.setEnabled(false);
            btnSua.setEnabled(false);
        }
        listKhachHang = khachHang_dao.getAllKhachHang();
        themDuLieuKhachHangVaoBang(listKhachHang);
//        loadTinh();
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
                kh.getDiaChi()   
            });
        }
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaKH = new javax.swing.JTextField();
        txtTenKH = new javax.swing.JTextField();
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
        jLabel8.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        cbbTrangThai = new javax.swing.JComboBox<>();
        btnXoaRong = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel2.setBackground(new Color(255, 255, 255));
        jScrollPane1 = new javax.swing.JScrollPane();
        tableKhachHang = new javax.swing.JTable();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã khách hàng:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên khách hàng: ");

        txtMaKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtMaKH.setEnabled(false);

        txtTenKH.setFont(new java.awt.Font("Segoe UI", 0, 14));

        btnThem.setBackground(new Color(43, 123, 255));
        btnThem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setIcon(new ImageIcon(Form_KhachHang.class.getResource("/image/icon/plus_white.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnXoa.setBackground(new Color(43, 123, 255));
        btnXoa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoa.setForeground(new java.awt.Color(255, 255, 255));
        btnXoa.setIcon(new ImageIcon(Form_KhachHang.class.getResource("/image/icon/bin_white.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setBackground(new Color(43, 123, 255));
        btnSua.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSua.setForeground(new java.awt.Color(255, 255, 255));
        btnSua.setIcon(new ImageIcon(Form_KhachHang.class.getResource("/image/icon/edit_white.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnLamMoi.setBackground(new Color(43, 123, 255));
        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLamMoi.setForeground(new java.awt.Color(255, 255, 255));
        btnLamMoi.setIcon(new ImageIcon(Form_KhachHang.class.getResource("/image/icon/reload.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });

        btnTim.setBackground(new Color(43, 123, 255));
        btnTim.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnTim.setForeground(new java.awt.Color(255, 255, 255));
        btnTim.setIcon(new ImageIcon(Form_KhachHang.class.getResource("/image/icon/search_white.png"))); // NOI18N
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

        btnXoaRong.setBackground(new Color(43, 123, 255));
        btnXoaRong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnXoaRong.setForeground(new java.awt.Color(255, 255, 255));
        btnXoaRong.setIcon(new ImageIcon(Form_KhachHang.class.getResource("/image/icon/close_white.png"))); // NOI18N
        btnXoaRong.setText("Xóa Rỗng");
        btnXoaRong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaRongActionPerformed(evt);
            }
        });
        
        JLabel lblAddress = new JLabel("Địa chỉ: ");
        lblAddress.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        
        txtAddress = new JTextField();
        txtAddress.setFont(new Font("Segoe UI", Font.PLAIN, 14));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel2)
        				.addComponent(jLabel3))
        			.addGap(18)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(txtTenKH)
        				.addComponent(txtMaKH, GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE))
        			.addGap(38)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jLabel1)
        				.addComponent(lblAddress))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(btnXoaRong)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnThem)
        					.addGap(18)
        					.addComponent(btnSua)
        					.addGap(18)
        					.addComponent(btnXoa)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnLamMoi)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnTim))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addComponent(txtSDT, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
        					.addGap(26)
        					.addComponent(jLabel7)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(cbbGioiTinh, GroupLayout.PREFERRED_SIZE, 158, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
        					.addComponent(jLabel8)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(cbbTrangThai, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
        				.addComponent(txtAddress, GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE))
        			.addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel2)
        						.addComponent(txtMaKH, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(txtTenKH, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel3)))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(jLabel1)
        						.addComponent(txtSDT, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
        						.addComponent(cbbTrangThai, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel8, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
        						.addComponent(jLabel7, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
        						.addComponent(cbbGioiTinh, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(lblAddress)
        						.addComponent(txtAddress, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, 47, Short.MAX_VALUE)
        				.addComponent(btnSua, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        				.addComponent(btnXoa, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        				.addComponent(btnLamMoi, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        				.addComponent(btnTim, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        				.addComponent(btnXoaRong, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tableKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Giới tính", "SĐT", "Trạng thái", "Địa chỉ"
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
        jPanel2Layout.setHorizontalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1458, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
        	jPanel2Layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
        );
        jPanel2.setLayout(jPanel2Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(jPanel1, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
        				.addComponent(jPanel2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1462, Short.MAX_VALUE))
        			.addContainerGap(8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 493, Short.MAX_VALUE))
        );
        this.setLayout(layout);
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
            txtAddress.setText(tableKhachHang.getValueAt(row,5).toString());
        }
    }//GEN-LAST:event_tableKhachHangMouseClicked

//    private void getQuanTheoThanhPho() {
//        vecQuanHuyen = diaChi_dao.getAllHuyenTheoTinh(cbbThanhPho.getSelectedItem().toString());
//        DefaultComboBoxModel<String> mdQuanHuyen = new DefaultComboBoxModel<>(vecQuanHuyen);
//        cbbQuan.setModel(mdQuanHuyen);
//    }

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (validateField()) {
            String taoMaKhachHang = khachHang_dao.TaoSoNgauNhien();
            String maKH = taoMaKhachHang;
            String tenKH = txtTenKH.getText();
            String sdt = txtSDT.getText();
//            String thanhPho = cbbThanhPho.getSelectedItem().toString();
//            String quanHuyen = cbbQuan.getSelectedItem().toString();
//            String phuongXa = cbbPhuong.getSelectedItem().toString();
            String diaChi = txtAddress.getText();

            boolean gioiTinh = cbbGioiTinh.getSelectedItem().toString() == "Nam" ? true : false;
            boolean trangThai = cbbTrangThai.getSelectedItem().toString() == "Thường xuyên" ? true : false;

            KhachHang kh = new KhachHang(maKH, tenKH, gioiTinh, sdt, diaChi, trangThai);

            if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thêm khách hàng ?", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (khachHang_dao.themKhachHang(kh)) {
                    modelKhachHang.addRow(new Object[]{kh.getMaKH(), kh.getTenKh(), kh.isGioiTinh(), kh.getSdt(), kh.isTrangThai(), kh.getDiaChi()});
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
//                    String thanhPho = cbbThanhPho.getSelectedItem().toString();
//                    String quanHuyen = cbbQuan.getSelectedItem().toString();
//                    String phuongXa = cbbPhuong.getSelectedItem().toString();
                    String diaChi = txtAddress.getText();

                    boolean gioiTinh = cbbGioiTinh.getSelectedItem().toString() == "Nam" ? true : false;
                    boolean trangThai = cbbTrangThai.getSelectedItem().toString() == "Thường xuyên" ? true : false;

                    KhachHang kh = new KhachHang(maKH, tenKH, gioiTinh, sdt,diaChi, trangThai);

                    if (khachHang_dao.capNhatKhachHang(kh)) {
                        modelKhachHang.setValueAt(txtTenKH.getText(), r, 1);
                        modelKhachHang.setValueAt(cbbGioiTinh.getSelectedItem().equals("Nam") ? true : false, r, 2);
                        modelKhachHang.setValueAt(txtSDT.getText(), r, 3);
                        modelKhachHang.setValueAt(cbbTrangThai.getSelectedItem().equals("Thường xuyên") ? true : false, r, 4);
                        modelKhachHang.setValueAt(txtAddress.getText(), r, 5);
//                        modelKhachHang.setValueAt(cbbQuan.getSelectedItem(), r, 6);
//                        modelKhachHang.setValueAt(cbbPhuong.getSelectedItem(), r, 7);
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
//        String tp = cbbThanhPho.getSelectedItem().toString();
//        if (cbbThanhPho.getSelectedIndex() == 0) {
//            tp = "";
//        }
//        String q = cbbQuan.getSelectedItem().toString();
//        if (cbbQuan.getSelectedIndex() == 0) {
//            q = "";
//        }
//        String p = cbbPhuong.getSelectedItem().toString();
//        if (cbbPhuong.getSelectedIndex() == 0) {
//            p = "";
//        }
        
        //Sửa bắt địa chỉ chỗ này
        
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
        String dc = txtAddress.getText();
        for (KhachHang kh : khachHang_dao.timKhachHangTheoDK(tenKH, sdt, trangThai, gioiTinh,dc)) {
            if (kh != null) {
                modelKhachHang.addRow(new Object[]{
                    kh.getMaKH(),
                    kh.getTenKh(),
                    kh.isGioiTinh() == true ? "Nam" : "Nữ",
                    kh.getSdt(),
                    kh.isTrangThai() == true ? "Thường xuyên" : "Vãng lai",
                    kh.getDiaChi()
                });
            }
        }
    }//GEN-LAST:event_btnTimActionPerformed

    private void btnXoaRongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaRongActionPerformed
        txtMaKH.setText(khachHang_dao.TaoSoNgauNhien());
        txtSDT.setText("");
        txtTenKH.setText("");
        cbbGioiTinh.setSelectedIndex(0);
//        cbbPhuong.setSelectedIndex(0);
//        cbbQuan.setSelectedIndex(0);
//        cbbThanhPho.setSelectedIndex(0);
        cbbGioiTinh.setSelectedIndex(0);
        cbbTrangThai.setSelectedIndex(0);
        txtAddress.setText("");

    }//GEN-LAST:event_btnXoaRongActionPerformed

//    private void getPhuongXaTheoQuanHuyen() {
//        vecPhuongXa = diaChi_dao.getAllPhuongXaTheoTinhVaHuyen(cbbThanhPho.getSelectedItem().toString(), cbbQuan.getSelectedItem().toString());
//        DefaultComboBoxModel<String> mdPhuong = new DefaultComboBoxModel<>(vecPhuongXa);
//        cbbPhuong.setModel(mdPhuong);
//    }

//    private void loadTinh() {
//        vecTinhTP = diaChi_dao.getAllTinh();
//        if (vecTinhTP.size() == 1) {
//            JOptionPane.showMessageDialog(null, "Lỗi khi đọc danh sách tỉnh!");
//            return;
//        }
//        DefaultComboBoxModel<String> md = new DefaultComboBoxModel<String>(vecTinhTP);
//    }

    private void lamMoi() {
        txtMaKH.setText(khachHang_dao.TaoSoNgauNhien());
        txtTenKH.setText("");
        txtSDT.setText("");
//        cbbThanhPho.setSelectedIndex(0);
//        cbbQuan.setSelectedIndex(0);
//        cbbPhuong.setSelectedIndex(0);
        txtAddress.setText("");
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
        if (txtAddress.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ");
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
    private javax.swing.JComboBox<String> cbbTrangThai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableKhachHang;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenKH;
    private JTextField txtAddress;
}
