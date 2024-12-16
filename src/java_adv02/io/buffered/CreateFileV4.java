package java_adv02.io.buffered;

import static java_adv02.io.buffered.BufferedConst.*;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 실행 결과
File created: /temp/buffered.dat
File Size: 10 MB
Time taken: 19ms
 */
public class CreateFileV4 {
	public static void main(String args[]) throws IOException {
		FileOutputStream fos = new FileOutputStream(FILE_NAME);
		long startTime = System.currentTimeMillis();

		byte[] buffer = new byte[FILE_SIZE];
		for(int i=0; i<FILE_SIZE; i++) {
			buffer[i] = 1;
		}
		fos.write(buffer);
		fos.close();
		
		long endTime = System.currentTimeMillis();
		System.out.println("File created: "+FILE_NAME);
		System.out.println("File Size: "+(FILE_SIZE/1024/1024)+" MB");
		System.out.println("Time taken: "+(endTime-startTime)+"ms");
	}
}
