package java_adv02.io.buffered;

import static java_adv02.io.buffered.BufferedConst.*;

import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 실행 결과
File created: /temp/buffered.dat
File Size: 10 MB
Time taken: 26ms
 *
 * 100MB도 한번 해보고 싶었음
File created: /temp/buffered.dat
File Size: 100 MB
Time taken: 265ms
 */
public class CreateFileV2 {
	public static void main(String args[]) throws IOException {
		FileOutputStream fos = new FileOutputStream(FILE_NAME);
		long startTime = System.currentTimeMillis();
		
		byte[] buffer = new byte[BUFFER_SIZE];
		int bufferIndex =0;
		
		
		for(int i=0; i<FILE_SIZE; i++) {
			buffer[bufferIndex++] =1;
			
			//버퍼 가득 차면 쓰고, 버퍼 비운다.
			if(bufferIndex == BUFFER_SIZE) {
				fos.write(buffer);
				bufferIndex=0;
			}
		}
		
		// 끝 부분에 오면 버퍼가 가득차지 않고 남아있을 수 있음, 버퍼에 남은 부분 쓰기
		if(bufferIndex>0) {
			fos.write(buffer, 0, bufferIndex);
		}
		fos.close();
		
		long endTime = System.currentTimeMillis();
		System.out.println("File created: "+FILE_NAME);
		System.out.println("File Size: "+(FILE_SIZE/1024/1024)+" MB");
		System.out.println("Time taken: "+(endTime-startTime)+"ms");
	}
}
