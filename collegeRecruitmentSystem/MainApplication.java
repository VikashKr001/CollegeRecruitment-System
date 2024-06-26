package collegeRecruitmentSystem;

import java.util.Scanner;

public class MainApplication {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            showMainMenu();
        }
    }

    private static void showMainMenu() {
        System.out.println("Select with what you want to work:");
        System.out.println("1. Company");
        System.out.println("2. Job Posting");
        System.out.println("3. Student");
        System.out.println("4. Application");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        switch (choice) {
            case 1:
                CompanyMenu.showMenu();
                break;
            case 2:
                JobPostingMenu.showMenu();
                break;
            case 3:
                StudentMenu.showMenu();
                break;
            case 4:
                ApplicationMenu.showMenu();
                break;
            case 5:
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }
}
