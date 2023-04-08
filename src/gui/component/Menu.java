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
import java.awt.geom.Path2D;
import javax.swing.Timer;

/**
 *
 * @author THANHTU
 */
public class Menu extends javax.swing.JPanel {

    public void addEventMenu(EventMenu event) {
        this.event = event;
    }

    private int selectedIndex = -1;
    private final Timer timer;
    private boolean toUp;
    private int menuTarget;
    int menuY;
    private int speed = 5;
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
                    speed++;// add tốc dodojwoj lên 1
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
        listMenu.addItem(new Model_Menu("iconTrangChu", "Trang Chủ", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("iconCuaHang", "Cửa Hàng", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("iconThuoc", "Thuốc", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("iconNhanVien", "Nhân Viên", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("iconKhachHang", "Khách Hàng", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("iconHoaDon", "Hóa đơn", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("iconThongKe", "Thống kê", Model_Menu.MenuType.MENU));
        listMenu.addItem(new Model_Menu("iconKhachHang", "Tài Khoản", Model_Menu.MenuType.MENU));

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblTieuDe = new javax.swing.JLabel();
        listMenu = new gui.swing.ListMenu<>();
        jPanel2 = new javax.swing.JPanel();

        jPanel1.setOpaque(false);

        lblTieuDe.setFont(new java.awt.Font("VNI-Fato", 1, 24)); // NOI18N
        lblTieuDe.setForeground(new java.awt.Color(255, 255, 255));
        lblTieuDe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/icon/icons8-health-40.png"))); // NOI18N
        lblTieuDe.setText("TAK'S Medical");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTieuDe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTieuDe)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(listMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(listMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 719, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g = new GradientPaint(0, 0, Color.decode("#009999"), 0, getHeight(), Color.decode("#ffdeff9"));
        g2.setPaint(g);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);//bo góc
        if (selectedIndex >= 0) {
            int menuX = 10;
            int height = 35;
            int width = getWidth();
            g2.setColor(new Color(255, 255, 255));
            if (selectedIndex <= 7) {
                g2.fillRoundRect(menuX, menuY, width, height, 35, 35);
                Path2D.Float f = new Path2D.Float();
                f.moveTo(width - 30, menuY);
                f.curveTo(width - 10, menuY, width, menuY, width, menuY - 30);
                f.lineTo(width, menuY + height + 30);
                f.curveTo(width, menuY + height, width - 10, menuY + height, width - 30, menuY + height);
                g2.fill(f);
            } else {
                g2.fillRoundRect(menuX, menuY - 15, width, height, 35, 35);
            }

        }
        super.paintComponent(grphcs);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblTieuDe;
    private gui.swing.ListMenu<String> listMenu;
    // End of variables declaration//GEN-END:variables

}
