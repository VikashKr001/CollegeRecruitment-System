package collegeRecruitmentSystem;

import java.util.Date;

public class JobPosting {
    private int jobID;
    private int companyID;
    private String jobTitle;
    private String description;
    private String requirements;
    private Date applicationDeadline;
	public JobPosting(int i, int companyID2, String jobTitle2, String description2, String requirements2,
			java.sql.Date valueOf) {
		// TODO Auto-generated constructor stub
		jobID=i;
		companyID=companyID2;
		jobTitle=jobTitle2;
		description=description2;
		requirements=requirements2;
		applicationDeadline=valueOf;
	}
	public JobPosting() {
		// TODO Auto-generated constructor stub
	}
	public int getJobID() {
		return jobID;
	}
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRequirements() {
		return requirements;
	}
	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}
	public java.sql.Date getApplicationDeadline() {
		return (java.sql.Date) applicationDeadline;
	}
	public void setApplicationDeadline(Date applicationDeadline) {
		this.applicationDeadline = applicationDeadline;
	}
	
	public String toString() {
        return "Job ID: " + jobID +
               ", Company ID: " + companyID +
               ", Job Title: " + jobTitle +
               ", Description: " + description +
               ", Requirements: " + requirements +
               ", Application Deadline: " + applicationDeadline;
    }

    // Getters and Setters
    
}

