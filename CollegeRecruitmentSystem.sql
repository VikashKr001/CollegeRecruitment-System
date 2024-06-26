-- Create the database
CREATE DATABASE CollegeRecruitment;

-- Use the database
USE CollegeRecruitment;

-- Create Companies table
CREATE TABLE Companies (
    CompanyID INT AUTO_INCREMENT PRIMARY KEY,
    CompanyName VARCHAR(100) NOT NULL,
    Industry VARCHAR(100),
    ContactInfo VARCHAR(255)
);

-- Create JobPostings table
CREATE TABLE JobPostings (
    JobID INT AUTO_INCREMENT PRIMARY KEY,
    CompanyID INT,
    JobTitle VARCHAR(100) NOT NULL,
    Description TEXT,
    Requirements TEXT,
    ApplicationDeadline DATE,
    FOREIGN KEY (CompanyID) REFERENCES Companies(CompanyID)
);

-- Create Students table
CREATE TABLE Students (
    StudentID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE NOT NULL,
    Major VARCHAR(100),
    GraduationYear INT,
    Resume TEXT
);

-- Create Applications table
CREATE TABLE Applications (
    ApplicationID INT AUTO_INCREMENT PRIMARY KEY,
    JobID INT,
    StudentID INT,
    ApplicationDate DATE,
    Status VARCHAR(50),
    FOREIGN KEY (JobID) REFERENCES JobPostings(JobID),
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID)
);
