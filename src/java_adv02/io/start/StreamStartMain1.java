package java_adv02.io.start;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamStartMain1 {
	
	public static void main(String args[]) throws IOException {
		//출력
		FileOutputStream fos = new FileOutputStream("temp/hello.dat");
		fos.write(65);
		fos.write(66);
		fos.write(67);
		fos.close();
		
		//입력
		FileInputStream fis = new FileInputStream("temp/hello.dat");
		System.out.println(fis.read());
		System.out.println(fis.read());
		System.out.println(fis.read());
		System.out.println(fis.read());
		fis.close();
	}

}