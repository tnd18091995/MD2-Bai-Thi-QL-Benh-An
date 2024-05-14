package model;

public class BenhAnVIP extends BenhAn {
    private String loaiVIP;
    private String thoiHanVIP;

    public BenhAnVIP(int stt, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoVaoVien, String loaiVIP, String thoiHanVIP) {
        super(stt, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoVaoVien);
        this.loaiVIP = loaiVIP;
        this.thoiHanVIP = thoiHanVIP;
    }

    public String getLoaiVIP() {
        return loaiVIP;
    }

    public void setLoaiVIP(String loaiVIP) {
        this.loaiVIP = loaiVIP;
    }

    public String getThoiHanVIP() {
        return thoiHanVIP;
    }

    public void setThoiHanVIP(String thoiHanVIP) {
        this.thoiHanVIP = thoiHanVIP;
    }

    @Override
    public double tinhPhiNamVien() {
        double phiBanDau = 100;
        switch (loaiVIP) {
            case "VIP":
                return phiBanDau * 0.6;
            case "VIPI":
                return phiBanDau * 0.7;
            case "VIPII":
                return phiBanDau * 0.8;
            default:
                return phiBanDau;
        }
    }
}
