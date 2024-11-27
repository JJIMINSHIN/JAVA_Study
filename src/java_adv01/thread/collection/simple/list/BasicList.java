package java_adv01.thread.collection.simple.list;

import static java_adv01.util.ThreadUtils.sleep;

import java.util.Arrays;

public class BasicList implements SimpleList{

	private static final int DEFAULT_CAPACITY = 5;
	private Object[] elementData;
	private int size = 0;
	
	public BasicList() {
		elementData = new Object[DEFAULT_CAPACITY];
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(Object e) {
		elementData[size] =e;
		sleep(100);
		size++;
	}

	@Override
	public Object get(int index) {
		return elementData[index];
	}

	@Override
	public String toString() {
		return Arrays.toString(Arrays.copyOf(elementData, size))+
				" size = "+size+", capacity = "+elementData.length;
	}
	
	

}
