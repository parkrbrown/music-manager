package ProgramControl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import mp3agic.*;

/*
 * This class combines with TagEditWindow.java. It pulls data from the user
 * clicks confirm and updates the selected tags with their choices.
 */
public class TagEditor extends FileController {
	private ArrayList<Mp3File> fileList;
	private String newArtist;
	private String newAlbum;
	private int newGenre; //Uses -1 as an equivalent for null

	public TagEditor() {
		// Auto-generated constructor stub
	}
	
	public void updateTags() {
		//VARIABLES
		
		fileList = findMP3s();
		
		if (MainController.TEW.isArtistSelected() == true) {
			newArtist = MainController.TEW.getTArtist();
		}
		else {
			newArtist = null;
		}
		
		if (MainController.TEW.isAlbumSelected() == true) {
			newAlbum = MainController.TEW.getTAlbum();
		}
		else {
			newAlbum = null;
		}
		
		if (MainController.TEW.isGenreSelected() == true) {
			newGenre = MainController.TEW.getSelectedGenre();
		}
		else {
			newGenre = -1;
		}
		
		//ACTIONS
		
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
			
			if (newGenre != -1) {
				thisTag.setGenre(newGenre);
			}
			
		}
		
		
	}

}
