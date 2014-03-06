package ProgramControl;

import java.io.IOException;

import mp3agic.*;

public interface FileController {	
	void findTagVersion(Mp3File MP3);
	// TODO
	
    void saveFile(String file) throws UnsupportedTagException, InvalidDataException, IOException, NotSupportedException;
    
    void findMP3s();
}