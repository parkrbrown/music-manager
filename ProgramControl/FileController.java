package ProgramControl;

import java.io.IOException;

import mp3agic.*;

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
	
    void saveFile(String file) throws UnsupportedTagException, InvalidDataException, IOException, NotSupportedException {
    	//Saves file to where it was before
    	//TODO
    }
    
    void findMP3s() {
    	//Derek has this; pulls the list of mp3 files in the directory
    	//TODO
    }
}