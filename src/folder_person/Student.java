package folder_person;

public class Student extends person {
private String school_name;
private int standard;
private String language_medium;

public String getSchool_name() {
	return school_name;
}
public void setSchool_name(String school_name) {
	this.school_name = school_name;
}
public int getStandard() {
	return standard;
}
public void setStandard(int standard) {
	this.standard = standard;
}
public String getLanguage_medium() {
	return language_medium;
}
public void setLanguage_medium(String language_medium) {
	this.language_medium = language_medium;
}
@Override
public String toString() {
	return "Student [id=" + pid + ", name=" + name + ", Email_id=" + Email_id +", phone no=" + phone_no+",school name=" + school_name + ", standard=" + standard + ", language medium=" + language_medium 
			+ ", home address=" + home_address + ", dob=" + dob + ", age=" + age + "]";
}
public Student(int pid, String name, String email_id, String phone_no, String home_address, String dob, int age,
		String school_name, int standard, String language_medium) {
	super(pid, name, email_id, phone_no, home_address, dob, age);
	this.school_name = school_name;
	this.standard = standard;
	this.language_medium = language_medium;
}
public Student() {
	super();
}

}
