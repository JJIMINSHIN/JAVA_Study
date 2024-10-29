package java_mid01.lang.immutable.test;

public class ImmutableMyData {

	private final int year;
	private final int month;
	private final int day;
	
	public ImmutableMyData(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}

	// 년도만 바꾸기
	public ImmutableMyData withYear(int newYear) {
		return new ImmutableMyData(newYear, month, day);
	} 

	// 월만 바꾸기
	public ImmutableMyData withMonth(int newMonth) {
		return new ImmutableMyData(year, newMonth, day);
	} 

	// 일만 바꾸기
	public ImmutableMyData withDay(int newDay) {
		return new ImmutableMyData(year, month, newDay);
	} 
	

	@Override
	public String toString() {
		return  year + "-" + month + "-" + day;
	}
}
