package ProgramControl;

import java.io.File;

import javax.swing.filechooser.FileNameExtensionFilter;

import GUI.FileFormatSelectionWindow;
import GUI.MainMenu;
import GUI.OganizationStyleSelectionWindow;
import GUI.TagEditWindow;

public class MainController {
    MainMenu MainMenu = new MainMenu();
    OganizationStyleSelectionWindow OSSW = new OganizationStyleSelectionWindow();
    FileFormatSelectionWindow FFSW = new FileFormatSelectionWindow();
    TagEditWindow TEW = new TagEditWindow();
    
    private File selectedDirectory;
    
    public FileNameExtensionFilter FileFilter = new FileNameExtensionFilter("MP3 Music Files", "mp3");
    
    public static void main (String[] args){
    	runApp();
    }
    
    private static void runApp(){
    	// int all gui elements
    	// start program
    	// display main window
    	// wait for selections
    	
    	MainMenu MM = new MainMenu();
    	MM.setVisible(true);
    }

	public File getSelectedDirectory() {
		return selectedDirectory;
	}

	public void setSelectedDirectory(File selectedDirectory) {
		this.selectedDirectory = selectedDirectory;
	}
}