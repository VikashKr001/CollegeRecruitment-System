package collegeRecruitmentSystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobPostingDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/CollegeRecruitment";
    private static final String USER = "root";
    private static final String PASSWORD = "vikash";

    public void addJobPosting(JobPosting jobPosting) {
        String sql = "INSERT INTO JobPostings (CompanyID, JobTitle, Description, Requirements, ApplicationDeadline) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, jobPosting.getCompanyID());
            stmt.setString(2, jobPosting.getJobTitle());
            stmt.setString(3, jobPosting.getDescription());
            stmt.setString(4, jobPosting.getRequirements());
            stmt.setDate(5, jobPosting.getApplicationDeadline());
            stmt.executeUpdate();
            System.out.println("Job posting added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteJobPosting(int jobID) {
        String sql = "DELETE FROM JobPostings WHERE JobID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, jobID);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Job posting deleted successfully.");
            } else {
                System.out.println("Job posting not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateJobPosting(JobPosting jobPosting) {
        String sql = "UPDATE JobPostings SET CompanyID = ?, JobTitle = ?, Description = ?, Requirements = ?, ApplicationDeadline = ? WHERE JobID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, jobPosting.getCompanyID());
            stmt.setString(2, jobPosting.getJobTitle());
            stmt.setString(3, jobPosting.getDescription());
            stmt.setString(4, jobPosting.getRequirements());
            stmt.setDate(5, jobPosting.getApplicationDeadline());
            stmt.setInt(6, jobPosting.getJobID());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Job posting updated successfully.");
            } else {
                System.out.println("Job posting not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<JobPosting> getAllJobPostings() {
        List<JobPosting> jobPostings = new ArrayList<>();
        String sql = "SELECT * FROM JobPostings";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int jobID = rs.getInt("JobID");
                int companyID = rs.getInt("CompanyID");
                String jobTitle = rs.getString("JobTitle");
                String description = rs.getString("Description");
                String requirements = rs.getString("Requirements");
                Date applicationDeadline = rs.getDate("ApplicationDeadline");
                jobPostings.add(new JobPosting(jobID, companyID, jobTitle, description, requirements, applicationDeadline));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jobPostings;
    }
}
