package java_adv02.io.streams;

import java.io.*;

public class PrintStreamEtcMain {

	public static void main(String args[]) throws IOException {
		FileOutputStream fos = new FileOutputStream("temp/print.txt");
		PrintStream printStream = new PrintStream(fos);
		
		printStream.println("hellow java!");
		printStream.println(10);
		printStream.println(true);
		printStream.printf("hello %s","world");
		printStream.close();
	}
}
