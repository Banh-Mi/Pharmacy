package gui.main;

import gui.event.EventMenu;
import javax.swing.JComponent;
import gui.form.Form_NhanVien;
import gui.form.Form_CuaHang;
import gui.form.Form_HoaDon;
import gui.form.Form_KhachHang;
import gui.form.Form_ThongKe;
import gui.form.Form_Thuoc;
import java.awt.Color;
import javax.swing.JComponent;
import connect.ConnectDB;
import entity.NhanVien;
import gui.form.Form_ThongKeNhanVien;
import gui.form.Form_ThongTinCaNhan;
import gui.form.Form_TrangChu;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author THANHTU
 */
public class Main extends javax.swing.JFrame {

    public Main(NhanVien nv) {
        initComponents();
        init(nv);
    }
   

    //Test
    private void init(NhanVien nv) {
        menu2.addEventMenu(new EventMenu() {
            @Override
            public void menuIndexChange(int index) {
                if (index == 0) {
                    setForm(new Form_TrangChu());
                } else if (index == 1) {
                    setForm(new Form_CuaHang(nv));
                } else if (index == 2) {
                    setForm(new Form_Thuoc(nv));
                } else if (index == 3) {
                    if (nv.isLoaiNhanVien() == true) {
                        setForm(new Form_NhanVien());
                    } else {
                        setForm(new Form_TrangChu());
//                        JOptionPane.showMessageDialog(null, "KHÔNG CÓ QUYỀN TRUY CẬP");
                    }
                } else if (index == 4) {
                    setForm(new Form_KhachHang(nv));

                } else if (index == 5) {
                    setForm(new Form_HoaDon(nv));
                } else if (index == 6) {
                    if (nv.isLoaiNhanVien()) {
//                        setForm(new Form_ThongKe());
                        setForm(new Form_ThongKe());
                    } else {
                        setForm(new Form_ThongKeNhanVien(nv));
                    }
                } else if (index == 7) {
                    setForm(new Form_ThongTinCaNhan(nv));
                }
            }
        });
    }

    private void setForm(JComponent com) {
        mainPanel.removeAll();
        mainPanel.add(com);
        mainPanel.repaint();
        mainPanel.revalidate();
    }

    @SuppressWarnings("checked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu2 = new gui.component.Menu();
        header1 = new gui.component.Header();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("TAK'S Medical");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 1456, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 7, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menu2, javax.swing.GroupLayout.DEFAULT_SIZE, 820, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(header1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        NhanVien nv = new NhanVien("Hieu");
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main(nv).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private gui.component.Header header1;
    private javax.swing.JPanel mainPanel;
    private gui.component.Menu menu2;
    // End of variables declaration//GEN-END:variables
}
