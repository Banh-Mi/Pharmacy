package entity;

import java.sql.Date;

public class Thuoc {
    private String maThuoc;
    private String tenThuoc;
    private double giaBan;
    private String donViTinh;
    private String thanhPhan;
    private String quyCachDongGoi;
    private String dangBaoChe;
    private String hamLuong;
    private String cTySanXuat;
    private String nuocSanXuat;
    private boolean trangThaiKD;
    private float thueVAT;
    private String soDK;
    private CongDung congDung;
    private long soLuongBanDau;
    private Date hanSuDung;

    public String getNuocSanXuat() {
        return nuocSanXuat;
    }

    public void setNuocSanXuat(String nuocSanXuat) {
        this.nuocSanXuat = nuocSanXuat;
    }

    public String getHamLuong() {
        return hamLuong;
    }

    public void setHamLuong(String hamLuong) {
        this.hamLuong = hamLuong;
    }

    public String getMaThuoc() {
        return maThuoc;
    }
    public void setMaThuoc(String maThuoc) {
        this.maThuoc = maThuoc;
    }
    public String getTenThuoc() {
        return tenThuoc;
    }
    public void setTenThuoc(String tenThuoc) {
        this.tenThuoc = tenThuoc;
    }
    public double getGiaBan() {
        return giaBan;
    }
    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }
    public String getDonViTinh() {
        return donViTinh;
    }
    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }
    public String getThanhPhan() {
        return thanhPhan;
    }
    public void setThanhPhan(String thanhPhan) {
        this.thanhPhan = thanhPhan;
    }
    public String getQuyCachDongGoi() {
        return quyCachDongGoi;
    }
    public void setQuyCachDongGoi(String quyCachDongGoi) {
        this.quyCachDongGoi = quyCachDongGoi;
    }
    public String getDangBaoChe() {
        return dangBaoChe;
    }
    public void setDangBaoChe(String dangBaoChe) {
        this.dangBaoChe = dangBaoChe;
    }
    public String getcTySanXuat() {
        return cTySanXuat;
    }
    public void setcTySanXuat(String cTySanXuat) {
        this.cTySanXuat = cTySanXuat;
    }
    public boolean isTrangThaiKD() {
        return trangThaiKD;
    }
    public void setTrangThaiKD(boolean trangThaiKD) {
        this.trangThaiKD = trangThaiKD;
    }
    public float getThueVAT() {
        return thueVAT;
    }
    public void setThueVAT(float thueVAT) {
        this.thueVAT = thueVAT;
    }
    public String getSoDK() {
        return soDK;
    }
    public void setSoDK(String soDK) {
        this.soDK = soDK;
    }
    public CongDung getCongDung() {
        return congDung;
    }
    public void setCongDung(CongDung congDung) {
        this.congDung = congDung;
    }
    public long getSoLuongBanDau() {
        return soLuongBanDau;
    }
    public void setSoLuongBanDau(long soLuongBanDau) {
        this.soLuongBanDau = soLuongBanDau;
    }
    public Date getHanSuDung() {
        return hanSuDung;
    }
    public void setHanSuDung(Date hanSuDung) {
        this.hanSuDung = hanSuDung;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maThuoc == null) ? 0 : maThuoc.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Thuoc other = (Thuoc) obj;
        if (maThuoc == null) {
            if (other.maThuoc != null)
                return false;
        } else if (!maThuoc.equals(other.maThuoc))
            return false;
        return true;
    }
    
    public Thuoc() {
    }

    public Thuoc(String maThuoc, String tenThuoc, double giaBan, String donViTinh, String thanhPhan, String quyCachDongGoi, String dangBaoChe, String hamLuong, String cTySanXuat, String nuocSanXuat, boolean trangThaiKD, float thueVAT, String soDK, CongDung congDung, long soLuongBanDau, Date hanSuDung) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.giaBan = giaBan;
        this.donViTinh = donViTinh;
        this.thanhPhan = thanhPhan;
        this.quyCachDongGoi = quyCachDongGoi;
        this.dangBaoChe = dangBaoChe;
        this.hamLuong = hamLuong;
        this.cTySanXuat = cTySanXuat;
        this.nuocSanXuat = nuocSanXuat;
        this.trangThaiKD = trangThaiKD;
        this.thueVAT = thueVAT;
        this.soDK = soDK;
        this.congDung = congDung;
        this.soLuongBanDau = soLuongBanDau;
        this.hanSuDung = hanSuDung;
    }
    
    
    public Thuoc(String maThuoc, String tenThuoc, double giaBan, String donViTinh, String thanhPhan,
            String quyCachDongGoi, String dangBaoChe, String hamLuong,String cTySanXuat, boolean trangThaiKD, float thueVAT,
            String soDK, CongDung congDung, long soLuongBanDau, Date hanSuDung) {
        this.maThuoc = maThuoc;
        this.tenThuoc = tenThuoc;
        this.giaBan = giaBan;
        this.donViTinh = donViTinh;
        this.thanhPhan = thanhPhan;
        this.quyCachDongGoi = quyCachDongGoi;
        this.dangBaoChe = dangBaoChe;
        this.hamLuong=hamLuong;
        this.cTySanXuat = cTySanXuat;
        this.trangThaiKD = trangThaiKD;
        this.thueVAT = thueVAT;
        this.soDK = soDK;
        this.congDung = congDung;
        this.soLuongBanDau = soLuongBanDau;
        this.hanSuDung = hanSuDung;
    }

    public Thuoc(String tenThuoc, double giaBan, String donViTinh, String thanhPhan, String dangBaoChe, CongDung congDung, long soLuongBanDau, Date hanSuDung) {
        this.tenThuoc = tenThuoc;
        this.giaBan = giaBan;
        this.donViTinh = donViTinh;
        this.thanhPhan = thanhPhan;
        this.dangBaoChe = dangBaoChe;
        this.congDung = congDung;
        this.soLuongBanDau = soLuongBanDau;
        this.hanSuDung = hanSuDung;
    }

    public Thuoc(String tenThuoc, double giaBan, String donViTinh, String thanhPhan, String dangBaoChe, String hamLuong, CongDung congDung, long soLuongBanDau, Date hanSuDung) {
        this.tenThuoc = tenThuoc;
        this.giaBan = giaBan;
        this.donViTinh = donViTinh;
        this.thanhPhan = thanhPhan;
        this.dangBaoChe = dangBaoChe;
        this.hamLuong = hamLuong;
        this.congDung = congDung;
        this.soLuongBanDau = soLuongBanDau;
        this.hanSuDung = hanSuDung;
    }
    
    
    public double tongtien()
    {
        return soLuongBanDau*(1+thueVAT)*giaBan;
    }
    
    public int tongSoLuong()
    {
        return 0;
    }

//    @Override
//    public String toString() {
//        return "Thuoc [maThuoc=" + maThuoc + ", tenThuoc=" + tenThuoc + ", giaBan=" + giaBan + ", donViTinh="
//                + donViTinh + ", thanhPhan=" + thanhPhan + ", quyCachDongGoi=" + quyCachDongGoi + ", dangBaoChe="
//                + dangBaoChe + ", cTySanXuat=" + cTySanXuat + ", trangThaiKD=" + trangThaiKD + ", thueVAT=" + thueVAT
//                + ", soDK=" + soDK + ", nhomCongDung=" + congDung.getMaCongDung() + ", soLuongBanDau=" + soLuongBanDau + ", hanSuDung="
//                + hanSuDung + "]";
//    }

    public Thuoc(String maThuoc,String tenThuoc, double giaBan, String hamLuong, float thueVAT, long soLuongBanDau) {
        this.maThuoc= maThuoc;
        this.tenThuoc = tenThuoc;
        this.giaBan = giaBan;
        this.hamLuong = hamLuong;
        this.thueVAT = thueVAT;
        this.soLuongBanDau = soLuongBanDau;
}

    @Override
    public String toString() {
        return "Thuoc{" + "maThuoc=" + maThuoc + ", tenThuoc=" + tenThuoc + ", giaBan=" + giaBan + ", donViTinh=" + donViTinh + ", thanhPhan=" + thanhPhan + ", quyCachDongGoi=" + quyCachDongGoi + ", dangBaoChe=" + dangBaoChe + ", hamLuong=" + hamLuong + ", cTySanXuat=" + cTySanXuat + ", trangThaiKD=" + trangThaiKD + ", thueVAT=" + thueVAT + ", soDK=" + soDK + ", congDung=" + congDung + ", soLuongBanDau=" + soLuongBanDau + ", hanSuDung=" + hanSuDung + '}';
    }

   
}
