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
import entity.KhachHang;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DAO_KhachHang {

    private Connection con;
    //private DAO_DiaChi dao_DiaChi = new DAO_DiaChi();

    public DAO_KhachHang() {
        try {
            con = ConnectDB.getInstances().getConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public KhachHang timKhachHangTheoSDT(String so_dien_thoai) {
        String sql = "select * from KhachHang where so_dien_thoai= ? ";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, so_dien_thoai);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                try {
                    //DiaChi diachi = dao_DiaChi.timdiachi(rs.getString("dia_chi"));
                    KhachHang khachhang = new KhachHang(rs.getString("ma_khach_hang"), rs.getString("ten_khach_hang"), rs.getBoolean("gioi_tinh"), rs.getString("so_dien_thoai"), rs.getString("dia_chi"), rs.getBoolean("trang_thai"));
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
    public ArrayList<KhachHang> timKhachHangTheoDK(String tenKH,String sdt,String trang_thai,String gioi_tinh,String dc) {
        ArrayList<KhachHang> listKhachHang = new ArrayList<>();
        String sql = "SELECT *\n"
                + "FROM    \n"
                + "                  KhachHang\n"
                + "Where ten_khach_hang like ? and so_dien_thoai like ? and trang_thai like ? and gioi_tinh like ? and dia_chi like ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
             stmt.setString(1, "%" + tenKH + "%");
            stmt.setString(2, "%" + sdt + "%");
            stmt.setString(3, "%" + trang_thai + "%");
            stmt.setString(4, "%" + gioi_tinh + "%");
            stmt.setString(5, "%" + dc + "%");
            
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
//                DiaChi diachi = dao_DiaChi.timdiachi(rs.getString("dia_chi"));
                KhachHang khachhang = new KhachHang(rs.getString("ma_khach_hang"), rs.getString("ten_khach_hang"), rs.getBoolean("gioi_tinh"), rs.getString("so_dien_thoai"), rs.getString("dia_chi"), rs.getBoolean("trang_thai"));
                listKhachHang.add(khachhang);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        ArrayList<KhachHang> tmp = new ArrayList<>();
        String sql = "select kh.* from KhachHang";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setMaKH(rs.getString("ma_khach_hang"));
                kh.setTenKh(rs.getString("ten_khach_hang"));
                kh.setGioiTinh(rs.getBoolean("gioi_tinh"));
                kh.setSdt(rs.getString("so_dien_thoai"));
                kh.setTrangThai(rs.getBoolean("trang_thai"));
                //DiaChi dcKH = new DiaChi(rs.getString("dia_chi"), rs.getString("tinh_tp"), rs.getString("quan_huyen"), rs.getString("phuong_xa"));
                kh.setDiaChi(rs.getString("dia_chi"));
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
            String sql = "Select * from KhachHang Order by ma_khach_hang Desc";
            Statement statement;
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String ma_khach_hang = rs.getString("ma_khach_hang");
                String ten_khach_hang = rs.getString("ten_khach_hang");
                boolean gioi_tinh = rs.getBoolean("gioi_tinh");
                String sdt = rs.getString("so_dien_thoai");
                boolean trang_thai = rs.getBoolean("trang_thai");
                String dia_chi = rs.getString("dia_chi");
//                DAO_DiaChi diaChi_dao = new DAO_DiaChi();
//                DiaChi diaChi = diaChi_dao.getDiaChiByMaDiaChi(dia_chi);

                KhachHang kh = new KhachHang(ma_khach_hang, ten_khach_hang, gioi_tinh, sdt, dia_chi, trang_thai);
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
            statement.setString(5, kh.getDiaChi());
            statement.setBoolean(6, kh.isTrangThai());
            n = statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }

    public boolean xoaKhachHang(String maKH) {
        int n = -1;
        String sql = "DELETE FROM [dbo].[KhachHang]\n"
                + "WHERE ma_khach_hang= ? ";
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
                + "   SET [ten_khach_hang] = ? \n"
                + "      ,[gioi_tinh] = ? \n"
                + "      ,[so_dien_thoai] = ? \n"
                + "      ,[trang_thai] = ? \n"
                + "      ,[dia_chi] = ? \n"
                + " WHERE ma_khach_hang= ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, kh.getTenKh());
            stmt.setBoolean(2, kh.isGioiTinh());
            stmt.setString(3, kh.getSdt());
            stmt.setBoolean(4, kh.isTrangThai());
            stmt.setString(5, kh.getDiaChi());
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
        String sql = "select top 1 ma_khach_hang from KhachHang order by ma_khach_hang desc";
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
        String str = strMaKH.substring(2, 4);
        strMaKH = strMaKH.substring(4);
        long longMaHD = Long.parseLong(strMaKH);
        if (longMaHD == 999) {
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
//        System.out.println(longMaHD);
//        System.out.println(str);
        strMaKH = longMaHD == 0 ? String.valueOf(1001 + longMaHD) : String.valueOf(1000 + longMaHD);
//        System.err.println(strMaKH);
        strMaKH = "KH" + str + strMaKH.substring(3);
        return strMaKH;
    }
}
