package gui.form;

import dao.DAO_NhanVien;
import entity.NhanVien;
import gui.main.Main;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.ImageIcon;


public class TrangDangNhap extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean showMK = true;
    private dao.DAO_NhanVien daonv = new DAO_NhanVien();
    private NhanVien nvdn;

    /**
     * Creates new form TrangDangNhap
     */
    public TrangDangNhap() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Đăng Nhập");
        setSize(600,300);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbIconDangNhap = new javax.swing.JLabel();
        titleTextDangNhap = new javax.swing.JLabel();
        lbTenDangNhap = new javax.swing.JLabel();
        lbMatKhau = new javax.swing.JLabel();
        tfDangNhap = new javax.swing.JTextField();
        tfDangNhap.setText("0901234567");
        tfPassWord = new javax.swing.JPasswordField();
        btThoat = new javax.swing.JButton();
        btDangNhap = new javax.swing.JButton();
        show_MatKhau = new javax.swing.JButton();
        lbl_backgroud_Dangnhap = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(600, 270));
        setSize(new java.awt.Dimension(600, 270));
        getContentPane().setLayout(null);
        getContentPane().add(jLabel1);
        jLabel1.setBounds(6, 6, 0, 0);

        lbIconDangNhap.setIcon(new ImageIcon(TrangDangNhap.class.getResource("/image/icon/icom_login_25.png"))); // NOI18N
        getContentPane().add(lbIconDangNhap);
        lbIconDangNhap.setBounds(170, 6, 50, 60);

        titleTextDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        titleTextDangNhap.setForeground(new java.awt.Color(0, 0, 255));
        titleTextDangNhap.setText("ĐĂNG NHẬP");
        getContentPane().add(titleTextDangNhap);
        titleTextDangNhap.setBounds(230, 20, 160, 32);

        lbTenDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbTenDangNhap.setForeground(new java.awt.Color(0, 0, 255));
        lbTenDangNhap.setText("Tên Đăng Nhập: ");
        getContentPane().add(lbTenDangNhap);
        lbTenDangNhap.setBounds(70, 70, 130, 30);

        lbMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbMatKhau.setForeground(new java.awt.Color(0, 0, 255));
        lbMatKhau.setText("Mật Khẩu:");
        getContentPane().add(lbMatKhau);
        lbMatKhau.setBounds(70, 111, 120, 30);

        tfDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfDangNhap.setToolTipText("");
        tfDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfDangNhapActionPerformed(evt);
            }
        });
        getContentPane().add(tfDangNhap);
        tfDangNhap.setBounds(210, 70, 180, 30);

        tfPassWord.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tfPassWord.setText("Password@1234");
        tfPassWord.setToolTipText("");
        tfPassWord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPassWordActionPerformed(evt);
            }
        });
        getContentPane().add(tfPassWord);
        tfPassWord.setBounds(210, 111, 150, 30);

        btThoat.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btThoat.setForeground(new java.awt.Color(0, 0, 255));
        btThoat.setIcon(new ImageIcon(TrangDangNhap.class.getResource("/image/icon/clearn.png"))); // NOI18N
        btThoat.setText("Thoát");
        btThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btThoatMouseExited(evt);
            }
        });
        btThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThoatActionPerformed(evt);
            }
        });
        getContentPane().add(btThoat);
        btThoat.setBounds(140, 170, 110, 40);

        btDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btDangNhap.setForeground(new java.awt.Color(0, 0, 255));
        btDangNhap.setIcon(new ImageIcon(TrangDangNhap.class.getResource("/image/icon/login.png"))); // NOI18N
        btDangNhap.setText("Đăng nhập");
        btDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDangNhapActionPerformed(evt);
            }
        });
        getContentPane().add(btDangNhap);
        btDangNhap.setBounds(270, 170, 140, 40);

        show_MatKhau.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        show_MatKhau.setIcon(new ImageIcon(TrangDangNhap.class.getResource("/image/icon/eyes.png"))); // NOI18N
        show_MatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                show_MatKhauActionPerformed(evt);
            }
        });
        getContentPane().add(show_MatKhau);
        show_MatKhau.setBounds(360, 110, 30, 30);

        lbl_backgroud_Dangnhap.setIcon(new ImageIcon(TrangDangNhap.class.getResource("/image/imgs/background_login.jpg"))); // NOI18N
        getContentPane().add(lbl_backgroud_Dangnhap);
        lbl_backgroud_Dangnhap.setBounds(0, 0, 600, 270);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfDangNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfDangNhapActionPerformed

    private void tfPassWordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPassWordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPassWordActionPerformed
    
    private void btDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDangNhapActionPerformed
        // TODO add your handling code here:
        String tk = tfDangNhap.getText().trim();
        String regexPhoneNumber = "^0[3|5|7|8|9]+[0-9]{8}$";
        Pattern patternPhoneNumber = Pattern.compile(regexPhoneNumber);
//        System.out.println(patternPhoneNumber.matcher(tk).matches());
        if (tk.isEmpty() == true) {
            JOptionPane.showMessageDialog(this, "SỐ ĐIỆN THOẠI KHÔNG ĐƯỢC ĐỂ TRỐNG", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);

        } else if (patternPhoneNumber.matcher(tk).matches()) {
            String mk = new String(tfPassWord.getPassword());
            NhanVien nvDangNhap = daonv.dangNhap(tk, mk);
            if (nvDangNhap != null) {
                try {
                    daonv.themLSDN(nvDangNhap);
                } catch (Exception ex) {
                    Logger.getLogger(TrangDangNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
                nvdn = daonv.getLSDNone();
                Main main = new gui.main.Main(nvdn);
                main.setVisible(true);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(this, "TÀI KHOẢN HOẶC MẬT KHẨU SAI", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "SỐ ĐIỆN THOẠI BẮT ĐẦU TỪ 03,05,07,08,09 VÀ PHẢI ĐỦ 10 SỐ", "Thông báo lỗi", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btDangNhapActionPerformed
    /**
     * 
     * @param evt 
     */
    private void show_MatKhauActionPerformed(java.awt.event.ActionEvent evt) {
        // String s=new String(tfPassWord.getPassword());
        // System.out.println(s);
        if (showMK == true) {
            tfPassWord.setEchoChar((char) 0);
            showMK = false;
        } else {
            tfPassWord.setEchoChar('*');
            showMK = true;
        }
    }
    private void btThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThoatActionPerformed
        // TODO add your handling code here:
        // this.setVisible(false);
        System.exit(0);
    }//GEN-LAST:event_btThoatActionPerformed

    public void btThoatMouseExited(java.awt.event.MouseEvent evt) {

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
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TrangDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TrangDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TrangDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TrangDangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

    	try {
    		javax.swing.UIManager.setLookAndFeel(new FlatIntelliJLaf());
    	}catch (Exception e) {
			 e.printStackTrace();
		}
    	
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrangDangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDangNhap;
    private javax.swing.JButton btThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbIconDangNhap;
    private javax.swing.JLabel lbMatKhau;
    private javax.swing.JLabel lbTenDangNhap;
    private javax.swing.JLabel lbl_backgroud_Dangnhap;
    private javax.swing.JButton show_MatKhau;
    private javax.swing.JTextField tfDangNhap;
    private javax.swing.JPasswordField tfPassWord;
    private javax.swing.JLabel titleTextDangNhap;
    // End of variables declaration//GEN-END:variables
}
