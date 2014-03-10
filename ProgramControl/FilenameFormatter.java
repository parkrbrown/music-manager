package ProgramControl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.activation.MailcapCommandMap;

import GUI.FileFormatSelectionWindow;
import mp3agic.*;

public class FilenameFormatter extends FileController {
	
	//USING TITLE WILL ALWAYS BE A REQUIREMENT

	// default constructor
	public FilenameFormatter() {

	}
	
	public void format(){
		// TODO
		//Pulls data from the window
		//MainController.FFSW.get.....
//		String oldFilename = /*CurrentFile.getName();*/
		// take tags in order
		// rename file with tags from window with dashes in between 
		// File (or directory) with old name
//		File file = new File(oldFilename);
		
		// File (or directory) with new name
		// File file2 = new File();
		
		// Rename file (or directory)
		// boolean success = file.renameTo(file2);
		// if (!success) {
		// File was not successfully renamed
		
		
		//Derek is working here...
		
		String currentDirectory = MainController.CurrentDirectory.getAbsolutePath();
//		String saveDirectory = MainController.CurrentDirectory.getAbsolutePath();
		ArrayList<File> mp3s = findMP3s(currentDirectory);
		ArrayList<String> renameTo = MainController.FFSW.getFormatOrder();
		
		//for each song
			//rename to match getFormatOrder();
		for(int i = 0; i < mp3s.size(); i++){
			Mp3File mp3 = null;
			try {
				mp3 = new Mp3File(mp3s.get(i).getAbsolutePath());
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
			
			StringBuffer NewName = new StringBuffer();
			for(int j = 0; j < renameTo.size(); j++)
			{
				//album, artist, <year, genre,>?? song title
				if(renameTo.get(j) == "Title")
				{
					NewName.append(mp3.getId3v1Tag().getTitle());
					NewName.append(" - ");
				}
				
				else if(renameTo.get(j) == "Album")
				{
					NewName.append(mp3.getId3v1Tag().getAlbum());
					NewName.append(" - ");
				}
				
				else if(renameTo.get(j) == "Artist")
				{
					NewName.append(mp3.getId3v1Tag().getArtist());
					NewName.append(" - ");
				}
				
				else if(renameTo.get(j) == "Year")
				{
					NewName.append(mp3.getId3v1Tag().getYear());
					NewName.append(" - ");
				}
				
				else if(renameTo.get(j) == "Genre")
				{
					NewName.append(mp3.getId3v1Tag().getGenreDescription());
					NewName.append(" - ");
				}
			}
			NewName.delete((NewName.length() - 3), NewName.length());
			String NewFileName = currentDirectory + NewName.toString() + ".mp3";
			
			MainController.FileController.saveFile((new File(mp3s.get(i).getAbsolutePath())), (new File(NewFileName)), mp3);
		}
		
		
		}
		
	}
