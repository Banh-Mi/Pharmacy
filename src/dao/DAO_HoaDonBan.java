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
        String sql = "select top 1 maHoaDonBan from HoaDonBan order by maHoaDonBan desc";
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
                + "           ([maHoaDonBan]\n"
                + "           ,[ngayLapHDBan]\n"
                + "           ,[maNhanVien]\n"
                + "           ,[maKhachHang])\n"
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

        String sql = "select hdb.*,kh.tenKhachHang,nv.tenNhanVien from HoaDonBan hdb join KhachHang kh on kh.maKhachHang=hdb.maKhachHang join NhanVien nv on nv.maNhanVien = hdb.maNhanVien order by ngayLapHDBan desc, hdb.maHoaDonBan desc";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString("tenNhanVien"));
                nv.setDiaChi(null);
//                nv.setTenNV(rs.getString("tenNhanVien"));
                KhachHang kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"));
                HoaDonBan hdb = new HoaDonBan();
                hdb.setMaHoaDonBan(rs.getString("maHoaDonBan"));
                hdb.setNgayLapHD(rs.getDate("ngayLapHDBan"));
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
        String sql = "select hdb.*,kh.tenKhachHang, kh.maDC as 'maDCKH', kh.gioiTinh as 'gioiTinhKH' ,nv.tenNhanVien from HoaDonBan hdb join KhachHang kh on kh.maKhachHang=hdb.maKhachHang join NhanVien nv on nv.maNhanVien = hdb.maNhanVien where maHoaDonBan =?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maHD);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString("tenNhanVien"));
                nv.setDiaChi(null);
//                nv.setTenNV(rs.getString("tenNhanVien"));
                KhachHang kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"));
                kh.setGioiTinh(rs.getBoolean("gioiTinhKH"));
                daodc = new DAO_DiaChi();
                DiaChi diaChiKhachHang = daodc.getDiaChiByMaDiaChi(rs.getString("maDCKH"));
                kh.setDiaChi(diaChiKhachHang);
                HoaDonBan hdb = new HoaDonBan();
                hdb.setMaHoaDonBan(rs.getString("maHoaDonBan"));
                hdb.setNgayLapHD(rs.getDate("ngayLapHDBan"));
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

        String sql = "select hdb.*,kh.tenKhachHang,nv.tenNhanVien from HoaDonBan hdb join KhachHang kh on kh.maKhachHang=hdb.maKhachHang join NhanVien nv on nv.maNhanVien = hdb.maNhanVien where hdb.maNhanVien= ? order by ngayLapHDBan desc, hdb.maHoaDonBan desc ";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maNV);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien(rs.getString("tenNhanVien"));
                nv.setDiaChi(null);
//                nv.setTenNV(rs.getString("tenNhanVien"));
                KhachHang kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"));
                HoaDonBan hdb = new HoaDonBan();
                hdb.setMaHoaDonBan(rs.getString("maHoaDonBan"));
                hdb.setNgayLapHD(rs.getDate("ngayLapHDBan"));
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

        String sql = "select * from HoaDonBan hdb join KhachHang kh on hdb.maKhachHang = kh.maKhachHang join NhanVien nv on nv.maNhanVien=hdb.maNhanVien where maHoaDonBan like ? and tenKhachHang like ? and soDienThoai like ? and soDienThoaiNV like ?";
        if (ngayLapHoaDon != null) {
            sql += " and ngayLapHDBan= ?";
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
                NhanVien nv = new NhanVien(rs.getString("tenNhanVien"));
                nv.setDiaChi(null);
                KhachHang kh = new KhachHang(rs.getString("maKhachHang"), rs.getString("tenKhachHang"));
                HoaDonBan hdb = new HoaDonBan();
                hdb.setMaHoaDonBan(rs.getString("maHoaDonBan"));
                hdb.setNgayLapHD(rs.getDate("ngayLapHDBan"));
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
                + "      WHERE maHoaDonBan = ? ";
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
        String sql = "select maHoaDonBan from HoaDonBan where ngayLapHDBan = '" + ngay + "' and maNhanVien like '%" + maNV + "%'";
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
        String sql = "select maHoaDonBan from HoaDonBan where ngayLapHDBan = '" + ngay + "'";
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
        String sql = "select maHoaDonBan from HoaDonBan where MONTH(ngayLapHDBan) = " + thang
                + " and YEAR(ngayLapHDBan) = YEAR(GETDATE()) and maNhanVien like '%" + ma + "%'";

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
        String sql = "select maHoaDonBan from HoaDonBan where MONTH(ngayLapHDBan) = " + thang
                + " and day(ngayLapHDBan) = " + ngay
                + " and YEAR(ngayLapHDBan) = YEAR(GETDATE()) and maNhanVien like '%" + manv + "%'";

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
        String sql = "select maHoaDonBan from HoaDonBan where Year(ngayLapHDBan) = " + nam + " and maNhanVien like '%" + maNV + "%'";

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
        String sql = "select maHoaDonBan from HoaDonBan where YEAR(ngayLapHDBan) = " + nam
                + " and MONTH(ngayLapHDBan) = " + thang + " and maNhanVien like '%" + maNV + "%'";

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
