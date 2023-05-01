package folder_transaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
//import folder_person.student;

public class book_transaction_manager {
	ObjectOutputStream oos_book_transaction=null; //use for write the object in file also known as serialization.
	ObjectInputStream ois_book_transaction=null;
	
	File book_transaction_file = null;
	ArrayList<book_transaction> book_transaction_list=null;
	
	public book_transaction_manager()
	{
		book_transaction_file = new File("book_transaction.dat");
		book_transaction_list = new ArrayList<book_transaction>();
		
		if(book_transaction_file.exists())
		{
			try {
				ois_book_transaction = new ObjectInputStream(new FileInputStream(book_transaction_file) );
				try {
					book_transaction_list = (ArrayList<book_transaction>) ois_book_transaction.readObject();
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
	
	public boolean issueofbook(int perid,  int isbn)
	{
		int total_book_issue=0;
		for(book_transaction booktransaction: book_transaction_list) {
			if((booktransaction.getPerid() == perid) && (booktransaction.getReturndate()== null))
				total_book_issue += 1;
	    	if(total_book_issue >= 3)
			return false;
	}
	String issue_date = new SimpleDateFormat("dd-mm-yyyy").format(new Date());
	book_transaction booktransaction = new book_transaction( isbn,perid, issue_date, issue_date);
	book_transaction_list.add(booktransaction);
	return true;
}
 public boolean returnbook(int perid, int isbn)
 {
	 for(book_transaction booktransaction: book_transaction_list) {
		 if((booktransaction.getPerid() == perid)  && (booktransaction.getReturndate()!=null)&& (booktransaction.getIsbn() == isbn));
		 { String return_date =  new SimpleDateFormat("dd-mm-yyyy").format(new Date());
		 booktransaction.setReturndate(return_date);
		 return true;
		 }
	 }
	 return false;
}
 
 
 public  void showalltransaction()
 {
	 for(book_transaction booktransaction:book_transaction_list)
		 System.out.println(booktransaction);
 }
 
 public void writeToFile() {
	 try {
		oos_book_transaction = new ObjectOutputStream(new FileOutputStream(book_transaction_file));
		oos_book_transaction.writeObject(book_transaction_list);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
 }
 }
