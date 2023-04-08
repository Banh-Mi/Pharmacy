package test;

import javax.swing.UIManager;

import gui.form.Form_CuaHang;

public class testgui {
    public static void main(String[] args) throws Exception {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
           
        } catch (Exception e) {
            // TODO: handle exception
        }
        
    }
}
