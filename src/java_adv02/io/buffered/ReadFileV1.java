package java_adv02.io.buffered;

import static java_adv02.io.buffered.BufferedConst.FILE_NAME;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * 실행 결과
File created: /temp/buffered.dat
File Size: 10 MB
Time taken: 36244ms
 */
public class ReadFileV1 {
	
	public static void main(String args[]) throws IOException {
		FileInputStream fis = new FileInputStream(FILE_NAME);
		long startTime = System.currentTimeMillis();
		
		int fileSize=0;
		int data;
		while((data =fis.read())!= -1) {
			fileSize++;
		}
		fis.close();
		long endTime = System.currentTimeMillis();
		
		System.out.println("File created: "+FILE_NAME);
		System.out.println("File Size: "+(fileSize/1024/1024)+" MB");
		System.out.println("Time taken: "+(endTime-startTime)+"ms");	}

}
