package controller;

import model.BenhAnThuong;
import storage.IRWFBenhAnThuong;
import storage.RWFBenhAnThuong;

import java.util.List;
import java.util.Scanner;

public class ManagerBAT {
    private static final Scanner scanner = new Scanner(System.in);
    private static final IRWFBenhAnThuong irwfBenhAnThuong = new RWFBenhAnThuong();
    private static final List<BenhAnThuong> benhAnThuongList = irwfBenhAnThuong.readFile();

    public static void themMoiBAT() {
        System.out.println("Nhập thông tin của BenhAnThuong mới:");
        System.out.print("Nhập STT: ");
        int stt = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhập mã bệnh án (BAXXX): ");
        String maBenhAn = scanner.nextLine();
        while (!maBenhAn.matches("BA\\d{3}")) {
            System.out.println("Mã bệnh án không hợp lệ. Vui lòng nhập lại (BAXXX): ");
            maBenhAn = scanner.nextLine();
        }
        System.out.print("Nhập mã bệnh nhân (BNXXX): ");
        String maBenhNhan = scanner.nextLine();
        while (!maBenhNhan.matches("BN\\d{3}")) {
            System.out.println("Mã bệnh nhân không hợp lệ. Vui lòng nhập lại (BNXXX): ");
            maBenhNhan = scanner.nextLine();
        }
        System.out.print("Nhập tên bệnh nhân: ");
        String tenBenhNhan = scanner.nextLine();
        System.out.print("Nhập ngày nhập viện: ");
        String ngayNhapVien = scanner.nextLine();
        System.out.print("Nhập ngày ra viện: ");
        String ngayRaVien = scanner.nextLine();
        System.out.print("Nhập lý do vào viện: ");
        String lyDoVaoVien = scanner.nextLine();
        System.out.print("Nhập Viện Phí: ");
        double vienPhi = Double.parseDouble(scanner.nextLine());
        BenhAnThuong benhAnThuong = new BenhAnThuong(stt, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoVaoVien, vienPhi);
        benhAnThuongList.add(benhAnThuong);
        irwfBenhAnThuong.writeFile(benhAnThuongList);
        System.out.println("Thêm mới bệnh án thường thành công.");
    }

    public static void xoaBAT() {
        if (benhAnThuongList.isEmpty()) {
            System.out.println("Danh sách Bệnh Án thường trống.");
        } else {
            System.out.println("Danh sách Bệnh Án thường:");
            for (BenhAnThuong benhAnThuong : benhAnThuongList) {
                System.out.println(benhAnThuong);
            }
            System.out.print("Nhập mã bệnh án cần xoá: ");
            String maBenhAnCanXoa = scanner.nextLine();
            BenhAnThuong benhAnCanXoa = null;
            for (BenhAnThuong benhAnThuong : benhAnThuongList) {
                if (benhAnThuong.getMaBenhAn().equalsIgnoreCase(maBenhAnCanXoa)) {
                    benhAnCanXoa = benhAnThuong;
                    break;
                }
            }

            if (benhAnCanXoa != null) {
                System.out.print("Bạn có chắc chắn muốn xoá bệnh án này? (Y/N): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    benhAnThuongList.remove(benhAnCanXoa);
                    irwfBenhAnThuong.writeFile(benhAnThuongList);
                    System.out.println("Xoá bệnh án thành công.");
                } else {
                    System.out.println("Đã hủy thao tác xoá bệnh án.");
                }
            } else {
                System.out.println("Không tìm thấy bệnh án có mã: " + maBenhAnCanXoa);
            }
        }
    }

    public static void xemDanhSachBAT() {
        if (benhAnThuongList.isEmpty()) {
            System.out.println("Danh sách Bệnh Án thường trống.");
        } else {
            System.out.println("Danh sách Bệnh Án thường:");
            for (BenhAnThuong benhAnThuong : benhAnThuongList) {
                System.out.println(benhAnThuong);
            }
        }
    }
}
