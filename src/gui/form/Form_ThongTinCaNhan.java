/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui.form;

import dao.DAO_NhanVien;
import entity.NhanVien;
import java.awt.Image;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JLayeredPane;


public class Form_ThongTinCaNhan extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private final DAO_NhanVien daoNV = new DAO_NhanVien();
    private int i = 1;
    private final ArrayList<String> listdangnhap;
    private DefaultTableModel modelLSDN;
    private JFrame_DoiMatKhau jfdoiMK;

    /**
     * Creates new form Form_ThongTinCaNhan
     */
    public Form_ThongTinCaNhan(NhanVien nv) {
        jfdoiMK = new JFrame_DoiMatKhau(nv);
        initComponents();
        setThongTinNhanVien(nv);
        listdangnhap = daoNV.getLSDNTheoNV(nv.getMaNV());
        themDuLieuVaoBang(listdangnhap);
        txtMaNV.setEnabled(false);
        cbbChucVu.setEnabled(false);
        txtSoDT.setEnabled(false);
        GroupLayout gl_jPanel2 = new GroupLayout(jPanel2);
        gl_jPanel2.setHorizontalGroup(
        	gl_jPanel2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanel2.createSequentialGroup()
        			.addGap(128)
        			.addComponent(lblNewLabel))
        		.addGroup(gl_jPanel2.createSequentialGroup()
        			.addGap(15)
        			.addComponent(jLabel1)
        			.addGap(10)
        			.addComponent(txtMaNV, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_jPanel2.createSequentialGroup()
        			.addGap(10)
        			.addComponent(jLabel2)
        			.addGap(10)
        			.addComponent(txtTenNv, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_jPanel2.createSequentialGroup()
        			.addGap(59)
        			.addComponent(jLabel3)
        			.addGap(10)
        			.addComponent(cbbGioiTinh, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jLabel10)
        			.addGap(10)
        			.addComponent(cbbChucVu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_jPanel2.createSequentialGroup()
        			.addGap(24)
        			.addComponent(jLabel4)
        			.addGap(10)
        			.addComponent(txtSoDT, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_jPanel2.createSequentialGroup()
        			.addGap(81)
        			.addComponent(jLabel6)
        			.addGap(10)
        			.addComponent(txtCMND, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
        		.addGroup(gl_jPanel2.createSequentialGroup()
        			.addGap(73)
        			.addComponent(jLabel5)
        			.addGap(10)
        			.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, 309, GroupLayout.PREFERRED_SIZE))
        );
        gl_jPanel2.setVerticalGroup(
        	gl_jPanel2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_jPanel2.createSequentialGroup()
        			.addGap(32)
        			.addComponent(lblNewLabel)
        			.addGap(29)
        			.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanel2.createSequentialGroup()
        					.addGap(6)
        					.addComponent(jLabel1))
        				.addComponent(txtMaNV, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
        			.addGap(20)
        			.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanel2.createSequentialGroup()
        					.addGap(6)
        					.addComponent(jLabel2))
        				.addComponent(txtTenNv, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
        			.addGap(20)
        			.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanel2.createSequentialGroup()
        					.addGap(7)
        					.addComponent(jLabel3))
        				.addComponent(cbbGioiTinh, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_jPanel2.createSequentialGroup()
        					.addGap(7)
        					.addComponent(jLabel10))
        				.addComponent(cbbChucVu, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
        			.addGap(20)
        			.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanel2.createSequentialGroup()
        					.addGap(6)
        					.addComponent(jLabel4))
        				.addComponent(txtSoDT, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
        			.addGap(20)
        			.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanel2.createSequentialGroup()
        					.addGap(6)
        					.addComponent(jLabel6))
        				.addComponent(txtCMND, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
        			.addGap(20)
        			.addGroup(gl_jPanel2.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_jPanel2.createSequentialGroup()
        					.addGap(6)
        					.addComponent(jLabel5))
        				.addComponent(txtDiaChi, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2.setLayout(gl_jPanel2);

    }

    private void setThongTinNhanVien(NhanVien nv) {
        txtMaNV.setText(nv.getMaNV());
        txtTenNv.setText(nv.getTenNV());
        txtSoDT.setText(nv.getSdt());
        txtCMND.setText(nv.getCmnd());
        cbbGioiTinh.setSelectedItem((nv.isGioiTinh() ? "Nam" : "Nữ"));
        cbbChucVu.setSelectedItem((nv.isLoaiNhanVien() ? "Quản Lý" : "Nhân Viên"));
        txtDiaChi.setText(nv.getDiaChi());
    
    }
    private void themDuLieuVaoBang(ArrayList<String> listdangnhap) {
        modelLSDN = (DefaultTableModel) tableLichSuDN.getModel();

        for (String temp : listdangnhap) {
            String[] temp2 = temp.split(";");
            modelLSDN.addRow(new Object[]{
                i++, temp2[0], temp2[1], temp2[2]
            });
        }

    }

    private boolean validateField() {
        String ten = txtTenNv.getText();
        String cmnd = txtCMND.getText();
   
//        String tenrg1 = "^([A-ZĐÂÁƯ]{1}[a-zvxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+)((\\s{1}[A-ZĐÂÁƯ][{1}a-vxyỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ]+){1,})$";
//        String tenrg2 = "^([A-ZĐÂÁƯ]{1}[A-ZVXYỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂĐ]+)((\\s{1}[A-ZĐÂÁƯ][{1}A-VXYỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂĐ]+){1,})$";
//        String rgten = tenrg1 + "|" + tenrg2;
        if (!(ten != null && !ten.trim().equals(""))) {
            JOptionPane.showMessageDialog(this, "Tên nhân viên không được rỗng");
            return false;
        }
//        if (!ten.matches(rgten)) {
//            JOptionPane.showMessageDialog(this, "Tên phải viết hoa chữ cái đầu tiên:\n"
//                    + "VD: Nguyễn Đình Thanh \n"
//                    + "Hoặc viết hoa hết tất cả:\n"
//                    + "VD: NGUYỄN ĐÌNH THANH.");
//            return false;
//        }
        if (txtDiaChi.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ");
            return false;
        }
        if (cmnd.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập CCCD");
            return false;
        }
        if (!cmnd.matches("[0-9]{9}")) {
            JOptionPane.showMessageDialog(this, "CMND không phù hợp");
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        anhDaiDien = new javax.swing.JLabel();
        anhDaiDien.setHorizontalAlignment(SwingConstants.CENTER);
        btnDoiAnhDaiDien = new javax.swing.JButton();
        jPanel2 = new JLayeredPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTenNv = new javax.swing.JTextField();
        txtSoDT = new javax.swing.JTextField();
        txtCMND = new javax.swing.JTextField();
        cbbGioiTinh = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cbbChucVu = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableLichSuDN = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();

        setBackground(new Color(255, 255, 255));

        jPanel1.setBackground(new Color(255, 255, 255));

        anhDaiDien.setIcon(new ImageIcon(Form_ThongTinCaNhan.class.getResource("/image/image_Profile/avatar_default.png"))); // NOI18N

        btnDoiAnhDaiDien.setBackground(new Color(255, 255, 255));
        btnDoiAnhDaiDien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDoiAnhDaiDien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/reset.png"))); // NOI18N
        btnDoiAnhDaiDien.setText("Đổi ảnh đại diện");
        btnDoiAnhDaiDien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiAnhDaiDienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(20)
        			.addComponent(btnDoiAnhDaiDien)
        			.addGap(28))
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(anhDaiDien, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(88))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(anhDaiDien)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnDoiAnhDaiDien, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        jPanel2.setBackground(new Color(46, 123, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new Color(0, 0, 0));
        jLabel1.setText("Mã Nhân Viên:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new Color(0, 0, 0));
        jLabel2.setText("Tên Nhân Viên:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new Color(0, 0, 0));
        jLabel3.setText("Giới Tính:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new Color(0, 0, 0));
        jLabel4.setText("Số điện thoại:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new Color(0, 0, 0));
        jLabel5.setText("Địa chỉ: ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new Color(0, 0, 0));
        jLabel6.setText("CMND:");

        txtMaNV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtMaNV.setToolTipText("");
        txtMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNVActionPerformed(evt);
            }
        });

        txtTenNv.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTenNv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNvActionPerformed(evt);
            }
        });

        txtSoDT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        txtCMND.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        cbbGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nam", "Nữ" }));
        cbbGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbGioiTinhActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new Color(0, 0, 0));
        jLabel10.setText("Chức vụ:");

        cbbChucVu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân Viên", "Quản Lý" }));
        cbbChucVu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbChucVuActionPerformed(evt);
            }
        });
        
        txtDiaChi = new JTextField();
        txtDiaChi.setText((String) null);
        txtDiaChi.setFont(new Font("Segoe UI", Font.BOLD, 14));
        
        lblNewLabel = new JLabel("THÔNG TIN NHÂN VIÊN");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(0, 0, 0));
        lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));

        jPanel3.setBackground(new Color(255, 255, 255));
        tableLichSuDN.setRowHeight(30);
        tableLichSuDN.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableLichSuDN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã Nhân Viên", "Tên Nhân Viên", "Thời Gian Đăng Nhập"
            }
        ) {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			@SuppressWarnings("rawtypes")
			Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class<?> getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableLichSuDN);
        if (tableLichSuDN.getColumnModel().getColumnCount() > 0) {
            tableLichSuDN.getColumnModel().getColumn(0).setPreferredWidth(2);
            tableLichSuDN.getColumnModel().getColumn(1).setPreferredWidth(3);
            tableLichSuDN.getColumnModel().getColumn(2).setPreferredWidth(3);
            tableLichSuDN.getColumnModel().getColumn(3).setPreferredWidth(50);
        }

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3Layout.setHorizontalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, jPanel3Layout.createSequentialGroup()
        			.addGap(22)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 507, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 322, Short.MAX_VALUE)
        			.addContainerGap())
        );
        jPanel3.setLayout(jPanel3Layout);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new Color(0, 0, 0));
        jLabel11.setText("LỊCH SỬ ĐĂNG NHẬP");
        btnDoiMK = new javax.swing.JButton();
        
                btnDoiMK.setBackground(new Color(255, 255, 255));
                btnDoiMK.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
                btnDoiMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/reset.png"))); // NOI18N
                btnDoiMK.setText("Đổi mật Khẩu");
                btnDoiMK.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnDoiMKActionPerformed(evt);
                    }
                });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(36, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 247, GroupLayout.PREFERRED_SIZE)
        					.addGap(178))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jLabel11)
        					.addGap(192))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 553, GroupLayout.PREFERRED_SIZE)
        					.addGap(32)))
        			.addPreferredGap(ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE)
        					.addGap(111))
        				.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        					.addComponent(btnDoiMK)
        					.addGap(215))))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(17)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jLabel11)
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnDoiMK, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(83, Short.MAX_VALUE))
        );
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoiMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMKActionPerformed
        // TODO add your handling code here:
        jfdoiMK.setVisible(true);
    }//GEN-LAST:event_btnDoiMKActionPerformed

    private void btnDoiAnhDaiDienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiAnhDaiDienActionPerformed
        // TODO add your handling code here:
        JFileChooser j = new JFileChooser("src\\image\\image_profile");
        int res = j.showSaveDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            String pathName = j.getSelectedFile().getPath();
            ImageIcon imageIcon = new ImageIcon(pathName); // load the image to a imageIcon
            Image image = imageIcon.getImage(); // transform it 
            Image newimg = image.getScaledInstance(225, 225, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
            imageIcon = new ImageIcon(newimg);
            anhDaiDien.setIcon(imageIcon);
        }
    }//GEN-LAST:event_btnDoiAnhDaiDienActionPerformed

    private void cbbGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbGioiTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbGioiTinhActionPerformed

//    private void getQuanTheoThanhPho() {
//        vecQuanHuyen = diaChi_dao.getAllHuyenTheoTinh(cbbTPTinh.getSelectedItem().toString());
//        DefaultComboBoxModel<String> mdQuanHuyen = new DefaultComboBoxModel<>(vecQuanHuyen);
//        cbbQuanHuyen.setModel(mdQuanHuyen);
//    }

//    private void getPhuongXaTheoQuanHuyen() {
//        vecPhuongXa = diaChi_dao.getAllPhuongXaTheoTinhVaHuyen(cbbTPTinh.getSelectedItem().toString(), cbbQuanHuyen.getSelectedItem().toString());
//        DefaultComboBoxModel<String> mdPhuong = new DefaultComboBoxModel<>(vecPhuongXa);
//        cbbPhuongXa.setModel(mdPhuong);
//    }


    private void txtMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNVActionPerformed

    private void txtTenNvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNvActionPerformed

    private void cbbChucVuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbChucVuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbChucVuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anhDaiDien;
    private javax.swing.JButton btnDoiAnhDaiDien;
    private javax.swing.JButton btnDoiMK;
    private javax.swing.JComboBox<String> cbbChucVu;
    private javax.swing.JComboBox<String> cbbGioiTinh;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private JLayeredPane jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableLichSuDN;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtSoDT;
    private javax.swing.JTextField txtTenNv;
    private JTextField txtDiaChi;
    private JLabel lblNewLabel;
}
