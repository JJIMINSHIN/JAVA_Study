package java_bsc.access.ex;

public class MaxCounter {
	private int cnt=0;
	private int max;
	
	public MaxCounter(int max) {
		this.max = max;
	}

	public void increment() {
		if(cnt >=max) {
			System.out.println("최대값을 초과할 수 없습니다.");
			return ;
		}
		cnt++;
	}

	public int getCount() {
		return cnt;
	}
	
}
