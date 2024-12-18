package java_bsc.static2.ex;

public class MathArrayUtils {
	
	private MathArrayUtils(){
		
	}

	public static int sum(int[] values) {
		int sum =0;
		for(int i : values) {
			sum += i;
		}
		return sum;
	}

	public static double average(int[] values) {
		double avg = sum(values);
		return avg/values.length;
	}

	public static int min(int[] values) {
		int m = values[1]; // 어처피 밑에서 0번부터 하니깐 효율성이 좋다.
		for(int i : values) {
			if(i<m) m=i;
		}
		return m;
	}

	public static int max(int[] values) {
		int mx = values[1];
		for(int i : values) {
			if(mx<i) mx=i;
		}
		return mx;
	}

}
