package gui.main;

import gui.event.EventMenu;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import gui.form.Form_NhanVien;
import gui.form.Form_CuaHang;
import gui.form.Form_HoaDon;
import gui.form.Form_KhachHang;
import gui.form.Form_ThongKe;
import gui.form.Form_Thuoc;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import entity.NhanVien;
import gui.form.Form_ThongKeNhanVien;
import gui.form.Form_ThongTinCaNhan;
import gui.form.Form_TrangChu;
import javax.swing.GroupLayout.Alignment;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.InputMap;


public class Main extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Main(NhanVien nv) {
    	getContentPane().setBackground(new Color(255, 255, 255));
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

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	
        menu2 = new gui.component.Menu();
        header1 = new gui.component.Header();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pharmacy");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        getContentPane().add(menu2, java.awt.BorderLayout.CENTER);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setOpaque(false);
        mainPanel.setLayout(new java.awt.BorderLayout());
        getContentPane().add(mainPanel, java.awt.BorderLayout.PAGE_START);
        
        btnNewButton = new javax.swing.JButton();
        btnNewButton.setBackground(new Color(46, 123, 255));
        btnNewButton2 = new javax.swing.JButton();
        btnNewButton2.setBackground(new Color(46, 123, 255));
        
        btnNewButton.setIcon(new ImageIcon(Main.class.getResource("/image/icon/menu.png")));
        btnNewButton2.setIcon(new ImageIcon(Main.class.getResource("/image/icon/multiply_white.png")));
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(header1, GroupLayout.PREFERRED_SIZE, 1379, GroupLayout.PREFERRED_SIZE))
        				.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 1468, Short.MAX_VALUE))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(7)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(header1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
        			.addContainerGap())
        );
        //Xử lý nút để đóng mở menu
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(e.getSource().equals(btnNewButton)) {
        			layout.setHorizontalGroup(layout.createParallelGroup(Alignment.LEADING)
        					.addGroup(layout.createSequentialGroup()
        		        			.addContainerGap()
        		        			.addComponent(menu2, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
        		        			.addPreferredGap(ComponentPlacement.RELATED)
        		        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        		        				.addGroup(layout.createSequentialGroup()
        		        					.addComponent(btnNewButton2, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
        		        					.addPreferredGap(ComponentPlacement.RELATED)
        		        					.addComponent(header1, GroupLayout.PREFERRED_SIZE, 1379, GroupLayout.PREFERRED_SIZE))
        		        				.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 1468, Short.MAX_VALUE))
        		        			.addContainerGap()));
        			
        			
        			 layout.setVerticalGroup(
        					 layout.createParallelGroup(Alignment.LEADING)
        		        		.addGroup(layout.createSequentialGroup()
       		        				.addGap(7)
        		        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        		        				.addComponent(menu2, GroupLayout.DEFAULT_SIZE, 813, Short.MAX_VALUE)
        		        				.addGroup(layout.createSequentialGroup()
        		        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        		        				.addComponent(btnNewButton2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        		        						.addComponent(header1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
        		        					.addPreferredGap(ComponentPlacement.RELATED)
        		        					.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)))
        		        			.addContainerGap())
        		        );
        			 
        			 
        			 
        			 
        			 
        			 
        			 
        			btnNewButton.setVisible(false);
        			btnNewButton2.setVisible(true);
        			 getContentPane().setLayout(layout);
        		        pack();
        		        setLocationRelativeTo(null);
        		      
        		}
        		
        	}
        });
        btnNewButton2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		if(e.getSource().equals(btnNewButton2)) {
        			getContentPane().removeAll();
        			layout.setHorizontalGroup(
        		        	layout.createParallelGroup(Alignment.LEADING)
        		        		.addGroup(layout.createSequentialGroup()
        		        			.addContainerGap()
        		        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        		        				.addGroup(layout.createSequentialGroup()
        		        					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
        		        					.addPreferredGap(ComponentPlacement.RELATED)
        		        					.addComponent(header1, GroupLayout.PREFERRED_SIZE, 1379, GroupLayout.PREFERRED_SIZE))
        		        				.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 1468, Short.MAX_VALUE))
        		        			.addContainerGap())
        		        );
        		        layout.setVerticalGroup(
        		        	layout.createParallelGroup(Alignment.LEADING)
        		        		.addGroup(layout.createSequentialGroup()
        		        			.addGap(7)
        		        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        		        				.addComponent(header1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
        		        				.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        		        			.addPreferredGap(ComponentPlacement.RELATED)
        		        			.addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, 747, Short.MAX_VALUE)
        		        			.addContainerGap())
        		        );
        			btnNewButton.setVisible(true);
        			btnNewButton2.setVisible(false);
        			 getContentPane().setLayout(layout);
        		        pack();
        		        setLocationRelativeTo(null);
        		       
        		}
        		     
        	}
        });
        getContentPane().setLayout(layout);
        pack();
        setLocationRelativeTo(null);
//        Kết thúc xử lý nút đóng mở menu
        
        
        //Gắn phím tắt cho việc đóng mở menu
        
        InputMap inputmap = btnNewButton.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actMap = btnNewButton.getActionMap();
        inputmap.put(KeyStroke.getKeyStroke(KeyEvent.VK_M,InputEvent.CTRL_DOWN_MASK),"click");
        actMap.put("click",new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				btnNewButton.doClick();
				
			}
        	
        });
        
        InputMap inputmapClose = btnNewButton2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actMapClose = btnNewButton2.getActionMap();
        
        inputmapClose.put(KeyStroke.getKeyStroke(KeyEvent.VK_M,InputEvent.CTRL_DOWN_MASK),"click");
        actMapClose.put("click",new AbstractAction() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				btnNewButton2.doClick();
				
			}
        	  
        });
        // Kết thúc gắn phím tắt
       
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {

    	
    	try {
    		javax.swing.UIManager.setLookAndFeel(new FlatLightLaf());
    	}catch (Exception e) {
			 e.printStackTrace();
		}
        NhanVien nv = new NhanVien("NV001", "Nguyễn Văn A",true,"0901234567","password123",true,true,"123456789","Tràng Tiền, Hoàn Kiếm, Hà Nội");
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main(nv).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private gui.component.Header header1;
    private javax.swing.JPanel mainPanel;
    private gui.component.Menu menu2;
    private JButton btnNewButton;
    private JButton btnNewButton2;
}
