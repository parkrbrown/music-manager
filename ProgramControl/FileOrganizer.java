package ProgramControl;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

import mp3agic.*;

public class FileOrganizer extends FileController {
	private ArrayList<File> fileList;
	private ArrayList<File> nonMp3Files;
	
	public FileOrganizer() {
		// No tasks for constructor
	}
	
	//Starting Method
	public void organize() {
		//Derek working here...
		//Get cur directory and scan dir for mp3s
		fileList = findMP3s();
		checkForNonMP3s(); //if file !mp3 prompt user to move the file into a new folder, 
			//re-run once files are out of the folder.  give absolute path for the dir that has non-mp3s
		
		
		//move all mp3s from sub directories to current dir
		moveFilesToRoot();
		//remove empty directories
		deleteEmptyFolders();
		
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
		//static String rootDirectory = MainController.CurrentDirectory.getAbsolutePath();
		
	}
	
//	public void moveFile(/*String oldPath, String newPath*/){
//		// TODO move file from oldPath to newPath
//		// For an individual file
//		
//		//or use Files.move()
//	}
	
	private void checkForNonMP3s() /* TODO throws Exception */ {
		ArrayList<File> nonMp3Files = findNonMP3s();
		
		if (nonMp3Files.size() > 0) {
			//throw new nonMP3FileException
		}
	}
	
	private ArrayList<File> findNonMP3s() {
		//Filter files by .mp3 extension
		FilenameFilter mp3Filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return !(name.endsWith(".mp3"));
    		}
		};

		File directory = new File(MainController.CurrentDirectory.toString());
		//Add all files in directory to an array
		File[] fileList = directory.listFiles(); 
		ArrayList<File> mp3Files = new ArrayList<File>();

    	if(fileList == null){
    		//TODO Give alert		System.out.println("Directory not found: " + directory);
    	}else if(fileList.length == 0){
    		//TODO Give alert		System.out.println("Empty directory: " + directory);
    	}else{

			//Go through all files in the fileList and add .mp3 files to the ArrayList
			for (File file : fileList){
				if (file.isFile()){
					if(mp3Filter.accept(directory,file.getName())){
						mp3Files.add(file);
					}
				//If a sub-directory is found, search for mp3s in that directory
				} else if (file.isDirectory()){
					findMP3s();
				}
			}
    	}
    	return mp3Files;
    }
	
	public void moveFilesToRoot(){
		//TODO
	}
	
	public void deleteEmptyFolders(){
		//TODO
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
