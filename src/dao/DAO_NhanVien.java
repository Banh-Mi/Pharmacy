package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.NhanVien;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DAO_NhanVien {

    private Connection con;
   // private DAO_DiaChi dao_DiaChi = new DAO_DiaChi();
    private PreparedStatement stmt;

    public DAO_NhanVien() {
        try {
            con = ConnectDB.getInstances().getConnection();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public NhanVien timNhanVien(String sdt) {
        String sql = "select * from NhanVien where so_dien_thoai= ? and loai_nhan_vien=0 and trang_thai_lam=1";

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, sdt);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
               String diachi;
                try {
                    diachi = rs.getString("dia_chi");
                    NhanVien nv = new NhanVien(rs.getString("ten_nhan_vien"), rs.getBoolean("gioi_tinh"),
                            rs.getString("so_dien_thoai"), rs.getBoolean("trang_thai_lam"), rs.getString("so_cmnd"), diachi);
                    return nv;
                } catch (Exception ex) {
                    Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public NhanVien timNhanVienAdmin(String sdt) {
        String sql = "select * from NhanVien where so_dien_thoai= ? and loai_nhan_vien=1 and trang_thai_lam=1";

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, sdt);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String diachi;
                try {
                    diachi = rs.getString("dia_chi");
                    NhanVien nv = new NhanVien(rs.getString("ten_nhan_vien"), rs.getBoolean("gioi_tinh"),
                            rs.getString("so_dien_thoai"), rs.getBoolean("trang_thai_lam"), rs.getString("so_cmnd"), diachi);
                    return nv;
                } catch (Exception ex) {
                    Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public NhanVien timNhanVienTheoMa(String ma) {
        String sql = "select * from NhanVien where ma_nhan_vien = ? ";

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, ma);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // NhanVien nv= new NhanVien(rs.getString("maNhanVien"),
                // rs.getString("ten_nhan_vien"), rs.getBoolean("gioi_tinh"),
                // rs.getString("so_dien_thoai"), rs.getString("passLogin"),
                // rs.getBoolean("trang_thai_lam"),
                // rs.getBoolean("loai_nhan_vien"),rs.getString("so_cmnd") ,null);
                String diachi;
                try {
                    diachi = rs.getString("dia_chi");
                    NhanVien nv = new NhanVien(
                            rs.getString("ma_nhan_vien"),
                            rs.getString("ten_nhan_vien"),
                            rs.getBoolean("gioi_tinh"),
                            rs.getString("so_dien_thoai"),
                            rs.getString("mat_khau"),
                            rs.getBoolean("trang_thai_lam"),
                            rs.getBoolean("loai_nhan_vien"),
                            rs.getString("so_cmnd"),
                            diachi);
                    return nv;
                } catch (Exception ex) {
                    Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public int themNV(NhanVien nv) throws Exception {
        if (timNhanVienTheoMa(nv.getMaNV()) != null) {
            return 0; // trùng sdt nv
        }
//        String madiachi = dao_DiaChi.timMaDC(nv.getDiaChi().getTinhTP(), nv.getDiaChi().getQuanHuyen(),
//                nv.getDiaChi().getPhuongXa());

        String sql = "USE [QLThuoc] INSERT INTO [dbo].[NhanVien] (ma_nhan_vien, ten_nhan_vien, gioi_tinh, so_dien_thoai, mat_khau, trang_thai_lam, loai_nhan_vien, so_cmnd, dia_chi) VALUES( ?,?,?,?,?,?,?,?,? ) ";

        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setString(1, nv.getMaNV());
        stmt.setString(2, nv.getTenNV());
        stmt.setBoolean(3, nv.isGioiTinh());
        stmt.setString(4, nv.getSdt());
        stmt.setString(5, nv.getMatKhau());
        stmt.setBoolean(6, nv.isTrangThaiLam());
        stmt.setBoolean(7, nv.isLoaiNhanVien());
        stmt.setString(8, nv.getCmnd());
        stmt.setString(9, nv.getDiaChi());

        stmt.executeUpdate();
        return 1;
    }

    public boolean xoaNhanVien(String sdt) {
        System.out.println(timNhanVien(sdt));
        int n = -1;
        if (timNhanVien(sdt) == null) {
            return n > 0; // không tìm thấy nhân viên
        }
        String sql = "DELETE FROM [dbo].[NhanVien] WHERE so_dien_thoai= ? ";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, sdt);
            n = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n > 0;
    }

    public int capNhatNhanVien(NhanVien nv) throws Exception {
        if (timNhanVienTheoMa(nv.getMaNV()) == null) {
            return 0; // không tìm thấy nhân viên
        }
        String sql = "USE [QLThuoc] "
                + "UPDATE [dbo].[NhanVien] "
                + "   SET [ten_nhan_vien] = ? "
                + "      ,[gioi_tinh] = ? "
                + "      ,[so_dien_thoai] = ? "
                + "      ,[trang_thai_lam] = ?"
                + "      ,[loai_nhan_vien] = ? "
                + "      ,[so_cmnd] = ? "
                + "      ,[dia_chi] = ? "
                + " WHERE ma_nhan_vien= ? ";

//        String madiachi = dao_DiaChi.timMaDC(nv.getDiaChi().getTinhTP(), nv.getDiaChi().getQuanHuyen(), nv.getDiaChi().getPhuongXa());
//        int loainv= nv.isLoaiNhanVien()?1:0;
//        int gioi_tinh=nv.isGioiTinh()?1:0;
//        int trangthai=nv.isTrangThaiLam()?1:0;
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, nv.getTenNV());
        stmt.setBoolean(2, nv.isGioiTinh());
        stmt.setString(3, nv.getSdt());
        stmt.setBoolean(4, nv.isTrangThaiLam());
        stmt.setBoolean(5, nv.isLoaiNhanVien());
        stmt.setString(6, nv.getCmnd());
        stmt.setString(7, nv.getDiaChi());
        stmt.setString(8, nv.getMaNV());

        int n = stmt.executeUpdate();
        return n;

    }

    public int capNhatNhanVienNghiLam(String ma) throws Exception {
        String sql = "USE [QLThuoc] "
                + "UPDATE [dbo].[NhanVien] "
                + "   SET trang_thai_lam = 0 "
                + " WHERE ma_nhan_vien = ? ";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, ma);
        int n = stmt.executeUpdate();
        return n;

    }

    public String sinhMaTuDong() throws SQLException {
        String sql = " select CONCAT('NV', RIGHT(CONCAT('00',ISNULL(right(max(ma_nhan_vien),6),0) + 1),6)) from [dbo].[NhanVien] where ma_nhan_vien like 'NV%' ";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString(1);
        }
        JOptionPane.showMessageDialog(null, "Sinh mã nhân viên thất bại");
        return null;
    }

    public int capNhatAdmind(NhanVien nv) {
        int n = 0;
        String sql = "USE [QLThuoc] "
                + "UPDATE [dbo].[NhanVien] "
                + "   SET ten_nhan_vien = ? "
                + "      ,[gioi_Tinh] = ? "
                + "      ,[so_dien_thoai] = ? "
                + "      ,[loai_nhan_vien] = ? "
                + "      ,[so_cmnd] = ? "
                + "      ,[dia_chi] = ? "
                + " WHERE so_dien_thoai= ? ";

   
        try {
            //madiachi = dao_DiaChi.timMaDC(nv.getDiaChi().getTinhTP(), nv.getDiaChi().getQuanHuyen(), nv.getDiaChi().getPhuongXa());
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nv.getTenNV());
            stmt.setBoolean(2, nv.isGioiTinh());
            stmt.setString(3, nv.getSdt());
            stmt.setBoolean(4, nv.isLoaiNhanVien());
            stmt.setString(5, nv.getCmnd());
            stmt.setString(6, nv.getDiaChi());
            stmt.setString(7, nv.getSdt());

            n = stmt.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n;

    }

    /**
     * @return
     */
    public ArrayList<NhanVien> getDSNhanVien() throws Exception {
        ArrayList<NhanVien> tmp = new ArrayList<NhanVien>();
        String sql = "select * from NhanVien nv  ";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            //DiaChi diachi = dao_DiaChi.timdiachi(rs.getString("dia_chi"));

            NhanVien nv = new NhanVien(rs.getString("ma_nhan_vien"),
                    rs.getString("ten_nhan_vien"),
                    rs.getBoolean("gioi_tinh"),
                    rs.getString("so_dien_thoai"),
                    rs.getString("mat_khau"),
                    rs.getBoolean("trang_thai_lam"),
                    rs.getBoolean("loai_nhan_vien"),
                    rs.getString("so_cmnd"),
                    rs.getString("dia_chi"));
            tmp.add(nv);
        }
        return tmp;
    }

    public ArrayList<NhanVien> getMaVaTenNV() {
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        try {
            String sql = "Select * from NhanVien Order by ma_nhan_vien Desc";
            Statement statement;
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String maNhanVien = rs.getString("ma_nhan_vien");
                String ten_nhan_vien = rs.getString("ten_nhan_vien");

                NhanVien nv = new NhanVien(maNhanVien, ten_nhan_vien);
                listNhanVien.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listNhanVien;
    }

    public NhanVien dangNhap(String tk, String mk) {
        String sql = "select * from NhanVien where so_dien_thoai = ? and trang_thai_lam = 1";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, tk);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String matKhau = rs.getString("mat_khau");
                if (mk.equals(matKhau)) {
                    NhanVien nv = new NhanVien();
                    String ma = rs.getString("ma_nhan_vien");
                    String taikhoan = rs.getString("so_dien_thoai");
                    nv.setMaNV(ma);
                    nv.setSdt(taikhoan);
                    nv.setTenNV(rs.getString("ten_nhan_vien"));
                    nv.setGioiTinh(rs.getBoolean("gioi_tinh"));
                    nv.setTrangThaiLam(rs.getBoolean("trang_thai_lam"));
                    nv.setLoaiNhanVien(rs.getBoolean("loai_nhan_vien"));
                    nv.setCmnd(rs.getString("so_cmnd"));
                    try {
                        nv.setDiaChi(rs.getString("dia_chi"));
                        return nv;
                    } catch (Exception ex) {
                        Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    return null;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public NhanVien getLSDNone() {

        String sql = "select top(1) * from LichSuDangNhap ls join NhanVien nv on ls.ma_nhan_vien=nv.ma_nhan_vien ORDER BY tg_dang_nhap DESC";

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                try {
                    //DiaChi dc = dao_DiaChi.timdiachi(rs.getString("dia_chi"));
                    NhanVien nv = new NhanVien(rs.getString("ma_nhan_vien"), rs.getString("ten_nhan_vien"), rs.getBoolean("gioi_tinh"), rs.getString("so_dien_thoai"), rs.getBoolean("loai_nhan_vien"));
                    nv.setDiaChi(rs.getString("dia_chi"));
                    nv.setCmnd(rs.getString("so_cmnd"));
                    return nv;
                } catch (Exception ex) {
                    Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<String> getLSDNTheoNV(String ma_nhan_vien) {
        ArrayList<String> tmp = new ArrayList<String>();
        String sql = "select * from LichSuDangNhap where ma_nhan_vien = ? order by tg_dang_nhap desc";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, ma_nhan_vien);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String o = rs.getString("ma_nhan_vien") + ";" + rs.getString("ten_nhan_vien") + ";" + rs.getString("tg_dang_nhap");
                tmp.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tmp;
    }

    public boolean themLSDN(NhanVien nv) {
        int n = -1;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = sdf.format(date);

        String sql = "INSERT INTO [dbo].[LichSuDangNhap]\n"
                + "           ([ma_nhan_vien]\n"
                + "           ,[ten_nhan_vien]\n"
                + "           ,[gioi_tinh]\n"
                + "           ,[so_dien_thoai]\n"
                + "           ,[loai_nhan_vien]\n"
                + "           ,[tg_dang_nhap])\n"
                + "     VALUES (?,?,?,?,?,?) ";

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, nv.getMaNV());
            stmt.setString(2, nv.getTenNV());
            stmt.setBoolean(3, nv.isGioiTinh());
            stmt.setString(4, nv.getSdt());
            stmt.setBoolean(5, nv.isLoaiNhanVien());
            stmt.setString(6, strDate);
            n = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }

        return n > 0;
    }

    public ArrayList<NhanVien> timKiemNhanVien(String sdtNV, String tenNV, String gioi_tinh, String trang_thai_lam) {
        ArrayList<NhanVien> temp = new ArrayList<>();
        int lengArr = 0;
        String sql = "select * from NhanVien nv join DiaChi dc on nv.dia_chi=dc.dia_chi where ";

        if (!sdtNV.isEmpty() && lengArr > 0) {
            sql += " and so_dien_thoai= " + sdtNV;
            lengArr++;
        } else if (!sdtNV.isEmpty()) {
            sql += " so dien thoai= " + sdtNV;
            lengArr++;
        }

        if (!tenNV.isEmpty() && lengArr > 0) {
            sql += " and ten_nhan_vien = N'" + tenNV + "'";
            lengArr++;
        } else if (!tenNV.isEmpty()) {
            sql += "ten_nhan_vien = N'" + tenNV + "'";
            lengArr++;
        }

        if (!gioi_tinh.equals("Giới tính") && lengArr > 0) {
            int tf_gioitinh = (gioi_tinh == "Nam" ? 1 : 0);
            sql += " and gioi_tinh = " + tf_gioitinh;
            lengArr++;
        } else if (!gioi_tinh.equals("Giới tính")) {
            int tf_gioitinh = (gioi_tinh == "Nam" ? 1 : 0);
            sql += " gioi_tinh = " + tf_gioitinh;
            lengArr++;
        }

        if (!trang_thai_lam.equals("Trạng thái") && lengArr > 0) {
            int tf_trangthai = trang_thai_lam == "Đang làm" ? 1 : 0;
            sql += "and trang_thai_lam = " + tf_trangthai;
            lengArr++;
        } else if (!trang_thai_lam.equals("Trạng thái")) {
            int tf_trangthai = trang_thai_lam == "Đang làm" ? 1 : 0;
            sql += " trang_thai_lam = " + tf_trangthai;
            lengArr++;
        }

        if (lengArr == 0) {
            sql = "select * from NhanVien";
        }

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
//                DiaChi dcNV = new DiaChi(rs.getString("tinh_tp"), rs.getString("quan_huyen"), rs.getString("phuong_xa"));
                nv.setMaNV(rs.getString("ma_nhan_vien"));
                nv.setTenNV(rs.getString("ten_nhan_vien"));
                nv.setGioiTinh(rs.getBoolean("gioi_tinh"));
                nv.setSdt(rs.getString("so_dien_thoai"));
                nv.setCmnd(rs.getString("so_cmnd"));
                nv.setDiaChi(rs.getString("dia_chi"));
                nv.setTrangThaiLam(rs.getBoolean("trang_thai_lam"));
                temp.add(nv);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return temp;
    }

    public String taoMaNgauNhienNhanVien() {
        String strMaHD = null;

        PreparedStatement s = null;
        String sql = "select top 1 ma_nhan_vien from NhanVien order by ma_nhan_vien desc";
        try {
            s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery();

            while (rs.next()) {
                strMaHD = rs.getString(1);
            }
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
        strMaHD = longMaHD == 0 ? String.valueOf(101 + longMaHD) : String.valueOf(10 + longMaHD);
        strMaHD = "NV" + str + strMaHD.substring(1);
        return strMaHD;
    }

    public boolean capnhapMatKhau(String mkNew, String soDTNV) {
        int n = -1;
        String sql = "UPDATE [dbo].[NhanVien]\n"
                + "   SET [mat_khau] = ? \n"
                + " WHERE so_dien_thoai = ? ";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, mkNew);
            stmt.setString(2, soDTNV);
            n = stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n > 0;
    }

    public ArrayList<NhanVien> timNVTheoTenVaSdt(String ten, String sdt) {
        String sql = "select * from NhanVien where ten_nhan_vien like '%" + ten + "%' or so_dien_thoai like N'%" + sdt + "%'";
        PreparedStatement statement = null;
        ArrayList<NhanVien> list = new ArrayList<NhanVien>();
        try {
            statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                try {
                    //diachi = dao_DiaChi.timdiachi(rs.getString("dia_chi"));
                    NhanVien nv = new NhanVien(rs.getString("ma_nhan_vien"),
                            rs.getString("ten_nhan_vien"),
                            rs.getBoolean("gioi_tinh"),
                            rs.getString("so_dien_thoai"),
                            rs.getString("mat_khau"),
                            rs.getBoolean("trang_thai_lam"),
                            rs.getBoolean("loai_nhan_vien"),
                            rs.getString("so_cmnd"),
                            rs.getString("dia_chi"));
                    list.add(nv);
                } catch (Exception ex) {
                    Logger.getLogger(DAO_NhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
}
