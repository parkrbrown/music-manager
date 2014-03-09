package ProgramControl;

import java.io.File;
import java.io.IOException;

import mp3agic.*;

public class FilenameFormatter extends FileController {
	
	//USING TITLE WILL ALWAYS BE A REQUIREMENT

	// default constructor
	public FilenameFormatter() {

	}
	
	public void format(){
		// TODO
		//Pulls data from the window
		//MainController.FFSW.get.....
		String oldFilename = /*CurrentFile.getName();*/
		// take tags in order
		// rename file with tags from window with dashes in between
		// File (or directory) with old name
		File file = new File(oldFilename);
		
		// File (or directory) with new name
		// File file2 = new File();
		
		// Rename file (or directory)
		// boolean success = file.renameTo(file2);
		// if (!success) {
		// File was not successfully renamed
		}
		
	}
