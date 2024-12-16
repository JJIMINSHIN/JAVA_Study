package java_adv02.io.buffered;

import static java_adv02.io.buffered.BufferedConst.BUFFER_SIZE;
import static java_adv02.io.buffered.BufferedConst.FILE_NAME;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/*
 * 실행 결과
File created: /temp/buffered.dat
File Size: 10 MB
Time taken: 169ms
 */
public class ReadFileV3 {
	
	public static void main(String args[]) throws IOException {
		FileInputStream fis = new FileInputStream(FILE_NAME);
		BufferedInputStream bis = new BufferedInputStream(fis, BUFFER_SIZE);
		
		long startTime = System.currentTimeMillis();
		
		int fileSize=0;
		int data;
		while((data =bis.read())!= -1) {
			fileSize++;
		}
		bis.close();
		long endTime = System.currentTimeMillis();
		
		System.out.println("File created: "+FILE_NAME);
		System.out.println("File Size: "+(fileSize/1024/1024)+" MB");
		System.out.println("Time taken: "+(endTime-startTime)+"ms");	}

}
