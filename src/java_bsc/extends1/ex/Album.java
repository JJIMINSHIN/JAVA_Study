package java_bsc.extends1.ex;

public class Album extends Item {
	private String artist;

	public Album(String name, int price, String author) {
		super(name, price);
		this.artist = author;
	}

	@Override
	public void print() {
		super.print();
		System.out.println(" - 아티스트 : "+artist);

	}
	

}
