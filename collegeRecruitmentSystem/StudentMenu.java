package collegeRecruitmentSystem;

import java.util.List;
import java.util.Scanner;

public class StudentMenu {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentDAO studentDAO = new StudentDAO();

    public static void showMenu() {
        while (true) {
            System.out.println("----Student Menu----");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Edit Student");
            System.out.println("4. View Students");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    deleteStudent();
                    break;
                case 3:
                    editStudent();
                    break;
                case 4:
                    viewStudents();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter major: ");
        String major = scanner.nextLine();
        System.out.print("Enter graduation year: ");
        int graduationYear = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter resume: ");
        String resume = scanner.nextLine();
        Student student = new Student(0, name, email, major, graduationYear, resume);
        studentDAO.addStudent(student);
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID to delete: ");
        int studentID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        studentDAO.deleteStudent(studentID);
    }

    private static void editStudent() {
        System.out.print("Enter student ID to edit: ");
        int studentID = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();
        System.out.print("Enter new major: ");
        String major = scanner.nextLine();
        System.out.print("Enter new graduation year: ");
        int graduationYear = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new resume: ");
        String resume = scanner.nextLine();
        Student student = new Student(studentID, name, email, major, graduationYear, resume);
        studentDAO.updateStudent(student);
    }

    private static void viewStudents() {
        List<Student> students = studentDAO.getAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
