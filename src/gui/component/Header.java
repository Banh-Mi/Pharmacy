
package gui.component;

import dao.DAO_NhanVien;
import entity.NhanVien;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Font;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import java.awt.Color;
import javax.swing.SwingConstants;


public class Header extends javax.swing.JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private dao.DAO_NhanVien daonv= new DAO_NhanVien();
    private NhanVien nv;
    public Header()
    {
        nv= daonv.getLSDNone();
       
        initComponents(nv);
        setOpaque(false);
    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(NhanVien nv) {

        jLabel2 = new javax.swing.JLabel();
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        lbTenNhanVien = new javax.swing.JLabel();
        lbTenNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
        lbChucVu = new javax.swing.JLabel();
        lbChucVu.setHorizontalAlignment(SwingConstants.CENTER);

        setBackground(new Color(46, 123, 255));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/user.png"))); // NOI18N

        lbTenNhanVien.setFont(new Font("Segoe UI", Font.BOLD, 17)); // NOI18N
        lbTenNhanVien.setForeground(new java.awt.Color(255, 255, 255));
        lbTenNhanVien.setText(nv.getTenNV());

        lbChucVu.setFont(new Font("Nunito", Font.BOLD | Font.ITALIC, 13)); // NOI18N
        lbChucVu.setForeground(new java.awt.Color(255, 255, 255));
        lbChucVu.setText((nv.isLoaiNhanVien()==true?"Quản lý":"Nhân viên"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addContainerGap(304, Short.MAX_VALUE)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lbTenNhanVien)
        				.addComponent(lbChucVu))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jLabel2)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(Alignment.LEADING, layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lbTenNhanVien, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbChucVu, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(16, Short.MAX_VALUE))
        );
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents

//                                       

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 =(Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
    	g2.fillRoundRect(0, 0, getWidth(), getHeight(),5, 5);
       
//        g2.fillRect(getWidth()-25, getHeight()-25, getWidth(), getHeight());
        super.paintComponent(g); 
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbChucVu;
    private javax.swing.JLabel lbTenNhanVien;
    // End of variables declaration//GEN-END:variables
}

