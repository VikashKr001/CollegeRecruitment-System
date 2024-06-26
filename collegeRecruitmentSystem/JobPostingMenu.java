package collegeRecruitmentSystem;

import java.util.List;
import java.util.Scanner;

public class JobPostingMenu {
    private static Scanner scanner = new Scanner(System.in);
    private static JobPostingDAO jobPostingDAO = new JobPostingDAO();

    public static void showMenu() {
        while (true) {
            System.out.println("----Job Posting Menu----");
            System.out.println("1. Add Job Posting");
            System.out.println("2. Delete Job Posting");
            System.out.println("3. Edit Job Posting");
            System.out.println("4. View Job Postings");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    addJobPosting();
                    break;
                case 2:
                    deleteJobPosting();
                    break;
                case 3:
                    editJobPosting();
                    break;
                case 4:
                    viewJobPostings();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addJobPosting() {
        System.out.print("Enter company ID: ");
        int companyID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter job title: ");
        String jobTitle = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter requirements: ");
        String requirements = scanner.nextLine();
        System.out.print("Enter application deadline (yyyy-mm-dd): ");
        String applicationDeadline = scanner.nextLine();
        JobPosting jobPosting = new JobPosting(0, companyID, jobTitle, description, requirements, java.sql.Date.valueOf(applicationDeadline));
        jobPostingDAO.addJobPosting(jobPosting);
    }

    private static void deleteJobPosting() {
        System.out.print("Enter job ID to delete: ");
        int jobID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        jobPostingDAO.deleteJobPosting(jobID);
    }

    private static void editJobPosting() {
        System.out.print("Enter job ID to edit: ");
        int jobID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new company ID: ");
        int companyID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new job title: ");
        String jobTitle = scanner.nextLine();
        System.out.print("Enter new description: ");
        String description = scanner.nextLine();
        System.out.print("Enter new requirements: ");
        String requirements = scanner.nextLine();
        System.out.print("Enter new application deadline (yyyy-mm-dd): ");
        String applicationDeadline = scanner.nextLine();
        JobPosting jobPosting = new JobPosting(jobID, companyID, jobTitle, description, requirements, java.sql.Date.valueOf(applicationDeadline));
        jobPostingDAO.updateJobPosting(jobPosting);
    }

    private static void viewJobPostings() {
        List<JobPosting> jobPostings = jobPostingDAO.getAllJobPostings();
        for (JobPosting jobPosting : jobPostings) {
            System.out.println(jobPosting);
        }
    }
}
