package entity;

public class CT_HoaDonBan {

    private int soLuong;
    private double giaBan;
    private Thuoc thuoc;
    private HoaDonBan hoaDonBan;
    private float vat;

    public CT_HoaDonBan() {
    }

    public CT_HoaDonBan(int soLuong, double giaBan, Thuoc thuoc, HoaDonBan hoaDonBan, float vat) {
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.thuoc = thuoc;
        this.hoaDonBan = hoaDonBan;
        this.vat = vat;
    }

    public CT_HoaDonBan(int soLuong, double giaBan, Thuoc thuoc, float vat) {
        this.soLuong = soLuong;
        this.giaBan = giaBan;
        this.thuoc = thuoc;
        this.vat = vat;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(double giaBan) {
        this.giaBan = giaBan;
    }

    public Thuoc getThuoc() {
        return thuoc;
    }

    public void setThuoc(Thuoc thuoc) {
        this.thuoc = thuoc;
    }

    public HoaDonBan getHoaDonBan() {
        return hoaDonBan;
    }

    public void setHoaDonBan(HoaDonBan hoaDonBan) {
        this.hoaDonBan = hoaDonBan;
    }

    public float getVat() {
        return vat;
    }

    public void setVat(float vat) {
        this.vat = vat;
    }

    public double thanhTien() {
        return (this.giaBan * (1 + this.vat) * this.soLuong);
    }

    @Override
    public String toString() {
        return "CT_HoaDonBan [soLuong=" + soLuong + ", giaBan=" + giaBan + ", thuoc=" + thuoc + ", hoaDonBan="
                + hoaDonBan + ", vat=" + vat + "]";
    }
}
