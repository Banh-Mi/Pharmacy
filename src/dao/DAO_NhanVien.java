package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.DiaChi;
import entity.NhanVien;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class DAO_NhanVien {

    private Connection con;
    private DAO_DiaChi dao_DiaChi = new DAO_DiaChi();
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
        String sql = "select * from NhanVien where soDienThoaiNV= ? and loaiNV=0 and trangThaiLamViec=1";

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, sdt);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                DiaChi diachi;
                try {
                    diachi = dao_DiaChi.timdiachi(rs.getString("maDC"));
                    NhanVien nv = new NhanVien(rs.getString("tenNhanVien"), rs.getBoolean("gioiTinh"),
                            rs.getString("soDienThoaiNV"), rs.getBoolean("trangThaiLamViec"), rs.getString("cmnd"), diachi);
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
        String sql = "select * from NhanVien where soDienThoaiNV= ? and loaiNV=1 and trangThaiLamViec=1";

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, sdt);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                DiaChi diachi;
                try {
                    diachi = dao_DiaChi.timdiachi(rs.getString("maDC"));
                    NhanVien nv = new NhanVien(rs.getString("tenNhanVien"), rs.getBoolean("gioiTinh"),
                            rs.getString("soDienThoaiNV"), rs.getBoolean("trangThaiLamViec"), rs.getString("cmnd"), diachi);
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
        String sql = "select * from NhanVien where maNhanVien = ? ";

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, ma);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // NhanVien nv= new NhanVien(rs.getString("maNhanVien"),
                // rs.getString("tenNhanVien"), rs.getBoolean("gioiTinh"),
                // rs.getString("soDienThoaiNV"), rs.getString("passLogin"),
                // rs.getBoolean("trangThaiLamViec"),
                // rs.getBoolean("loaiNV"),rs.getString("cmnd") ,null);
                DiaChi diachi;
                try {
                    diachi = dao_DiaChi.timdiachi(rs.getString("maDC"));
                    NhanVien nv = new NhanVien(
                            rs.getString("maNhanVien"),
                            rs.getString("tenNhanVien"),
                            rs.getBoolean("gioiTinh"),
                            rs.getString("soDienThoaiNV"),
                            rs.getString("passLogin"),
                            rs.getBoolean("trangThaiLamViec"),
                            rs.getBoolean("loaiNV"),
                            rs.getString("cmnd"),
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
        String madiachi = dao_DiaChi.timMaDC(nv.getDiaChi().getTinhTP(), nv.getDiaChi().getQuanHuyen(),
                nv.getDiaChi().getPhuongXa());

        String sql = "USE [QLThuoc] INSERT INTO [dbo].[NhanVien] ([maNhanVien],[tenNhanVien],[gioiTinh],[soDienThoaiNV],[passLogin],[trangThaiLamViec],[loaiNV],[cmnd],[maDC]) VALUES( ?,?,?,?,?,?,?,?,? ) ";

        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setString(1, nv.getMaNV());
        stmt.setString(2, nv.getTenNV());
        stmt.setBoolean(3, nv.isGioiTinh());
        stmt.setString(4, nv.getSdt());
        stmt.setString(5, nv.getMatKhau());
        stmt.setBoolean(6, nv.isTrangThaiLam());
        stmt.setBoolean(7, nv.isLoaiNhanVien());
        stmt.setString(8, nv.getCmnd());
        stmt.setString(9, madiachi);

        stmt.executeUpdate();
        return 1;
    }

    public boolean xoaNhanVien(String sdt) {
        // System.out.println(timNhanVien(sdt));
        int n = -1;
        if (timNhanVien(sdt) == null) {
            return n > 0; // không tìm thấy nhân viên
        }
        String sql = "DELETE FROM [dbo].[NhanVien] WHERE soDienThoaiNV= ? ";
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
                + "   SET [tenNhanVien] = ? "
                + "      ,[gioiTinh] = ? "
                + "      ,[soDienThoaiNV] = ? "
                + "      ,[trangThaiLamViec] = ?"
                + "      ,[loaiNV] = ? "
                + "      ,[cmnd] = ? "
                + "      ,[maDC] = ? "
                + " WHERE maNhanVien= ? ";

        String madiachi = dao_DiaChi.timMaDC(nv.getDiaChi().getTinhTP(), nv.getDiaChi().getQuanHuyen(), nv.getDiaChi().getPhuongXa());
//        int loainv= nv.isLoaiNhanVien()?1:0;
//        int gioiTinh=nv.isGioiTinh()?1:0;
//        int trangthai=nv.isTrangThaiLam()?1:0;
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, nv.getTenNV());
        stmt.setBoolean(2, nv.isGioiTinh());
        stmt.setString(3, nv.getSdt());
        stmt.setBoolean(4, nv.isTrangThaiLam());
        stmt.setBoolean(5, nv.isLoaiNhanVien());
        stmt.setString(6, nv.getCmnd());
        stmt.setString(7, madiachi);
        stmt.setString(8, nv.getMaNV());

        int n = stmt.executeUpdate();
        return n;

    }

    public int capNhatNhanVienNghiLam(String ma) throws Exception {
        String sql = "USE [QLThuoc] "
                + "UPDATE [dbo].[NhanVien] "
                + "   SET trangThaiLamViec = 0 "
                + " WHERE maNhanVien= ? ";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, ma);
        int n = stmt.executeUpdate();
        return n;

    }

    public String sinhMaTuDong() throws SQLException {
        String sql = " select CONCAT('NVAA', RIGHT(CONCAT('000000',ISNULL(right(max(maNhanVien),6),0) + 1),6)) from [dbo].[NhanVien] where maNhanVien like 'NVAA%' ";
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
                + "   SET [tenNhanVien] = ? "
                + "      ,[gioiTinh] = ? "
                + "      ,[soDienThoaiNV] = ? "
                + "      ,[loaiNV] = ? "
                + "      ,[cmnd] = ? "
                + "      ,[maDC] = ? "
                + " WHERE soDienThoaiNV= ? ";

        String madiachi;
        try {
            madiachi = dao_DiaChi.timMaDC(nv.getDiaChi().getTinhTP(), nv.getDiaChi().getQuanHuyen(), nv.getDiaChi().getPhuongXa());
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nv.getTenNV());
            stmt.setBoolean(2, nv.isGioiTinh());
            stmt.setString(3, nv.getSdt());
            stmt.setBoolean(4, nv.isLoaiNhanVien());
            stmt.setString(5, nv.getCmnd());
            stmt.setString(6, madiachi);
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
        String sql = "select * from NhanVien order by maNhanVien ";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            DiaChi diachi = dao_DiaChi.timdiachi(rs.getString("maDC"));

            NhanVien nv = new NhanVien(rs.getString("maNhanVien"),
                    rs.getString("tenNhanVien"),
                    rs.getBoolean("gioiTinh"),
                    rs.getString("soDienThoaiNV"),
                    rs.getString("passLogin"),
                    rs.getBoolean("trangThaiLamViec"),
                    rs.getBoolean("loaiNV"),
                    rs.getString("cmnd"),
                    diachi);
            tmp.add(nv);
        }
        return tmp;
    }

    public ArrayList<NhanVien> getMaVaTenNV() {
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        try {
            String sql = "Select * from NhanVien Order by maNhanVien Desc";
            Statement statement;
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String maNhanVien = rs.getString("maNhanVien");
                String tenNhanVien = rs.getString("tenNhanVien");

                NhanVien nv = new NhanVien(maNhanVien, tenNhanVien);
                listNhanVien.add(nv);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listNhanVien;
    }

    public NhanVien dangNhap(String tk, String mk) {
        String sql = "select * from NhanVien where soDienThoaiNV= ? and trangThaiLamViec = 1";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, tk);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String matKhau = rs.getString("passLogin");
                if (mk.equals(matKhau)) {
                    NhanVien nv = new NhanVien();
                    String ma = rs.getString("maNhanVien");
                    String taikhoan = rs.getString("soDienThoaiNV");
                    boolean loaiNV = rs.getBoolean("loaiNV");
                    nv.setMaNV(ma);
                    nv.setSdt(taikhoan);
                    nv.setTenNV(rs.getString("tenNhanVien"));
                    nv.setGioiTinh(rs.getBoolean("gioiTinh"));
                    nv.setTrangThaiLam(rs.getBoolean("trangThaiLamViec"));
                    nv.setLoaiNhanVien(rs.getBoolean("loaiNV"));
                    nv.setCmnd(rs.getString("cmnd"));
                    try {
                        nv.setDiaChi(dao_DiaChi.timdiachi(rs.getString("maDC")));
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

        String sql = "select top(1) * from LichSuDangNhap ls join NhanVien nv on ls.maNV=nv.maNhanVien ORDER BY thoiGianDangNhap DESC";

        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                try {
                    DiaChi dc = dao_DiaChi.timdiachi(rs.getString("maDC"));
                    NhanVien nv = new NhanVien(rs.getString("maNV"), rs.getString("tenNhanVien"), rs.getBoolean("gioiTinh"), rs.getString("soDienThoaiNV"), rs.getBoolean("loaiNV"));
                    nv.setDiaChi(dc);
                    nv.setCmnd(rs.getString("cmnd"));
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

    public ArrayList<String> getLSDNTheoNV(String maNV) {
        ArrayList tmp = new ArrayList();
        String sql = "select * from LichSuDangNhap where maNV = ? order by thoiGianDangNhap desc";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, maNV);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String o = rs.getString("maNV") + ";" + rs.getString("tenNhanVien") + ";" + rs.getString("thoiGianDangNhap");
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
                + "           ([maNV]\n"
                + "           ,[tenNhanVien]\n"
                + "           ,[gioiTinh]\n"
                + "           ,[soDienThoaiNV]\n"
                + "           ,[loaiNV]\n"
                + "           ,[thoiGianDangNhap])\n"
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

    public ArrayList<NhanVien> timKiemNhanVien(String sdtNV, String tenNV, String gioiTinh, String trangThaiLamViec) {
        ArrayList<NhanVien> temp = new ArrayList<>();
        int lengArr = 0;
        String sql = "select * from NhanVien nv join DiaChi dc on nv.maDC=dc.maDC where ";

        if (!sdtNV.isEmpty() && lengArr > 0) {
            sql += " and soDienThoaiNV= " + sdtNV;
            lengArr++;
        } else if (!sdtNV.isEmpty()) {
            sql += " soDienThoaiNV= " + sdtNV;
            lengArr++;
        }

        if (!tenNV.isEmpty() && lengArr > 0) {
            sql += " and tenNhanVien = N'" + tenNV + "'";
            lengArr++;
        } else if (!tenNV.isEmpty()) {
            sql += "tenNhanVien = N'" + tenNV + "'";
            lengArr++;
        }

        if (!gioiTinh.equals("Giới tính") && lengArr > 0) {
            int tf_gioitinh = (gioiTinh == "Nam" ? 1 : 0);
            sql += " and gioiTinh = " + tf_gioitinh;
            lengArr++;
        } else if (!gioiTinh.equals("Giới tính")) {
            int tf_gioitinh = (gioiTinh == "Nam" ? 1 : 0);
            sql += " gioiTinh = " + tf_gioitinh;
            lengArr++;
        }

        if (!trangThaiLamViec.equals("Trạng thái") && lengArr > 0) {
            int tf_trangthai = trangThaiLamViec == "Đang làm" ? 1 : 0;
            sql += "and trangThaiLamViec = " + tf_trangthai;
            lengArr++;
        } else if (!trangThaiLamViec.equals("Trạng thái")) {
            int tf_trangthai = trangThaiLamViec == "Đang làm" ? 1 : 0;
            sql += " trangThaiLamViec = " + tf_trangthai;
            lengArr++;
        }

        if (lengArr == 0) {
            sql = "select * from NhanVien nv join DiaChi dc on nv.maDC=dc.maDC";
        }

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                DiaChi dcNV = new DiaChi(rs.getString("tinhTP"), rs.getString("quanHuyen"), rs.getString("phuongXa"));
                nv.setMaNV(rs.getString("maNhanVien"));
                nv.setTenNV(rs.getString("tenNhanVien"));
                nv.setGioiTinh(rs.getBoolean("gioiTinh"));
                nv.setSdt(rs.getString("soDienThoai"));
                nv.setCmnd(rs.getString("cmnd"));
                nv.setDiaChi(dcNV);
                nv.setTrangThaiLam(rs.getBoolean("trangThaiLamViec"));
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
        String sql = "select top 1 maNhanVien from NhanVien order by maNhanVien desc";
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
        strMaHD = longMaHD == 0 ? String.valueOf(1000001 + longMaHD) : String.valueOf(1000000 + longMaHD);
        strMaHD = "NV" + str + strMaHD.substring(1);
        return strMaHD;
    }

    public boolean capnhapMatKhau(String mkNew, String soDTNV) {
        int n = -1;
        String sql = "UPDATE [dbo].[NhanVien]\n"
                + "   SET [passLogin] = ? \n"
                + " WHERE soDienThoaiNV= ? ";
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
        String sql = "select * from NhanVien where tenNhanVien like '%" + ten + "%' and soDienThoaiNV like N'%" + sdt + "%'";
        PreparedStatement statement = null;
        ArrayList<NhanVien> list = new ArrayList<NhanVien>();
        try {
            statement = con.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                DiaChi diachi;
                try {
                    diachi = dao_DiaChi.timdiachi(rs.getString("maDC"));
                    NhanVien nv = new NhanVien(rs.getString("maNhanVien"),
                            rs.getString("tenNhanVien"),
                            rs.getBoolean("gioiTinh"),
                            rs.getString("soDienThoaiNV"),
                            rs.getString("passLogin"),
                            rs.getBoolean("trangThaiLamViec"),
                            rs.getBoolean("loaiNV"),
                            rs.getString("cmnd"),
                            diachi);
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
