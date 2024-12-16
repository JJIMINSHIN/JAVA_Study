package java_adv02.io.buffered;

import static java_adv02.io.buffered.BufferedConst.*;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 실행 결과
File created: /temp/buffered.dat
File Size: 10 MB
Time taken: 173ms
 */
public class CreateFileV3 {
	public static void main(String args[]) throws IOException {
		FileOutputStream fos = new FileOutputStream(FILE_NAME);
		BufferedOutputStream bos = new BufferedOutputStream(fos, BUFFER_SIZE);
		long startTime = System.currentTimeMillis();
		
		for(int i=0; i<FILE_SIZE; i++) {
			bos.write(1);
		}
		
		bos.close();		
		
		long endTime = System.currentTimeMillis();
		System.out.println("File created: "+FILE_NAME);
		System.out.println("File Size: "+(FILE_SIZE/1024/1024)+" MB");
		System.out.println("Time taken: "+(endTime-startTime)+"ms");
	}
}
