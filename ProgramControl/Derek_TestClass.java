package ProgramControl;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;

public class Derek_TestClass {
	static String rootDirectory = "C:/Java Files";
	
	public void deleteDirectory() throws IOException{
		


		File directory = new File(rootDirectory);
		String[] dirNames = directory.list();
		
		
	}


	public static void main(String[] args) throws IOException {
		Derek_TestClass test = new Derek_TestClass();
	
		test.deleteDirectory();
		
	}

}
