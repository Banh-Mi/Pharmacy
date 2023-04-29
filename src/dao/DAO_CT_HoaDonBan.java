/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.CT_HoaDonBan;
import entity.Thuoc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class DAO_CT_HoaDonBan {

    private Connection con;

    public DAO_CT_HoaDonBan() {
        try {
            con = connect.ConnectDB.getInstances().getConnection();
        } catch (Exception ex) {
            Logger.getLogger(DAO_CT_HoaDonBan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean capNhatChiTietHoaDon(Thuoc thuoc, String maHoaDon) {
        int n = -1;
        String sql = "INSERT INTO [dbo].[CT_HoaDonBan]\n"
                + "           ([so_luong]\n"
                + "           ,[ma_thuoc]\n"
                + "           ,[ma_hoa_don_ban]\n"
                + "           ,[gia_ban]\n"
                + "           ,[thue_vat])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?)";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, thuoc.getSoLuongBanDau());
            stmt.setString(2, thuoc.getMaThuoc());
            stmt.setString(3, maHoaDon);
            stmt.setDouble(4, thuoc.getGiaBan());
            stmt.setFloat(5, thuoc.getThueVAT());

            n = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAO_CT_HoaDonBan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }
     public boolean xoaCTHoaDon(String maHD) {
        int n = -1;
        String sql = "DELETE FROM [dbo].[CT_HoaDonBan]\n"
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
    public double giaTienTheoMaHD(String maHD) {
//        String gia = "";
        double gia=0;
        String sql = "select SUM(cthd.so_luong*cthd.gia_ban*(1+cthd.thue_vat)) as 'TongTien',ma_hoa_don_ban from CT_HoaDonBan cthd\n"
                + "group by cthd.ma_hoa_don_ban\n"
                + "Having ma_hoa_don_ban= ? ";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maHD);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
//                String x = String.format("%,.0f", rs.getDouble("TongTien"));
                gia = rs.getDouble("TongTien");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_CT_HoaDonBan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gia;
    }

    public ArrayList<CT_HoaDonBan> getChiTietHoaDon(String maHD) {
        ArrayList<CT_HoaDonBan> tmp = new ArrayList<CT_HoaDonBan>();
        String sql = "select cthd.*,t.ten_thuoc, t.thue_vat as 'thue_vat', t.gia_ban,t.thanh_phan from CT_HoaDonBan cthd join Thuoc t on cthd.ma_thuoc=t.ma_thuoc where ma_hoa_don_ban= ? ";
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maHD);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CT_HoaDonBan cthd = new CT_HoaDonBan();
//                String x = String.format("%,.0f", rs.getDouble("gia_ban"));

                cthd.setGiaBan(rs.getDouble("gia_ban"));
                cthd.setSoLuong(rs.getInt("so_luong"));
                cthd.setVat(rs.getFloat("thue_vat"));
                Thuoc t = new Thuoc();
                t.setTenThuoc(rs.getString("ten_thuoc"));
                t.setMaThuoc(rs.getString("ma_thuoc"));
                t.setThanhPhan(rs.getString("thanh_phan"));

                cthd.setThuoc(t);

                tmp.add(cthd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_CT_HoaDonBan.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tmp;
    }

    public ArrayList<CT_HoaDonBan> getDSCT_HdByMaHD(String maHD) {
        ArrayList<CT_HoaDonBan> list = new ArrayList<>();
        PreparedStatement s = null;
        String sql = "select * from CT_HoaDonBan where ma_hoa_don_ban = '" + maHD + "'";
        try {
            s = con.prepareStatement(sql);
            ResultSet r = s.executeQuery();
            // v.addElement("");
            while (r.next()) {
                int sl = r.getInt(1);
                String ma_thuoc = r.getString(3);
                double gia = r.getDouble(2);
                float thue_vat = r.getFloat(5);

                DAO_Thuoc dao = new DAO_Thuoc();
                Thuoc t = dao.getThuocTheoMa(ma_thuoc);

                CT_HoaDonBan ctHD = new CT_HoaDonBan(sl, gia, t, thue_vat);
                list.add(ctHD);
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
