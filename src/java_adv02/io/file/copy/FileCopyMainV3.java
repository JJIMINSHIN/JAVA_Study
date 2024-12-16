package java_adv02.io.file.copy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileCopyMainV3 {
	public static void main(String args[]) throws IOException {
		long startTime = System.currentTimeMillis();
		Path src = Path.of("temp/copy.dat");
		Path tag = Path.of("temp/copy_new3.dat");

		Files.copy(src, tag, StandardCopyOption.REPLACE_EXISTING);

		long endTime = System.currentTimeMillis();
		System.out.println("Time taken: " + (endTime - startTime) + "ms");

	}
}
