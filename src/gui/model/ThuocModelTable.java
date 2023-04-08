/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui.model;

import entity.Thuoc;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author NDT
 */
public class ThuocModelTable extends AbstractTableModel{

    private String[] header;
    private ArrayList<Thuoc> dst;

    public ThuocModelTable(String[] header, ArrayList<Thuoc> dst) {
        this.header = header;
        this.dst = dst;
    }
    
    @Override
    public int getRowCount() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return dst.size();
    }


    @Override
    public int getColumnCount() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Thuoc t=dst.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return t.getTenThuoc();
            case 1:
                return t.getThanhPhan();
            case 2:
                return t.getDangBaoChe();
            case 3:
                return t.getDonViTinh();
            case 4: 
                return t.getHamLuong();
            case 5:
                return t.getCongDung().getNhomCongDung();
            case 6:
                return t.getHanSuDung();
            case 7:
                return t.getGiaBan();
            case 8:
                return t.getSoLuongBanDau();
            default:
                throw new AssertionError();
        }
    }

    @Override
    public String getColumnName(int column) {
        return header[column]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
//        return super.getColumnClass(columnIndex); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        if (columnIndex==7)
            return Double.class;
        if (columnIndex==8)
            return Integer.class;
        return String.class;
    }
    
    
    
    
    
    
}
