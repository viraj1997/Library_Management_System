package folder_books;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ListIterator;

public class book_manager {
ObjectOutputStream oos_book=null; //use for write the object in file also known as serialization.
ObjectInputStream ois_book=null;  //use for read the object from file also known as de-serialization.

File book_file = new File ("books.dat"); //this file / object create for books // required to import file
ArrayList<book> book_list=null; // here i used arraylist for book name of the arraylist is book

@SuppressWarnings("unchecked")
public book_manager(){     //here i create one constructor for book manager class for intitialize book_list
	book_list = new ArrayList<book>();
	if(book_file.exists())  // here i check the books are present inside book_file or not
	{
				try {
					// here i read the object from file i.e. performing deserialization
					ois_book = new ObjectInputStream (new FileInputStream(book_file));
					book_list= (ArrayList<book>) ois_book.readObject(); // to show books read the arraylist and assign in book_list
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
public void listbooksbysubjectwise(String subject)
{
	for(book book : book_list) {
		if(book.getSubject().equals(subject))
			System.out.println(book);
	}
}
public void addabook (book book) // to add book one method is created addabook
{
	book_list.add(book); // add method use in arraylist
}
public void viewallbooks()  // to read all books create viewallbooks method
{
	for(book book:book_list) // using for-each loop
		System.out.println(book);
}
public book searchbyisbn(int search_isbn) // if book is search by isbn no here parameter as a isbn no
{
	for(book book:book_list) {   // for each loop for iteration
		if(book.getIsbn() == search_isbn) // here we compare the isbn no if isbn no is same then return a book
			return book;
	}
	return null; //if book is not found then return null
}

public boolean deletebook(int delete_isbn) // for delete the book boolean method it will return yes or no
{
	ListIterator<book> book_iterator = (ListIterator<book>) book_list.listIterator(); // here iterator method is use to iterate books
	while(book_iterator.hasNext()) { // here check a book is present or not hasnext method is check the book is present or not
		book book = book_iterator.next(); // here get the book using next method
		if(book.getIsbn() == delete_isbn) // here we check the isbn no if yes then remove the book from book lis
		{
		book_list.remove(book);	
		return true; //yes delete
		}
	}
	return false;// not deleted	
}

public boolean updatebook(int update_isbn, String book_title, String auther_name, String publisher, int edition, String subject,
		int avilable_copies, double book_price) // for delete the book boolean method it will return yes or no
{
	ListIterator<book> book_iterator = (ListIterator<book>) book_list.listIterator(); // here iterator method is use to iterate books
	while(book_iterator.hasNext()) { // here check a book is present or not hasnext method is check the book is present or not
		book book = book_iterator.next(); // here get the book using next method
		if(book.getIsbn() == update_isbn) // here we check the isbn no if yes then remove the book from book lis
		{
		book.setAuther_name(auther_name);
		book.setAvilable_copies(avilable_copies);
		book.setEdition(edition);
		book.setPublisher(publisher);
		book.setSubject(subject);
		book.setBook_title(book_title);
		
		return true; //yes delete
		}
		
	}
	return false;// not deleted	
}

public void writeToFile()
{
	try {
		oos_book = new ObjectOutputStream(new FileOutputStream(book_file));
		oos_book.writeObject(book_list);
	}
	catch(IOException IOE) {
		IOE.printStackTrace();
	}
}

}

