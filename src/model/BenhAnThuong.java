package model;

import java.io.Serializable;

public class BenhAnThuong extends BenhAn implements Serializable {
    private double phiNamVien;

    public BenhAnThuong(int stt, String maBenhAn, String maBenhNhan, String tenBenhNhan, String ngayNhapVien, String ngayRaVien, String lyDoVaoVien, double phiNamVien) {
        super(stt, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoVaoVien);
        this.phiNamVien = phiNamVien;
    }

    public double getPhiNamVien() {
        return phiNamVien;
    }

    public void setPhiNamVien(double phiNamVien) {
        this.phiNamVien = phiNamVien;
    }

    @Override
    public double tinhPhiNamVien() {
        return phiNamVien;
    }
}
