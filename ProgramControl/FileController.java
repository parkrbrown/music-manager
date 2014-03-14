package ProgramControl;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import mp3agic.ID3v2;
import mp3agic.ID3v24Tag;
import mp3agic.Mp3File;
import mp3agic.NotSupportedException;

public class FileController {
	
	
	public Mp3File checkForTag(Mp3File mp3) {
		if(mp3.hasId3v2Tag())
		{
			return mp3;
		}
		else
		{
			mp3.removeId3v2Tag();
			mp3.removeId3v1Tag();
			mp3.removeCustomTag();
			mp3.setId3v2Tag(new ID3v24Tag());
			return mp3;
		}
	}
	
	public ID3v2 getTag(Mp3File mp3) {
		
		return mp3.getId3v2Tag();
	}
	
	//Tag Edit Method
	public void saveFile(File CurrentFile, File NewLocation, Mp3File FileToSave)
    {
    	try
		{
			Mp3File Moving = FileToSave;
			Moving.save((CurrentFile.getName()));
		}
		catch (NotSupportedException | IOException e)
		{
		}
		
		try
		{
			Files.move((Paths.get(".\\" + CurrentFile.getName())), (Paths.get(NewLocation.getAbsolutePath())), REPLACE_EXISTING);
		}
		catch (IOException e)
		{
		}
		
		String Remove = "\\" + CurrentFile.getName();
		File RemoveThis = new File("." + Remove);
		RemoveThis.delete();
    }
	
	//Rename Method
    public void saveFile(File CurrentFile, File NewLocation, Mp3File FileToSave, StringBuffer NewName)
    {
    	try
		{
			Mp3File Moving = FileToSave;
			Moving.save((NewName.toString())/* + ".mp3"*/);
		}
		catch (NotSupportedException | IOException e)
		{
		}
		
		try
		{
			Files.move((Paths.get(CurrentFile.getAbsolutePath())), (Paths.get(NewLocation.getAbsolutePath())), REPLACE_EXISTING);
		}
		catch (IOException e)
		{
		}
		
		String Remove = "\\" + NewName;
		File RemoveThis = new File("." + Remove);
		RemoveThis.delete();
    }
    
  //Organize Method
    public void saveFile(File CurrentFile, File NewLocation, Mp3File FileToSave, StringBuffer NewName, boolean trash)
    {
    	try
		{
			Mp3File Moving = FileToSave;
			Moving.save((NewName.toString()));
		}
		catch (NotSupportedException | IOException e)
		{
		}
		
		if(!(NewLocation.exists()))
		{
			NewLocation.mkdirs();
		}
		
		try
		{
			Files.move((Paths.get(CurrentFile.getAbsolutePath())), (Paths.get(NewLocation.getAbsolutePath()/* + CurrentFile.getName()*/)), REPLACE_EXISTING);
		}
		catch (IOException e)
		{
		}
		
		String Remove = "\\" + NewName;
		File RemoveThis = new File("." + Remove);
		RemoveThis.delete();
    }
    
    public ArrayList<File> findMP3s(File Directory) {
		//Filter files by .mp3 extension
		FilenameFilter mp3Filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return (name.endsWith(".mp3"));
    		}
		};

		File directory = Directory;
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
					ArrayList<File> dirFiles = findMP3s(file);
					for(File temp : dirFiles)
					{
						mp3Files.add(temp);
					}
				}
			}
    	}
    	return mp3Files;
    }
}