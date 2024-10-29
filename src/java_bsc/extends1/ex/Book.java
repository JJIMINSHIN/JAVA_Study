package java_bsc.extends1.ex;

/*
 * 이클립스 생성자 단축키
 * alt+shift+s 
 * => generate constructor using field
 * => 오버라이드
 * */ 
public class Book extends Item {
	
	private String author;
	private String isbn;
	
	public Book(String name, int price, String author, String isbn) {
		super(name, price);
		this.author = author;
		this.isbn = isbn;
	}
	

	@Override
	public void print() {
		System.out.println(" - 저자 : "+author+", isbn : "+isbn);
	}
	
}
