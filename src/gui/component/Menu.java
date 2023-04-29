package gui.component;

import gui.event.EventMenuSelected;
import gui.event.EventMenu;
import gui.event.EventMenuCallBack;
import gui.model.Model_Menu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Font;


public class Menu extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void addEventMenu(EventMenu event) {
        this.event = event;
    }

    private int selectedIndex = -1;
    private final Timer timer;
    private boolean toUp;
    private int menuTarget;
    int menuY;
    private int speed = 10;
    private EventMenuCallBack callBack;
    private EventMenu event;

    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu.setOpaque(false);
        listMenu.addEventSelectedMenu(new EventMenuSelected() {
            @Override
            public void menuSelected(int index, EventMenuCallBack callBack) {
                if (index != selectedIndex) {
                    Menu.this.callBack = callBack;
                    toUp = selectedIndex > index;
//                    selectedIndex = index;
                    if (selectedIndex == -1) {//vị trí bắt đầu                   
                        speed = 15;
                    } else {
//                        speed = selectedIndex + index;
                        if (speed < 0) {
                            speed *= -1;
                        }
                    }
                    selectedIndex = index;
                    menuTarget = selectedIndex * 35 + listMenu.getY();//menuTager ở vị trí y
                    if (!timer.isRunning()) {
                        timer.start();
                    }
                }
            }
        });
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toUp) {
                    if (menuY <= menuTarget) {
                        menuY = menuTarget;
                        repaint();
                        callBack.call(selectedIndex);
                        if (event != null) {
                            event.menuIndexChange(selectedIndex);
                        }
                    } else {
                        menuY -= speed;
                        repaint();
                    }
                } else {
                    if (menuY >= menuTarget - 1) {//style animation
                        menuY = menuTarget;
                        timer.stop();
                        callBack.call(selectedIndex);
                        if (event != null) {
                            event.menuIndexChange(selectedIndex);
                        }
                    } else {
                        menuY += speed;
                        repaint();
                    }
                }
            }
        });
        initData();
    }

    private void initData() {
        listMenu.addItem(new Model_Menu("home", "Trang Chủ", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("store", "Cửa Hàng", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("medicine", "Thuốc", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("employees", "Nhân Viên", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("customer", "Khách Hàng", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("bill", "Hóa đơn", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("chart", "Thống kê", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("address", "Tài Khoản", Model_Menu.MenuType.MENU));

        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("", "", Model_Menu.MenuType.EMPTY));
        listMenu.addItem(new Model_Menu("logout", "Đăng xuất", Model_Menu.MenuType.LOGOUT));

    }

    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTieuDe = new javax.swing.JLabel();
        listMenu = new gui.swing.ListMenu<>();
        listMenu.setFont(new Font("Nunito", Font.PLAIN, 13));

        jPanel1.setOpaque(false);

        lblTieuDe.setFont(new java.awt.Font("VNI-Fato", 1, 24)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(255, 255, 255));
        lblTieuDe.setIcon(new ImageIcon(Menu.class.getResource("/image/imgs/membermenu.png"))); // NOI18N
        lblTieuDe.setText("G.O.A.T");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(32)
        			.addComponent(lblTieuDe, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap(20, Short.MAX_VALUE)
        			.addComponent(lblTieuDe)
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(listMenu, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
        			.addContainerGap())
        		.addComponent(jPanel1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(13)
        			.addComponent(listMenu, GroupLayout.PREFERRED_SIZE, 713, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#2e7bff"), 0, getHeight(), Color.decode("#2e7bff"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10,10);//bo góc
        if (selectedIndex >= 0) {
            int menuX = 10;
            int height = 35;
            int width = getWidth()-20;
            g2.setColor(new Color(255, 255, 255));
            if (selectedIndex <= 7) {
            	int cornerRadius = Math.min(width, height); 
            	g2.fillRoundRect(menuX, menuY, width, height, cornerRadius, cornerRadius);
            } else {
                g2.fillRoundRect(menuX, menuY - 15, width, height, 35, 35);
            }

        }
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblTieuDe;
    private gui.swing.ListMenu<String> listMenu;
    // End of variables declaration//GEN-END:variables

}
