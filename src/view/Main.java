package view;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("-----Menu-----");
            System.out.println("1. Bệnh Án Thường");
            System.out.println("2. Bệnh Án VIP");
            System.out.println("0. Thoát ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    MenuBAT.showMenuBAT();
                case 2:
                    MenuBAV.showMenuBAV();
                case 0:
                    System.out.println("Exit Program");
                    break;
            }
        } while (choice != 0) ;
    }
}
