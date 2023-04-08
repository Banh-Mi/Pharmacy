/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.DiaChi;
import entity.HoaDonBan;
import entity.KhachHang;
import entity.NhanVien;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author NDT
 */
public class DAO_HoaDonBan {

    private Connection con;
    private DAO_DiaChi daodc;

    public DAO_HoaDonBan() {
        try {
            con = connect.ConnectDB.getInstances().getConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_HoaDonBan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String taoMaNgauNhien() {
        String strMaHD = null;

        PreparedStatement s = null;
        String sql = "select top 1 ma_hoa_don_ban from HoaDonBan order by ma_hoa_don_ban desc";
        try {
            s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
                strMaHD = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tạo mã HĐ");
            return "";
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (strMaHD == null) {
            strMaHD = "BTAA000000";
        }

        String str = strMaHD.substring(2, 4);
        strMaHD = strMaHD.substring(4);
        long longMaHD = Long.parseLong(strMaHD);
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
        strMaHD = longMaHD == 0 ? String.valueOf(1000001 + longMaHD) : String.valueOf(1000000 + longMaHD);
        strMaHD = "BT" + str + strMaHD.substring(1);
        return strMaHD;
    }

    public boolean taoHoaDon(HoaDonBan hoaDon) {
        int n = -1;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date(System.currentTimeMillis());
        Date fordate = Date.valueOf(formatter.format(today));
        
        String sql = "INSERT INTO [dbo].[HoaDonBan]\n"
                + "           ([ma_hoa_don_ban]\n"
                + "           ,[ngay_lap_hd]\n"
                + "           ,[ma_nhan_vien]\n"
                + "           ,[ma_khach_hang])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, hoaDon.getMaHoaDonBan());
            stmt.setDate(2, fordate);
            stmt.setString(3, hoaDon.getNv().getMaNV());
            stmt.setString(4, hoaDon.getKh().getMaKH());
            n = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDonBan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }

    public ArrayList<HoaDonBan> getDSHoaDonBan() {
        ArrayList<HoaDonBan> tmp = new ArrayList<>();

        String sql = "select hdb.*,kh.ten_khach_hang,nv.ten_nhan_vien from HoaDonBan hdb join KhachHang kh on kh.ma_khach_hang=hdb.ma_khach_hang join NhanVien nv on nv.ma_nhan_vien = hdb.ma_nhan_vien order by ngay_lap_hd desc, hdb.ma_hoa_don_ban desc";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString("ten_nhan_vien"));
                nv.setDiaChi(null);
//                nv.setTenNV(rs.getString("ten_nhan_vien"));
                KhachHang kh = new KhachHang(rs.getString("ma_khach_hang"), rs.getString("ten_khach_hang"));
                HoaDonBan hdb = new HoaDonBan();
                hdb.setMaHoaDonBan(rs.getString("ma_hoa_don_ban"));
                hdb.setNgayLapHD(rs.getDate("ngay_lap_hd"));
                hdb.setKh(kh);
                hdb.setNv(nv);
                tmp.add(hdb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDonBan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }

    public HoaDonBan getChiTietHoaDonBan(String maHD) {
        String sql = "select hdb.*,kh.ten_khach_hang, kh.dia_chi as 'maDCKH', kh.gioi_tinh as 'gioiTinhKH' ,nv.ten_nhan_vien from HoaDonBan hdb join KhachHang kh on kh.ma_khach_hang=hdb.ma_khach_hang join NhanVien nv on nv.ma_nhan_vien = hdb.ma_nhan_vien where ma_hoa_don_ban =?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maHD);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString("ten_nhan_vien"));
                nv.setDiaChi(null);
//                nv.setTenNV(rs.getString("ten_nhan_vien"));
                KhachHang kh = new KhachHang(rs.getString("ma_khach_hang"), rs.getString("ten_khach_hang"));
                kh.setGioiTinh(rs.getBoolean("gioi_tinh"));
                daodc = new DAO_DiaChi();
                DiaChi diaChiKhachHang = daodc.getDiaChiByMaDiaChi(rs.getString("dia_chi"));
                kh.setDiaChi(diaChiKhachHang);
                HoaDonBan hdb = new HoaDonBan();
                hdb.setMaHoaDonBan(rs.getString("ma_hoa_don_ban"));
                hdb.setNgayLapHD(rs.getDate("ngay_lap_hd"));
                hdb.setKh(kh);
                hdb.setNv(nv);
                return hdb;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDonBan.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;

    }

    public ArrayList<HoaDonBan> getDSHoaDonBanTheoMaNV(String maNV) {
        ArrayList<HoaDonBan> tmp = new ArrayList<>();

        String sql = "select hdb.*,kh.ten_khach_hang,nv.ten_nhan_vien from HoaDonBan hdb join KhachHang kh on kh.ma_khach_hang=hdb.ma_khach_hang join NhanVien nv on nv.ma_nhan_vien = hdb.ma_nhan_vien where hdb.ma_nhan_vien= ? order by ngay_lap_hd desc, hdb.ma_hoa_don_ban desc ";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maNV);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString("ten_nhan_vien"));
                nv.setDiaChi(null);
//                nv.setTenNV(rs.getString("ten_nhan_vien"));
                KhachHang kh = new KhachHang(rs.getString("ma_khach_hang"), rs.getString("ten_khach_hang"));
                HoaDonBan hdb = new HoaDonBan();
                hdb.setMaHoaDonBan(rs.getString("ma_hoa_don_ban"));
                hdb.setNgayLapHD(rs.getDate("ngay_lap_hd"));
                hdb.setKh(kh);
                hdb.setNv(nv);
                tmp.add(hdb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDonBan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }

    public ArrayList<HoaDonBan> timKiemHoaDon(String maHD, String tenKh, String sdtKH, String sdtNV, Date ngayLapHoaDon) {
        ArrayList<HoaDonBan> tmp = new ArrayList<>();

        String sql = "select * from HoaDonBan hdb join KhachHang kh on hdb.ma_khach_hang = kh.ma_khach_hang join NhanVien nv on nv.ma_nhan_vien=hdb.ma_nhan_vien where ma_hoa_don_ban like ? and ten_khach_hang like ? and soDienThoai like ? and soDienThoaiNV like ?";
        if (ngayLapHoaDon != null) {
            sql += " and ngay_lap_hd= ?";
        }
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + maHD + "%");
            stmt.setString(2, "%" + tenKh + "%");
            stmt.setString(3, "%" + sdtKH + "%");
            stmt.setString(4, "%" + sdtNV + "%");
            if (ngayLapHoaDon != null) {
                stmt.setDate(5, ngayLapHoaDon);
            }
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString("ten_nhan_vien"));
                nv.setDiaChi(null);
                KhachHang kh = new KhachHang(rs.getString("ma_khach_hang"), rs.getString("ten_khach_hang"));
                HoaDonBan hdb = new HoaDonBan();
                hdb.setMaHoaDonBan(rs.getString("ma_hoa_don_ban"));
                hdb.setNgayLapHD(rs.getDate("ngay_lap_hd"));
                hdb.setKh(kh);
                hdb.setNv(nv);
                tmp.add(hdb);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDonBan.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tmp;
    }

    public boolean xoaHoaDon(String maHD) {
        int n = -1;
        String sql = "DELETE FROM [dbo].[HoaDonBan]\n"
                + "      WHERE ma_hoa_don_ban = ? ";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maHD);
            n = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_HoaDonBan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }

    public ArrayList<HoaDonBan> getHoaDonTheoNgayCuaNhanVien(String ngay, String maNV) {
        ArrayList<HoaDonBan> list = new ArrayList<HoaDonBan>();
        String sql = "select ma_hoa_don_ban from HoaDonBan where ngay_lap_hd = '" + ngay + "' and ma_nhan_vien like '%" + maNV + "%'";
        PreparedStatement s = null;
        try {
            s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                String ma = rs.getString(1);
                HoaDonBan hd = new HoaDonBan(ma);
                list.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }

    public ArrayList<HoaDonBan> getTatCaHoaDonTheoNgay(String ngay) {
        ArrayList<HoaDonBan> list = new ArrayList<HoaDonBan>();
        String sql = "select ma_hoa_don_ban from HoaDonBan where ngay_lap_hd = '" + ngay + "'";
        PreparedStatement s = null;
        try {
            s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                String ma = rs.getString(1);
                HoaDonBan hd = new HoaDonBan(ma);
                list.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }

    public ArrayList<HoaDonBan> getHoaDonTheoThang(String thang, String ma) {
        ArrayList<HoaDonBan> list = new ArrayList<>();
        String sql = "select ma_hoa_don_ban from HoaDonBan where MONTH(ngay_lap_hd) = " + thang
                + " and YEAR(ngay_lap_hd) = YEAR(GETDATE()) and ma_nhan_vien like '%" + ma + "%'";

        PreparedStatement s = null;
        try {
            s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
                String mahd = rs.getString(1);

                HoaDonBan hd = new HoaDonBan(mahd);
                list.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }

    public ArrayList<HoaDonBan> thongKeThang(String thang, String ngay, String manv) {
        ArrayList<HoaDonBan> list = new ArrayList<>();
        String sql = "select ma_hoa_don_ban from HoaDonBan where MONTH(ngay_lap_hd) = " + thang
                + " and day(ngay_lap_hd) = " + ngay
                + " and YEAR(ngay_lap_hd) = YEAR(GETDATE()) and ma_nhan_vien like '%" + manv + "%'";

        PreparedStatement s = null;
        try {
            s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
                String ma = rs.getString(1);

                HoaDonBan hd = new HoaDonBan(ma);
                list.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }

    public ArrayList<HoaDonBan> getHoaDonTheoNam(String nam, String maNV) {
        ArrayList<HoaDonBan> list = new ArrayList<>();
        String sql = "select ma_hoa_don_ban from HoaDonBan where Year(ngay_lap_hd) = " + nam + " and ma_nhan_vien like '%" + maNV + "%'";

        PreparedStatement s = null;
        try {
            s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
                String ma = rs.getString(1);

                HoaDonBan hd = new HoaDonBan(ma);
                list.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }

    public ArrayList<HoaDonBan> thongKeNam(String nam, String thang, String maNV) {
        ArrayList<HoaDonBan> list = new ArrayList<HoaDonBan>();
        String sql = "select ma_hoa_don_ban from HoaDonBan where YEAR(ngay_lap_hd) = " + nam
                + " and MONTH(ngay_lap_hd) = " + thang + " and ma_nhan_vien like '%" + maNV + "%'";

        PreparedStatement s = null;
        try {
            s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
                String ma = rs.getString(1);

                HoaDonBan hd = new HoaDonBan(ma);
                list.add(hd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }
}
