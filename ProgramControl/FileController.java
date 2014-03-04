package ProgramControl;

import java.io.File;
import java.io.IOException;

import mp3agic.*;

public interface FileController {
	
	void updateDirectory(String directory);
		//Or file
	
	void findTagVersion();
	// TODO
	
    void saveFile(String file) throws UnsupportedTagException, InvalidDataException, IOException, NotSupportedException;
    
    void removeTags(String file) throws UnsupportedTagException, InvalidDataException, IOException, NotSupportedException;
    
}