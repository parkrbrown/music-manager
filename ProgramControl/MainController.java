package ProgramControl;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import GUI.FileFormatSelectionWindow;
import GUI.MainMenu;
import GUI.OganizationStyleSelectionWindow;
import GUI.TagEditWindow;


public class MainController {
	//GUI Windows for Program
	public static MainMenu MainMenu = new MainMenu();
	public static OganizationStyleSelectionWindow OSSW = new OganizationStyleSelectionWindow();
	public static FileFormatSelectionWindow FFSW = new FileFormatSelectionWindow();
	public static TagEditWindow TEW = new TagEditWindow();
	public static JFrame ReferenceFrame = new JFrame();
    
	//File Designation variables for Program
    public static File CurrentDirectory;
    public static JFileChooser FileChooser = new JFileChooser();
 /*TODO Probably need a different class for limiting files*/
    public static FileNameExtensionFilter FileFilter = new FileNameExtensionFilter("MP3 Music Files", "mp3");
    
    
	//TODO
	
	
	
    public static void main (String[] args) {
    	MainMenu.setVisible(true);
    }
}