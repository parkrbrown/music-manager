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
	private ArrayList<File> fileList;
	private ArrayList<Mp3File> mp3List;
	private String newArtist = null;
	private String newAlbum = null;
	private int newGenre = -2; //Uses -2 as an equivalent for null

	public TagEditor() {
		// Auto-generated constructor stub
	}
	
	public void updateTags() {
		//VARIABLES
		
		fileList = findMP3s();
		
		for (int count = 0; count < fileList.size(); count++) {
			Mp3File temp = null;
			try {
				temp = new Mp3File(fileList.get(count).getAbsolutePath());
			} catch (UnsupportedTagException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			mp3List.add(temp);
		}
		
		
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
			newGenre = -2;
		}
		
		//ACTIONS
		
		for (int index = 0; index < mp3List.size(); index++) {
			//Checks for tag and creates one if necessary
			checkForTag(mp3List.get(index));
			//Gets the tag from the file
			ID3v1Tag thisTag = getTag(mp3List.get(index));
			
			if (newArtist != null) {
				thisTag.setArtist(newArtist);
			}
			
			if (newAlbum != null) {
				thisTag.setAlbum(newAlbum);
			}
			
			if (newGenre != -2) {
				thisTag.setGenre(newGenre);
			}
			
		}
		
		
	}

}
