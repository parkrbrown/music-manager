package ProgramControl;

import java.io.File;
import java.io.IOException;

import mp3agic.*;

public class FileController {
	private String filename;
	
    private void saveFile(String file) throws UnsupportedTagException, InvalidDataException, IOException, NotSupportedException{
    	Mp3File mp3file = new Mp3File(file);
    	mp3file.save(file);
    }
    
    private void removeTags(String file) throws UnsupportedTagException, InvalidDataException, IOException, NotSupportedException{
    	Mp3File mp3file = new Mp3File(file);
    	if (mp3file.hasId3v1Tag()) {
    	  mp3file.removeId3v1Tag();
    	}
    	if (mp3file.hasId3v2Tag()) {
    	  mp3file.removeId3v2Tag();
    	}
    	if (mp3file.hasCustomTag()) {
    	  mp3file.removeCustomTag();
    	}
    	mp3file.save(file);
    }
    
}