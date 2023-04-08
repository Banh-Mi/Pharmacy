/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.CongDung;
import entity.Thuoc;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author NDT
 */
public class DAO_Thuoc {

    private Connection con;

    public DAO_Thuoc() {
        try {
            con = connect.ConnectDB.getInstances().getConnection();
        } catch (Exception ex) {

            ex.printStackTrace();
        }
    }

    public ArrayList<Thuoc> getDsThuoc() {

        ArrayList<Thuoc> tmp = new ArrayList<>();
        // String sql="select t.tenThuoc,t.thanhPhan,t.dangBaoChe,t.donViTinh,t.hamLuong,cd.nhomCongDung,t.hanSuDung,t.giaBan,t.soLuongBanDau from Thuoc t join CongDung cd on t.maCongDung=cd.maCongDung";
        String sql = "select * from Thuoc t join CongDung cd on t.maCongDung=cd.maCongDung where (YEAR(GETDATE())=YEAR(hanSuDung) and MONTH(GETDATE())<=MONTH(hanSuDung) and DAY(GETDATE())<=DAY(hanSuDung)) or (YEAR(GETDATE())<YEAR(hanSuDung)) and trangThaiKD=1";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                CongDung cd = new CongDung("", rs.getString("nhomCongDung"), "");
                Thuoc t = new Thuoc(rs.getString("tenThuoc"), rs.getDouble("giaBan"), rs.getString("donViTinh"), rs.getString("thanhPhan"), rs.getString("dangBaoChe"), rs.getString("hamLuong"), cd, rs.getInt("soLuongBanDau"), rs.getDate("hanSuDung"));
                t.setThueVAT(rs.getFloat("thueVAT"));
                t.setMaThuoc(rs.getString("maThuoc"));
                tmp.add(t);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAO_Thuoc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }

    public ArrayList<Thuoc> getAllThuoc() {
        ArrayList<Thuoc> listThuoc = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Thuoc ORDER BY maThuoc DESC";
            Statement statement;

            statement = con.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String ma = rs.getString("maThuoc");
                String ten = rs.getString("tenThuoc");
                double gia = rs.getDouble("giaBan");
                String dvt = rs.getNString("donViTinh");
                String thanhPhan = rs.getString("thanhPhan");
                String quyCachDongGoi = rs.getString("quyCachDongGoi");
                String dangBaoChe = rs.getString("dangBaoChe");
                String hamLuong = rs.getString("hamLuong");
                String cTySanXuat = rs.getString("cTySanXuat");
                String nuocSanXuat = rs.getString("nuocSanXuat");
                boolean trangThaiKD = rs.getBoolean("trangThaiKD");
                float vat = rs.getFloat("thueVAT");
                String soDK = rs.getString("soDK");
                String maCongDung = rs.getString("maCongDung");
                int soLuong = rs.getInt("soLuongBanDau");
                Date hanSuDung = rs.getDate("hanSuDung");

                DAO_CongDung dao_CD = new DAO_CongDung();
                CongDung congDung = dao_CD.getCongDungByMaCongDung(maCongDung);

                Thuoc t = new Thuoc(ma, ten, gia, dvt, thanhPhan, quyCachDongGoi, dangBaoChe, hamLuong,
                        cTySanXuat, nuocSanXuat, trangThaiKD, vat, soDK, congDung, soLuong, hanSuDung);

                listThuoc.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listThuoc;
    }

    public ArrayList<String> getDsDangBaoChe() {
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("All");
        String sql = "select distinct dangBaoChe from Thuoc";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tmp.add(rs.getString("dangBaoChe"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tmp;
    }

    public ArrayList<String> getDsDonViTinh() {
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("All");
        String sql = "select distinct donViTinh from Thuoc";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tmp.add(rs.getString("donViTinh"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
        return tmp;
    }

    public ArrayList<String> getDsNhomCongCung() {
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("All");
        String sql = "select distinct cd.nhomCongDung from Thuoc t join CongDung cd on t.maCongDung=cd.maCongDung";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tmp.add(rs.getString("nhomCongDung"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tmp;
    }

    public ArrayList<String> getDsCongCung() {
        ArrayList<String> tmp = new ArrayList<>();
        tmp.add("All");
        String sql = "select distinct cd.congDung from Thuoc t join CongDung cd on t.maCongDung=cd.maCongDung";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tmp.add(rs.getString("congDung"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tmp;
    }

    public ArrayList<Thuoc> timKiemThuoc(String tenthuoc, String hoatChat, String dangBC, String dvt, String nhomCongDung, String congDung) {
        ArrayList<Thuoc> tmp = new ArrayList<>();
        String sql = "select t.*,cd.* from Thuoc t join CongDung cd on t.maCongDung=cd.maCongDung where ";
        int lengthAnd = 0;
        // đúng la=1, sai la=0
        if (tenthuoc.trim().isEmpty() == false && lengthAnd > 0) {
            sql += " and tenThuoc=N'" + tenthuoc.trim() + "'";
            lengthAnd += 1;
        } else if (!tenthuoc.trim().isEmpty()) {
            sql += "tenThuoc=N'" + tenthuoc.trim() + "'";
            lengthAnd += 1;
        }

        // đúng la =2, sai la=0
        if (lengthAnd <= 1 && hoatChat.trim().isEmpty() == false && lengthAnd > 0) {
            sql += " and thanhPhan=N'" + hoatChat.trim() + "'";
            lengthAnd += 1;
        } else if (hoatChat.trim().isEmpty() == false) {
            sql += "thanhPhan=N'" + hoatChat.trim() + "'";
            lengthAnd += 1;
        }

        // đúng la =3, sai la = 0
        if (lengthAnd <= 2 && dangBC.equalsIgnoreCase("All") == false && lengthAnd > 0) {
            sql += " and dangBaoChe=N'" + dangBC.trim() + "'";
            lengthAnd += 1;
        } else if (dangBC.equalsIgnoreCase("All") == false) {
            sql += " dangBaoChe=N'" + dangBC.trim() + "'";
            lengthAnd += 1;
        }

        // đúng la=4, sai la=3
        if (lengthAnd <= 3 && lengthAnd > 0 && dvt.equalsIgnoreCase("All") == false) {
            sql += " and donViTinh=N'" + dvt.trim() + "'";
            lengthAnd += 1;
        } else if (dvt.equalsIgnoreCase("All") == false) {
            sql += " donViTinh=N'" + dvt.trim() + "'";
            lengthAnd += 1;
        }

        // đúng la=5, sai la=0
        if (lengthAnd <= 4 && lengthAnd > 0 && nhomCongDung.equalsIgnoreCase("All") == false) {
            sql += " and nhomCongDung=N'" + nhomCongDung.trim() + "'";
            lengthAnd += 1;
        } else if (nhomCongDung.equalsIgnoreCase("All") == false) {
            sql += " nhomCongDung=N'" + nhomCongDung.trim() + "'";
            lengthAnd += 1;
        }

        // đúng la=6, sai la=0
        if (lengthAnd <= 6 && lengthAnd > 0 && congDung.equalsIgnoreCase("All") == false) {
            sql += " and congDung=N'" + congDung.trim() + "'";
            lengthAnd += 1;
        } else if (congDung.equalsIgnoreCase("All") == false) {
            sql += " congDung=N'" + congDung.trim() + "'";
            lengthAnd += 1;
        }

        if (lengthAnd == 0) {
            sql = "select t.*,cd.* from Thuoc t join CongDung cd on t.maCongDung=cd.maCongDung";
        }

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CongDung cd = new CongDung("", rs.getString("nhomCongDung"), rs.getString("congDung"));
                Thuoc t = new Thuoc(rs.getString("tenThuoc"), rs.getDouble("giaBan"), rs.getString("donViTinh"), rs.getString("thanhPhan"), rs.getString("dangBaoChe"), rs.getString("hamLuong"), cd, rs.getInt("soLuongBanDau"), rs.getDate("hanSuDung"));
                t.setMaThuoc(rs.getString("maThuoc"));
                tmp.add(t);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tmp;
    }

    public ArrayList<Thuoc> timKiemThuocNangCao(Thuoc thuocTim) {
        ArrayList<Thuoc> tmp = new ArrayList<>();
        String sql = "select t.*,cd.* from Thuoc t join CongDung cd on t.maCongDung=cd.maCongDung where tenThuoc like ? and thanhPhan like ? ";

        // đúng la =3, sai la = 0
        if (thuocTim.getDangBaoChe().equalsIgnoreCase("All") == false) {
            sql += " and dangBaoChe=N'" + thuocTim.getDangBaoChe().trim() + "'";
        }

        // đúng la=4, sai la=3
        if (thuocTim.getDonViTinh().equalsIgnoreCase("All") == false) {
            sql += " and donViTinh=N'" + thuocTim.getDonViTinh().trim() + "'";
        }

        // đúng la=5, sai la=0
        if (thuocTim.getCongDung().getNhomCongDung().equalsIgnoreCase("All") == false) {
            sql += " and nhomCongDung=N'" + thuocTim.getCongDung().getNhomCongDung().trim() + "'";
        }

        // đúng la=6, sai la=0
        if (thuocTim.getCongDung().getCongDung().equalsIgnoreCase("All") == false) {
            sql += " and congDung=N'" + thuocTim.getCongDung().getCongDung().trim() + "'";
        }
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + thuocTim.getTenThuoc() + "%");
            stmt.setString(2, "%" + thuocTim.getThanhPhan() + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CongDung cd = new CongDung("", rs.getString("nhomCongDung"), rs.getString("congDung"));
                Thuoc t = new Thuoc(rs.getString("tenThuoc"), rs.getDouble("giaBan"), rs.getString("donViTinh"), rs.getString("thanhPhan"), rs.getString("dangBaoChe"), rs.getString("hamLuong"), cd, rs.getInt("soLuongBanDau"), rs.getDate("hanSuDung"));
                t.setMaThuoc(rs.getString("maThuoc"));
                tmp.add(t);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tmp;
    }

    public ArrayList<Thuoc> timKiemThuoc2(String maThuoc, String tenThuoc, String giaBan, String donViTinh,
            String thanhPhan, String quyCachDongGoi, String dangBaoChe, String hamLuong,
            String cTySanXuat, String nuocSanXuat, String trangThaiKD, String thueVAT,
            String soDK, CongDung congDung, String soLuongBanDau, Date hanSuDung) {

        ArrayList<Thuoc> tmp = new ArrayList<>();
        String sql = "select t.*,cd.* from Thuoc t join CongDung cd on t.maCongDung=cd.maCongDung where ";
        int lengthAnd = 0;
        // đúng la=1, sai la=0
        if (tenThuoc.trim().isEmpty() == false && lengthAnd > 0) {
            sql += " and tenThuoc=N'" + tenThuoc.trim() + "'";
            lengthAnd += 1;
        } else if (!tenThuoc.trim().isEmpty()) {
            sql += "tenThuoc=N'" + tenThuoc.trim() + "'";
            lengthAnd += 1;
        }

        // đúng la =2, sai la=0
        if (lengthAnd <= 1 && thanhPhan.trim().isEmpty() == false && lengthAnd > 0) {
            System.out.println(thanhPhan);
            sql += " and thanhPhan=N'" + thanhPhan.trim() + "'";
            lengthAnd += 1;
        } else if (thanhPhan.trim().isEmpty() == false) {
            System.out.println(thanhPhan);
            sql += "thanhPhan=N'" + thanhPhan.trim() + "'";
            lengthAnd += 1;
        }

        // đúng la =3, sai la = 0
        if (lengthAnd <= 2 && !dangBaoChe.isEmpty() && lengthAnd > 0) {
            System.out.println(dangBaoChe);
            sql += " and dangBaoChe=N'" + dangBaoChe.trim() + "'";
            lengthAnd += 1;
        } else if (!dangBaoChe.isEmpty()) {
            System.out.println(dangBaoChe);
            sql += " dangBaoChe=N'" + dangBaoChe.trim() + "'";
            lengthAnd += 1;
        }

        // đúng la=4, sai la=3
        if (lengthAnd <= 3 && lengthAnd > 0 && !donViTinh.isEmpty()) {
            System.out.println(donViTinh);

            sql += " and donViTinh=N'" + donViTinh.trim() + "'";
            lengthAnd += 1;
        } else if (!donViTinh.isEmpty()) {
            System.out.println(donViTinh);
            sql += " donViTinh=N'" + donViTinh.trim() + "'";
            lengthAnd += 1;
        }

        // đúng la=5, sai la=0
        if (lengthAnd <= 4 && lengthAnd > 0 && congDung.getNhomCongDung().equalsIgnoreCase("Nhóm Công Dụng") == false) {
            System.out.println(congDung.getNhomCongDung());
            sql += " and nhomCongDung=N'" + congDung.getNhomCongDung().trim() + "'";
            lengthAnd += 1;
        } else if (congDung.getNhomCongDung().equalsIgnoreCase("Nhóm Công Dụng") == false) {
            System.out.println(congDung.getNhomCongDung());
            sql += " nhomCongDung=N'" + congDung.getNhomCongDung().trim() + "'";
            lengthAnd += 1;
        }

        // đúng la=6, sai la=0
        if (lengthAnd <= 6 && lengthAnd > 0 && congDung.getCongDung().equalsIgnoreCase("Công Dụng") == false) {
            System.out.println(congDung.getCongDung());
            sql += " and congDung=N'" + congDung.getCongDung().trim() + "'";
            lengthAnd += 1;
        } else if (congDung.getCongDung().equalsIgnoreCase("Công Dụng") == false) {
            System.out.println(congDung.getCongDung());
            sql += " congDung=N'" + congDung.getCongDung().trim() + "'";
            lengthAnd += 1;
        }

        if (lengthAnd <= 7 && lengthAnd > 0 && !quyCachDongGoi.isEmpty()) {
            System.out.println(quyCachDongGoi);
            sql += " and quyCachDongGoi=N'" + quyCachDongGoi.trim() + "'";
            lengthAnd += 1;
        } else if (!quyCachDongGoi.isEmpty()) {
            System.out.println(quyCachDongGoi);
            sql += " quyCachDongGoi=N'" + quyCachDongGoi.trim() + "'";
            lengthAnd += 1;
        }

        if (lengthAnd <= 8 && lengthAnd > 0 && !hamLuong.isEmpty()) {
            sql += " and hamLuong=N'" + hamLuong.trim() + "'";
            lengthAnd += 1;
        } else if (!hamLuong.isEmpty()) {
            sql += " hamLuong=N'" + hamLuong.trim() + "'";
            lengthAnd += 1;
        }

        if (lengthAnd <= 9 && lengthAnd > 0 && !cTySanXuat.isEmpty()) {
            sql += " and cTySanXuat=N'" + cTySanXuat.trim() + "'";
            lengthAnd += 1;
        } else if (!cTySanXuat.isEmpty()) {
            sql += " cTySanXuat=N'" + cTySanXuat.trim() + "'";
            lengthAnd += 1;
        }
        if (lengthAnd <= 10 && lengthAnd > 0 && !nuocSanXuat.isEmpty()) {
            System.out.println(nuocSanXuat);
            sql += " and nuocSanXuat=N'" + nuocSanXuat.trim() + "'";
            lengthAnd += 1;
        } else if (!nuocSanXuat.isEmpty()) {
            System.out.println(nuocSanXuat);
            sql += " nuocSanXuat=N'" + nuocSanXuat.trim() + "'";
            lengthAnd += 1;
        }

        if (lengthAnd <= 11 && lengthAnd > 0 && trangThaiKD.equalsIgnoreCase("All") == false) {
            int tf_ttkd = (trangThaiKD == "Đang Kinh Doanh" ? 1 : 0);
            sql += " and trangThaiKD= " + tf_ttkd;
            lengthAnd += 1;
        } else if (trangThaiKD.equalsIgnoreCase("All") == false) {
            int tf_ttkd = (trangThaiKD == "Đang Kinh Doanh" ? 1 : 0);
            sql += " trangThaiKD= " + tf_ttkd;
            lengthAnd += 1;
        }

        if (lengthAnd <= 12 && !maThuoc.isEmpty() && lengthAnd > 0) {
            sql += " and maThuoc=N'" + maThuoc.trim() + "'";
            lengthAnd += 1;
        } else if (!maThuoc.isEmpty()) {
            sql += " maThuoc=N'" + maThuoc.trim() + "'";
            lengthAnd += 1;
        }

        if (lengthAnd <= 13 && !soDK.isEmpty() && lengthAnd > 0) {
            sql += " and soDK=N'" + soDK.trim() + "'";
            lengthAnd += 1;
        } else if (!soDK.isEmpty()) {
            sql += " soDK=N'" + soDK.trim() + "'";
            lengthAnd += 1;
        }

        if (lengthAnd == 0) {
            sql = "select t.*,cd.* from Thuoc t join CongDung cd on t.maCongDung=cd.maCongDung";
        }

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CongDung cd = new CongDung(rs.getString("maCongDung"), rs.getString("nhomCongDung"), rs.getString("congDung"));
                Thuoc t = new Thuoc(rs.getString("tenThuoc"), rs.getDouble("giaBan"), rs.getString("donViTinh"), rs.getString("thanhPhan"), rs.getString("dangBaoChe"), rs.getString("hamLuong"), cd, rs.getInt("soLuongBanDau"), rs.getDate("hanSuDung"));
                t.setMaThuoc(rs.getString("maThuoc"));
                t.setQuyCachDongGoi(rs.getString("quyCachDongGoi"));
                t.setcTySanXuat(rs.getString("cTySanXuat"));
                t.setThueVAT(rs.getFloat("thueVAT"));
                t.setSoDK(rs.getString("soDK"));
                t.setNuocSanXuat(rs.getString("nuocSanXuat"));
                t.setTrangThaiKD(rs.getBoolean("trangThaiKD"));
                tmp.add(t);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tmp;
    }

    public Thuoc getThuocTheoMa(String mathuoc) {
        String sql = "select * from Thuoc t join CongDung cd on t.maCongDung=cd.maCongDung where t.maThuoc= ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, mathuoc);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                CongDung cd = new CongDung(rs.getString("maCongDung"), rs.getString("nhomCongDung"), rs.getString("congDung"));
                Thuoc x = new Thuoc(rs.getString("maThuoc"), rs.getString("tenThuoc"), rs.getDouble("giaBan"), rs.getString("donViTinh"), rs.getString("thanhPhan"), rs.getString("quyCachDongGoi"), rs.getString("dangBaoChe"), rs.getString("hamLuong"), rs.getString("cTySanXuat"), rs.getBoolean("trangThaiKD"), rs.getFloat("thueVAT"), rs.getString("soDK"), cd, rs.getInt("soLuongBanDau"), rs.getDate("hanSuDung"));
                x.setNuocSanXuat(rs.getString("nuocSanXuat"));
                return x;

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Thuoc.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Thuoc timThuocTheoMa(String mathuoc) {
        String sql = "select * from Thuoc t where t.maThuoc= ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, mathuoc);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Thuoc x = new Thuoc();
                x.setMaThuoc(rs.getString("maThuoc"));
                return x;

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Thuoc.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Thuoc> timKiemThuoc3(String maThuoc, String tenThuoc, String giaBan, String donViTinh,
            String thanhPhan, String quyCachDongGoi, String dangBaoChe, String hamLuong,
            String cTySanXuat, String nuocSanXuat, String trangThaiKD, String thueVAT,
            String soDK, CongDung congDung, String soLuongBanDau, Date hanSuDung) {

        ArrayList<Thuoc> tmp = new ArrayList<>();
        String sql = "select t.*,cd.* from Thuoc t join CongDung cd on t.maCongDung=cd.maCongDung where maThuoc like ? and tenThuoc like ? and donViTinh like ? and thanhPhan like ? and quyCachDongGoi like ? and dangBaoChe like ? and hamLuong like ? and cTySanXuat like ? and nuocSanXuat like ? and soDK like ?";

        if (trangThaiKD.equalsIgnoreCase("All") == false) {
            int tf_ttkd = (trangThaiKD == "Đang Kinh Doanh" ? 1 : 0);
            sql += " and trangThaiKD= " + tf_ttkd;
        }
        //11
        boolean tfhsd = false;
        if (hanSuDung != null) {
//            System.out.println("dao.DAO_Thuoc.timKiemThuoc3()");
            sql += " and hanSuDung= ? ";
            tfhsd = true;
        }

        boolean tfgiaBan = false;
        System.out.println("gia vao" + giaBan);
        if (!giaBan.isEmpty()) {
            sql += " and giaBan = ? ";
            tfgiaBan = true;
        }
        boolean tfvat = false;
        if (!thueVAT.isEmpty()) {
            sql += " and thueVAT = ? ";
            tfvat = true;
        }
        boolean tfsl = false;
        System.out.println("soluong" + soLuongBanDau);
        if (!soLuongBanDau.isEmpty()) {
            System.out.println("soluong");

            sql += " and soLuongBanDau = ? ";
            tfsl = true;
        }

        if (congDung.getNhomCongDung().equalsIgnoreCase("Nhóm Công Dụng") == false) {
            sql += " and nhomCongDung=N'" + congDung.getNhomCongDung().trim() + "'";
        }

        if (congDung.getCongDung().equalsIgnoreCase("Công Dụng") == false) {
            sql += " and congDung=N'" + congDung.getCongDung().trim() + "'";
        }
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + maThuoc + "%");
            stmt.setString(2, "%" + tenThuoc + "%");
            stmt.setString(3, "%" + donViTinh + "%");
            stmt.setString(4, "%" + thanhPhan + "%");
            stmt.setString(5, "%" + quyCachDongGoi + "%");
            stmt.setString(6, "%" + dangBaoChe + "%");
            stmt.setString(7, "%" + hamLuong + "%");
            stmt.setString(8, "%" + cTySanXuat + "%");
            stmt.setString(9, "%" + nuocSanXuat + "%");
            stmt.setString(10, "%" + soDK + "%");

            if (tfhsd) {
                stmt.setDate(11, hanSuDung);
            }

            if (tfgiaBan) {
                System.out.println("gia");
                stmt.setDouble(12, Double.parseDouble(giaBan));
            }
            if (tfvat) {
                stmt.setFloat(13, Float.parseFloat(thueVAT));
            }

            if (tfsl) {
                stmt.setLong(14, Long.parseLong(soLuongBanDau));
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CongDung cd = new CongDung(rs.getString("maCongDung"), rs.getString("nhomCongDung"), rs.getString("congDung"));
                Thuoc t = new Thuoc(rs.getString("tenThuoc"), rs.getDouble("giaBan"), rs.getString("donViTinh"), rs.getString("thanhPhan"), rs.getString("dangBaoChe"), rs.getString("hamLuong"), cd, rs.getInt("soLuongBanDau"), rs.getDate("hanSuDung"));
                t.setMaThuoc(rs.getString("maThuoc"));
                t.setQuyCachDongGoi(rs.getString("quyCachDongGoi"));
                t.setcTySanXuat(rs.getString("cTySanXuat"));
                t.setThueVAT(rs.getFloat("thueVAT"));
                t.setSoDK(rs.getString("soDK"));
                t.setNuocSanXuat(rs.getString("nuocSanXuat"));
                t.setTrangThaiKD(rs.getBoolean("trangThaiKD"));
                System.out.println(t);
                tmp.add(t);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
        }
        return tmp;
    }

    public boolean addThuoc(Thuoc t) {
        PreparedStatement pre = null;
        try {
            if (timThuocTheoMa(t.getMaThuoc()) != null) {
                return false;
            }
            String sql = "Insert into Thuoc Values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pre = con.prepareStatement(sql);
            pre.setString(1, t.getMaThuoc());
            pre.setString(2, t.getTenThuoc());
            pre.setDouble(3, t.getGiaBan());
            pre.setString(4, t.getDonViTinh());
            pre.setString(5, t.getThanhPhan());
            pre.setString(6, t.getQuyCachDongGoi());
            pre.setString(7, t.getDangBaoChe());
            pre.setString(8, t.getHamLuong());
            pre.setString(9, t.getcTySanXuat());
            pre.setString(10, t.getNuocSanXuat());
            pre.setBoolean(11, t.isTrangThaiKD());
            pre.setFloat(12, t.getThueVAT());
            pre.setString(13, t.getSoDK());
            pre.setString(14, t.getCongDung().getMaCongDung());
            pre.setLong(15, t.getSoLuongBanDau());
            pre.setDate(16, t.getHanSuDung());
            pre.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateThuoc(Thuoc t, String maThuoc) throws SQLException {
        PreparedStatement pre = null;
        int count = 0;
        try {
            Statement stmTimT = con.createStatement();
            ResultSet amountT = stmTimT.executeQuery("Select Count(maThuoc) As total from Thuoc Where maThuoc = '" + maThuoc + "' ");
            while (amountT.next()) {
                count = amountT.getInt("total");
            }
            System.out.println(count);
            if (count != 0) {
                String sql = "update Thuoc set tenThuoc=?,giaBan=?,donViTinh=?,thanhPhan=?,quyCachDongGoi=?,dangBaoChe=?,hamLuong=?,cTySanXuat=?, nuocSanXuat=?,trangThaiKD=?, thueVAT=?, soDK=?, maCongDung=?, soLuongBanDau=?, hanSuDung=? WHERE maThuoc=?";
                pre = con.prepareStatement(sql);
                pre.setString(1, t.getTenThuoc());
                pre.setDouble(2, t.getGiaBan());
                pre.setString(3, t.getDonViTinh());
                pre.setString(4, t.getThanhPhan());
                pre.setString(5, t.getQuyCachDongGoi());
                pre.setString(6, t.getDangBaoChe());
                pre.setString(7, t.getHamLuong());
                pre.setString(8, t.getcTySanXuat());
                pre.setString(9, t.getNuocSanXuat());
                pre.setBoolean(10, t.isTrangThaiKD());
                pre.setFloat(11, t.getThueVAT());
                pre.setString(12, t.getSoDK());
                pre.setString(13, t.getCongDung().getMaCongDung());
                pre.setLong(14, t.getSoLuongBanDau());
                pre.setDate(15, t.getHanSuDung());
                pre.setString(16, t.getMaThuoc());
                pre.executeUpdate();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean ngungBanThuoc(String maThuoc) throws SQLException {
        PreparedStatement pre = null;
        int count = 0;
        try {
            Statement stmTimT = con.createStatement();
            ResultSet amountT = stmTimT.executeQuery("Select Count(maThuoc) As total from Thuoc Where maThuoc = '" + maThuoc + "' ");
            while (amountT.next()) {
                count = amountT.getInt("total");
            }
            if (count != 0) {
                String sql = "update Thuoc set trangThaiKD=? WHERE maThuoc=?";
                pre = con.prepareStatement(sql);
                pre.setString(1, "false");
                pre.setString(2, maThuoc);
                pre.executeUpdate();
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean deleteThuoc(String maThuoc) {
        PreparedStatement statement = null;
        try {
            String sql = "Delete From Thuoc Where maThuoc = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, maThuoc);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String TaoSoNgauNhien() {
        String strMaHD = null;

        PreparedStatement s = null;
        String sql = "select top 1 maThuoc from Thuoc order by maThuoc desc";
        try {
            s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                strMaHD = rs.getString(1);
            }
            System.out.println("strMaHD:" + strMaHD);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tạo mã Nhân viên");
            return "";
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        String str = strMaHD.substring(4, 6);
        strMaHD = strMaHD.substring(6);
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
        System.out.println(longMaHD);
        System.out.println(str);
        strMaHD = longMaHD == 0 ? String.valueOf(1000001 + longMaHD) : String.valueOf(1000000 + longMaHD);
        System.err.println(strMaHD);
        strMaHD = "DPAA" + str + strMaHD.substring(3);
        return strMaHD;
    }

    public boolean capNhatSoLuong(Thuoc thuocMua) {
        String sql = "select * from Thuoc where maThuoc= ?";
        String sqlCapNhatThuoc = "UPDATE [dbo].[Thuoc]\n"
                + "   SET [soLuongBanDau] = ? \n"
                + " WHERE maThuoc= ? ";
        int soThuocConlai = 0;
        int n = -1;
        try {
            PreparedStatement stmt1 = con.prepareStatement(sql);
            PreparedStatement stmt2 = con.prepareStatement(sqlCapNhatThuoc);
            stmt1.setString(1, thuocMua.getMaThuoc());
            ResultSet rs = stmt1.executeQuery();
            if (rs.next()) {
                soThuocConlai = (int) rs.getLong("soLuongBanDau") - (int) thuocMua.getSoLuongBanDau();
            }
            stmt2.setLong(1, soThuocConlai);
            stmt2.setString(2, thuocMua.getMaThuoc());
            n = stmt2.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(DAO_CT_HoaDonBan.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }

    public ArrayList<Thuoc> getThuocHetHan() {
        ArrayList<Thuoc> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Thuoc WHERE DATEDIFF(day, GETDATE(), hanSuDung ) BETWEEN 1 AND 60  ORDER BY hanSuDung ";
            Statement statement;

            statement = con.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String ma = rs.getString("maThuoc");
                String ten = rs.getString("tenThuoc");
                double gia = rs.getDouble("giaBan");
                String dvt = rs.getNString("donViTinh");
                String thanhPhan = rs.getString("thanhPhan");
                String quyCachDongGoi = rs.getString("quyCachDongGoi");
                String dangBaoChe = rs.getString("dangBaoChe");
                String hamLuong = rs.getString("hamLuong");
                String cTySanXuat = rs.getString("cTySanXuat");
                String nuocSanXuat = rs.getString("nuocSanXuat");
                boolean trangThaiKD = rs.getBoolean("trangThaiKD");
                float vat = rs.getFloat("thueVAT");
                String soDK = rs.getString("soDK");
                String maCongDung = rs.getString("maCongDung");
                int soLuong = rs.getInt("soLuongBanDau");
                Date hanSuDung = rs.getDate("hanSuDung");

                DAO_CongDung dao_CD = new DAO_CongDung();
                CongDung congDung = dao_CD.getCongDungByMaCongDung(maCongDung);

                Thuoc T = new Thuoc(ma, ten, gia, dvt, thanhPhan, quyCachDongGoi, dangBaoChe, hamLuong, cTySanXuat,
                        nuocSanXuat, trangThaiKD, vat, soDK, congDung, soLuong, hanSuDung);

                list.add(T);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public ArrayList<Thuoc> getThuocDaHetHan() {
        ArrayList<Thuoc> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Thuoc WHERE hanSuDung <= CURRENT_TIMESTAMP";
            Statement statement;

            statement = con.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String ma = rs.getString("maThuoc");
                String ten = rs.getString("tenThuoc");
                double gia = rs.getDouble("giaBan");
                String dvt = rs.getNString("donViTinh");
                String thanhPhan = rs.getString("thanhPhan");
                String quyCachDongGoi = rs.getString("quyCachDongGoi");
                String dangBaoChe = rs.getString("dangBaoChe");
                String hamLuong = rs.getString("hamLuong");
                String cTySanXuat = rs.getString("cTySanXuat");
                String nuocSanXuat = rs.getString("nuocSanXuat");
                boolean trangThaiKD = rs.getBoolean("trangThaiKD");
                float vat = rs.getFloat("thueVAT");
                String soDK = rs.getString("soDK");
                String maCongDung = rs.getString("maCongDung");
                int soLuong = rs.getInt("soLuongBanDau");
                Date hanSuDung = rs.getDate("hanSuDung");

                DAO_CongDung dao_CD = new DAO_CongDung();
                CongDung congDung = dao_CD.getCongDungByMaCongDung(maCongDung);

                Thuoc T = new Thuoc(ma, ten, gia, dvt, thanhPhan, quyCachDongGoi, dangBaoChe, hamLuong, cTySanXuat,
                        nuocSanXuat, trangThaiKD, vat, soDK, congDung, soLuong, hanSuDung);

                list.add(T);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
