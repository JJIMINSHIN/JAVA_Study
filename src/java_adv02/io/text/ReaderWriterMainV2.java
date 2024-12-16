package java_adv02.io.text;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java_adv02.io.text.TextConst.FILE_NAME;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class ReaderWriterMainV2 {
	public static void main(String args[]) throws IOException {
		String writeString ="BCD";
		System.out.println("write String: "+writeString);

		
		//파일에 쓰기
		FileOutputStream fos = new FileOutputStream(FILE_NAME);
		OutputStreamWriter osw = new OutputStreamWriter(fos, UTF_8);
		osw.write(writeString);
		osw.close();
		
		//파일에서 읽기
		FileInputStream fis = new FileInputStream(FILE_NAME);
		InputStreamReader isr = new InputStreamReader(fis, UTF_8);
		
		StringBuilder content = new StringBuilder();
		int ch;
		while((ch =isr.read())!=-1) {
			content.append((char)ch);
		}
		isr.close();
		System.out.println("read String: "+content);
		
	}
}