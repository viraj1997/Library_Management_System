package folder_person;

import java.io.Serializable;

//this class is not req to show user or not req to instantiate so we make this class as a abtract class
abstract public class person implements Serializable{
// protected access specifier use because of attributes are use in onother package or folder also
	protected int pid;
	protected String name;
	protected String Email_id;
	protected String phone_no;
	protected String home_address;
	protected String dob;
	protected int age;
	
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_id() {
		return Email_id;
	}
	public void setEmail_id(String email_id) {
		Email_id = email_id;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getHome_address() {
		return home_address;
	}
	public void setHome_address(String home_address) {
		this.home_address = home_address;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public person(int pid, String name, String email_id, String phone_no, String home_address, String dob, int age) {
		super();
		this.pid=pid;
		this.name = name;
		this.Email_id = email_id;
		this.phone_no = phone_no;
		this.home_address = home_address;
		this.dob = dob;
		this.age = age;
	}
	public person() {
		super();
	}
	
	
}
