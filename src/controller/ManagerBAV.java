package controller;

import model.BenhAnThuong;
import model.BenhAnVIP;
import storage.IRWFBenhAnThuong;
import storage.IRWFBenhAnVIP;
import storage.RWFBenhAnThuong;
import storage.RWFBenhAnVIP;

import java.util.List;
import java.util.Scanner;

public class ManagerBAV {
    private static IRWFBenhAnVIP rwfBenhAnVIP = new RWFBenhAnVIP();
    private static List<BenhAnVIP> benhAnVIPList = rwfBenhAnVIP.readFile();
    private static Scanner scanner = new Scanner(System.in);

    public static void themMoiBAV() {
        System.out.println("Nhập thông tin của BenhAnVIP mới:");
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
        System.out.println("Chọn loại VIP (nhập số tương ứng):");
        System.out.println("1. VIPI");
        System.out.println("2. VIPII");
        System.out.println("3. VIPIII");
        System.out.print("Chọn loại VIP: ");
        int choice = Integer.parseInt(scanner.nextLine());
        String loaiVIP;
        switch (choice) {
            case 1:
                loaiVIP = "VIPI";
                break;
            case 2:
                loaiVIP = "VIPII";
                break;
            case 3:
                loaiVIP = "VIPIII";
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ. Mặc định sẽ chọn VIPI.");
                loaiVIP = "VIPI";
                break;
        }
        System.out.print("Nhập thời hạn VIP (dd/mm/yyyy): ");
        String thoiHanVIP = scanner.nextLine();
        BenhAnVIP benhAnVIP = new BenhAnVIP(stt, maBenhAn, maBenhNhan, tenBenhNhan, ngayNhapVien, ngayRaVien, lyDoVaoVien, loaiVIP, thoiHanVIP);
        benhAnVIPList.add(benhAnVIP);
        rwfBenhAnVIP.writeFile(benhAnVIPList);
        System.out.println("Thêm mới bệnh án VIP thành công.");
    }

    public static void xoaBAV() {
        List<BenhAnVIP> listBAV = rwfBenhAnVIP.readFile();
        if (listBAV.isEmpty()) {
            System.out.println("Danh sách Bệnh Án VIP trống.");
        } else {
            System.out.println("Danh sách Bệnh Án VIP:");
            for (BenhAnVIP benhAnVIP : listBAV) {
                System.out.println(benhAnVIP);
            }
            System.out.print("Nhập mã bệnh án cần xoá: ");
            String maBenhAnCanXoa = scanner.nextLine();
            BenhAnVIP benhAnCanXoa = null;
            for (BenhAnVIP benhAnVIP : listBAV) {
                if (benhAnVIP.getMaBenhAn().equalsIgnoreCase(maBenhAnCanXoa)) {
                    benhAnCanXoa = benhAnVIP;
                    break;
                }
            }

            if (benhAnCanXoa != null) {
                System.out.print("Bạn có chắc chắn muốn xoá bệnh án này? (Y/N): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    listBAV.remove(benhAnCanXoa);
                    rwfBenhAnVIP.writeFile(listBAV);
                    System.out.println("Xoá bệnh án thành công.");
                } else {
                    System.out.println("Đã hủy thao tác xoá bệnh án.");
                }
            } else {
                System.out.println("Không tìm thấy bệnh án có mã: " + maBenhAnCanXoa);
            }
        }
    }
    public static void xemDanhSachBAV() {
        List<BenhAnVIP> listBAV = rwfBenhAnVIP.readFile();
        if (listBAV.isEmpty()) {
            System.out.println("Danh sách Bệnh Án VIP trống.");
        } else {
            System.out.println("Danh sách Bệnh Án VIP:");
            for (BenhAnVIP benhAnVIP : listBAV) {
                System.out.println(benhAnVIP);
            }
        }
    }
}