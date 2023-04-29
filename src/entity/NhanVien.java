package entity;

public class NhanVien {

    private String maNV;
    private String tenNV;
    private boolean gioiTinh;
    private String sdt;
    private String matKhau;
    private boolean trangThaiLam;
    private boolean loaiNhanVien;
    private String cmnd;
    private String diaChi;

    public NhanVien() {
    }

    public NhanVien(String maNV, String tenNV) {
        this.maNV = maNV;
        this.tenNV = tenNV;
    }

    public NhanVien(String maNV, String tenNV, boolean gioiTinh, String sdt, String matKhau, boolean trangThaiLam,
            boolean loaiNhanVien, String cmnd, String diaChi) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.trangThaiLam = trangThaiLam;
        this.loaiNhanVien = loaiNhanVien;
        this.cmnd = cmnd;
        this.diaChi = diaChi;
    }

    public NhanVien(String tenNV, boolean gioiTinh, String sdt, boolean trangThaiLam, String cmnd, String diaChi) {
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.trangThaiLam = trangThaiLam;
        this.cmnd = cmnd;
        this.diaChi = diaChi;
    }

    public NhanVien(String maNV, String tenNV, boolean gioiTinh, String sdt, boolean loaiNhanVien) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.loaiNhanVien = loaiNhanVien;
    }

    public NhanVien(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean isTrangThaiLam() {
        return trangThaiLam;
    }

    public void setTrangThaiLam(boolean trangThaiLam) {
        this.trangThaiLam = trangThaiLam;
    }

    public boolean isLoaiNhanVien() {
        return loaiNhanVien;
    }

    public void setLoaiNhanVien(boolean loaiNhanVien) {
        this.loaiNhanVien = loaiNhanVien;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
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
        NhanVien other = (NhanVien) obj;
        if (maNV == null) {
            if (other.maNV != null) {
                return false;
            }
        } else if (!maNV.equals(other.maNV)) {
            return false;
        }
        return true;
    }
//    @Override
////
//    public String toString() {
//        return "NhanVien [tenNV=" + tenNV + ", gioiTinh=" + (gioiTinh==false?"Nữ":"Nam") + ", sdt=" + sdt + ", trangThaiLam=" + (trangThaiLam==true?"Đang làm":"Nghỉ") + ", cmnd=" + cmnd + ", thanhPho=" + diaChi.getTinhTP() +  ", quanHuyen=" + diaChi.getQuanHuyen() +  ", phuongXa=" + diaChi.getPhuongXa() + "]";
//    }

    // @Override
    // public String toString() {
    //     return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", gioiTinh=" + (gioiTinh==false?"Nữ":"Nam") + ", sdt=" + sdt + ", matKhau="
    //             + matKhau + ", trangThaiLam=" + trangThaiLam + ", loaiNhanVien=" + loaiNhanVien + ", cmnd=" + cmnd
    //             + ", diaChi=" + diaChi + "]";
    // }
    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", tenNV=" + tenNV + ", gioiTinh=" + gioiTinh + ", sdt=" + sdt + ", trangThaiLam=" + trangThaiLam + ", loaiNhanVien=" + loaiNhanVien + ", cmnd=" + cmnd + ", diaChi=" + diaChi + '}';
    }

}
