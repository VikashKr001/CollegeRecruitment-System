package collegeRecruitmentSystem;

import java.util.List;
import java.util.Scanner;

public class ApplicationMenu {
    private static Scanner scanner = new Scanner(System.in);
    private static ApplicationDAO applicationDAO = new ApplicationDAO();

    public static void showMenu() {
        while (true) {
            System.out.println("----Application Menu----");
            System.out.println("1. Add Application");
            System.out.println("2. Delete Application");
            System.out.println("3. Edit Application");
            System.out.println("4. View Applications");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    addApplication();
                    break;
                case 2:
                    deleteApplication();
                    break;
                case 3:
                    editApplication();
                    break;
                case 4:
                    viewApplications();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addApplication() {
        System.out.print("Enter job ID: ");
        int jobID = scanner.nextInt();
        System.out.print("Enter student ID: ");
        int studentID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter application date (yyyy-mm-dd): ");
        String applicationDate = scanner.nextLine();
        System.out.print("Enter status: ");
        String status = scanner.nextLine();
        Application application = new Application(0, jobID, studentID, java.sql.Date.valueOf(applicationDate), status);
        applicationDAO.addApplication(application);
    }

    private static void deleteApplication() {
        System.out.print("Enter application ID to delete: ");
        int applicationID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        applicationDAO.deleteApplication(applicationID);
    }

    private static void editApplication() {
        System.out.print("Enter application ID to edit: ");
        int applicationID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new job ID: ");
        int jobID = scanner.nextInt();
        System.out.print("Enter new student ID: ");
        int studentID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new application date (yyyy-mm-dd): ");
        String applicationDate = scanner.nextLine();
        System.out.print("Enter new status: ");
        String status = scanner.nextLine();
        Application application = new Application(applicationID, jobID, studentID, java.sql.Date.valueOf(applicationDate), status);
        applicationDAO.updateApplication(application);
    }

    private static void viewApplications() {
        List<Application> applications = applicationDAO.getAllApplications();
        for (Application application : applications) {
            System.out.println(application);
        }
    }
}
