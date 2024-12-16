package java_adv02.io.buffered;

import static java_adv02.io.buffered.BufferedConst.BUFFER_SIZE;
import static java_adv02.io.buffered.BufferedConst.FILE_NAME;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * 실행 결과
File created: /temp/buffered.dat
File Size: 10 MB
Time taken: 8ms
 *
 * 100MB
File created: /temp/buffered.dat
File Size: 100 MB
Time taken: 82ms
 */
public class ReadFileV2 {
	
	public static void main(String args[]) throws IOException {
		FileInputStream fis = new FileInputStream(FILE_NAME);
		long startTime = System.currentTimeMillis();
		
		byte[] buffer = new byte[BUFFER_SIZE];
		int fileSize=0;
		int size;
		while((size =fis.read(buffer))!= -1) {
			fileSize += size;
		}
		fis.close();
		long endTime = System.currentTimeMillis();
		
		System.out.println("File created: "+FILE_NAME);
		System.out.println("File Size: "+(fileSize/1024/1024)+" MB");
		System.out.println("Time taken: "+(endTime-startTime)+"ms");	}

}
