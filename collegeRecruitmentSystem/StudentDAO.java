package collegeRecruitmentSystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/CollegeRecruitment";
    private static final String USER = "root";
    private static final String PASSWORD = "vikash";

    public void addStudent(Student student) {
        String sql = "INSERT INTO Students (Name, Email, Major, GraduationYear, Resume) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getMajor());
            stmt.setInt(4, student.getGraduationYear());
            stmt.setString(5, student.getResume());
            stmt.executeUpdate();
            System.out.println("Student added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int studentID) {
        String sql = "DELETE FROM Students WHERE StudentID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, studentID);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student deleted successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {
        String sql = "UPDATE Students SET Name = ?, Email = ?, Major = ?, GraduationYear = ?, Resume = ? WHERE StudentID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getEmail());
            stmt.setString(3, student.getMajor());
            stmt.setInt(4, student.getGraduationYear());
            stmt.setString(5, student.getResume());
            stmt.setInt(6, student.getStudentID());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Student updated successfully.");
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM Students";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int studentID = rs.getInt("StudentID");
                String name = rs.getString("Name");
                String email = rs.getString("Email");
                String major = rs.getString("Major");
                int graduationYear = rs.getInt("GraduationYear");
                String resume = rs.getString("Resume");
                students.add(new Student(studentID, name, email, major, graduationYear, resume));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
