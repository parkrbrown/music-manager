package ProgramControl;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Derek_TestClass {
	static String rootDirectory = "C:/Java Files/NoFiles/New folder";
	
	
	private File[] findSubDirectories(String directoryPath) {
		File root = new File(rootDirectory); // current directory

		FileFilter directoryFilter = new FileFilter() {
			public boolean accept(File file) {
				return file.isDirectory();
			}
		};

		File[] directoryList = root.listFiles(directoryFilter);
		for (File file : directoryList) {
			if (file.isDirectory()) {
				rootDirectory = file.getAbsolutePath();

				findSubDirectories(rootDirectory);
				System.out.println("Directory: " + file.getAbsolutePath());
			} 
		}
		return directoryList;
	}
	
	public void deleteEmptyFolders(){
		//TODO
		//findDirectories()
		File directory = new File(rootDirectory);
		
		//Check to make sure dir exists
		if(!directory.exists()){
			System.out.println("Directory doesn't exist: " + rootDirectory);
		}else if(directory.list().length != 0){
			System.out.println(" Directory isn't empty: " + directory.getAbsolutePath());
			directory.
			
			}else{
				directory.delete();
				System.out.println("Directory deleted: " + directory.getAbsolutePath());
			}
	
		}
		
		//check to see if dir.isEmpty()
			//if !empty ignore dir and move to the next
		//file.delete()
	



	public static void main(String[] args) throws IOException {
		Derek_TestClass test = new Derek_TestClass();
	
//		test.findSubDirectories(rootDirectory);
		test.deleteEmptyFolders();
		
	}

}
