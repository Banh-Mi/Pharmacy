package entity;

public class CongDung {
    private String maCongDung;
    private String nhomCongDung;
    private String congDung;
    public CongDung() {
    }
    public CongDung(String maCongDung, String nhomCongDung, String congDung) {
        this.maCongDung = maCongDung;
        this.nhomCongDung = nhomCongDung;
        this.congDung = congDung;
    }
    public CongDung(String maCongDung) {
        this.maCongDung = maCongDung;
    }
    public String getMaCongDung() {
        return maCongDung;
    }
    public void setMaCongDung(String maCongDung) {
        this.maCongDung = maCongDung;
    }
    public String getNhomCongDung() {
        return nhomCongDung;
    }
    public void setNhomCongDung(String nhomCongDung) {
        this.nhomCongDung = nhomCongDung;
    }
    public String getCongDung() {
        return congDung;
    }
    public void setCongDung(String congDung) {
        this.congDung = congDung;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((maCongDung == null) ? 0 : maCongDung.hashCode());
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
        CongDung other = (CongDung) obj;
        if (maCongDung == null) {
            if (other.maCongDung != null)
                return false;
        } else if (!maCongDung.equals(other.maCongDung))
            return false;
        return true;
    }
    
    
    @Override
    public String toString() {
        return "CongDung [maCongDung=" + maCongDung + ", nhomCongDung=" + nhomCongDung + ", congDung=" + congDung + "]";
    }

    
}
