package view;

import controller.ManagerBAT;

import java.util.Scanner;

public class MenuBAT {
    public static void showMenuBAT() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("-----Bệnh Án Thường-----");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xoá");
            System.out.println("3. Danh Sách");
            System.out.println("4. Thoát");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    ManagerBAT.themMoiBAT();
                    break;
                case 2:
                    ManagerBAT.xoaBAT();
                    break;
                case 3:
                    ManagerBAT.xemDanhSachBAT();
                    break;
                case 4:
                    System.out.println("Exit Program");
                    break;
                default:
                    System.out.println("Try Enter Again!");
                    break;
            }
        } while (choice != 0);
    }
}