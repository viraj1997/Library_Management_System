package folder_main;

import java.util.Scanner;


import folder_books.book;
import folder_books.book_manager;
import folder_exception.BookNotFoundException;
import folder_exception.StudentNotFoundException;
//import folder_person.Person_manager;
import folder_person.Student;
import folder_person.Student_manager;
import folder_person.person;
import folder_person.Student;
import folder_transaction.book_transaction_manager;

public class main {

	public static void main(String[] args) throws StudentNotFoundException {
		int choice ;
		Scanner sc = new Scanner(System.in);
		book_manager bm = new book_manager();
	//	Person_manager pm = new Person_manager();
		Student_manager sm = new Student_manager();
		book_transaction_manager btm = new book_transaction_manager();
		
		do
		{
			System.out.println("       WELCOME");
			System.out.println("ENTER 1 IF STUDENT\nENTER 2 IF LIBRARIAN\nENTER 3 IF WANT TO EXIT");
	choice = sc.nextInt();
	if(choice == 1) //if user is student
	{
		System.out.println("enter id");
		int pid = sc.nextInt();
		try {
			Student s= sm.get(pid);
			if (s == null)
				throw new StudentNotFoundException();
			int stud_choice;
			do {	
				System.out.println("ENTER 1 TO VIEW ALL BOOKS\nENTER 2 TO SEARCH BOOKS BY ISBN\nENTER 3 TO LIST BOOKS BY SUBJECTS\nENTER 4 TO ISSUE A BOOK\nENTER 5 TO RETURN A BOOK\nENTER 99 TO EXIT");
				stud_choice = sc.nextInt();
				switch(stud_choice)
				{
				case 1:
					System.out.println("All the books records are");
					bm.viewallbooks();
				break;
				case 2:
					System.out.println("Please enter ISBN no to show a book");
					int search_isbn;
					search_isbn = sc.nextInt();
					book book = bm.searchbyisbn(search_isbn);
					if(book == null)
					System.out.println("no books found with this ISBN number");
					else
						System.out.println(book);
				break;	
				case 3:
					System.out.println("Enter a subject to search");
					sc.nextLine();
					String search_subject=sc.nextLine();
					bm.listbooksbysubjectwise(search_subject);
					break;
				case 4:
					System.out.println("Enter A ISBN to issue a book");
					int issue_isbn = sc.nextInt();
					book = bm.searchbyisbn(issue_isbn);
					try {
					if(book == null)
					{
						throw new BookNotFoundException();
					}
					if(book.getAvilable_copies()>0)
					{
						if(btm.issueofbook(pid, issue_isbn)) {
							book.setAvilable_copies(book.getAvilable_copies()-1);
							System.out.println("Book has been issued");
						}
					}
					else
					{
						System.out.println("The Book Has Been Issued");
					}
					}
					catch(BookNotFoundException bnfe) {
						System.out.println(bnfe);
					}
					
					break;
				case 5:
					System.out.println("Please enter ISBN to enter a book");
					int return_isbn = sc.nextInt();
					book = bm.searchbyisbn(return_isbn);
					if(book != null) 
					{
					if(btm.returnbook(pid, return_isbn)) 
					{
						book.setAvilable_copies(book.getAvilable_copies()+1);
						System.out.println("Thank you for return");
					}
					else
						System.out.println("Could not return the book");
					}
					else
						System.out.println("Book with this ISBN does not exist");
						
					break;
				case 99:
					System.out.println("thank you");
					break;
				default:
					System.out.println("invalid choice");
				}
				//stud_choice = sc.nextInt();
				
			}
			while(stud_choice != 99);
		}
		catch(StudentNotFoundException snfe) {
			System.out.println(snfe);
		}
	} //if user is student
	else if(choice == 2)//if user is librarian
	{
		int lib_choice;
		do {
		System.out.println("       ABOUT LIBRARY MEMBERS");
		System.out.println("ENTER 11 TO VIEW ALL MEMBERS\nENTER 12 TO PRINT MEMBERS BY ID\nENTER 13 TO REGISTER A MEMBER\nENTER 14 TO UPDATE A MEMBER\nENTER 15 TO DELETE A MEMBER");
		System.out.println("");
		System.out.println("       ABOUT BOOKS");
		System.out.println("ENTER 21 TO VIEW ALL BOOKS\nENTER 22 TO PRINT BOOK BY ISBN\nENTER 23 TO ADD A NEW BOOK\nENTER 24 TO UPDATE A BOOK\nENTER 25 TO DELETE A BOOK");
		System.out.println("");
		System.out.println("       ABOUT BOOK TRANSACTION");
		System.out.println("ENTER 31 TO VIEW ALL TRANSACTION");
		System.out.println("");
		System.out.println("ENTER 99 TO EXIT");
		lib_choice = sc.nextInt();
		switch (lib_choice)
		{
		case 11:// view all members
			System.out.println("All the members record");
			sm.viewallstudent();
		break;
		case 12:	// serach a member by id
			System.out.println("enter student id to fetch members records");
			int get_pid=sc.nextInt();
			Student student= sm.get(get_pid);
			if(student == null)
			{
				System.out.println("no member found");
			}
			else
				System.out.println(student);
		break;
		case 13:// add a member
			System.out.println("enter member details to add");
			int pid ;
			String name;
			String email_id;
			String phone_no;
			String home_address;
			String dob;
			int age;
			String school_name;
			int standard;
			String language_medium;
			
			sc.nextLine();
			System.out.println("student id");
			pid = sc.nextInt();
			sc.nextLine();
			System.out.println("name");
			name = sc.nextLine();
			System.out.println("email id");
			email_id = sc.nextLine();
			System.out.println("phone no");
			phone_no = sc.nextLine();
			System.out.println("home address");
			home_address = sc.nextLine();
			System.out.println("date of birth");
			dob = sc.nextLine();
			System.out.println("age");
			age = sc.nextInt();
			sc.nextLine();
			System.out.println("school name");
			school_name = sc.nextLine();
			System.out.println("standard");
			standard = sc.nextInt();
			sc.nextLine();
			System.out.println("language medium");
			language_medium = sc.nextLine();
			
			student = new Student( pid, name, email_id, phone_no,  home_address,  dob,  age, school_name, standard, language_medium);
				sm.addastudent(student);
				System.out.println("student is added");
			break;
		case 14: // update a student
			System.out.println("enter id for update a member");
			int update_pid;
			update_pid = sc.nextInt();
			student = sm.get(update_pid);
		try {
			if(student == null)
			
				throw new StudentNotFoundException();
			
			sc.nextLine();
		
			System.out.println("name");
			name = sc.nextLine();
			System.out.println("email id");
			email_id = sc.nextLine();
			System.out.println("phone no");
			phone_no = sc.nextLine();
			System.out.println("home address");
			home_address = sc.nextLine();
			System.out.println("date of birth");
			dob = sc.nextLine();
			System.out.println("age");
			age = sc.nextInt();
			sc.nextLine();
			System.out.println("school name");
			school_name = sc.nextLine();
			System.out.println("standard");
			standard = sc.nextInt();
			sc.nextLine();
			System.out.println("language medium");
			language_medium = sc.nextLine();
			
			sm.updateStudent(update_pid, name, email_id, phone_no, home_address, dob, age, school_name, standard, language_medium);
		    System.out.println("stdent record is updated");
		}
		catch(StudentNotFoundException snfe)
		{
			System.out.println(snfe);
		}
		break;
		case 15:
			System.out.println("enter id for delete a member");
			int delete_pid;
			delete_pid = sc.nextInt();
			if(sm.deletestudent(delete_pid))
				System.out.println("member is deleted");
			else 
				System.out.println("no record found with given id");
		break;
		case 21: //view all books
			bm.viewallbooks();
			break;
		case 22: //search books by ISBN
			int search_isbn;
			System.out.println("Enter ISBN of the book to search");
			search_isbn = sc.nextInt();
			book book = bm.searchbyisbn(search_isbn);
			if(book == null)
			System.out.println("no books found with this ISBN number");
			else
				System.out.println(book);
			break;
		case 23: // add a book
			System.out.println("enter a book details to add");
			int isbn; //isbn means international standard book number.
			String book_title;
			String Auther_name;
			String publisher;
			int edition;
		    String subject;
			int avilable_copies;
			double book_price;
			
			System.out.println("isbn");
			isbn = sc.nextInt();
			sc.nextLine();
			
			System.out.println("book title");
			book_title = sc.nextLine();
			
			System.out.println("Auther name");
			Auther_name = sc.nextLine();
			
			System.out.println("publisher");
			publisher = sc.nextLine();
			
			System.out.println("edition");
			edition = sc.nextInt();
			sc.nextLine();
			
			System.out.println("subject");
			subject = sc.nextLine();
			
			System.out.println("avilable copies");
			avilable_copies = sc.nextInt();
			sc.nextLine();
			
			System.out.println("book price");
			book_price = sc.nextDouble();
			
			book = new book(isbn, book_title, Auther_name, publisher, edition, subject, avilable_copies, book_price);
			bm.addabook(book);
			System.out.println("A book record is added");
		break;
		case 24:
			System.out.println("enter ISBN NO for update a BOOK");
			int update_isbn;
			update_isbn = sc.nextInt();
			book = bm.searchbyisbn(update_isbn);
			try {
				if(book == null)
					
					throw new BookNotFoundException();
				
				sc.nextLine();
				
				System.out.println("book title");
				book_title = sc.nextLine();
				
				System.out.println("Auther name");
				Auther_name = sc.nextLine();
				
				System.out.println("publisher");
				publisher = sc.nextLine();
				
				System.out.println("edition");
				edition = sc.nextInt();
				sc.nextLine();
				
				System.out.println("subject");
				subject = sc.nextLine();
				
				System.out.println("avilable copies");
				avilable_copies = sc.nextInt();
				sc.nextLine();
				
				System.out.println("book price");
				book_price = sc.nextDouble();
				
				bm.updatebook(update_isbn, book_title, Auther_name, publisher, edition, subject, avilable_copies, book_price);
				System.out.println("book record is updated");
			}catch(BookNotFoundException bnfe)
			{
				System.out.println(bnfe);
			}
			break;
		case 25:
			System.out.println("Enter ISBN no to delete the book");
			int delete_book;
			delete_book = sc.nextInt();
			if(bm.deletebook(delete_book))
				System.out.println("book is deleted");
			else 
				System.out.println("no record found with given ISBN");
		break;
		case 31: //view all transaction
			System.out.println("All the transaction are");
			btm.showalltransaction();
		break;
		case 99:
			System.out.println("thank you");
			break;
		default:
			System.out.println("invalid choice");
		}
		}while(lib_choice != 99);
	}//if user is librarian
	
		}
		
		while(choice != 3);
		sm.writeToFile();
		bm.writeToFile();
		btm.writeToFile();
		sc.close();
	}
}
