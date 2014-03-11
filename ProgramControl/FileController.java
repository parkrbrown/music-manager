package ProgramControl;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import mp3agic.ID3v1Tag;
import mp3agic.InvalidDataException;
import mp3agic.Mp3File;
import mp3agic.NotSupportedException;
import mp3agic.UnsupportedTagException;

public class FileController {
	
	
	public Mp3File checkForTag(Mp3File mp3) {
		if(mp3.hasId3v1Tag())
		{
			return mp3;
		}
		else
		{
			mp3.setId3v1Tag(new ID3v1Tag());
			return mp3;
		}
	}
	
	public ID3v1Tag getTag(Mp3File mp3) {
		return (ID3v1Tag) mp3.getId3v1Tag();
	}
	
    public void saveFile(File CurrentFile, File NewLocation, Mp3File FileToSave)
    {
    	try
		{
			Mp3File Moving = new Mp3File(CurrentFile.getAbsolutePath());
			Moving.save(Moving.getFilename());
		}
		catch (NotSupportedException | IOException | UnsupportedTagException | InvalidDataException e)
		{
			// TODO
		}
		
		if(!(NewLocation.exists()))
		{
			NewLocation.mkdirs();
		}
		
		try
		{
			Files.move((Paths.get(CurrentFile.getAbsolutePath())), (Paths.get(NewLocation.getAbsolutePath())), REPLACE_EXISTING);
		}
		catch (IOException e)
		{
			// TODO
		}
    }
    
    public ArrayList<File> findMP3s() {
		//Filter files by .mp3 extension
		FilenameFilter mp3Filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return (name.endsWith(".mp3"));
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
}