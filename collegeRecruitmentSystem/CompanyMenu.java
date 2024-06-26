package collegeRecruitmentSystem;

import java.util.List;
import java.util.Scanner;

public class CompanyMenu {
    private static Scanner scanner = new Scanner(System.in);
    private static CompanyDAO companyDAO = new CompanyDAO();

    public static void showMenu() {
        while (true) {
            System.out.println("----Company Menu----");
            System.out.println("1. Add Company");
            System.out.println("2. Delete Company");
            System.out.println("3. Edit Company");
            System.out.println("4. View Companies");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    addCompany();
                    break;
                case 2:
                    deleteCompany();
                    break;
                case 3:
                    editCompany();
                    break;
                case 4:
                    viewCompanies();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addCompany() {
        System.out.print("Enter company name: ");
        String companyName = scanner.nextLine();
        System.out.print("Enter industry: ");
        String industry = scanner.nextLine();
        System.out.print("Enter contact info: ");
        String contactInfo = scanner.nextLine();
        Company company = new Company(0, companyName, industry, contactInfo);
        companyDAO.addCompany(company);
    }

    private static void deleteCompany() {
        System.out.print("Enter company ID to delete: ");
        int companyID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        companyDAO.deleteCompany(companyID);
    }

    private static void editCompany() {
        System.out.print("Enter company ID to edit: ");
        int companyID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new company name: ");
        String companyName = scanner.nextLine();
        System.out.print("Enter new industry: ");
        String industry = scanner.nextLine();
        System.out.print("Enter new contact info: ");
        String contactInfo = scanner.nextLine();
        Company company = new Company(companyID, companyName, industry, contactInfo);
        companyDAO.updateCompany(company);
    }

    private static void viewCompanies() {
        List<Company> companies = companyDAO.getAllCompanies();
        for (Company company : companies) {
            System.out.println(company);
        }
    }
}
