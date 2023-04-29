package gui.model;

import entity.Thuoc;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ThemThuocModelTable extends AbstractTableModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] header;
    private ArrayList<Thuoc> dsThemThuoc;

    public ThemThuocModelTable(String[] header, ArrayList<Thuoc> dsThemThuoc) {
        this.header = header;
        this.dsThemThuoc = dsThemThuoc;
    }

    @Override
    public int getRowCount() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return dsThemThuoc.size();
    }

    @Override
    public int getColumnCount() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Thuoc t = dsThemThuoc.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return t.getTenThuoc();
            case 1:
                return t.getHamLuong();
            case 2:
                return t.getGiaBan();
            case 3:
                return t.getThueVAT();
            case 4:
                return t.getSoLuongBanDau();
            case 5:
                return t.tongtien();
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
        if (columnIndex == 2) {
            return Double.class;
        }
        if (columnIndex == 3) {
            return Double.class;
        }
        if (columnIndex == 4) {
            return Integer.class;
        }
        if (columnIndex == 5) {
            return Double.class;
        }
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if (columnIndex == 4) {
            return true;
        }
        return false;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        if (value instanceof String) {
            Thuoc temp = dsThemThuoc.get(row);
            temp.setSoLuongBanDau(Integer.parseInt(value.toString()));
            dsThemThuoc.set(row, temp);
            fireTableRowsUpdated(row, row);
        }
    }

}
