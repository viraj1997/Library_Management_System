package folder_person;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;

public class Student_manager {
	ObjectOutputStream oos_student=null; //use for write the object in file also known as serialization.
	ObjectInputStream ois_student=null;
	
	File student_file = null;
	ArrayList<Student> student_list=null;
	
	@SuppressWarnings("unchecked")
	public Student_manager()
	{
		student_file = new File("Student.dat");
		student_list = new ArrayList<Student>();
		
		if(student_file.exists())
		{
			try {
				ois_student = new ObjectInputStream(new FileInputStream(student_file) );
				try {
					student_list = (ArrayList<Student>) ois_student.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void addastudent(Student student)
	{
		student_list.add(student);
	}
	
	public Student get(int pid)
	{
		for(Student student:student_list)
		{
			if (student.getPid()== pid)
				return student;
		}
		return null;
	}
	
	public void viewallstudent()
	{
		for(Student student:student_list)
		System.out.println(student);
	}
	
	public boolean deletestudent(int delete_pid)
	{
		ListIterator<Student> student_iterator = (ListIterator<Student>) student_list.listIterator();
		while(student_iterator.hasNext()) 
		{
	    Student student = student_iterator.next();
	    if(student.getPid() == delete_pid) {
	    	student_list.remove(student);
	    	return true;
	    }
	}
		return false;
}
	public boolean updateStudent(int update_pid, String name, String email_id, String phone_no, String home_address, String dob, int age,String school_name, int standard, String language_medium) 
	 {
		ListIterator<Student> student_iterator = (ListIterator<Student>) student_list.listIterator();
		while(student_iterator.hasNext()) 
		{
	    Student student = student_iterator.next();
	    if(student.getPid() == update_pid) {
	    	student.setName(name);
	    	student.setEmail_id(email_id);
	    	student.setPhone_no(phone_no);
	    	student.setHome_address(home_address);
	    	student.setAge(age);
	    	student.setSchool_name(school_name);
	    	student.setStandard(standard);
	    	student.setLanguage_medium(language_medium);
	    	return true;
	    }
		}
		return false;
	 }
	
	public void writeToFile()
	{
		try {
			oos_student = new ObjectOutputStream(new FileOutputStream(student_file));
			oos_student.writeObject(student_list);
		}
		catch(IOException IOE) {
			IOE.printStackTrace();
		}
	}
	
	
}
