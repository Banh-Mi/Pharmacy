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
        // String sql="select t.ten_thuoc,t.thanh_phan,t.dang_bao_che,t.don_vi_tinh,t.ham_luong,cd.nhom_cong_dung,t.han_su_dung,t.gia_ban,t.so_luong_ban_dau from Thuoc t join CongDung cd on t.ma_cong_dung=cd.ma_cong_dung";
        String sql = "select * from Thuoc t join CongDung cd on t.ma_cong_dung=cd.ma_cong_dung where (YEAR(GETDATE())=YEAR(han_su_dung) and MONTH(GETDATE())<=MONTH(han_su_dung) and DAY(GETDATE())<=DAY(han_su_dung)) or (YEAR(GETDATE())<YEAR(han_su_dung)) and trang_thai_kd=1";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                CongDung cd = new CongDung("", rs.getString("nhom_cong_dung"), "");
                Thuoc t = new Thuoc(rs.getString("ten_thuoc"), rs.getDouble("gia_ban"), rs.getString("don_vi_tinh"), rs.getString("thanh_phan"), rs.getString("dang_bao_che"), rs.getString("ham_luong"), cd, rs.getInt("so_luong_ban_dau"), rs.getDate("han_su_dung"));
                t.setThueVAT(rs.getFloat("thue_vat"));
                t.setMaThuoc(rs.getString("ma_thuoc"));
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
            String sql = "SELECT * FROM Thuoc ORDER BY ma_thuoc DESC";
            Statement statement;

            statement = con.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String ma = rs.getString("ma_thuoc");
                String ten = rs.getString("ten_thuoc");
                double gia = rs.getDouble("gia_ban");
                String dvt = rs.getString("don_vi_tinh");
                String thanh_phan = rs.getString("thanh_phan");
                String quy_cach_dong_goi = rs.getString("quy_cach_dong_goi");
                String dang_bao_che = rs.getString("dang_bao_che");
                String ham_luong = rs.getString("ham_luong");
                String cty_san_xuat = rs.getString("cty_san_xuat");
                String nuoc_san_xuat = rs.getString("nuoc_san_xuat");
                boolean trang_thai_kd = rs.getBoolean("trang_thai_kd");
                float vat = rs.getFloat("thue_vat");
                String so_dk = rs.getString("so_dk");
                String ma_cong_dung = rs.getString("ma_cong_dung");
                int soLuong = rs.getInt("so_luong_ban_dau");
                Date han_su_dung = rs.getDate("han_su_dung");

                DAO_CongDung dao_CD = new DAO_CongDung();
                CongDung cong_dung = dao_CD.getCongDungByMaCongDung(ma_cong_dung);

                Thuoc t = new Thuoc(ma, ten, gia, dvt, thanh_phan, quy_cach_dong_goi, dang_bao_che, ham_luong,
                        cty_san_xuat, nuoc_san_xuat, trang_thai_kd, vat, so_dk, cong_dung, soLuong, han_su_dung);

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
        String sql = "select distinct dang_bao_che from Thuoc";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tmp.add(rs.getString("dang_bao_che"));
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
        String sql = "select distinct don_vi_tinh from Thuoc";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tmp.add(rs.getString("don_vi_tinh"));
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
        String sql = "select distinct cd.nhom_cong_dung from Thuoc t join CongDung cd on t.ma_cong_dung=cd.ma_cong_dung";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tmp.add(rs.getString("nhom_cong_dung"));
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
        String sql = "select distinct cd.cong_dung from Thuoc t join CongDung cd on t.ma_cong_dung=cd.ma_cong_dung";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                tmp.add(rs.getString("cong_dung"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tmp;
    }

    public ArrayList<Thuoc> timKiemThuoc(String tenthuoc, String hoatChat, String dangBC, String dvt, String nhom_cong_dung, String cong_dung) {
        ArrayList<Thuoc> tmp = new ArrayList<>();
        String sql = "select t.*,cd.* from Thuoc t join CongDung cd on t.ma_cong_dung=cd.ma_cong_dung where ";
        int lengthAnd = 0;
        // đúng la=1, sai la=0
        if (tenthuoc.trim().isEmpty() == false && lengthAnd > 0) {
            sql += " and ten_thuoc=N'" + tenthuoc.trim() + "'";
            lengthAnd += 1;
        } else if (!tenthuoc.trim().isEmpty()) {
            sql += "ten_thuoc=N'" + tenthuoc.trim() + "'";
            lengthAnd += 1;
        }

        // đúng la =2, sai la=0
        if (lengthAnd <= 1 && hoatChat.trim().isEmpty() == false && lengthAnd > 0) {
            sql += " and thanh_phan=N'" + hoatChat.trim() + "'";
            lengthAnd += 1;
        } else if (hoatChat.trim().isEmpty() == false) {
            sql += "thanh_phan=N'" + hoatChat.trim() + "'";
            lengthAnd += 1;
        }

        // đúng la =3, sai la = 0
        if (lengthAnd <= 2 && dangBC.equalsIgnoreCase("All") == false && lengthAnd > 0) {
            sql += " and dang_bao_che=N'" + dangBC.trim() + "'";
            lengthAnd += 1;
        } else if (dangBC.equalsIgnoreCase("All") == false) {
            sql += " dang_bao_che=N'" + dangBC.trim() + "'";
            lengthAnd += 1;
        }

        // đúng la=4, sai la=3
        if (lengthAnd <= 3 && lengthAnd > 0 && dvt.equalsIgnoreCase("All") == false) {
            sql += " and don_vi_tinh=N'" + dvt.trim() + "'";
            lengthAnd += 1;
        } else if (dvt.equalsIgnoreCase("All") == false) {
            sql += " don_vi_tinh=N'" + dvt.trim() + "'";
            lengthAnd += 1;
        }

        // đúng la=5, sai la=0
        if (lengthAnd <= 4 && lengthAnd > 0 && nhom_cong_dung.equalsIgnoreCase("All") == false) {
            sql += " and nhom_cong_dung=N'" + nhom_cong_dung.trim() + "'";
            lengthAnd += 1;
        } else if (nhom_cong_dung.equalsIgnoreCase("All") == false) {
            sql += " nhom_cong_dung=N'" + nhom_cong_dung.trim() + "'";
            lengthAnd += 1;
        }

        // đúng la=6, sai la=0
        if (lengthAnd <= 6 && lengthAnd > 0 && cong_dung.equalsIgnoreCase("All") == false) {
            sql += " and cong_dung=N'" + cong_dung.trim() + "'";
            lengthAnd += 1;
        } else if (cong_dung.equalsIgnoreCase("All") == false) {
            sql += " cong_dung=N'" + cong_dung.trim() + "'";
            lengthAnd += 1;
        }

        if (lengthAnd == 0) {
            sql = "select t.*,cd.* from Thuoc t join CongDung cd on t.ma_cong_dung=cd.ma_cong_dung";
        }

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CongDung cd = new CongDung("", rs.getString("nhom_cong_dung"), rs.getString("cong_dung"));
                Thuoc t = new Thuoc(rs.getString("ten_thuoc"), rs.getDouble("gia_ban"), rs.getString("don_vi_tinh"), rs.getString("thanh_phan"), rs.getString("dang_bao_che"), rs.getString("ham_luong"), cd, rs.getInt("so_luong_ban_dau"), rs.getDate("han_su_dung"));
                t.setMaThuoc(rs.getString("ma_thuoc"));
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
        String sql = "select t.*,cd.* from Thuoc t join CongDung cd on t.ma_cong_dung=cd.ma_cong_dung where ten_thuoc like ? and thanh_phan like ? ";

        // đúng la =3, sai la = 0
        if (thuocTim.getDangBaoChe().equalsIgnoreCase("All") == false) {
            sql += " and dang_bao_che=N'" + thuocTim.getDangBaoChe().trim() + "'";
        }

        // đúng la=4, sai la=3
        if (thuocTim.getDonViTinh().equalsIgnoreCase("All") == false) {
            sql += " and don_vi_tinh=N'" + thuocTim.getDonViTinh().trim() + "'";
        }

        // đúng la=5, sai la=0
        if (thuocTim.getCongDung().getNhomCongDung().equalsIgnoreCase("All") == false) {
            sql += " and nhom_cong_dung=N'" + thuocTim.getCongDung().getNhomCongDung().trim() + "'";
        }

        // đúng la=6, sai la=0
        if (thuocTim.getCongDung().getCongDung().equalsIgnoreCase("All") == false) {
            sql += " and cong_dung=N'" + thuocTim.getCongDung().getCongDung().trim() + "'";
        }
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + thuocTim.getTenThuoc() + "%");
            stmt.setString(2, "%" + thuocTim.getThanhPhan() + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CongDung cd = new CongDung("", rs.getString("nhom_cong_dung"), rs.getString("cong_dung"));
                Thuoc t = new Thuoc(rs.getString("ten_thuoc"), rs.getDouble("gia_ban"), rs.getString("don_vi_tinh"), rs.getString("thanh_phan"), rs.getString("dang_bao_che"), rs.getString("ham_luong"), cd, rs.getInt("so_luong_ban_dau"), rs.getDate("han_su_dung"));
                t.setMaThuoc(rs.getString("ma_thuoc"));
                tmp.add(t);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tmp;
    }

    public ArrayList<Thuoc> timKiemThuoc2(String ma_thuoc, String ten_thuoc, String gia_ban, String don_vi_tinh,
            String thanh_phan, String quy_cach_dong_goi, String dang_bao_che, String ham_luong,
            String cty_san_xuat, String nuoc_san_xuat, String trang_thai_kd, String thue_vat,
            String so_dk, CongDung cong_dung, String so_luong_ban_dau, Date han_su_dung) {

        ArrayList<Thuoc> tmp = new ArrayList<>();
        String sql = "select t.*,cd.* from Thuoc t join CongDung cd on t.ma_cong_dung=cd.ma_cong_dung where ";
        int lengthAnd = 0;
        // đúng la=1, sai la=0
        if (ten_thuoc.trim().isEmpty() == false && lengthAnd > 0) {
            sql += " and ten_thuoc=N'" + ten_thuoc.trim() + "'";
            lengthAnd += 1;
        } else if (!ten_thuoc.trim().isEmpty()) {
            sql += "ten_thuoc=N'" + ten_thuoc.trim() + "'";
            lengthAnd += 1;
        }

        // đúng la =2, sai la=0
        if (lengthAnd <= 1 && thanh_phan.trim().isEmpty() == false && lengthAnd > 0) {
            System.out.println(thanh_phan);
            sql += " and thanh_phan=N'" + thanh_phan.trim() + "'";
            lengthAnd += 1;
        } else if (thanh_phan.trim().isEmpty() == false) {
            System.out.println(thanh_phan);
            sql += "thanh_phan=N'" + thanh_phan.trim() + "'";
            lengthAnd += 1;
        }

        // đúng la =3, sai la = 0
        if (lengthAnd <= 2 && !dang_bao_che.isEmpty() && lengthAnd > 0) {
            System.out.println(dang_bao_che);
            sql += " and dang_bao_che=N'" + dang_bao_che.trim() + "'";
            lengthAnd += 1;
        } else if (!dang_bao_che.isEmpty()) {
            System.out.println(dang_bao_che);
            sql += " dang_bao_che=N'" + dang_bao_che.trim() + "'";
            lengthAnd += 1;
        }

        // đúng la=4, sai la=3
        if (lengthAnd <= 3 && lengthAnd > 0 && !don_vi_tinh.isEmpty()) {
            System.out.println(don_vi_tinh);

            sql += " and don_vi_tinh=N'" + don_vi_tinh.trim() + "'";
            lengthAnd += 1;
        } else if (!don_vi_tinh.isEmpty()) {
            System.out.println(don_vi_tinh);
            sql += " don_vi_tinh=N'" + don_vi_tinh.trim() + "'";
            lengthAnd += 1;
        }

        // đúng la=5, sai la=0
        if (lengthAnd <= 4 && lengthAnd > 0 && cong_dung.getNhomCongDung().equalsIgnoreCase("Nhóm Công Dụng") == false) {
            System.out.println(cong_dung.getNhomCongDung());
            sql += " and nhom_cong_dung=N'" + cong_dung.getNhomCongDung().trim() + "'";
            lengthAnd += 1;
        } else if (cong_dung.getNhomCongDung().equalsIgnoreCase("Nhóm Công Dụng") == false) {
            System.out.println(cong_dung.getNhomCongDung());
            sql += " nhom_cong_dung=N'" + cong_dung.getNhomCongDung().trim() + "'";
            lengthAnd += 1;
        }

        // đúng la=6, sai la=0
        if (lengthAnd <= 6 && lengthAnd > 0 && cong_dung.getCongDung().equalsIgnoreCase("Công Dụng") == false) {
            System.out.println(cong_dung.getCongDung());
            sql += " and cong_dung=N'" + cong_dung.getCongDung().trim() + "'";
            lengthAnd += 1;
        } else if (cong_dung.getCongDung().equalsIgnoreCase("Công Dụng") == false) {
            System.out.println(cong_dung.getCongDung());
            sql += " cong_dung=N'" + cong_dung.getCongDung().trim() + "'";
            lengthAnd += 1;
        }

        if (lengthAnd <= 7 && lengthAnd > 0 && !quy_cach_dong_goi.isEmpty()) {
            System.out.println(quy_cach_dong_goi);
            sql += " and quy_cach_dong_goi=N'" + quy_cach_dong_goi.trim() + "'";
            lengthAnd += 1;
        } else if (!quy_cach_dong_goi.isEmpty()) {
            System.out.println(quy_cach_dong_goi);
            sql += " quy_cach_dong_goi=N'" + quy_cach_dong_goi.trim() + "'";
            lengthAnd += 1;
        }

        if (lengthAnd <= 8 && lengthAnd > 0 && !ham_luong.isEmpty()) {
            sql += " and ham_luong=N'" + ham_luong.trim() + "'";
            lengthAnd += 1;
        } else if (!ham_luong.isEmpty()) {
            sql += " ham_luong=N'" + ham_luong.trim() + "'";
            lengthAnd += 1;
        }

        if (lengthAnd <= 9 && lengthAnd > 0 && !cty_san_xuat.isEmpty()) {
            sql += " and cty_san_xuat=N'" + cty_san_xuat.trim() + "'";
            lengthAnd += 1;
        } else if (!cty_san_xuat.isEmpty()) {
            sql += " cty_san_xuat=N'" + cty_san_xuat.trim() + "'";
            lengthAnd += 1;
        }
        if (lengthAnd <= 10 && lengthAnd > 0 && !nuoc_san_xuat.isEmpty()) {
            System.out.println(nuoc_san_xuat);
            sql += " and nuoc_san_xuat=N'" + nuoc_san_xuat.trim() + "'";
            lengthAnd += 1;
        } else if (!nuoc_san_xuat.isEmpty()) {
            System.out.println(nuoc_san_xuat);
            sql += " nuoc_san_xuat=N'" + nuoc_san_xuat.trim() + "'";
            lengthAnd += 1;
        }

        if (lengthAnd <= 11 && lengthAnd > 0 && trang_thai_kd.equalsIgnoreCase("All") == false) {
            int tf_ttkd = (trang_thai_kd == "Đang Kinh Doanh" ? 1 : 0);
            sql += " and trang_thai_kd= " + tf_ttkd;
            lengthAnd += 1;
        } else if (trang_thai_kd.equalsIgnoreCase("All") == false) {
            int tf_ttkd = (trang_thai_kd == "Đang Kinh Doanh" ? 1 : 0);
            sql += " trang_thai_kd= " + tf_ttkd;
            lengthAnd += 1;
        }

        if (lengthAnd <= 12 && !ma_thuoc.isEmpty() && lengthAnd > 0) {
            sql += " and ma_thuoc=N'" + ma_thuoc.trim() + "'";
            lengthAnd += 1;
        } else if (!ma_thuoc.isEmpty()) {
            sql += " ma_thuoc=N'" + ma_thuoc.trim() + "'";
            lengthAnd += 1;
        }

        if (lengthAnd <= 13 && !so_dk.isEmpty() && lengthAnd > 0) {
            sql += " and so_dk=N'" + so_dk.trim() + "'";
            lengthAnd += 1;
        } else if (!so_dk.isEmpty()) {
            sql += " so_dk=N'" + so_dk.trim() + "'";
            lengthAnd += 1;
        }

        if (lengthAnd == 0) {
            sql = "select t.*,cd.* from Thuoc t join CongDung cd on t.ma_cong_dung=cd.ma_cong_dung";
        }

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CongDung cd = new CongDung(rs.getString("ma_cong_dung"), rs.getString("nhom_cong_dung"), rs.getString("cong_dung"));
                Thuoc t = new Thuoc(rs.getString("ten_thuoc"), rs.getDouble("gia_ban"), rs.getString("don_vi_tinh"), rs.getString("thanh_phan"), rs.getString("dang_bao_che"), rs.getString("ham_luong"), cd, rs.getInt("so_luong_ban_dau"), rs.getDate("han_su_dung"));
                t.setMaThuoc(rs.getString("ma_thuoc"));
                t.setQuyCachDongGoi(rs.getString("quy_cach_dong_goi"));
                t.setcTySanXuat(rs.getString("cty_san_xuat"));
                t.setThueVAT(rs.getFloat("thue_vat"));
                t.setSoDK(rs.getString("so_dk"));
                t.setNuocSanXuat(rs.getString("nuoc_san_xuat"));
                t.setTrangThaiKD(rs.getBoolean("trang_thai_kd"));
                tmp.add(t);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return tmp;
    }

    public Thuoc getThuocTheoMa(String mathuoc) {
        String sql = "select * from Thuoc t join CongDung cd on t.ma_cong_dung=cd.ma_cong_dung where t.ma_thuoc= ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, mathuoc);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                CongDung cd = new CongDung(rs.getString("ma_cong_dung"), rs.getString("nhom_cong_dung"), rs.getString("cong_dung"));
                Thuoc x = new Thuoc(rs.getString("ma_thuoc"), rs.getString("ten_thuoc"), rs.getDouble("gia_ban"), rs.getString("don_vi_tinh"), rs.getString("thanh_phan"), rs.getString("quy_cach_dong_goi"), rs.getString("dang_bao_che"), rs.getString("ham_luong"), rs.getString("cty_san_xuat"), rs.getBoolean("trang_thai_kd"), rs.getFloat("thue_vat"), rs.getString("so_dk"), cd, rs.getInt("so_luong_ban_dau"), rs.getDate("han_su_dung"));
                x.setNuocSanXuat(rs.getString("nuoc_san_xuat"));
                return x;

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Thuoc.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Thuoc timThuocTheoMa(String mathuoc) {
        String sql = "select * from Thuoc t where t.ma_thuoc= ?";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, mathuoc);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Thuoc x = new Thuoc();
                x.setMaThuoc(rs.getString("ma_thuoc"));
                return x;

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_Thuoc.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Thuoc> timKiemThuoc3(String ma_thuoc, String ten_thuoc, String gia_ban, String don_vi_tinh,
            String thanh_phan, String quy_cach_dong_goi, String dang_bao_che, String ham_luong,
            String cty_san_xuat, String nuoc_san_xuat, String trang_thai_kd, String thue_vat,
            String so_dk, CongDung cong_dung, String so_luong_ban_dau, Date han_su_dung) {

        ArrayList<Thuoc> tmp = new ArrayList<>();
        String sql = "select t.*,cd.* from Thuoc t join CongDung cd on t.ma_cong_dung=cd.ma_cong_dung where ma_thuoc like ? and ten_thuoc like ? and don_vi_tinh like ? and thanh_phan like ? and quy_cach_dong_goi like ? and dang_bao_che like ? and ham_luong like ? and cty_san_xuat like ? and nuoc_san_xuat like ? and so_dk like ?";

        if (trang_thai_kd.equalsIgnoreCase("All") == false) {
            int tf_ttkd = (trang_thai_kd == "Đang Kinh Doanh" ? 1 : 0);
            sql += " and trang_thai_kd= " + tf_ttkd;
        }
        //11
        boolean tfhsd = false;
        if (han_su_dung != null) {
//            System.out.println("dao.DAO_Thuoc.timKiemThuoc3()");
            sql += " and han_su_dung= ? ";
            tfhsd = true;
        }

        boolean tfgia_ban = false;
        System.out.println("gia vao" + gia_ban);
        if (!gia_ban.isEmpty()) {
            sql += " and gia_ban = ? ";
            tfgia_ban = true;
        }
        boolean tfvat = false;
        if (!thue_vat.isEmpty()) {
            sql += " and thue_vat = ? ";
            tfvat = true;
        }
        boolean tfsl = false;
        System.out.println("soluong" + so_luong_ban_dau);
        if (!so_luong_ban_dau.isEmpty()) {
            System.out.println("soluong");

            sql += " and so_luong_ban_dau = ? ";
            tfsl = true;
        }

        if (cong_dung.getNhomCongDung().equalsIgnoreCase("Nhóm Công Dụng") == false) {
            sql += " and nhom_cong_dung=N'" + cong_dung.getNhomCongDung().trim() + "'";
        }

        if (cong_dung.getCongDung().equalsIgnoreCase("Công Dụng") == false) {
            sql += " and cong_dung=N'" + cong_dung.getCongDung().trim() + "'";
        }
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, "%" + ma_thuoc + "%");
            stmt.setString(2, "%" + ten_thuoc + "%");
            stmt.setString(3, "%" + don_vi_tinh + "%");
            stmt.setString(4, "%" + thanh_phan + "%");
            stmt.setString(5, "%" + quy_cach_dong_goi + "%");
            stmt.setString(6, "%" + dang_bao_che + "%");
            stmt.setString(7, "%" + ham_luong + "%");
            stmt.setString(8, "%" + cty_san_xuat + "%");
            stmt.setString(9, "%" + nuoc_san_xuat + "%");
            stmt.setString(10, "%" + so_dk + "%");

            if (tfhsd) {
                stmt.setDate(11, han_su_dung);
            }

            if (tfgia_ban) {
                System.out.println("gia");
                stmt.setDouble(12, Double.parseDouble(gia_ban));
            }
            if (tfvat) {
                stmt.setFloat(13, Float.parseFloat(thue_vat));
            }

            if (tfsl) {
                stmt.setLong(14, Long.parseLong(so_luong_ban_dau));
            }
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                CongDung cd = new CongDung(rs.getString("ma_cong_dung"), rs.getString("nhom_cong_dung"), rs.getString("cong_dung"));
                Thuoc t = new Thuoc(rs.getString("ten_thuoc"), rs.getDouble("gia_ban"), rs.getString("don_vi_tinh"), rs.getString("thanh_phan"), rs.getString("dang_bao_che"), rs.getString("ham_luong"), cd, rs.getInt("so_luong_ban_dau"), rs.getDate("han_su_dung"));
                t.setMaThuoc(rs.getString("ma_thuoc"));
                t.setQuyCachDongGoi(rs.getString("quy_cach_dong_goi"));
                t.setcTySanXuat(rs.getString("cty_san_xuat"));
                t.setThueVAT(rs.getFloat("thue_vat"));
                t.setSoDK(rs.getString("so_dk"));
                t.setNuocSanXuat(rs.getString("nuoc_san_xuat"));
                t.setTrangThaiKD(rs.getBoolean("trang_thai_kd"));
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

    public boolean updateThuoc(Thuoc t, String ma_thuoc) throws SQLException {
        PreparedStatement pre = null;
        int count = 0;
        try {
            Statement stmTimT = con.createStatement();
            ResultSet amountT = stmTimT.executeQuery("Select Count(ma_thuoc) As total from Thuoc Where ma_thuoc = '" + ma_thuoc + "' ");
            while (amountT.next()) {
                count = amountT.getInt("total");
            }
            System.out.println(count);
            if (count != 0) {
                String sql = "update Thuoc set ten_thuoc=?,gia_ban=?,don_vi_tinh=?,thanh_phan=?,quy_cach_dong_goi=?,dang_bao_che=?,ham_luong=?,cty_san_xuat=?, nuoc_san_xuat=?,trang_thai_kd=?, thue_vat=?, so_dk=?, ma_cong_dung=?, so_luong_ban_dau=?, han_su_dung=? WHERE ma_thuoc=?";
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

    public boolean ngungBanThuoc(String ma_thuoc) throws SQLException {
        PreparedStatement pre = null;
        int count = 0;
        try {
            Statement stmTimT = con.createStatement();
            ResultSet amountT = stmTimT.executeQuery("Select Count(ma_thuoc) As total from Thuoc Where ma_thuoc = '" + ma_thuoc + "' ");
            while (amountT.next()) {
                count = amountT.getInt("total");
            }
            if (count != 0) {
                String sql = "update Thuoc set trang_thai_kd=? WHERE ma_thuoc=?";
                pre = con.prepareStatement(sql);
                pre.setInt(1, 0);
                pre.setString(2, ma_thuoc);
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

    public boolean deleteThuoc(String ma_thuoc) {
        PreparedStatement statement = null;
        try {
            String sql = "Delete From Thuoc Where ma_thuoc = ?";
            statement = con.prepareStatement(sql);
            statement.setString(1, ma_thuoc);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String TaoSoNgauNhien() {
        String strMaThuoc = null;

        PreparedStatement s = null;
        String sql = "select top 1 ma_thuoc from Thuoc order by ma_thuoc desc";
        try {
            s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                strMaThuoc = rs.getString(1);
            }
            System.out.println("strMaThuoc:" + strMaThuoc);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Lỗi khi tạo mã thuốc");
            return "";
        } finally {
            try {
                s.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        String str = strMaThuoc.substring(2, 4);
        strMaThuoc = strMaThuoc.substring(4);
        long longMaHD = Long.parseLong(strMaThuoc);
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
        strMaThuoc = longMaHD == 0 ? String.valueOf(1001 + longMaHD) : String.valueOf(1000 + longMaHD);
//        System.err.println(strMaThuoc);
        strMaThuoc = "TH" + str + strMaThuoc.substring(3);
        return strMaThuoc;
    }

    public boolean capNhatSoLuong(Thuoc thuocMua) {
        String sql = "select * from Thuoc where ma_thuoc= ?";
        String sqlCapNhatThuoc = "UPDATE [dbo].[Thuoc]\n"
                + "   SET [so_luong_ban_dau] = ? \n"
                + " WHERE ma_thuoc= ? ";
        int soThuocConlai = 0;
        int n = -1;
        try {
            PreparedStatement stmt1 = con.prepareStatement(sql);
            PreparedStatement stmt2 = con.prepareStatement(sqlCapNhatThuoc);
            stmt1.setString(1, thuocMua.getMaThuoc());
            ResultSet rs = stmt1.executeQuery();
            if (rs.next()) {
                soThuocConlai = (int) rs.getLong("so_luong_ban_dau") - (int) thuocMua.getSoLuongBanDau();
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
            String sql = "SELECT * FROM Thuoc WHERE DATEDIFF(day, GETDATE(), han_su_dung ) BETWEEN 1 AND 60  ORDER BY han_su_dung ";
            Statement statement;

            statement = con.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String ma = rs.getString("ma_thuoc");
                String ten = rs.getString("ten_thuoc");
                double gia = rs.getDouble("gia_ban");
                String dvt = rs.getNString("don_vi_tinh");
                String thanh_phan = rs.getString("thanh_phan");
                String quy_cach_dong_goi = rs.getString("quy_cach_dong_goi");
                String dang_bao_che = rs.getString("dang_bao_che");
                String ham_luong = rs.getString("ham_luong");
                String cty_san_xuat = rs.getString("cty_san_xuat");
                String nuoc_san_xuat = rs.getString("nuoc_san_xuat");
                boolean trang_thai_kd = rs.getBoolean("trang_thai_kd");
                float vat = rs.getFloat("thue_vat");
                String so_dk = rs.getString("so_dk");
                String ma_cong_dung = rs.getString("ma_cong_dung");
                int soLuong = rs.getInt("so_luong_ban_dau");
                Date han_su_dung = rs.getDate("han_su_dung");

                DAO_CongDung dao_CD = new DAO_CongDung();
                CongDung cong_dung = dao_CD.getCongDungByMaCongDung(ma_cong_dung);

                Thuoc T = new Thuoc(ma, ten, gia, dvt, thanh_phan, quy_cach_dong_goi, dang_bao_che, ham_luong, cty_san_xuat,
                        nuoc_san_xuat, trang_thai_kd, vat, so_dk, cong_dung, soLuong, han_su_dung);

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
            String sql = "SELECT * FROM Thuoc WHERE han_su_dung <= CURRENT_TIMESTAMP";
            Statement statement;

            statement = con.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String ma = rs.getString("ma_thuoc");
                String ten = rs.getString("ten_thuoc");
                double gia = rs.getDouble("gia_ban");
                String dvt = rs.getNString("don_vi_tinh");
                String thanh_phan = rs.getString("thanh_phan");
                String quy_cach_dong_goi = rs.getString("quy_cach_dong_goi");
                String dang_bao_che = rs.getString("dang_bao_che");
                String ham_luong = rs.getString("ham_luong");
                String cty_san_xuat = rs.getString("cty_san_xuat");
                String nuoc_san_xuat = rs.getString("nuoc_san_xuat");
                boolean trang_thai_kd = rs.getBoolean("trang_thai_kd");
                float vat = rs.getFloat("thue_vat");
                String so_dk = rs.getString("so_dk");
                String ma_cong_dung = rs.getString("ma_cong_dung");
                int soLuong = rs.getInt("so_luong_ban_dau");
                Date han_su_dung = rs.getDate("han_su_dung");

                DAO_CongDung dao_CD = new DAO_CongDung();
                CongDung cong_dung = dao_CD.getCongDungByMaCongDung(ma_cong_dung);

                Thuoc T = new Thuoc(ma, ten, gia, dvt, thanh_phan, quy_cach_dong_goi, dang_bao_che, ham_luong, cty_san_xuat,
                        nuoc_san_xuat, trang_thai_kd, vat, so_dk, cong_dung, soLuong, han_su_dung);

                list.add(T);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
