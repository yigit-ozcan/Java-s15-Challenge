package librarysystem.app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Library System ===");
        System.out.println("1. Show all books");
        System.out.println("2. Show my books");
        System.out.println("3. Borrow book");
        System.out.println("4. Return book");
        System.out.println("5. Pay bill");
        System.out.println("0. Exit");
        System.out.print("Select an option: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Show all books selected");
                break;
            case 2:
                System.out.println("Show my books selected");
                break;
            case 3:
                System.out.println("Borrow book selected");
                break;
            case 4:
                System.out.println("Return book selected");
                break;
            case 5:
                System.out.println("Pay bill selected");
                break;
            case 0:
                System.out.println("Exit selected");
                break;
            default:
                System.out.println("Invalid option");
        }
    }
}
