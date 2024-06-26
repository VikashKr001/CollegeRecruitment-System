package collegeRecruitmentSystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/CollegeRecruitment";
    private static final String USER = "root";
    private static final String PASSWORD = "vikash";

    public void addCompany(Company company) {
        String sql = "INSERT INTO Companies (CompanyName, Industry, ContactInfo) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, company.getCompanyName());
            stmt.setString(2, company.getIndustry());
            stmt.setString(3, company.getContactInfo());
            stmt.executeUpdate();
            System.out.println("Company added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCompany(int companyID) {
        String sql = "DELETE FROM Companies WHERE Companyid = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, companyID);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Company deleted successfully.");
            } else {
                System.out.println("Company not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCompany(Company company) {
        String sql = "UPDATE Companies SET CompanyName = ?, Industry = ?, ContactInfo = ? WHERE CompanyID = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, company.getCompanyName());
            stmt.setString(2, company.getIndustry());
            stmt.setString(3, company.getContactInfo());
            stmt.setInt(4, company.getCompanyID());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Company updated successfully.");
            } else {
                System.out.println("Company not found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Company> getAllCompanies() {
        List<Company> companies = new ArrayList<>();
        String sql = "SELECT * FROM Companies";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("CompanyID");
                String name = rs.getString("CompanyName");
                String industry = rs.getString("Industry");
                String contactInfo = rs.getString("ContactInfo");
                companies.add(new Company(id, name, industry, contactInfo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return companies;
    }
}
