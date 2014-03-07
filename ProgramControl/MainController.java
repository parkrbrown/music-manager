package ProgramControl;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import GUI.FileFormatSelectionWindow;
import GUI.MainMenu;
import GUI.OrganizationStyleSelectionWindow;
import GUI.TagEditWindow;


public class MainController {
	//File Designation variables for Program
    public static File CurrentDirectory = new File("Libraries\\Music");
    public static JFileChooser FileChooser = new JFileChooser();
 /*TODO Probably need a different class for limiting files*/
    public static FileNameExtensionFilter FileFilter = new FileNameExtensionFilter("MP3 Music Files", "mp3");
    
    //GUI Windows for Program
  	public static MainMenu MainMenu = new MainMenu();
  	public static OrganizationStyleSelectionWindow OSSW = new OrganizationStyleSelectionWindow();
  	public static FileFormatSelectionWindow FFSW = new FileFormatSelectionWindow();
  	public static TagEditWindow TEW = new TagEditWindow();
  	public static JFrame ReferenceFrame = new JFrame();
    
    
	//TODO
	
	
	
    public static void main (String[] args) {
    	MainMenu.setVisible(true);
    }
}