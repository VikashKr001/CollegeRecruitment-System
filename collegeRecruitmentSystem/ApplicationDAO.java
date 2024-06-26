package collegeRecruitmentSystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/CollegeRecruitment";
    private static final String USER = "root";
    private static final String PASSWORD = "vikash";

    public void addApplication(Application application) {
        String sql = "INSERT INTO Applications (JobID, StudentID, ApplicationDate, Status) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, application.getJobID());
            stmt.setInt(2, application.getStudentID());
            stmt.setDate(3, application.getApplicationDate());
            stmt.setString(4, application.getStatus());
            stmt.executeUpdate();
            System.out.println("Application added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteApplication(int applicationID) {
        String sql = "DELETE FROM Applications WHERE ApplicationID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, applicationID);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Application deleted successfully.");
            } else {
                System.out.println("Application not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateApplication(Application application) {
        String sql = "UPDATE Applications SET JobID = ?, StudentID = ?, ApplicationDate = ?, Status = ? WHERE ApplicationID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, application.getJobID());
            stmt.setInt(2, application.getStudentID());
            stmt.setDate(3, application.getApplicationDate());
            stmt.setString(4, application.getStatus());
            stmt.setInt(5, application.getApplicationID());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Application updated successfully.");
            } else {
                System.out.println("Application not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Application> getAllApplications() {
        List<Application> applications = new ArrayList<>();
        String sql = "SELECT * FROM Applications";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int applicationID = rs.getInt("ApplicationID");
                int jobID = rs.getInt("JobID");
                int studentID = rs.getInt("StudentID");
                Date applicationDate = rs.getDate("ApplicationDate");
                String status = rs.getString("Status");
                applications.add(new Application(applicationID, jobID, studentID, applicationDate, status));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return applications;
    }
}
