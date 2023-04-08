/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.CT_HoaDonBan;
import entity.HoaDonBan;
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
 * @author NDT
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
                + "           ([soLuong]\n"
                + "           ,[maThuoc]\n"
                + "           ,[maHoaDonBan]\n"
                + "           ,[giaBan]\n"
                + "           ,[thueVAT])\n"
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

    public double giaTienTheoMaHD(String maHD) {
//        String gia = "";
        double gia=0;
        String sql = "select SUM(cthd.soLuong*cthd.giaBan*(1+cthd.thueVAT)) as 'TongTien',maHoaDonBan from CT_HoaDonBan cthd\n"
                + "group by cthd.maHoaDonBan\n"
                + "Having maHoaDonBan= ? ";
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
        ArrayList tmp = new ArrayList();
        String sql = "select cthd.*,t.tenThuoc, t.thueVAT as 'VATThuoc', t.giaBan,t.thanhPhan from CT_HoaDonBan cthd join Thuoc t on cthd.maThuoc=t.maThuoc where maHoaDonBan= ? ";
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maHD);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CT_HoaDonBan cthd = new CT_HoaDonBan();
//                String x = String.format("%,.0f", rs.getDouble("giaBan"));

                cthd.setGiaBan(rs.getDouble("giaBan"));
                cthd.setSoLuong(rs.getInt("soLuong"));
                cthd.setVat(rs.getFloat("VATThuoc"));
                Thuoc t = new Thuoc();
                t.setTenThuoc(rs.getString("tenThuoc"));
                t.setMaThuoc(rs.getString("maThuoc"));
                t.setThanhPhan(rs.getString("thanhPhan"));

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
        String sql = "select * from CT_HoaDonBan where maHoaDonBan = '" + maHD + "'";
        try {
            s = con.prepareStatement(sql);
            ResultSet r = s.executeQuery();
            // v.addElement("");
            while (r.next()) {
                int sl = r.getInt(1);
                String maThuoc = r.getString(2);
                double gia = r.getDouble(4);
                float vat = r.getFloat(5);

                DAO_Thuoc dao = new DAO_Thuoc();
                Thuoc t = dao.getThuocTheoMa(maThuoc);

                CT_HoaDonBan ctHD = new CT_HoaDonBan(sl, gia, t, vat);
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
