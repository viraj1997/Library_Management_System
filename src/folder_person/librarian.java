package folder_person;

public class librarian extends person {
private int id;
private String doj; // date of joining
private double sal;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDoj() {
	return doj;
}
public void setDoj(String doj) {
	this.doj = doj;
}
public double getSal() {
	return sal;
}
public void setSal(double sal) {
	this.sal = sal;
}
@Override
public String toString() {
	return "librarian [id=" + id + ", doj=" + doj + ", sal=" + sal + ", name=" + name + ", Email_id=" + Email_id
			+ ", phone_no=" + phone_no + ", home_address=" + home_address + ", dob=" + dob + ", age=" + age + "]";
}
public librarian(String name, String email_id, String phone_no, String home_address, String dob, int age, int id,
		String doj, double sal) {
	super(id, name, email_id, phone_no, home_address, dob, age);
	this.id = id;
	this.doj = doj;
	this.sal = sal;
}
public librarian() {
	super();
}


}
