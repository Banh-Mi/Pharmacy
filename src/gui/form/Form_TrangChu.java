/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui.form;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;


public class Form_TrangChu extends javax.swing.JPanel {

    
    
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
     * Creates new form Form_TrangChu
     */
    public Form_TrangChu() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();

        setBackground(new Color(181, 214, 222));

        jLabel2.setIcon(new ImageIcon(Form_TrangChu.class.getResource("/image/imgs/HOME1.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap(282, Short.MAX_VALUE)
        			.addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 675, GroupLayout.PREFERRED_SIZE)
        			.addGap(264))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(50)
        			.addComponent(jLabel2)
        			.addContainerGap(52, Short.MAX_VALUE))
        );
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
