package view;

import controller.ManagerBAV;

import java.util.Scanner;

public class MenuBAV {
    public static void showMenuBAV() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("-----Bệnh Án VIP-----");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xoá");
            System.out.println("3. Danh Sách");
            System.out.println("4. Thoát");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    ManagerBAV.themMoiBAV();
                    break;
                case 2:
                    ManagerBAV.themMoiBAV();
                    break;
                case 3:
                    ManagerBAV.xemDanhSachBAV();
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