package java_mid01.lang.immutable.address;

public class ImmutableObj {

	private final int value;

	public ImmutableObj(int value) {
		this.value = value;
	}
	
	public ImmutableObj add(int addValue) {
		/* inline Variable
		int res = value + addValue;
		return new ImmutableObj(res);
		*/
		return new ImmutableObj(value+addValue);
	}

	public int getValue() {
		return value;
	}
	
	
}
