package folder_transaction;

public class book_transaction
{
	private int isbn;
	private int perid;
    private String issuedate;
    private String returndate;
	public int getIsbn() {
		return isbn;
	}
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public int getPerid() {
		return perid;
	}
	public void setPerid(int perid) {
		this.perid = perid;
	}
	public String getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(String issuedate) {
	}
	public String getReturndate() {
		return returndate;
	}
	public void setReturndate(String returndate) {
		this.returndate = returndate;
	}
	
	public book_transaction(int isbn, int perid, String issuedate, String returndate) {
		super();
		this.isbn = isbn;
		this.perid = perid;
		this.issuedate = issuedate;
		this.returndate = returndate;
	}
	public book_transaction() { //default constructor
		super();
	}
	@Override
	public String toString() {
		return "book_transaction [isbn=" + isbn + ", perid=" + perid + ", issuedate=" + issuedate
				+ ", returndate=" + returndate + "]";
	}
	
    
    
}
