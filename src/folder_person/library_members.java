package folder_person;

public class library_members extends person {
private String job;

public String getJob() {
	return job;
}

public void setJob(String job) {
	this.job = job;
}

@Override
public String toString() {
	return "library_members [job=" + job + ", name=" + name + ", Email_id=" + Email_id + ", phone_no=" + phone_no
			+ ", home_address=" + home_address + ", dob=" + dob + ", age=" + age + "]";
}

public library_members(String name, String email_id, String phone_no, String home_address, String dob, int age,
		String job) {
	super(age, name, email_id, phone_no, home_address, dob, age);
	this.job = job;
}

public library_members() {
	super();
}


}
