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
//		ArrayList<String> FoldersToMake = FindFolders(MainController.CurrentDirectory, OrganizationOrder.get(0));
		File[] FilesInMainDir = MainController.CurrentDirectory.listFiles();
//		ArrayList<Mp3File> Mp3sBeforeRename = new ArrayList<>();
//		ArrayList<Mp3File> Mp3sAfterRename = new ArrayList<>();
		
		for(File temp : FilesInMainDir)
		{
			Mp3File tempMp3 = null;
			try
			{
				tempMp3 = new Mp3File(temp.getAbsolutePath());
			}
			catch (UnsupportedTagException e)
			{
				// TODO Auto-generated catch block
			}
			catch (InvalidDataException e)
			{
				// TODO Auto-generated catch block
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
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
			saveFile((new File(temp.getAbsolutePath())), (new File(NewLocation.toString())), tempMp3, TempName);
		}
	}
	
	private void PullFilesFromSubs()
	{
		ArrayList<File> mp3s = MainController.FileController.findMP3s(MainController.CurrentDirectory);
		for(File temp : mp3s)
		{
			StringBuffer test = new StringBuffer();
			test.append(temp.getName());
			try {
				MainController.FileController.saveFile(temp, (new File("E:\\")), (new Mp3File(temp.getAbsolutePath())), test);
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
				if(!(FilesInSub.length != 0))
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
//				// TODO Auto-generated catch block
//			}
//			catch (InvalidDataException e)
//			{
//				// TODO Auto-generated catch block
//			}
//			catch (IOException e)
//			{
//				// TODO Auto-generated catch block
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	/******************************************************************************************************************************************************
//	public void moveFile(/*String oldPath, String newPath/){
//		// TODO move file from oldPath to newPath
//		// For an individual file
//		
//		//or use Files.move()
//	}
	
	private void verifyNoMp3sFound() /* TODO throws Exception / {
		ArrayList<File> nonMp3Files = findNonMP3s();
		
		if (nonMp3Files.size() > 0) {
			System.out.println(nonMp3Files.get(0).getName() + ", make sure all files other than .mp3 are removed from this directory.");
			//throw new nonMP3FileException
		}
	}
	
	private ArrayList<File> findNonMP3s() {
		//Filter files by .mp3 extension
		FilenameFilter mp3Filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return !(name.endsWith(".mp3"));
    		}
		};

		File directory = new File(MainController.CurrentDirectory.toString());
		//Add all files in directory to an array
		File[] fileList = directory.listFiles(); 
		ArrayList<File> mp3Files = new ArrayList<File>();

    	if(fileList == null){
    		//TODO Give alert		System.out.println("Directory not found: " + directory);
    	}else if(fileList.length == 0){
    		//TODO Give alert		System.out.println("Empty directory: " + directory);
    	}else{

			//Go through all files in the fileList and add .mp3 files to the ArrayList
			for (File file : fileList){
				if (file.isFile()){
					if(mp3Filter.accept(directory,file.getName())){
						mp3Files.add(file);
					}
				//If a sub-directory is found, search for mp3s in that directory
				} else if (file.isDirectory()){
					findMP3s(MainController.CurrentDirectory.getAbsoluteFile());
				}
			}
    	}
    	return mp3Files;
    }
	
	public void moveFilesToRoot(){
		//TODO
		for(int i = 0; i < fileList.size(); i++){
			try{
				File fileToMove = new File(fileList.get(i).getAbsolutePath());
				
				if(fileToMove.renameTo(new File(rootDirectory + fileToMove.getName()))){
					System.out.println(fileToMove.getAbsolutePath() + " successfully moved.");
				}else{
					System.out.println(fileToMove.getAbsolutePath() + " move unsuccessful.");
				}
			}catch(Exception e){
				e.getMessage();
			}
		} 
	}
	
	public void deleteEmptyFolders(){
		//TODO
		//findDirectories()
		//check to see if dir.isEmpty()
			//if !empty ignore dir and move to the next
		//file.delete()
	
	}
	
	public void createDirectories(){
		ArrayList<String> foldersToCreate = MainController.FFSW.getFormatOrder();
		ArrayList<File> mp3s = findMP3s(MainController.CurrentDirectory.getAbsoluteFile());
	}
	
	public void moveFromRootToNewDir(){
		
	}
	
	public void scanId3Tags(){
		
	}
	

	
	
	
	
	
	
	******************************************************************************************************************************************************/
}
