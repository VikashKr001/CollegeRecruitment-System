package collegeRecruitmentSystem;

public class Student {
    private int studentID;
    private String name;
    private String email;
    private String major;
    private int graduationYear;
    private String resume;

    public Student() {
    }

    public Student(int studentID, String name, String email, String major, int graduationYear, String resume) {
        this.studentID = studentID;
        this.name = name;
        this.email = email;
        this.major = major;
        this.graduationYear = graduationYear;
        this.resume = resume;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public void setGraduationYear(int graduationYear) {
        this.graduationYear = graduationYear;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "Student No: 1.\n [" +
                "studentID=" + studentID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", major='" + major + '\'' +
                ", graduationYear=" + graduationYear +
                ", resume='" + resume + '\'' +
                ']';
    }
}
