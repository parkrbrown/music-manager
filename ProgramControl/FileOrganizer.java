package ProgramControl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import mp3agic.ID3v2;
import mp3agic.InvalidDataException;
import mp3agic.Mp3File;
import mp3agic.UnsupportedTagException;


public class FileOrganizer extends FileController {	
	public FileOrganizer() {
		// No tasks for constructor
	}
	
	//Starting Method
	public void Organize()
	{
		//"Album", "Artist", "Genre", "Year"
		PullFilesFromSubs();
		DeleteSubs(MainController.CurrentDirectory);
		ArrayList<String> OrganizationOrder = MainController.OSSW.getOrganizationOrder();
		File[] FilesInMainDir = MainController.CurrentDirectory.listFiles();
		ArrayList<File> MP3sInMainDir = new ArrayList<>();
		
		for(File curFile : FilesInMainDir)
		{
			if(curFile.isFile())
			{
				MP3sInMainDir.add(curFile);
			}
			else
			{
				ArrayList<File> FoundFiles = new ArrayList<>();
				FoundFiles = findMP3s(curFile.getAbsoluteFile());
				for(File cur : FoundFiles)
				{
					MP3sInMainDir.add(cur);
				}
			}
		}
		
		for(File temp : MP3sInMainDir)
		{
			Mp3File tempMp3 = null;
			try
			{
				tempMp3 = new Mp3File(temp.getAbsolutePath());
			}
			catch (UnsupportedTagException e)
			{
			}
			catch (InvalidDataException e)
			{
			}
			catch (IOException e)
			{
			}
			
			ID3v2 CurTag = tempMp3.getId3v2Tag();
			StringBuffer NewName = new StringBuffer();
			for(int k = 0; k < OrganizationOrder.size(); k++)
			{
				if(OrganizationOrder.get(k).equals("Genre"))
				{
					NewName.append("\\" + CurTag.getGenreDescription());
				}
				else if(OrganizationOrder.get(k).equals("Artist"))
				{
					NewName.append("\\" + CurTag.getArtist());
				}
				else if(OrganizationOrder.get(k).equals("Album"))
				{
					NewName.append("\\" + CurTag.getAlbum());
				}
				else if(OrganizationOrder.get(k).equals("Year"))
				{
					NewName.append("\\" + CurTag.getYear());
				}
			}
			NewName.append("\\" + temp.getName());
			StringBuffer NewLocation = new StringBuffer();
			NewLocation.append(MainController.CurrentDirectory);
			if(NewLocation.charAt((NewLocation.length() - 1)) == '\\')
			{
				NewLocation.deleteCharAt((NewLocation.length() - 1));
			}
			NewLocation.append(NewName.toString());
			StringBuffer TempName = new StringBuffer();
			TempName.append(temp.getName());
			saveFile((new File(temp.getAbsolutePath())), (new File(NewLocation.toString())), tempMp3, TempName, true);
		}
	}
	
	private void PullFilesFromSubs()
	{
		ArrayList<File> mp3s = findMP3s(MainController.CurrentDirectory);
		for(File temp : mp3s)
		{
			StringBuffer test = new StringBuffer();
			test.append(temp.getName());
			try {
				saveFile((new File(temp.getAbsolutePath())), (new File(MainController.CurrentDirectory.getAbsolutePath())), (new Mp3File(temp.getAbsolutePath())), test);
			} catch (UnsupportedTagException e) {
			} catch (InvalidDataException e) {
			} catch (IOException e) {
			}
		}
	}
	
	private void DeleteSubs(File Directory)
	{
		File[] Files = Directory.listFiles();
		for(File CurFile : Files)
		{
			if(CurFile.isDirectory())
			{
				File[] FilesInSub = CurFile.listFiles();
				if(!(FilesInSub.length != 0))//TODO
				{
					for(File temp : FilesInSub)
					{
						DeleteSubs(temp);
					}
					CurFile.delete();
				}
				else
				{
					CurFile.delete();
				}
			}
		}
	}
	
//	private ArrayList<String> FindFolders(File Directory, String OrderBy)
//	{
//		File[] MP3s = Directory.listFiles();
//		int CurrentOrganizer = -1;
//		if(OrderBy.equals("Genre"))
//		{
//			CurrentOrganizer = 0;
//		}
//		else if(OrderBy.equals("Artist"))
//		{
//			CurrentOrganizer = 1;
//		}
//		else if(OrderBy.equals("Album"))
//		{
//			CurrentOrganizer = 2;
//		}
//		else if(OrderBy.equals("Year"))
//		{
//			CurrentOrganizer = 3;
//		}
//		
//		ArrayList<String> FoldersToMake = new ArrayList<>();
//		for(File Temp : MP3s)
//		{
//			Mp3File TempMp3 = null;
//			try
//			{
//				TempMp3 = new Mp3File(Temp.getAbsolutePath());
//			}
//			catch (UnsupportedTagException e)
//			{
//			}
//			catch (InvalidDataException e)
//			{
//			}
//			catch (IOException e)
//			{
//			}
//			
//			boolean InList = false;
//			for(int i = 0; i < FoldersToMake.size(); i++)
//			{
//				if(CurrentOrganizer == 0)
//				{
//					if(TempMp3.getId3v2Tag().getGenreDescription().equals(FoldersToMake.get(i)))
//					{
//						InList = true;
//					}
//				}
//				else if(CurrentOrganizer == 1)
//				{
//					if(TempMp3.getId3v2Tag().getArtist().equals(FoldersToMake.get(i)))
//					{
//						InList = true;
//					}
//				}
//				else if(CurrentOrganizer == 2)
//				{
//					if(TempMp3.getId3v2Tag().getAlbum().equals(FoldersToMake.get(i)))
//					{
//						InList = true;
//					}
//				}
//				else if(CurrentOrganizer == 3)
//				{
//					if(TempMp3.getId3v2Tag().getYear().equals(FoldersToMake.get(i)))
//					{
//						InList = true;
//					}
//				}
//			}
//			
//			if(!InList)
//			{
//				if(CurrentOrganizer == 0)
//				{
//					FoldersToMake.add(TempMp3.getId3v2Tag().getGenreDescription());
//				}
//				else if(CurrentOrganizer == 1)
//				{
//					FoldersToMake.add(TempMp3.getId3v2Tag().getArtist());
//				}
//				else if(CurrentOrganizer == 2)
//				{
//					FoldersToMake.add(TempMp3.getId3v2Tag().getAlbum());
//				}
//				else if(CurrentOrganizer == 3)
//				{
//					FoldersToMake.add(TempMp3.getId3v2Tag().getYear());
//				}
//			}
//		}
//		return FoldersToMake;
//	}
}
