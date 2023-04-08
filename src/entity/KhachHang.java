package entity;

public class KhachHang {
    private String maKH;
    private String tenKh;
    private boolean gioiTinh;
    private String sdt;
    private DiaChi diaChi;
    private boolean trangThai;
    
    public KhachHang() {
    }
    public KhachHang(String maKH, String tenKh, boolean gioiTinh, String sdt, DiaChi diaChi, boolean trangThai) {
        this.maKH = maKH;
        this.tenKh = tenKh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }
    public KhachHang(String maKH, String tenKh) {
        this.maKH = maKH;
        this.tenKh = tenKh;
    }
    public String getMaKH() {
        return maKH;
    }
    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }
    public String getTenKh() {
        return tenKh;
    }
    public void setTenKh(String tenKh) {
        this.tenKh = tenKh;
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
    public DiaChi getDiaChi() {
        return diaChi;
    }
    public void setDiaChi(DiaChi diaChi) {
        this.diaChi = diaChi;
    }
    public boolean isTrangThai() {
        return trangThai;
    }
    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maKH == null) ? 0 : maKH.hashCode());
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
        KhachHang other = (KhachHang) obj;
        if (maKH == null) {
            if (other.maKH != null)
                return false;
        } else if (!maKH.equals(other.maKH))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return "KhachHang [maKH=" + maKH + ", tenKh=" + tenKh + ", gioiTinh=" + (gioiTinh?"Nam":"Nữ") + ", sdt=" + sdt + ", diaChi="
                + diaChi + ", trangThai=" + trangThai + "]";
    }

    

}
