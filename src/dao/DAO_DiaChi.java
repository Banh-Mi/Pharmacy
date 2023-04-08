package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import connect.ConnectDB;
import entity.DiaChi;
import entity.KhachHang;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DAO_DiaChi {

    private Connection con;

    public DAO_DiaChi() {
        try {
            con = ConnectDB.getInstances().getConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public DiaChi timdiachi(String maDC) throws Exception {
        String sql = "SELECT [tinhTP],[quanHuyen],[phuongXa] FROM [dbo].[DiaChi] where maDC= ? ";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, maDC);

        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            // NhanVien nv= new NhanVien(rs.getString("maNhanVien"), rs.getString("tenNhanVien"), rs.getBoolean("gioiTinh"), rs.getString("soDienThoaiNV"), rs.getString("passLogin"), rs.getBoolean("trangThaiLamViec"), rs.getBoolean("loaiNV"),rs.getString("cmnd") ,null);

            DiaChi dc = new DiaChi(rs.getString("tinhTP"), rs.getString("quanHuyen"), rs.getString("phuongXa"));
            return dc;
        }
        return null;
    }

    public String timMaDC(String tp, String qh, String px) throws Exception {
        String sql = "SELECT [maDC] FROM [dbo].[DiaChi] where tinhTP=N'" + tp + "' and quanHuyen=N'" + qh + "' and phuongXa=N'" + px + "'";

        PreparedStatement stmt = con.prepareStatement(sql);
        // stmt.setString(1, tp);
        // stmt.setString(2, qh);
        // stmt.setString(3, px);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            String madiachi = rs.getString("maDC");
            return madiachi;
        }
        return null;
    }

    public ArrayList<String> getDSTinhTP() {
        ArrayList tmp = new ArrayList();
        tmp.add("Tỉnh/Thành Phố");
        String sql = "select distinct tinhTP from DiaChi order by tinhTP asc";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tmp.add(rs.getString("tinhTP"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_DiaChi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }

    public ArrayList<String> getDsQuanHuyen(String tenTinhTP) {
        ArrayList tmp = new ArrayList();
        tmp.add("Quận/Huyện");
        String sql = "select distinct quanHuyen from DiaChi where tinhTP=N'" + tenTinhTP + "' order by quanHuyen asc";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tmp.add(rs.getString("quanHuyen"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_DiaChi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }

    public ArrayList<String> getDsPhuongXa(String tenTinhTP, String tenQuanHuyen) {
        ArrayList tmp = new ArrayList();
        tmp.add("Phường/Xã");
        String sql = "select distinct phuongXa from DiaChi where tinhTP=N'" + tenTinhTP.trim() + "' and quanHuyen=N'" + tenQuanHuyen.trim() + "' order by phuongXa asc";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tmp.add(rs.getString("phuongXa"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_DiaChi.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }

    public DiaChi getDiaChiByMaDiaChi(String maDC) {
        DiaChi dc = new DiaChi();
        String sql = "Select * from DiaChi where maDC='" + maDC + "'";
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String maDiachi = rs.getString(1);
                String tinhTP = rs.getString(2);
                String quanHuyen = rs.getString(3);
                String phuongXa = rs.getString(4);
                dc = new DiaChi(maDiachi, tinhTP, quanHuyen, phuongXa);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dc;
    }

    public ArrayList<DiaChi> getListDiaChi() throws SQLException {
        ArrayList<DiaChi> dsDiaChi = new ArrayList<>();
        try {
            String sql = "SELECT * FROM DiaChi";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String maDC = rs.getString("maDC");
                String tinhTP = rs.getString("tinhTP");
                String quanHuyen = rs.getString("quanHuyen");
                String phuongXa = rs.getString("phuongXa");

                DiaChi diaChi = new DiaChi(maDC, tinhTP, quanHuyen, phuongXa);
                dsDiaChi.add(diaChi);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsDiaChi;
    }

    public Vector<String> getAllTinh() {
        Vector<String> v = new Vector<>();
        v.add("Tỉnh/Thành phố");
        String sql = "select tinhTP from DiaChi group by tinhTP";
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(sql);

            ResultSet r = statement.executeQuery();

            while (r.next()) {
                v.add(r.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return v;
    }

    public Vector<String> getAllHuyenTheoTinh(String tinh) {
        Vector<String> v = new Vector<>();
        v.add("Quận/Huyện");
        String sql = "select quanHuyen from DiaChi where tinhTP = N'" + tinh + "' group by quanHuyen";
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(sql);

            ResultSet r = statement.executeQuery();

            while (r.next()) {
                v.add(r.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return v;
    }

    public Vector<String> getAllPhuongXaTheoTinhVaHuyen(String tinh, String huyen) {
        Vector<String> v = new Vector<>();
        v.add("Phường/Xã");
        String sql = "select phuongXa from DiaChi where quanHuyen = N'" + huyen + "' and tinhTP = N'" + tinh + "' group by phuongXa";
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(sql);

            ResultSet r = statement.executeQuery();

            while (r.next()) {
                v.add(r.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return v;
    }

    public String getMaDCTheoTinhHuyenXa(String tinh, String huyen, String xa) {
        String ma = "";
        String sql = "select maDC from DiaChi where tinhTP = N'" + tinh + "' and quanHuyen = N'" + huyen + "' and phuongXa = N'" + xa + "'";
        PreparedStatement statement = null;
        try {
            statement = con.prepareStatement(sql);
            ResultSet r = statement.executeQuery();
            r.next();
            ma = r.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return ma;
    }
}
