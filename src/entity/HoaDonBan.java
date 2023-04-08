package entity;

import dao.DAO_CT_HoaDonBan;
import java.sql.Date;
import java.util.ArrayList;

public class HoaDonBan {

    private String maHoaDonBan;
    private Date ngayLapHD;
    private NhanVien nv;
    private KhachHang kh;

    public HoaDonBan(String maHoaDonBan, Date ngayLapHD, NhanVien nv, KhachHang kh) {
        this.maHoaDonBan = maHoaDonBan;
        this.ngayLapHD = ngayLapHD;
        this.nv = nv;
        this.kh = kh;
    }

    public HoaDonBan(String maHoaDonBan, Date ngayLapHD, KhachHang kh) {
        this.maHoaDonBan = maHoaDonBan;
        this.ngayLapHD = ngayLapHD;
        this.kh = kh;
    }

    public HoaDonBan(String maHoaDonBan) {
        this.maHoaDonBan = maHoaDonBan;
    }

    public HoaDonBan() {
    }

    public String getMaHoaDonBan() {
        return maHoaDonBan;
    }

    public void setMaHoaDonBan(String maHoaDonBan) {
        this.maHoaDonBan = maHoaDonBan;
    }

    public Date getNgayLapHD() {
        return ngayLapHD;
    }

    public void setNgayLapHD(Date ngayLapHD) {
        this.ngayLapHD = ngayLapHD;
    }

    public NhanVien getNv() {
        return nv;
    }

    public void setNv(NhanVien nv) {
        this.nv = nv;
    }

    public KhachHang getKh() {
        return kh;
    }

    public void setKh(KhachHang kh) {
        this.kh = kh;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maHoaDonBan == null) ? 0 : maHoaDonBan.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        HoaDonBan other = (HoaDonBan) obj;
        if (maHoaDonBan == null) {
            if (other.maHoaDonBan != null) {
                return false;
            }
        } else if (!maHoaDonBan.equals(other.maHoaDonBan)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HoaDonBan [maHoaDonBan=" + maHoaDonBan + ", ngayLapHD=" + ngayLapHD + ", nv=" + nv + ", kh=" + kh + "]";
    }

    public double tongTien() {
        DAO_CT_HoaDonBan ctHoaDon_dao = new DAO_CT_HoaDonBan();
        ArrayList<CT_HoaDonBan> list = ctHoaDon_dao.getDSCT_HdByMaHD(this.maHoaDonBan);
        double tt = 0;
        for (CT_HoaDonBan t : list) {
            tt += t.thanhTien();
        }
        return tt;
    }
}
