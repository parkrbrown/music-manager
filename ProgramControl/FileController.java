package ProgramControl;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import mp3agic.ID3v1Tag;
import mp3agic.InvalidDataException;
import mp3agic.Mp3File;
import mp3agic.NotSupportedException;
import mp3agic.UnsupportedTagException;

public class FileController {	
	void checkForTag(Mp3File mp3) {
		//Checks for a v1 tag and creates a new one if none is found
		// TODO
	}
	
	ID3v1Tag getTag(Mp3File mp3) {
		//returns actual ID3v1 tag
		return null;
		//TODO
	}
	
    void saveFile(File CurrentFile, File NewLocation, Mp3File FileToSave)
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
    
    void findMP3s() {
    	//Derek has this; pulls the list of mp3 files in the directory
    	//TODO
    }
}