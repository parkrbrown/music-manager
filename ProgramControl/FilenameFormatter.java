package ProgramControl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import mp3agic.InvalidDataException;
import mp3agic.Mp3File;
import mp3agic.UnsupportedTagException;



public class FilenameFormatter extends FileController {
	public FilenameFormatter() {

	}
	
	//Renames the mp3 filename according to user preferences
	public void format(){
		String currentDirectory = MainController.CurrentDirectory.getAbsolutePath();
		ArrayList<File> mp3s = findMP3s();
		ArrayList<String> renameTo = MainController.FFSW.getFormatOrder();
		
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