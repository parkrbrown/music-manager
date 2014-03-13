package ProgramControl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import mp3agic.InvalidDataException;
import mp3agic.Mp3File;
import mp3agic.UnsupportedTagException;

/*
 * DESCRIPTION AND JAVADOCS TODO
 */
public class FilenameFormatter extends FileController {
	public FilenameFormatter() {
		//No tasks for Constructor
	}
	
	/*
	 * Renames the mp3 filename according to user preferences
	 */
	public void format() {
		ArrayList<File> mp3s = findMP3s(MainController.CurrentDirectory);
		ArrayList<String> renameTo = MainController.FFSW.getFormatOrder();
		
		for (int i = 0; i < mp3s.size(); i++) {
			Mp3File mp3 = null;
			try {
				mp3 = new Mp3File(mp3s.get(i).getAbsolutePath());
			} catch (UnsupportedTagException exception) {
			} catch (InvalidDataException exception) {
			} catch (IOException exception) {
			}
			
			StringBuffer NewName = new StringBuffer();
			for (int j = 0; j < renameTo.size(); j++) {
				if (renameTo.get(j).equals("Title")) {
					if (!((mp3.getId3v2Tag().getTitle()) == null)) {
						NewName.append(mp3.getId3v2Tag().getTitle());
						NewName.append(" - ");
					}
					else {
						NewName.append("[No Title Found]");
						NewName.append(" - ");
					}
				}
				else if (renameTo.get(j).equals("Album")) {
					if (!((mp3.getId3v2Tag().getAlbum()) == null)) {
						NewName.append(mp3.getId3v2Tag().getAlbum());
						NewName.append(" - ");
					}
					else {
						NewName.append("[No Album Found]");
						NewName.append(" - ");
					}
				}
				else if (renameTo.get(j).equals("Artist")) {
					if (!((mp3.getId3v2Tag().getArtist()) == null)) {
						NewName.append(mp3.getId3v2Tag().getArtist());
						NewName.append(" - ");
					}
					else {
						NewName.append("[No Artist Found]");
						NewName.append(" - ");
					}
				}
				else if (renameTo.get(j).equals("Year")) {
					if (!((mp3.getId3v2Tag().getYear()) == null)) {
						NewName.append(mp3.getId3v2Tag().getYear());
						NewName.append(" - ");
					}
					else {
						NewName.append("[No Year Found]");
						NewName.append(" - ");
					}
				}
				else if (renameTo.get(j).equals("Genre")) {
					if (!((mp3.getId3v2Tag().getGenreDescription()) == null)) {
						NewName.append(mp3.getId3v2Tag().getGenreDescription());
						NewName.append(" - ");
					}
					else {
						NewName.append("[No Genre Found]");
						NewName.append(" - ");
					}
				}
			}
			NewName.delete((NewName.length() - 3), NewName.length());
			String NewFileName = MainController.CurrentDirectory + "\\" + (NewName.toString()) + ".mp3";
			
			MainController.FileController.saveFile((new File(mp3s.get(i).getAbsolutePath())), (new File(NewFileName)), mp3, NewName);
		}
	}
}