//package test;
//
//import connect.ConnectDB;
//import dao.DAO_CT_HoaDonBan;
//import java.util.List;
//
//import dao.DAO_HoaDonBan;
//import dao.DAO_KhachHang;
//import dao.DAO_NhanVien;
//import dao.DAO_Thuoc;
//import entity.KhachHang;
//import entity.NhanVien;
//import java.sql.Connection;
//import java.sql.Date;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//
//public class mytest {
//
//    public static void main(String[] args) throws Exception {
        // LopHocDao lhdao= new LopHocDao();
        // Lophoc lophoc= new Lophoc("DHKTPM16A", "Đại học kĩ thuật phần mềm 16A");
        // boolean n= lhdao.themLopHoc(lophoc);
        // boolean n= lhdao.capNhatLopHoc(lophoc);
        // boolean n= lhdao.xoaLopHoc("DHKHMT16CTT");
        // System.out.println(n);
        // List tmp= lhdao.getDSLopHoc();
        // tmp.forEach(lh -> System.out.println(lh));
        // System.out.println(lhdao.timLophoc("DHKHMT16A"));

        // SinhVienDao svdao= new SinhVienDao();
        // System.out.println(svdao.timSinhVien("20003005"));
        // SinhVien sv= new SinhVien("20112001", "Nguyễn Hoàng", "Thành", true, "123@gmail.com", "HCM", "DHKHMT16A");
        // System.out.println(svdao.capNhatSinhVien(sv));
        // System.out.println(svdao.xoaSinhVien("20001234"));
        // System.out.println(svdao.themSinhVien(sv));
        // List tmp= svdao.getDsSinhVien();
        // tmp.forEach(sv1 -> System.out.println(sv1));
        // lhdao.timSvTheoLop("DHKHMT16A").forEach(svtl-> System.out.println(svtl));
        // select LopHoc.malop,LopHoc.tenlop, count(SinhVien.maLop) as siso from LopHoc join SinhVien on LopHoc.malop=SinhVien.maLop group by LopHoc.malop,LopHoc.tenlop
//        Connection con = ConnectDB.getInstances().getConnection();
//        DAO_NhanVien daonv = new DAO_NhanVien();

        // System.out.println(dao_NhanVien.timNhanVien("0862462245"));
        // DC-0004529
        // DiaChi diachi=new DiaChi("Tỉnh Hải Dương", "Huyện Cẩm Giàng", "Xã Đức Chính");
        // String x=dao_DiaChi.timMaDC("Thành phố Cần Thơ", null, null);
        // NhanVien nv=new NhanVien("NVAA000102", "Nguyễn Đình Thanh", false, "0862462245", "123", true, true, "231351915", diachi);
        // System.out.println(dao_NhanVien.themNV(nv));
//       System.out.println(dao_NhanVien.xoaNhanVien("0945601416"));
        // System.out.println(dao_NhanVien.capNhatNhanVien(nv));
//        daonv.getDSNhanVien().forEach(nv-> System.out.println(nv));
//        DAO_Thuoc daot = new DAO_Thuoc();
//        daot.getDsThuoc().forEach(t-> System.out.println(t));
//        daot.getDsDangBaoChe().forEach(dbc->System.out.println(dbc));
//        daot.timKiemThuoc("Etomidate Lipuro").forEach(tkt->System.out.println(tkt));
//        DAO_KhachHang dao_KhachHang= new DAO_KhachHang();
//        System.out.println(dao_KhachHang.timKhachHang("0945601318"));
//        NhanVien nv=daonv.getLSDNone();
//        System.out.println(nv.getTenNV());
//        System.out.println(daot.getThuocTheoMa("DPAA000008"));
//        DAO_KhachHang daokh = new DAO_KhachHang();
//         daokh.getDsKhachHang().forEach(kh -> System.out.println(kh));
//        KhachHang kh= new KhachHang();
//        kh.setMaKH("KHAA000102");
//        kh.setTenKh("Nguyễn Đình Thanh");
//        kh.setGioiTinh(true);
//        kh.setSdt("0862462245");
//        kh.setTrangThai(true);
//        DiaChi dckh= new DiaChi("Thành phố Cần Thơ", "Huyện Cờ Đỏ", "Xã Trung Hưng");
//        kh.setDiaChi(dckh);
//        System.out.println(daokh.themKhachHang(kh));
//            System.out.println(daokh.xoaKhachHang("KHAA000102"));
//        System.out.println(daokh.capNhatKhachHang(kh));
//        System.out.println(daodc.getDSTinhTP());
//        System.out.println(daodc.getDsQuanHuyen("Tỉnh Nam Định"));
//        System.out.println(daodc.getDsPhuongXa("Tỉnh Nam Định", "Huyện Nam Trực"));

//        DAO_HoaDonBan daohdb = new DAO_HoaDonBan();
//        System.out.println(daohdb.taoMaNgauNhien())
//         System.out.println(daohdb.taoHoaDon("NVAA000102", "KHAA000007"));
//        daohdb.getDSHoaDonBan().forEach(t-> System.out.println(t));
//        dao.DAO_CT_HoaDonBan daocthdb = new DAO_CT_HoaDonBan();
//        System.out.println(daocthdb.giaTienTheoMaHD("BTAA000051"));
//        String sDate1 = "2022-11-21";
//        Date date1 = Date.valueOf(sDate1);
//        System.out.println(date1);
//        daohdb.timKiemHoaDon("", "", "", "", date1).forEach(sv -> System.out.println(sv));
////        SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy");
////        Date date = new Date(System.currentTimeMillis());
////        String ngayLapHoaDon=formatter.format(date);
////        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
////        Date startDate;
////        try {
////            startDate = (Date) df.parse(ngayLapHoaDon);
////            System.out.println(startDate);
//////            String newDateString = df.format(startDate);
//////            System.out.println(newDateString);    
////        } catch (ParseException e) {
////            e.printStackTrace();
////    }
//
////        System.out.println(sDate1 + "\t" + date1);
//        daonv.getLSDNTheoNV("NVAA000102").forEach(nv-> System.out.println(nv));
//    }
//}
