package java_mid02.generic.ex1;

public class GenericBox<T> {
	
	private T value;
	
	public void set(T value) {
		this.value = value;
	}
	
	public T get() {
		return value;
	}

}
