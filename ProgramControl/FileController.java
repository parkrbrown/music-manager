package ProgramControl;

import java.io.File;
import java.io.IOException;

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
	
    void saveFile(File CurrentFile, File NewLocation) {
    	//Removes Old Files & Re-saves/Saves files to proper location
    	//TODO
    }
    
    void findMP3s() {
    	//Derek has this; pulls the list of mp3 files in the directory
    	//TODO
    }
}