package ProgramControl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import mp3agic.ID3v2;
import mp3agic.InvalidDataException;
import mp3agic.Mp3File;
import mp3agic.UnsupportedTagException;

/*
 * This class combines with TagEditWindow.java. It pulls data from the user
 * clicks confirm and updates the selected tags with their choices.
 * JAVADOCS HERE //TODO
 */
public class TagEditor extends FileController {
    private ArrayList<File> fileList;
    private ArrayList<Mp3File> mp3List;
    private String newArtist = null;
    private String newAlbum = null;
    private int newGenre = -2; //Uses -2 as an equivalent for null

    public TagEditor() {
        //No tasks for constructor
    }

    /**
     * Gets existing ID3 Tag, changes the given values, and saves the changes.
     */
    public void updateTags() {
        //VARIABLES
        fileList = findMP3s(MainController.CurrentDirectory.getAbsoluteFile()); //Builds list of files that are mp3s
        mp3List = new ArrayList<>(); //Instantiate
        //Converts fileList into a list of Mp3Files
        for (int count = 0; count < fileList.size(); count++) {
            Mp3File temp = null;
            try {
                temp = new Mp3File(fileList.get(count).getAbsolutePath());
            } catch (UnsupportedTagException e) {
            } catch (InvalidDataException e) {
            } catch (IOException e) {
            }
            mp3List.add(temp);
        }
        //Gets data from window
        if (MainController.TEW.isArtistSelected() == true) {
            newArtist = MainController.TEW.getTArtist();
        }
        if (MainController.TEW.isAlbumSelected() == true) {
            newAlbum = MainController.TEW.getTAlbum();
        }
        if (MainController.TEW.isGenreSelected() == true) {
            newGenre = MainController.TEW.getSelectedGenre();
        }

        //ACTIONS
        for (int index = 0; index < mp3List.size(); index++) {
            //Checks for tag and creates one if necessary
            Mp3File mp3Temp = checkForTag(mp3List.get(index));
            //Gets the tag from the file
            ID3v2 thisTag = getTag(mp3Temp);
            //Updates tag
            if (newArtist != null) {
                thisTag.setArtist(newArtist);
            }
            if (newAlbum != null) {
                thisTag.setAlbum(newAlbum);
            }
            if (newGenre != -2) {
                thisTag.setGenre(newGenre);
            }
            
            mp3Temp.setId3v2Tag(thisTag);
            
            //File RemoveThis = fileList.get(index);
            //RemoveThis.delete();
            
            //Saves file
            saveFile(fileList.get(index), fileList.get(index), mp3Temp);
        }
    }
}
