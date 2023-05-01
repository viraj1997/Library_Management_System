/*package folder_person;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;

import folder_books.book;



public class Person_manager {
	ObjectOutputStream oos_person=null; //use for write the object in file also known as serialization.
	ObjectInputStream ois_person=null;  //use for read the object from file also known as de-serialization.
	
	File person_file = null; //this file / object create for books // required to import file
	ArrayList<person> person_list=null;
	
	public Person_manager()
	{
		person_file = new File("person.dat");
		person_list = new ArrayList<person>();
		
		if(person_file.exists())
		{
			try {
				ois_person = new ObjectInputStream(new FileInputStream(person_file) );
				try {
					person_list = (ArrayList<person>) ois_person.readObject();
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
	
	public void addaperson(person person)
	{
		person_list.add(person);
	}
	
	public person get(int pid)
	{
		for(person person:person_list)
		{
			if (person.getPid()== pid)
				return person;
		}
		return null;
	}
	
	public void viewallperson()
	{
		for(person person:person_list)
		System.out.println(person);
	}
	
	public boolean deletePerson(int delete_pid)
	{
		ListIterator<person> person_iterator = (ListIterator<person>) person_list.iterator();
		while(person_iterator.hasNext()) 
		{
	    person person = person_iterator.next();
	    if(person.getPid() == delete_pid) {
	    	person_list.remove(person);
	    	return true;
	    }
	}
		return false;
	
	
	
}
}
*/