package collegeRecruitmentSystem;
public class Company {
    private int companyID;
    private String companyName;
    private String industry;
    private String contactInfo;
	public Company(int i, String companyName2, String industry2, String contactInfo2) {
		// TODO Auto-generated constructor stub
		companyID=i;
		companyName=companyName2;
		industry=industry2;
		contactInfo=contactInfo2;
	}
	public Company() {
		// TODO Auto-generated constructor stub
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	
	public String toString() {
        return "Company ID: " + companyID +
               ", Company Name: " + companyName +
               ", Industry: " + industry +
               ", Contact Info: " + contactInfo;
    }

    // Getters and Setters
    
}

