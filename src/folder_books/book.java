package folder_books;

import java.io.Serializable;

public class book implements Serializable{
 private int isbn; //isbn means international standard book number.
 private String book_title; 
 private String Auther_name;
 private String publisher;
 private int edition;
 private String subject;
 private int avilable_copies;
 private double book_price;
 // here we use getter setter method
public int getIsbn() {
	return isbn;
}
public void setIsbn(int isbn) {
	this.isbn = isbn;
}
public String getBook_title() {
	return book_title;
}
public void setBook_title(String book_title) {
	this.book_title = book_title;
}
public String getAuther_name() {
	return Auther_name;
}
public void setAuther_name(String auther_name) {
	Auther_name = auther_name;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public int getEdition() {
	return edition;
}
public void setEdition(int edition) {
	this.edition = edition;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public int getAvilable_copies() {
	return avilable_copies;
}
public void setAvilable_copies(int avilable_copies) {
	this.avilable_copies = avilable_copies;
}
public double getBook_price() {
	return book_price;
}
public void setBook_price(double book_price) {
	this.book_price = book_price;
} 
 // here i generate parameterised constructor
public book(int isbn, String book_title, String auther_name, String publisher, int edition, String subject,
		int avilable_copies, double book_price) {
	super();
	this.isbn = isbn;
	this.book_title = book_title;
	this.Auther_name = auther_name;
	this.publisher = publisher;
	this.edition = edition;
	this.subject = subject;
	this.avilable_copies = avilable_copies;
	this.book_price = book_price;
}
//here i generate default constructor
public book() {
	super();
}
// override tostring method
@Override
public String toString() {
	return "book [isbn=" + isbn + ", book_title=" + book_title + ", Auther_name=" + Auther_name + ", publisher="
			+ publisher + ", edition=" + edition + ", subject=" + subject + ", avilable_copies=" + avilable_copies
			+ ", book_price=" + book_price + "]";
}

}
