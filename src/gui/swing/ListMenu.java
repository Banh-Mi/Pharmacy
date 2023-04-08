
package gui.swing;

import gui.event.EventMenuCallBack;
import gui.event.EventMenuSelected;
import gui.model.Model_Menu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import gui.form.TrangDangNhap;
import gui.main.Main;
import javax.swing.JOptionPane;

/**
 *
 * @author THANHTU
 */
public class ListMenu<E extends Object> extends JList<E> {
    
    public void addEventSelectedMenu(EventMenuSelected event){
        events.add(event);
    }
    
    private final DefaultListModel model;
    private final List<EventMenuSelected> events;
    private int selectedIndex = -1;
    private EventMenuSelected event;
    public void addEventMenuSelected(EventMenuSelected eventMenu) {
        this.event = event;
    }

    public ListMenu() {
        model = new DefaultListModel();
        events = new ArrayList<>();
        super.setModel(model);
                addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int index = locationToIndex(me.getPoint());
                    Object obj = model.getElementAt(index);
                    if (obj instanceof Model_Menu) {
                        Model_Menu data = (Model_Menu) obj;
                        if (data.getType() ==  Model_Menu.MenuType.MENU) {
                            if(index != selectedIndex){
                                selectedIndex = -1;
                                runEvent(index);
                            }  
                        }
                        else if(data.getType() ==  Model_Menu.MenuType.LOGOUT)
                        {
                            int dialogButton = JOptionPane.YES_NO_OPTION;
                            int dialogResult = JOptionPane.showConfirmDialog (null, "BẠN CÓ MUỐN THOÁT","Xác thực",dialogButton);
                            if (dialogResult==0)
                            {
                                System.exit(0);
                            }
                        }
                    }else{
                        if(index != selectedIndex){
                            selectedIndex = -1;
                            runEvent(index);
                        }  
                    }
                }
            }
        });
    }
    
    private void runEvent(int indexChange){
        for(EventMenuSelected event:events){
            event.menuSelected(indexChange, new EventMenuCallBack() {
                @Override
                public void call(int index) {
                    //gọi lại hàm khi chạy sự kiện khi có animation thành công
                   selectedIndex = index;
                   repaint();
                }
            });
        }
    }
    
    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object o, int index, boolean selected, boolean focus) {
                Model_Menu data;
                if (o instanceof Model_Menu) {
                    data = (Model_Menu) o;
                }else{
                    data = new Model_Menu("1", o + "", Model_Menu.MenuType.MENU);
                }
                MenuItem item = new MenuItem(data);
                item.setSelected(index == selectedIndex);
                return item;
            }   
        };
    }
    
    @Override
    public void setModel(ListModel<E> lm) {
        for (int i = 0; i < lm.getSize(); i++) {
            model.addElement(lm.getElementAt(i));
        }
    }
    
    public void addItem(Model_Menu data){
        model.addElement(data);
    }
}
