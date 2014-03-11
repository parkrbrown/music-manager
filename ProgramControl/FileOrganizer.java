package ProgramControl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import mp3agic.*;

public class FileOrganizer extends FileController {

	public FileOrganizer() {
		// TODO Auto-generated constructor stub
	}
	
	//Some kind of starting method
	
	public void moveFile(/*String oldPath, String newPath*/){
		// TODO move file from oldPath to newPath
		// For an individual file
		
		//or use Files.move()
	}		
	
	
	//Derek working here...
	//Get cur directory
	//scan dir for mp3s
		//if file !mp3 --- ignore directories
			//prompt user to move the file into a new folder, re-run once files are out of the folder.  give absolute path for the dir that doens't have mp3s
	//move all mp3s from sub directories to current dir
	//remove empty directories
	//create new directories IAW user preferences
		//check if folder already exists
			//if true
				//don't make dir
			//else create
	//move files that have matching id3 tags to appropriate folder
		//scan id3 field to match getFormatOrder().length
			//if (field 1 matches)
				//scan field 2;
				//if (field 2 matches)
				//add mp3 to array
		//move files in array to the created directory
	static String rootDirectory = MainController.CurrentDirectory.getAbsolutePath();
	
	public void findMp3s(){
		
	}
	
	public void moveMp3sToRootDirectory(){
		
	}
	
	public void deleteEmptyFolders(){
		
	}
	
	public void createDirectories(){
		ArrayList<String> foldersToCreate = MainController.FFSW.getFormatOrder();
		ArrayList<File> mp3s = findMP3s();
	}
	
	public void moveFromRootToNewDir(){
		
	}
	
	public void scanId3Tags(){
		
	}
	

	
	
	
	
	
	

}
