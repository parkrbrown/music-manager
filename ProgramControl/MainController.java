package ProgramControl;

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
    
    public FileNameExtensionFilter FileFilter = new FileNameExtensionFilter("MP3 Music Files", "mp3");
    
    public static void main (String[] args){
    	runApp();
    }
    
    private static void runApp(){
    	// start program
    	// display main window
    	// wait for selections
    }
}