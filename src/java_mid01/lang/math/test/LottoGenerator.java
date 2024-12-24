package java_mid01.lang.math.test;

import java.util.Random;

public class LottoGenerator {
	private final Random random = new Random();
	private int[] lottoNumbers;
	private int cnt;
	
	//로또 번호 6개 배열로 반환
	public int[] generate() {
		lottoNumbers = new int[6];
		cnt=0; //실행할때마다 새롭게
		
		while(cnt<6) {
			// 1부터 45 사이의 숫자 생성
			int num = random.nextInt(45)+1; //1부터 나와야함
			
			//중복 체크, 중복되지 않은 경우에만 배열에 추가
			if(isUnique(num)) {
				lottoNumbers[cnt] = num;
				cnt++;
			}
		}
		
		
		
		
		
		return lottoNumbers;
	}
	
	private boolean isUnique(int num) {
		for (int i = 0; i < cnt; i++) {
			if(lottoNumbers[i] == num) return false;
		}
		return true;
	}
}
