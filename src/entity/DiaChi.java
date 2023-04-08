package entity;

public class DiaChi {

    private String maDC;
    private String tinhTP;
    private String quanHuyen;
    private String phuongXa;

    public DiaChi() {
    }

    public DiaChi(String maDC, String tinhTP, String quanHuyen, String phuongXa) {
        this.maDC = maDC;
        this.tinhTP = tinhTP;
        this.quanHuyen = quanHuyen;
        this.phuongXa = phuongXa;
    }

    public DiaChi(String tinhTP, String quanHuyen, String phuongXa) {
        this.tinhTP = tinhTP;
        this.quanHuyen = quanHuyen;
        this.phuongXa = phuongXa;
    }

    public DiaChi(String maDC) {
        this.maDC = maDC;
    }

    public String getMaDC() {
        return maDC;
    }

    public void setMaDC(String maDC) {
        this.maDC = maDC;
    }

    public String getTinhTP() {
        return tinhTP;
    }

    public void setTinhTP(String tinhTP) {
        this.tinhTP = tinhTP;
    }

    public String getQuanHuyen() {
        return quanHuyen;
    }

    public void setQuanHuyen(String quanHuyen) {
        this.quanHuyen = quanHuyen;
    }

    public String getPhuongXa() {
        return phuongXa;
    }

    public void setPhuongXa(String phuongXa) {
        this.phuongXa = phuongXa;
    }

    @Override
    public String toString() {
        return "DiaChi [maDC=" + maDC + ", tinhTP=" + tinhTP + ", quanHuyen=" + quanHuyen + ", phuongXa=" + phuongXa
                + "]";
    }

}
