package ProgramControl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import mp3agic.*;

public class TagEditor extends FileController {
	private ArrayList<Mp3File> fileList;
	String newArtist;
	String newAlbum;
	String newGenre;

	public TagEditor() {
		// TODO Auto-generated constructor stub
	}
	
	public void updateTags() {
		//VARIABLES
		
		fileList = findMP3s();
		
		if (MainController.TEW.newArtist() == true) {
			newArtist = MainController.TEW.getNewArtist();
		}
		else {
			newArtist = null;
		}
		
		if (MainController.TEW.newAlbum() == true) {
			newAlbum = MainController.TEW.getNewAlbum();
		}
		else {
			newAlbum = null;
		}
		
		if (MainController.TEW.newGenre() == true) {
			newGenre = MainController.TEW.getNewGenre();
		}
		else {
			newGenre = null;
		}
		
		
		for (int index = 0; index < fileList.size(); index++) {
			//Checks for tag and creates one if necessary
			checkForTag(fileList.get(index));
			//Gets the tag from the file
			ID3v1Tag thisTag = getTag(fileList.get(index));
			
			if (newArtist != null) {
				thisTag.setArtist(newArtist);
			}
			
			if (newAlbum != null) {
				thisTag.setAlbum(newAlbum);
			}
			
			if (newGenre != null) {
				thisTag.setGenre(newGenre);
			}
			
		}
		
		
	}

}
