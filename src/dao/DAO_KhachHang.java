/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connect.ConnectDB;
import entity.DiaChi;
import entity.KhachHang;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author NDT
 */
public class DAO_KhachHang {

    private Connection con;
    private DAO_DiaChi dao_DiaChi = new DAO_DiaChi();

    public DAO_KhachHang() {
        try {
            con = ConnectDB.getInstances().getConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public KhachHang timKhachHangTheoSDT(String soDienThoai) {
        String sql = "select * from KhachHang where soDienThoai= ? ";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, soDienThoai);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                try {
                    DiaChi diachi = dao_DiaChi.timdiachi(rs.getString("maDC"));
                    KhachHang khachhang = new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"), rs.getBoolean("gioiTinh"), rs.getString("soDienThoai"), diachi, rs.getBoolean("trangThai"));
                    return khachhang;
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<KhachHang> timKhachHangTheoDK(String tenKH,String sdt,String trangThai,String gioiTinh,String tinh,String huyen,String phuong) {
        ArrayList<KhachHang> listKhachHang = new ArrayList<>();
        String sql = "SELECT *\n"
                + "FROM     DiaChi INNER JOIN\n"
                + "                  KhachHang ON DiaChi.maDC = KhachHang.maDC\n"
                + "Where tenKhachHang like ? and soDienThoai like ? and trangThai like ? and gioiTinh like ? and tinhTP like ? and quanHuyen like ? and phuongXa like ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setString(1, "%" + tenKH + "%");
            stmt.setString(2, "%" + sdt + "%");
            stmt.setString(3, "%" + trangThai + "%");
            stmt.setString(4, "%" + gioiTinh + "%");
            stmt.setString(5, "%" + tinh + "%");
            stmt.setString(6, "%" + huyen+ "%");
            stmt.setString(7, "%" + phuong+ "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                DiaChi diachi = dao_DiaChi.timdiachi(rs.getString("maDC"));
                KhachHang khachhang = new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"), rs.getBoolean("gioiTinh"), rs.getString("soDienThoai"), diachi, rs.getBoolean("trangThai"));
                listKhachHang.add(khachhang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        ArrayList<KhachHang> tmp = new ArrayList<>();
        String sql = "select kh.*,dc.* from KhachHang kh join DiaChi dc on kh.maDC=dc.maDC";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("maKhachHang"));
                kh.setTenKh(rs.getString("tenKhachHang"));
                kh.setGioiTinh(rs.getBoolean("gioiTinh"));
                kh.setSdt(rs.getString("soDienThoai"));
                kh.setTrangThai(rs.getBoolean("trangThai"));
                DiaChi dcKH = new DiaChi(rs.getString("maDC"), rs.getString("tinhTP"), rs.getString("quanHuyen"), rs.getString("phuongXa"));
                kh.setDiaChi(dcKH);
                tmp.add(kh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }

    public ArrayList<KhachHang> getAllKhachHang() {
        ArrayList<KhachHang> listKhachHang = new ArrayList<>();
        try {
            String sql = "Select * from KhachHang Order by maKhachHang Desc";
            Statement statement;
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String maKhachHang = rs.getString("maKhachHang");
                String tenKhachHang = rs.getString("tenKhachHang");
                boolean gioiTinh = rs.getBoolean("gioiTinh");
                String sdt = rs.getString("soDienThoai");
                boolean trangThai = rs.getBoolean("trangThai");
                String maDC = rs.getString("maDC");

                DAO_DiaChi diaChi_dao = new DAO_DiaChi();
                DiaChi diaChi = diaChi_dao.getDiaChiByMaDiaChi(maDC);

                KhachHang kh = new KhachHang(maKhachHang, tenKhachHang, gioiTinh, sdt, diaChi, trangThai);
                listKhachHang.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;
    }

    public boolean themKhachHang(KhachHang kh) {
        int n = -1;
        if (timKhachHangTheoSDT(kh.getSdt()) != null) {
            return n > 0;
        }
        String sql = "insert into KhachHang values(?,?,?,?,?,?)";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, kh.getMaKH());
            statement.setString(2, kh.getTenKh());
            statement.setBoolean(3, kh.isGioiTinh());
            statement.setString(4, kh.getSdt());
            statement.setString(6, kh.getDiaChi().getMaDC());
            statement.setBoolean(5, kh.isTrangThai());
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }

    public boolean xoaKhachHang(String maKH) {
        int n = -1;
        String sql = "DELETE FROM [dbo].[KhachHang]\n"
                + "WHERE maKhachHang= ? ";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maKH);
            n = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }

    public boolean capNhatKhachHang(KhachHang kh) {
        int n = -1;
        String sql = "UPDATE [dbo].[KhachHang]\n"
                + "   SET [tenKhachHang] = ? \n"
                + "      ,[gioiTinh] = ? \n"
                + "      ,[soDienThoai] = ? \n"
                + "      ,[trangThai] = ? \n"
                + "      ,[maDC] = ? \n"
                + " WHERE maKhachHang= ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, kh.getTenKh());
            stmt.setBoolean(2, kh.isGioiTinh());
            stmt.setString(3, kh.getSdt());
            stmt.setBoolean(4, kh.isTrangThai());
            stmt.setString(5, kh.getDiaChi().getMaDC());
            stmt.setString(6, kh.getMaKH());
            n = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }

    public String TaoSoNgauNhien() {
        String strMaKH = null;

        PreparedStatement s = null;
        String sql = "select top 1 maKhachHang from KhachHang order by maKhachHang desc";
        try {
            s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                strMaKH = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tạo mã khách hàng");
            return "";
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        String str = strMaKH.substring(4, 6);
        strMaKH = strMaKH.substring(6);
        long longMaHD = Long.parseLong(strMaKH);
        if (longMaHD == 999999) {
            if (str.equals("ZZ")) {
                return "error! (out of memory)";
            } else if (str.codePointAt(1) == 90) {
                int temp = str.codePointAt(0) + 1;
                str = (char) temp + "A";
                longMaHD = 0;
            } else {
                int temp = str.codePointAt(0);
                int temp1 = str.codePointAt(1) + 1;
                str = (char) temp + "" + (char) temp1;
                longMaHD = 0;
            }
        } else {
            longMaHD += 1;
        }
        System.out.println(longMaHD);
        System.out.println(str);
        strMaKH = longMaHD == 0 ? String.valueOf(1000001 + longMaHD) : String.valueOf(1000000 + longMaHD);
        System.err.println(strMaKH);
        strMaKH = "KHAA" + str + strMaKH.substring(3);
        return strMaKH;
    }
}
