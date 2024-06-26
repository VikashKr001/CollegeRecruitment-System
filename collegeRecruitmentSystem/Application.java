package collegeRecruitmentSystem;

import java.sql.Date;

public class Application {
    private int applicationID;
    private int jobID;
    private int studentID;
    private Date applicationDate;
    private String status;

    public Application() {
    }

    public Application(int applicationID, int jobID, int studentID, Date applicationDate, String status) {
        this.applicationID = applicationID;
        this.jobID = jobID;
        this.studentID = studentID;
        this.applicationDate = applicationDate;
        this.status = status;
    }

    public int getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(int applicationID) {
        this.applicationID = applicationID;
    }

    public int getJobID() {
        return jobID;
    }

    public void setJobID(int jobID) {
        this.jobID = jobID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Application no: 1.\n{" +
                "applicationID=" + applicationID +
                ", jobID=" + jobID +
                ", studentID=" + studentID +
                ", applicationDate=" + applicationDate +
                ", status='" + status + '\'' +
                '}';
    }
}
